package parser;

import lexer.Token;

public class BalancedTree {
    public class Node {
        private Node left;
        private Node right;
        private Token value;
        private Node parent;

        private Node(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        private void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        private void setRight(Node right) {
            this.right = right;
        }

        public Token getValue() {
            return value;
        }

        private void setValue(Token value) {
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

        private void setParent(Node parent) {
            this.parent = parent;
        }
    }

    private Node root;
    private int height;
    private Node nextInsert;

    public BalancedTree(int height) {
        this.height = height;
        for (int i = 0; i < height; i++) {
            if (root == null) {
                root = new Node(null);
            } else {
                createEmptyChildren(root);
            }
        }
    }

    private void createEmptyChildren(Node node) {
        if (node.getLeft() != null) {
            createEmptyChildren(node.getLeft());
        } else {
            node.setLeft(new Node(node));
        }
        if (node.getRight() != null) {
            createEmptyChildren(node.getRight());
        } else {
            node.setRight(new Node(node));
        }
    }

    public void insert(Token token) {
        Node temp = root;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        insert(temp, token);
    }

    private Node leftmost(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private void insert(Node node, Token token) {
        if (node.getLeft() == null && node.getValue() == null) {
            node.setValue(token);
        } else {
            if (node.getLeft().getValue() != null && leftmost(node.getRight()).getValue() == null) {
                node.setValue(token);
            } else {

            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public int getHeight() {
        return height;
    }
}
