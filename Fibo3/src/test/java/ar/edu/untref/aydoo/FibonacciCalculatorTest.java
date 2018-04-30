package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class FibonacciCalculatorTest
{
    @Test
    public void testFirstNumber()
    {
        FibonacciCalculator fibo = new FibonacciCalculator();
        int result = fibo.get_fibonacci_number(1);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testSecondNumber()
    {
        FibonacciCalculator fibo = new FibonacciCalculator();
        int result = fibo.get_fibonacci_number(2);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testFifthNumber()
    {
        FibonacciCalculator fibo = new FibonacciCalculator();
        int result = fibo.get_fibonacci_number(5);
        Assert.assertEquals(5, result);
    }

    @Test
    public void testInvalidNumber()
    {
        FibonacciCalculator fibo = new FibonacciCalculator();
        int result = fibo.get_fibonacci_number(-5);
        Assert.assertEquals(-1, result);
    }


}
