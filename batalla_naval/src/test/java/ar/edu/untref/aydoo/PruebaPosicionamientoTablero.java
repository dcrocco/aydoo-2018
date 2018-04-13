package ar.edu.untref.aydoo;

import org.junit.Test;

public class PruebaPosicionamientoTablero {

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
