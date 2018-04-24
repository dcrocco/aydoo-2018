package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

class Libreria {

    private List<Venta> ventas;
    private List<Cliente> clientes;
    private List<Subscripcion> subscripciones;

    Libreria(){
        this.ventas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.subscripciones = new ArrayList<>();
    }

    Float obtenerCobroMensual(Fecha fecha, Cliente cliente) {

        Float importeACobrar = 0.0f;
        for (Venta venta: this.getVentas()) {
            if (venta.getFecha() == fecha && cliente == venta.getCliente()){
                importeACobrar += venta.obtenerImporteACobrar(this);
            }
        }

        return importeACobrar;
    }

    Float obtenerCobroAnual(Integer anio, Cliente cliente) {
        Float importeACobrar = 0.0f;
        for (Venta venta: this.getVentas()) {
            if (venta.getFecha().getAnio() == anio && cliente == venta.getCliente()){
                importeACobrar += venta.obtenerImporteACobrar(this);
            }
        }

        return importeACobrar;
    }

    void registrarVenta(Fecha fecha, Cliente unCliente, Producto unProducto) {
        Venta ventaARegistrar = new Venta(fecha, unCliente, unProducto);
        this.ventas.add(ventaARegistrar);
    }

    void registrarCliente(Cliente clienteARegistrar) {
        this.clientes.add(clienteARegistrar);
    }

    boolean estaRegistrado(Cliente cliente) {
        return this.clientes.contains(cliente);
    }

    boolean tieneSubscripcion(Cliente cliente, Producto producto) {
        for (Subscripcion subscripcion: this.getSubscripciones()){
            if (subscripcion.getCliente() == cliente && subscripcion.getProducto() == producto){
                return true;
            }
        }
        return false;
    }

    private List<Subscripcion> getSubscripciones() { return this.subscripciones; }

    private List<Venta> getVentas(){
        return this.ventas;
    }

    void registrarSubscripcion(Cliente unCliente, Fecha fechaInicial, Fecha fechaFinal, ProductoSubscripcion producto) {
        Subscripcion subscripcionARegistrar = new Subscripcion(unCliente, fechaInicial, fechaFinal, producto);
        this.subscripciones.add(subscripcionARegistrar);
    }

}
