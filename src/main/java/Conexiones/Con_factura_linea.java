package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Iván Pérez
 */
public class Con_factura_linea {

    protected Conexion objConexion;
    protected Connection con;

    public Con_factura_linea() {
        objConexion = new Conexion();
        con = objConexion.conexion();
    }
    
    public boolean ingresoLineaFactura(int numFactura, int codAlbaran, double subTotal, double total) {
        String query = "INSERT INTO `lineas_factura`(num_factura, cod_albaran, sub_total, total)"
                + "VALUES (?,?,?,?)";
        int comprobacion = 0;
        try ( PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, numFactura);
            pst.setInt(2, codAlbaran);
            pst.setDouble(3, subTotal);
            pst.setDouble(4, total);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }
}
