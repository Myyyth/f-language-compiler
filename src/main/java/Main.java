import lexer.Lexer;
import lexer.Token;
import parser.BalancedTree;
import parser.Parser;
import parser.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String entireFileText = new Scanner(new File("input.f"))
                    .useDelimiter("\\A").next();
            ArrayList<Token> tokens = new Lexer(entireFileText).parse();
            System.out.println(tokens);
            BalancedTree ast = new Parser(tokens).parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
