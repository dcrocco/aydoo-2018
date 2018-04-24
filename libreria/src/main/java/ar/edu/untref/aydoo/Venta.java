package ar.edu.untref.aydoo;

class Venta {

    private Fecha fecha;
    private Cliente cliente;
    private Producto producto;

    Venta(Fecha fecha, Cliente unCliente, Producto unProducto) {
        this.fecha = fecha;
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
