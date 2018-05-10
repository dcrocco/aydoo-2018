package ar.edu.untref.aydoo;

public class Tramo {

    private Ciudad ciudadInicial;
    private Ciudad ciudadFinal;
    private Avion avion;

    public Tramo(Ciudad ciudadInicial, Ciudad ciudadFinal, Avion avion) {
        this.ciudadInicial = ciudadInicial;
        this.ciudadFinal = ciudadFinal;
        this.avion = avion;
    }

    public double cobrar() {
        return 25000.0;
    }
}
