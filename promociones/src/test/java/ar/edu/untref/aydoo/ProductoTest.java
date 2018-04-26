package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by nicopaez on 25/04/2018.
 */
public class ProductoTest {

    @Test
    public void calculaSuPrecioConIva() {
        Producto producto = new Producto("pan", 10d);
        Double total = producto.getPrecioConIva();
        double esperado = 12.1d;
        Assert.assertEquals(esperado, total,0d);
    }
}
