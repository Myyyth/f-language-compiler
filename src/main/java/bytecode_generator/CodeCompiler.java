package bytecode_generator;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CodeCompiler {
    public void compile(String fileName) throws IOException {
        String classDef = ""
                + "public class " + fileName + " implements Runnable {"
                + "  public void run() {" +
                "        System.out.println(\"Hello\");" +
                "    }"
                + "}";

        String directoryName = "target/classes/src/";
        Path sourceFile = Paths.get(directoryName + "/" + fileName + ".java");

        File directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdirs();
        }

        Files.write(sourceFile, classDef.getBytes());
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            System.out.println("JDK required (running inside of JRE)");
            System.exit(1);
        }

        int compilationResult = compiler.run(null, null, null, sourceFile.toString());
        Files.deleteIfExists(sourceFile);
        if (compilationResult == 0) {
            System.out.println("Compilation is successful. Compiled class located in /target/src/...");
        } else {
            System.out.println("Compilation Failed");
            System.exit(1);
        }
    }
}
