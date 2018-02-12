import java.io.IOException;
import java.io.Reader;

public class Lexer {
    private Reader reader;
    private int currentChar;

    public Lexer(Reader reader) throws IOException {
        this.reader = reader;
        readChar();
    }

    private void readChar() throws IOException {
        currentChar = reader.read();
        while (Character.isWhitespace((char)currentChar))
            currentChar = reader.read();
    }

    public Lexeme getLexeme() throws IOException {
        Lexeme tmp;
        switch (currentChar) {
            case '+':
                tmp = new Lexeme(LexemeType.PLUS, "+");
                readChar();
                break;
            case '-':
                tmp = new Lexeme(LexemeType.MINUS, "-");
                readChar();
                break;
            case '*':
                tmp = new Lexeme(LexemeType.ASTERISK, "*");
                readChar();
                break;
            case '/':
                tmp = new Lexeme(LexemeType.SLASH, "/");
                readChar();
                break;
            case '^':
                tmp = new Lexeme(LexemeType.CARET, "^");
                readChar();
                break;
            case '(':
                tmp = new Lexeme(LexemeType.LEFT_PAREN, "(");
                readChar();
                break;
            case ')':
                tmp = new Lexeme(LexemeType.RIGHT_PAREN, ")");
                readChar();
                break;
            case -1:
                tmp = new Lexeme(LexemeType.EOF, null);
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                StringBuilder builder = new StringBuilder();
                builder.append((char)currentChar);
                currentChar = reader.read();
                while (Character.isDigit((char)currentChar)) {
                    builder.append((char)currentChar);
                    currentChar = reader.read();
                }
                tmp = new Lexeme(LexemeType.NUMBER, builder.toString());
                if (Character.isWhitespace((char)currentChar))
                    readChar();
                break;
            default:
                throw new IOException("Error: forbidden char: " + (char)currentChar);
        }
        return tmp;
    }
}