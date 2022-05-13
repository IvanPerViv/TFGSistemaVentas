package Conexiones;

import Modelos.FamiliaArticulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Iván Pérez
 */
public class Con_familia_articulo {

    protected Conexion objConexion;
    protected Connection con;

    public Con_familia_articulo() {
        objConexion = new Conexion();
        con = objConexion.conexion();
    }

    public boolean ingresoFamiliaArticulos(int codFamilia, String nombreFamilia) {
        String query = "INSERT INTO `familias_articulos`(`cod_familia`, `nombre_familia`) VALUES (?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, codFamilia);
            pst.setString(2, nombreFamilia);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public void eliminarRegistroFamiliaArticulos(int codFamilia) {
        String query = "DELETE FROM `familias_articulos`  WHERE cod_familia = '" + codFamilia + "' ";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
    }

    public boolean actualizarFamiliaArticulos(int codFamilia, String nombreFamilia) {
        int comprobacion = 0;
        String query = "UPDATE `familias_articulos` set cod_familia ='" + codFamilia
                + "',nombre_familia='" + nombreFamilia
                + "' WHERE cod_familia='" + codFamilia + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }
    
    public ArrayList mostrarArticulosYBusqueda(String buscar) {
        ArrayList<FamiliaArticulo> arFamiliaArticulo = new ArrayList<>();

        String query = "SELECT * FROM `familias_articulos` where concat(`cod_familia`, `nombre_familia`) like'%" + buscar + "%'";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt(1);
                    String nombrePoc = rs.getString(2);
                    arFamiliaArticulo.add(new FamiliaArticulo(cod, nombrePoc));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arFamiliaArticulo;
    }
    
    public int codigoFamilia() {
        String query = "select max(cod_familia) from `familias_articulos`";
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
