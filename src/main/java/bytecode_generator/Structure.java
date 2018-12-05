package bytecode_generator;

public class Structure implements Runnable {
    public void run() {
        Complex complex = new Complex(2424, 857);
        System.out.println(complex.toString());
    }
    public class Complex {
        public double real;
        public double imaginary;

        public Complex() {
        }

        public Complex(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        @Override
        public String toString() {
            return String.valueOf(real) + "i" + String.valueOf(imaginary);
        }
    }

    public Complex sum(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.imaginary + b.imaginary);
    }

    public boolean eq(Complex a, Complex b) {
        if ((a.real == b.real) || (a.imaginary == b.imaginary)) {
            return true;
        } else {
            return false;
        }
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

    public Complex compl(int a) {
        return new Complex(a, 0);
    }

    public double re(Complex a){
        return a.real;
    }
}