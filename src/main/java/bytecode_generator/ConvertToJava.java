package bytecode_generator;

import lexer.Token;

import java.util.ArrayList;

public class ConvertToJava {

    ArrayList<Token> tokens;
    int position = 0;

    public ConvertToJava(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public String convert(String fileName) {
        String source = "public class " + fileName + " implements Runnable {\n" +
                "  public void run() {\n" +
                convertTokens() +
                "    }\n"

                + "}\n"; // TODO add structure code
        return source;
    }

    private String convertTokens() {
        String code = "";
        deleteWhitespaces();
        while (position < tokens.size()) {
            code += convertDeclarations();
            if (tokens.get(position).getLexeme().equals(";"))
                position++;
            position=10;
        }

        return code;
    }

    private String convertDeclarations() {
        String code = "";
        if (tokens.get(position).getType().equals(Token.TokenType.IDENTIFIER)) {
            String identifier = tokens.get(position).getLexeme();
            code += "Object " + identifier + ";\n";
            position++;
            if (tokens.get(position).getLexeme().equals(":")) {
                position++;
                if (tokens.get(position).getLexeme().equals("integer")) {
                    code += identifier + " = new Integer(" + convertExpression() +
                            ");\n";
                    position++;

                    code += "System.out.println(" + identifier + ".toString());\n";
                }
            }
        }
        return code;
    }

    private String convertExpression() {
        String code = "";
        
        return code;
    }

    private void deleteWhitespaces() {
        ArrayList<Token> modified = new ArrayList<Token>();
        for (Token token: tokens) {
            if (token.getType() != Token.TokenType.WHITE_SPACE) {
                modified.add(token);
            }
        }
        this.tokens = modified;
    }
}
