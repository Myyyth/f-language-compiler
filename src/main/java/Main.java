import bytecode_generator.CodeCompiler;
import bytecode_generator.Interpreter;
import jdk.nashorn.internal.codegen.CompilerConstants;
import lexer.Lexer;

import java.io.IOException;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {

        String s = "d is func(a: integer):integer => ;\n";

        Integer a = new Integer(10);
        Double c = new Double(10);
        System.out.println(a+c);

        (new CodeCompiler()).compile("Run", s);
        (new Interpreter()).run("Run");

        /*
        final Callable a = new Callable() {
            public Object call() throws Exception {
                System.out.println("hello");
                return null;
            }
        };

        Integer id = new Integer(10);
        final Integer id2 = new Integer(id);


        int abc = 0;
        final int babc = abc;
        class bClass implements Callable {
            int a;
            bClass() {

            }
            bClass(int a) {
                this.a = a;
            }

            public Integer call() throws Exception {
                return new Integer(2);
            }
        }
        Integer b;
        b = new bClass().call();
        System.out.println(b);
        new bClass(1).call();
        */
    }

    static void fun(Callable f) throws Exception {
        f.call();
    }

    static void printHello(StringBuilder prep) {
        prep.append("Hello");
        System.out.println("hello");
    }
}
