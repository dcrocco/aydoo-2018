package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by nicopaez on 25/04/2018.
 */
public class PromocionNulaTest {

    @Test
    public void deberiaSumaTodosLosItems() {
        Producto p1 = new Producto("pan", 10d);
        Producto p2 = new Producto("jabon", 10d);

        List<Producto> items = new ArrayList<Producto>();
        items.add(p1);
        items.add(p2);
        PromocionNula promo = new PromocionNula();
        Double resultado = promo.aplicar(items);

        assertEquals(24.20d, resultado, 0d);
    }
}
