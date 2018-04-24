package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class LibreriaTest {

    @Test
    public void cobrarAUnClienteQueNoComproNadaEnEneroDe2018() {
        Libreria libreria = new Libreria();
        Integer mes = 1;
        Integer anio = 2018;
        Cliente unCliente = new Cliente();
        Float importeACobrar = libreria.obtenerCobroMensual(mes, anio, unCliente);
        Assert.assertEquals(0.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteNoRegistradoQueComproUnLibroDe500EnEneroDe2018() {
        Libreria libreria = new Libreria();
        Integer mes = 1;
        Integer anio = 2018;
        Cliente unCliente = new Cliente();
        Libro unLibro = new Libro(500.0f);
        libreria.registrarVenta(mes, anio, unCliente, unLibro);
        Float importeACobrar = libreria.obtenerCobroMensual(mes, anio, unCliente);
        Assert.assertEquals(500.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoQueComproUnaRevistaDe300EnMarzoDe2018() {
        Libreria libreria = new Libreria();
        Integer mes = 3;
        Integer anio = 2018;
        Cliente unCliente = new Cliente();
        libreria.registrarCliente(unCliente);
        Revista unaRevista = new Revista(300.0f);
        libreria.registrarVenta(mes, anio, unCliente, unaRevista);
        Float importeACobrar = libreria.obtenerCobroMensual(mes, anio, unCliente);
        Assert.assertEquals(285.0f, importeACobrar, 0.001);
    }

    @Test
    public void cobrarAUnClienteRegistradoQueRealizoUnaSubscripciónAnualDeUnPeriódico() {
        Periodico periodico = new Periodico();
        Libreria libreria = new Libreria();
        Fecha fecha_inicial = new Fecha(12, 2017);
        Integer mes = 12;
        Integer anio = 2017;
        Cliente unCliente = new Cliente();
        libreria.registrarSubscripción(unCliente, )
        Revista unaRevista = new Revista(300.0f);
        libreria.registrarVenta(mes, anio, unCliente, unaRevista);
        Float importeACobrar = libreria.obtenerCobroMensual(mes, anio, unCliente);
        Assert.assertEquals(285.0f, importeACobrar, 0.001);
    }
}
