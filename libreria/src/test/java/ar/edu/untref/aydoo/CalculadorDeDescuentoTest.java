package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CalculadorDeDescuentoTest {

    @Test
    public void calcularDescuentoDeUnLibroDeUnClienteNoRegistrado() {
        Libreria libreria = new Libreria();
        Producto unLibro = new Producto(500.0f);
        Cliente unCliente = new Cliente();
        Float importeConDescuento = CalculadorDeDescuento.CalcularDescuento(unLibro, unCliente, libreria);
        Assert.assertEquals(500.0f, importeConDescuento, 0.001);
    }

    @Test
    public void calcularDescuentoDeUnaRevistaDeUnClienteNoRegistrado() {
        Libreria libreria = new Libreria();
        Producto unLibro = new Producto(300.0f);
        Cliente unCliente = new Cliente();
        libreria.registrarCliente(unCliente);
        Float importeConDescuento = CalculadorDeDescuento.CalcularDescuento(unLibro, unCliente, libreria);
        Assert.assertEquals(285.0f, importeConDescuento, 0.001);
    }

    @Test
    public void calcularDescuentoDeUnPeriodicoConSubscripcion() {
        Libreria libreria = new Libreria();
        Producto unLibro = new Producto(150.0f);
        Cliente unCliente = new Cliente();
        Fecha fecha_inicial = new Fecha(12, 2017);
        Fecha fecha_final = new Fecha(12, 2018);
        libreria.registrarSubscripcion(unCliente, fecha_inicial, fecha_final);
        Float importeConDescuento = CalculadorDeDescuento.CalcularDescuento(unLibro, unCliente, libreria);
        Assert.assertEquals(112.5f, importeConDescuento, 0.001);
    }

}
