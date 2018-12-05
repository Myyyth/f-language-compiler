import bytecode_generator.CodeCompiler;
import bytecode_generator.Interpreter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        (new CodeCompiler()).compile("Run");
        (new Interpreter()).run("Run");
    }
}
