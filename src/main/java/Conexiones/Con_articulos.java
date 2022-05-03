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

    public boolean ingresoDeArticulos(int cod_articulo, String nombre_producto, int familia, double precio_compra, int iva, int stock) {
        String query = "INSERT INTO `articulos`(`cod_articulo`, `nombre_producto`, `familia`, `precio_compra`, `IVA`,`stock`) VALUES (?,?,?,?,?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, cod_articulo);
            pst.setString(2, nombre_producto);
            pst.setInt(3, familia);
            pst.setDouble(4, precio_compra);
            pst.setDouble(5, iva);
            pst.setInt(6, stock);

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

    public boolean actualizarArticulos(int cod_art, String nomProc, int familia, double precioCompra, String iva, String stock) {
        int comprobacion = 0;
        String query = "UPDATE `articulos` set cod_articulo ='" + cod_art
                + "',nombre_producto ='" + nomProc
                + "',familia ='" + familia
                + "',precio_compra ='" + precioCompra
                + "',IVA ='" + iva
                + "',stock ='" + stock
                + "' WHERE cod_articulo ='" + cod_art + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList mostrarArticulosYBusqueda(String buscar) {
        ArrayList<Articulos> art = new ArrayList<>();

        String query = "SELECT * FROM `articulos` where concat(`cod_articulo`, `nombre_producto`, `familia`, `precio_compra`, `IVA`,`stock`) like'%" + buscar + "%'";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt(1);
                    String nombrePoc = rs.getString(2);
                    int familia = rs.getInt(3);
                    double precioCompra = rs.getDouble(4);
                    int iva = rs.getInt(5);
                    int stock = rs.getInt(6);
                    art.add(new Articulos(cod, nombrePoc, familia, precioCompra, iva, stock));
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

    //SELECT nombre_familia FROM `familias_articulos` INNER JOIN articulos on articulos.cod_articulo = familias_articulos.cod_familia where familias_articulos.cod_familia = 1;
    public String mostrarFamiliaArticulos(int buscar) {
        String query = "SELECT nombre_familia FROM `familias_articulos` JOIN articulos on articulos.familia = familias_articulos.cod_familia where familias_articulos.cod_familia ='" + buscar + "'";
        String resultado = "";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    resultado = rs.getString(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return resultado;
    }

    public int mostrarNombreFamilia(String buscar) {
        String query = "SELECT cod_familia FROM `familias_articulos` WHERE nombre_familia LIKE '" + buscar + "'";
        int resultado = 0;
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    resultado = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return resultado;
    }

    public String mostrarNombreArticulo(int buscar) {
        String query = "SELECT nombre_producto FROM `articulos` WHERE cod_articulo =" + buscar;
        String resultado = "";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    resultado = rs.getString(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return resultado;
    }

    public boolean actualizarStock(int cantidad, int codigoArt) {
        String query = "UPDATE articulos SET stock = stock - ? WHERE cod_articulo = ? ";
        int comprobacion = 0;
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, cantidad);
            pst.setInt(2, codigoArt);
            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;

    }

    //DEVOLVER EL NUMERO DE STOCK POR ARTICULO
    public int mostrarStockArticulo(int codPedido) {
        String query = "SELECT stock FROM `articulos` WHERE cod_articulo=" + codPedido;
        int resultado = 0;
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    resultado = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return resultado;
    }

}
