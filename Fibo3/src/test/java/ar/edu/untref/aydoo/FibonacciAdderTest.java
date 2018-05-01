package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciAdderTest {

    @Test
    public void testAddSequenceOfFibonacciWithN5(){
        FibonacciCalculator fiboCalc = new FibonacciCalculator();
        FibonacciAdder fiboAdder = new FibonacciAdder();
        fiboAdder.get_fibonacci_added_sequence(5, fiboCalc);
        Assert.assertEquals(7,  fiboAdder.get_fibonacci_added_sequence(5, fiboCalc));
    }
}
