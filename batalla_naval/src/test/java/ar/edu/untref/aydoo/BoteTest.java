package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class BoteTest {

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

}
