package Modelos;

/**
 *
 * @author Iván Pérez
 */
public class Clientes {
    int cod_cliente;
    String nombre, pais_fiscal, nombre_comercial, id_fiscal, codigo_postal, dirrecion, ciudad, telefono, email;

    public Clientes(int cod_cliente, String nombre, String pais_fiscal, String nombre_comercial, String id_fiscal, String codigo_postal, String dirrecion, String ciudad, String telefono, String email) {
        this.cod_cliente = cod_cliente;
        this.nombre = nombre;
        this.pais_fiscal = pais_fiscal;
        this.nombre_comercial = nombre_comercial;
        this.id_fiscal = id_fiscal;
        this.codigo_postal = codigo_postal;
        this.dirrecion = dirrecion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.email = email;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais_fiscal() {
        return pais_fiscal;
    }

    public void setPais_fiscal(String pais_fiscal) {
        this.pais_fiscal = pais_fiscal;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getId_fiscal() {
        return id_fiscal;
    }

    public void setId_fiscal(String id_fiscal) {
        this.id_fiscal = id_fiscal;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
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
