package Conexiones;

import Modelos.LineaPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Iván Pérez
 */
public class Con_pedido_linea {

    protected Conexion objConexion;
    protected Connection con;

    public Con_pedido_linea() {
        objConexion = new Conexion();
        con = objConexion.conexion();
    }

    public boolean ingresoLineasPedidos(int codPedido, int codArticulo, int cantidad, Double precioVenta, double iva) {
        String query = "INSERT INTO `lineas_pedidos`(pedido, articulo, cantidad, precio_venta, iva)"
                + "VALUES (?,?,?,?,?)";
        int comprobacion = 0;
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, codPedido);
            pst.setInt(2, codArticulo);
            pst.setInt(3, cantidad);
            pst.setDouble(4, precioVenta);
            pst.setDouble(5, iva);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList mostrarLineasPedidos(int buscar) {
        String query = "SELECT * FROM lineas_pedidos WHERE pedido=" + buscar;

        ArrayList<LineaPedido> arLineaPedido = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int codPedido = rs.getInt(2);
                    int codArticulo = rs.getInt(3);
                    int cantidad = rs.getInt(4);
                    double precioVentaa = rs.getDouble(5);
                    double iva = rs.getDouble(6);

                    arLineaPedido.add(new LineaPedido(codPedido, codArticulo, cantidad, precioVentaa, iva));

                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arLineaPedido;
    }

}
