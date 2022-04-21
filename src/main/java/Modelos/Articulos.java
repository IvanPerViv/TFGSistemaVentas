package Modelos;

/**
 * @author Iváan Pérez
 */
public class Articulos {

    int cod_articulo;
    String nombre_producto;
    double precio_compra;
    int stock;

    public Articulos(int cod_articulo, String nombre_producto, double precio_compra, int stock) {
        this.cod_articulo = cod_articulo;
        this.nombre_producto = nombre_producto;
        this.precio_compra = precio_compra;
        this.stock = stock;
    }

    public int getCod_articulo() {
        return cod_articulo;
    }

    public void setCod_articulo(int cod_articulo) {
        this.cod_articulo = cod_articulo;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
