package Modelos;

/**
 *
 * @author Iván Pérez
 */
public class Clientes {

    int codClientes;
    String nombre;
    String nombreComercial;
    String nif;
    int codPostal;
    String dirFiscal;
    int localidad;
    int telf;
    String email;

    public Clientes(int codClientes, String nombre, String nombreComercial, String nif, int codPostal, String dirFiscal, int localidad, int telf, String email) {
        this.codClientes = codClientes;
        this.nombre = nombre;
        this.nombreComercial = nombreComercial;
        this.nif = nif;
        this.codPostal = codPostal;
        this.dirFiscal = dirFiscal;
        this.localidad = localidad;
        this.telf = telf;
        this.email = email;
    }

    public int getCodClientes() {
        return codClientes;
    }

    public void setCodClientes(int codClientes) {
        this.codClientes = codClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getDirFiscal() {
        return dirFiscal;
    }

    public void setDirFiscal(String dirFiscal) {
        this.dirFiscal = dirFiscal;
    }

    public int getLocalidad() {
        return localidad;
    }

    public void setLocalidad(int localidad) {
        this.localidad = localidad;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
