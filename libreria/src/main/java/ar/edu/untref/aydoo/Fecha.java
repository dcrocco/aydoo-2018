package ar.edu.untref.aydoo;

public class Fecha {

    private int mes;
    private int anio;

    Fecha(int mes, int anio) {
        this.mes = mes;
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }
}
