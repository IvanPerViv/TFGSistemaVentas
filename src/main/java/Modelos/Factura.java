package Modelos;

import java.sql.Date;

/**
 * @author Iván Pérez
 */
public class Factura {

    int codFactura;
    int CodCliente;
    Date fechaFactura;
    String observaciones;

    public Factura(int codFactura, int CodCliente, Date fechaFactura, String observaciones) {
        this.codFactura = codFactura;
        this.CodCliente = CodCliente;
        this.fechaFactura = fechaFactura;
        this.observaciones = observaciones;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public int getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(int CodCliente) {
        this.CodCliente = CodCliente;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
