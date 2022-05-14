package Conexiones;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Iván Pérez
 */
public class Con_factura {

    protected Conexion objConexion;
    protected Connection con;

    public Con_factura() {
        objConexion = new Conexion();
        con = objConexion.conexion();
    }

    public int codigoFactura() {
        String query = "select max(cod_factura) from `factura`";
        int codigo = 0;
        try ( PreparedStatement pst = con.prepareStatement(query)) {
            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    codigo = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return codigo;
    }

    public boolean ingresoFacturas(int codFactura, int codCliente, Date fechaDate, String area) {
        String query = "INSERT INTO `factura`(cod_factura, cliente, fecha_factura, observaciones)"
                + "VALUES (?,?,?,?)";
        int comprobacion = 0;
        try ( PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, codFactura);
            pst.setInt(2, codCliente);
            pst.setDate(3, fechaDate);
            pst.setString(4, area);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }
    
}
