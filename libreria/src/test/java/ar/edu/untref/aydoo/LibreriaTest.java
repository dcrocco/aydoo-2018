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
        Revista unaRevista = new Revista(500.0f);
        libreria.registrarVenta(mes, anio, unCliente, unaRevista);
        Float importeACobrar = libreria.obtenerCobroMensual(mes, anio, unCliente);
        Assert.assertEquals(475.0f, importeACobrar, 0.001);
    }

}
