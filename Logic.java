public class Logic {

    public double add(double a, double b) {
        return a + b;
    }
    public double subtract(double a, double b) {
        return a - b;
    }
    public  double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    public double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot take square root of a negative number");
        }
        return Math.sqrt(a);
    }
    public double percentage(double a, double b) {
        return (a * b) / 100;
    }
    
}
