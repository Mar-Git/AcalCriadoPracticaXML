package clases;

public class Producto {

    private int id;
    private String descripcion;
    private double precio;
    private int stock;

    public Producto(int id, String descripcion,double precio, int stock ) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio =precio;
        this.stock = stock;
    }

    public Producto(){
        id =0;
        descripcion="";
        precio =0.0;
        stock =0;
    }

    public int getId() {
        return id;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
