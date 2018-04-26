package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by nicopaez on 25/04/2018.
 */
public class PromocionPorcentajeTest {

    @Test
    public void deberiaAplicarseSobreProductosIncluidos() {
        Producto jabon = new Producto("jabon", 10d);
        PromocionPorcentaje promo = new PromocionPorcentaje(jabon, 10d);
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(jabon);
        Double total = promo.aplicar(productos);

        assertEquals(10.89d, total, 0d);

    }

}
