import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.concurrent.Callable;
public class Run implements Runnable {
  public void run() {
  try {Integer b= new Integer(5);
final Integer bd = b;
class d implements Callable {
d() {
}
public Integer call() throws Exception {
System.out.println(bd);
return 0;
}
}
Integer c= new Integer((new d()).call().toString());
  } catch (Exception e) {}    }
public boolean[] addBooleanArrayArray(boolean[] a, boolean[] b) {
        int lenA = a.length;
        int lenB = b.length;
        boolean[] newArr = new boolean[lenA + lenB];
        int k = 0;
        for (int i = 0; i < lenA; i++) {
            newArr[i] = a[i];
            k = i;
        }
        for (int i = 0; i < lenB; i++) {
            newArr[k] = b[i];
            k++;
        }
        return newArr;
}
public boolean[] addBooleanArrayEntity(boolean[] a, boolean e) {
        int len = a.length;
        boolean[] newArr = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            newArr[i] = a[i];
        }
        newArr[len] = e;
        return newArr;
    }
public int[] addIntArrayArray(int[] a, int[] b) {
        int lenA = a.length;
        int lenB = b.length;
        int[] newArr = new int[lenA + lenB];
        int k = 0;
        for (int i = 0; i < lenA; i++) {
            newArr[i] = a[i];
            k = i;
        }
        for (int i = 0; i < lenB; i++) {
            newArr[k] = b[i];
            k++;
        }
        return newArr;
    }
public int[] addIntArrayEntity(int[] a, int e) {
        int len = a.length;
        int[] newArr = new int[len + 1];
        for (int i = 0; i < len; i++) {
            newArr[i] = a[i];
        }
        newArr[len] = e;
        return newArr;
    }
public int addIntInt(int a, int b) {
        return a + b;
    }
public Rational addIntRational(int a, Rational b) {
        int nom = b.num;
        int denom = b.denom;
        return new Rational(a * denom + nom, denom);
    }
public int addIntReal(int a, int b) {
        return a + b;
    }
public Rational[] addRationalArrayArray(Rational[] a, Rational[] b) {
        int lenA = a.length;
        int lenB = b.length;
        Rational[] newArr = new Rational[lenA + lenB];
        int k = 0;
        for (int i = 0; i < lenA; i++) {
            newArr[i] = a[i];
            k = i;
        }
        for (int i = 0; i < lenB; i++) {
            newArr[k] = b[i];
            k++;
        }
        return newArr;
    }
public Rational[] addRationalArrayEntity(Rational[] a, Rational e) {
        int len = a.length;
        Rational[] newArr = new Rational[len + 1];
        for (int i = 0; i < len; i++) {
            newArr[i] = a[i];
        }
        newArr[len] = e;
        return newArr;
    }
public Rational addRationalInt(Rational a, int b) {
        int nom = a.num;
        int denom = a.denom;
        return new Rational(b * denom + nom, denom);
    }
public Rational addRationalRational(Rational a, Rational b) {
        int nomA = a.num;
        int denomA = a.denom;
        int nomB = b.num;
        int denomB = b.denom;
        return new Rational(nomA * denomB + nomB * denomA, denomA * denomB);
    }
public double[] addRealArrayArray(double[] a, double[] b) {
        int lenA = a.length;
        int lenB = b.length;
        double[] newArr = new double[lenA + lenB];
        int k = 0;
        for (int i = 0; i < lenA; i++) {
            newArr[i] = a[i];
            k = i;
        }
        for (int i = 0; i < lenB; i++) {
            newArr[k] = b[i];
            k++;
        }
        return newArr;
    }
public double[] addRealArrayEntity(double[] a, double e) {
        int len = a.length;
        double[] newArr = new double[len + 1];
        for (int i = 0; i < len; i++) {
            newArr[i] = a[i];
        }
        newArr[len] = e;
        return newArr;
    }
public double addRealInt(double a, int b) {
        return a + b;
    }
public double addRealReal(double a, double b) {
        return a + b;
    }
public String[] addStringArrayArray(String[] a, String[] b) {
        int lenA = a.length;
        int lenB = b.length;
        String[] newArr = new String[lenA + lenB];
        int k = 0;
        for (int i = 0; i < lenA; i++) {
            newArr[i] = a[i];
            k = i;
        }
        for (int i = 0; i < lenB; i++) {
            newArr[k] = b[i];
            k++;
        }
        return newArr;
    }
public String[] addStringArrayEntity(String[] a, String e) {
        int len = a.length;
        String[] newArr = new String[len + 1];
        for (int i = 0; i < len; i++) {
            newArr[i] = a[i];
        }
        newArr[len] = e;
        return newArr;
    }
public Complex compl(int a) {
        return new Complex(a, 0);
    }
public Complex compl(int a, int b) {
        return new Complex(a, b);
    }
public Complex compl(double a) {
        return new Complex(a, 0);
    }
public Complex compl(int a, double b) {
        return new Complex(a, b);
    }
public Complex compl(double a, int b) {
        return new Complex(a, b);
    }
public Complex compl(double a, double b) {
        return new Complex(a, b);
    }
public double denomRat(Rational a) {
        return a.denom;
    }
public Complex div(Complex a, Complex b) {
        return new Complex(a.real / b.real, a.imaginary / b.imaginary);
    }
public Complex div(int a, Complex b) {
        return new Complex(a / b.real, b.imaginary);
    }
public Complex div(double a, Complex b) {
        return new Complex(a / b.real, b.imaginary);
    }
public Complex div(Complex a, double b) {
        return new Complex(a.real / b, a.imaginary);
    }
public int divIntInt(int a, int b) {
        return a / b;
    }
public Rational divIntRational(int a, Rational b) {
        int nom = b.num;
        int denom = b.denom;
        return new Rational(a * denom, nom);
    }
public double divIntReal(int a, double b) {
        return a / b;
    }
public Rational divRationalInt(Rational a, int b) {
        int nom = a.num;
        int denom = a.denom;
        return new Rational(nom, b * denom);
    }
public Rational divRationalRational(Rational a, Rational b) {
        int nomA = a.num;
        int denomA = a.denom;
        int nomB = b.num;
        int denomB = b.denom;
        return new Rational(nomA * denomB, denomA * nomB);
    }
public double divRealInt(double a, int b) {
        return a / b;
    }
public double divRealReal(double a, double b) {
        return a / b;
    }
public boolean eq(Complex a, Complex b) {
        if ((a.real == b.real) && (a.imaginary == b.imaginary)) {
            return true;
        } else {
            return false;
        }
    }
public boolean equalIntInt(int a, int b) {
        return a == b;
    }
public boolean equalIntRational(int a, Rational b) {
        int nom = b.num;
        int denom = b.denom;
        return a == (nom / denom);
    }
public boolean equalIntReal(int a, double b) {
        return a == b;
    }
public boolean equalRationalInt(Rational a, int b) {
        int nom = a.num;
        int denom = a.denom;
        return (nom / denom) == b;
    }
public boolean equalRationalRational(Rational a, Rational b) {
        int nomA = a.num;
        int denomA = a.denom;
        int nomB = b.num;
        int denomB = b.denom;
        return (nomA / denomA) == (nomB / denomB);
    }
public boolean equalRealInt(double a, int b) {
        return a == b;
    }
public boolean equalRealReal(double a, double b) {
        return a == b;
    }
public boolean exclusiveOrBoolBool(boolean a, boolean b) {
        return a ^ b;
    }
public boolean gr(Complex a, Complex b) {
        if (a.real > b.real) {
            return true;
        }
        if (a.real == b.real) {
            if (a.imaginary > b.imaginary) {
                return true;
            }
        }
        return false;
    }
public boolean grEq(Complex a, Complex b) {
        if (a.real > b.real) {
            return true;
        } else {
            if (a.real == b.real) {
                if (a.imaginary >= b.imaginary) {
                    return true;
                }
            }
        }
        return false;
    }
public double im(Complex a){
        return a.imaginary;
    }
public boolean less(Complex a, Complex b) {
        if (a.real < b.real) {
            return true;
        }
        if (a.real == b.real) {
            if (a.imaginary < b.imaginary) {
                return true;
            }
        }
        return false;
    }
public boolean lessEq(Complex a, Complex b) {
        if (a.real < b.real) {
            return true;
        } else {
            if (a.real == b.real) {
                if (a.imaginary <= b.imaginary) {
                    return true;
                }
            }
        }
        return false;
    }
public boolean lessEqualIntInt(int a, int b) {
        return a <= b;
    }
public boolean lessEqualIntRational(int a, Rational b) {
        int nom = b.num;
        int denom = b.denom;
        return a <= (nom / denom);
    }
public boolean lessEqualIntReal(int a, double b) {
        return a <= b;
    }
public boolean lessEqualRationalInt(Rational a, int b) {
        int nom = a.num;
        int denom = a.denom;
        return (nom / denom) <= b;
    }
public boolean lessEqualRationalRational(Rational a, Rational b) {
        int nomA = a.num;
        int denomA = a.denom;
        int nomB = b.num;
        int denomB = b.denom;
        return (nomA / denomA) <= (nomB / denomB);
    }
public boolean lessEqualRealInt(double a, int b) {
        return a <= b;
    }
public boolean lessEqualRealReal(double a, double b) {
        return a <= b;
    }
public boolean lessIntInt(int a, int b) {
        return a < b;
    }
public boolean lessIntRational(int a, Rational b) {
        int nom = b.num;
        int denom = b.denom;
        return a < (nom / denom);
    }
public boolean lessIntReal(int a, double b) {
        return a < b;
    }
public boolean lessRationalInt(Rational a, int b) {
        int nom = a.num;
        int denom = a.denom;
        return (nom / denom) < b;
    }
public boolean lessRationalRational(Rational a, Rational b) {
        int nomA = a.num;
        int denomA = a.denom;
        int nomB = b.num;
        int denomB = b.denom;
        return (nomA / denomA) < (nomB / denomB);
    }
public boolean lessRealInt(double a, int b) {
        return a < b;
    }
public boolean lessRealReal(double a, double b) {
        return a < b;
    }
public boolean logicalAndBoolBool(boolean a, boolean b) {
        return a && b;
    }
public boolean logicalOrBoolBool(boolean a, boolean b) {
        return a || b;
    }
public boolean moreEqualIntInt(int a, int b) {
        return a >= b;
    }
public boolean moreEqualIntRational(int a, Rational b) {
        int nom = b.num;
        int denom = b.denom;
        return a >= (nom / denom);
    }
public boolean moreEqualIntReal(int a, double b) {
        return a >= b;
    }
public boolean moreEqualRationalInt(Rational a, int b) {
        int nom = a.num;
        int denom = a.denom;
        return (nom / denom) >= b;
    }
public boolean moreEqualRationalRational(Rational a, Rational b) {
        int nomA = a.num;
        int denomA = a.denom;
        int nomB = b.num;
        int denomB = b.denom;
        return (nomA / denomA) >= (nomB / denomB);
    }
public boolean moreEqualRealInt(double a, int b) {
        return a >= b;
    }
public boolean moreEqualRealReal(double a, double b) {
        return a >= b;
    }
public boolean moreIntInt(int a, int b) {
        return a > b;
    }
public boolean moreIntRational(int a, Rational b) {
        int nom = b.num;
        int denom = b.denom;
        return a > (nom / denom);
    }
public boolean moreIntReal(int a, double b) {
        return a > b;
    }
public boolean moreRationalInt(Rational a, int b) {
        int nom = a.num;
        int denom = a.denom;
        return (nom / denom) > b;
    }
public boolean moreRationalRational(Rational a, Rational b) {
        int nomA = a.num;
        int denomA = a.denom;
        int nomB = b.num;
        int denomB = b.denom;
        return (nomA / denomA) > (nomB / denomB);
    }
public boolean moreRealInt(double a, int b) {
        return a > b;
    }
public boolean moreRealReal(double a, double b) {
        return a > b;
    }
public Complex mul(Complex a, Complex b) {
        return new Complex(a.real * b.real, a.imaginary * b.imaginary);
    }
public Complex mul(Complex a, int b) {
        return new Complex(a.real * b, a.imaginary);
    }
public Complex mul(Complex a, double b) {
        return new Complex(a.real * b, a.imaginary);
    }
public int multIntInt(int a, int b) {
        return a * b;
    }
public Rational multIntRational(int a, Rational b) {
        int nom = b.num;
        int denom = b.denom;
        return new Rational(a * nom, denom);
    }
public double multIntReal(int a, double b) {
        return a * b;
    }
public Rational multRationalInt(Rational a, int b) {
        int nom = a.num;
        int denom = a.denom;
        return new Rational(b * nom, denom);
    }
public Rational multRationalRational(Rational a, Rational b) {
        int nomA = a.num;
        int denomA = a.denom;
        int nomB = b.num;
        int denomB = b.denom;
        return new Rational(nomA * nomB, denomA * denomB);
    }
public double multRealInt(double a, int b) {
        return a * b;
    }
public double multRealReal(double a, double b) {
        return a * b;
    }
public boolean neq(Complex a, Complex b) {
        if ((a.real != b.real) || (a.imaginary != b.imaginary)) {
            return true;
        } else {
            return false;
        }
    }
public Rational normRat(Rational a) {
        int num = a.num;
        int denom = a.denom;
        if (denom < 0) {
            num = -num;
            denom = -denom;
        }
        return new Rational(num, denom);
    }
public boolean notEqualIntInt(int a, int b) {
        return a != b;
    }
public boolean notEqualIntRational(int a, Rational b) {
        int nom = b.num;
        int denom = b.denom;
        return a != (nom / denom);
    }
public boolean notEqualIntReal(int a, double b) {
        return a != b;
    }
public boolean notEqualRationalInt(Rational a, int b) {
        int nom = a.num;
        int denom = a.denom;
        return (nom / denom) != b;
    }
public boolean notEqualRationalRational(Rational a, Rational b) {
        int nomA = a.num;
        int denomA = a.denom;
        int nomB = b.num;
        int denomB = b.denom;
        return (nomA / denomA) != (nomB / denomB);
    }
public boolean notEqualRealInt(double a, int b) {
        return a != b;
    }
public boolean notEqualRealReal(double a, double b) {
        return a != b;
    }
public double numRat(Rational a) {
        return a.num;
    }
public Rational ratInt(int a) {
        return new Rational(a, 1);
    }
public Rational ratIntInt(int a, int b) {
        return new Rational(a, b);
    }
public double re(Complex a){
        return a.real;
    }
public double roundRat(Rational a) {
        return (a.num / a.denom);
    }
public int roundReal(double a) {
        return (int) Math.round(a);
    }
public Complex sub(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.imaginary + b.imaginary);
    }
public Complex sub(int a, Complex b) {
        return new Complex(a - b.real, b.imaginary);
    }
public Complex sub(Complex a, int b) {
        return new Complex(a.real - b, a.imaginary);
    }
public Complex sub(double a, Complex b) {
        return new Complex(a - b.real, b.imaginary);
    }
public Complex sub(Complex a, double b) {
        return new Complex(a.real - b, a.imaginary);
    }
public int subtractIntInt(int a, int b) {
        return a - b;
    }
public Rational subtractIntRational(int a, Rational b) {
        int nom = b.num;
        int denom = b.denom;
        return new Rational(a * denom - nom, denom);
    }
public double subtractIntReal(int a, double b) {
        return a - b;
    }
public Rational subtractRationalInt(Rational a, int b) {
        int nom = a.num;
        int denom = a.denom;
        return new Rational(b * denom - nom, denom);
    }
public Rational subtractRationalRational(Rational a, Rational b) {
        int nomA = a.num;
        int denomA = a.denom;
        int nomB = b.num;
        int denomB = b.denom;
        return new Rational(nomA * denomB - nomB * denomA, denomA * denomB);
    }
public double subtractRealInt(double a, int b) {
        return a - b;
    }
public double subtractRealReal(double a, double b) {
        return a - b;
    }
public Complex sum(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.imaginary + b.imaginary);
    }
public Complex sum(Complex a, int b) {
        return new Complex(a.real + b, a.imaginary);
    }
public Complex sum(Complex a, double b) {
        return new Complex(a.real + b, a.imaginary);
    }
}
class Complex {
        public double real;
        public double imaginary;

        public Complex() { }

        public Complex(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }
    }
class Rational {
        public int num;
        public int denom;
        public Rational(int num, int denom) {
            this.num = num;
            this.denom = denom;
        }
@Override
        public String toString() {
            return String.valueOf(num) + "/" + String.valueOf(denom);
        }
    }
