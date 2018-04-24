package ar.edu.untref.aydoo;

class Subscripcion {

    private Cliente cliente;
    private Fecha fecha_inicial;
    private Fecha fecha_final;

    Subscripcion(Cliente unCliente, Fecha fecha_inicial, Fecha fecha_final) {
        this.cliente = unCliente;
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
    }

    Cliente getCliente() {
        return this.cliente;
    }

}
