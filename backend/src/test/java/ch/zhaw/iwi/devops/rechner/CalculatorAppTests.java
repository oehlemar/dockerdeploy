package ch.zhaw.iwi.devops.rechner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorAppTests {

    CalculatorApp calculator = new CalculatorApp();

    // Test einer normalen Addition
    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3));
    }
    // Test einer Addition mit negativen Zahlen
    @Test
    void testAddingNegatives() {
        assertEquals(-7, calculator.add(-3, -4));
    }
    // Test einer normalen Subtraktion
    @Test
    void testSubtraction() {
        assertEquals(1, calculator.subtract(4, 3));
    }
    // Test einer Subtraktion mit negativen Zahlen
    @Test
    void testSubtractingNegatives() {
        assertEquals(3, calculator.subtract(-10, -13));
    }
    // Test einer normalen Multiplikation
    @Test
    void testMultiplication() {
        assertEquals(36, calculator.multiply(3, 12));
    }
    // Test einer Multiplikation mit negativen Zahlen
    @Test
    void testMultiplyingNegatives() {
        assertEquals(8, calculator.multiply(-4, -2));
    }
    // Test einer normalen Division
    @Test
    void testDivision() {
        assertEquals(4, calculator.divide(8, 2));
    }
    // Test einer Division mit negativen Zahlen
    @Test
    void testDividingNegatives() {
        assertEquals(2, calculator.divide(-4, -2));
    }

    // Test einer Division durch 0
    @Test
    void testDivisionByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, ()-> calculator.divide(5, 0));
    }
    // Test nur ganzzahlige Divisionen
    @Test
    void testDivisionNonFullNumber() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, ()->calculator.divide(5, 2));
    }
    // Test Quadratwurzel
    @Test
    void testSquareRoot() {
        assertEquals(3, calculator.squareRoot(9), 0.001);
        assertEquals(5, calculator.squareRoot(25), 0.001);
        assertEquals(10, calculator.squareRoot(100), 0.001);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->calculator.squareRoot(-2));
    }
    // Test Logarithmus
    @Test
    void testLogarithm() {
        assertEquals(0, calculator.log(1), 0.001);
        assertEquals(1, calculator.log(Math.E), 0.001);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->calculator.log(-2));
    }
}
