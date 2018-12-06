package parser;

import java.util.ArrayList;
import lexer.Token;

public class Parser {
    private ArrayList<Token> tokens;
    private int globalIterator;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.globalIterator = -1;
    }

    public BalancedTree parse() {
        deleteWhitespaces();
        Tree tree = program();
        /*BalancedTree balanced = new BalancedTree((int)Math.ceil(Math.log(tokens.size()) / Math.log(2)));
        if (tree != null) {
            for (Token token: tokens) {
                if (token.getLexeme().equals("+")) {
                    System.out.println("");
                }
                balanced.insert(token);
            }
        }*/
        return tree;
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

    private Tree rightmost(Tree tree) {
        while (tree.getRight() != null) {
            tree = tree.getRight();
        }
        return tree;
    }

    private Tree program() {
        int localIterator = globalIterator;
        Tree left = declaration();
        if (left != null) {
            Tree local = new Tree();
            Tree right = new Tree();
            local.setRight(right);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            while (tokens.get(globalIterator).getLexeme().equals(";")) {
                right.setValue(tokens.get(globalIterator));
                if (globalIterator >= tokens.size() - 1) {
                    break;
                }
                localIterator = globalIterator;
                right.setRight(declaration());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
                right = rightmost(right);
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
            }
            globalIterator--;
            return new Tree(left, local, null);
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree declaration() {
        int localIterator = globalIterator;
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getType() == Token.TokenType.IDENTIFIER) {
            Tree left = new Tree(null, null, tokens.get(globalIterator));
            Tree local = new Tree();
            Tree right = new Tree();
            local.setRight(right);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals(":")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(type());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
                right = rightmost(right);
            } else {
                globalIterator--;
            }
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals("is")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(expression());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
                return new Tree(left, local, null);
            }
            globalIterator--;
            return new Tree(left, local, null);
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree expressions() {
        int localIterator = globalIterator;
        Tree left = expression();
        if (left != null) {
            Tree local = new Tree();
            Tree right = new Tree();
            local.setRight(right);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            while (tokens.get(globalIterator).getLexeme().equals(",")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(expression());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
                right = rightmost(right);
                right.setRight(new Tree());
                right = right.getRight();
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
            }
            globalIterator--;
            return new Tree(left, local, null);
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree expression() {
        int localIterator = globalIterator;
        Tree left = relation();
        if (left != null) {
            Tree right = new Tree();
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals("and") || tokens.get(globalIterator).getLexeme().equals("or") ||
                    tokens.get(globalIterator).getLexeme().equals("xor")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(relation());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
            } else {
                globalIterator--;
                return left;
            }
            return new Tree(left, right, null);

        }
        globalIterator = localIterator;
        return null;
    }

    private Tree relation() {
        int localIterator = globalIterator;
        Tree left = factor();
        if (left != null) {
            Tree right = new Tree();
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals("<") || tokens.get(globalIterator).getLexeme().equals("<=") ||
                    tokens.get(globalIterator).getLexeme().equals(">") || tokens.get(globalIterator).getLexeme().equals(">=") ||
                    tokens.get(globalIterator).getLexeme().equals("=") || tokens.get(globalIterator).getLexeme().equals("/=")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(factor());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
            } else {
                globalIterator--;
                return left;
            }
            return new Tree(left, right, null);
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree factor() {
        int localIterator = globalIterator;
        Tree left = term();
        if (left != null) {
            Tree local = new Tree();
            Tree right = new Tree();
            local.setRight(right);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            while (tokens.get(globalIterator).getLexeme().equals("+") || tokens.get(globalIterator).getLexeme().equals("-")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(term());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                } else {
                    right = rightmost(right);
                    right.setRight(new Tree());
                    right = right.getRight();
                }
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
            }
            globalIterator--;
            return new Tree(left, right, null);
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree term() {
        int localIterator = globalIterator;
        Tree left = unary();
        if (left != null) {
            Tree local = new Tree();
            Tree right = new Tree();
            local.setRight(right);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            while (tokens.get(globalIterator).getLexeme().equals("*") || tokens.get(globalIterator).getLexeme().equals("/")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(unary());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                } else {
                    right = rightmost(right);
                    right.setRight(new Tree());
                    right = right.getRight();
                }
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
            }
            globalIterator--;
            return new Tree(left, right, null);
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree unary() {
        int localIterator = globalIterator;
        Tree local = new Tree();
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("+") || tokens.get(globalIterator).getLexeme().equals("-")) {
            local.setValue(tokens.get(globalIterator));
        } else {
            globalIterator--;
        }
        localIterator = globalIterator;
        local.setRight(secondary());
        if (local.getRight() == null) {
            globalIterator = localIterator;
            return null;
        }
        return local;
    }

    private Tree secondary() {
        int localIterator = globalIterator;
        Tree left = primary();
        if (left != null) {
            Tree local = new Tree();
            Tree right = new Tree();
            local.setRight(right);
            localIterator = globalIterator;
            Tree temp = tail();
            while (temp != null) {
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
                right.setRight(temp);
                right = rightmost(right);
                localIterator = globalIterator;
                temp = tail();
            }
            globalIterator = localIterator;
            return new Tree(left, local, null);
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree primary() {
        int localIterator = globalIterator;
        Tree left = elementary();
        if (left != null) {
            return left;
        } else {
            globalIterator = localIterator;
        }
        left = function();
        if (left != null) {
            return left;
        } else {
            globalIterator = localIterator;
        }
        left = tuple();
        if (left != null) {
            return left;
        } else {
            globalIterator = localIterator;
        }
        left = map();
        if (left != null) {
            return left;
        } else {
            globalIterator = localIterator;
        }
        left = list();
        if (left != null) {
            return left;
        } else {
            globalIterator = localIterator;
        }
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("(")) {
            Tree local = new Tree();
            local.setValue(tokens.get(globalIterator));
            Tree right = new Tree();
            local.setRight(right);
            localIterator = globalIterator;
            right.setLeft(expression());
            if (right.getLeft() == null) {
                globalIterator = localIterator;
                globalIterator--;
                return null;
            }
            globalIterator++;
            if (tokens.get(globalIterator).getLexeme().equals(")")) {
                right.setValue(tokens.get(globalIterator));
                return local;
            }
            globalIterator--;
            return null;
        }
        globalIterator--;
        return null;
    }

    private Tree tail() {
        int localIterator = globalIterator;
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("(")) {
            Tree local = new Tree();
            local.setValue(tokens.get(globalIterator));
            Tree right = new Tree();
            local.setRight(right);
            localIterator = globalIterator;
            right.setLeft(expressions());
            if (right.getLeft() == null) {
                globalIterator = localIterator;
            }
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals(")")) {
                right.setValue(tokens.get(globalIterator));
                return local;
            }
            globalIterator--;
            return null;
        }
        if (tokens.get(globalIterator).getLexeme().equals("[")) {
            Tree local = new Tree();
            local.setValue(tokens.get(globalIterator));
            Tree right = new Tree();
            local.setRight(right);
            localIterator = globalIterator;
            right.setLeft(expression());
            if (right.getLeft() == null) {
                globalIterator = localIterator;
                return null;
            }
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals("]")) {
                right.setValue(tokens.get(globalIterator));
                return local;
            }
            globalIterator--;
            return null;
        }
        if (tokens.get(globalIterator).getLexeme().equals(".")) {
            Tree local = new Tree();
            local.setValue(tokens.get(globalIterator));
            Tree right = new Tree();
            local.setRight(right);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getType() != Token.TokenType.IDENTIFIER) {
                globalIterator--;
            } else {
                right.setLeft(new Tree(null, null, tokens.get(globalIterator)));
                return local;
            }
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getType() != Token.TokenType.INTEGER) {
                globalIterator--;
                return null;
            } else {
                right.setLeft(new Tree(null, null, tokens.get(globalIterator)));
                return local;
            }
        }
        globalIterator--;
        return null;
    }

    private Tree elementary() {
        int localIterator = globalIterator;
        globalIterator++;

        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("false") || tokens.get(globalIterator).getLexeme().equals("true")) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        if (tokens.get(globalIterator).getType() == Token.TokenType.INTEGER) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        if (tokens.get(globalIterator).getType() == Token.TokenType.REAL_NUMBER) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        if (tokens.get(globalIterator).getType() == Token.TokenType.RATIONAL_NUMBER) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        if (tokens.get(globalIterator).getType() == Token.TokenType.COMPLEX_NUMBER) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        if (tokens.get(globalIterator).getType() == Token.TokenType.STRING) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        if (tokens.get(globalIterator).getType() == Token.TokenType.IDENTIFIER) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        globalIterator--;
        return null;
    }

    private Tree function() {
        int localIterator = globalIterator;
        Tree local = new Tree();
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("func")) {
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals("(")) {
                local.setLeft(new Tree());
                local.getLeft().setLeft(new Tree());
                local.getLeft().getLeft().setValue(tokens.get(globalIterator-1));
                local.getLeft().setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                local.getLeft().setRight(parameters());
                if (local.getLeft().getRight() == null) {
                    globalIterator = localIterator;
                }
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
                if (tokens.get(globalIterator).getLexeme().equals(")")) {
                    local.setValue(tokens.get(globalIterator));
                    globalIterator++;
                    if (globalIterator >= tokens.size()) {
                        return new Tree();
                    }
                    if (tokens.get(globalIterator).getLexeme().equals(":")) {
                        Tree right = new Tree();
                        right.setValue(tokens.get(globalIterator));
                        right.setRight(new Tree());
                        localIterator = globalIterator;
                        right.getRight().setLeft(type());
                        if (right.getRight().getLeft() == null) {
                            globalIterator = localIterator;
                            return null;
                        }
                        localIterator = globalIterator;
                        right.getRight().setRight(body());
                        if (right.getRight().getRight() == null) {
                            globalIterator = localIterator;
                            return null;
                        }
                        return new Tree(local, right, null);
                    }
                    globalIterator--;
                    localIterator = globalIterator;
                    local.setRight(body());
                    if (local.getRight() == null) {
                        globalIterator = localIterator;
                        return null;
                    }
                    return local;
                }
                globalIterator--;
                return null;
            }
            globalIterator--;
            return null;
        }
        globalIterator--;
        return null;
    }

    private Tree parameters() {
        int localIterator = globalIterator;
        Tree left = declaration();
        if (left != null) {
            Tree local = new Tree();
            Tree right = new Tree();
            local.setRight(right);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            while (tokens.get(globalIterator).getLexeme().equals(",")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(declaration());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
                right = rightmost(right);
                right.setRight(new Tree());
                right = right.getRight();
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
            }
            globalIterator--;
            return new Tree(left, local, null);
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree body() {
        int localIterator = globalIterator;
        Tree local = new Tree();
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("do")) {
            local.setValue(tokens.get(globalIterator));
            local.setRight(new Tree());
            localIterator = globalIterator;
            local.getRight().setLeft(statements());
            if (local.getRight().getLeft() == null) {
                globalIterator = localIterator;
                return null;
            }
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals("end")) {
                local.getRight().setValue(tokens.get(globalIterator));
                return local;
            }
            globalIterator--;
        }
        if (tokens.get(globalIterator).getLexeme().equals("=>")) {
            local.setValue(tokens.get(globalIterator));
            localIterator = globalIterator;
            local.setRight(expression());
            if (local.getRight() == null) {
                globalIterator = localIterator;
                return null;
            }
            return local;
        }
        globalIterator--;
        return null;
    }

    private Tree tuple() {
        int localIterator = globalIterator;
        Tree local = new Tree();
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("[")) {
            local.setValue(tokens.get(globalIterator));
            Tree temp = new Tree();
            localIterator = globalIterator;
            temp.setLeft(tupleElement());
            if (temp.getLeft() == null) {
                globalIterator = localIterator;
            }
            Tree rightTemp = new Tree();
            temp.setRight(rightTemp);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            while (tokens.get(globalIterator).getLexeme().equals(",")) {
                rightTemp.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                rightTemp.setRight(tupleElement());
                if (rightTemp.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
                rightTemp = rightmost(rightTemp);
                rightTemp.setRight(new Tree());
                rightTemp = rightTemp.getRight();
            }
            globalIterator--;
            return new Tree(local, temp, null);
        }
        globalIterator--;
        return null;
    }

    private Tree tupleElement() {
        int localIterator = globalIterator;
        Tree local = new Tree();
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getType() == Token.TokenType.IDENTIFIER) {
            local.setValue(tokens.get(globalIterator));
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals("is")) {
                Token value = tokens.get(globalIterator);
                localIterator = globalIterator;
                Tree temp = expression();
                if (temp != null) {
                    return new Tree(local, temp, value);
                }
                globalIterator = localIterator;
                return null;
            }
            globalIterator--;
        }
        globalIterator--;
        local = expression();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree map() {
        int localIterator = globalIterator;
        Tree local = new Tree();
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("[")) {
            local.setValue(tokens.get(globalIterator));
            Tree temp = new Tree();
            localIterator = globalIterator;
            temp.setLeft(mapElement());
            if (temp.getLeft() == null) {
                globalIterator = localIterator;
            }
            Tree rightTemp = new Tree();
            temp.setRight(rightTemp);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            while (tokens.get(globalIterator).getLexeme().equals(",")) {
                rightTemp.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                rightTemp.setRight(mapElement());
                if (rightTemp.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
                rightTemp = rightmost(rightTemp);
                rightTemp.setRight(new Tree());
                rightTemp = rightTemp.getRight();
            }
            globalIterator--;
            return new Tree(local, temp, null);
        }
        globalIterator--;
        return null;
    }

    private Tree mapElement() {
        int localIterator = globalIterator;
        Tree left = expression();
        if (left == null) {
            globalIterator = localIterator;
            return null;
        }
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals(":")) {
            Token value = tokens.get(globalIterator);
            localIterator = globalIterator;
            Tree right = expression();
            if (right != null) {
                return new Tree(left, right, value);
            }
            globalIterator = localIterator;
        }
        globalIterator--;
        return null;
    }

    private Tree list() {
        int localIterator = globalIterator;
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("(")) {
            Token value = tokens.get(globalIterator);
            localIterator = globalIterator;
            Tree local = new Tree();
            Tree left = expression();
            if (left == null) {
                globalIterator = localIterator;
            }
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals(")")) {
                local.setLeft(left);
                local.setValue(tokens.get(globalIterator));
                return new Tree(null, local, value);
            }
            globalIterator--;
            return null;
        }
        globalIterator--;
        return null;
    }

    private Tree type() {
        int localIterator = globalIterator;
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getType() == Token.TokenType.BOOLEAN || tokens.get(globalIterator).getLexeme().equals("integer") ||
                tokens.get(globalIterator).getLexeme().equals("real")) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        if (tokens.get(globalIterator).getLexeme().equals("rational") || tokens.get(globalIterator).getLexeme().equals("complex") ||
                tokens.get(globalIterator).getLexeme().equals("string")) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        if (tokens.get(globalIterator).getLexeme().equals("func")) {
            Tree local = new Tree();
            local.setLeft(new Tree(null, null, tokens.get(globalIterator)));
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals("(")) {
                local.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                Tree localRight = type();
                local.setRight(localRight);
                if (localRight == null) {
                    globalIterator = localIterator;
                } else {
                    globalIterator++;
                    if (globalIterator >= tokens.size()) {
                        return new Tree();
                    }
                    while (tokens.get(globalIterator).getLexeme().equals(",")) {
                        localRight = rightmost(local);
                        localIterator = globalIterator;
                        localRight.setRight(type());
                        if (localRight.getRight() == null) {
                            globalIterator = localIterator;
                            return null;
                        }
                        globalIterator++;
                        if (globalIterator >= tokens.size()) {
                            return new Tree();
                        }
                    }
                    globalIterator--;
                }
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
                if (tokens.get(globalIterator).getLexeme().equals(")")) {
                    local = new Tree(local, null, tokens.get(globalIterator));
                    Tree rightLocal = new Tree();
                    globalIterator++;
                    if (globalIterator >= tokens.size()) {
                        return new Tree();
                    }
                    if (tokens.get(globalIterator).getLexeme().equals(":")) {
                        rightLocal.setValue(tokens.get(globalIterator));
                        localIterator = globalIterator;
                        rightLocal.setRight(type());
                        if (rightLocal.getRight() == null) {
                            globalIterator = localIterator;
                            return null;
                        }
                        local.setRight(rightLocal);
                    }
                    globalIterator--;
                    return local;
                }
                globalIterator--;
                return null;
            }
            globalIterator--;
            return null;
        }
        if (tokens.get(globalIterator).getLexeme().equals("{")) {
            Tree temp = new Tree(null, null, tokens.get(globalIterator));
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals("}")) {
                return new Tree(temp, null, tokens.get(globalIterator));
            }
            globalIterator--;
            return null;
        }
        if (tokens.get(globalIterator).getLexeme().equals("[")) {
            Token value = tokens.get(globalIterator);
            localIterator = globalIterator;
            Tree right = type();
            if (right == null) {
                globalIterator = localIterator;
                return null;
            }
            Tree local = new Tree();
            local.setLeft(new Tree(null, right, value));
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals(":")) {
                local.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right = type();
                if (right == null) {
                    globalIterator = localIterator;
                    return null;
                }
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
                if (tokens.get(globalIterator).getLexeme().equals("]")) {
                    local.setRight(new Tree(right, null, tokens.get(globalIterator)));
                    return local;
                }
                globalIterator--;
                return null;
            }
            globalIterator--;
            return null;
        }
        if (tokens.get(globalIterator).getLexeme().equals("(")) {
            Token value = tokens.get(globalIterator);
            localIterator = globalIterator;
            Tree right = type();
            if (right == null) {
                globalIterator = localIterator;
                return null;
            }
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals(")")) {
                return new Tree(null, new Tree(right, null, tokens.get(globalIterator)), value);
            }
        }
        globalIterator--;
        return null;
    }

    private Tree statements() {
        int localIterator = globalIterator;
        Tree left = statement();
        if (left != null) {
            Tree local = new Tree();
            Tree right = new Tree();
            local.setRight(right);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            while (tokens.get(globalIterator).getLexeme().equals(";")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(statement());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
                right = rightmost(right);
                right.setRight(new Tree());
                right = right.getRight();
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
            }
            globalIterator--;
            return new Tree(left, local, null);
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree statement() {
        int localIterator = globalIterator;
        Tree local = assignmentOrCall();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        local = conditional();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        local = loop();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        local = declaration();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("return")) {
            Token value = tokens.get(globalIterator);
            localIterator = globalIterator;
            Tree right = expression();
            if (right == null) {
                globalIterator = localIterator;
            }
            return new Tree(null, right, value);
        }
        if (tokens.get(globalIterator).getLexeme().equals("break")) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        globalIterator--;
        return null;
    }

    private Tree assignmentOrCall() {
        int localIterator = globalIterator;
        Tree left = secondary();
        if (left != null) {
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals(":=")) {
                Token value = tokens.get(globalIterator);
                localIterator = globalIterator;
                Tree right = expression();
                if (right == null) {
                    globalIterator = localIterator;
                    return null;
                }
                return new Tree(left, right, value);
            }
            globalIterator--;
            return left;
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree conditional() {
        int localIterator = globalIterator;
        globalIterator++;
        if (globalIterator >= tokens.size()) {
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("if")) {
            Token value = tokens.get(globalIterator);
            localIterator = globalIterator;
            Tree right = expression();
            if (right == null) {
                globalIterator = localIterator;
                return null;
            }
            Tree leftLocal = new Tree(null, right, value);
            globalIterator++;
            if (globalIterator >= tokens.size()) {
                return new Tree();
            }
            if (tokens.get(globalIterator).getLexeme().equals("then")) {
                Tree local = new Tree(leftLocal, null, tokens.get(globalIterator));
                localIterator = globalIterator;
                right = statements();
                if (right == null) {
                    globalIterator = localIterator;
                    return null;
                }
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
                Tree rightLocal = new Tree(right, null, null);
                if (tokens.get(globalIterator).getLexeme().equals("else")) {
                    right.setValue(tokens.get(globalIterator));
                    localIterator = globalIterator;
                    right.setRight(statements());
                    if (right.getRight() == null) {
                        globalIterator = localIterator;
                        return null;
                    }
                } else {
                    globalIterator--;
                }
                globalIterator++;
                if (globalIterator >= tokens.size()) {
                    return new Tree();
                }
                if (tokens.get(globalIterator).getLexeme().equals("end")) {
                    rightLocal.setValue(tokens.get(globalIterator));
                    local.setRight(rightLocal);
                    globalIterator++;
                    if (tokens.get(globalIterator).getLexeme().equals(";")) {
                        return local;
                    }
                    globalIterator--;
                    return local;
                }
                globalIterator--;
                return null;
            }
            globalIterator--;
            return null;
        }
        globalIterator--;
        return null;
    }

    private Tree loop() {
        int localIterator = globalIterator;
        globalIterator++;
        if (tokens.get(globalIterator).getLexeme().equals("for")) {
            globalIterator++;
            if (tokens.get(globalIterator).getType() == Token.TokenType.IDENTIFIER) {
                globalIterator++;
                if (tokens.get(globalIterator).getLexeme().equals("in")) {
                } else {
                    globalIterator--;
                    return null;
                }
            } else {
                globalIterator--;
            }
            localIterator = globalIterator;
            if (expression() == null) {
                globalIterator = localIterator;
            }
            globalIterator++;
            if (tokens.get(globalIterator).getLexeme().equals("..")) {
                localIterator = globalIterator;
                if (expression() == null) {
                    globalIterator = localIterator;
                    return null;
                }
            } else {
                globalIterator--;
            }
            localIterator = globalIterator;
            if (loopBody() == null) {
                globalIterator = localIterator;
                return null;
            }
            return new Tree();
        }
        if (tokens.get(globalIterator).getLexeme().equals("while")) {
            localIterator = globalIterator;
            if (expression() == null) {
                globalIterator = localIterator;
                return null;
            }
        }
        globalIterator--;
        localIterator = globalIterator;
        if (loopBody() == null) {
            globalIterator = localIterator;
            return null;
        }
        return new Tree();
    }

    private Tree loopBody() {
        int localIterator = globalIterator;
        globalIterator++;
        if (tokens.get(globalIterator).getLexeme().equals("loop")) {
            localIterator = globalIterator;
            if (statements() == null) {
                globalIterator = localIterator;
                return null;
            }
            globalIterator++;
            if (tokens.get(globalIterator).getLexeme().equals("end")) {
                globalIterator++;
                if (tokens.get(globalIterator).getLexeme().equals(";")) {
                    return new Tree();
                }
                globalIterator--;
                return new Tree();
            }
            globalIterator--;
            return null;
        }
        globalIterator--;
        return null;
    }
}
