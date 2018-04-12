package ar.edu.untref.aydoo;

import java.util.ArrayList;

class Tablero {

    ArrayList<Barco> listaDeBarcos = new ArrayList<>();

    ResultadoDeDisparo recibirDisparo(Posicion posicionIndicada) {
        for (Barco barco: listaDeBarcos) {
            if(barco.estaEn(posicionIndicada)){
                return barco.recibirDisparo();
            }
        }
        return ResultadoDeDisparo.AGUA;
    }

    void ubicarBote(Bote unBote, Posicion posicion) {
        unBote.setPosicion(posicion);
        listaDeBarcos.add(unBote);
    }

    void ubicarCrucero(Crucero unCrucero, Posicion posicion) {
        unCrucero.setPosicion(posicion);
        listaDeBarcos.add(unCrucero);
    }
}
