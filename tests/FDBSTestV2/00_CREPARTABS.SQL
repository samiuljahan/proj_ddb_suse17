set echo on;

alter session set nls_language = english;
alter session set nls_date_format = 'DD-MON-YYYY';
alter session set nls_date_language = english;
--2.2 CREATE TABLE
--	1.4.1	☐Keywords and identifiers (names of tables and their attributes) may be written in capital or small letters or a mix of those. 
--	2.2.2 constraint of types UNIQUE
create table DB04_Colors (
color		varchar(10),
constraint color_UQ UNIQUE (color)
);
INSERT INTO  db04_colors values ('red');
commit;
SELECT * FROM  db04_colors;
INSERT INTO  db04_colors values ('red');-- CHECK for violation of color_UQ
SELECT * FROM  db04_colors;
Drop table  db04_colors;
 
--	2.2.1 constraints of types PRIMARY KEY
--1.2	Only INTEGER and VARCHAR data types, written in capital letters, have to be considered.
create table FLUGHAFEN (
FHC		varchar(3),
LAND		varchar(3),
STADT		varchar(50),
NAME		varchar(50),
constraint FLUGHAFEN_PS
		primary key (FHC)
);
 
create table FLUGLINIE (
FLC		varchar(2),
LAND		varchar(3),
HUB		varchar(3),
NAME		varchar(30),
ALLIANZ		varchar(20),
constraint FLUGLINIE_LAND_NN
		check (LAND is not null),
constraint FLUGLINIE_ALLIANZ_CHK
		check (ALLIANZ in ('Star','Excellence','Leftover','OneWorld','SkyTeam')),
constraint FLUGLINIE_PS
		primary key (FLC),
constraint FLUGLINIE_FS_HUB
		foreign key (HUB) references FLUGHAFEN(FHC)
);
--	2.2.3	☐The FDBS at least must manage horizontally partitioned tables.
--	2.2.2	☐Support of FOREIGN KEY constraints is optional. 
create table FLUG (
FNR             integer,
FLC		varchar(2),
FLNR		integer,		
VON		varchar(3),
NACH		varchar(3),
AB		integer,
AN		integer,
constraint FLUG_VON_NN
		check (VON is not null),
constraint FLUG_NACH_NN
		check (NACH is not null),
constraint FLUG_AB_NN
		check (AB is not null),
constraint FLUG_AN_NN
		check (AN is not null),
constraint FLUG_AB_CHK
		check (AB between 0 and 2400),
constraint FLUG_AN_CHK
		check (AN between 0 and 2400),
constraint FLUG_VONNACH_CHK
		check (VON != NACH),
constraint FLUG_PS
		primary key (FNR),
constraint FLUG_FS_FLC
		foreign key (FLC) references FLUGLINIE(FLC),
constraint FLUG_FS_VON
		foreign key (VON) references FLUGHAFEN(FHC),
constraint FLUG_FS_NACH
		foreign key (NACH) references FLUGHAFEN(FHC)
)
HORIZONTAL (AB(1000,1500));


create table PASSAGIER (
PNR		integer,
NAME		varchar(40),
VORNAME		varchar(40),		
LAND		varchar(3),
constraint PASSAGIER_NAME_NN
                check (NAME is not null),
constraint PASSAGIER_PS
		primary key (PNR)
)
HORIZONTAL (PNR(35,70));


create table BUCHUNG (
BNR             integer,
PNR		integer,
FLC		varchar(2),
FLNR		integer,		
VON		varchar(3),
NACH		varchar(3),
TAG		varchar(20),
MEILEN          integer,
PREIS           integer,
constraint BUCHUNG_NACH_NN
		check (NACH is not null),
constraint BUCHUNG_MEILEN_NN
		check (MEILEN is not null),
constraint BUCHUNG_PREIS_NN
		check (PREIS is not null),
constraint BUCHUNG_MEILEN_CHK
                check (MEILEN >= 0),
constraint BUCHUNG_PREIS_CHK
                check (PREIS > 0),
constraint BUCHUNG_PS
		primary key (BNR),
constraint BUCHUNG_FS_PNR
		foreign key (PNR) references PASSAGIER(PNR),
constraint BUCHUNG_FS_FLC
		foreign key (FLC) references FLUGLINIE(FLC),
constraint BUCHUNG_FS_VON
		foreign key (VON) references FLUGHAFEN(FHC),
constraint BUCHUNG_FS_NACH
		foreign key (NACH) references FLUGHAFEN(FHC)
)
HORIZONTAL (PNR(35,70));
