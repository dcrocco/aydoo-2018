package ar.edu.untref.aydoo;

class ProductoSubscripcion extends Producto {

    private Integer periodicidad;

    ProductoSubscripcion(Float precio, int periodicidad){
        super(precio);
        this.periodicidad = periodicidad;
    }

    Integer getPeriodicidad() {
        return periodicidad;
    }
}
