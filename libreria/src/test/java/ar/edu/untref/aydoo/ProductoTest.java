package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {

    @Test
    public void obtenerPrecioDeUnLibro() {
        Libro libro = new Libro(200);
        Assert.assertEquals(200.0f, libro.getPrecio(),0.001);
    }

}
