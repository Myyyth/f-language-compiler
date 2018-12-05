package bytecode_generator;

import org.objectweb.asm.*;
import static org.objectweb.asm.Opcodes.*;

public class Mapper {
    public String createComplexClass() {
        return "public class Complex {\n" +
                "        public double real;\n" +
                "        public double imaginary;\n" +
                "\n" +
                "        public Complex() { }\n" +
                "\n" +
                "        public Complex(double real, double imaginary) {\n" +
                "            this.real = real;\n" +
                "            this.imaginary = imaginary;\n" +
                "        }\n" +
                "    }\n" +
                "@Override\n" +
                "        public String toString() {\n" +
                "            return String.valueOf(real) + \"i\" + String.valueOf(imaginary);\n" +
                "        }\n";
    }

    public String createComplexObject(double real, double imaginary) {
        return null;
    }

    public String createRationalClass(){
        return "public class Rational {\n" +
                "        public int num;\n" +
                "        public int denom;\n" +
                "        public Rational(int num, int denom) {\n" +
                "            this.num = num;\n" +
                "            this.denom = denom;\n" +
                "        }\n" +
                "@Override\n" +
                "        public String toString() {\n" +
                "            return String.valueOf(real) + \"i\" + String.valueOf(imaginary);\n" +
                "        }\n" +
                "    }\n";
    }

    public String createRationalObject(String var, int num, int denom) {
        return "Rational " + var + " = new Rational("+num+", "+denom+");\n";
    }

    /*
        ADD part
     */
    public String addIntInt(){
        return "public int addIntInt(int a, int b) {\n" +
                "        return a + b;\n" +
                "    }\n";
    }

    public String addIntReal(){
        return "public int addIntInt(int a, int b) {\n" +
                "        return a + b;\n" +
                "    }\n";
    }

    public String addRealInt(){
        return "public double addRealInt(double a, int b) {\n" +
                "        return a + b;\n" +
                "    }\n";
    }

    public String addRealReal(){
        return "public double addRealReal(double a, double b) {\n" +
                "        return a + b;\n" +
                "    }\n";
    }

    public String addIntRational(){
        return "public Rational addIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return new Rational(a * denom + nom, denom);\n" +
                "    }\n";
    }

    public String addRationalInt(){
        return "public Rational addRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return new Rational(b * denom + nom, denom);\n" +
                "    }\n";
    }

    public String addRationalRational(){
        return "public Rational addRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return new Rational(nomA * denomB + nomB * denomA, denomA * denomB);\n" +
                "    }\n";
    }

    public String subtractIntInt(){
        return "public int subtractIntInt(int a, int b) {\n" +
                "        return a - b;\n" +
                "    }\n";
    }

    public String subtractIntReal(){
        return "public double subtractIntReal(int a, double b) {\n" +
                "        return a - b;\n" +
                "    }\n";
    }

    public String subtractRealInt(){
        return "public double subtractRealInt(double a, int b) {\n" +
                "        return a - b;\n" +
                "    }\n";
    }

    public String subtractRealReal(){
        return "public double subtractRealReal(double a, double b) {\n" +
                "        return a - b;\n" +
                "    }\n";
    }

    public String subtractIntRational() {
        return "public Rational subtractIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return new Rational(a * denom - nom, denom);\n" +
                "    }\n";
    }

    public String subtractRationalInt() {
        return "public Rational subtractRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return new Rational(b * denom - nom, denom);\n" +
                "    }\n";
    }

    public String subtractRationalRational() {
        return "public Rational subtractRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return new Rational(nomA * denomB - nomB * denomA, denomA * denomB);\n" +
                "    }\n";
    }

    /*
        MULT part
     */
    public String multIntInt() {
        return "public int multIntInt(int a, int b) {\n" +
                "        return a * b;\n" +
                "    }\n";
    }

    public String multIntReal() {
        return "public double multIntReal(int a, double b) {\n" +
                "        return a * b;\n" +
                "    }\n";
    }

    public String multRealInt() {
        return "public double multRealInt(double a, int b) {\n" +
                "        return a * b;\n" +
                "    }\n";
    }

    public String multRealReal() {
        return "public double multRealReal(double a, double b) {\n" +
                "        return a * b;\n" +
                "    }\n";
    }

    public String multIntRational() {
        return "public Rational multIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return new Rational(a * nom, denom);\n" +
                "    }\n";
    }

    public String multRationalInt() {
        return "public Rational multRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return new Rational(b * nom, denom);\n" +
                "    }\n";
    }

    public String multRationalRational() {
        return "public Rational multRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return new Rational(nomA * nomB, denomA * denomB);\n" +
                "    }\n";
    }

    /*
        DIV part
     */
    public String divIntInt() {
        return "public int divIntInt(int a, int b) {\n" +
                "        return a / b;\n" +
                "    }\n";
    }

    public String divIntReal() {
        return "public double divIntReal(int a, double b) {\n" +
                "        return a / b;\n" +
                "    }\n";
    }

    public String divRealInt() {
        return "public double divRealInt(double a, int b) {\n" +
                "        return a / b;\n" +
                "    }\n";
    }

    public String divRealReal() {
        return "public double divRealReal(double a, double b) {\n" +
                "        return a / b;\n" +
                "    }\n";
    }

    public String divIntRational() {
        return "public Rational divIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return new Rational(a * denom, nom);\n" +
                "    }\n";
    }

    public String divRationalInt() {
        return "public Rational divRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return new Rational(nom, b * denom);\n" +
                "    }\n";
    }

    public String divRationalRational() {
        return "public Rational divRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return new Rational(nomA * denomB, denomA * nomB);\n" +
                "    }\n";
    }

    /*
        LESS part
     */
    public String lessIntInt() {
        return "public boolean lessIntInt(int a, int b) {\n" +
                "        return a < b;\n" +
                "    }\n";
    }

    public String lessIntReal() {
        return "public boolean lessIntReal(int a, double b) {\n" +
                "        return a < b;\n" +
                "    }\n";
    }

    public String lessRealInt() {
        return "public boolean lessRealInt(double a, int b) {\n" +
                "        return a < b;\n" +
                "    }\n";
    }

    public String lessRealReal() {
        return "public boolean lessRealReal(double a, double b) {\n" +
                "        return a < b;\n" +
                "    }\n";
    }

    public String lessIntRational() {
        return "public boolean lessIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a < (nom / denom);\n" +
                "    }\n";
    }

    public String lessRationalInt() {
        return "public boolean lessRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) < b;\n" +
                "    }\n";
    }

    public String lessRationalRational() {
        return "public boolean lessRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return (nomA / denomA) < (nomB / denomB);\n" +
                "    }\n";
    }

    /*
       LESS_EQUAL part
    */
    public String lessEqualIntInt() {
        return "public boolean lessEqualIntInt(int a, int b) {\n" +
                "        return a <= b;\n" +
                "    }\n";
    }

    public String lessEqualIntReal() {
        return "public boolean lessEqualIntReal(int a, double b) {\n" +
                "        return a <= b;\n" +
                "    }\n";
    }

    public String lessEqualRealInt() {
        return "public boolean lessEqualRealInt(double a, int b) {\n" +
                "        return a <= b;\n" +
                "    }\n";
    }

    public String lessEqualRealReal() {
        return "public boolean lessEqualRealReal(double a, double b) {\n" +
                "        return a <= b;\n" +
                "    }\n";
    }

    public String lessEqualIntRational() {
        return "public boolean lessEqualIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a <= (nom / denom);\n" +
                "    }\n";
    }

    public String lessEqualRationalInt() {
        return "public boolean lessEqualRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) <= b;\n" +
                "    }\n";
    }

    public String lessEqualRationalRational() {
        return "public boolean lessEqualRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return (nomA / denomA) <= (nomB / denomB);\n" +
                "    }\n";
    }

    /*
       MORE part
    */
    public String moreIntInt() {
        return "public boolean moreIntInt(int a, int b) {\n" +
                "        return a > b;\n" +
                "    }\n";
    }

    public String moreIntReal() {
        return "public boolean moreIntReal(int a, double b) {\n" +
                "        return a > b;\n" +
                "    }\n";
    }

    public String moreRealInt() {
        return "public boolean moreRealInt(double a, int b) {\n" +
                "        return a > b;\n" +
                "    }\n";
    }

    public String moreRealReal() {
        return "public boolean moreRealReal(double a, double b) {\n" +
                "        return a > b;\n" +
                "    }\n";
    }

    public String moreIntRational() {
        return "public boolean moreIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a > (nom / denom);\n" +
                "    }\n";
    }

    public String moreRationalInt() {
        return "public boolean moreRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) > b;\n" +
                "    }\n";
    }

    public String moreRationalRational() {
        return "public boolean moreRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return (nomA / denomA) > (nomB / denomB);\n" +
                "    }\n";
    }

    /*
       MORE_EQUAL part
    */
    public String moreEqualIntInt() {
        return "public boolean moreEqualIntInt(int a, int b) {\n" +
                "        return a >= b;\n" +
                "    }\n";
    }

    public String moreEqualIntReal() {
        return "public boolean moreEqualIntReal(int a, double b) {\n" +
                "        return a >= b;\n" +
                "    }\n";
    }

    public String moreEqualRealInt() {
        return "public boolean moreEqualRealInt(double a, int b) {\n" +
                "        return a >= b;\n" +
                "    }\n";
    }

    public String moreEqualRealReal() {
        return "public boolean moreEqualRealReal(double a, double b) {\n" +
                "        return a >= b;\n" +
                "    }\n";
    }

    public String moreEqualIntRational() {
        return "public boolean moreEqualIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a >= (nom / denom);\n" +
                "    }\n";
    }

    public String moreEqualRationalInt() {
        return "public boolean moreEqualRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) >= b;\n" +
                "    }\n";
    }

    public String moreEqualRationalRational() {
        return "public boolean moreEqualRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return (nomA / denomA) >= (nomB / denomB);\n" +
                "    }\n";
    }

    /*
       EQUAL part
    */
    public String equalIntInt() {
        return "public boolean equalIntInt(int a, int b) {\n" +
                "        return a == b;\n" +
                "    }\n";
    }

    public String equalIntReal() {
        return "public boolean equalIntReal(int a, double b) {\n" +
                "        return a == b;\n" +
                "    }\n";
    }

    public String equalRealInt() {
        return "public boolean equalRealInt(double a, int b) {\n" +
                "        return a == b;\n" +
                "    }\n";
    }

    public String equalRealReal() {
        return "public boolean equalRealReal(double a, double b) {\n" +
                "        return a == b;\n" +
                "    }\n";
    }

    public String equalIntRational() {
        return "public boolean equalIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a == (nom / denom);\n" +
                "    }\n";
    }

    public String equalRationalInt() {
        return "public boolean equalRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) == b;\n" +
                "    }\n";
    }

    public String equalRationalRational() {
        return "public boolean equalRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return (nomA / denomA) == (nomB / denomB);\n" +
                "    }\n";
    }

    /*
       NOT_EQUAL part
    */
    public String notEqualIntInt() {
        return "public boolean notEqualIntInt(int a, int b) {\n" +
                "        return a != b;\n" +
                "    }\n";
    }

    public String notEqualIntReal() {
        return "public boolean notEqualIntReal(int a, double b) {\n" +
                "        return a != b;\n" +
                "    }\n";
    }

    public String notEqualRealInt() {
        return "public boolean notEqualRealInt(double a, int b) {\n" +
                "        return a != b;\n" +
                "    }\n";
    }

    public String notEqualRealReal() {
        return "public boolean notEqualRealReal(double a, double b) {\n" +
                "        return a != b;\n" +
                "    }\n";
    }

    public String notEqualIntRational() {
        return "public boolean notEqualIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a != (nom / denom);\n" +
                "    }\n";
    }

    public String notEqualRationalInt() {
        return "public boolean notEqualRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) != b;\n" +
                "    }\n";
    }

    public String notEqualRationalRational() {
        return "public boolean notEqualRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return (nomA / denomA) != (nomB / denomB);\n" +
                "    }\n";
    }

    /*
        Logical operators part
     */
    public String logicalAndBoolBool() {
        return "public boolean logicalAndBoolBool(boolean a, boolean b) {\n" +
                "        return a && b;\n" +
                "    }\n";
    }

    public String logicalOrBoolBool() {
        return "public boolean logicalOrBoolBool(boolean a, boolean b) {\n" +
                "        return a || b;\n" +
                "    }\n";
    }

    public String exclusiveOrBoolBool() {
        return "public boolean exclusiveOrBoolBool(boolean a, boolean b) {\n" +
                "        return a ^ b;\n" +
                "    }\n";
    }

    public String roundReal() {
        return "public int roundReal(double a) {\n" +
                "        return (int) Math.round(a);\n" +
                "    }\n";
    }

    public String roundRat() {
        return "public double roundRat(Rational a) {\n" +
                "        return (a.num / a.denom);\n" +
                "    }\n";
    }

    public String numRat() {
        return "public double numRat(Rational a) {\n" +
                "        return a.num;\n" +
                "    }\n";
    }

    public String denomRat() {
        return "public double denomRat(Rational a) {\n" +
                "        return a.denom;\n" +
                "    }\n";
    }

    public String ratInt() {
        return "public Rational ratInt(int a) {\n" +
                "        return new Rational(a, 1);\n" +
                "    }\n";
    }

    public String ratIntInt() {
        return "public Rational ratIntInt(int a, int b) {\n" +
                "        return new Rational(a, b);\n" +
                "    }\n";
    }

    public String normRat() {
        return "public Rational normRat(Rational a) {\n" +
                "        int num = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        if (denom < 0) {\n" +
                "            num = -num;\n" +
                "            denom = -denom;\n" +
                "        }\n" +
                "        return new Rational(num, denom);\n" +
                "    }\n";
    }

    public String addIntArrayEntity() {
        return "public int[] addIntArrayEntity(int[] a, int e) {\n" +
                "        int len = a.length;\n" +
                "        int[] newArr = new int[len + 1];\n" +
                "        for (int i = 0; i < len; i++) {\n" +
                "            newArr[i] = a[i];\n" +
                "        }\n" +
                "        newArr[len] = e;\n" +
                "        return newArr;\n" +
                "    }\n";
    }

    public String addRealArrayEntity() {
        return "public double[] addRealArrayEntity(double[] a, double e) {\n" +
                "        int len = a.length;\n" +
                "        double[] newArr = new double[len + 1];\n" +
                "        for (int i = 0; i < len; i++) {\n" +
                "            newArr[i] = a[i];\n" +
                "        }\n" +
                "        newArr[len] = e;\n" +
                "        return newArr;\n" +
                "    }\n";
    }

    public String addRationalArrayEntity() {
        return "public Rational[] addRationalArrayEntity(Rational[] a, Rational e) {\n" +
                "        int len = a.length;\n" +
                "        Rational[] newArr = new Rational[len + 1];\n" +
                "        for (int i = 0; i < len; i++) {\n" +
                "            newArr[i] = a[i];\n" +
                "        }\n" +
                "        newArr[len] = e;\n" +
                "        return newArr;\n" +
                "    }\n";
    }

    public String addStringArrayEntity() {
        return "public String[] addStringArrayEntity(String[] a, String e) {\n" +
                "        int len = a.length;\n" +
                "        String[] newArr = new String[len + 1];\n" +
                "        for (int i = 0; i < len; i++) {\n" +
                "            newArr[i] = a[i];\n" +
                "        }\n" +
                "        newArr[len] = e;\n" +
                "        return newArr;\n" +
                "    }\n";
    }

    public String addBooleanArrayEntity() {
        return "public boolean[] addBooleanArrayEntity(boolean[] a, boolean e) {\n" +
                "        int len = a.length;\n" +
                "        boolean[] newArr = new boolean[len + 1];\n" +
                "        for (int i = 0; i < len; i++) {\n" +
                "            newArr[i] = a[i];\n" +
                "        }\n" +
                "        newArr[len] = e;\n" +
                "        return newArr;\n" +
                "    }\n";
    }

    public String addIntArrayArray() {
        return "public int[] addIntArrayArray(int[] a, int[] b) {\n" +
                "        int lenA = a.length;\n" +
                "        int lenB = b.length;\n" +
                "        int[] newArr = new int[lenA + lenB];\n" +
                "        int k = 0;\n" +
                "        for (int i = 0; i < lenA; i++) {\n" +
                "            newArr[i] = a[i];\n" +
                "            k = i;\n" +
                "        }\n" +
                "        for (int i = 0; i < lenB; i++) {\n" +
                "            newArr[k] = b[i];\n" +
                "            k++;\n" +
                "        }\n" +
                "        return newArr;\n" +
                "    }\n";
    }

    public String addRealArrayArray() {
        return "public double[] addRealArrayArray(double[] a, double[] b) {\n" +
                "        int lenA = a.length;\n" +
                "        int lenB = b.length;\n" +
                "        double[] newArr = new double[lenA + lenB];\n" +
                "        int k = 0;\n" +
                "        for (int i = 0; i < lenA; i++) {\n" +
                "            newArr[i] = a[i];\n" +
                "            k = i;\n" +
                "        }\n" +
                "        for (int i = 0; i < lenB; i++) {\n" +
                "            newArr[k] = b[i];\n" +
                "            k++;\n" +
                "        }\n" +
                "        return newArr;\n" +
                "    }\n";
    }

    public String addRationalArrayArray() {
        return "public Rational[] addRationalArrayArray(Rational[] a, Rational[] b) {\n" +
                "        int lenA = a.length;\n" +
                "        int lenB = b.length;\n" +
                "        Rational[] newArr = new Rational[lenA + lenB];\n" +
                "        int k = 0;\n" +
                "        for (int i = 0; i < lenA; i++) {\n" +
                "            newArr[i] = a[i];\n" +
                "            k = i;\n" +
                "        }\n" +
                "        for (int i = 0; i < lenB; i++) {\n" +
                "            newArr[k] = b[i];\n" +
                "            k++;\n" +
                "        }\n" +
                "        return newArr;\n" +
                "    }\n";
    }

    public String addStringArrayArray() {
        return "public String[] addStringArrayArray(String[] a, String[] b) {\n" +
                "        int lenA = a.length;\n" +
                "        int lenB = b.length;\n" +
                "        String[] newArr = new String[lenA + lenB];\n" +
                "        int k = 0;\n" +
                "        for (int i = 0; i < lenA; i++) {\n" +
                "            newArr[i] = a[i];\n" +
                "            k = i;\n" +
                "        }\n" +
                "        for (int i = 0; i < lenB; i++) {\n" +
                "            newArr[k] = b[i];\n" +
                "            k++;\n" +
                "        }\n" +
                "        return newArr;\n" +
                "    }\n";
    }

    public String addBooleanArrayArray() {
        return "public boolean[] addBooleanArrayArray(boolean[] a, boolean[] b) {\n" +
                "        int lenA = a.length;\n" +
                "        int lenB = b.length;\n" +
                "        boolean[] newArr = new boolean[lenA + lenB];\n" +
                "        int k = 0;\n" +
                "        for (int i = 0; i < lenA; i++) {\n" +
                "            newArr[i] = a[i];\n" +
                "            k = i;\n" +
                "        }\n" +
                "        for (int i = 0; i < lenB; i++) {\n" +
                "            newArr[k] = b[i];\n" +
                "            k++;\n" +
                "        }\n" +
                "        return newArr;\n" +
                "    }\n";
    }
}
