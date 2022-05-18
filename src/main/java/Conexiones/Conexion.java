package Conexiones;

import Utils.cargaBaseDatos;
import java.sql.*;

/**
 *
 * @author Iván Pérez
 */
public class Conexion extends javax.swing.JFrame {

    protected Connection con = null;
    protected PreparedStatement pst;
    protected cargaBaseDatos prop;

    public Conexion() {
        prop = new cargaBaseDatos();
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
