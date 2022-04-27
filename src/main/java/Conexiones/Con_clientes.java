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
     *
     * @return boolean si los datos han sido metidos.
     */
    public boolean ingresoClientes(int cod_cliente, String nombre, String pais_fiscal, String nombre_comercial, int id_fiscal, int cod_postal, String dir, String ciudad, int telf, String email) {
        String query = "INSERT INTO `clientes` (cod_cliente, nombre, pais_fiscal, nombre_comercial, id_fiscal, codigo_postal, dirrecion, ciudad, telefono, email)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, cod_cliente);
            pst.setString(2, nombre);
            pst.setString(3, pais_fiscal);
            pst.setString(4, nombre_comercial);
            pst.setInt(5, id_fiscal);
            pst.setInt(6, cod_postal);
            pst.setString(7, dir);
            pst.setString(8, ciudad);
            pst.setInt(9, telf);
            pst.setString(10, email);

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

    public boolean actualizarClientes(int cod_cliente, String nombre, String pais_fiscal, String nombre_comercial, int id_fiscal, int cod_postal, String dir, String ciudad, int telf, String email) {
        int comprobacion = 0;
        String query = "UPDATE `clientes` set cod_cliente ='" + cod_cliente
                + "',nombre='" + nombre
                + "',pais_fiscal='" + pais_fiscal
                + "',nombre_comercial='" + nombre_comercial
                + "',id_fiscal='" + id_fiscal
                + "',codigo_postal='" + cod_postal
                + "',dirrecion='" + dir
                + "',ciudad='" + ciudad
                + "',telefono='" + telf
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
        String query = "SELECT * FROM `clientes`where concat(cod_cliente, nombre, pais_fiscal, nombre_comercial, codigo_postal, dirrecion, ciudad,telefono, email) like'%" + buscar + "%'";

        ArrayList<Clientes> clie = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int codClie = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String pais_fiscal = rs.getString(3);
                    String nombre_comercial = rs.getString(4);
                    String id_fiscal = rs.getString(5);
                    String codigo_postal = rs.getString(6);
                    String dirrecion = rs.getString(7);
                    String ciudad = rs.getString(8);
                     String telefono = rs.getString(9);
                    String email = rs.getString(10);
                    clie.add(new Clientes(codClie, nombre, pais_fiscal, nombre_comercial,id_fiscal, codigo_postal, dirrecion, ciudad, telefono, email));

                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return clie;
    }

    public int codigoClientes() {
        String query = "select max(cod_cliente) from `clientes`";
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
