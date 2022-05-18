package Modelos;

/**
 * @author Iván Pérez
 */
public class LineaPedido {

    int numPedido;
    int codArticulo;
    int cantidad;
    double precioVenta;
    double iva;

    public LineaPedido(int numPedido, int codArticulo, int cantidad, double precioVenta, double iva) {
        this.numPedido = numPedido;
        this.codArticulo = codArticulo;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.iva = iva;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
}
