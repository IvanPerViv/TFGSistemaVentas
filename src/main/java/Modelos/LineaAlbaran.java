package Modelos;

/**
 *
 * @author Iván Pérez
 */
public class LineaAlbaran {

    int numAlbaran;
    int codArticulo;
    int cantidad;
    double precioUnitario;
    double iva;

    public LineaAlbaran(int numAlbaran, int codArticulo, int cantidad, double precioUnitario, double iva) {
        this.numAlbaran = numAlbaran;
        this.codArticulo = codArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.iva = iva;
    }

    public int getNumAlbaran() {
        return numAlbaran;
    }

    public void setNumAlbaran(int numAlbaran) {
        this.numAlbaran = numAlbaran;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

}
