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
}
