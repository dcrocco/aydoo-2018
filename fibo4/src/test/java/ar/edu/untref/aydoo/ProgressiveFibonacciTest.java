package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProgressiveFibonacciTest {

    @Test
    public void printProgressiveAndDirect() {
        List<Integer> sucession = new ArrayList<>();
        sucession.add(0);
        sucession.add(1);
        sucession.add(1);
        sucession.add(2);
        sucession.add(3);
        sucession.add(5);
        ProgressiveFibonacci progresive = new ProgressiveFibonacci();
        String output = "\n0 \n0 1 \n0 1 1 \n0 1 1 2 \n0 1 1 2 3 \n0 1 1 2 3 5 ";
        Assert.assertEquals(progresive.giveShape(sucession), output);
    }
}
