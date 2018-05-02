package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    // Pruebas de disparos al tablero
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

    // Tests de ubicacion al tablero
    @Test
    public void PruebaUbicarBote() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(2, 2));
        Bote bote = new Bote();
        tablero.ubicarBarco(bote, new Posicion(1, 1));
    }

    @Test(expected = ExcepcionFueraDeTablero.class)
    public void PruebaUbicarBoteFueraDelTablero() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(2, 2));
        Bote bote = new Bote();
        tablero.ubicarBarco(bote, new Posicion(3, 3));
    }

    @Test
    public void PruebaUbicarCrucero() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(2, 2));
        Bote bote = new Bote();
        tablero.ubicarBarco(bote, new Posicion(1, 1));
    }

    @Test
    public void PruebaUbicarMultiplesBarcos() throws ExcepcionSuperposicion, ExcepcionFueraDeTablero {
        Tablero tablero = new Tablero(new Posicion(5, 5));
        Bote bote = new Bote();
        Crucero crucero = new Crucero();
        tablero.ubicarBarco(bote, new Posicion(1, 1));
        tablero.ubicarBarco(crucero, new Posicion(2, 1));

    }
    @Test(expected = ExcepcionFueraDeTablero.class)
    public void PruebaUbicarCruceroFueraDelTablero() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(2, 2));
        Crucero crucero = new Crucero();
        tablero.ubicarBarco(crucero, new Posicion(3, 1));
    }

    @Test(expected = ExcepcionFueraDeTablero.class)
    public void PruebaUbicarCruceroEnUnTableroMasChicoQueSuTamanio() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(1, 1));
        Crucero crucero = new Crucero();
        tablero.ubicarBarco(crucero, new Posicion(1, 1));
    }

    @Test(expected = ExcepcionSuperposicion.class)
    public void PruebaSuperponerBotes() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(5, 5));
        Bote bote = new Bote();
        Bote bote2 = new Bote();
        tablero.ubicarBarco(bote, new Posicion(1, 1));
        tablero.ubicarBarco(bote2, new Posicion(1, 1));
    }

    @Test(expected = ExcepcionSuperposicion.class)
    public void PruebaSuperponerBoteConCrucero() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(5, 5));
        Bote bote = new Bote();
        Crucero crucero = new Crucero();
        tablero.ubicarBarco(bote, new Posicion(1, 1));
        tablero.ubicarBarco(crucero, new Posicion(1, 1));
    }

    @Test(expected = ExcepcionSuperposicion.class)
    public void PruebaSuperponerCruceros() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(5, 5));
        Crucero crucero = new Crucero();
        Crucero crucero2 = new Crucero();
        tablero.ubicarBarco(crucero, new Posicion(1, 1));
        tablero.ubicarBarco(crucero2, new Posicion(1, 2));
    }

    @Test(expected = ExcepcionSuperposicion.class)
    public void PruebaSuperponerBordesDeCrucerosEnDistintaOrientacion() throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        Tablero tablero = new Tablero(new Posicion(5, 5));
        Crucero crucero = new Crucero();
        Crucero crucero2 = new Crucero();
        crucero2.setOrientacionHorizontal(false);
        tablero.ubicarBarco(crucero, new Posicion(2, 1));
        tablero.ubicarBarco(crucero2, new Posicion(1, 2));
    }

}
