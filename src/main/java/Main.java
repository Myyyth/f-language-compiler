import bytecode_generator.CodeCompiler;
import bytecode_generator.Interpreter;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            String entireFileText = new Scanner(new File("input.f"))
                    .useDelimiter("\\A").next();

            (new CodeCompiler()).compile("Run", entireFileText);
            (new Interpreter()).run("Run");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


