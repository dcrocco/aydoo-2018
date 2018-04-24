package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

class Libreria {

    private List<Venta> ventas;
    private List<Cliente> clientes;

    Libreria(){
        this.ventas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    Float obtenerCobroMensual(int mes, int anio, Cliente cliente) {

        Float importeACobrar = 0.0f;
        for (Venta venta: this.getVentas()) {
            importeACobrar += venta.obtenerImporteACobrar();
        }

        return importeACobrar;
    }

    void registrarVenta(Integer mes, Integer anio, Cliente unCliente, Producto unProducto) {
        Venta ventaARegistrar = new Venta(mes, anio, unCliente, unProducto);
        this.ventas.add(ventaARegistrar);
    }

    private List<Venta> getVentas(){
        return this.ventas;
    }

    void registrarCliente(Cliente clienteARegistrar) {
        this.clientes.add(clienteARegistrar);
    }
}
