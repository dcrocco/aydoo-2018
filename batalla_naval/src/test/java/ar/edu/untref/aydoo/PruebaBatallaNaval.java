package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class PruebaBatallaNaval {

    @Test
    public void disparoATableroVacioYDevuelveAgua(){
        Tablero tablero = new Tablero();
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(1, 1);
        Assert.assertEquals(ResultadoDeDisparo.AGUA, resultadoDeDisparo);
    }
}
