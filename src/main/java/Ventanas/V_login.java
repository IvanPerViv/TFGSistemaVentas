package Ventanas;

import ModeloBD.Conexiones;
import ModeloBD.Usuarios;
import com.sun.tools.javac.Main;
import java.awt.*;
import java.net.URL;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.UIManager;

/**
 * @author Iván Pérez
 */
public class V_login extends javax.swing.JFrame {

    protected Image imagenIconito;

    public V_login() {
        initComponents();
        //imagenIconito = getIconImage();
        setLocationRelativeTo(null);
    }

    /**
     * Metodo que carga una imagen para establecerla como icono del programa.
     * @return imagen del icono del programa.
     */
    @Override
    public Image getIconImage() {
        URL imageResource = Main.class.getClassLoader().getResource("VI_login/iconito.png");
        Image iconito = Toolkit.getDefaultToolkit().getImage(imageResource);
        return iconito;
    }

    public void tema() {
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
            //UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(V_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnel_conexion = new javax.swing.JPanel();
        usuarioText = new javax.swing.JTextField();
        passText = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BotonLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Pnel_conexion.setBackground(new java.awt.Color(255, 255, 255));

        usuarioText.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        usuarioText.setForeground(new java.awt.Color(153, 153, 153));
        usuarioText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        passText.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        passText.setForeground(new java.awt.Color(153, 153, 153));
        passText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setBackground(new java.awt.Color(255, 204, 51));
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));

        jLabel2.setBackground(new java.awt.Color(255, 204, 51));
        jLabel2.setForeground(new java.awt.Color(255, 204, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Iniciar Sesión");

        BotonLogin.setText("INGRESAR");
        BotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLoginActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 22)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Contraseña");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 22)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Usuario");

        javax.swing.GroupLayout Pnel_conexionLayout = new javax.swing.GroupLayout(Pnel_conexion);
        Pnel_conexion.setLayout(Pnel_conexionLayout);
        Pnel_conexionLayout.setHorizontalGroup(
            Pnel_conexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnel_conexionLayout.createSequentialGroup()
                .addGroup(Pnel_conexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnel_conexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(Pnel_conexionLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Pnel_conexionLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(Pnel_conexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnel_conexionLayout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnel_conexionLayout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Pnel_conexionLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(BotonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        Pnel_conexionLayout.setVerticalGroup(
            Pnel_conexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnel_conexionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnel_conexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnel_conexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(BotonLogin)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Pnel_conexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnel_conexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLoginActionPerformed
        String nombre = usuarioText.getText();
        String pass = passText.getText();

//String itemSeleecionado = (String) comboUser.getSelectedItem();
//        if (usuario.equals("ivan") && itemSeleecionado.equals("Administrador")) {
//            new V_principal(itemSeleecionado, usuario).setVisible(true);
//        }
//
//        if (usuario.equals("ivan") && itemSeleecionado.equals("Empleado")) {
//            new V_principal(itemSeleecionado, usuario).setVisible(true);
//        }
        Conexiones objConexiones = new Conexiones();
        Usuarios objUsuarios = objConexiones.recuperarDatosUsuarios(nombre, pass);
        if (!Objects.isNull(objUsuarios)) {
            if (nombre.equals(objUsuarios.getNombre()) && pass.equals(objUsuarios.getContraseña())) {
                new V_principal(objUsuarios.getRol_trabajador(), nombre).setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Usuario incorrecto.", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Creedenciales incorrectas.", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_BotonLoginActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                V_login app = new V_login();
                app.tema();
                app.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonLogin;
    private javax.swing.JPanel Pnel_conexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField passText;
    private javax.swing.JTextField usuarioText;
    // End of variables declaration//GEN-END:variables
}
