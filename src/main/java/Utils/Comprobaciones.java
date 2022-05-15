package Utils;

import static Ventanas.Ven_principal.escritorio;
import java.awt.Color;
import java.awt.event.KeyEvent;
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

    public double conversor(String valor) {
        String precioArticuloConvertido = valor.replaceAll(",", ".");
        double precioArticuloFinal = Double.valueOf(precioArticuloConvertido);
        return precioArticuloFinal;
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

    public boolean comprobacionJTextFieldSinPintar(JTextField campo) {
        boolean comprobacion = false;
        if (campo.getText().isEmpty()) {
            comprobacion = true;
        }
        return comprobacion;
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

    public int verificacionCodigoPedido(String datoEvaluar, JTable dtm) {
        int comprobacion = 0;
        try {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String nombreTabla = dtm.getValueAt(i, 1).toString();
                if (datoEvaluar.equals(nombreTabla)) {
                    comprobacion = 1;
                }
            }
        } catch (Exception ex) {
        }
        return comprobacion;
    }

    public boolean ValidarCamposNumeros(JTextField campo) {
        boolean comprobacion = false;
        if (campo.getText().equals("0.0")) {
            comprobacion = true;
        }
        return comprobacion;
    }

    public void comprobacionNumeroDecimal(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if ((caracter < '0' || caracter > '9') && (caracter != '.') && (caracter != ',')) {
            evt.consume();
        }
    }
    
    public void comprobacionNumeroEntero(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (caracter < '0' || caracter > '9') {
            evt.consume();
        }
    }
}
