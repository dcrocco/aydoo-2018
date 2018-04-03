package ar.edu.untref.aydoo;

class Vaso {

    private int cantidadDeAzucar;
    private boolean tieneCafe;
    private boolean tieneTe;

    Vaso() {
        this.cantidadDeAzucar = 0;
        this.tieneCafe = false;
        this.tieneTe = false;
    }

    void setCantidadDeAzucar(final int cantAzucar) {
        this.cantidadDeAzucar = cantAzucar;
    }

    int getCantidadDeAzucar() {
        return this.cantidadDeAzucar;
    }

    void setTieneCafe() {
        this.tieneCafe = !this.tieneCafe;
    }

    boolean tieneCafe() {
        return this.tieneCafe;
    }

    void setTieneTe() {
        this.tieneTe = !this.tieneTe;
    }

    boolean tieneTe() {
        return this.tieneTe;
    }

    boolean tieneAzucar() {
        return this.cantidadDeAzucar > 0;
    }

}
