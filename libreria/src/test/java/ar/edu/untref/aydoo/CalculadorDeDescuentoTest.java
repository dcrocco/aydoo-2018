package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CalculadorDeDescuentoTest {

    @Test
    public void calcularDescuentoDeUnLibroDeUnClienteNoRegistrado() {
        Libreria libreria = new Libreria();
        Producto unLibro = new Producto(500.0f);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        Float importeConDescuento = CalculadorDeDescuento.CalcularDescuento(unLibro, unCliente, libreria);
        Assert.assertEquals(500.0f, importeConDescuento, 0.001);
    }

    @Test
    public void calcularDescuentoDeUnLibroDeUnClienteRegistrado() {
        Libreria libreria = new Libreria();
        Producto unLibro = new Producto(300.0f);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        libreria.registrarCliente(unCliente);
        Float importeConDescuento = CalculadorDeDescuento.CalcularDescuento(unLibro, unCliente, libreria);
        Assert.assertEquals(285.0f, importeConDescuento, 0.001);
    }

    @Test
    public void calcularDescuentoDeUnPeriodicoConSubscripcion() {
        Libreria libreria = new Libreria();
        ProductoSubscripcion unPeriodico = new ProductoSubscripcion(150.0f, 8);
        Cliente unCliente = new Cliente("Juan", "Calle de Juan");
        Fecha fecha_inicial = new Fecha(12, 2017);
        Fecha fecha_final = new Fecha(12, 2018);
        libreria.registrarSubscripcion(unCliente, fecha_inicial, fecha_final, unPeriodico);
        Float importeConDescuento = CalculadorDeDescuento.CalcularDescuento(unPeriodico, unCliente, libreria);
        Assert.assertEquals(120.0f, importeConDescuento, 0.001);
    }

}
