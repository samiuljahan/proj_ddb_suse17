SELECT COUNT(*) FROM TJ_PASSAGIER;

/* DELETE ONE TUPLE FROM PINATUBO */
DELETE FROM TJ_PASSAGIER WHERE PNR = 1;             
SELECT COUNT(*) FROM TJ_PASSAGIER;

/* DELETE FROM ONE PARTITIONS */
DELETE FROM TJ_PASSAGIER WHERE VON = 'CDG';
SELECT COUNT(*) FROM TJ_PASSAGIER;

/* DELETE FROM TWO PARTITIONS */
DELETE FROM TJ_PASSAGIER WHERE FLC = 'DL';
SELECT COUNT(*) FROM TJ_PASSAGIER;

/* DELETE OVER ALL PARTITONS */
DELETE FROM TJ_PASSAGIER WHERE FLC = 'DB';             
SELECT COUNT(*) FROM TJ_PASSAGIER;

/* DELETE ALL */
DELETE FROM TJ_PASSAGIER;             
SELECT COUNT(*) FROM TJ_PASSAGIER;

rollback;
  