package lexer;

public class RealNumberToken extends Token {
    private Token integerPart;
    private Token mantissa;

    public RealNumberToken(String lexeme, int row, int column, int length, Token integerPart, Token mantissa) {
        super(TokenType.REAL_NUMBER, lexeme, row, column, length);

        this.integerPart = integerPart;
        this.mantissa = mantissa;
    }

    public Token getIntegerPart() {
        return integerPart;
    }

    public Token getMantissa() {
        return mantissa;
    }

    @Override
    public String toString() {

        return super.toString() + "\n\tINTEGER_TYPE - " + integerPart.toString() + "\n\tMANTISSA - " + mantissa.toString();
    }
}
