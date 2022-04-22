package Conexiones;

import Modelos.Articulos;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * @author Iván Pérez
 */
public class Con_articulos {

    protected Conexion objConexion;
    protected Connection con;

    public Con_articulos() {
        objConexion = new Conexion();
        con = objConexion.con;
    }

    public boolean ingresoDeArticulos(int cod_articulo, String nombre_producto, double precio_compra, int iva, int stock) {
        String query = "INSERT INTO `articulos`(`cod_articulo`, `nombre_producto`, `precio_compra`, `IVA`,`stock`) VALUES (?,?,?,?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, cod_articulo);
            pst.setString(2, nombre_producto);
            pst.setDouble(3, precio_compra);
             pst.setDouble(4, iva);
            pst.setInt(5, stock);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public void eliminarRegistroArticulo(int cod_art) {
        String query = "DELETE FROM `articulos`  WHERE cod_articulo= '" + cod_art + "' ";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
    }
    
    public boolean actualizarArticulos(int cod_art, String nomProc, String precioCompra, String iva, String stock) {
        int comprobacion = 0;
        String query = "UPDATE `articulos` set cod_articulo ='" + cod_art
                + "',nombre_producto='" + nomProc
                + "',precio_compra='" + precioCompra
                + "',IVA='" + iva 
                + "',stock='" + stock 
                + "' WHERE cod_articulo='" + cod_art + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList mostrarArticulosYBusqueda(String buscar) {
        ArrayList<Articulos> art = new ArrayList<>();

        String query = "SELECT * FROM `articulos` where concat(`cod_articulo`, `nombre_producto`, `precio_compra`, `IVA`,`stock`) like'%" + buscar + "%'";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt(1);
                    String nombrePoc = rs.getString(2);
                    double precioCompra = rs.getDouble(3);
                    int iva = rs.getInt(5);
                    int stock = rs.getInt(5);
                    art.add(new Articulos(cod, nombrePoc, precioCompra,iva, stock));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return art;
    }
    
    public int codigoArticulos() {
        String query = "select max(cod_articulo) from `articulos`";
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
