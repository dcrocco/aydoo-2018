package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class PruebaBarco {

    @Test
    public void posicionarCruceroVertical() {
        Crucero crucero = new Crucero();
        crucero.setOrientacionHorizontal(false);
        Assert.assertFalse(crucero.isOrientacionHorizontal());
    }

}
