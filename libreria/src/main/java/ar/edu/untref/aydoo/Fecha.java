package ar.edu.untref.aydoo;

public class Fecha {

    private int mes;
    private int anio;

    Fecha(int mes, int anio) {
        if ((mes < 1 || mes > 12) || (anio <= 0)){
            throw new IllegalArgumentException("El valor del mes debe estar entre 1 y 12 y el año mayor a 0");
        }
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
