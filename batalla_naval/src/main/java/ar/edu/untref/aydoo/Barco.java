package ar.edu.untref.aydoo;

abstract class Barco {

    private Posicion posicionDelbarco;

    void setPosicion(Posicion unaPosicion) {
        this.posicionDelbarco = unaPosicion;
    }

    Posicion getPosicion(){
        return this.posicionDelbarco;
    }

    abstract boolean estaEn(Posicion unaPosicion);

    abstract ResultadoDeDisparo recibirDisparo();

}
