package Conexiones;

import Modelos.LineaAlbaran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Iván Pérez
 */
public class Con_albaran_linea {

    protected Conexion objConexion;
    protected Connection con;

    public Con_albaran_linea() {
        objConexion = new Conexion();
        con = objConexion.conexion();
    }

    public boolean ingresoLineaAlbaran(int numAlbaran, int articulo, int cantidad, double precioUni, double iva) {
        String query = "INSERT INTO `lineas_albaran`(num_albaran, articulo, cantidad, precio_uni, iva)"
                + "VALUES (?,?,?,?,?)";
        int comprobacion = 0;
        try ( PreparedStatement pst = con.prepareStatement(query)) {
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

    public ArrayList mostrarLineaAlbaran(int buscar) {
        ArrayList<LineaAlbaran> arAlbaran = new ArrayList<>();

        String query = "SELECT * FROM `lineas_albaran` where num_albaran =" + buscar;
        try ( PreparedStatement pst = con.prepareStatement(query)) {
            try ( ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int codAlbaran = rs.getInt(1);
                    int codArt = rs.getInt(2);
                    int cantidad = rs.getInt(3);
                    double precioUni = rs.getDouble(4);
                    double iva = rs.getDouble(5);

                    arAlbaran.add(new LineaAlbaran(codAlbaran, codArt, cantidad, precioUni, iva));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arAlbaran;
    }

    public boolean actualizarLineaAlbaran(int cantidadEnviada, int numeroDeAlbaran, int numArticulo) {
        int comprobacion = 0;
        String query = "UPDATE `lineas_albaran` set cantidad = " + cantidadEnviada
                //+ ",cantidad =" + cantidad
                + " WHERE num_albaran = " + numeroDeAlbaran + " and articulo = " + numArticulo;

        try ( PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public int maxCodLineaAlbaran() {
        String query = "select max(cod_linea_albaran) from `lineas_albaran`";
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
}
