package ar.edu.untref.aydoo;

import org.junit.Test;

public class FechaTest {

    @Test(expected = IllegalArgumentException.class)
    public void crearFechaConMesInvalido(){
        new Fecha(13, 2018);
    }

    @Test(expected = IllegalArgumentException.class)
    public void crearFechaConAnioInvalido(){
        new Fecha(12, -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void crearFechaConAnioYMesInvalido(){
        new Fecha(13, -10);
    }


}
