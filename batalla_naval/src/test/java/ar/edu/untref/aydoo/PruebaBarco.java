package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class PruebaBarco {

    @Test
    public void posicionarBoteYPreguntarPosicion() {
        Bote bote = new Bote();
        Posicion posicion = new Posicion(1, 1);
        bote.setPosicion(posicion);
        Assert.assertTrue(bote.estaEn(posicion));
    }

    @Test
    public void posicionarBoteYPreguntarFalsaPosicion() {
        Bote bote = new Bote();
        Posicion posicion = new Posicion(1, 1);
        Posicion posicionFalsa = new Posicion(1, 2);

        bote.setPosicion(posicion);
        Assert.assertFalse(bote.estaEn(posicionFalsa));
    }

    @Test
    public void posicionarCruceroVertical() {
        Crucero crucero = new Crucero();
        crucero.setOrientacionHorizontal(false);
        Assert.assertFalse(crucero.isOrientacionHorizontal());
    }

    @Test
    public void posicionarCruceroYPreguntarPosiciones() {
        Crucero crucero = new Crucero();
        Posicion posicionx1y1 = new Posicion(1, 1);
        Posicion posicionx1y2 = new Posicion(1, 2);
        crucero.setPosicion(posicionx1y1);
        Assert.assertTrue(crucero.estaEn(posicionx1y1));
        Assert.assertTrue(crucero.estaEn(posicionx1y2));
    }

    @Test
    public void posicionarCruceroVerticalYPreguntarPosiciones() {
        Crucero crucero = new Crucero();
        crucero.setOrientacionHorizontal(false);
        Posicion posicionx1y1 = new Posicion(1, 1);
        Posicion posicionx2y1 = new Posicion(2, 1);
        crucero.setPosicion(posicionx1y1);
        Assert.assertTrue(crucero.estaEn(posicionx1y1));
        Assert.assertTrue(crucero.estaEn(posicionx2y1));
    }


}
