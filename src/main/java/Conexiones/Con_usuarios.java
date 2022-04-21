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

    public Usuarios recuperarDatosUsuarios(String usuario, String pass) {
        String query = "SELECT * FROM `usuarios` WHERE nombre = ? and contraseña = ?";
        Usuarios objUsers = null;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, usuario);
            pst.setString(2, pass);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ENTRO!!");
                    String nom = rs.getString(2);   //Nombre
                    String pasw = rs.getString(3);  //Contraseña
                    String apl = rs.getString(4);   //Apellidos
                    String rol = rs.getString(5);   //rol usuario
                    objUsers = new Usuarios(0, nom, pasw, apl, rol);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar la consulta!!" + ex.toString());
        }
        return objUsers;
    }
}
