package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class VentaTest {

    @Test
    public void ventaDeUnLibroDe500AClienteNoRegistradoEnEneroDe2018() {
        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        Producto unLibro = new Producto(500);
        Fecha fecha = new Fecha(1, 2018);
        Venta venta = new Venta(fecha, unCliente, unLibro);
        Float importeACobrar = venta.obtenerImporteACobrar(libreria);
        Assert.assertEquals(500.0f, importeACobrar, 0.001);
    }

    @Test
    public void ventaDeUnaRevistaDe300AClienteRegistradoEnEneroDe2018() {
        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        Producto unLibro = new Producto(300);
        libreria.registrarCliente(unCliente);
        Fecha fecha = new Fecha(1, 2018);
        Venta venta = new Venta(fecha, unCliente, unLibro);
        Float importeACobrar = venta.obtenerImporteACobrar(libreria);
        Assert.assertEquals(285.0f, importeACobrar, 0.001);
    }


}
