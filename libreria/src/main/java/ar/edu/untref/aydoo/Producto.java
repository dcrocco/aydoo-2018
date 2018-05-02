package ar.edu.untref.aydoo;

class Producto {

    float precio;

    Producto(float precio) {
        if (precio <= 0){
            throw new IllegalArgumentException("El importe del producto debe ser mayor que 0");
        }
        this.precio = precio;
    }

    float getPrecio() {
        return this.precio;
    }
}
