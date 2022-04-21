package Conexiones;

import Utils.Propert;
import java.sql.*;

/**
 *
 * @author Iván Pérez
 */
public class Conexion extends javax.swing.JFrame {

    protected Connection con;
    protected PreparedStatement pst;
    protected Propert prop;
    protected String query = "SELECT nombre, contraseña, rol_trabajador FROM `usuarios` WHERE nombre = ? and contraseña = ?";

    public Conexion() {
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
}
