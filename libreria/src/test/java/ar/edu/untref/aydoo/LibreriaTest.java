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
        libreria.registrarSubscripcion(unCliente, fecha_final, fecha_inicial);
        libreria.registrarVenta(fecha_venta, unCliente, unPeriodico);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha_venta, unCliente);
        Assert.assertEquals(112.5f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoQueRealizoUnaSubscripcionAnualDeUnPeriodico() {
        Producto unPeriodico = new Producto(150);
        Libreria libreria = new Libreria();
        Fecha fecha_inicial = new Fecha(12, 2017);
        Fecha fecha_final = new Fecha(12, 2018);
        Fecha fecha_venta = new Fecha(1, 2018);
        Cliente unCliente = new Cliente();
        libreria.registrarSubscripcion(unCliente, fecha_final, fecha_inicial);
        libreria.registrarCliente(unCliente);
        libreria.registrarVenta(fecha_venta, unCliente, unPeriodico);
        Float importeACobrar = libreria.obtenerCobroMensual(fecha_venta, unCliente);
        Assert.assertEquals(112.5f, importeACobrar, 0.001);
    }

}
