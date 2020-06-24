package calculadordestocktest;

import dominio.calculadordestock.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductoTest {
    private ProductoSimple guantes;
    private ProductoSimple casco;
    private ProductoSimple chaleco;
    private ProductoSimple piloto;
    private Combo comboBasico;
    private Combo comboPremium;

    @Before
    public void init(){
        guantes = new ProductoSimple();
        guantes.setNombre("guantes");
        guantes.setPrecio(600.00);
        guantes.setStock(10);

        casco = new ProductoSimple();
        casco.setPrecio(1200.00);
        casco.setNombre("Casco");

        chaleco = new ProductoSimple();
        chaleco.setNombre("Chaleco");
        chaleco.setPrecio(400.00);

        piloto = new ProductoSimple();
        piloto.setPrecio(500.00);
        piloto.setNombre("Piloto");

        comboBasico = new Combo();
        comboBasico.agregarProducto(guantes, casco, chaleco);

        comboPremium = new Combo();
        comboPremium.agregarProducto(comboBasico, piloto);
    }

    @Test
    public void comboBasicoVale2200Test(){
        Assert.assertEquals(2200, comboBasico.precio(),0.0);
    }

    @Test
    public void comboPremiumVale2700Test(){
        Assert.assertEquals(2700, comboPremium.precio(), 0.0);
    }

    @Test
    public void comboBasicoConDescuentoVale2000Test(){
        Decorado descuentoDe200pe = new DescuentoFijo(comboBasico,200.00);
        Assert.assertEquals(2000, descuentoDe200pe.precio(), 0.0);
    }

    @Test
    public void chalecoConPackagingVale500Test(){
        Decorado caja = new Packaging(chaleco, 100.00);
        Assert.assertEquals(500, caja.precio(), 0.0);
    }

    @Test
    public void premiumConDescuentoYPackagingVale2400(){
        Decorado descuentoDe500Pe = new DescuentoFijo(comboPremium, 500.00);
        Decorado cajon = new Packaging(descuentoDe500Pe, 200.00);
        Assert.assertEquals(2400.00, cajon.precio(), 0.0);
    }
}