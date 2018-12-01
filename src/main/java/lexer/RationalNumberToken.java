package lexer;

public class RationalNumberToken extends Token{
    private Token numerator;
    private Token denominator;

    public RationalNumberToken(String lexeme, int row, int column, int length, Token numerator, Token denominator) {
        super(Token.TokenType.RATIONAL_NUMBER, lexeme, row, column, length);

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Token getNumerator() {
        return numerator;
    }

    public Token getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tNUMERATOR - " + numerator.toString() + "\n\tDENOMINATOR - " + denominator.toString();
    }
}
