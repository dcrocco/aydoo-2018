package ar.edu.untref.aydoo;

class Subscripcion {

    private Cliente cliente;
    private Fecha fecha_inicial;
    private Fecha fecha_final;
    private Producto producto;

    Subscripcion(Cliente unCliente, Fecha fecha_inicial, Fecha fecha_final, Producto producto) {
        this.cliente = unCliente;
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
        this.producto = producto;
    }

    Cliente getCliente() {
        return this.cliente;
    }

    Producto getProducto() {
        return this.producto;
    }
}
