package Conexiones;

import Modelos.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Iván Pérez
 */
public class Con_usuarios {

    protected Conexion objConexion;
    protected Connection con;

    public Con_usuarios() {
        objConexion = new Conexion();
        con = objConexion.con;
    }

    public String mostrarNombreRol(int buscar) {
        String query = "SELECT rol_usuario FROM `usuarios` INNER JOIN roles_usuarios on usuarios.cod_usuario = roles_usuarios.cod_rol WHERE roles_usuarios.cod_rol = " + buscar;
        String resultado = "";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    resultado = rs.getString(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return resultado;
    }
    
    public int mostrarNombreRol(String buscar) {
        String query = "SELECT cod_rol FROM `roles_usuarios` WHERE rol_usuario LIKE '" + buscar + "'";
        int resultado=0;
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    resultado = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return resultado;
    }

    public Usuarios recuperarDatosUsuarios(String usuario, String pass) {
        String query = "SELECT * FROM `usuarios` WHERE usuario = ? and contraseña = ?";
        Usuarios objUsers = null;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, usuario);
            pst.setString(2, pass);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int cod = rs.getInt(1);
                    String user = rs.getString(2);
                    String nom = rs.getString(3);   //Nombre
                    String pasw = rs.getString(4);  //Contraseña
                    String apl = rs.getString(5);   //Apellidos
                    int rol = rs.getInt(6);   //rol usuario
                    objUsers = new Usuarios(cod, user, nom, pasw, apl, rol);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar la consulta!!" + ex.toString());
        }
        return objUsers;
    }
    
    public void eliminarUsuario(int codUser) {
        String query = "DELETE FROM `usuarios`  WHERE cod_usuario= '" + codUser + "' ";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
    }
    
    
    public boolean ingresoUsuarios(int cod_usuario, String usuario, String nombre, String apellidos, String contraseña, int rol) {
        String query = "INSERT INTO `usuarios`(`cod_usuario`, `usuario`, `nombre`, `apellidos`, `contraseña`,`rol`) VALUES (?,?,?,?,?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, cod_usuario);
            pst.setString(2, usuario);
            pst.setString(3, nombre);
            pst.setString(4, apellidos);
            pst.setString(5, contraseña);
            pst.setInt(6, rol);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }
    
     public boolean actualizarUsuarios(int cod_usuario, String usuario, String nombre, String apellidos, String contraseña, int rol) {
        int comprobacion = 0;
        String query = "UPDATE `usuarios` set cod_usuario ='" + cod_usuario
                + "',usuario ='" + usuario
                + "',nombre ='" + nombre
                + "',apellidos ='" + apellidos
                + "',contraseña ='" + contraseña
                + "',rol ='" + rol
                + "' WHERE cod_usuario ='" + cod_usuario + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }
    
    public ArrayList mostrarUsuarios(String buscar) {
        ArrayList<Usuarios> arUser = new ArrayList<>();

        String query = "SELECT * FROM `usuarios` where concat(`cod_usuario`, `usuario`, `nombre`, `apellidos`, `contraseña`,`rol`) like'%" + buscar + "%'";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt(1);
                    String nomUsuario = rs.getString(2);
                    String nombre= rs.getString(3);
                    String apellidos = rs.getString(4);
                    String pass = rs.getString(5);
                    int rol = rs.getInt(6);
                    
                    arUser.add(new Usuarios(cod, nomUsuario, nombre, apellidos, pass, rol));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arUser;
    }
    
    
    public int codigoUsuarios() {
        String query = "select max(cod_usuario) from `usuarios`";
        int codigo = 0;
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    codigo = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return codigo;
    }
}
