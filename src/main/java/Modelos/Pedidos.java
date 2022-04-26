package Modelos;

/**
 *
 * @author Iván Pérez
 */
public class Pedidos {

    int cod_pedido;
    int cantidad;
    double precio;
    int iva;
    double precio_subtotal;
    double precio_total;
    String estado;
    int cod_cliente;

    public Pedidos(int cod_pedido, int cantidad, double precio, int iva, double precio_subtotal, double precio_total, String estado, int cod_cliente) {
        this.cod_pedido = cod_pedido;
        this.cantidad = cantidad;
        this.precio = precio;
        this.iva = iva;
        this.precio_subtotal = precio_subtotal;
        this.precio_total = precio_total;
        this.estado = estado;
        this.cod_cliente = cod_cliente;
    }

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public double getPrecio_subtotal() {
        return precio_subtotal;
    }

    public void setPrecio_subtotal(double precio_subtotal) {
        this.precio_subtotal = precio_subtotal;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

}
