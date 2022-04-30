package Utils;

import static Ventanas.Ven_principal.escritorio;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
                JOptionPane.showMessageDialog(this, "La ventana esta en uso.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }

    public int comprobacionJTextField(JTextField campo) {
        int comprobacion = 1;
        if (campo.getText().trim().equals("")) {
            comprobacion = 0;
        }
        return comprobacion;
    }
}
