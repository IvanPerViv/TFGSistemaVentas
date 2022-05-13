package Modelos;

/**
 *
 * @author Iván Pérez
 */
public class LineaFactura {

    int numFactura;
    int codAlbaran;
    double subTotal;
    double total;

    public LineaFactura(int numFactura, int codAlbaran, double subTotal, double total) {
        this.numFactura = numFactura;
        this.codAlbaran = codAlbaran;
        this.subTotal = subTotal;
        this.total = total;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public int getCodAlbaran() {
        return codAlbaran;
    }

    public void setCodAlbaran(int codAlbaran) {
        this.codAlbaran = codAlbaran;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
