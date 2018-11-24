package parser;

import java.util.ArrayList;

public class Parser {
    private ArrayList<String> tokens;
    private int globalIterator;

    public Parser(ArrayList<String> tokens) {
        this.tokens = tokens;
        this.globalIterator = -1;
    }

    public Tree parse() {
        globalIterator++;
        return program();
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
            while (tokens.get(globalIterator).equals(";")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(declaration());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
                right = rightmost(right);
                globalIterator++;
            }
            globalIterator--;
            return new Tree(left, local, null);
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree declaration() {
        int localIterator = globalIterator;
        Tree left = identifier();
        if (left != null) {
            Tree local = new Tree();
            Tree right = new Tree();
            local.setRight(right);
            globalIterator++;
            if (tokens.get(globalIterator).equals(":")) {
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
            if (tokens.get(globalIterator).equals("is")) {
                right.setValue(tokens.get(globalIterator));
                localIterator = globalIterator;
                right.setRight(expression());
                if (right.getRight() == null) {
                    globalIterator = localIterator;
                    return null;
                }
                return new Tree(left, local, null);
            }
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
            while (tokens.get(globalIterator).equals(",")) {
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
            if (tokens.get(globalIterator).equals("and") || tokens.get(globalIterator).equals("or") ||
                    tokens.get(globalIterator).equals("xor")) {
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
            if (tokens.get(globalIterator).equals("<") || tokens.get(globalIterator).equals("<=") ||
                    tokens.get(globalIterator).equals(">") || tokens.get(globalIterator).equals(">=") ||
                    tokens.get(globalIterator).equals("=") || tokens.get(globalIterator).equals("/=")) {
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
            while (tokens.get(globalIterator).equals("+") || tokens.get(globalIterator).equals("-")) {
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
            while (tokens.get(globalIterator).equals("*") || tokens.get(globalIterator).equals("/")) {
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
        if (tokens.get(globalIterator).equals("+") || tokens.get(globalIterator).equals("-")) {
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
        if (tokens.get(globalIterator).equals("(")) {
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
            if (tokens.get(globalIterator).equals(")")) {
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
        if (tokens.get(globalIterator).equals("(")) {
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
            if (tokens.get(globalIterator).equals(")")) {
                right.setValue(tokens.get(globalIterator));
                return local;
            }
            globalIterator--;
            return null;
        }
        if (tokens.get(globalIterator).equals("[")) {
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
            if (tokens.get(globalIterator).equals("]")) {
                right.setValue(tokens.get(globalIterator));
                return local;
            }
            globalIterator--;
            return null;
        }
        if (tokens.get(globalIterator).equals(".")) {
            Tree local = new Tree();
            local.setValue(tokens.get(globalIterator));
            Tree right = new Tree();
            local.setRight(right);
            localIterator = globalIterator;
            right.setLeft(identifier());
            if (right.getLeft() == null) {
                globalIterator = localIterator;
            }
            right.setLeft(integerLiteral());
            if (right.getLeft() == null) {
                globalIterator = localIterator;
                return null;
            }
            return local;
        }
        globalIterator--;
        return null;
    }

    private Tree elementary() {
        int localIterator = globalIterator;
        globalIterator++;
        if (tokens.get(globalIterator).equals("false") || tokens.get(globalIterator).equals("true")) {
            return new Tree(null, null, tokens.get(globalIterator));
        }
        globalIterator--;
        Tree local = integerLiteral();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        local = realLiteral();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        local = rationalLiteral();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        local = complexLiteral();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        local = stringLiteral();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        local = identifier();
        if (local != null) {
            return local;
        }
        globalIterator = localIterator;
        return null;
    }

    private Tree function() {
        int localIterator = globalIterator;
        Tree local = new Tree();
        globalIterator++;
        if (tokens.get(globalIterator).equals("func")) {
            globalIterator++;
            if (tokens.get(globalIterator).equals("(")) {
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
                if (tokens.get(globalIterator).equals(")")) {
                    local.setValue(tokens.get(globalIterator));
                    globalIterator++;
                    if (tokens.get(globalIterator).equals(":")) {
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
            while (tokens.get(globalIterator).equals(",")) {
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
        if (tokens.get(globalIterator).equals("do")) {
            local.setValue(tokens.get(globalIterator));
            local.setRight(new Tree());
            localIterator = globalIterator;
            local.getRight().setLeft(statements());
            if (local.getRight().getLeft() == null) {
                globalIterator = localIterator;
                return null;
            }
            globalIterator++;
            if (tokens.get(globalIterator).equals("end")) {
                local.getRight().setValue(tokens.get(globalIterator));
                return local;
            }
            globalIterator--;
        }
        if (tokens.get(globalIterator).equals("=>")) {
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
        if (tokens.get(globalIterator).equals("[")) {
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
            while (tokens.get(globalIterator).equals(",")) {
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
        Tree local = identifier();
        if (local != null) {
            globalIterator++;
            if (tokens.get(globalIterator).equals("is")) {
                String value = tokens.get(globalIterator);
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
        localIterator = globalIterator;
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
        if (tokens.get(globalIterator).equals("[")) {
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
            while (tokens.get(globalIterator).equals(",")) {
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
}
