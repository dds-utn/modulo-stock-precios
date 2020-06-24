package dominio.calculadordestock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Combo extends Producto {
    private List<Producto> productos;

    public Combo(){
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto ... productos){
        Collections.addAll(this.productos, productos);
    }

    @Override
    public Double precio() {
        return this.productos.stream().mapToDouble(Producto::precio).sum();
    }

    @Override
    public Integer stock() {
        return Collections.min(this.productos, Comparator.comparing(Producto::stock)).stock();
    }
}