package bytecode_generator;

import lexer.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConvertToJava {

    ArrayList<Token> tokens;
    String userFunctions = "";
    Map<String, String> types = new HashMap<String, String>();
    int position = 0;

    public ConvertToJava(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public String convert(String fileName) {
        String source = "public class " + fileName + " implements Runnable {\n" +
                "  public void run() {\n" +
                convertTokens() +
                "    }\n"

                + "}\n" ; // TODO add structure code
        return source;
    }

    private String convertTokens() {
        StringBuilder code = new StringBuilder();
        deleteWhitespaces();
        convertOperatorsToJava();
        while (position < tokens.size()) {
            if (tokens.get(position).getType() == Token.TokenType.KEYWORD) {
                convertKeyword();
            }
            code.append(convertDeclarations());
            if (position >= tokens.size()) {
                break;
            }
            if (tokens.get(position).getLexeme().equals(";"))
                position++;
        }

        return code.toString();
    }

    private StringBuilder convertKeyword() {
        StringBuilder code = new StringBuilder();
        if (tokens.get(position).getLexeme().equals("while")) {
            code.append("while (");
            position++;
            while (!tokens.get(position).getLexeme().equals("loop")) {
                if (tokens.get(position).getType() == Token.TokenType.IDENTIFIER ||
                        tokens.get(position).getType() == Token.TokenType.OPERATOR ||
                        tokens.get(position).getType() == Token.TokenType.BOOLEAN ||
                        tokens.get(position).getType() == Token.TokenType.REAL_NUMBER ||
                        tokens.get(position).getType() == Token.TokenType.INTEGER) {
                    code.append(tokens.get(position).getLexeme());
                }
                position++;
            }
            code.append(") {\n");
            while (!tokens.get(position).getLexeme().equals("end")) {
                position++;
                if (position >= tokens.size()) {
                    break;
                }
                code.append(convertExpression());
                code.append(";\n");
                position++;
                if (!tokens.get(position).getLexeme().equals("end")) {
                    position--;
                }
            }
            code.append("}\n");
        } else {
            if (tokens.get(position).getLexeme().equals("if")) {
                code.append("if (");
                position++;
                while (!tokens.get(position).getLexeme().equals("then")) {
                    if (tokens.get(position).getType() == Token.TokenType.IDENTIFIER ||
                            tokens.get(position).getType() == Token.TokenType.OPERATOR ||
                            tokens.get(position).getType() == Token.TokenType.BOOLEAN ||
                            tokens.get(position).getType() == Token.TokenType.REAL_NUMBER ||
                            tokens.get(position).getType() == Token.TokenType.INTEGER) {
                        code.append(tokens.get(position).getLexeme());
                    }
                    position++;
                }
                code.append(") {\n");
                while (!tokens.get(position).getLexeme().equals("else") && !tokens.get(position).getLexeme().equals("end")) {
                    position++;
                    if (position >= tokens.size()) {
                        break;
                    }
                    code.append(convertExpression());
                    code.append(";\n");
                    position++;
                    if (!tokens.get(position).getLexeme().equals("else") && !tokens.get(position).getLexeme().equals("end")) {
                        position--;
                    }
                }
                if (tokens.get(position).getLexeme().equals("else")) {
                    code.append("} else {\n");
                    while (!tokens.get(position).getLexeme().equals("end")) {
                        position++;
                        if (position >= tokens.size()) {
                            break;
                        }
                        code.append(convertExpression());
                        code.append(";\n");
                        position++;
                        if (!tokens.get(position).getLexeme().equals("end")) {
                            position--;
                        }
                    }
                    code.append(convertExpression());
                    code.append(";\n");
                    position++;
                }
                code.append("}\n");
            }
        }
        return code;
    }

    private StringBuilder convertDeclarations() {
        StringBuilder code = new StringBuilder();
        if (tokens.get(position).getType().equals(Token.TokenType.IDENTIFIER)) {
            String identifier = tokens.get(position).getLexeme();
            position++;
            if (tokens.get(position).getLexeme().equals(":")) {
                position++;
                code.append(convertType(identifier));
            }
            else {
                code.append(convertType(identifier));
            }
        }
        return code;
    }

    private StringBuilder convertType(String identifier) {
        StringBuilder code = new StringBuilder();
        if (tokens.get(position).getLexeme().equals("integer")) {
            code.append("Integer " + identifier + "= new Integer(" + convertExpression() + ");\n");
            types.put(identifier, "Integer");
            position++;
        }
        else if(tokens.get(position).getLexeme().equals("bool")) {
            code.append("Boolean " + identifier + "= new Boolean(" + convertExpression() + ");\n");
            types.put(identifier, "Boolean");
            position++;
        }
        else if(tokens.get(position).getLexeme().equals("real")) {
            code.append("Double " + identifier + "= new Double(" + convertExpression() + ");\n");
            types.put(identifier, "Double");
            position++;
        }
        else if(tokens.get(position).getLexeme().equals("rational")) {
            code.append("Rational " + identifier + "= new Rational(" + convertExpression() + ");\n");
            types.put(identifier, "Rational");
            position++;
        }
        else if(tokens.get(position).getLexeme().equals("complex")) {
            code.append("Comlex " + identifier + "= new Complex(" + convertExpression() + ");\n");
            types.put(identifier, "Complex");
            position++;
        }
        else if(tokens.get(position).getLexeme().equals("string")) {
            code.append("String " + identifier + "= new String(" + convertExpression() + ");\n");
            types.put(identifier, "String");
            position++;
        }
        else if (tokens.get(position).getLexeme().equals("[")) {
            position++;
            String arrType = convertToJavaType(tokens.get(position).getLexeme());
            position++;
            while (!tokens.get(position).getLexeme().equals("[")) {
                position++;
            }
            position++;
            StringBuilder elements = new StringBuilder("{");
            while (!tokens.get(position).getLexeme().equals("]")) {
                if (tokens.get(position).getType() == Token.TokenType.PUNCTUATION) {
                    elements.append(tokens.get(position).getLexeme());
                } else {
                    elements.append("new " + convertTokenTypeToJava(tokens.get(position).getType()) +"(" + tokens.get(position).getLexeme() + ")");
                }
                position++;
                if (position >= tokens.size()) {
                    position--;
                    break;
                }
            }
            elements.append("}");
            position++;
            code.append(arrType+"[] " + identifier + " = new "+arrType+"[]"+elements+";\n");
        }
        else if(tokens.get(position).getLexeme().equals("is") && tokens.get(position+1).getLexeme().equals("func")) {
            position+=3;
            types.put(identifier, "func");
            ArrayList<String> paramsType = new ArrayList<String>();
            ArrayList<String> paramsId = new ArrayList<String>();
            int pos_copy = position;
            while(!tokens.get(pos_copy).getLexeme().equals(")")) {
                //Check func as param
                if (tokens.get(pos_copy).getLexeme().equals(","))
                    pos_copy++;
                paramsId.add(tokens.get(pos_copy).getLexeme());
                pos_copy+=2;
                if (tokens.get(pos_copy).getLexeme().equals("func")) {
                    paramsType.add("func");
                    pos_copy += 2;
                    while(tokens.get(pos_copy).getLexeme().equals(")")) {
                        pos_copy++;
                    }
                    pos_copy += 2;
                }
                else {
                    paramsType.add(convertToJavaType(tokens.get(pos_copy).getLexeme()));
                    pos_copy++;
                }
            }
            pos_copy+=2;
            String returnType = convertToJavaType(tokens.get(pos_copy).getLexeme());
            pos_copy++;
            position = pos_copy;
            ArrayList <String> identifiers = new ArrayList<String>();
            if (tokens.get(pos_copy).getLexeme().equals("=>")) {
                while(!tokens.get(pos_copy).getLexeme().equals(";")) {
                    if (tokens.get(pos_copy).getType().equals(Token.TokenType.IDENTIFIER) && !paramsId.contains(tokens.get(pos_copy).getLexeme())) {
                        if (!types.get(tokens.get(pos_copy).getLexeme()).equals("func"))
                            identifiers.add(tokens.get(pos_copy).getLexeme());
                    }
                    pos_copy++;
                }
                pos_copy++;
            }
            else if (tokens.get(pos_copy).getLexeme().equals("do")) {
                while(!tokens.get(pos_copy).getLexeme().equals("end")) {
                    if (tokens.get(pos_copy).getType().equals(Token.TokenType.IDENTIFIER) && !paramsId.contains(tokens.get(pos_copy).getLexeme())) {
                        if (!types.get(tokens.get(pos_copy).getLexeme()).equals("func"))
                            identifiers.add(tokens.get(pos_copy).getLexeme());
                    }
                    pos_copy++;
                }
                pos_copy++;
            }

            for (int i=0; i<identifiers.size(); i++) {
                code.append("final " + types.get(identifiers.get(i)) + " " + identifiers.get(i)+identifier + " = " + identifiers.get(i) + ";\n");
            }
            code.append("class " + identifier + " implements Callable {\n");
            for (int i=0; i<paramsId.size(); i++) {
                if (paramsType.get(i).equals("func")) {
                    continue;
                }
                code.append(paramsType.get(i) + " " + paramsId.get(i) + ";\n");
            }
            code.append(identifier + "(");
            for (int i=0; i<paramsId.size(); i++) {
                if (paramsType.get(i).equals("func")) {
                    continue;
                }
                if (i==0)
                    code.append(paramsType.get(i) + " " + paramsId.get(i));
                else
                    code.append(", " + paramsType.get(i) + " " + paramsId.get(i));
            }
            code.append(") {\n");
            for (int i=0; i<paramsId.size(); i++) {
                if (paramsType.get(i).equals("func")) {
                    continue;
                }
                code.append("this." + paramsId.get(i) + " = " + paramsId.get(i) + ";\n");
            }
            code.append("}\n");
            code.append("public " + returnType + " call() throws Exception {\n");

            // TODO
            code.append(convertExpression());
            // code.append("System.out.println(\"Hello from function\");\n");

            code.append("return null;\n}\n");
            code.append("}\n");

        }

        return code;
    }

    private StringBuilder convertExpression() {
        StringBuilder code = new StringBuilder();
        while (!tokens.get(position).getLexeme().equals(";")) {
            if (position+3 < tokens.size() && tokens.get(position+3).getLexeme().equals("[")) {
                position += 2;
                String identifier = tokens.get(position).getLexeme();
                position += 1;
                StringBuilder index = convertExpression();
                code.append(identifier+index);
            }
            else if (!(tokens.get(position).getType().equals(Token.TokenType.IDENTIFIER) && tokens.get(position+1).getLexeme().equals("("))) {
                code.append(tokens.get(position).getLexeme());
                position++;
            }
            else {
                code.append("(new "+tokens.get(position).getLexeme()+"(");
                position++;
                while(tokens.get(position).getLexeme().equals(")")) {
                    //
                }
                code.append(")");
            }
        }
        return code;
    }

    private String convertToJavaType(String type) {
        if (type.equals("integer"))
            return "Integer";
        else if (type.equals("real"))
            return "Double";
        else if (type.equals("bool"))
            return "Boolean";
        else if (type.equals("Rational"))
            return "Rational";
        else if (type.equals("Complex"))
            return "Complex";
        else if (type.equals("String"))
            return "String";
        return null;
    }

    private String convertTokenTypeToJava(Token.TokenType type) {
        if (type == Token.TokenType.INTEGER) {
            return "Integer";
        }
        if (type == Token.TokenType.REAL_NUMBER) {
            return "Double";
        }
        if (type == Token.TokenType.COMPLEX_NUMBER) {
            return "Complex";
        }
        if (type == Token.TokenType.BOOLEAN) {
            return "Boolean";
        }
        if (type == Token.TokenType.RATIONAL_NUMBER) {
            return "Rational";
        }
        if (type == Token.TokenType.STRING) {
            return "String";
        }
        return null;
    }

    private void convertOperatorsToJava() {
        for (Token token: tokens) {
            if (token.getLexeme().equals(":=")) {
                token.setLexeme("=");
            }
            if (token.getLexeme().equals("/=")) {
                token.setLexeme("!=");
            }
        }
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
