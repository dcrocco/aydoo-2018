package ar.edu.untref.aydoo;

class Bote extends Barco {

    @Override
    boolean estaEn(Posicion unaPosicion) {
        boolean fila = unaPosicion.getFila() == this.getPosicion().getFila();
        boolean columna = unaPosicion.getColumna() == this.getPosicion().getColumna();
        return fila && columna;

    }

    @Override
    ResultadoDeDisparo recibirDisparo() {
        return ResultadoDeDisparo.HUNDIDO;
    }

}
