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
import java.lang.reflect.Constructor;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            String entireFileText = new Scanner(new File("input1.f"))
                    .useDelimiter("\\A").next();

            (new CodeCompiler()).compile("Run", entireFileText);
            (new Interpreter()).run("Run");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void fun(Callable f) throws Exception {
        f.call();
    }

    static void printHello(StringBuilder prep) {
        prep.append("Hello");
        System.out.println("hello");
    }
}


