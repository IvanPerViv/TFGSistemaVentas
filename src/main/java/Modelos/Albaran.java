package Modelos;

import java.sql.Date;

/**
 * @author Iván Pérez
 */
public class Albaran {

    int codAlbaran;
    int codCliente;
    int numPedido;
    Date fecha;
    String estado;

    public Albaran(int codAlbaran, int codCliente, int numPedido, Date fecha, String estado) {
        this.codAlbaran = codAlbaran;
        this.codCliente = codCliente;
        this.numPedido = numPedido;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodAlbaran() {
        return codAlbaran;
    }

    public void setCodAlbaran(int codAlbaran) {
        this.codAlbaran = codAlbaran;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
