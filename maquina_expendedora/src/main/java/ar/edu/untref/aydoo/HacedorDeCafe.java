package ar.edu.untref.aydoo;

class HacedorDeCafe {

    private Lechero lechero = new Lechero();
    private Cafetero cafetero = new Cafetero();

    void hacerCafeConLeche(Vaso vaso) {
        cafetero.agregarCafe(vaso);
        lechero.agregarLeche(vaso);
    }
}
