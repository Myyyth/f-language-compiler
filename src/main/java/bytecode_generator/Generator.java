package bytecode_generator;

import org.objectweb.asm.*;

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
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "bytecode_generator/Structure", null, "java/lang/Object", new String[]{"java/lang/Runnable"});

        cw.visitSource("Structure.java", null);

        cw.visitInnerClass("bytecode_generator/Structure$Complex", "bytecode_generator/Structure", "Complex", Opcodes.ACC_PUBLIC);

        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(3, l0);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(Opcodes.RETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lbytecode_generator/Structure;", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "run", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitTypeInsn(Opcodes.NEW, "bytecode_generator/Structure$Complex");
            mv.visitInsn(Opcodes.DUP);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitLdcInsn(new Double("2424.0"));
            mv.visitLdcInsn(new Double("857.0"));
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "bytecode_generator/Structure$Complex", "<init>", "(Lbytecode_generator/Structure;DD)V", false);
            mv.visitVarInsn(Opcodes.ASTORE, 1);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(6, l1);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitFieldInsn(Opcodes.GETFIELD, "bytecode_generator/Structure$Complex", "imaginary", "D");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitInsn(Opcodes.RETURN);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLocalVariable("this", "Lbytecode_generator/Structure;", null, l0, l3, 0);
            mv.visitLocalVariable("complex", "Lbytecode_generator/Structure$Complex;", null, l1, l3, 1);
            mv.visitMaxs(7, 2);
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
