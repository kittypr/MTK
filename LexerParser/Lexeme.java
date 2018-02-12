public class Lexeme {
    private LexemeType type;
    private String lexemeText;

    public Lexeme(LexemeType type, String lexemeText) {
        this.type = type;
        this.lexemeText = lexemeText;
    }

    public LexemeType getType() {
        return type;
    }

    public String getLexemeText() {
        return lexemeText;
    }
}