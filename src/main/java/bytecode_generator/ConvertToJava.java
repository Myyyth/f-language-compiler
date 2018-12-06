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
        String source = "import java.io.IOException;\n" +
                "import java.lang.reflect.Constructor;\n" +
                "import java.util.concurrent.Callable;\n" +
                "public class " + fileName + " implements Runnable {\n" +
                "  public void run() {\n" +
                "  try {" +
                convertTokens() +
                "  } catch (Exception e) {}" +
                "    }\n"

                + "}\n" ; // TODO add structure code
        return source;
    }

    private String convertTokens() {
        StringBuilder code = new StringBuilder();
        deleteWhitespaces();
        while (position < tokens.size()) {
            code.append(convertDeclarations());
            if (tokens.get(position).getLexeme().equals(";"))
                position++;
        }

        return code.toString();
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
            types.put(identifier, "Integer");
            position+=2;
            code.append("Integer " + identifier + "= new Integer(" + convertExpression() + ");\n");
        }
        else if(tokens.get(position).getLexeme().equals("bool")) {
            types.put(identifier, "Boolean");
            position+=2;
            code.append("Boolean " + identifier + "= new Boolean(" + convertExpression() + ");\n");
        }
        else if(tokens.get(position).getLexeme().equals("real")) {
            types.put(identifier, "Double");
            position+=2;
            code.append("Double " + identifier + "= new Double(" + convertExpression() + ");\n");
        }
        else if(tokens.get(position).getLexeme().equals("rational")) {
            types.put(identifier, "Rational");
            position+=2;
            code.append("Rational " + identifier + "= new Rational(" + convertExpression() + ");\n");
        }
        else if(tokens.get(position).getLexeme().equals("complex")) {
            types.put(identifier, "Complex");
            position+=2;
            code.append("Comlex " + identifier + "= new Complex(" + convertExpression() + ");\n");
        }
        else if(tokens.get(position).getLexeme().equals("string")) {
            types.put(identifier, "String");
            position+=2;
            code.append("String " + identifier + "= new String(" + convertExpression() + ");\n");
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
                pos_copy += 2;

                if (tokens.get(pos_copy).getLexeme().equals("func")) {
                    pos_copy += 2;
                    paramsType.add("paramFunc");
                    while(!tokens.get(pos_copy).getLexeme().equals(")")) {
                        pos_copy++;
                    }
                    pos_copy += 3;
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
                if (paramsType.get(i).equals("paramFunc")) {
                    code.append("Callable " + paramsId.get(i) + ";\n");
                }
                else {
                    code.append(paramsType.get(i) + " " + paramsId.get(i) + ";\n");
                }
            }
            code.append(identifier + "(");
            for (int i=0; i<paramsId.size(); i++) {
                if (i != 0)
                    code.append(", ");

                if (paramsType.get(i).equals("paramFunc")) {
                    code.append("Callable " + paramsId.get(i));
                }
                else {
                    code.append(paramsType.get(i) + " " + paramsId.get(i));
                }
            }
            code.append(") {\n");
            for (int i=0; i<paramsId.size(); i++) {
                code.append("this." + paramsId.get(i) + " = " + paramsId.get(i) + ";\n");
            }
            code.append("}\n");
            code.append("public " + returnType + " call() throws Exception {\n");


            if (tokens.get(position).getLexeme().equals("=>")) {
                position++;
                code.append("return ");
                while(!tokens.get(position).getLexeme().equals(";")) {
                    // Closured identifiers
                    if (tokens.get(position).getType().equals(Token.TokenType.IDENTIFIER) && !paramsId.contains(tokens.get(position).getLexeme())) {
                        code.append(tokens.get(position).getLexeme()+identifier);
                        position++;
                    }
                    else if (paramsId.contains(tokens.get(position).getLexeme()) && paramsType.get(paramsId.indexOf(tokens.get(position).getLexeme())).equals("paramFunc")) {
                        code.append(returnType + ".valueOf(" + tokens.get(position).getLexeme() + ".call().toString())");
                        position += 3;
                    }
                    else {
                        code.append(tokens.get(position).getLexeme());
                        position++;
                    }
                }
                code.append(";");
            }
            else if (tokens.get(position).getLexeme().equals("do")) {
                position++;
                while(!tokens.get(position).getLexeme().equals("end")) {
                    // Closured  identifiers
                    if (tokens.get(position).getType().equals(Token.TokenType.IDENTIFIER) && !paramsId.contains(tokens.get(position).getLexeme())) {
                        code.append(tokens.get(position).getLexeme()+identifier);
                        position++;
                    }
                    else if (paramsId.contains(tokens.get(position).getLexeme()) && paramsType.get(paramsId.indexOf(tokens.get(position).getLexeme())).equals("paramFunc")) {
                        code.append(tokens.get(position).getLexeme() + ".call()");
                        position += 3;
                    }
                    else if (tokens.get(position).getLexeme().equals("print")) {
                        position += 2;
                        code.append("System.out.println(");
                        while (!tokens.get(position).getLexeme().equals(")")) {
                            if (identifiers.contains(tokens.get(position).getLexeme())) {
                                code.append(tokens.get(position).getLexeme() + identifier);
                            }
                            else {
                                code.append(tokens.get(position).getLexeme());
                            }
                            position++;
                        }
                        code.append(");\n");
                        position+=2;
                    }
                    else if (tokens.get(position).getLexeme().equals("return")) {
                        code.append("return ");
                        position++;
                    }
                    else {
                        code.append(tokens.get(position).getLexeme());
                        position++;
                    }
                }
                position++;
            }

            code.append("\n}\n");
            code.append("}\n");

        }

        return code;
    }

    private StringBuilder convertExpression() {
        StringBuilder code = new StringBuilder();
        while (!tokens.get(position).getLexeme().equals(";")) {
            if (!(tokens.get(position).getType().equals(Token.TokenType.IDENTIFIER) && tokens.get(position+1).getLexeme().equals("("))) {
                code.append(tokens.get(position).getLexeme());
                position++;
            }
            else {
                code.append("(new "+tokens.get(position).getLexeme()+"(");
                position+=2;
                while(!tokens.get(position).getLexeme().equals(")")) {
                    if (tokens.get(position).getLexeme().equals(",")) {
                        position++;
                    }
                    if (types.get(tokens.get(position).getLexeme()).equals("func")) {
                        position += 2;

                    }
                    else {
                        code.append(tokens.get(position).getLexeme());
                        position++;
                        if (!tokens.get(position).getLexeme().equals(")"))
                            code.append(", ");
                    }
                }
                code.append(")).call().toString()");
                position++;
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
