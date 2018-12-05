import bytecode_generator.CodeCompiler;
import bytecode_generator.Interpreter;
import lexer.Lexer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {

        String s = "d: integer is 5;";


        (new CodeCompiler()).compile("Run", s);
        (new Interpreter()).run("Run");
    }
}
