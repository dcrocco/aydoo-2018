package ar.edu.untref.aydoo;

class Venta {

    private Integer mes;
    private Integer anio;
    private Cliente cliente;
    private Producto producto;

    Venta(Integer mes, Integer anio, Cliente unCliente, Producto unProducto) {
        this.mes = mes;
        this.anio = anio;
        this.cliente = unCliente;
        this.producto = unProducto;
    }

    Float obtenerImporteACobrar(Libreria libreria) {
        producto = this.getProducto();
        cliente = this.getCliente();
        return CalculadorDeDescuento.CalcularDescuento(producto, cliente, libreria);
    }

    private Cliente getCliente() {
        return this.cliente;
    }

    private Producto getProducto() {
        return this.producto;
    }

}
