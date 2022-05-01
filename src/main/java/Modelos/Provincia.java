package Modelos;

/**
 * @author Iván Pérez
 */
public class Provincia {

    int codProv;
    String nombreProvincia;
    int codPais;

    public Provincia(int codProv, String nombreProvincia, int codPais) {
        this.codProv = codProv;
        this.nombreProvincia = nombreProvincia;
        this.codPais = codPais;
    }

    public int getCodProv() {
        return codProv;
    }

    public void setCodProv(int codProv) {
        this.codProv = codProv;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

}
