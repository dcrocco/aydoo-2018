package ar.edu.untref.aydoo;

import org.junit.Test;

public class SubscripcionTest {

    @Test (expected = IllegalArgumentException.class)
    public void TestFechasConAniosInvalidos(){
        Fecha fecha_inicial = new Fecha(12, 2018);
        Fecha fecha_final = new Fecha(12, 2017);
        Cliente unCliente = new Cliente("Juan", "Calle Juan");
        new Subscripcion(unCliente, fecha_inicial, fecha_final, new ProductoSubscripcion(120.0f, 8));
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestFechasConMesesInvalidos(){
        Fecha fecha_inicial = new Fecha(12, 2018);
        Fecha fecha_final = new Fecha(12, 2018);
        Cliente unCliente = new Cliente("Juan", "Calle Juan");
        new Subscripcion(unCliente, fecha_inicial, fecha_final, new ProductoSubscripcion(120.0f, 8));
    }

}
