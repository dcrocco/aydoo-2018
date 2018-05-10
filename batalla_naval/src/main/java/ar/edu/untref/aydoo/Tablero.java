package ar.edu.untref.aydoo;

import java.util.ArrayList;

class Tablero {

    ArrayList<Barco> listaDeBarcos = new ArrayList<>();
    private Posicion limites;

    Tablero (Posicion limites){
        this.limites = limites;
    }

    ResultadoDeDisparo recibirDisparo(Posicion posicionIndicada) throws ExcepcionFueraDeTablero {

        verificarSiEstaFueraDelTablero(posicionIndicada);

        for (Barco barco : listaDeBarcos) {
            if (barco.estaEn(posicionIndicada)) {
                return barco.recibirDisparo();
            }
        }
        return ResultadoDeDisparo.AGUA;
    }

    void ubicarBarco(Barco unBarco, Posicion posicion) throws ExcepcionFueraDeTablero, ExcepcionSuperposicion {
        unBarco.setPosicion(posicion);
        Posicion limitesBarco = unBarco.obtenerLimites();
        verificarSiEstaFueraDelTablero(limitesBarco);
        verificarSuperposicion(unBarco);
        listaDeBarcos.add(unBarco);
    }

    Posicion getLimites() {
        return limites;
    }

    private void verificarSuperposicion(Barco unBarco) throws ExcepcionSuperposicion {
        for (Barco barco : listaDeBarcos) {
            if (barco.seSuperponeCon(unBarco)){
                throw new ExcepcionSuperposicion("Ya hay un elemento en esa posición!");
            }
        }
    }

    private void verificarSiEstaFueraDelTablero(Posicion posicionAVerificar) throws ExcepcionFueraDeTablero {
        if (posicionAVerificar.getColumna() > this.getLimites().getColumna()
            || posicionAVerificar.getFila() > this.getLimites().getFila()){
               throw new ExcepcionFueraDeTablero("Se esta intentando realizar una acción fuera del tablero");
        }
    }
}
