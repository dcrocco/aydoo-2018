package ar.edu.untref.aydoo;

class MaquinaExpendedoraDeBebidas {
    
    private HacedorDeCafe hacedorDeCafe = new HacedorDeCafe();
    private HacedorDeTe hacedorDeTe = new HacedorDeTe();
    private Azucarero azucarero = new Azucarero();

    void hacerCafeConLecheConNDeAzucar(final Vaso vaso, final int cantAzucar) {
        hacedorDeCafe.hacerCafeConLeche(vaso);
        azucarero.ponerAzucar(vaso, cantAzucar);
    }

    void hacerTeConLecheConNDeAzucar(final Vaso vaso, final int cantAzucar) {
        hacedorDeTe.hacerTeConLeche(vaso);
        azucarero.ponerAzucar(vaso, cantAzucar);
    }

}
