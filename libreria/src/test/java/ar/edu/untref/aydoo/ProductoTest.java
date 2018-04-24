package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {

    @Test
    public void obtenerPrecioDeUnLibro() {
        Producto libro = new Producto(200);
        Assert.assertEquals(200.0f, libro.getPrecio(),0.001);
    }

    @Test
    public void obtenerPeriodicidadDeUnPeriodico() {
        ProductoSubscripcion periodico = new ProductoSubscripcion(200.0f, 8);
        Assert.assertEquals(8, periodico.getPeriodicidad(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarPrecioCero() {
        new Producto(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarUnPrecioNegativo() {
        new Producto(-100);
    }
}

