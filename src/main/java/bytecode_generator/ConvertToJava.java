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
                Mapper.sumComplexWithRealFunc() +
                "}\n"+  // TODO add structure code

                Mapper.createComplexClass() +
                Mapper.createRationalClass(); // TODO add structure code
        return source;
    }

    private String convertTokens() {
        StringBuilder code = new StringBuilder();
        deleteWhitespaces();
        convertOperatorsToJava();
        while (position < tokens.size()) {
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
                if (tokens.get(position).getLexeme().equals("print")) {
                    code.append("System.out.println(");
                    position += 2;
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
        position+=2;
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
            code.append("Complex " + identifier + "= new Complex(" + convertExpression() + ");\n");
        }
        else if(tokens.get(position).getLexeme().equals("string")) {
            types.put(identifier, "String");
            position+=2;
            code.append("String " + identifier + "= new String(" + convertExpression() + ");\n");
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
                    if (tokens.get(position).getLexeme().equals("print")) {
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
                    else if (tokens.get(position).getType().equals(Token.TokenType.IDENTIFIER) && !paramsId.contains(tokens.get(position).getLexeme())) {
                        code.append(tokens.get(position).getLexeme()+identifier);
                        position++;
                    }
                    else if (paramsId.contains(tokens.get(position).getLexeme()) && paramsType.get(paramsId.indexOf(tokens.get(position).getLexeme())).equals("paramFunc")) {
                        code.append(tokens.get(position).getLexeme() + ".call()");
                        position += 3;
                    }
                    else if (tokens.get(position).getLexeme().equals("return")) {
                        code.append("return ");
                        position++;
                    }
                    else if (tokens.get(position).getType() == Token.TokenType.KEYWORD) {
                        code.append(convertKeyword());
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
            if (position+2 < tokens.size() && tokens.get(position).getType().equals(Token.TokenType.INTEGER)
                    && tokens.get(position+1).getLexeme().equals("+") && tokens.get(position+2).getType().equals(Token.TokenType.RATIONAL_NUMBER) ) {
                if (tokens.get(position+1).getLexeme().equals("+")){
                    if (tokens.get(position+2).getType().equals(Token.TokenType.RATIONAL_NUMBER)){
                        String intNum = tokens.get(position).getLexeme();
                        String ratNum = tokens.get(position+2).getLexeme();

                        code.append("addIntRational(" + intNum + ", new Rational(" + convertRational(ratNum) +")).toString()");
                        position += 3;
                    }else if (tokens.get(position+2).getType().equals(Token.TokenType.COMPLEX_NUMBER)){
                        String intNum = tokens.get(position).getLexeme();
                        String compNum = tokens.get(position+2).getLexeme();
                        String parts[] = compNum.split("i");
                        String real = parts[0];
                        String imag = parts[1];
                        code.append("sumComplexWithIntFunc(new Complex(" + real + ", " + imag + "), " + intNum + ");");
                    }
                } else if (tokens.get(position+1).getLexeme().equals("*")){
                    if (tokens.get(position+2).getType().equals(Token.TokenType.RATIONAL_NUMBER)) {
                        String intNum = tokens.get(position).getLexeme();
                        String ratNum = tokens.get(position + 2).getLexeme();
                        String parts[] = ratNum.split("\\\\");
                        String numer = parts[0];
                        String denom = parts[1];
                        code.append("multIntRational(" + intNum + ", new Rational(" + numer + ", " + denom + "))");
                        position += 3;
                    }
                } else if (tokens.get(position+1).getLexeme().equals("-")){
                    if (tokens.get(position+2).getType().equals(Token.TokenType.RATIONAL_NUMBER)) {
                        String intNum = tokens.get(position).getLexeme();
                        String ratNum = tokens.get(position + 2).getLexeme();
                        String parts[] = ratNum.split("\\\\");
                        String numer = parts[0];
                        String denom = parts[1];
                        code.append("subtractIntRational(" + intNum + ", new Rational(" + numer + ", " + denom + "))");
                        position += 3;
                    }
                } else if (tokens.get(position+1).getLexeme().equals("/")){
                    if (tokens.get(position+2).getType().equals(Token.TokenType.RATIONAL_NUMBER)) {
                        String intNum = tokens.get(position).getLexeme();
                        String ratNum = tokens.get(position + 2).getLexeme();
                        String parts[] = ratNum.split("\\\\");
                        String numer = parts[0];
                        String denom = parts[1];
                        code.append("divIntRational(" + intNum + ", new Rational(" + numer + ", " + denom + "))");
                        position += 3;
                    }
                }
            } else if (position+2 < tokens.size() && tokens.get(position).getType().equals(Token.TokenType.RATIONAL_NUMBER)
                        && tokens.get(position+1).getLexeme().equals("+") && tokens.get(position+2).getType().equals(Token.TokenType.INTEGER)) {
                if (tokens.get(position + 1).getLexeme().equals("+")) {
                    if (tokens.get(position + 2).getType().equals(Token.TokenType.INTEGER)) {
                        String ratNum = tokens.get(position).getLexeme();
                        String intNum = tokens.get(position + 2).getLexeme();

                        code.append("divIntRational(" + intNum + ", new Rational(" + ratNum + ")).toString()");
                        position += 3;
                    } else if (tokens.get(position + 2).getType().equals(Token.TokenType.RATIONAL_NUMBER)) {
                        String ratNumA = tokens.get(position).getLexeme();
                        String ratNumB = tokens.get(position + 2).getLexeme();
                        String partsA[] = ratNumA.split("\\\\");
                        String numerA = partsA[0];
                        String denomA = partsA[1];
                        String partsB[] = ratNumB.split("\\\\");
                        String numerB = partsB[0];
                        String denomB = partsB[1];
                        code.append("divIntRational(new Rational(" + numerA + ", " + denomA + "), new Rational(" + numerB + ", " + denomB + "))");
                        position += 3;
                    }
                } else if (tokens.get(position + 1).getLexeme().equals("-")) {
                    if (tokens.get(position + 2).getType().equals(Token.TokenType.INTEGER)) {
                        String ratNum = tokens.get(position).getLexeme();
                        String intNum = tokens.get(position + 2).getLexeme();
                        String parts[] = ratNum.split("\\\\");
                        String numer = parts[0];
                        String denom = parts[1];
                        code.append("subtractRationalInt(new Rational(" + numer + ", " + denom + "), " + intNum + ")");
                        position += 3;
                    } else if (tokens.get(position + 2).getType().equals(Token.TokenType.RATIONAL_NUMBER)) {
                        String ratNumA = tokens.get(position).getLexeme();
                        String ratNumB = tokens.get(position + 2).getLexeme();
                        String partsA[] = ratNumA.split("\\\\");
                        String numerA = partsA[0];
                        String denomA = partsA[1];
                        String partsB[] = ratNumB.split("\\\\");
                        String numerB = partsB[0];
                        String denomB = partsB[1];
                        code.append("subtractRationalRational(new Rational(" + numerA + ", " + denomA + "), new Rational(" + numerB + ", " + denomB + "))");
                        position += 3;
                    }
                } else if (tokens.get(position + 1).getLexeme().equals("*")) {
                    if (tokens.get(position + 2).getType().equals(Token.TokenType.INTEGER)) {
                        String ratNum = tokens.get(position).getLexeme();
                        String intNum = tokens.get(position + 2).getLexeme();
                        String parts[] = ratNum.split("\\\\");
                        String numer = parts[0];
                        String denom = parts[1];
                        code.append("multRationalInt(new Rational(" + numer + ", " + denom + "), " + intNum + ")");
                        position += 3;
                    } else if (tokens.get(position + 2).getType().equals(Token.TokenType.RATIONAL_NUMBER)) {
                        String ratNumA = tokens.get(position).getLexeme();
                        String ratNumB = tokens.get(position + 2).getLexeme();
                        String partsA[] = ratNumA.split("\\\\");
                        String numerA = partsA[0];
                        String denomA = partsA[1];
                        String partsB[] = ratNumB.split("\\\\");
                        String numerB = partsB[0];
                        String denomB = partsB[1];
                        code.append("multRationalRational(new Rational(" + numerA + ", " + denomA + "), new Rational(" + numerB + ", " + denomB + "))");
                        position += 3;
                    }
                }
            }
            else if (tokens.get(position).getType().equals(Token.TokenType.COMPLEX_NUMBER)) {
                code.append("\"" + tokens.get(position).getLexeme() + "\"");
                position++;
            }
            else if (position+3 < tokens.size() && tokens.get(position+3).getLexeme().equals("[")) {
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
                position+=2;
                while(!tokens.get(position).getLexeme().equals(")")) {
                    if (tokens.get(position).getLexeme().equals(",")) {
                        position++;
                    }
                    if (types.containsKey(tokens.get(position).getLexeme()) && types.get(tokens.get(position).getLexeme()).equals("func")) {
                        code.append("new " + tokens.get(position).getLexeme() + "()");
                        position += 1;
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

    private String convertRational(String s){
        String[] res = s.split("\\\\");
        String num = res[0];
        String denom = res[1];
        return "\"" + num + "\\\\" + denom + "\"";
    }
}
