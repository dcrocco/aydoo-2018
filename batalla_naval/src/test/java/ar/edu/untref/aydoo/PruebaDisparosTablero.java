package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class PruebaDisparosTablero {

    @Test
    public void disparoATableroVacioYDevuelveAgua() throws ExcepcionFueraDeTablero {
        Tablero tablero = new Tablero(new Posicion(1, 1));
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(new Posicion(1,1));
        Assert.assertEquals(ResultadoDeDisparo.AGUA, resultadoDeDisparo);
    }

    @Test
    public void disparoATableroCuandoTocoUnBoteYDevuelveHundido() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(1, 1));
        Bote unBote = new Bote();
        tablero.ubicarBarco(unBote,new Posicion(1,1));
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(new Posicion(1,1));
        Assert.assertEquals(ResultadoDeDisparo.HUNDIDO, resultadoDeDisparo);
    }

    @Test
    public void disparoATableroCuandoTocoUnCruceroYDevuelveTocado() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(2, 2));
        Crucero unCrucero = new Crucero();
        tablero.ubicarBarco(unCrucero, new Posicion(1, 1));
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(new Posicion(1, 1));
        Assert.assertEquals(ResultadoDeDisparo.TOCADO, resultadoDeDisparo);
    }

    @Test
    public void disparoDosVecesATableroCuandoTocoUnCruceroYDevuelveHundido() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(2, 2));
        Crucero unCrucero = new Crucero();
        tablero.ubicarBarco(unCrucero, new Posicion(1, 1));
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(new Posicion(1, 1));
        Assert.assertEquals(ResultadoDeDisparo.TOCADO, resultadoDeDisparo);
        ResultadoDeDisparo resultadoDeSegundoDisparo = tablero.recibirDisparo(new Posicion(1, 2));
        Assert.assertEquals(ResultadoDeDisparo.HUNDIDO, resultadoDeSegundoDisparo);
    }

    @Test
    public void disparoDosVecesATableroCuandoTocoUnCruceroVerticalYDevuelveHundido() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(2, 2));
        Crucero unCrucero = new Crucero();
        unCrucero.setOrientacionHorizontal(false);
        tablero.ubicarBarco(unCrucero, new Posicion(1, 1));
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(new Posicion(1, 1));
        Assert.assertEquals(ResultadoDeDisparo.TOCADO, resultadoDeDisparo);
        ResultadoDeDisparo resultadoDeSegundoDisparo = tablero.recibirDisparo(new Posicion(2, 1));
        Assert.assertEquals(ResultadoDeDisparo.HUNDIDO, resultadoDeSegundoDisparo);
    }

    @Test(expected = ExcepcionFueraDeTablero.class)
    public void disparoAfueraDelTableroYDeuvelveExcepcion() throws ExcepcionFueraDeTablero {
        Tablero tablero = new Tablero(new Posicion(2, 2));
        tablero.recibirDisparo(new Posicion(3, 1));
    }
}
