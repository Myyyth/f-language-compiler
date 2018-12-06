package semantic;

import semantic.Variable;
import lexer.Token;
import parser.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Semantic {
    private ArrayList<Token> tokens;
    private int globalIterator;
    private Map<String, Variable> variables;
    private ArrayList<String> input = new ArrayList<String>();
    private Map<String, Variable> funcVariables = new HashMap<String, Variable>();

    public Semantic(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.globalIterator = 0;
        this.variables = new HashMap<String, Variable>();
        addFunctions();

    }

    public String analyze() throws Exception {
        deleteWhitespaces();
        while (globalIterator < tokens.size()) {
            if (tokens.get(globalIterator).getType().name().equals("IDENTIFIER")) {
                String msg = checkInd();
                if (msg != null) {
//                    System.out.println("y Bac oLLlu6Ka Ha CTPOKE HOMEP " + msg);
//                    System.exit(2);
                    throw  new Exception("y Bac oLLlu6Ka Ha CTPOKE HOMEP " + msg);
                }
            } else {
                globalIterator++;
            }
        }
        return "";
    }

    private String checkInd() throws Exception {
        int ind = globalIterator;
        globalIterator++;
        if (tokens.get(globalIterator).getLexeme().equals("is")) {
            globalIterator++;
            Tree types = checkExp(new ArrayList<Token>());
            if (types == null) {
                throw  new Exception("y Bac oLLlu6Ka Ha CTPOKE HOMEP " + Integer.toString(tokens.get(globalIterator).getRow() + 1));
            }
            String type = foundType(types);
            if (type != null) {
                if (variables.get(tokens.get(ind).getLexeme()) == null)
                    if (tokens.get(ind).getType().name() != "TYPE") {
                        variables.put(tokens.get(ind).getLexeme(), new Variable(tokens.get(ind), type));
                    } else {
                        return type;
                    }
            } else {
                throw  new Exception("y Bac oLLlu6Ka Ha CTPOKE HOMEP " + Integer.toString(tokens.get(globalIterator).getRow() + 1));
            }
        } else if (tokens.get(globalIterator).getLexeme().equals(":")) {
            if (variables.get(tokens.get(globalIterator - 1).getLexeme()) != null) {
                throw  new Exception("y Bac oLLlu6Ka Ha CTPOKE HOMEP " + Integer.toString(tokens.get(globalIterator-1).getRow() + 1));
            }
            globalIterator++;
            String oType = hardType(tokens.get(globalIterator).getLexeme());
            globalIterator += 2;
            Tree types = checkExp(new ArrayList<Token>());
            if (types == null) {
                throw  new Exception("y Bac oLLlu6Ka Ha CTPOKE HOMEP " + Integer.toString(tokens.get(globalIterator).getRow() + 1));
            }
            String type = foundType(types);
            if (type != null && ((type.equals(oType) || (oType.equals("REAL_NUMBER") && type.equals("INTEGER"))))) {
                if (input.size() == 0) {
                    variables.put(tokens.get(ind).getLexeme(), new Variable(tokens.get(ind), type));
                } else {
                    return type;
                }
            } else {
                throw  new Exception("y Bac oLLlu6Ka Ha CTPOKE HOMEP " + Integer.toString(tokens.get(globalIterator).getRow() + 1));
            }
        } else if (tokens.get(globalIterator).getLexeme().equals(":=")) {
            if (variables.get(tokens.get(ind).getLexeme()) == null) {
                throw  new Exception("y Bac oLLlu6Ka Ha CTPOKE HOMEP " + Integer.toString(tokens.get(globalIterator).getRow() + 1));
            }
            String oType = variables.get(tokens.get(ind).getLexeme()).getType();
            globalIterator++;
            Tree types = checkExp(new ArrayList<Token>());
            if (types == null) {
                throw  new Exception("y Bac oLLlu6Ka Ha CTPOKE HOMEP " + Integer.toString(tokens.get(globalIterator).getRow() + 1));
            }
            String type = foundType(types);
            if (type != null && ((type.equals(oType) || (oType.equals("REAL_NUMBER") && type.equals("INTEGER"))))) {
                return null;
            } else {
                throw  new Exception("y Bac oLLlu6Ka Ha CTPOKE HOMEP " + Integer.toString(tokens.get(globalIterator).getRow() + 1));
            }
        }
        return null;
    }

    public Tree checkExp(ArrayList<Token> expTokens) throws Exception {
        if (tokens.get(globalIterator).getLexeme().equals("func")) {
            return checkFunction();
        }
        if (expTokens.size() == 0) {
            int localIt = globalIterator;
            while (!tokens.get(localIt).getLexeme().equals(";") && tokens.size() - 1 > localIt) {
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
                tree.setLeft(checkExp(new ArrayList<Token>(expTokens.subList(0, i))));
                tree.setRight(checkExp(new ArrayList<Token>(expTokens.subList(i + 1, expTokens.size()))));
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
            if (t.equals("(") && i > 0 && !expTokens.get(i - 1).getType().name().equals("IDENTIFIER")) {
                for (int j = 0; j < expTokens.size(); j++)
                    if (expTokens.get(j).getLexeme().equals(")")) {
                        tree.setValue(expTokens.get(i));
                        tree.setLeft(checkExp(new ArrayList<Token>(expTokens.subList(i + 1, j))));
                    }
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            String t = expTokens.get(i).getLexeme();
            if (expTokens.get(i).getType().name().equals("IDENTIFIER") &&
                    i != expTokens.size() - 1 && expTokens.get(i + 1).getLexeme().equals("(")) {
                Token val = expTokens.get(i);
                i += 2;
                ArrayList<String> input = new ArrayList<String>();
                while (!expTokens.get(i).getLexeme().equals(")")) {
                    if (expTokens.get(i).getLexeme().equals(",")) {
                        i++;
                        continue;
                    }
                    if (expTokens.get(i).getType().name().equals("IDENTIFIER")) {
                        if (variables.get(expTokens.get(i).getLexeme()) != null)
                            input.add(variables.get(expTokens.get(i).getLexeme()).getType());
                        else {
                            throw new Exception("y Bac oLLlu6Ka(HeOnPEgE/|EHHA9 nEPEMEHHA9) Ha CTPOKE HOMEP " +
                                    Integer.toString(expTokens.get(i).getRow() + 1));
                        }
                    } else {
                        input.add(expTokens.get(i).getType().name());
                    }
                    i++;
                }
                int h = 0;
                ArrayList<String> predInput = null;
                if (val.getLexeme().equals("compl")) {
                    if (input.size() == 1) {
                        if (input.get(0) == "INTEGER" || input.get(0) == "REAL_NUMBER") {
                            predInput = input;
                        }
                    } else if (input.size() == 2) {
                        if ((input.get(0) == "INTEGER" && input.get(1) == "REAL_NUMBER") ||
                                (input.get(0) == "INTEGER" && input.get(1) == "INTEGER") ||
                                (input.get(0) == "REAL_NUMBER" && input.get(1) == "REAL_NUMBER") ||
                                (input.get(0) == "REAL_NUMBER" && input.get(1) == "INTEGER")) {
                            predInput = input;
                        }
                    }
                } else if (val.getLexeme().equals("rat")) {
                    if (input.size() == 1) {
                        if (input.get(0) == "INTEGER") {
                            predInput = input;
                        }
                    } else if (input.size() == 2) {
                        if ((input.get(0) == "INTEGER" && input.get(1) == "INTEGER")) {
                            predInput = input;
                        }
                    }
                } else if (val.getLexeme().equals("round")) {
                    if (input.size() == 1) {
                        if (input.get(0) == "REAL_NUMBER") {
                            predInput = input;
                            variables.put("round", new Variable(null, "INTEGER"));
                        } else if (input.get(0) == "RATIONAL_NUMBER") {
                            predInput = input;
                            variables.put("round", new Variable(null, "REAL_NUMBER"));
                        }
                    }
                } else if (val.getLexeme().equals("length")) {
                    if (input.size() == 1) {
                        if (input.get(0).substring(0, 5) == "ARRAY") {
                            predInput = input;
                            variables.put("length", new Variable(null, "INTEGER"));
                        }
                    }
                }
                if (predInput == null) {
                    if (variables.get(val.getLexeme()) != null && variables.get(val.getLexeme()).getInput() != null) {
                        predInput = variables.get(val.getLexeme()).getInput();
                    } else {
                        predInput = new ArrayList<String>();
                    }
                }
                if (input.size() == predInput.size()) {
                    for (int j = 0; j < input.size(); j++) {
                        if (input.get(j) != predInput.get(j)) {
                            throw  new Exception("y Bac oLLlu6Ka(HeCoBnageHue TunoB) Ha CTPOKE HOMEP " +
                                    Integer.toString(expTokens.get(globalIterator).getRow() + 1));
                        }
                    }
                } else {
                    throw  new Exception("y Bac oLLlu6Ka(HeCoBnageHue TunoB nAPAMETPOB u/|u uX ko/|u4ecTBa) Ha CTPOKE HOMEP " +
                            Integer.toString(expTokens.get(i).getRow() + 1));
                }
                tree.setValue(val);
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            int t = i;
            if (expTokens.get(i).getType().name().equals("IDENTIFIER") &&
                    i != expTokens.size() - 1 && expTokens.get(i + 1).getLexeme().equals("[")) {
                Token val = expTokens.get(i);
                i += 2;
                if (expTokens.get(i).getType().name().equals("IDENTIFIER")) {
                    if (!variables.get(expTokens.get(i).getLexeme()).getType().equals("INTEGER")) {
                        throw  new Exception("HenPaBu/|Huu` Tun uTePaToPA Ha CTPOKE HOMEP " +
                                Integer.toString(expTokens.get(i).getRow()));

                    }
                }
                if (!expTokens.get(i).getType().name().equals("INTEGER")) {
                    throw  new Exception("HenPaBu/|Huu` Tun uTePaToPA Ha CTPOKE HOMEP " +
                            Integer.toString(expTokens.get(i).getRow()));
                }
                i = t;
                if (variables.get(expTokens.get(i).getLexeme()).getType().substring(5).equals("INTEGER"))
                    expTokens.get(i).setType(Token.TokenType.INTEGER);
                if (variables.get(expTokens.get(i).getLexeme()).getType().substring(5).equals("REAL_NUMBER"))
                    expTokens.get(i).setType(Token.TokenType.REAL_NUMBER);
                if (variables.get(expTokens.get(i).getLexeme()).getType().substring(5).equals("BOOLEAN"))
                    expTokens.get(i).setType(Token.TokenType.BOOLEAN);
                if (variables.get(expTokens.get(i).getLexeme()).getType().substring(5).equals("COMPLEX_NUMBER"))
                    expTokens.get(i).setType(Token.TokenType.COMPLEX_NUMBER);
                if (variables.get(expTokens.get(i).getLexeme()).getType().substring(5).equals("RATIONAL_NUMBER"))
                    expTokens.get(i).setType(Token.TokenType.RATIONAL_NUMBER);
                if (variables.get(expTokens.get(i).getLexeme()).getType().substring(5).equals("STRING"))
                    expTokens.get(i).setType(Token.TokenType.STRING);
                tree.setValue(expTokens.get(i));
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            Token t = expTokens.get(i);
            if (t.getLexeme().equals("[")) {
                String type = "";
                i++;
                while (!expTokens.get(i).getLexeme().equals("]")) {
                    if (expTokens.get(i).getLexeme().equals(",")) {
                        i++;
                        continue;
                    }
                    String newType = "";
                    if (expTokens.get(i).getType().name().equals("IDENTIFIER")) {
                        if (variables.get(expTokens.get(i).getLexeme()) != null) {
                            newType = variables.get(expTokens.get(i).getLexeme()).getType();
                        }
                    } else newType = expTokens.get(i).getType().name();
                    if (!type.equals("") && !type.equals(newType)) {
                        throw  new Exception("OLLlu6KA B MACCuBE Ha CTPOKE HOMEP " +
                                Integer.toString(expTokens.get(i).getRow()));
                    } else type = newType;
                    i++;
                }
                t.setLexeme("ARRAY" + type);
                tree.setValue(t);
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            String t = expTokens.get(i).getLexeme();
            if (expTokens.get(i).getType().name().equals("INTEGER") ||
                    expTokens.get(i).getType().name().equals("REAL_NUMBER") ||
                    expTokens.get(i).getType().name().equals("BOOLEAN") ||
                    expTokens.get(i).getType().name().equals("COMPLEX_NUMBER") ||
                    expTokens.get(i).getType().name().equals("RATIONAL_NUMBER") ||
                    expTokens.get(i).getType().name().equals("STRING")) {
                tree.setValue(expTokens.get(i));
                return tree;
            }
        }
        for (int i = 0; i < expTokens.size(); i++) {
            String t = expTokens.get(i).getLexeme();
            if (expTokens.get(i).getType().name().equals("IDENTIFIER")) {
                if ((variables.get(expTokens.get(i).getLexeme()) != null &&
                        variables.get(expTokens.get(i).getLexeme()).getInput() != null) ||
                        (funcVariables.get(expTokens.get(i).getLexeme()) != null &&
                                funcVariables.get(expTokens.get(i).getLexeme()).getInput() != null) &&
                                variables.get(expTokens.get(i).getLexeme()).getInput().size() > 0) {
                    throw  new Exception("HeOnPEgE/|EHHA9 nEPEMEHHA9 Ha CTPOKE HOMEP " +
                            Integer.toString(expTokens.get(i).getRow()));
                }
                tree.setValue(expTokens.get(i));
                return tree;
            }
        }

        return null;
    }

    private Tree checkFunction() throws Exception {
        int ind = globalIterator - 2;
        globalIterator += 1;
        Map<String, Variable> localVariables = new HashMap<String, Variable>();

        while (!tokens.get(globalIterator).getLexeme().equals(")")) {
            globalIterator++;
            if (tokens.get(globalIterator).getType().name().equals("IDENTIFIER")) {
                String type = hardType(tokens.get(globalIterator + 2).getLexeme());
                if (tokens.get(globalIterator + 2).getLexeme() == "func") {
                    int f = globalIterator;
                    ArrayList<String> funcVariables = new ArrayList<String>();
                    while (!tokens.get(globalIterator).getLexeme().equals(")")) {
                        globalIterator++;
                        if (tokens.get(globalIterator).getType().name().equals("IDENTIFIER")) {
                            String types = hardType(tokens.get(globalIterator + 2).getLexeme());
                            funcVariables.add(types);
                            globalIterator += 3;
                        }
                    }
                    type = hardType(tokens.get(globalIterator + 2).getLexeme());
                    localVariables.put(tokens.get(f).getLexeme(), new Variable(tokens.get(f), type));
                    localVariables.get(tokens.get(f).getLexeme()).setList(new ArrayList<String>(funcVariables));

                } else
                    localVariables.put(tokens.get(globalIterator).getLexeme(), new Variable(tokens.get(globalIterator), type));
                input.add(type);
                globalIterator += 3;
            }
        }
        funcVariables = localVariables;
        input.add("ZAGLUSHKA");
        if (tokens.get(globalIterator + 3).getLexeme().equals("=>")) {
            tokens.get(globalIterator + 3).setLexeme("is");
            globalIterator += 2;
            String type = checkInd();
            variables.put(tokens.get(ind).getLexeme(), new Variable(tokens.get(ind), type));
            if (input.size() != 1) {
                variables.get(tokens.get(ind).getLexeme()).setList(new ArrayList<String>(input.subList(0, input.size() - 1)));
            }
        } else {
            ArrayList<Token> funcTokens = new ArrayList<Token>();
            globalIterator++;
            String predType = null;
            if (tokens.get(globalIterator).getLexeme().equals(":")) {
                globalIterator++;
                predType = hardType(tokens.get(globalIterator).getLexeme());
                globalIterator++;
            }
            globalIterator++;
            int h = 0;
            while (!tokens.get(globalIterator).getLexeme().equals("end") || h != 0) {
                String t = tokens.get(globalIterator).getLexeme();
                if (t.equals("if") || t.equals("do") || t.equals("loop")) {
                    h++;
                }
                if (t.equals("end")) {
                    h--;
                }
                funcTokens.add(tokens.get(globalIterator));
                globalIterator++;
            }

            String type = new SemanticForFunction(funcTokens, new HashMap<String, Variable>(variables), funcVariables).analyze();
            if (type == null || (predType != null && type != predType)) {
                return null;
            }
            variables.put(tokens.get(ind).getLexeme(), new Variable(tokens.get(ind), type));
            if (input.size() != 1) {
                variables.get(tokens.get(ind).getLexeme()).setList(new ArrayList<String>(input.subList(0, input.size() - 1)));
            }
        }
        input = new ArrayList<String>();
        funcVariables = new HashMap<String, Variable>();
        Tree ans = new Tree();
        ans.setValue(tokens.get(ind));
        return ans;
    }

    private String foundType(Tree tree) {
        Token t = tree.getValue();
        if (t.getType().name().equals("IDENTIFIER")) {
            if (variables.get(t.getLexeme()) != null)
                return variables.get(t.getLexeme()).getType();
            else if (funcVariables.get((t.getLexeme())) != null)
                return funcVariables.get(t.getLexeme()).getType();
            else
                return null;
        }
        if (t.getType().name().equals("INTEGER") ||
                t.getType().name().equals("REAL_NUMBER") ||
                t.getType().name().equals("BOOLEAN") ||
                t.getType().name().equals("COMPLEX_NUMBER") ||
                t.getType().name().equals("RATIONAL_NUMBER") ||
                t.getType().name().equals("STRING")) {
            return t.getType().name();
        }
        if (t.getLexeme().length() >= 5 && t.getLexeme().substring(0, 5).equals("ARRAY")) {
            return t.getLexeme();
        }
        if (t.getType().name().equals("OPERATOR")) {
            String left = null;
            String right = null;
            if (tree.getLeft() != null)
                left = foundType(tree.getLeft());
            if (tree.getRight() != null)
                right = foundType(tree.getRight());
            if (right == null && left == null) {
                return null;
            }
            return answerType(t.getLexeme(), left, right);
        }
        return "";
    }

    private String answerType(String type, String left, String right) {
        if (right == null || left == null){
            return null;
        }
        if (type == "+" || type == "-" || type == "*") {
            if (right.substring(0, 5).equals("ARRAY") && right.equals(left)) {
                return right;
            }
            if (right.substring(0, 5).equals("ARRAY") && right.substring(5).equals(left)) {
                return right;
            }
            if (left.substring(0, 5).equals("ARRAY") && left.substring(5).equals(right)) {
                return left;
            }

            //WITH COMPLEX NUMBERS
            if (right == "COMPLEX_NUMBER" && left == "INTEGER") {
                return "COMPLEX_NUMBER";
            }
            if (right == "COMPLEX_NUMBER" && left == "REAL_NUMBER") {
                return "COMPLEX_NUMBER";
            }
            if (right == "COMPLEX_NUMBER" && left == "COMPLEX_NUMBER") {
                return "COMPLEX_NUMBER";
            }
            if (right == "REAL_NUMBER" && left == "COMPLEX_NUMBER") {
                return "COMPLEX_NUMBER";
            }
            if (right == "INTEGER" && left == "COMPLEX_NUMBER") {
                return "COMPLEX_NUMBER";
            }

            //WITH RATIONAL NUMBERS
            if (right == "RATIONAL_NUMBER" && left == "RATIONAL_NUMBER") {
                return "RATIONAL_NUMBER";
            }
            if (right == "INTEGER" && left == "RATIONAL_NUMBER") {
                return "RATIONAL_NUMBER";
            }
            if (right == "RATIONAL_NUMBER" && left == "INTEGER") {
                return "RATIONAL_NUMBER";
            }

            //WITH REAL NUMBERS
            if (right == "REAL_NUMBER" && left == "REAL_NUMBER") {
                return "REAL_NUMBER";
            }
            if (right == "INTEGER" && left == "REAL_NUMBER") {
                return "REAL_NUMBER";
            }
            if (right == "REAL_NUMBER" && left == "INTEGER") {
                return "REAL_NUMBER";
            }

            //WITH INTEGERS
            if (right == "INTEGER" || left == "INTEGER") {
                return "INTEGER";
            }
        }
        if (type == "/") {
            //WITH COMPLEX NUMBERS
            if (right == "COMPLEX_NUMBER" && left == "COMPLEX_NUMBER") {
                return "COMPLEX_NUMBER";
            }
            if (right == "COMPLEX_NUMBER" && left == "REAL_NUMBER") {
                return "COMPLEX_NUMBER";
            }
            if (right == "COMPLEX_NUMBER" && left == "INTEGER") {
                return "COMPLEX_NUMBER";
            }

            //WITH RATIONAL NUMBERS
            if (right == "RATIONAL_NUMBER" && left == "RATIONAL_NUMBER") {
                return "RATIONAL_NUMBER";
            }
            if (right == "INTEGER" && left == "RATIONAL_NUMBER") {
                return "RATIONAL_NUMBER";
            }
            if (right == "RATIONAL_NUMBER" && left == "INTEGER") {
                return "RATIONAL_NUMBER";
            }

            //WITH REAL NUMBERS
            if (right == "REAL_NUMBER" && left == "REAL_NUMBER") {
                return "REAL_NUMBER";
            }
            if (right == "INTEGER" && left == "REAL_NUMBER") {
                return "REAL_NUMBER";
            }
            if (right == "REAL_NUMBER" && left == "INTEGER") {
                return "REAL_NUMBER";
            }

            //WITH INTEGERS
            if (right == "INTEGER" && left == "INTEGER") {
                return "REAL_NUMBER";
            }
        }

        if (type == "<" || type == "<=" || type == ">" || type == ">=" || type == "=" || type == "/=") {
            if (right == "INTEGER" && left == "INTEGER") {
                return "BOOLEAN";
            }
            if (right == "INTEGER" && left == "REAL_NUMBER") {
                return "BOOLEAN";
            }
            if (right == "REAL_NUMBER" && left == "INTEGER") {
                return "BOOLEAN";
            }
            if (right == "REAL_NUMBER" && left == "REAL_NUMBER") {
                return "BOOLEAN";
            }
            if (right == "INTEGER" && left == "RATIONAL_NUMBER") {
                return "BOOLEAN";
            }
            if (right == "RATIONAL_NUMBER" && left == "INTEGER") {
                return "BOOLEAN";
            }
            if (right == "RATIONAL_NUMBER" && left == "RATIONAL_NUMBER") {
                return "BOOLEAN";
            }
            if (right == "COMPLEX_NUMBER" && left == "COMPLEX_NUMBER") {
                return "BOOLEAN";
            }
        }

        if (type == "&" || type == "|" || type == "^") {
            if (right == "BOOLEAN" && left == "BOOLEAN")
                return "BOOLEAN";
        }
        return null;
    }

    private String hardType(String lex) {
        if (lex.equals("integer")) {
            return "INTEGER";
        }
        if (lex.equals("boolean")) {
            return "BOOLEAN";
        }
        if (lex.equals("real")) {
            return "REAL_NUMBER";
        }
        if (lex.equals("rational")) {
            return "RATIONAL_NUMBER";
        }
        if (lex.equals("complex")) {
            return "COMPLEX_NUMBER";
        }
        if (lex.equals("string")) {
            return "STRING";
        }
        if (lex.equals("[")) {
            String type = hardType(tokens.get(globalIterator + 1).getLexeme());
            globalIterator += 2;
            return "ARRAY" + type;
        }
        return "";
    }

    private void deleteWhitespaces() {
        ArrayList<Token> modified = new ArrayList<Token>();
        for (Token token : tokens) {
            if (token.getType() != Token.TokenType.WHITE_SPACE) {
                modified.add(token);
            }
        }
        this.tokens = modified;
    }

    private void addFunctions() {
        variables.put("round", new Variable(null, "INTEGER"));

        variables.put("re", new Variable(null, "REAL_NUMBER"));
        variables.get("re").setList(new ArrayList<String>(Arrays.asList("COMPLEX_NUMBER")));

        variables.put("im", new Variable(null, "REAL_NUMBER"));
        variables.get("im").setList(new ArrayList<String>(Arrays.asList("COMPLEX_NUMBER")));

        variables.put("num", new Variable(null, "INTEGER"));
        variables.get("num").setList(new ArrayList<String>(Arrays.asList("RATIONAL_NUMBER")));

        variables.put("denom", new Variable(null, "INTEGER"));
        variables.get("denom").setList(new ArrayList<String>(Arrays.asList("RATIONAL_NUMBER")));

        variables.put("norm", new Variable(null, "RATIONAL_NUMBER"));
        variables.get("norm").setList(new ArrayList<String>(Arrays.asList("RATIONAL_NUMBER")));

        variables.put("compl", new Variable(null, "COMPLEX_NUMBER"));

        variables.put("rat", new Variable(null, "RATIONAL_NUMBER"));

        variables.put("length", new Variable(null, "INTEGER"));
    }
}
