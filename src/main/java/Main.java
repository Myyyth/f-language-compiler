import bytecode_generator.CodeCompiler;
import bytecode_generator.Interpreter;
import lexer.Lexer;
import lexer.Token;
import parser.BalancedTree;
import parser.Parser;
import parser.Tree;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {
        String s = "arr: [integer] is [1,2,3];";

        Integer a = new Integer(10);
        Double c = new Double(10);
        System.out.println(a+c);

        (new CodeCompiler()).compile("Run", s);
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
