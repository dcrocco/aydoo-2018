package ar.edu.untref.aydoo;

class HacedorDeTe {

    private Lechero lechero = new Lechero();
    private Tetero tetero = new Tetero();

    void hacerTeConLeche(Vaso vaso) {
        tetero.agregarTe(vaso);
        lechero.agregarLeche(vaso);
    }

}
