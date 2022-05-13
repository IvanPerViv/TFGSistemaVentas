package Conexiones;

import Modelos.Cliente;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Iván Pérez
 */
public class Con_cliente {

    protected Conexion objConexion;
    protected Connection con;

    public Con_cliente() {
        objConexion = new Conexion();
        con = objConexion.conexion();
    }

    /**
     * Metodo que agrega los diferentes valores escritor por teclado.
     *
     * @return boolean si los datos han sido metidos.
     */
    public boolean ingresoClientes(int codCliente, String nombre, String nombreComercial, String nifCif, int codPostal, String dirFiscal, int localidadFiscal, int telefono, String email) {
        String query = "INSERT INTO `clientes` (cod_cliente, nombre, nombre_comercial, nif_cif,  codigo_postal, dirrecion_fiscal, localidad_fiscal, telefono, email)"
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, codCliente);
            pst.setString(2, nombre);
            pst.setString(3, nombreComercial);
            pst.setString(4, nifCif);
            pst.setInt(5, codPostal);
            pst.setString(6, dirFiscal);
            pst.setInt(7, localidadFiscal);
            pst.setInt(8, telefono);
            pst.setString(9, email);

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

    public boolean actualizarClientes(int codCliente, String nombre, String nombreComercial, String nif, 
            int codPostal, String dirFiscal, int localidadFiscal, int telefono, String email) {
        int comprobacion = 0;
        String query = "UPDATE `clientes` set cod_cliente ='" + codCliente
                + "',nombre='" + nombre
                + "',nombre_comercial='" + nombreComercial
                + "',nif_cif='" + nif
                + "',codigo_postal='" + codPostal
                + "',dirrecion_fiscal='" + dirFiscal
                + "',localidad_fiscal='" + localidadFiscal
                + "',telefono='" + telefono
                + "',email='" + email
                + "' WHERE cod_cliente='" + codCliente + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList mostrarClientesYBusqueda(String buscar) {
        String query = "SELECT * FROM `clientes`where concat(cod_cliente, nombre, nombre_comercial, nif_cif,  codigo_postal, dirrecion_fiscal, localidad_fiscal, telefono, email) like'%" + buscar + "%'";

        ArrayList<Cliente> arCliente = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int codClie = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String nombreComercial = rs.getString(3);
                    String nif = rs.getString(4);
                    int codPostal = rs.getInt(5);
                    String dirFiscal = rs.getString(6);
                    int localidadFiscal = rs.getInt(7);
                    int telefono = rs.getInt(8);
                    String email = rs.getString(9);
                    arCliente.add(new Cliente(codClie, nombre, nombreComercial, nif, codPostal, dirFiscal, localidadFiscal, telefono, email));

                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arCliente;
    }
    
    public ArrayList mostrarDatosClientes(int buscar) {
        String query = "SELECT * FROM `clientes` where cod_cliente =" + buscar;
        ArrayList<Cliente> arCliente = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int codClie = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String nombreComercial = rs.getString(3);
                    String nif = rs.getString(4);
                    int codPostal = rs.getInt(5);
                    String dirFiscal = rs.getString(6);
                    int localidadFiscal = rs.getInt(7);
                    int telefono = rs.getInt(8);
                    String email = rs.getString(9);
                    arCliente.add(new Cliente(codClie, nombre, nombreComercial, nif, codPostal, dirFiscal, localidadFiscal, telefono, email));

                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arCliente;
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
