package lexer;

import java.util.ArrayList;

public class Lexer {
    private ArrayList<Token> tokens = new ArrayList<Token>();
    private StringBuilder source;
    private int row = 0;
    private int column = 0;

    public Lexer(StringBuilder source) {
        this.source = source;
    }

    public Lexer(String source) {
        this.source = new StringBuilder(source);
    }

    public ArrayList<Token> parse() throws Exception {
        Token curToken;
        int position = 0;

        while(position < source.length()) {
            curToken = parseWhiteSpaces(position);

            if (curToken == null)
                curToken = parsePunctuation(position);
            if (curToken == null)
                curToken = parseKeyword(position);
            if (curToken == null)
                curToken = parseType(position);
            if (curToken == null)
                curToken = parseBoolean(position);
            if (curToken == null)
                curToken = parseOperator(position);
            if (curToken == null)
                curToken = parseIdentifier(position);
            if (curToken == null)
                curToken = parseString(position);
            if (curToken == null)
                curToken = parseComplexNumber(position);
            if (curToken == null)
                curToken = parseRationalNumber(position);
            if (curToken == null)
                curToken = parseRealNumber(position);
            if (curToken == null)
                curToken = parseInteger(position);

            if (curToken == null) {
                throw new UnexpectedTokenException(row, column);
            }
            position += curToken.getLength();
            tokens.add(curToken);
        }

        if (position != source.length()) {
            throw new Exception("Not all tokens passed");
        }

        return tokens;
    }

    private Token parseComplexNumber(int position) {
        Token token = null;
        int start = position;
        int length = 0;

        Token realPart = parseRealNumber(position);
        if (realPart == null)
            realPart = parseInteger(position);

        if (realPart != null) {
            position += realPart.getLength();
            length += realPart.getLength();
            if (isNext(position) && nextChar(position) == 'i') {
                position++;
                length++;

                Token imaginaryPart = parseRealNumber(position);
                if (imaginaryPart == null)
                    imaginaryPart = parseInteger(position);

                if (imaginaryPart != null) {
                    length += imaginaryPart.getLength();

                    token = new ComplexNumberToken(nextChar(start, length), row, column, length, realPart, imaginaryPart);
                    column += length;
                }
            }
            else {
                column -= length;
            }
        }
        return token;
    }

    private Token parseRationalNumber(int position) {
        Token token = null;
        int start = position;
        int length = 0;

        Token numerator = parseInteger(position);
        if (numerator != null) {
            position += numerator.getLength();
            length += numerator.getLength();
            if (isNext(position) && nextChar(position) == '\\') {
                position++;
                length++;

                Token denominator = parseInteger(position);
                if (denominator != null) {
                    length += denominator.getLength();

                    token = new RationalNumberToken(nextChar(start, length), row, column, length, numerator, denominator);
                    column += length;
                }
            }
            else {
                column -= length;
            }
        }

        return token;
    }

    private Token parseRealNumber(int position) {
        Token token = null;
        int start = position;
        int length = 0;

        Token integerPart = parseInteger(position);
        if (integerPart != null) {
            position += integerPart.getLength();
            length += integerPart.getLength();
            if(isNext(position) && nextChar(position) == '.') {
                position++;
                length++;

                Token mantissa = parseInteger(position);
                if (mantissa != null) {
                    length += mantissa.getLength();

                    token = new RealNumberToken(nextChar(start, length), row, column, length, integerPart, mantissa);
                    column += length;
                }
            }
            else {
                column -= length;
            }
        }

        return token;
    }

    private Token parseInteger(int position) {
        Token token = null;
        int start = -1;
        int length = 0;

        if (isNext(position) && Character.isDigit(nextChar(position))) {
            start = position;
            length++;
            position++;

            while (isNext(position) && Character.isDigit(nextChar(position))) {
                length++;
                position++;
            }
        }

        if (start != -1) {
            token = new Token(Token.TokenType.INTEGER, nextChar(start, length), row, column);
            column += length;
        }

        return token;
    }

    private Token parseString(int position) throws UnterminatedStringLiteral {
        Token token = null;
        int start = -1;
        int length = 0;

        if (isNext(position) && nextChar(position) == '\"') {
            start = position;
            length++;
            position++;

            while(isNext(position) && nextChar(position) != '\"') {
                if (nextChar(position) == '\n')
                    throw new UnterminatedStringLiteral(row, column+length);
                length++;
                position++;
            }
        }

        if (start != -1) {
            token = new Token(Token.TokenType.STRING, nextChar(start, length), row, column);
            column += length;
        }

        return token;
    }

    private Token parseOperator(int position) {
        Token token = null;
        String operator = null;

        if (isNext(position, 3) && nextChar(position, 3).equals("and") && !isIdentidierPart(nextChar(position + 3)))
            operator = "and";
        else if (isNext(position, 2) && nextChar(position, 2).equals("or") && !isIdentidierPart(nextChar(position + 2)))
            operator = "or";
        else if (isNext(position, 3) && nextChar(position, 3).equals("xor") && !isIdentidierPart(nextChar(position + 3)))
            operator = "xor";
        else if (isNext(position, 2) && nextChar(position, 2).equals("<="))
            operator = "<=";
        else if (isNext(position, 2) && nextChar(position, 2).equals(">="))
            operator = ">=";
        else if (isNext(position, 2) && nextChar(position, 2).equals("/="))
            operator = "/=";
        else if (isNext(position) && nextChar(position) == '<')
            operator = "<";
        else if (isNext(position) && nextChar(position) == '>')
            operator = ">";
        else if (isNext(position) && nextChar(position) == '=')
            operator = "=";
        else if (isNext(position) && nextChar(position) == '*')
            operator = "*";
        else if (isNext(position) && nextChar(position) == '/')
            operator = "/";
        else if (isNext(position) && nextChar(position) == '+')
            operator = "+";
        else if (isNext(position) && nextChar(position) == '-')
            operator = "-";
        else if (isNext(position) && nextChar(position) == '^')
            operator = "^";
        else if (isNext(position) && nextChar(position) == '&')
            operator = "&";
        else if (isNext(position) && nextChar(position) == '|')
            operator = "|";

        if (operator != null) {
            token = new Token(Token.TokenType.OPERATOR, operator, row, column, operator.length());
            column += operator.length();
        }

        return token;
    }

    private Token parseBoolean(int position) {
        Token token = null;
        String value = null;

        if (isNext(position, 4) && nextChar(position, 4).equals("true") && !isIdentidierPart(nextChar(position + 4)))
            value = "true";
        else if (isNext(position, 5) && nextChar(position, 5).equals("false") && !isIdentidierPart(nextChar(position + 5)))
            value = "false";

        if (value != null) {
            token = new Token(Token.TokenType.BOOLEAN, value, row, column, value.length());
            column += value.length();
        }

        return token;
    }

    private Token parseIdentifier(int position) {
        Token token = null;
        int start = -1;
        int length = 0;

        if (isNext(position) && isIdentifierStart(nextChar(position))) {
            start = position;
            position++;
            length++;

            while (isNext(position) && isIdentidierPart(nextChar(position))) {
                position++;
                length++;
            }
        }

        if (start != -1) {
            token = new Token(Token.TokenType.IDENTIFIER, nextChar(start, length), row, column, length);
            column += length;
        }

        return token;
    }

    private Token parseType(int position) {
        Token token = null;
        String type = null;

        if (isNext(position, 4) && nextChar(position, 4).equals("bool") && !isIdentidierPart(nextChar(position + 4)))
            type = "bool";
        else if (isNext(position, 7) && nextChar(position, 7).equals("integer") && !isIdentidierPart(nextChar(position + 7)))
            type = "integer";
        else if (isNext(position, 4) && nextChar(position, 4).equals("real") && !isIdentidierPart(nextChar(position + 4)))
            type = "real";
        else if (isNext(position, 8) && nextChar(position, 8).equals("rational") && !isIdentidierPart(nextChar(position + 8)))
            type = "rational";
        else if (isNext(position, 7) && nextChar(position, 7).equals("complex") && !isIdentidierPart(nextChar(position + 7)))
            type = "complex";
        else if (isNext(position, 6) && nextChar(position, 6).equals("string") && !isIdentidierPart(nextChar(position + 6)))
            type = "string";
        else if (isNext(position, 4) && nextChar(position, 4).equals("func") && !isIdentidierPart(nextChar(position + 4)))
            type = "func";

        if (type != null) {
            token = new Token(Token.TokenType.TYPE, type, row, column, type.length());
            column += type.length();
        }

        return token;
    }

    private Token parseKeyword(int position) {
        Token token = null;
        String keyword = null;

        if (isNext(position, 2) && nextChar(position, 2).equals("do") && !isIdentidierPart(nextChar(position + 2)))
            keyword = "do";
        else if (isNext(position, 3) && nextChar(position, 3).equals("end") && !isIdentidierPart(nextChar(position + 3)))
            keyword = "end";
        else if (isNext(position, 2) && nextChar(position, 2).equals("is") && !isIdentidierPart(nextChar(position + 2)))
            keyword = "is";
        else if (isNext(position, 6) && nextChar(position, 6).equals("return") && !isIdentidierPart(nextChar(position + 6)))
            keyword = "return";
        else if (isNext(position, 5) && nextChar(position, 5).equals("break") && !isIdentidierPart(nextChar(position + 5)))
            keyword = "break";
        else if (isNext(position, 2) && nextChar(position, 2).equals("if") && !isIdentidierPart(nextChar(position + 2)))
            keyword = "if";
        else if (isNext(position, 4) && nextChar(position, 4).equals("then") && !isIdentidierPart(nextChar(position + 4)))
            keyword = "then";
        else if (isNext(position, 4) && nextChar(position, 4).equals("else") && !isIdentidierPart(nextChar(position + 4)))
            keyword = "else";
        else if (isNext(position, 3) && nextChar(position, 3).equals("for") && !isIdentidierPart(nextChar(position + 3)))
            keyword = "for";
        else if (isNext(position, 2) && nextChar(position, 2).equals("in") && !isIdentidierPart(nextChar(position + 2)))
            keyword = "in";
        else if (isNext(position, 5) && nextChar(position, 5).equals("while") && !isIdentidierPart(nextChar(position + 5)))
            keyword = "while";
        else if (isNext(position, 4) && nextChar(position, 4).equals("loop") && !isIdentidierPart(nextChar(position + 4)))
            keyword = "loop";
        else if (isNext(position, 5) && nextChar(position, 5).equals("print") && !isIdentidierPart(nextChar(position + 5)))
            keyword = "print";

        if (keyword != null) {
            token = new Token(Token.TokenType.KEYWORD, keyword, row, column, keyword.length());
            column += keyword.length();
        }

        return token;
    }

    private Token parsePunctuation(int position) {
        Token token = null;
        String punctuation = null;
        if (isNext(position) && nextChar(position) == ',')
            punctuation = ",";
        else if (isNext(position, 2) && nextChar(position, 2).equals(":="))
            punctuation = ":=";
        else if (isNext(position) && nextChar(position) == ':')
            punctuation = ":";
        else if (isNext(position) && nextChar(position) == '{')
            punctuation = "{";
        else if (isNext(position) && nextChar(position) == '}')
            punctuation = "}";
        else if (isNext(position) && nextChar(position) == '[')
            punctuation = "[";
        else if (isNext(position) && nextChar(position) == ']')
            punctuation = "]";
        else if (isNext(position) && nextChar(position) == '(')
            punctuation = "(";
        else if (isNext(position) && nextChar(position) == ')')
            punctuation = ")";
        else if (isNext(position) && nextChar(position) == '.')
            punctuation = ".";
        else if (isNext(position) && nextChar(position) == ';')
            punctuation = ";";
        else if (isNext(position, 2) && nextChar(position, 2).equals("=>"))
            punctuation = "=>";

        if (punctuation != null) {
            token = new Token(Token.TokenType.PUNCTUATION, punctuation, row, column, punctuation.length());
            column += punctuation.length();
        }

        return token;
    }

    private Token parseWhiteSpaces(int position) {
        Token token = null;
        if (isNext(position) && nextChar(position) == '\t') {
            token = new Token(Token.TokenType.WHITE_SPACE, "\\t", row, column, 1);
            column++;
        }
        else if (isNext(position) && nextChar(position) == '\n') {
            token = new Token(Token.TokenType.WHITE_SPACE, "\\n", row, column, 1);
            row++;
        }
        else if (isNext(position) && nextChar(position) == '\r') {
            token = new Token(Token.TokenType.WHITE_SPACE, "\\r", row, column, 1);
            column = 0;
        }
        else if (isNext(position) && nextChar(position) == ' ') {
            int l = 0;
            while (isNext(position) && nextChar(position) == ' ') {
                position++;
                l++;
            }
            token = new Token(Token.TokenType.WHITE_SPACE, " ", row, column, l);
            column += l;
        }
        return token;
    }

    private char nextChar(int position) {
        return source.charAt(position);
    }

    private String nextChar(int position, int n) {
        return source.substring(position, position + n);
    }

    private boolean isNext(int position) {
        return position < source.length();
    }

    private boolean isNext(int position, int n) {
        return position + n - 1 < source.length();
    }

    private boolean isIdentifierStart(char ch) {
        return Character.isLetter(ch) || ch =='_';
    }

    private boolean isIdentidierPart(char ch) {
        return Character.isLetterOrDigit(ch) || ch == '_';
    }
}
