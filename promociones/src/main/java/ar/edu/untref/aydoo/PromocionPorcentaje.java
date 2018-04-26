package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;

/**
 * Created by nicopaez on 25/04/2018.
 */
public class PromocionPorcentaje {
    private final Producto productoEnPromocion;
    private final Double porcentajeDescuento;

    public PromocionPorcentaje(Producto producto, Double porcentajeDescuento) {
        this.productoEnPromocion = producto;
        this.porcentajeDescuento =  porcentajeDescuento;
    }

    public Double aplicar(List<Producto> items) {
        Double montoAPagar = 0d;
        Iterator<Producto> it = items.iterator();
        while(it.hasNext()){
            if (productoEnPromocion.equals(it.next())) {
                Double precioTotal = productoEnPromocion.getPrecioConIva();
                Double montoADescontar = precioTotal * porcentajeDescuento / 100d;
                montoAPagar += precioTotal - montoADescontar;
                it.remove();
            }
        }
        return montoAPagar;
    }
}
