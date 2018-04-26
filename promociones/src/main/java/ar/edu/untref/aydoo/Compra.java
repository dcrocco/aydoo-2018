package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicopaez on 25/04/2018.
 */
public class Compra {
    private final List<PromocionPorcentaje> promociones;
    private List<Producto> items;

    public Compra(List<PromocionPorcentaje> promocionesActivas) {
        this.items = new ArrayList<Producto>();
        this.promociones = promocionesActivas;

    }

    public void agregar(Producto jabon) {
        this.items.add(jabon);
    }

    public Double calcularTotal() {
        Double total = 0d;
        List<Producto> itemsAProcesar = new ArrayList<Producto>();
        itemsAProcesar.addAll(this.items);
        for (PromocionPorcentaje promocion : this.promociones) {
            total += promocion.aplicar(itemsAProcesar);
        }
        return total;
    }
}
