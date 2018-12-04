package semantic;

import lexer.Token;

public class Variable {
    private Token token;
    private String type;

    public Variable(Token token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
