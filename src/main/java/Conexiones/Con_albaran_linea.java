package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Iván Pérez
 */
public class Con_albaran_linea {
    protected Conexion objConexion;
    protected Connection con;

    public Con_albaran_linea() {
        objConexion = new Conexion();
        con = objConexion.con;
    }
    
    public boolean ingresoLineasPedidos(int numAlbaran, int articulo, int cantidad, Double precioUni, double iva) {
        String query = "INSERT INTO `lineas_albaran`(num_albaran, articulo, cantidad, precio_uni, iva)"
                + "VALUES (?,?,?,?,?)";
        int comprobacion = 0;
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, numAlbaran);
            pst.setInt(2, articulo);
            pst.setInt(3, cantidad);
            pst.setDouble(4, precioUni);
            pst.setDouble(5, iva);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }
    
    
    
}
