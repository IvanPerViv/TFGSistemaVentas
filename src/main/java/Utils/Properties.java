package Utils;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Iván Pérez
 */
public class Properties {

    public final String RUTAPROPERTIES = "./src/main/java/Main/config.properties";
    public final String URL = cargaProperties("url");
    public final String BBDD = cargaProperties("bbddname");
    public final String USER = cargaProperties("username");
    public final String PASS = cargaProperties("pass");

    protected String cargaProperties(String valueProperties) {
        java.util.Properties prop = new java.util.Properties();
        String valor = "";
        try (FileInputStream input = new FileInputStream(RUTAPROPERTIES)) {
            prop.load(input);
            valor = prop.getProperty(valueProperties);

        } catch (IOException ex) {
            System.err.println("No se pudo abrir el fichero de properties");
        }
        return valor;
    }
}
