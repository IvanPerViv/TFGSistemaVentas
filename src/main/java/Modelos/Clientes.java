package Modelos;

/**
 *
 * @author Iván Pérez
 */
public class Clientes {
    int codClientes;
    String nombre, paisFiscal, nombreComercial, idFiscal, codigoPostal, dirrecion, ciudad, telefono, email;

    public Clientes(int cod_cliente, String nombre, String pais_fiscal, String nombre_comercial, String id_fiscal, String codigo_postal, String dirrecion, String ciudad, String telefono, String email) {
        this.codClientes = cod_cliente;
        this.nombre = nombre;
        this.paisFiscal = pais_fiscal;
        this.nombreComercial = nombre_comercial;
        this.idFiscal = id_fiscal;
        this.codigoPostal = codigo_postal;
        this.dirrecion = dirrecion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.email = email;
    }

    public int getCod_cliente() {
        return codClientes;
    }

    public void setCod_cliente(int cod_cliente) {
        this.codClientes = cod_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais_fiscal() {
        return paisFiscal;
    }

    public void setPais_fiscal(String pais_fiscal) {
        this.paisFiscal = pais_fiscal;
    }

    public String getNombre_comercial() {
        return nombreComercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombreComercial = nombre_comercial;
    }

    public String getId_fiscal() {
        return idFiscal;
    }

    public void setId_fiscal(String id_fiscal) {
        this.idFiscal = id_fiscal;
    }

    public String getCodigo_postal() {
        return codigoPostal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigoPostal = codigo_postal;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
