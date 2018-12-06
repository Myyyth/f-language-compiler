import bytecode_generator.CodeCompiler;
import bytecode_generator.Interpreter;
import jdk.nashorn.internal.codegen.CompilerConstants;
import lexer.Lexer;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {

        String s = "b:integer is 1; d is func(a: func():integer):integer => b * 2 + a();\n";
        String s1 = "b:integer is 5; d is func():integer do print(b); return 0; end; c:integer is d();";


        (new CodeCompiler()).compile("Run", s1);
        (new Interpreter()).run("Run");

    }

    static void fun(Callable f) throws Exception {
        f.call();
    }

    static void printHello(StringBuilder prep) {
        prep.append("Hello");
        System.out.println("hello");
    }
}


