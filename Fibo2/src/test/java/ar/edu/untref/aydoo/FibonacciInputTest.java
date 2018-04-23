package ar.edu.untref.aydoo;

import org.junit.Test;

public class FibonacciInputTest
{
    @Test
    public void testValidInputWithOneDigit() throws IllegalArgumentException {
        String input[] = new String[]{"0"};
        Fibonacci.validate_input(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputWithOneDigit() throws IllegalArgumentException {
        String input[] = new String[]{"A"};
        Fibonacci.validate_input(input);
    }

    @Test
    public void testValidInputWithTwoArgumentsVerticalAndDirect() throws IllegalArgumentException {
        String input[] = new String[]{"-o=vd", "5"};
        Fibonacci.validate_input(input);
    }

    @Test
    public void testValidInputWithTwoArgumentsHorizontalEInverse() throws IllegalArgumentException {
        String input[] = new String[]{"-o=hi", "8"};
        Fibonacci.validate_input(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInValidInputWithTwoArguments() throws IllegalArgumentException {
        String input[] = new String[]{"-o=xy", "8"};
        Fibonacci.validate_input(input);
    }
}
