package Modelos;

/**
 * @author Iváan Pérez
 */
public class Articulo {

    int codArticulo;
    String nombreProducto;
    double precioCompra;
    int stock, IVA, familia;

    public Articulo(int cod_articulo, String nombre_producto, int familia, double precio_compra, int IVA, int stock) {
        this.codArticulo = cod_articulo;
        this.nombreProducto = nombre_producto;
        this.familia = familia;
        this.precioCompra = precio_compra;
        this.IVA = IVA;
        this.stock = stock;
    }

    public int getFamilia() {
        return familia;
    }

    public void setFamilia(int familia) {
        this.familia = familia;
    }

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int IVA) {
        this.IVA = IVA;
    }

    public int getCod_articulo() {
        return codArticulo;
    }

    public void setCod_articulo(int cod_articulo) {
        this.codArticulo = cod_articulo;
    }

    public String getNombre_producto() {
        return nombreProducto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombreProducto = nombre_producto;
    }

    public double getPrecio_compra() {
        return precioCompra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precioCompra = precio_compra;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
