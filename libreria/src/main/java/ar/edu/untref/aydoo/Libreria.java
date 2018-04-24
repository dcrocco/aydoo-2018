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
    }

    Float obtenerCobroMensual(int mes, int anio, Cliente cliente) {

        Float importeACobrar = 0.0f;
        for (Venta venta: this.getVentas()) {
            importeACobrar += venta.obtenerImporteACobrar(this);
        }

        return importeACobrar;
    }

    void registrarVenta(Integer mes, Integer anio, Cliente unCliente, Producto unProducto) {
        Venta ventaARegistrar = new Venta(mes, anio, unCliente, unProducto);
        this.ventas.add(ventaARegistrar);
    }

    void registrarCliente(Cliente clienteARegistrar) {
        this.clientes.add(clienteARegistrar);
    }

    boolean estaRegistrado(Cliente cliente) {
        return this.clientes.contains(cliente);
    }

    private List<Venta> getVentas(){
        return this.ventas;
    }

}
