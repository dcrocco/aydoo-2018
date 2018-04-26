package ar.edu.untref.aydoo;

import java.math.BigDecimal;

/**
 * Created by nicopaez on 25/04/2018.
 */
public class Producto {
    private static final Double IVA = 1.21;

    private final Double precio;
    private final String nombre;

    public Producto(String nombre, Double precio) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public Double getPrecioConIva() {
        return this.precio * IVA;
    }
}
