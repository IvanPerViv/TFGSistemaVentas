package Conexiones;

import Modelos.Clientes;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Iván Pérez
 */
public class Con_clientes {

    protected Conexion objConexion;
    protected Connection con;

    public Con_clientes() {
        objConexion = new Conexion();
        con = objConexion.con;
    }

    /**
     * Metodo que agrega los diferentes valores escritor por teclado.
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

    public ArrayList mostrarClientesYBusqueda(String buscar) {
        String query = "SELECT * FROM `clientes`where concat(cod_cliente, nombre, apellidos, telefono, codigo_postal, dirrecion, ciudad, email) like'%" + buscar + "%'";

        ArrayList<Clientes> clie = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int codClie = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String apellidos = rs.getString(3);
                    String telefono = rs.getString(4);
                    String codigo_postal = rs.getString(5);
                    String dirrecion = rs.getString(6);
                    String ciudad = rs.getString(7);
                    String email = rs.getString(8);
                    clie.add(new Clientes(codClie, nombre, apellidos, telefono, codigo_postal, dirrecion, ciudad, email));

                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return clie;
    }

}
