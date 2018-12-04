import com.sun.corba.se.impl.orb.ParserTable;
import lexer.Lexer;
import lexer.Token;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.BalancedTree;
import parser.Parser;
import parser.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import antlr4_gen.*;

public class Main {
    public static void main(String[] args) {
        try {
            String entireFileText = new Scanner(new File("input.f"))
                    .useDelimiter("\\A").next();
//            ArrayList<Token> tokens = new Lexer(entireFileText).parse();
//            System.out.println(tokens);
//            BalancedTree ast = new Parser(tokens).parse();
            fLexer flexer = new fLexer(CharStreams.fromString(entireFileText));
            CommonTokenStream tokens = new CommonTokenStream(flexer);
            fParser fparser = new fParser(tokens);
            fParser.ProgramContext programContext = fparser.program();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
