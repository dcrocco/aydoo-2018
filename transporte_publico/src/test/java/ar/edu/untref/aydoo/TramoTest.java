package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TramoTest {

    @Test
    public void cobrarUnTramoDeUnAvionDeTarifaFijaDeNYAAMsterdam() {
        Ciudad nuevaYork = new Ciudad("Nueva York", "NYK");
        Ciudad amsterdam = new Ciudad("Amsterdam", "AMS");
        Avion avion = new Avion();
        Tramo nuevaYorkAAmsterdam = new Tramo(nuevaYork, amsterdam, avion);

        Assert.assertEquals(25000.0, nuevaYorkAAmsterdam.cobrar(), 0.01);

    }

    @Test
    public void cobrarUnTramoDeUnAvionDeTarifaFijaDeAmsterdamASidney() {
        Ciudad amsterdam = new Ciudad("Amsterdam", "AMS");
        Ciudad sidney = new Ciudad("Sidney", "SNY");
        Avion avion = new Avion();
        Tramo nuevaYorkAAmsterdam = new Tramo(amsterdam, sidney, avion);

        Assert.assertEquals(27000.0, nuevaYorkAAmsterdam.cobrar(), 0.01);
    }
}
