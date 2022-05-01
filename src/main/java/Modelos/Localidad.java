package Modelos;

/**
 *
 * @author Iván Pérez
 */
public class Localidad {

    int codLocalidad;
    String nombreCiudad;
    int CodProv;

    public Localidad(int codLocalidad, String nombreCiudad, int CodProv) {
        this.codLocalidad = codLocalidad;
        this.nombreCiudad = nombreCiudad;
        this.CodProv = CodProv;
    }

    public int getCodLocalidad() {
        return codLocalidad;
    }

    public void setCodLocalidad(int codLocalidad) {
        this.codLocalidad = codLocalidad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public int getCodProv() {
        return CodProv;
    }

    public void setCodProv(int CodProv) {
        this.CodProv = CodProv;
    }

}
