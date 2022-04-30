package Modelos;

/**
 *
 * @author Iván Pérez
 */
public class Pedidos {

    int codPedido, cantidad,iva, codCliente;
    double precio, precioSubtotal, precioTotal;
    String estado;

    public Pedidos(int cod_pedido, int cantidad, double precio, int iva, double precio_subtotal, double precio_total, String estado, int cod_cliente) {
        this.codPedido = cod_pedido;
        this.cantidad = cantidad;
        this.precio = precio;
        this.iva = iva;
        this.precioSubtotal = precio_subtotal;
        this.precioTotal = precio_total;
        this.estado = estado;
        this.codCliente = cod_cliente;
    }

    public int getCod_pedido() {
        return codPedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.codPedido = cod_pedido;
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
        return precioSubtotal;
    }

    public void setPrecio_subtotal(double precio_subtotal) {
        this.precioSubtotal = precio_subtotal;
    }

    public double getPrecio_total() {
        return precioTotal;
    }

    public void setPrecio_total(double precio_total) {
        this.precioTotal = precio_total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCod_cliente() {
        return codCliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.codCliente = cod_cliente;
    }

}
