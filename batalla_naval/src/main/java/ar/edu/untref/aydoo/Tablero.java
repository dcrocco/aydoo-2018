package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;

public class Tablero {

    ArrayList<Bote> listaDeBotes = new ArrayList<Bote>();

    public ResultadoDeDisparo recibirDisparo(Posicion posicionIndicada) {
        for (Bote bote : listaDeBotes) {
            if(bote.estaEn(posicionIndicada)){
                return ResultadoDeDisparo.HUNDIDO;
            }
        }
        return ResultadoDeDisparo.AGUA;
    }

    public void ubicarBote(Bote unBote, Posicion posicionIndicada) {
        unBote.setPosicion(posicionIndicada);
        listaDeBotes.add(unBote);
    }
}
