package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class PruebaTablero {

    /*
    cuando unico un barco indico la direccion V u H

    disparo fuera del tablero debria lanzar excepcion
    ubico un barco en una posicion ya ocupada, deberia lanzar excepcion
    ubicar un barco fuera del tablero deberia lanzar excepcion

         */
    @Test
    public void disparoATableroVacioYDevuelveAgua(){
        Tablero tablero = new Tablero();
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(new Posicion(1,1));
        Assert.assertEquals(ResultadoDeDisparo.AGUA, resultadoDeDisparo);
    }

    @Test
    public void disparoATableroCuandoTocoUnBoteYDevuelveHundido(){
        Tablero tablero = new Tablero();
        Bote unBote = new Bote();
        tablero.ubicarBote(unBote,new Posicion(1,1));
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(new Posicion(1,1));
        Assert.assertEquals(ResultadoDeDisparo.HUNDIDO, resultadoDeDisparo);
    }

    @Test
    public void disparoATableroCuandoTocoUnCruceroYDevuelveTocado(){
        Tablero tablero = new Tablero();
        Crucero unCrucero = new Crucero();
        tablero.ubicarCrucero(unCrucero, new Posicion(1, 1));
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(new Posicion(1, 1));
        Assert.assertEquals(ResultadoDeDisparo.TOCADO, resultadoDeDisparo);
    }

    @Test
    public void disparoDosVecesATableroCuandoTocoUnCruceroYDevuelveHundido(){
        Tablero tablero = new Tablero();
        Crucero unCrucero = new Crucero();
        tablero.ubicarCrucero(unCrucero, new Posicion(1, 1));
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(new Posicion(1, 1));
        Assert.assertEquals(ResultadoDeDisparo.TOCADO, resultadoDeDisparo);
        ResultadoDeDisparo resultadoDeSegundoDisparo = tablero.recibirDisparo(new Posicion(1, 2));
        Assert.assertEquals(ResultadoDeDisparo.HUNDIDO, resultadoDeSegundoDisparo);
    }

    @Test
    public void disparoDosVecesATableroCuandoTocoUnCruceroVerticalYDevuelveHundido(){
        Tablero tablero = new Tablero();
        Crucero unCrucero = new Crucero();
        unCrucero.setOrientacionHorizontal(false);
        tablero.ubicarCrucero(unCrucero, new Posicion(1, 1));
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(new Posicion(1, 1));
        Assert.assertEquals(ResultadoDeDisparo.TOCADO, resultadoDeDisparo);
        ResultadoDeDisparo resultadoDeSegundoDisparo = tablero.recibirDisparo(new Posicion(2, 1));
        Assert.assertEquals(ResultadoDeDisparo.HUNDIDO, resultadoDeSegundoDisparo);
    }

}
