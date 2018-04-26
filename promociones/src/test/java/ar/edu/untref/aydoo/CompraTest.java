package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;


public class CompraTest {

    @Test
    public void deberiaIncluirElIvaEnElTotal() {
        Double precio = 10d;
        String nombre = "jabon";
        Producto jabon = new Producto(nombre, precio);
        PromocionNula promocionNula = new PromocionNula();
        List<PromocionPorcentaje> promocionesActivas = new ArrayList<PromocionPorcentaje>();
        promocionesActivas.add(promocionNula);
        Compra compraDelMes = new Compra(promocionesActivas);
        compraDelMes.agregar(jabon);

        Double total = compraDelMes.calcularTotal();

        Assert.assertEquals(12.10, total, 0d);
    }

    @Test
    public void deberiaSumarTodosLosProductos() {
        Double precio = 100d;
        String nombre = "jabon";
        Producto jabon = new Producto(nombre, precio);
        nombre = "pan";
        Producto pan = new Producto(nombre, precio);
        PromocionNula promocionNula = new PromocionNula();
        List<PromocionPorcentaje> promocionesActivas = new ArrayList<PromocionPorcentaje>();
        promocionesActivas.add(promocionNula);
        Compra compraDelMes = new Compra(promocionesActivas);
        compraDelMes.agregar(jabon);
        compraDelMes.agregar(pan);

        Double total = compraDelMes.calcularTotal();

        Assert.assertEquals(242d, total, 0d);
    }

    @Test
    public void promocionQueNoAplicaALaCompra () {
        Producto jabon = new Producto("jabon", 10d);
        Double porcentajeDescuento = 10d;

        Producto pan = new Producto("pan", 10d);

        PromocionNula promocionNula = new PromocionNula();
        PromocionPorcentaje promocionJabon = new PromocionPorcentaje(pan, porcentajeDescuento);
        List<PromocionPorcentaje> promocionesActivas = new ArrayList<PromocionPorcentaje>();
        promocionesActivas.add(promocionJabon);
        promocionesActivas.add(promocionNula);
        Compra compraDelMes = new Compra(promocionesActivas);
        compraDelMes.agregar(jabon);

        Double total = compraDelMes.calcularTotal();

        Assert.assertEquals(12.10, total, 0d);
    }

    @Test
    public void torgugaVerde() {
        Double porcentajeDescuento = 10d;

        Producto jabon = new Producto("jabon", 10d);

        PromocionNula promocionNula = new PromocionNula();
        PromocionPorcentaje promocionJabon = new PromocionPorcentaje(jabon, porcentajeDescuento);
        List<PromocionPorcentaje> promocionesActivas = new ArrayList<PromocionPorcentaje>();
        promocionesActivas.add(promocionJabon);
        promocionesActivas.add(promocionNula);

        Compra compraDelMes = new Compra(promocionesActivas);

        compraDelMes.agregar(jabon);

        Double total = compraDelMes.calcularTotal();

        Assert.assertEquals(10.89d, total, 0d);

    }

}
