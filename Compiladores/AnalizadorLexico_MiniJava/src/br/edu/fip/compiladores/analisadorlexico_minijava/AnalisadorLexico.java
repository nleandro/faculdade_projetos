/* The following code was generated by JFlex 1.6.1 */

package br.edu.fip.compiladores.analisadorlexico_minijava;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>C:/Users/Nellson/Documents/Faculdade/Compiladores/AnalizadorLexico_MiniJava/src/br/edu/fip/compiladores/analisadorlexico_minijava/language.lex</tt>
 */
class AnalisadorLexico {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\1\1\50\1\1\1\1\22\0\1\1\1\42\4\0"+
    "\1\47\1\0\1\37\1\37\1\45\1\43\1\37\1\44\1\36\1\46"+
    "\1\5\11\6\1\0\1\37\1\41\1\40\3\0\22\2\1\27\7\2"+
    "\1\37\1\0\1\37\1\0\1\4\1\0\1\13\1\7\1\15\1\21"+
    "\1\12\1\32\1\31\1\34\1\24\2\2\1\11\1\26\1\14\1\10"+
    "\1\22\1\2\1\30\1\16\1\20\1\23\1\25\1\33\1\17\1\35"+
    "\1\2\1\37\1\3\1\37\7\0\1\50\u1fa2\0\1\50\1\50\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\2\2\4\17\3\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\1"+
    "\13\3\1\15\7\3\1\10\34\3\13\0\1\15";

  private static int [] zzUnpackAction() {
    int [] result = new int[91];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\51\0\51\0\122\0\122\0\51\0\173\0\244"+
    "\0\315\0\366\0\u011f\0\u0148\0\u0171\0\u019a\0\u01c3\0\u01ec"+
    "\0\u0215\0\u023e\0\u0267\0\u0290\0\u02b9\0\u02e2\0\51\0\u030b"+
    "\0\51\0\u030b\0\51\0\51\0\51\0\51\0\u0334\0\u035d"+
    "\0\u0386\0\u03af\0\u03d8\0\u0401\0\u042a\0\u0453\0\u047c\0\u04a5"+
    "\0\u04ce\0\u04f7\0\122\0\u0520\0\u0549\0\u0572\0\u059b\0\u05c4"+
    "\0\u05ed\0\u0616\0\51\0\u063f\0\u0668\0\u0691\0\u06ba\0\u06e3"+
    "\0\u070c\0\u0735\0\u075e\0\u0787\0\u07b0\0\u07d9\0\u0802\0\u082b"+
    "\0\u0854\0\u087d\0\u08a6\0\u08cf\0\u08f8\0\u0921\0\u094a\0\u0973"+
    "\0\u099c\0\u09c5\0\u09ee\0\u0a17\0\u0a40\0\u0a69\0\u0a92\0\u0abb"+
    "\0\u0ae4\0\u0b0d\0\u0b36\0\u0b5f\0\u0b88\0\u0bb1\0\u0bda\0\u0c03"+
    "\0\u0c2c\0\u0c55\0\51";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[91];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\2\1\6\1\7\1\10"+
    "\1\4\1\11\1\12\1\4\1\13\1\14\1\15\1\4"+
    "\1\16\1\4\1\17\1\4\1\20\1\21\1\22\1\23"+
    "\1\24\1\4\1\25\1\26\2\4\2\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\54\0\34\4"+
    "\20\0\2\7\44\0\6\4\1\40\25\4\15\0\10\4"+
    "\1\41\23\4\15\0\7\4\1\42\5\4\1\43\16\4"+
    "\15\0\10\4\1\44\23\4\15\0\7\4\1\45\24\4"+
    "\15\0\16\4\1\46\15\4\15\0\26\4\1\47\3\4"+
    "\1\50\1\4\15\0\21\4\1\51\12\4\15\0\12\4"+
    "\1\52\15\4\1\53\3\4\15\0\6\4\1\54\25\4"+
    "\15\0\11\4\1\55\22\4\15\0\16\4\1\56\14\4"+
    "\1\57\15\0\10\4\1\60\23\4\15\0\11\4\1\61"+
    "\22\4\15\0\32\4\1\62\1\4\53\0\1\31\57\0"+
    "\1\63\3\0\6\4\1\64\25\4\15\0\12\4\1\65"+
    "\21\4\15\0\14\4\1\66\17\4\15\0\16\4\1\67"+
    "\15\4\15\0\31\4\1\53\2\4\15\0\11\4\1\70"+
    "\22\4\15\0\11\4\1\71\22\4\15\0\21\4\1\66"+
    "\12\4\15\0\22\4\1\72\11\4\15\0\5\4\1\73"+
    "\26\4\15\0\16\4\1\53\15\4\15\0\22\4\1\74"+
    "\11\4\15\0\22\4\1\75\11\4\15\0\26\4\1\76"+
    "\5\4\15\0\14\4\1\77\17\4\15\0\16\4\1\100"+
    "\15\4\15\0\7\4\1\42\24\4\15\0\22\4\1\101"+
    "\11\4\15\0\7\4\1\102\24\4\15\0\27\4\1\103"+
    "\4\4\15\0\10\4\1\53\23\4\15\0\10\4\1\104"+
    "\23\4\15\0\14\4\1\72\17\4\15\0\16\4\1\105"+
    "\15\4\15\0\14\4\1\53\17\4\15\0\7\4\1\105"+
    "\24\4\15\0\17\4\1\53\14\4\15\0\12\4\1\53"+
    "\21\4\15\0\22\4\1\106\11\4\15\0\16\4\1\107"+
    "\15\4\15\0\21\4\1\110\12\4\15\0\7\4\1\66"+
    "\24\4\15\0\10\4\1\111\23\4\15\0\16\4\1\112"+
    "\15\4\15\0\12\4\1\113\21\4\15\0\22\4\1\114"+
    "\11\4\15\0\12\4\1\115\21\4\15\0\10\4\1\116"+
    "\23\4\15\0\26\4\1\75\5\4\15\0\11\4\1\75"+
    "\22\4\15\0\32\4\1\53\1\4\15\0\17\4\1\72"+
    "\14\4\15\0\13\4\1\53\20\4\15\0\27\4\1\53"+
    "\4\4\15\0\24\4\1\117\7\4\15\0\34\4\1\120"+
    "\22\0\1\121\63\0\1\122\45\0\1\123\66\0\1\124"+
    "\34\0\1\125\56\0\1\126\44\0\1\127\40\0\1\130"+
    "\54\0\1\131\41\0\1\132\53\0\1\133\34\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3198];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\2\1\1\11\20\1\1\11\1\1\1\11"+
    "\1\1\4\11\24\1\1\11\34\1\13\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[91];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
private void imprimir(String descricao, String lexema) {
    System.out.println(lexema + "\t- " + descricao);
}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  AnalisadorLexico(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 172) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Object yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new RuntimeException("Caractere invalido \"" +yytext() +
"\" na linha "+yyline+", coluna "+yycolumn);
            }
          case 14: break;
          case 2: 
            { imprimir("Espaço em branco", yytext());
            }
          case 15: break;
          case 3: 
            { imprimir("Identificador", yytext());
            }
          case 16: break;
          case 4: 
            { imprimir("Número Inteiro", yytext());
            }
          case 17: break;
          case 5: 
            { imprimir("Delimitador", yytext());
            }
          case 18: break;
          case 6: 
            { imprimir("Símbolo de atribuição", yytext());
            }
          case 19: break;
          case 7: 
            { imprimir("Símbolo de comparação", yytext());
            }
          case 20: break;
          case 8: 
            { imprimir("Símbolo de relação", yytext());
            }
          case 21: break;
          case 9: 
            { imprimir("Operador de soma", yytext());
            }
          case 22: break;
          case 10: 
            { imprimir("Operador de subtração", yytext());
            }
          case 23: break;
          case 11: 
            { imprimir("Operador de multiplicação", yytext());
            }
          case 24: break;
          case 12: 
            { imprimir("Operador de divisão", yytext());
            }
          case 25: break;
          case 13: 
            { imprimir("Palavra reservada", yytext());
            }
          case 26: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
