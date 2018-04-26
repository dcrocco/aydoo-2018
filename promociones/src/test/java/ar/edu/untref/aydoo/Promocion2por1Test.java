package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Promocion2por1Test {

    @Test
    public void promocionConUnSoloProductoSeMantienePrecio() {
        Producto jabon = new Producto("jabon", 10d);
        Promocion2por1 promo = new Promocion2por1(jabon);
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(jabon);

        Double total = promo.aplicar(productos);

        assertEquals(12.10d, total, 0d);
    }

    @Test
    public void promocionConDosProductosMantienePrecioDeUno() {
        Producto jabon = new Producto("jabon", 10d);
        Promocion2por1 promo = new Promocion2por1(jabon);
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(jabon);
        productos.add(jabon);

        Double total = promo.aplicar(productos);

        assertEquals(12.10d, total, 0d);
    }

    @Test
    public void promocionConTresProductosDuplicaElPrecioDeUno() {
        Producto jabon = new Producto("jabon", 10d);
        Promocion2por1 promo = new Promocion2por1(jabon);
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(jabon);
        productos.add(jabon);
        productos.add(jabon);

        Double total = promo.aplicar(productos);

        assertEquals(24.20d, total, 0.1d);
    }

}
