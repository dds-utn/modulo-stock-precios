package dominio.calculadordestock;

public class DescuentoFijo extends Decorado {
    private Double valor;

    public DescuentoFijo(Producto producto, Double valor) {
        super(producto);
        this.valor = valor;
    }

    @Override
    public Double precio() {
        return super.producto.precio() - this.valor;
    }
}
