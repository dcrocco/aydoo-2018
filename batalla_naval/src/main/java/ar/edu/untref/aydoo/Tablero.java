package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Tablero {

    ArrayList<Barco> listaDeBarcos = new ArrayList<>();

    public ResultadoDeDisparo recibirDisparo(Posicion posicionIndicada) {
        for (Barco barco: listaDeBarcos) {
            if(barco.estaEn(posicionIndicada)){
                return barco.recibirDisparo();
            }
        }
        return ResultadoDeDisparo.AGUA;
    }

    public void ubicarBote(Bote unBote, Posicion posicion) {
        unBote.setPosicion(posicion);
        listaDeBarcos.add(unBote);
    }

    public void ubicarCrucero(Crucero unCrucero, Posicion posicion) {
        unCrucero.setPosicion(posicion);
        listaDeBarcos.add(unCrucero);
    }
}
