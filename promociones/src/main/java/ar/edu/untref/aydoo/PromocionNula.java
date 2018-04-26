package ar.edu.untref.aydoo;

import java.util.List;

/**
 * Created by nicopaez on 25/04/2018.
 */
public class PromocionNula extends PromocionPorcentaje {

    public PromocionNula() {
        super(null, 0d);
    }

    public Double aplicar(List<Producto> items) {
        Double total = 0d;
        for (Producto prod: items) {
            total += prod.getPrecioConIva();
        }
        return total;
    }
}
