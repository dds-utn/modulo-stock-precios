package dominio.calculadordestock;

public class Packaging extends Decorado {
    private Double precio;

    public Packaging(Producto producto, Double precio) {
        super(producto);
        this.precio = precio;
    }

    @Override
    public Double precio() {
        return super.producto.precio() + this.precio;
    }
}
