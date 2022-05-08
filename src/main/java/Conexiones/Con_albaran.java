package Conexiones;

import Modelos.Albaran;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Iván Pérez
 */
public class Con_albaran {

    protected Conexion objConexion;
    protected Connection con;

    public Con_albaran() {
        objConexion = new Conexion();
        con = objConexion.con;
    }

    public boolean ingresoAlbaran(int cod_albaran, int cod_cliente, int num_pedido, java.sql.Date fecha, String estado) {
        String query = "INSERT INTO `albaran`(`cod_albaran`, `cod_cliente`, `num_pedido`, `fecha`, `estado`) VALUES (?,?,?,?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, cod_albaran);
            pst.setInt(2, cod_cliente);
            pst.setInt(3, num_pedido);
            pst.setDate(4, fecha);
            pst.setString(5, estado);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList mostrarAlbaran(String buscar) {
        ArrayList<Albaran> arAlbaran = new ArrayList<>();

        String query = "SELECT * FROM `albaran` where concat(`cod_albaran`, `cod_cliente`, `num_pedido`, `fecha`, `estado`) like'%" + buscar + "%'";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod_albaran = rs.getInt(1);
                    int cod_cliente = rs.getInt(2);
                    int num_pedido = rs.getInt(3);
                    java.sql.Date fecha = rs.getDate(4);
                    String estado = rs.getString(5);

                    arAlbaran.add(new Albaran(cod_albaran, cod_cliente, num_pedido, fecha, estado));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arAlbaran;
    }

    public int codigoAlbaran() {
        String query = "select max(cod_albaran) from `albaran`";
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

    public boolean actualizarEstadoAlbaran(int codAlbaran, String estado) {
        int comprobacion = 0;
        String query = "UPDATE `albaran` set estado ='" + estado
                + "' WHERE cod_albaran='" + codAlbaran + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }
}
