package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

import java.util.LinkedList;


public class ItinerarioTest {

    @Test
    public void cobrarUnItinerarioConUnSoloTramoYTarifaFija() {
        Ciudad nuevaYork = new Ciudad("Nueva York", "NYK");
        Ciudad amsterdam = new Ciudad("Amsterdam", "AMS");
        Avion avion = new Avion();
        Tramo nuevaYorkAAmsterdam = new Tramo(nuevaYork, amsterdam, avion);
        LinkedList<Tramo> listaDeTramos = new LinkedList<>();
        listaDeTramos.add(nuevaYorkAAmsterdam);
        Itinerario itinerarioNuevaYorkAmsterdam = new Itinerario(listaDeTramos);

        Assert.assertEquals(25000.0, itinerarioNuevaYorkAmsterdam.cobrar(), 0.01);
    }

    @Test
    public void cobrarUnItinerarioConDosTramosYUnTransporteYTarfijasFijas() {
        Ciudad nuevaYork = new Ciudad("Nueva York", "NYK");
        Ciudad amsterdam = new Ciudad("Amsterdam", "AMS");
        Ciudad sidney = new Ciudad("Sidney", "SNY");

        Avion avion = new Avion();
        Tramo nuevaYorkAAmsterdam = new Tramo(nuevaYork, amsterdam, avion);
        Tramo amsterdamASidney = new Tramo(amsterdam, sidney, avion);

        LinkedList<Tramo> listaDeTramos = new LinkedList<>();
        listaDeTramos.add(nuevaYorkAAmsterdam);
        listaDeTramos.add(amsterdamASidney);
        Itinerario itinerarioNuevaYorkAmsterdam = new Itinerario(listaDeTramos);

        Assert.assertEquals(52000.0, itinerarioNuevaYorkAmsterdam.cobrar(), 0.01);

    }

}
