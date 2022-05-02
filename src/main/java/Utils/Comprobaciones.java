package Utils;

import static Ventanas.Ven_principal.escritorio;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Iván Pérez
 */
public class Comprobaciones extends javax.swing.JFrame {

    public Comprobaciones() {

    }

    public boolean comprobacionVentanaAbierta(JInternalFrame frame) {
        JInternalFrame[] ventansActivas = escritorio.getAllFrames();
        for (int i = 0; i < ventansActivas.length; i++) {
            if (frame.getClass().isInstance(ventansActivas[i])) {
                JOptionPane.showMessageDialog(this, "La ventana '" + frame.getTitle() + "' esta en uso.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }

    public boolean comprobacionJTextField(JTextField campo) {
        boolean comprobacion = false;
        if (campo.getText().isEmpty()) {
            campo.setBorder(new LineBorder(Color.red));
            comprobacion = true;
        }
        return comprobacion;
    }
    
    public boolean comprobacionJTextField0SinPintar(JTextField campo) {
        boolean comprobacion = false;
        if (campo.getText().isEmpty()) {
            comprobacion = true;
        }
        return comprobacion;
    }

    public void ValidarNumeros(JTextField campo) {
        Pattern patron = Pattern.compile("[0-9]*");
        Matcher match = patron.matcher(campo.getText());

        if (!match.matches()) {
            JOptionPane.showMessageDialog(this, "Debe contener un valor númerico.", "Información", JOptionPane.INFORMATION_MESSAGE);
            campo.setText("");
            campo.requestFocus();
        }
    }

    public void ValidarCodigoPostal(JTextField campo) {
        Pattern patronCVV = Pattern.compile("[0-9]{5}");
        Matcher matchCVV = patronCVV.matcher(campo.getText());

        if (!matchCVV.matches()) {
            JOptionPane.showMessageDialog(this, "Debe contener un valor númerico no superior a cinco numeros.", "Información", JOptionPane.INFORMATION_MESSAGE);
            campo.setText("");
            campo.requestFocus();
        }
    }
}
