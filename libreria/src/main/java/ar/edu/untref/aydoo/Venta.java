package ar.edu.untref.aydoo;

class Venta {

    private Integer mes;
    private Integer anio;
    private Cliente cliente;
    private Producto libro;

    Venta(Integer mes, Integer anio, Cliente unCliente, Producto unProducto) {
        this.mes = mes;
        this.anio = anio;
        this.cliente = unCliente;
        this.libro = unProducto;
    }

    Float obtenerImporteACobrar() {
        return this.getLibro().getPrecio();
    }

    private Producto getLibro() {
        return this.libro;
    }

}
