package semantic;

import lexer.Token;

import java.util.ArrayList;
import java.util.List;

public class Variable {
    private Token token;
    private String type;
    private ArrayList<String> input;

    public Variable(Token token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getType(){
        return type;
    }
    public ArrayList<String> getInput(){
        return input;
    }

    public void setList(ArrayList<String> list){
        input = list;
    }
}
