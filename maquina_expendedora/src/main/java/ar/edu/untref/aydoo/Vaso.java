package ar.edu.untref.aydoo;

class Vaso {

    private int cantidadDeAzucar;
    private boolean tieneCafe;
    private boolean tieneTe;
    private boolean tieneLeche;

    Vaso() {
        this.cantidadDeAzucar = 0;
        this.tieneCafe = false;
        this.tieneTe = false;
        this.tieneLeche = false;
    }

    void setCantidadDeAzucar(final int cantAzucar) {
        this.cantidadDeAzucar = cantAzucar;
    }

    int getCantidadDeAzucar() {
        return this.cantidadDeAzucar;
    }

    void setTieneCafe() {
        this.tieneCafe = true;
    }

    boolean tieneCafe() {
        return this.tieneCafe;
    }

    void setTieneTe() {
        this.tieneTe = true;
    }

    boolean tieneTe() {
        return this.tieneTe;
    }

    boolean tieneAzucar() {
        return this.getCantidadDeAzucar() > 0;
    }

    void setTieneLeche() {
        this.tieneLeche = true;
    }
}
