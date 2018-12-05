package bytecode_generator;

public class Structure implements Runnable {
    public void run() {
        Complex complex = new Complex(2424, 857);
        System.out.println(complex.imaginary);
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
}