package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArticuloDeLibreriaTest {

    @Test
    public void ObtenerPrecioConIva21(){
        ArticuloDeLibreria articulo = new ArticuloDeLibreria(500.0f, 21.0f);
        Assert.assertEquals(605.0f, articulo.getPrecio(), 0.01);
    }

}
