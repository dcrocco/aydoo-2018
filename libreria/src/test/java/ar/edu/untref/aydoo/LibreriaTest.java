package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class LibreriaTest {

    @Test
    public void cobrarAUnClienteQueNoComproNadaEnEneroDe2018() {
        Libreria libreria = new Libreria();
        Fecha fecha = new Fecha(1, 2018);
        Cliente unCliente = new Cliente();
        Float importeACobrar = libreria.obtenerCobroMensual(fecha, unCliente);
        Assert.assertEquals(0.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueComproUnLibroDe500EnEneroDe2018() {
        Libreria libreria = new Libreria();
        Fecha fecha = new Fecha(1, 2018);
        Cliente unCliente = new Cliente();
        Producto unLibro = new Producto(500.0f);
        libreria.registrarVenta(fecha, unCliente, unLibro);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha, unCliente);
        Assert.assertEquals(500.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoQueComproUnaRevistaDe300EnMarzoDe2018() {
        Libreria libreria = new Libreria();
        Fecha fecha = new Fecha(3, 2018);
        Cliente unCliente = new Cliente();
        libreria.registrarCliente(unCliente);
        Producto unaRevista = new Producto(300.0f);
        libreria.registrarVenta(fecha, unCliente, unaRevista);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha, unCliente);
        Assert.assertEquals(285.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueRealizoUnaSubscripcionAnualDeUnPeriodico() {
        Producto unPeriodico = new Producto(150);
        Libreria libreria = new Libreria();
        Fecha fecha_inicial = new Fecha(12, 2017);
        Fecha fecha_final = new Fecha(12, 2018);
        Fecha fecha_venta = new Fecha(1, 2018);
        Cliente unCliente = new Cliente();
        libreria.registrarSubscripcion(unCliente, fecha_final, fecha_inicial, unPeriodico);
        libreria.registrarVenta(fecha_venta, unCliente, unPeriodico);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha_venta, unCliente);
        Assert.assertEquals(120.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoQueRealizoUnaSubscripcionAnualDeUnPeriodico() {
        Producto unPeriodico = new Producto(150);
        Libreria libreria = new Libreria();
        Fecha fecha_inicial = new Fecha(12, 2017);
        Fecha fecha_final = new Fecha(12, 2018);
        Fecha fecha_venta = new Fecha(1, 2018);
        Cliente unCliente = new Cliente();
        libreria.registrarSubscripcion(unCliente, fecha_final, fecha_inicial, unPeriodico);
        libreria.registrarCliente(unCliente);
        libreria.registrarVenta(fecha_venta, unCliente, unPeriodico);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha_venta, unCliente);
        Assert.assertEquals(120.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueComproMultiplesProductosEnLaMismaFecha() {
        Producto unPeriodico = new Producto(100);
        Producto unArticuloDeLibreria = new Producto(50);
        Fecha fecha_venta = new Fecha(1, 2018);
        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente();
        libreria.registrarVenta(fecha_venta, unCliente, unPeriodico);
        libreria.registrarVenta(fecha_venta, unCliente, unArticuloDeLibreria);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha_venta, unCliente);

        Assert.assertEquals(150.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoQueComproMultiplesProductosEnLaMismaFecha() {
        Producto unPeriodico = new Producto(100);
        Producto unArticuloDeLibreria = new Producto(50);
        Fecha fecha_venta = new Fecha(1, 2018);
        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente();
        libreria.registrarCliente(unCliente);
        libreria.registrarVenta(fecha_venta, unCliente, unPeriodico);
        libreria.registrarVenta(fecha_venta, unCliente, unArticuloDeLibreria);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha_venta, unCliente);

        Assert.assertEquals(142.5f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueComproMultiplesProductosEnDistintasFechas() {
        Producto unArticuloDeLibreria = new Producto(50);
        Producto unPeriodico = new Producto(100);
        Fecha fecha_venta_articulo = new Fecha(1, 2018);
        Fecha fecha_venta_periodico = new Fecha(2, 2018);

        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente();
        libreria.registrarVenta(fecha_venta_articulo, unCliente, unArticuloDeLibreria);
        libreria.registrarVenta(fecha_venta_periodico, unCliente, unPeriodico);
        Float importeACobrarEnero = libreria.obtenerCobroMensual(fecha_venta_articulo, unCliente);
        Float importeACobrarFebrero = libreria.obtenerCobroMensual(fecha_venta_periodico, unCliente);

        Assert.assertEquals(50.0f, importeACobrarEnero, 0.001);
        Assert.assertEquals(100.0f, importeACobrarFebrero, 0.001);
    }


    @Test
    public void cobrarAUnClienteConVentaDeOtrosClientesRegistradas() {
        Producto unArticuloDeLibreria = new Producto(50);
        Producto unPeriodico = new Producto(100);
        Fecha fecha_venta = new Fecha(1, 2018);

        Libreria libreria = new Libreria();
        Cliente clienteArticulo = new Cliente();
        Cliente clientePeriodico = new Cliente();

        libreria.registrarVenta(fecha_venta, clienteArticulo, unArticuloDeLibreria);
        libreria.registrarVenta(fecha_venta, clientePeriodico, unPeriodico);
        Float importeACobrarClienteArticulo = libreria.obtenerCobroMensual(fecha_venta, clienteArticulo);

        Assert.assertEquals(50.0f, importeACobrarClienteArticulo, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoConUnProductoYUnaSubscripcion() {
        Producto unArticuloDeLibreria = new Producto(50);
        Producto unPeriodico = new Producto(100);
        Fecha fecha_inicial = new Fecha(12, 2017);
        Fecha fecha_final = new Fecha(12, 2018);
        Fecha fecha_venta = new Fecha(1, 2018);

        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente();
        libreria.registrarCliente(unCliente);
        libreria.registrarSubscripcion(unCliente, fecha_inicial, fecha_final, unPeriodico);
        libreria.registrarVenta(fecha_venta, unCliente, unArticuloDeLibreria);
        libreria.registrarVenta(fecha_venta, unCliente, unPeriodico);
        Float importeACobrarClienteArticulo = libreria.obtenerCobroMensual(fecha_venta, unCliente);
        Assert.assertEquals(127.5f, importeACobrarClienteArticulo, 0.001);

    }
}
