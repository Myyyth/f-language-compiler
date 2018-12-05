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
                "@Override\n" +
                "        public String toString() {\n" +
                "            return String.valueOf(real) + \"i\" + String.valueOf(imaginary);\n" +
                "        }\n" +
                "    }\n";
    }

    public String createComplexObject(String var, double real, double imaginary) {
        return "Complex "+var+" = new Complex("+real+", "+imaginary+");\n";
    }

    public String printObject(String var) {
        return "System.out.println("+var+".toString());\n";
    }

    public String sumComplexFunc() {
        return "public Complex sum(Complex a, Complex b) {\n" +
                "        return new Complex(a.real + b.real, a.imaginary + b.imaginary);\n" +
                "    }\n";
    }

    public String sumComplexWithIntFunc() {
        return "public Complex sum(Complex a, int b) {\n" +
                "        return new Complex(a.real + b, a);\n" +
                "    }\n";
    }

    public String sumComplexWithRealFunc() {
        return "public Complex sum(Complex a, real b) {\n" +
                "        return new Complex(a.real + b, a);\n" +
                "    }\n";
    }

    public String subComplexFunc() {
        return "public Complex sub(Complex a, Complex b) {\n" +
                "        return new Complex(a.real + b.real, a.imaginary + b.imaginary);\n" +
                "    }\n";
    }

    public String subComplexWithIntRightFunc() {
        return "public Complex sub(Complex a, int b) {\n" +
                "        return new Complex(a.real - b, a);\n" +
                "    }\n";
    }

    public String subComplexWithIntLeftFunc() {
        return "public Complex sub(int a, Complex b) {\n" +
                "        return new Complex(a - b.real, b.imaginary);\n" +
                "    }\n";
    }

    public String subComplexWithRealRightFunc() {
        return "public Complex sub(Complex a, real b) {\n" +
                "        return new Complex(a.real - b, a);\n" +
                "    }\n";
    }

    public String subComplexWithRealLeftFunc() {
        return "public Complex sub(real a, Complex b) {\n" +
                "        return new Complex(a - b.real, b.imaginary);\n" +
                "    }\n";
    }

    public String mulComplexFunc() {
        return "public Complex mul(Complex a, Complex b) {\n" +
                "        return new Complex(a.real * b.real, a.imaginary * b.imaginary);\n" +
                "    }\n";
    }

    public String mulComplexWithIntFunc() {
        return "public Complex mul(Complex a, int b) {\n" +
                "        return new Complex(a.real * b, a);\n" +
                "    }\n";
    }

    public String mulComplexWithRealFunc() {
        return "public Complex mul(Complex a, real b) {\n" +
                "        return new Complex(a.real * b, a);\n" +
                "    }\n";
    }

    public String divComplexFunc() {
        return "public Complex div(Complex a, Complex b) {\n" +
                "        return new Complex(a.real / b, a);\n" +
                "    }\n";
    }

    public String divComplexWithRealRightFunc() {
        return "public Complex div(Complex a, real b) {\n" +
                "        return new Complex(a.real / b, a);\n" +
                "    }\n";
    }

    public String divComplexWithRealLeftFunc() {
        return "public Complex div(real a, Complex b) {\n" +
                "        return new Complex(a / b.real, b.imaginary);\n" +
                "    }\n";
    }

    public String divComplexWithLeftIntFunc() {
        return "public Complex div(int a, Complex b) {\n" +
                "        return new Complex(a / b.real, b.imaginary);\n" +
                "    }\n";
    }

    public String eqComplexFunc() {
        return "public boolean eq(Complex a, Complex b) {\n" +
                "        if ((a.real == b.real) && (a.imaginary == b.imaginary)) {\n" +
                "            return true;\n" +
                "        } else {\n" +
                "            return false;\n" +
                "        }\n" +
                "    }\n";
    }

    public String lessComplexFunc() {
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

    public String lessEqComplexFunc() {
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

    public String grEqComplexFunc() {
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

    public String grComplexFunc() {
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
    public String neqComplexFunc() {
        return "public boolean neq(Complex a, Complex b) {\n" +
                "        if ((a.real != b.real) || (a.imaginary != b.imaginary)) {\n" +
                "            return true;\n" +
                "        } else {\n" +
                "            return false;\n" +
                "        }\n" +
                "    }\n";
    }

    public String re() {
        return "public double re(Complex a){\n" +
                "        return a.real;\n" +
                "    }\n";
    }

    public String im() {
        return "public double im(Complex a){\n" +
                "        return a.imaginary;\n" +
                "    }\n";
    }

    public String complInt() {
        return "public Complex compl(int a) {\n" +
                "        return new Complex(a, 0);\n" +
                "    }\n";
    }

    public String complReal() {
        return "public Complex compl(double a) {\n" +
                "        return new Complex(a, 0);\n" +
                "    }\n";
    }

    public String complRealReal() {
        return "public Complex compl(double a, double b) {\n" +
                "        return new Complex(a, b);\n" +
                "    }\n";
    }

    public String complRealInt() {
        return "public Complex compl(double a, int b) {\n" +
                "        return new Complex(a, b);\n" +
                "    }\n";
    }

    public String complIntReal() {
        return "public Complex compl(int a, double b) {\n" +
                "        return new Complex(a, b);\n" +
                "    }\n";
    }

    public String complIntInt() {
        return "public Complex compl(int a, int b) {\n" +
                "        return new Complex(a, b);\n" +
                "    }\n";
    }
}
