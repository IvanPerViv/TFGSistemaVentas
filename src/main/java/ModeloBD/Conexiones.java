package ModeloBD;

import Utils.Propert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Iván Pérez
 */
public class Conexiones extends javax.swing.JFrame {

    protected Connection con;
    protected PreparedStatement pst;
    protected Propert prop;
    protected String query = "SELECT nombre, contraseña, rol_trabajador FROM `usuarios` WHERE nombre = ? and contraseña = ?";

    public Conexiones() {
        prop = new Propert();
        conexion(prop);
    }

    public void conexion(Propert valorProperties) {
        try {
            con = DriverManager.getConnection(valorProperties.URL + valorProperties.BBDD, valorProperties.USER, valorProperties.PASS);
            System.out.println("CONEXION EXITOSA!!");
        } catch (SQLException ex) {
            System.err.println("Fallo en la BBDD" + ex.toString());
        }
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
                    String nom = rs.getString(2); //NOM
                    String pasw = rs.getString(3); //PASS
                    String apl = rs.getString(4); //Appelidos
                    String rol = rs.getString(5); //ROL
                    System.out.println(nom);
                    objUsers = new Usuarios(0, nom, pasw, apl, rol);
                }
            } catch (SQLException ex) {
                System.err.println("Error al ejecutar la consulta!!" + ex.toString());
            }
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar la consulta!!" + ex.toString());
        }
        return objUsers;

    }

}
