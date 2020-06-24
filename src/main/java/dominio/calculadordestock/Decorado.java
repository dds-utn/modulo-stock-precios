package dominio.calculadordestock;

public abstract class Decorado extends Producto {
    protected Producto producto;

    public Decorado(Producto producto){
        this.producto = producto;
    }

    @Override
    public Integer stock(){
        return this.producto.stock();
    }
}