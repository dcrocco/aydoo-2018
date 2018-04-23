package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciPrintTest
{
    @Test
    public void testPrintFibonacciSequenceWithOneArgument() {
        String input[] = new String[]{"8"};
        FibonacciCalculator calculator = new FibonacciCalculator();
        String sequence = calculator.get_fibonacci_string_sequence(8);
        Assert.assertEquals(
                "fibo<8>: 0 1 1 2 3 5 8 13",
            Fibonacci.print_fibonacci_sequence(sequence, 8, input)
        );
    }

    @Test
    public void testPrintFibonacciSequenceVerticalAndDirect() {
        String input[] = new String[]{"-o=vd","5"};
        FibonacciCalculator calculator = new FibonacciCalculator();
        String sequence = calculator.get_fibonacci_string_sequence(5);
        Assert.assertEquals(
                "fibo<5>:\n0\n1\n1\n2\n3",
            Fibonacci.print_fibonacci_sequence(sequence, 5, input)
        );
    }

    @Test
    public void testPrintFibonacciSequenceHorizontalAndInverse() {
        String input[] = new String[]{"-o=hi","8"};
        FibonacciCalculator calculator = new FibonacciCalculator();
        String sequence = calculator.get_fibonacci_string_sequence(8);
        Assert.assertEquals(
                "fibo<8>: 13 8 5 3 2 1 1 0",
            Fibonacci.print_fibonacci_sequence(sequence, 8, input)
        );
    }

    @Test
    public void testPrintFibonacciSequenceVerticalAndInverse() {
        String input[] = new String[]{"-o=vi","8"};
        FibonacciCalculator calculator = new FibonacciCalculator();
        String sequence = calculator.get_fibonacci_string_sequence(8);
        Assert.assertEquals(
                "fibo<8>:\n13\n8\n5\n3\n2\n1\n1\n0",
            Fibonacci.print_fibonacci_sequence(sequence, 8, input)
        );
    }

}
