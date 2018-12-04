package bytecode_generator;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.objectweb.asm.Opcodes.*;

public class Generator {

    private ArrayList<Object> operations;

    public Generator(ArrayList<Object> operations) {
        this.operations = operations;
    }

    public byte[] toByteCode() {
        String className = "FLanguage";

        ClassWriter cw = new ClassWriter(2);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, className, null, "java/lang/Object", new String[]{"java/lang/Runnable"});

        cw.visitSource(className + ".java", null);

        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "run", "()V", null, null);
            mv.visitCode();
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");

            /*
                Generate code from tree
             */


            mv.visitLdcInsn("Hello");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            /*
                End of generated code
             */

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }
        cw.visitEnd();
        return cw.toByteArray();
    }

    public void saveToFile() {
        try {
            FileOutputStream stream = new FileOutputStream(new File("Flanguage"));
            stream.write(toByteCode());
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IllegalAccessException, InstantiationException {
        Class<?> aClass = ByteCodeLoader.clazz.loadClass( //загружаем байткод и получем класс
                toByteCode()
        );

        ((Runnable)aClass.newInstance()).run(); //создаем класс и запускаем
    }
}
