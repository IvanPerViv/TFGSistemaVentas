package ModeloBD;

import Utils.Propert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

    /// CLIENTES ////
    /**
     * Metodo que agrega los diferentes valores escritor por teclado.
     *
     * @param cod_cliente
     * @param nombre
     * @param appell
     * @param telef
     * @param cod_postal
     * @param dir
     * @param ciudad
     * @param email
     * @return boolean si los datos han sido metidos.
     */
    public boolean ingresoClientes(int cod_cliente, String nombre, String appell, String telef, String cod_postal, String dir, String ciudad, String email) {
        String query = "INSERT INTO `clientes` (cod_cliente, nombre, apellidos, telefono, codigo_postal, dirrecion, ciudad, email) VALUES (?,?,?,?,?,?,?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, cod_cliente);
            pst.setString(2, nombre);
            pst.setString(3, appell);
            pst.setString(4, telef);
            pst.setString(5, cod_postal);
            pst.setString(6, dir);
            pst.setString(7, ciudad);
            pst.setString(8, email);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public void eliminarRegistroCliente(int cod_cliente) {
        String query = "DELETE FROM `clientes`  WHERE cod_cliente= '" + cod_cliente + "' ";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
    }

    public void mostrarDatosClientes(DefaultTableModel dtm, String buscar) {
        String query = "SELECT * FROM `clientes`where concat(cod_cliente, nombre, apellidos, telefono, codigo_postal, dirrecion, ciudad, email) like'%"+buscar+"%'";
        String[] registrosClientes = new String[8];

        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    registrosClientes[0] = String.valueOf(rs.getInt(1));
                    registrosClientes[1] = rs.getString(2);
                    registrosClientes[2] = rs.getString(3);
                    registrosClientes[3] = rs.getString(4);
                    registrosClientes[4] = rs.getString(5);
                    registrosClientes[5] = rs.getString(6);
                    registrosClientes[6] = rs.getString(7);
                    registrosClientes[7] = rs.getString(8);
                    dtm.addRow(registrosClientes);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
    }

    public boolean actualizarClientes(int cod_cliente, String nombre, String appell, String telef, String cod_postal, String dir, String ciudad, String email) {
        int comprobacion = 0;
        String query = "UPDATE `clientes` set cod_cliente ='" + cod_cliente
                + "',nombre='" + nombre
                + "',apellidos='" + appell
                + "',telefono='" + telef
                + "',codigo_postal='" + cod_postal
                + "',dirrecion='" + dir
                + "',ciudad='" + ciudad
                + "',email='" + email
                + "' WHERE cod_cliente='" + cod_cliente + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }
}
