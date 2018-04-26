package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;

public class Promocion2por1 {
    // Para 4por1 cambiar todos los 2 por un 4
    private final Producto productoEnPromocion;

    public Promocion2por1(Producto producto) {
        this.productoEnPromocion = producto;
    }

    public Double aplicar(List<Producto> items) {
        Integer cantidadDeProductos = 0;
        Iterator<Producto> it = items.iterator();
        while(it.hasNext()){
            if (productoEnPromocion.equals(it.next())) {
                cantidadDeProductos += 1;
                it.remove();
            }
        }
        Integer cantidadAConsiderar = cantidadDeProductos / 2;
        Double montoAPagar = productoEnPromocion.getPrecioConIva() * cantidadDeProductos;

        if (cantidadAConsiderar > 0){
            Double montoARestar = productoEnPromocion.getPrecioConIva() * cantidadAConsiderar;
            montoAPagar -= montoARestar;
        }
        return montoAPagar;
    }
}
