package ar.edu.untref.aydoo;

class ArticuloDeLibreria extends Producto{

    private float coeficienteIva;

    ArticuloDeLibreria(float precio, float coeficienteIva) {
        super(precio);
        this.coeficienteIva = coeficienteIva;
    }

    @Override
    float getPrecio() {
        return this.precio * (1 + this.coeficienteIva/100);
    }

}
