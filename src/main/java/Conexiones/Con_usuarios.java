package Conexiones;

import Modelos.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public String mostrarCodUsuario(int buscar) {
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
}
