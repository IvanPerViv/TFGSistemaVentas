package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
