/* Generated By:JavaCC: Do not edit this line. GepardParser.java */
package parser;
public class GepardParser implements GepardParserConstants {
                public static void main(String args[]) throws Exception {
                        GepardParser parser = new GepardParser(System.in);
                        System.out.println(parser.CreateTable());
                }

/* ================ Tokens End ============== */

/* ================ Rules Start ============== */



// DDL Statement
  final public int parseDMLQuery() throws ParseException {
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
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public int CreateTable() throws ParseException {
                     int queryType;
    jj_consume_token(CREATE);
    jj_consume_token(TABLE);
    Name();
    jj_consume_token(LPAREN);
    TableColumn();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      jj_consume_token(COMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LETTER:
        TableColumn();
        break;
      case CONSTRAINT:
        TableConstraint();
        break;
      default:
        jj_la1[2] = jj_gen;
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
      jj_la1[3] = jj_gen;
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
        jj_la1[4] = jj_gen;
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
        jj_la1[5] = jj_gen;
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
          jj_la1[6] = jj_gen;
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
          jj_la1[7] = jj_gen;
          break label_5;
        }
      }
      jj_consume_token(RPAREN);
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void TableConstraint() throws ParseException {
    jj_consume_token(CONSTRAINT);
    Name();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PRIMARYKEY:
      jj_consume_token(PRIMARYKEY);
      break;
    case UNIQUE:
      jj_consume_token(UNIQUE);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(LPAREN);
    Name();
    jj_consume_token(RPAREN);
  }

// Drop Statement
  final public int DropTable() throws ParseException {
    jj_consume_token(DROP);
    jj_consume_token(TABLE);
    Name();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CASCADE:
      jj_consume_token(CASCADE);
      jj_consume_token(CONSTRAINTS);
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
    jj_consume_token(SEMICOLON);
         {if (true) return 3;}
    throw new Error("Missing return statement in function");
  }

// Select Statement




// DML Statement




// General Semantics
  final public void Name() throws ParseException {
    jj_consume_token(LETTER);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIGIT:
      case LETTER:
      case SYMBOL:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LETTER:
        jj_consume_token(LETTER);
        break;
      case DIGIT:
        jj_consume_token(DIGIT);
        break;
      case SYMBOL:
        jj_consume_token(SYMBOL);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
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
  final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x60,0x80000,0x200800,0x48000,0x100000,0x80000,0x100000,0x100000,0x300,0x6000,0x400,0x700000,0x700000,};
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
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public GepardParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GepardParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public GepardParser(GepardParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(GepardParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[23];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 13; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 23; i++) {
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