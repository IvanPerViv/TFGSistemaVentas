package Conexiones;

import Modelos.Localidad;
import Modelos.Pais;
import Modelos.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Con_localidad_prov_pais {

    protected Conexion objConexion;
    protected Connection con;

    public Con_localidad_prov_pais() {
        objConexion = new Conexion();
        con = objConexion.conexion();
    }

    // PAIS //
    public boolean ingresoPais(int codPais, String nombrePais) {
        String query = "INSERT INTO `pais`(`cod_pais`, `nombre_pais`) VALUES (?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, codPais);
            pst.setString(2, nombrePais);
            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public void eliminarPais(int codPais) {
        String query = "DELETE FROM `pais`  WHERE cod_pais= '" + codPais + "' ";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
    }

    public boolean actualizarPais(int codPais, String nomProc) {
        int comprobacion = 0;
        String query = "UPDATE `pais` set cod_pais ='" + codPais
                + "',nombre_pais ='" + nomProc
                + "' WHERE cod_pais ='" + codPais + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList MostrarPais(String buscar) {
        ArrayList<Pais> arPais = new ArrayList<>();

        String query = "SELECT * FROM `pais` where concat(`cod_pais`, `nombre_pais`) like'%" + buscar + "%'";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt(1);
                    String nombrePoc = rs.getString(2);
                    arPais.add(new Pais(cod, nombrePoc));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arPais;
    }

    public int codigoPais() {
        String query = "select max(cod_pais) from `pais`";
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

    // PROVINCIA //
    public boolean ingresoProv(int codProv, String nombreProv, int codPais) {
        String query = "INSERT INTO `provincia`(`cod_provincia`, `nombre_prov`, `cod_pais`) VALUES (?,?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, codProv);
            pst.setString(2, nombreProv);
            pst.setInt(3, codPais);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public void eliminarProv(int codProv) {
        String query = "DELETE FROM `provincia`  WHERE cod_provincia= '" + codProv + "' ";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
    }

    public boolean actualizarProv(int codProv, String nombreProv) {
        int comprobacion = 0;
        String query = "UPDATE `provincia` set cod_provincia ='" + codProv
                + "',nombre_prov ='" + nombreProv
                + "' WHERE cod_provincia ='" + codProv + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList MostrarProv(String buscar) {
        ArrayList<Provincia> arProvincia = new ArrayList<>();

        String query = "SELECT * FROM `provincia` where concat(`cod_provincia`, `nombre_prov`, `cod_pais`) like'%" + buscar + "%'";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt(1);
                    String nombrePoc = rs.getString(2);
                    int codPais = rs.getInt(3);
                    arProvincia.add(new Provincia(cod, nombrePoc, codPais));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arProvincia;
    }

    public int codigoProv() {
        String query = "select max(cod_provincia) from `provincia`";
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

    // LOCALIDAD //
    public boolean ingresoLocalidad(int codLocalidad, String nombreCiudad, int codProvincia) {
        String query = "INSERT INTO `localidades`(`cod_localidad`, `nombre_ciudad`, `cod_provincia`) VALUES (?,?,?)";
        int comprobacion = 0;

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, codLocalidad);
            pst.setString(2, nombreCiudad);
            pst.setInt(3, codProvincia);

            comprobacion = pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public void eliminarLocalidad(int codLocal) {
        String query = "DELETE FROM `localidades`  WHERE cod_localidad= '" + codLocal + "' ";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
    }

    public boolean actualizarLocalidad(int codLocalidad, String nombreCiudad) {
        int comprobacion = 0;
        String query = "UPDATE `localidades` set cod_localidad ='" + codLocalidad
                + "',nombre_ciudad ='" + nombreCiudad
                + "' WHERE cod_localidad ='" + codLocalidad + "'";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return comprobacion > 0;
    }

    public ArrayList MostrarLocalidad(String buscar) {
        ArrayList<Localidad> arLocalidad = new ArrayList<>();

        String query = "SELECT * FROM `localidades` where concat(`cod_localidad`, `nombre_ciudad`, `cod_provincia`) like'%" + buscar + "%'";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt(1);
                    String nombrePoc = rs.getString(2);
                    int codProv = rs.getInt(3);
                    arLocalidad.add(new Localidad(cod, nombrePoc, codProv));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arLocalidad;
    }

    public int codigoLocalidad() {
        String query = "select max(cod_localidad) from `localidades`";
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

    public String buscarProvinciaPorCodigo(int buscar) {
        String query = "SELECT nombre_prov FROM `provincia` WHERE cod_provincia ='" + buscar + "'";
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

    //CONSULTAS
    
    public int consultarLocalidad (String buscar) {
        String query = "SELECT cod_localidad FROM `localidades` WHERE nombre_ciudad like'" + buscar + "'";
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
    
    public String consultarLocalidadNombre (int buscar) {
        String query = "SELECT nombre_ciudad FROM `localidades` WHERE cod_localidad ='" + buscar + "'";
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
    
    
    public ArrayList consultarPais() {
        ArrayList<Pais> arPais = new ArrayList<>();
        String query = "SELECT * FROM `pais`";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt(1);
                    String nombre = rs.getString(2);
                    arPais.add(new Pais(cod, nombre));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arPais;
    }

    public int consultarProvincia(String buscar) {
        String query = "SELECT cod_provincia FROM `provincia` WHERE nombre_prov like'" + buscar + "'";
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

    public ArrayList consultarProvincia() {
        ArrayList<Provincia> arProv = new ArrayList<>();
        String query = "SELECT * FROM `provincia`";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt(1);
                    String nombre = rs.getString(2);
                    int codPais = rs.getInt(3);
                    arProv.add(new Provincia(cod, nombre, codPais));
                }
            }
        } catch (SQLException ex) {
            System.err.println("¡Error al ejecutar la consulta!" + ex.toString());
        }
        return arProv;
    }

    //SELECT nombre_prov FROM `provincia` JOIN pais on pais.cod_pais = provincia.cod_pais WHERE provincia.cod_pais = 1;
    public String buscarPaisPorCodigo(int buscar) {
        String query = "SELECT nombre_pais FROM `pais` WHERE cod_pais ='" + buscar + "'";
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

    //SELECT pais.cod_pais FROM `pais` JOIN provincia on pais.cod_pais = provincia.cod_pais WHERE pais.nombre_pais like 'PORTUGAL'
    public int buscarNombrePorCodigo(String buscar) {
        String query = "SELECT pais.cod_pais from pais WHERE nombre_pais like'" + buscar + "'";
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
