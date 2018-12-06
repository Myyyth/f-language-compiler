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
        String s = "b:integer is 1; d is func(a: func():integer):integer => b * 2 + a();\n";
        String s1 = "b:integer is 5; d is func():integer do print(b); return 0; end; c:integer is d();";
        String s2 = "a:integer is 1; d is func(c: integer): integer do while c < 5 loop print(c); c := c + 1; end; return 0; end; z:integer is d(a);";
        String s4 = "a:rational is 2+1\\4; b is func():integer do print(a); return 0; end; c:integer is b();";

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


