package Conexiones;

import Utils.Propert;
import java.sql.*;

/**
 *
 * @author Iván Pérez
 */
public class Conexion extends javax.swing.JFrame {

    protected Connection con = null;
    protected PreparedStatement pst;
    protected Propert prop;

    public Conexion() {
        prop = new Propert();
    }

    public Connection conexion() {
        try {
            con = DriverManager.getConnection(prop.URL + prop.BBDD, prop.USER, prop.PASS);
        } catch (SQLException ex) {
            System.err.println("Fallo en la conexion con la BBDD" + ex.toString());
        }
        return con;
    }

    public void desconexion() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
}
