package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class LibreriaTest {

    // COBROS MENSUALES

    @Test
    public void cobrarAUnClienteQueNoComproNadaEnEneroDe2018() {
        Libreria libreria = new Libreria();
        Fecha fecha = new Fecha(1, 2018);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        Float importeACobrar = libreria.obtenerCobroMensual(fecha, unCliente);
        Assert.assertEquals(0.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueComproUnLibroDe500EnEneroDe2018() {
        Libreria libreria = new Libreria();
        Fecha fecha = new Fecha(1, 2018);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        Producto unLibro = new Producto(500.0f);
        libreria.registrarVenta(fecha, unCliente, unLibro);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha, unCliente);
        Assert.assertEquals(500.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoQueComproUnaRevistaDe300EnMarzoDe2018() {
        Libreria libreria = new Libreria();
        Fecha fecha = new Fecha(3, 2018);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarCliente(unCliente);
        ProductoSubscripcion unaRevista = new ProductoSubscripcion(300.0f, 4);
        libreria.registrarVenta(fecha, unCliente, unaRevista);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha, unCliente);
        Assert.assertEquals(285.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoUnArticuloDeLibreriaCon21DeIva() {
        Libreria libreria = new Libreria();
        Fecha fecha = new Fecha(3, 2018);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        ArticuloDeLibreria unArticuloDeLibreria = new ArticuloDeLibreria(300.0f, 21.00f);
        libreria.registrarVenta(fecha, unCliente, unArticuloDeLibreria);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha, unCliente);
        Assert.assertEquals(363.0f, importeACobrar, 0.0001);
    }

    @Test
    public void cobrarAUnClienteRegistradoUnArticuloDeLibreriaCon21DeIva() {
        Libreria libreria = new Libreria();
        Fecha fecha = new Fecha(3, 2018);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarCliente(unCliente);
        ArticuloDeLibreria unArticuloDeLibreria = new ArticuloDeLibreria(300.0f, 21.00f);
        libreria.registrarVenta(fecha, unCliente, unArticuloDeLibreria);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha, unCliente);
        Assert.assertEquals(344.85f, importeACobrar, 0.0001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueRealizoUnaSubscripcionAnualDeUnPeriodico() {
        ProductoSubscripcion unPeriodico = new ProductoSubscripcion(150.0f, 8);
        Libreria libreria = new Libreria();
        Fecha fechaInicial = new Fecha(12, 2017);
        Fecha fechaFinal = new Fecha(12, 2018);
        Fecha fechaVenta = new Fecha(1, 2018);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarSubscripcion(unCliente, fechaInicial, fechaFinal, unPeriodico);
        libreria.registrarVenta(fechaVenta, unCliente, unPeriodico);
        Float importeACobrar = libreria.obtenerCobroMensual(fechaVenta, unCliente);
        Assert.assertEquals(120.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoQueRealizoUnaSubscripcionAnualDeUnPeriodico() {
        ProductoSubscripcion unPeriodico = new ProductoSubscripcion(150.0f, 8);
        Libreria libreria = new Libreria();
        Fecha fechaInicial = new Fecha(12, 2017);
        Fecha fechaFinal = new Fecha(12, 2018);
        Fecha fechaVenta = new Fecha(1, 2018);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarSubscripcion(unCliente, fechaInicial, fechaFinal, unPeriodico);
        libreria.registrarCliente(unCliente);
        libreria.registrarVenta(fechaVenta, unCliente, unPeriodico);
        Float importeACobrar = libreria.obtenerCobroMensual(fechaVenta, unCliente);
        Assert.assertEquals(120.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueComproMultiplesProductosEnLaMismaFecha() {
        ProductoSubscripcion unPeriodico = new ProductoSubscripcion(100.0f, 8);
        Producto unArticuloDeLibreria = new Producto(50);
        Fecha fechaVenta = new Fecha(1, 2018);
        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarVenta(fechaVenta, unCliente, unPeriodico);
        libreria.registrarVenta(fechaVenta, unCliente, unArticuloDeLibreria);
        Float importeACobrar = libreria.obtenerCobroMensual(fechaVenta, unCliente);

        Assert.assertEquals(150.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoQueComproMultiplesProductosEnLaMismaFecha() {
        ProductoSubscripcion unPeriodico = new ProductoSubscripcion(100.0f, 8);
        Producto unArticuloDeLibreria = new Producto(50);
        Fecha fechaVenta = new Fecha(1, 2018);
        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarCliente(unCliente);
        libreria.registrarVenta(fechaVenta, unCliente, unPeriodico);
        libreria.registrarVenta(fechaVenta, unCliente, unArticuloDeLibreria);
        Float importeACobrar = libreria.obtenerCobroMensual(fechaVenta, unCliente);

        Assert.assertEquals(142.5f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueComproMultiplesProductosEnDistintasFechas() {
        Producto unArticuloDeLibreria = new Producto(50);
        ProductoSubscripcion unPeriodico = new ProductoSubscripcion(100.0f, 8);
        Fecha fechaVenta_articulo = new Fecha(1, 2018);
        Fecha fechaVenta_periodico = new Fecha(2, 2018);

        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarVenta(fechaVenta_articulo, unCliente, unArticuloDeLibreria);
        libreria.registrarVenta(fechaVenta_periodico, unCliente, unPeriodico);
        Float importeACobrarEnero = libreria.obtenerCobroMensual(fechaVenta_articulo, unCliente);
        Float importeACobrarFebrero = libreria.obtenerCobroMensual(fechaVenta_periodico, unCliente);

        Assert.assertEquals(50.0f, importeACobrarEnero, 0.001);
        Assert.assertEquals(100.0f, importeACobrarFebrero, 0.001);
    }

    @Test
    public void cobrarAUnClienteConVentaDeOtrosClientesRegistradas() {
        Producto unArticuloDeLibreria = new Producto(50);
        ProductoSubscripcion unPeriodico = new ProductoSubscripcion(100.0f, 8);
        Fecha fechaVenta = new Fecha(1, 2018);

        Libreria libreria = new Libreria();
        Cliente clienteArticulo = new Cliente("Juan", "Calle de Juan");
        Cliente clientePeriodico = new Cliente("Pedro", "Calle de Pedro 123");

        libreria.registrarVenta(fechaVenta, clienteArticulo, unArticuloDeLibreria);
        libreria.registrarVenta(fechaVenta, clientePeriodico, unPeriodico);
        Float importeACobrarClienteArticulo = libreria.obtenerCobroMensual(fechaVenta, clienteArticulo);

        Assert.assertEquals(50.0f, importeACobrarClienteArticulo, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoConUnProductoYUnaSubscripcion() {
        Producto unArticuloDeLibreria = new Producto(50);
        ProductoSubscripcion unPeriodico = new ProductoSubscripcion(100.0f, 8);
        Fecha fechaInicial = new Fecha(12, 2017);
        Fecha fechaFinal = new Fecha(12, 2018);
        Fecha fechaVenta = new Fecha(1, 2018);

        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarCliente(unCliente);
        libreria.registrarSubscripcion(unCliente, fechaInicial, fechaFinal, unPeriodico);
        libreria.registrarVenta(fechaVenta, unCliente, unArticuloDeLibreria);
        libreria.registrarVenta(fechaVenta, unCliente, unPeriodico);
        Float importeACobrarClienteArticulo = libreria.obtenerCobroMensual(fechaVenta, unCliente);
        Assert.assertEquals(127.5f, importeACobrarClienteArticulo, 0.001);
    }

    // COBROS ANUALES
    @Test
    public void cobrarAUnClienteQueNoComproNadaEn2018() {
        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        Float importeACobrar = libreria.obtenerCobroAnual(2018, unCliente);
        Assert.assertEquals(0.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueComproUnLibroDe500En2018() {
        Libreria libreria = new Libreria();
        Fecha fecha = new Fecha(1, 2018);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        Producto unLibro = new Producto(500.0f);
        libreria.registrarVenta(fecha, unCliente, unLibro);
        Float importeACobrar = libreria.obtenerCobroAnual(2018, unCliente);
        Assert.assertEquals(500.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueComproMultiplesProductosEn2018() {
        ProductoSubscripcion unPeriodico = new ProductoSubscripcion(100.0f, 8);
        Producto unArticuloDeLibreria = new Producto(50);
        Fecha fechaVenta = new Fecha(1, 2018);
        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarVenta(fechaVenta, unCliente, unPeriodico);
        libreria.registrarVenta(fechaVenta, unCliente, unArticuloDeLibreria);
        Float importeACobrar = libreria.obtenerCobroAnual(2018, unCliente);
        Assert.assertEquals(150.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteQueComproMultiplesProductosEnDistintosanios() {
        Producto unArticuloDeLibreria = new Producto(50);
        ProductoSubscripcion unPeriodico = new ProductoSubscripcion(100.0f, 8);
        Fecha fechaVenta_articulo = new Fecha(1, 2018);
        Fecha fechaVenta_periodico = new Fecha(2, 2017);

        Libreria libreria = new Libreria();
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarVenta(fechaVenta_articulo, unCliente, unArticuloDeLibreria);
        libreria.registrarVenta(fechaVenta_periodico, unCliente, unPeriodico);
        Float importeACobrar2018 = libreria.obtenerCobroAnual(2018, unCliente);
        Float importeACobrar2017 = libreria.obtenerCobroAnual(2017, unCliente);

        Assert.assertEquals(50.0f, importeACobrar2018, 0.001);
        Assert.assertEquals(100.0f, importeACobrar2017, 0.001);
    }

}
