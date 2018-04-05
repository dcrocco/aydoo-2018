package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;

public class Tablero {

    ArrayList<Bote> listaDeBotes = new ArrayList<Bote>();

    public ResultadoDeDisparo recibirDisparo(int fila, int columna) {
        for (Bote bote : listaDeBotes) {
            if(bote.estaEn(fila,columna)){
                return ResultadoDeDisparo.HUNDIDO;
            }
        }
        return ResultadoDeDisparo.AGUA;
    }

    public void ubicarBote(Bote unBote, int fila, int columna) {
        unBote.setPosicion(fila, columna);
        listaDeBotes.add(unBote);
    }
}
