package Conexiones;

import Modelos.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Iván Pérez
 */
public class Con_pedidos {

    protected Conexion objConexion;
    protected Connection con;

    public Con_pedidos() {
        objConexion = new Conexion();
        con = objConexion.con;
    }

    public int codigoPedidos() {
        String query = "select max(cod_pedido) from `pedidos`";
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

    
    
    
    public boolean ingresoPedidos(int cod_pedido, int cantidad, double precio, int iva, double precio_subtotal, double precio_total, String estado, int codClie) {
        String query = "INSERT INTO `pedidos`(cod_pedido,cantidad, precio, iva, precio_sub, precio_total, estado,cod_cliente )"
                + "VALUES (?,?,?,?,?,?,?,?)";
        int comprobacion = 0;
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, cod_pedido);
            pst.setInt(2, cantidad);
            pst.setDouble(3, precio);
            pst.setInt(4, iva);
            pst.setDouble(5, precio_subtotal);
            pst.setDouble(6, precio_total);
            pst.setString(7, estado);
             pst.setInt(8, codClie);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList mostrarPedidos(String buscar) {
        String query = "SELECT * FROM `pedidos`where concat(cod_pedido, cantidad, precio, iva, precio_sub, precio_total, estado,cod_cliente ) like'%" + buscar + "%'";

        ArrayList<Pedidos> clie = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod_pedido = rs.getInt(1);
                    int cantidad = rs.getInt(2);
                    double precio = rs.getDouble(3);
                    int iva = rs.getInt(4);
                    double precio_sub = rs.getDouble(5);
                    double precio_total= rs.getDouble(6);
                    String estado = rs.getString(7);
                    int cod_cliente = rs.getInt(8);
                    clie.add(new Pedidos(cod_pedido, cantidad, precio, iva, precio_sub, precio_total,estado,cod_cliente));

                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return clie;
    }

}
