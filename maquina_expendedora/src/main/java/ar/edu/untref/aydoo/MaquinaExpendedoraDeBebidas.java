package ar.edu.untref.aydoo;

class MaquinaExpendedoraDeBebidas {

    void hacerCafeConLecheConNDeAzucar(final Vaso vaso, final int cantAzucar) {
        vaso.setCantidadDeAzucar(cantAzucar);
        vaso.setTieneCafe();
    }

    void hacerTeConLecheConNDeAzucar(final Vaso vaso, final int cantAzucar) {
        vaso.setCantidadDeAzucar(cantAzucar);
        vaso.setTieneTe();
    }

}
