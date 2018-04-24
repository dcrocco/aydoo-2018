package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class VentaTest {

    @Test
    public void ventaDeUnLibroDe500AClienteNoRegistradoEnEneroDe2018() {
        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente();
        Producto unLibro = new Producto(500);
        Venta venta = new Venta(1, 2018, unCliente, unLibro);
        Float importeACobrar = venta.obtenerImporteACobrar(libreria);
        Assert.assertEquals(500.0f, importeACobrar, 0.001);
    }

    @Test
    public void ventaDeUnaRevistaDe300AClienteRegistradoEnEneroDe2018() {
        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente();
        Producto unLibro = new Producto(300);
        libreria.registrarCliente(unCliente);
        Venta venta = new Venta(1, 2018, unCliente, unLibro);
        Float importeACobrar = venta.obtenerImporteACobrar(libreria);
        Assert.assertEquals(285.0f, importeACobrar, 0.001);
    }


}
