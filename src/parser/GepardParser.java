/* Generated By:JavaCC: Do not edit this line. GepardParser.java */
package parser;
public class GepardParser implements GepardParserConstants {
        public static void main(String args[]) {
                GepardParser parser = new GepardParser(System.in);
                try {
                        //parser.NonJoinCondition();
                        System.out.println(parser.ParseQuery());
                        System.out.println("Validated");
                }catch(Exception e){
                   System.out.println(e);
                }
        }

/* ================ Tokens End ============== */

/* ================ Rules Start ============== */

// Main Parser Call
  final public int ParseQuery() throws ParseException {
                    int queryType;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CREATE:
    case DROP:
      queryType = ParseDDLQuery();
                                  {if (true) return queryType;}
      break;
    case DELETE:
    case INSERT:
      queryType = ParseDMLQuery();
                                  {if (true) return queryType;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

// DDL Statement
  final public int ParseDDLQuery() throws ParseException {
                       int queryType;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DROP:
      queryType = DropTable();
                              {if (true) return queryType;}
      break;
    case CREATE:
      queryType = CreateTable();
                                {if (true) return queryType;}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public int DropTable() throws ParseException {
    jj_consume_token(DROP);
    jj_consume_token(TABLE);
    TableName();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CASCADE:
      jj_consume_token(CASCADE);
      jj_consume_token(CONSTRAINTS);
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    jj_consume_token(SEMICOLON);
         {if (true) return 3;}
    throw new Error("Missing return statement in function");
  }

  final public int CreateTable() throws ParseException {
                     int queryType;
    jj_consume_token(CREATE);
    jj_consume_token(TABLE);
    TableName();
    jj_consume_token(LPAREN);
    TableColumn();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_1;
      }
      jj_consume_token(COMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case UNDERSCORE:
      case MINUS:
      case DIGIT:
      case LETTER:
        TableColumn();
        break;
      case CONSTRAINT:
        TableConstraint();
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(RPAREN);
    queryType = PartitionedOrNonPartitioned();
                                                                                                                                                  {if (true) return queryType;}
    throw new Error("Missing return statement in function");
  }

  final public int PartitionedOrNonPartitioned() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SEMICOLON:
      CreateTableNonPartitioned();
                                    {if (true) return 1;}
      break;
    case HORIZONTAL:
      CreateTablePartitioned();
                                                                        {if (true) return 2;}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void CreateTableNonPartitioned() throws ParseException {
    jj_consume_token(SEMICOLON);
  }

  final public void CreateTablePartitioned() throws ParseException {
    HorizontalSyntax();
  }

  final public void HorizontalSyntax() throws ParseException {
    jj_consume_token(HORIZONTAL);
    jj_consume_token(LPAREN);
    Name();
    jj_consume_token(LPAREN);
    ListOfBoundaries();
    jj_consume_token(RPAREN);
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
  }

  final public void ListOfBoundaries() throws ParseException {
    label_2:
    while (true) {
      jj_consume_token(DIGIT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIGIT:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_2;
      }
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMMA);
      label_4:
      while (true) {
        jj_consume_token(DIGIT);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DIGIT:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_4;
        }
      }
    }
  }

  final public void TableColumn() throws ParseException {
    Name();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
      jj_consume_token(INTEGER);
      break;
    case VARCHAR:
      jj_consume_token(VARCHAR);
      jj_consume_token(LPAREN);
      label_5:
      while (true) {
        jj_consume_token(DIGIT);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DIGIT:
          ;
          break;
        default:
          jj_la1[9] = jj_gen;
          break label_5;
        }
      }
      jj_consume_token(RPAREN);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void TableConstraint() throws ParseException {
    jj_consume_token(CONSTRAINT);
    Name();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PRIMARYKEY:
    case UNIQUE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PRIMARYKEY:
        jj_consume_token(PRIMARYKEY);
        break;
      case UNIQUE:
        jj_consume_token(UNIQUE);
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(LPAREN);
      NameWithoutSpace();
      jj_consume_token(RPAREN);
      break;
    case CHECK:
      CheckConstraints();
      break;
    case FOREIGNKEY:
      ForeignKeyConstraint();
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void CheckConstraints() throws ParseException {
    jj_consume_token(CHECK);
    jj_consume_token(LPAREN);
    Name();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IS:
      CheckConstraint();
      break;
    case IN:
      CheckConstraintWithIn();
      break;
    case BETWEEN:
      CheckConstraintWithBetween();
      break;
    case OPERATOR:
      CheckConstraintWithOperator();
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(RPAREN);
  }

  final public void CheckConstraint() throws ParseException {
    jj_consume_token(IS);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      jj_consume_token(NOT);
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    jj_consume_token(NULL);
  }

  final public void CheckConstraintWithIn() throws ParseException {
    jj_consume_token(IN);
    jj_consume_token(LPAREN);
    ListOfConstants();
    jj_consume_token(RPAREN);
  }

  final public void CheckConstraintWithBetween() throws ParseException {
    jj_consume_token(BETWEEN);
    Constant();
    jj_consume_token(AND);
    Constant();
  }

  final public void CheckConstraintWithOperator() throws ParseException {
    jj_consume_token(OPERATOR);
    NameWithoutSpace();
  }

  final public void ForeignKeyConstraint() throws ParseException {
    jj_consume_token(FOREIGNKEY);
    jj_consume_token(LPAREN);
    NameWithoutSpace();
    jj_consume_token(RPAREN);
    jj_consume_token(REFERENCES);
    Name();
    jj_consume_token(LPAREN);
    NameWithoutSpace();
    jj_consume_token(RPAREN);
  }

// Select Statement
  final public int Select() throws ParseException {
                int queryType;
    jj_consume_token(SELECT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COUNT:
      queryType = SelectCountAllTable();
                                                 {if (true) return queryType;}
      break;
    case UNDERSCORE:
    case MINUS:
    case AST:
    case DIGIT:
    case LETTER:
      queryType = SelectNoGroup();
                                                                                              {if (true) return queryType;}
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void ListOfAttributes() throws ParseException {
    TableAttribute();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_6;
      }
      jj_consume_token(COMMA);
      TableAttribute();
    }
  }

  final public void TableAttribute() throws ParseException {
    Name();
    jj_consume_token(DOT);
    Name();
  }

  final public void NonJoinCondition() throws ParseException {
    jj_consume_token(LPAREN);
    TableAttribute();
    jj_consume_token(OPERATOR);
    Constant();
    jj_consume_token(RPAREN);
  }

  final public void NonJoinConditions() throws ParseException {
    NonJoinCondition();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AND:
    case OR:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        jj_consume_token(AND);
        break;
      case OR:
        jj_consume_token(OR);
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      NonJoinCondition();
      break;
    default:
      jj_la1[18] = jj_gen;
      ;
    }
  }

  final public void Count() throws ParseException {
    jj_consume_token(COUNT);
    jj_consume_token(LPAREN);
    jj_consume_token(AST);
    jj_consume_token(RPAREN);
  }

  final public int SelectCountAllTable() throws ParseException {
    Count();
    jj_consume_token(FROM);
    Name();
    jj_consume_token(SEMICOLON);
 {if (true) return 11;}
    throw new Error("Missing return statement in function");
  }

  final public int SelectNoGroup() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AST:
      jj_consume_token(AST);
      break;
    case UNDERSCORE:
    case MINUS:
    case DIGIT:
    case LETTER:
      ListOfAttributes();
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(FROM);
    ListOfTables();
    jj_consume_token(SEMICOLON);
                                                          {if (true) return 12;}
    throw new Error("Missing return statement in function");
  }

// DML Statement
  final public int ParseDMLQuery() throws ParseException {
                       int queryType;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DELETE:
      queryType = DeleteTable();
                                {if (true) return queryType;}
      break;
    case INSERT:
      queryType = InsertTable();
                                {if (true) return queryType;}
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public int DeleteTable() throws ParseException {
    jj_consume_token(DELETE);
    jj_consume_token(FROM);
    NameWithoutSpace();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHERE:
    case 42:
      WhereClauseForDelete();
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    jj_consume_token(SEMICOLON);
   {if (true) return 4;}
    throw new Error("Missing return statement in function");
  }

  final public int InsertTable() throws ParseException {
    jj_consume_token(INSERT);
    jj_consume_token(INTO);
    Name();
    jj_consume_token(VALUES);
    jj_consume_token(LPAREN);
    Constant();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_7;
      }
      jj_consume_token(COMMA);
      Constant();
    }
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
   {if (true) return 5;}
    throw new Error("Missing return statement in function");
  }

  final public void WhereClauseForDelete() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 42:
      jj_consume_token(42);
      break;
    default:
      jj_la1[23] = jj_gen;
      ;
    }
    jj_consume_token(WHERE);
    Name();
    jj_consume_token(OPERATOR);
    Constant();
  }

// General Semantics
  final public void WhereClause() throws ParseException {
    jj_consume_token(WHERE);
    Name();
    jj_consume_token(OPERATOR);
    Constant();
  }

  final public void Name() throws ParseException {
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LETTER:
        jj_consume_token(LETTER);
        break;
      case DIGIT:
        jj_consume_token(DIGIT);
        break;
      case UNDERSCORE:
        jj_consume_token(UNDERSCORE);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        break;
      default:
        jj_la1[24] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case UNDERSCORE:
      case MINUS:
      case DIGIT:
      case LETTER:
        ;
        break;
      default:
        jj_la1[25] = jj_gen;
        break label_8;
      }
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 42:
      jj_consume_token(42);
      break;
    default:
      jj_la1[26] = jj_gen;
      ;
    }
  }

  final public void NameWithoutSpace() throws ParseException {
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LETTER:
        jj_consume_token(LETTER);
        break;
      case DIGIT:
        jj_consume_token(DIGIT);
        break;
      case UNDERSCORE:
        jj_consume_token(UNDERSCORE);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        break;
      default:
        jj_la1[27] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case UNDERSCORE:
      case MINUS:
      case DIGIT:
      case LETTER:
        ;
        break;
      default:
        jj_la1[28] = jj_gen;
        break label_9;
      }
    }
  }

  final public void TableName() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LETTER:
      jj_consume_token(LETTER);
      break;
    case UNDERSCORE:
      jj_consume_token(UNDERSCORE);
      break;
    default:
      jj_la1[29] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case UNDERSCORE:
      case DIGIT:
      case LETTER:
        ;
        break;
      default:
        jj_la1[30] = jj_gen;
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LETTER:
        jj_consume_token(LETTER);
        break;
      case UNDERSCORE:
        jj_consume_token(UNDERSCORE);
        break;
      case DIGIT:
        jj_consume_token(DIGIT);
        break;
      default:
        jj_la1[31] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 42:
      jj_consume_token(42);
      break;
    default:
      jj_la1[32] = jj_gen;
      ;
    }
  }

  final public void ListOfTables() throws ParseException {
    TableName();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMMA:
      jj_consume_token(COMMA);
      TableName();
      break;
    default:
      jj_la1[33] = jj_gen;
      ;
    }
  }

  final public void Constant() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLEQUOTE:
      StringConstant();
      break;
    case MINUS:
    case DIGIT:
      IntegerConstant();
      break;
    case NULL:
      jj_consume_token(NULL);
      break;
    default:
      jj_la1[34] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void IntegerConstant() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MINUS:
      jj_consume_token(MINUS);
      break;
    default:
      jj_la1[35] = jj_gen;
      ;
    }
    label_11:
    while (true) {
      jj_consume_token(DIGIT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIGIT:
        ;
        break;
      default:
        jj_la1[36] = jj_gen;
        break label_11;
      }
    }
  }

  final public void StringConstant() throws ParseException {
    jj_consume_token(SINGLEQUOTE);
    NameWithoutSpace();
    jj_consume_token(SINGLEQUOTE);
  }

  final public void ListOfConstants() throws ParseException {
    Constant();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[37] = jj_gen;
        break label_12;
      }
      jj_consume_token(COMMA);
      Constant();
    }
  }

  /** Generated Token Manager. */
  public GepardParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[38];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x480006,0x6,0x40,0x10000000,0x80000080,0x8000800,0x0,0x10000000,0x0,0x0,0x30,0x600,0x11600,0x4004a000,0x4000,0x80000000,0x10000000,0x0,0x0,0x80000000,0x480000,0x200000,0x10000000,0x0,0x80000000,0x80000000,0x0,0x80000000,0x80000000,0x80000000,0x80000000,0x80000000,0x0,0x10000000,0x20000000,0x0,0x0,0x10000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x301,0x0,0x100,0x0,0x100,0x100,0x0,0x0,0x0,0x0,0x0,0x389,0x0,0x30,0x30,0x309,0x0,0x400,0x0,0x400,0x301,0x301,0x400,0x301,0x301,0x200,0x300,0x300,0x400,0x0,0x103,0x1,0x100,0x0,};
   }

  /** Constructor with InputStream. */
  public GepardParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public GepardParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new GepardParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public GepardParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GepardParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public GepardParser(GepardParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(GepardParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 38; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[43];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 38; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 43; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
