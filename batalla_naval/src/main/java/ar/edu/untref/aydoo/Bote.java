package ar.edu.untref.aydoo;

public class Bote extends Barco {

    @Override
    boolean estaEn(Posicion unaPosicion) {
        boolean fila = unaPosicion.getFila() == this.getPosicion().getFila();
        boolean columna = unaPosicion.getColumna() == this.getPosicion().getColumna();
        return fila && columna;

    }

    @Override
    public ResultadoDeDisparo recibirDisparo() {
        return ResultadoDeDisparo.HUNDIDO;
    }

    @Override
    public Posicion obtenerLimites() {
        return this.getPosicion();
    }

    @Override
    public boolean seSuperponeCon(Barco unBarco) {
        return unBarco.estaEn(this.getPosicion());
    }

}
