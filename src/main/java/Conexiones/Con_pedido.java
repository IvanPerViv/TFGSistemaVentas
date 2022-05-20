package Conexiones;

import Modelos.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Iván Pérez
 */
public class Con_pedido {

    protected Conexion objConexion;
    protected Connection con;

    public Con_pedido() {
        objConexion = new Conexion();
        con = objConexion.conexion();
    }

    public int codigoPedidos() {
        String query = "select max(num_pedido) from `pedidos`";
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

    public boolean ingresoPedidos(int num_pedido,  int cod_cliente, java.sql.Date fecha_pedido, String estado, String observaciones) {
        String query = "INSERT INTO `pedidos`(num_pedido, cod_cliente, fecha_pedido, estado, observaciones)"
                + "VALUES (?,?,?,?,?)";
        int comprobacion = 0;
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, num_pedido);
            pst.setInt(2, cod_cliente);
            pst.setDate(3, fecha_pedido);
            pst.setString(4, estado);
            pst.setString(5, observaciones);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList mostrarPedidos(String buscar) {
        String query = "SELECT * FROM `pedidos`where concat(num_pedido, fecha_pedido, cod_cliente, estado, observaciones) like'%" + buscar + "%'";

        ArrayList<Pedido> arPedidos = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int numPedido = rs.getInt(1);
                    int codCliente = rs.getInt(2);
                    Date fechaPedido = rs.getDate(3);
                    String estado = rs.getString(4);
                    String observaciones = rs.getString(5);
                    arPedidos.add(new Pedido(numPedido, fechaPedido, codCliente, estado, observaciones));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arPedidos;
    }
    
    public ArrayList busquedaNumPedido(int buscar) {
        String query = "SELECT * FROM `pedidos` WHERE num_pedido =" + buscar;
        ArrayList<Pedido> arPedidos = new ArrayList<>();
        
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int numPedido = rs.getInt(1);
                    int codCliente = rs.getInt(2);
                    Date fechaPedido = rs.getDate(3);
                    String estado = rs.getString(4);
                    String observaciones = rs.getString(5);
                    arPedidos.add(new Pedido(numPedido, fechaPedido, codCliente, estado, observaciones));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arPedidos;
    }
    

    public void eliminarPedido(int numPedido) {
        String query = "DELETE FROM `pedidos`  WHERE num_pedido= '" + numPedido + "' ";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
    }

    //SELECT * FROM `pedidos` INNER JOIN clientes USING(cod_cliente);
    //SELECT nombre_comercial FROM `pedidos` INNER JOIN clientes on pedidos.cod_pedido = clientes.cod_cliente where clientes.cod_cliente = '2';
    public String mostrarNombreCliente(int buscar) {
        String query = "SELECT nombre_comercial FROM `clientes` WHERE cod_cliente = '" + buscar + "'";
        String resultado = "";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    resultado = rs.getString(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return resultado;
    }
    
    public int mostrarCodCliente(String buscar) {
        String query = "SELECT cod_cliente FROM `clientes` WHERE nombre_comercial LIKE '%" + buscar + "%'";
        int resultado = 0;
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    resultado = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return resultado;
    }

    public boolean actualizarEstadoPedido(int numPedido, String estado) {
        int comprobacion = 0;
        String query = "UPDATE `pedidos` set estado ='" + estado
                + "' WHERE num_pedido='" + numPedido + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

}
