package ar.edu.untref.aydoo;

class Subscripcion {

    private Cliente cliente;
    private Fecha fechaInicial;
    private Fecha fechaFinal;
    private Producto producto;

    Subscripcion(Cliente unCliente, Fecha fechaInicial, Fecha fechaFinal, ProductoSubscripcion producto) {
        validarFechas(fechaInicial, fechaFinal);

        this.cliente = unCliente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.producto = producto;
    }

    private void validarFechas(Fecha fechaInicial, Fecha fechaFinal) {
        String excepcionFechasInvalidas = "La fecha inicial de la subscripción debe ser menor que la final";
        if (fechaFinal.getAnio() < fechaInicial.getAnio()){
            throw new IllegalArgumentException(excepcionFechasInvalidas);
        }else if (fechaFinal.getAnio() == fechaInicial.getAnio()){
            if (fechaFinal.getMes() <= fechaInicial.getMes()){
                throw new IllegalArgumentException(excepcionFechasInvalidas);
            }
        }
    }

    Cliente getCliente() {
        return this.cliente;
    }

    Producto getProducto() {
        return this.producto;
    }
}
