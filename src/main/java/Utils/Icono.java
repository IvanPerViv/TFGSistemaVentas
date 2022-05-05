/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.sun.tools.javac.Main;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author Iván Pérez
 */
public class Icono {
    
    /**
     * Metodo que carga una imagen para establecerla como icono del programa.
     * @return imagen del icono del programa.
     */
    public Image getIconImage(String ruta) {
        URL imageResource = Main.class.getClassLoader().getResource(ruta);
        Image iconito = Toolkit.getDefaultToolkit().getImage(imageResource);
        return iconito;
    }
}
