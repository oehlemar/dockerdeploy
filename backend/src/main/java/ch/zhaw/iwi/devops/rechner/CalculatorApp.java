package ch.zhaw.iwi.devops.rechner;

public class CalculatorApp {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        if (a%b != 0) {
            throw new ArithmeticException("Division result is non integer.");
        }
        return a / b;
    }
    public double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate the square root of a negative number.");
        }
        return Math.sqrt(number);
    }
    public double log(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Logarithm for non-positive numbers is undefined.");
        }
        return Math.log(number);
    }

}
