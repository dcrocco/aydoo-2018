package ar.edu.untref.aydoo;

public class Posicion {

    private final int fila;
    private final int columna;

    Posicion(int fila, int columna) {
        this.fila=fila;
        this.columna=columna;
    }

    int getFila() {
        return fila;
    }

    int getColumna() {
        return columna;
    }
}
