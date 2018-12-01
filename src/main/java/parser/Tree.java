package parser;

public class Tree {
    private Tree left;
    private Tree right;
    private String value;

    public Tree(parser.Tree left, parser.Tree right, String value) {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
