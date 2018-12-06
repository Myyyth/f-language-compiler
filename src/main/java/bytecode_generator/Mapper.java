package bytecode_generator;

import org.objectweb.asm.*;
import static org.objectweb.asm.Opcodes.*;

public class Mapper {
    public static String createComplexClass() {
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
                "@Override\n" +
                "        public String toString() {\n" +
                "            return String.valueOf(real) + \"i\" + String.valueOf(imaginary);\n" +
                "        }\n" +
                "    }\n";
    }

    public static String createComplexObject(String var, double real, double imaginary) {
        return "Complex "+var+" = new Complex("+real+", "+imaginary+");\n";
    }

    public static String printObject(String var) {
        return "System.out.println("+var+".toString());\n";
    }

    public static String sumComplexFunc() {
        return "public Complex sum(Complex a, Complex b) {\n" +
                "        return new Complex(a.real + b.real, a.imaginary + b.imaginary);\n" +
                "    }\n";
    }

    public static String sumComplexWithIntFunc() {
        return "public Complex sum(Complex a, int b) {\n" +
                "        return new Complex(a.real + b, a);\n" +
                "    }\n";
    }

    public static String sumComplexWithRealFunc() {
        return "public Complex sum(Complex a, real b) {\n" +
                "        return new Complex(a.real + b, a);\n" +
                "    }\n";
    }

    public static String subComplexFunc() {
        return "public Complex sub(Complex a, Complex b) {\n" +
                "        return new Complex(a.real + b.real, a.imaginary + b.imaginary);\n" +
                "    }\n";
    }

    public static String subComplexWithIntRightFunc() {
        return "public Complex sub(Complex a, int b) {\n" +
                "        return new Complex(a.real - b, a);\n" +
                "    }\n";
    }

    public static String subComplexWithIntLeftFunc() {
        return "public Complex sub(int a, Complex b) {\n" +
                "        return new Complex(a - b.real, b.imaginary);\n" +
                "    }\n";
    }

    public static String createComplexObject(double real, double imaginary) {
        return null;
    }

    public static String createRationalClass(){
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

    public static String createRationalObject(String var, int num, int denom) {
        return "Rational " + var + " = new Rational("+num+", "+denom+");\n";
    }

    /*
        ADD part
     */
    public static String addIntInt(){
        return "public int addIntInt(int a, int b) {\n" +
                "        return a + b;\n" +
                "    }\n";
    }

    public static String addIntReal(){
        return "public int addIntInt(int a, int b) {\n" +
                "        return a + b;\n" +
                "    }\n";
    }

    public static String addRealInt(){
        return "public double addRealInt(double a, int b) {\n" +
                "        return a + b;\n" +
                "    }\n";
    }

    public static String addRealReal(){
        return "public double addRealReal(double a, double b) {\n" +
                "        return a + b;\n" +
                "    }\n";
    }

    public static String addIntRational(){
        return "public Rational addIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return new Rational(a * denom + nom, denom);\n" +
                "    }\n";
    }

    public static String addRationalInt(){
        return "public Rational addRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return new Rational(b * denom + nom, denom);\n" +
                "    }\n";
    }

    public static String addRationalRational(){
        return "public Rational addRationalRational(Rational a, Rational b) {\n" +
                "        int nomA = a.num;\n" +
                "        int denomA = a.denom;\n" +
                "        int nomB = b.num;\n" +
                "        int denomB = b.denom;\n" +
                "        return new Rational(nomA * denomB + nomB * denomA, denomA * denomB);\n" +
                "    }\n";
    }

    public static String subtractIntInt(){
        return "public int subtractIntInt(int a, int b) {\n" +
                "        return a - b;\n" +
                "    }\n";
    }

    public static String subtractIntReal(){
        return "public double subtractIntReal(int a, double b) {\n" +
                "        return a - b;\n" +
                "    }\n";
    }

    public static String subtractRealInt(){
        return "public double subtractRealInt(double a, int b) {\n" +
                "        return a - b;\n" +
                "    }\n";
    }

    public static String subtractRealReal(){
        return "public double subtractRealReal(double a, double b) {\n" +
                "        return a - b;\n" +
                "    }\n";
    }

    public static String subtractIntRational() {
        return "public Rational subtractIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return new Rational(a * denom - nom, denom);\n" +
                "    }\n";
    }

    public static String subtractRationalInt() {
        return "public Rational subtractRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return new Rational(b * denom - nom, denom);\n" +
                "    }\n";
    }

    public static String subtractRationalRational() {
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
    public static String multIntInt() {
        return "public int multIntInt(int a, int b) {\n" +
                "        return a * b;\n" +
                "    }\n";
    }

    public static String multIntReal() {
        return "public double multIntReal(int a, double b) {\n" +
                "        return a * b;\n" +
                "    }\n";
    }

    public static String multRealInt() {
        return "public double multRealInt(double a, int b) {\n" +
                "        return a * b;\n" +
                "    }\n";
    }

    public static String multRealReal() {
        return "public double multRealReal(double a, double b) {\n" +
                "        return a * b;\n" +
                "    }\n";
    }

    public static String multIntRational() {
        return "public Rational multIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return new Rational(a * nom, denom);\n" +
                "    }\n";
    }

    public static String multRationalInt() {
        return "public Rational multRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return new Rational(b * nom, denom);\n" +
                "    }\n";
    }

    public static String multRationalRational() {
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
    public static String divIntInt() {
        return "public int divIntInt(int a, int b) {\n" +
                "        return a / b;\n" +
                "    }\n";
    }

    public static String divIntReal() {
        return "public double divIntReal(int a, double b) {\n" +
                "        return a / b;\n" +
                "    }\n";
    }

    public static String divRealInt() {
        return "public double divRealInt(double a, int b) {\n" +
                "        return a / b;\n" +
                "    }\n";
    }

    public static String divRealReal() {
        return "public double divRealReal(double a, double b) {\n" +
                "        return a / b;\n" +
                "    }\n";
    }

    public static String divIntRational() {
        return "public Rational divIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return new Rational(a * denom, nom);\n" +
                "    }\n";
    }

    public static String divRationalInt() {
        return "public Rational divRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return new Rational(nom, b * denom);\n" +
                "    }\n";
    }

    public static String divRationalRational() {
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
    public static String lessIntInt() {
        return "public boolean lessIntInt(int a, int b) {\n" +
                "        return a < b;\n" +
                "    }\n";
    }

    public static String lessIntReal() {
        return "public boolean lessIntReal(int a, double b) {\n" +
                "        return a < b;\n" +
                "    }\n";
    }

    public static String lessRealInt() {
        return "public boolean lessRealInt(double a, int b) {\n" +
                "        return a < b;\n" +
                "    }\n";
    }

    public static String lessRealReal() {
        return "public boolean lessRealReal(double a, double b) {\n" +
                "        return a < b;\n" +
                "    }\n";
    }

    public static String lessIntRational() {
        return "public boolean lessIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a < (nom / denom);\n" +
                "    }\n";
    }

    public static String lessRationalInt() {
        return "public boolean lessRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) < b;\n" +
                "    }\n";
    }

    public static String lessRationalRational() {
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
    public static String lessEqualIntInt() {
        return "public boolean lessEqualIntInt(int a, int b) {\n" +
                "        return a <= b;\n" +
                "    }\n";
    }

    public static String lessEqualIntReal() {
        return "public boolean lessEqualIntReal(int a, double b) {\n" +
                "        return a <= b;\n" +
                "    }\n";
    }

    public static String lessEqualRealInt() {
        return "public boolean lessEqualRealInt(double a, int b) {\n" +
                "        return a <= b;\n" +
                "    }\n";
    }

    public static String lessEqualRealReal() {
        return "public boolean lessEqualRealReal(double a, double b) {\n" +
                "        return a <= b;\n" +
                "    }\n";
    }

    public static String lessEqualIntRational() {
        return "public boolean lessEqualIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a <= (nom / denom);\n" +
                "    }\n";
    }

    public static String lessEqualRationalInt() {
        return "public boolean lessEqualRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) <= b;\n" +
                "    }\n";
    }

    public static String lessEqualRationalRational() {
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
    public static String moreIntInt() {
        return "public boolean moreIntInt(int a, int b) {\n" +
                "        return a > b;\n" +
                "    }\n";
    }

    public static String moreIntReal() {
        return "public boolean moreIntReal(int a, double b) {\n" +
                "        return a > b;\n" +
                "    }\n";
    }

    public static String moreRealInt() {
        return "public boolean moreRealInt(double a, int b) {\n" +
                "        return a > b;\n" +
                "    }\n";
    }

    public static String moreRealReal() {
        return "public boolean moreRealReal(double a, double b) {\n" +
                "        return a > b;\n" +
                "    }\n";
    }

    public static String moreIntRational() {
        return "public boolean moreIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a > (nom / denom);\n" +
                "    }\n";
    }

    public static String moreRationalInt() {
        return "public boolean moreRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) > b;\n" +
                "    }\n";
    }

    public static String moreRationalRational() {
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
    public static String moreEqualIntInt() {
        return "public boolean moreEqualIntInt(int a, int b) {\n" +
                "        return a >= b;\n" +
                "    }\n";
    }

    public static String moreEqualIntReal() {
        return "public boolean moreEqualIntReal(int a, double b) {\n" +
                "        return a >= b;\n" +
                "    }\n";
    }

    public static String moreEqualRealInt() {
        return "public boolean moreEqualRealInt(double a, int b) {\n" +
                "        return a >= b;\n" +
                "    }\n";
    }

    public static String moreEqualRealReal() {
        return "public boolean moreEqualRealReal(double a, double b) {\n" +
                "        return a >= b;\n" +
                "    }\n";
    }

    public static String moreEqualIntRational() {
        return "public boolean moreEqualIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a >= (nom / denom);\n" +
                "    }\n";
    }

    public static String moreEqualRationalInt() {
        return "public boolean moreEqualRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) >= b;\n" +
                "    }\n";
    }

    public static String moreEqualRationalRational() {
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
    public static String equalIntInt() {
        return "public boolean equalIntInt(int a, int b) {\n" +
                "        return a == b;\n" +
                "    }\n";
    }

    public static String equalIntReal() {
        return "public boolean equalIntReal(int a, double b) {\n" +
                "        return a == b;\n" +
                "    }\n";
    }

    public static String equalRealInt() {
        return "public boolean equalRealInt(double a, int b) {\n" +
                "        return a == b;\n" +
                "    }\n";
    }

    public static String equalRealReal() {
        return "public boolean equalRealReal(double a, double b) {\n" +
                "        return a == b;\n" +
                "    }\n";
    }

    public static String equalIntRational() {
        return "public boolean equalIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a == (nom / denom);\n" +
                "    }\n";
    }

    public static String equalRationalInt() {
        return "public boolean equalRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) == b;\n" +
                "    }\n";
    }

    public static String equalRationalRational() {
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
    public static String notEqualIntInt() {
        return "public boolean notEqualIntInt(int a, int b) {\n" +
                "        return a != b;\n" +
                "    }\n";
    }

    public static String notEqualIntReal() {
        return "public boolean notEqualIntReal(int a, double b) {\n" +
                "        return a != b;\n" +
                "    }\n";
    }

    public static String notEqualRealInt() {
        return "public boolean notEqualRealInt(double a, int b) {\n" +
                "        return a != b;\n" +
                "    }\n";
    }

    public static String notEqualRealReal() {
        return "public boolean notEqualRealReal(double a, double b) {\n" +
                "        return a != b;\n" +
                "    }\n";
    }

    public static String notEqualIntRational() {
        return "public boolean notEqualIntRational(int a, Rational b) {\n" +
                "        int nom = b.num;\n" +
                "        int denom = b.denom;\n" +
                "        return a != (nom / denom);\n" +
                "    }\n";
    }

    public static String notEqualRationalInt() {
        return "public boolean notEqualRationalInt(Rational a, int b) {\n" +
                "        int nom = a.num;\n" +
                "        int denom = a.denom;\n" +
                "        return (nom / denom) != b;\n" +
                "    }\n";
    }

    public static String notEqualRationalRational() {
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
    public static String logicalAndBoolBool() {
        return "public boolean logicalAndBoolBool(boolean a, boolean b) {\n" +
                "        return a && b;\n" +
                "    }\n";
    }

    public static String logicalOrBoolBool() {
        return "public boolean logicalOrBoolBool(boolean a, boolean b) {\n" +
                "        return a || b;\n" +
                "    }\n";
    }

    public static String exclusiveOrBoolBool() {
        return "public boolean exclusiveOrBoolBool(boolean a, boolean b) {\n" +
                "        return a ^ b;\n" +
                "    }\n";
    }

    public static String roundReal() {
        return "public int roundReal(double a) {\n" +
                "        return (int) Math.round(a);\n" +
                "    }\n";
    }

    public static String roundRat() {
        return "public double roundRat(Rational a) {\n" +
                "        return (a.num / a.denom);\n" +
                "    }\n";
    }

    public static String numRat() {
        return "public double numRat(Rational a) {\n" +
                "        return a.num;\n" +
                "    }\n";
    }

    public static String denomRat() {
        return "public double denomRat(Rational a) {\n" +
                "        return a.denom;\n" +
                "    }\n";
    }

    public static String ratInt() {
        return "public Rational ratInt(int a) {\n" +
                "        return new Rational(a, 1);\n" +
                "    }\n";
    }

    public static String ratIntInt() {
        return "public Rational ratIntInt(int a, int b) {\n" +
                "        return new Rational(a, b);\n" +
                "    }\n";
    }

    public static String normRat() {
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

    public static String addIntArrayEntity() {
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

    public static String addRealArrayEntity() {
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

    public static String addRationalArrayEntity() {
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

    public static String addStringArrayEntity() {
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

    public static String addBooleanArrayEntity() {
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

    public static String addIntArrayArray() {
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

    public static String addRealArrayArray() {
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

    public static String addRationalArrayArray() {
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

    public static String addStringArrayArray() {
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

    public static String addBooleanArrayArray() {
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
                "        return newArr;\n";
    }

    public static String subComplexWithRealRightFunc() {
        return "public Complex sub(Complex a, real b) {\n" +
                "        return new Complex(a.real - b, a);\n" +
                "    }\n";
    }

    public static String subComplexWithRealLeftFunc() {
        return "public Complex sub(real a, Complex b) {\n" +
                "        return new Complex(a - b.real, b.imaginary);\n" +
                "    }\n";
    }

    public static String mulComplexFunc() {
        return "public Complex mul(Complex a, Complex b) {\n" +
                "        return new Complex(a.real * b.real, a.imaginary * b.imaginary);\n" +
                "    }\n";
    }

    public static String mulComplexWithIntFunc() {
        return "public Complex mul(Complex a, int b) {\n" +
                "        return new Complex(a.real * b, a);\n" +
                "    }\n";
    }

    public static String mulComplexWithRealFunc() {
        return "public Complex mul(Complex a, real b) {\n" +
                "        return new Complex(a.real * b, a);\n" +
                "    }\n";
    }

    public static String divComplexFunc() {
        return "public Complex div(Complex a, Complex b) {\n" +
                "        return new Complex(a.real / b, a);\n" +
                "    }\n";
    }

    public static String divComplexWithRealRightFunc() {
        return "public Complex div(Complex a, real b) {\n" +
                "        return new Complex(a.real / b, a);\n" +
                "    }\n";
    }

    public static String divComplexWithRealLeftFunc() {
        return "public Complex div(real a, Complex b) {\n" +
                "        return new Complex(a / b.real, b.imaginary);\n" +
                "    }\n";
    }

    public static String divComplexWithLeftIntFunc() {
        return "public Complex div(int a, Complex b) {\n" +
                "        return new Complex(a / b.real, b.imaginary);\n" +
                "    }\n";
    }

    public static String eqComplexFunc() {
        return "public boolean eq(Complex a, Complex b) {\n" +
                "        if ((a.real == b.real) && (a.imaginary == b.imaginary)) {\n" +
                "            return true;\n" +
                "        } else {\n" +
                "            return false;\n" +
                "        }\n" +
                "    }\n";
    }

    public static String lessComplexFunc() {
        return "public boolean less(Complex a, Complex b) {\n" +
                "        if (a.real < b.real) {\n" +
                "            return true;\n" +
                "        }\n" +
                "        if (a.real == b.real) {\n" +
                "            if (a.imaginary < b.imaginary) {\n" +
                "                return true;\n" +
                "            }\n" +
                "        }\n" +
                "        return false;\n" +
                "    }\n";
    }

    public static String lessEqComplexFunc() {
        return "public boolean lessEq(Complex a, Complex b) {\n" +
                "        if (a.real < b.real) {\n" +
                "            return true;\n" +
                "        } else {\n" +
                "            if (a.real == b.real) {\n" +
                "                if (a.imaginary <= b.imaginary) {\n" +
                "                    return true;\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        return false;\n" +
                "    }\n";
    }

    public static String grEqComplexFunc() {
        return "public boolean grEq(Complex a, Complex b) {\n" +
                "        if (a.real > b.real) {\n" +
                "            return true;\n" +
                "        } else {\n" +
                "            if (a.real == b.real) {\n" +
                "                if (a.imaginary >= b.imaginary) {\n" +
                "                    return true;\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        return false;\n" +
                "    }\n";
    }

    public static String grComplexFunc() {
        return "public boolean gr(Complex a, Complex b) {\n" +
                "        if (a.real > b.real) {\n" +
                "            return true;\n" +
                "        }\n" +
                "        if (a.real == b.real) {\n" +
                "            if (a.imaginary > b.imaginary) {\n" +
                "                return true;\n" +
                "            }\n" +
                "        }\n" +
                "        return false;\n" +
                "    }\n";
    }
    public static String neqComplexFunc() {
        return "public boolean neq(Complex a, Complex b) {\n" +
                "        if ((a.real != b.real) || (a.imaginary != b.imaginary)) {\n" +
                "            return true;\n" +
                "        } else {\n" +
                "            return false;\n" +
                "        }\n" +
                "    }\n";
    }

    public static String re() {
        return "public double re(Complex a){\n" +
                "        return a.real;\n" +
                "    }\n";
    }

    public static String im() {
        return "public double im(Complex a){\n" +
                "        return a.imaginary;\n" +
                "    }\n";
    }

    public static String complInt() {
        return "public Complex compl(int a) {\n" +
                "        return new Complex(a, 0);\n" +
                "    }\n";
    }

    public static String complReal() {
        return "public Complex compl(double a) {\n" +
                "        return new Complex(a, 0);\n" +
                "    }\n";
    }

    public static String complRealReal() {
        return "public Complex compl(double a, double b) {\n" +
                "        return new Complex(a, b);\n" +
                "    }\n";
    }

    public static String complRealInt() {
        return "public Complex compl(double a, int b) {\n" +
                "        return new Complex(a, b);\n" +
                "    }\n";
    }

    public static String complIntReal() {
        return "public Complex compl(int a, double b) {\n" +
                "        return new Complex(a, b);\n" +
                "    }\n";
    }

    public static String complIntInt() {
        return "public Complex compl(int a, int b) {\n" +
                "        return new Complex(a, b);\n" +
                "    }\n";
    }
}
