package Modelos;

/**
 * @author Iván Pérez
 */
public class Usuarios {
     protected int cod_usuario;
     protected String nombre, apellidos, contraseña, rol_trabajador;

    public Usuarios(int cod_usuarios, String nombre, String apellidos, String contraseña, String rol_trabajador) {
        this.cod_usuario = cod_usuarios;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.rol_trabajador = rol_trabajador;
    }

    public int getCod_usuarios() {
        return cod_usuario;
    }

    public void setCod_usuarios(int cod_usuarios) {
        this.cod_usuario = cod_usuarios;
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

    public String getRol_trabajador() {
        return rol_trabajador;
    }

    public void setRol_trabajador(String rol_trabajador) {
        this.rol_trabajador = rol_trabajador;
    }
    
}
