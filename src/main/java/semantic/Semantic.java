package semantic;

import lexer.Token;
import parser.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Semantic {
    private ArrayList<Token> tokens;
    private int globalIterator;
    private Map<String, Variable> variables;

    public Semantic(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.globalIterator = 0;
        this.variables = new HashMap<String, Variable>();
    }

    public String analyze() {
        deleteWhitespaces();
        while (globalIterator < tokens.size()) {
            if (tokens.get(globalIterator).getType().name().equals("IDENTIFIER")) {
                String msg = checkInd();
                if (msg != null){
                    return msg;
                }

            }
            else {
                globalIterator++;
            }
            /*else{
                return tokens.get(globalIterator).getLength() + " " + tokens.get(globalIterator).getColumn();
            }*/

        }
        return "";
    }

    public String checkInd(){
        //TODO :real is int
        int ind = globalIterator;
        globalIterator++;
        if (tokens.get(globalIterator).getLexeme().equals("is")) {
            globalIterator++;
            Tree types = checkExp(new ArrayList<Token>());
            String type = foundType(types);
            if (type != null){
                variables.put(tokens.get(ind).getLexeme(), new Variable(tokens.get(ind),type));
            }
            else{
                return Integer.toString(tokens.get(globalIterator).getRow());
            }
        }
        else if (tokens.get(globalIterator).getLexeme().equals(":")) {
            globalIterator++;
            String oType = hardType();
            globalIterator++;
            Tree types = checkExp(new ArrayList<Token>());
            String type = foundType(types);
            if (type != null && type == oType){
                variables.put(tokens.get(ind).getLexeme(), new Variable(tokens.get(ind),type));
            }
            else{
                return Integer.toString(tokens.get(globalIterator).getColumn());
            }
        }
        else if (tokens.get(globalIterator).getLexeme().equals(":=")) {
            if (variables.get(tokens.get(ind).getLexeme()) == null){
                return  Integer.toString(tokens.get(globalIterator).getColumn());
            }
            Variable oType = variables.get(tokens.get(ind).getLexeme());
            globalIterator++;
            Tree types = checkExp(new ArrayList<Token>());
            String type = foundType(types);
            if (type != null && type == oType.getType()){
                return null;
                //variables.put(tokens.get(ind).getLexeme(), new Variable(tokens.get(ind),type));
            }
            else{
                return Integer.toString(tokens.get(globalIterator).getColumn());
            }
        }
        return null;
    }

    public Tree checkExp(ArrayList<Token> expTokens){
        if (expTokens.size() == 0){
            int localIt = globalIterator;
            while (!tokens.get(localIt).getLexeme().equals(";")) {
                expTokens.add(tokens.get(localIt));
                localIt++;
            }
            globalIterator = localIt;
        }
        Tree tree = new Tree();
        for (int i = 0; i < expTokens.size(); i++) {
            String t = expTokens.get(i).getLexeme();
            if (t.equals("&") || t.equals("|") || t.equals("^")) {
                tree.setValue(expTokens.get(i));
                tree.setLeft(checkExp(new ArrayList<Token>(expTokens.subList(0, i))));
                tree.setRight(checkExp(new ArrayList<Token>(expTokens.subList(i + 1, expTokens.size()))));
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            String t = expTokens.get(i).getLexeme();
            if (t.equals("<") || t.equals("<=") || t.equals(">") || t.equals(">=") || t.equals("=") || t.equals("/=")) {
                tree.setValue(expTokens.get(i));
                tree.setLeft(checkExp(new ArrayList<Token>(expTokens.subList(0, i))));
                tree.setRight(checkExp(new ArrayList<Token>(expTokens.subList(i + 1, expTokens.size()))));
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            String t = expTokens.get(i).getLexeme();
            if (t.equals("-") || t.equals("+")) {
                tree.setValue(expTokens.get(i));
                tree.setLeft(checkExp(new ArrayList<Token>( expTokens.subList(0, i))));
                tree.setRight(checkExp(new ArrayList<Token>( expTokens.subList(i + 1, expTokens.size()))));
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            String t = expTokens.get(i).getLexeme();
            if (t.equals("*") || t.equals("/")) {
                tree.setValue(expTokens.get(i));
                tree.setLeft(checkExp(new ArrayList<Token>(expTokens.subList(0, i))));
                tree.setRight(checkExp(new ArrayList<Token>(expTokens.subList(i + 1, expTokens.size()))));
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            String t = expTokens.get(i).getLexeme();
            if (t.equals("(") && i>0 && !expTokens.get(i-1).getLexeme().equals("func")) {
                for (int j=0; j<expTokens.size(); j++)
                    if (expTokens.get(j).getLexeme().equals(")")) {
                        tree.setValue(expTokens.get(i));
                        tree.setLeft(checkExp(new ArrayList<Token>(expTokens.subList(i + 1, j))));
                    }
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            String t = expTokens.get(i).getLexeme();
            if (t.equals("func")){
                tree.setValue(expTokens.get(i));
                tree.setLeft(checkFunction( new ArrayList<Token>(expTokens.subList(i + 1, expTokens.size()))));
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            String t = expTokens.get(i).getLexeme();
            if (expTokens.get(i).getType().name().equals("IDENTIFIER") || expTokens.get(i).getType().name().equals("INTEGER") ||
                    expTokens.get(i).getType().name().equals("REAL_NUMBER")) { //TODO add all types
                tree.setValue(expTokens.get(i));
                return tree;
            }
        }
        return null;
    }

    public Tree checkFunction(ArrayList<Token> expTokens){
        return new Tree();
    }

    public String foundType(Tree tree){
        Token t = tree.getValue();
        if (t.getType().name().equals("IDENTIFIER")){
            if (variables.get(t.getLexeme()) != null)
                return variables.get(t.getLexeme()).getType();
            else
                return null;
        }
        if(t.getType().name().equals("INTEGER") ||
                t.getType().name().equals("REAL_NUMBER")){
            return t.getType().name(); //TODO all types
        }
        if (t.getType().name().equals("OPERATOR")){
            String left = foundType(tree.getLeft());
            String right = foundType(tree.getRight());
            if (right == null || left == null){
                return null;
            }
            return answerType(t.getLexeme(), left, right);
        }
        return "";
    }

    public String answerType(String type, String left, String right){
        if (type == "+" || type == "-" || type == "*"){
            if (right == "COMPLEX_NUMBER" || left == "COMPLEX_NUMBER"){
                return "COMPLEX_NUMBER";
            }
            if (right == "RATIONAL_NUMBER" || left == "RATIONAL_NUMBER"){
                return "RATIONAL_NUMBER"; //TODO rational only with rational or int
            }
            if (right == "REAL_NUMBER" || left == "REAL_NUMBER"){
                return "REAL_NUMBER";
            }
            if (right == "INTEGER" && left == "INTEGER"){
                return "INTEGER";
            }
        }
        if (type == "/"){
            if (right == "COMPLEX_NUMBER" || left == "COMPLEX_NUMBER"){
                return "COMPLEX_NUMBER"; //TODO */comp
            }
            if (right == "RATIONAL_NUMBER" || left == "RATIONAL_NUMBER"){
                return "RATIONAL_NUMBER"; //TODO rational only with rational or int
            }
            if (right == "REAL_NUMBER" || left == "REAL_NUMBER"){
                return "REAL_NUMBER";
            }
            if (right == "INTEGER" && left == "INTEGER"){
                return "REAL_NUMBER";
            }
        }
        if (type == "<" || type == "<=" || type == ">" || type == ">=" || type == "=" || type == "/="){
            return "BOOLEAN";
        }

        if (type == "&" || type == "|" || type == "^" ){
            if (right == "BOOLEAN" && left == "BOOLEAN")
                return "BOOLEAN";
        }
        return "";
    }

    //TODO govnokod tolko dlya prostix tipov
    public String hardType(){
        if (tokens.get(globalIterator).getLexeme().equals("integer")){
            return "INTEGER";
        }
        if (tokens.get(globalIterator).getLexeme().equals("boolean")){
            return "BOOLEAN";
        }
        if (tokens.get(globalIterator).getLexeme().equals("real")){
            return "REAL_NUMBER";
        }
        if (tokens.get(globalIterator).getLexeme().equals("rational")){
            return "RATIONAL_NUMBER";
        }
        if (tokens.get(globalIterator).getLexeme().equals("complex")){
            return "COMPLEX_NUMBER";
        }
        if (tokens.get(globalIterator).getLexeme().equals("string")){
            return "STRING";
        }
        return "";
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
