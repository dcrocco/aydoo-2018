package ar.edu.untref.aydoo;

import java.util.List;

public class Itinerario {

    List<Tramo> listaDeTramos;

    public Itinerario(List<Tramo> listaDeTramos) {
        this.listaDeTramos = listaDeTramos;
    }

    public double cobrar() {
        double total = 0.0;
        for (Tramo tramo: this.listaDeTramos) {
            tramo.cobrar();
        }
        return total;
    }

}
