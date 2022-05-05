package Modelos;

import java.sql.Date;

/**
 *
 * @author Iván Pérez
 */
public class Pedidos {

    int num_pedido;
    Date fecha_pedido;
    int cod_cliente;
    String estado;
    String observaciones;

    public Pedidos(int num_pedido, Date fecha_pedido, int cod_cliente, String estado, String observaciones) {
        this.num_pedido = num_pedido;
        this.fecha_pedido = fecha_pedido;
        this.cod_cliente = cod_cliente;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public int getNum_pedido() {
        return num_pedido;
    }

    public void setNum_pedido(int num_pedido) {
        this.num_pedido = num_pedido;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
