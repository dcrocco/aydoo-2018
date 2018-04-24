package ar.edu.untref.aydoo;


class CalculadorDeDescuento {

    private static final float descuentoGlobal = 0.05f;

    /**
     * Si el producto tiene una subscripción, se hace un 20% de descuento.
     * Si el producto no tiene una subscripción pero el cliente está registado, se hace un 5% de descuento.
     * @param producto: Producto sobre el cual se realizará el descuento.
     * @param cliente: Cliente el cual compró el producto.
     * @param libreria: Librería que vende el producto y lleva la cuenta corriente de los clientes
     */
    static float CalcularDescuento(Producto producto, Cliente cliente, Libreria libreria) {

        Float precio = producto.getPrecio();
        if (libreria.estaRegistrado(cliente)){
            precio *= (1 - descuentoGlobal);
        }
        return precio;

    }
}
