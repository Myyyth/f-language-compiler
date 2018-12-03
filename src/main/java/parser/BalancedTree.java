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

    private void insert(Node node, Token token) {
        if (node.getValue() == null && (node.getLeft() == null || node.getLeft().getValue() != null)) {
            node.setValue(token);
        } else {
            if (node.getValue() == null && node.getLeft() != null) {
                insert(node.getLeft(), token);
            } else {
                if (node.getValue() != null && (node.getRight() != null && node.getRight().getValue() == null)) {
                    insert(node.getRight(), token);
                } else {
                    if (node.parent != null) {
                        insert(node.parent, token);
                    }
                }
            }
        }
    }

    private void insertRight(Token token) {
        Node temp = root.getRight();
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        insert(temp, token);
    }

    public Node getRoot() {
        return root;
    }

    public int getHeight() {
        return height;
    }
}
