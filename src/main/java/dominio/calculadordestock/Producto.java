package dominio.calculadordestock;

public abstract class Producto {
    private Integer codigo;
    private String marca;
    private String nombre;

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract Double precio();
    public abstract Integer stock();
}
