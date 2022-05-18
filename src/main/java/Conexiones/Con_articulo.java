package Conexiones;

import Modelos.Articulo;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Iván Pérez
 */
public class Con_articulo {

    protected Conexion objConexion;
    protected Connection con;

    public Con_articulo() {
        objConexion = new Conexion();
        con = objConexion.conexion();
    }

    public boolean ingresoDeArticulos(int codArticulo, String nombreProducto, int familia, double precioCompra, double iva, int stock) {
        String query = "INSERT INTO `articulos`(`cod_articulo`, `nombre_producto`, `familia`, `precio_compra`, `IVA`,`stock`) VALUES (?,?,?,?,?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, codArticulo);
            pst.setString(2, nombreProducto);
            pst.setInt(3, familia);
            pst.setDouble(4, precioCompra);
            pst.setDouble(5, iva);
            pst.setInt(6, stock);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public void eliminarRegistroArticulo(int codArticulo) {
        String query = "DELETE FROM `articulos`  WHERE cod_articulo= '" + codArticulo + "' ";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
    }

    public boolean actualizarArticulos(int codArticulo, String nomProc, int familia, double precioCompra, double iva, String stock) {
        int comprobacion = 0;
        String query = "UPDATE `articulos` set cod_articulo ='" + codArticulo
                + "',nombre_producto ='" + nomProc
                + "',familia ='" + familia
                + "',precio_compra ='" + precioCompra
                + "',IVA ='" + iva
                + "',stock ='" + stock
                + "' WHERE cod_articulo ='" + codArticulo + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList mostrarArticulosYBusqueda(String buscar) {
        ArrayList<Articulo> arArticulo = new ArrayList<>();

        String query = "SELECT * FROM `articulos` where concat(`cod_articulo`, `nombre_producto`, `familia`, `precio_compra`, `IVA`,`stock`) like'%" + buscar + "%'";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt(1);
                    String nombrePoc = rs.getString(2);
                    int familia = rs.getInt(3);
                    double precioCompra = rs.getDouble(4);
                    double iva = rs.getDouble(5);
                    int stock = rs.getInt(6);
                    arArticulo.add(new Articulo(cod, nombrePoc, familia, precioCompra, iva, stock));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arArticulo;
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
    
    public int mostrarCodigoArticulo(String buscar) {
        String query = "SELECT cod_articulo FROM `articulos` WHERE nombre_producto LIKE '" + buscar+ "'";
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

}
