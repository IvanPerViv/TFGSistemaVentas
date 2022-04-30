package Modelos;

/**
 * @author Iván Pérez
 */
public class Usuarios {

    protected int codUsuario, rol;
    protected String usuario, nombre, apellidos, contraseña;

    public Usuarios(int cod_usuario, String usuario, String nombre, String apellidos, String contraseña, int rol) {
        this.codUsuario = cod_usuario;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public int getCod_usuario() {
        return codUsuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.codUsuario = cod_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

}
