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
        con = conexion(prop);
    }

    public Connection conexion(Propert valorProperties) {
        try {
            con = DriverManager.getConnection(valorProperties.URL + valorProperties.BBDD, valorProperties.USER, valorProperties.PASS);
        } catch (SQLException ex) {
            System.err.println("Fallo en la conexion con la BBDD" + ex.toString());
        }
        return con;
    }
}
