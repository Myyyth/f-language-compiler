package lexer;

public class Token {
    public enum TokenType {
        INTEGER, REAL_NUMBER, STRING, PUNCTUATION, KEYWORD, TYPE, BOOLEAN, OPERATOR, WHITE_SPACE, IDENTIFIER, RATIONAL_NUMBER, COMPLEX_NUMBER
    };

    private String lexeme;
    private TokenType type;
    private int length;
    private int row;
    private int column;

    public Token(TokenType type, String lexeme, int row, int column) {
        this.type = type;
        this.lexeme = lexeme;
        this.length = lexeme.length();
        this.row = row;
        this.column = column;
    }

    public Token(TokenType type, String lexeme, int row, int column, int length) {
        this.type = type;
        this.lexeme = lexeme;
        this.length = length;
        this.row = row;
        this.column = column;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }

    public TokenType getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "TYPE: " + type + ", LEXEME: " + lexeme + ", LENGTH: " + length + ", ROW: " + row + ", COLUMN: " + column;
    }
}

class UnexpectedTokenException extends Exception {
    public UnexpectedTokenException(int row, int column) {
        super("Unexpected token at row: " + row + ", column: " + column);
    }
}

class UnterminatedStringLiteral extends Exception {
    public UnterminatedStringLiteral(int row, int column) {
        super("Unterminated string before new line at row: " + row + ", column: " + column);
    }
}
