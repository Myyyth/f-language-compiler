package parser;

import lexer.Token;

public class Tree {
    private Tree left;
    private Tree right;
    private Token value;

    public Tree(parser.Tree left, parser.Tree right, Token value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Tree() {

    }

    public parser.Tree getLeft() {
        return left;
    }

    public void setLeft(parser.Tree left) {
        this.left = left;
    }

    public parser.Tree getRight() {
        return right;
    }

    public void setRight(parser.Tree right) {
        this.right = right;
    }

    public Token getValue() {
        return value;
    }

    public void setValue(Token value) {
        this.value = value;
    }
}
