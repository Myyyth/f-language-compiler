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
                "    }\n" +
                Mapper.addBooleanArrayArray() +
                Mapper.addBooleanArrayEntity() +
                Mapper.addIntArrayArray() +
                Mapper.addIntArrayEntity() +
                Mapper.addIntInt() +
                Mapper.addIntRational() +
                Mapper.addIntReal() +
                Mapper.addRationalArrayArray() +
                Mapper.addRationalArrayEntity() +
                Mapper.addRationalInt() +
                Mapper.addRationalRational() +
                Mapper.addRealArrayArray() +
                Mapper.addRealArrayEntity() +
                Mapper.addRealInt() +
                Mapper.addRealReal() +
                Mapper.addStringArrayArray() +
                Mapper.addStringArrayEntity() +
                Mapper.complInt() +
                Mapper.complIntInt() +
                Mapper.complReal() +
                Mapper.complIntReal() +
                Mapper.complRealInt() +
                Mapper.complRealReal() +
                Mapper.denomRat() +
                Mapper.divComplexFunc() +
                Mapper.divComplexWithLeftIntFunc() +
                Mapper.divComplexWithRealLeftFunc() +
                Mapper.divComplexWithRealRightFunc() +
                Mapper.divIntInt() +
                Mapper.divIntRational() +
                Mapper.divIntReal() +
                Mapper.divRationalInt() +
                Mapper.divRationalRational() +
                Mapper.divRealInt() +
                Mapper.divRealReal() +
                Mapper.eqComplexFunc() +
                Mapper.equalIntInt() +
                Mapper.equalIntRational() +
                Mapper.equalIntReal() +
                Mapper.equalRationalInt() +
                Mapper.equalRationalRational() +
                Mapper.equalRealInt() +
                Mapper.equalRealReal() +
                Mapper.exclusiveOrBoolBool() +
                Mapper.grComplexFunc() +
                Mapper.grEqComplexFunc() +
                Mapper.im() +
                Mapper.lessComplexFunc() +
                Mapper.lessEqComplexFunc() +
                Mapper.lessEqualIntInt() +
                Mapper.lessEqualIntRational() +
                Mapper.lessEqualIntReal() +
                Mapper.lessEqualRationalInt() +
                Mapper.lessEqualRationalRational() +
                Mapper.lessEqualRealInt() +
                Mapper.lessEqualRealReal() +
                Mapper.lessIntInt() +
                Mapper.lessIntRational() +
                Mapper.lessIntReal() +
                Mapper.lessRationalInt() +
                Mapper.lessRationalRational() +
                Mapper.lessRealInt() +
                Mapper.lessRealReal() +
                Mapper.logicalAndBoolBool() +
                Mapper.logicalOrBoolBool() +
                Mapper.moreEqualIntInt() +
                Mapper.moreEqualIntRational() +
                Mapper.moreEqualIntReal() +
                Mapper.moreEqualRationalInt() +
                Mapper.moreEqualRationalRational() +
                Mapper.moreEqualRealInt() +
                Mapper.moreEqualRealReal() +
                Mapper.moreIntInt() +
                Mapper.moreIntRational() +
                Mapper.moreIntReal() +
                Mapper.moreRationalInt() +
                Mapper.moreRationalRational() +
                Mapper.moreRealInt() +
                Mapper.moreRealReal() +
                Mapper.mulComplexFunc() +
                Mapper.mulComplexWithIntFunc() +
                Mapper.mulComplexWithRealFunc() +
                Mapper.multIntInt() +
                Mapper.multIntRational() +
                Mapper.multIntReal() +
                Mapper.multRationalInt() +
                Mapper.multRationalRational() +
                Mapper.multRealInt() +
                Mapper.multRealReal() +
                Mapper.neqComplexFunc() +
                Mapper.normRat() +
                Mapper.notEqualIntInt() +
                Mapper.notEqualIntRational() +
                Mapper.notEqualIntReal() +
                Mapper.notEqualRationalInt() +
                Mapper.notEqualRationalRational() +
                Mapper.notEqualRealInt() +
                Mapper.notEqualRealReal() +
                Mapper.numRat() +
                Mapper.ratInt() +
                Mapper.ratIntInt() +
                Mapper.re() +
                Mapper.roundRat() +
                Mapper.roundReal() +
                Mapper.subComplexFunc() +
                Mapper.subComplexWithIntLeftFunc() +
                Mapper.subComplexWithIntRightFunc() +
                Mapper.subComplexWithRealLeftFunc() +
                Mapper.subComplexWithRealRightFunc() +
                Mapper.subtractIntInt() +
                Mapper.subtractIntRational() +
                Mapper.subtractIntReal() +
                Mapper.subtractRationalInt() +
                Mapper.subtractRationalRational() +
                Mapper.subtractRealInt() +
                Mapper.subtractRealReal() +
                Mapper.sumComplexFunc() +
                Mapper.sumComplexWithIntFunc() +
                Mapper.sumComplexWithRealFunc()
                + "} \n" + Mapper.createComplexClass() +
                Mapper.createRationalClass(); // TODO add structure code
        return source;
    }

    private String convertTokens() {
        StringBuilder code = new StringBuilder();
        deleteWhitespaces();
        while (position < tokens.size()) {
            code.append(convertDeclarations());
            if (tokens.get(position).getLexeme().equals(";"))
                position++;
            position=10;
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
            if (!(tokens.get(position).getType().equals(Token.TokenType.IDENTIFIER) && tokens.get(position+1).getLexeme().equals("("))) {
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
