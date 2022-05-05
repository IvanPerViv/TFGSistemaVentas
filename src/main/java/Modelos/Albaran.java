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

    public Albaran(int codAlbaran, int codCliente, int numPedido, Date fecha) {
        this.codAlbaran = codAlbaran;
        this.codCliente = codCliente;
        this.numPedido = numPedido;
        this.fecha = fecha;
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
