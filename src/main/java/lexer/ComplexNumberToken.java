package lexer;

public class ComplexNumberToken extends Token{

    Token realPart;
    Token imaginaryPart;

    public ComplexNumberToken(String lexeme, int row, int column, int length, Token realPart, Token imaginaryPart) {
        super(Token.TokenType.COMPLEX_NUMBER, lexeme, row, column, length);

        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tREAL_PART - " + realPart.toString() + "\n\tIMAGINARY_PART - " + imaginaryPart.toString();
    }
}
