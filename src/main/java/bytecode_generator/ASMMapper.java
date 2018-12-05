package bytecode_generator;

import org.objectweb.asm.*;
import static org.objectweb.asm.Opcodes.*;

public class ASMMapper {
    public void createComplexClass(ClassWriter cw) {
        FieldVisitor fv;
        {
            fv = cw.visitField(ACC_PUBLIC, "real", "D", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC, "imaginary", "D", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_FINAL + ACC_SYNTHETIC, "this$0", "Lbytecode_generator/Structure;", null, null);
            fv.visitEnd();
        }
    }
}
