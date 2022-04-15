package Ventanas;

import javax.swing.*;

/**
 * @author Iván Pérez
 */
public class V_principal extends javax.swing.JFrame {

    public V_principal(String rolUsuario, String nombreUsuario) {
        initComponents();
        comprobacionUsuario(rolUsuario);
        jLabel1.setText(nombreUsuario);
        //setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
    }

    public void comprobacionUsuario(String a) {
        if (!a.equals("Administrador")) {
            i_CrearUsuario.disable();
            i_CrearUsuario.setVisible(false);
        }
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

    public void mostarVentana(JInternalFrame frame) {
        if (comprobacionVentanaAbierta(frame) != true) {
            escritorio.add(frame);
            frame.show();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        FondoLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        barraSupHerra = new javax.swing.JMenuBar();
        BH_usuarios = new javax.swing.JMenu();
        i_CrearUsuario = new javax.swing.JMenuItem();
        i_cerrarSesion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        i_salir = new javax.swing.JMenuItem();
        BH_clientes = new javax.swing.JMenu();
        BH_articulos = new javax.swing.JMenu();
        BH_ventas = new javax.swing.JMenu();
        BH_ayuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setMinimumSize(null);
        setResizable(false);

        escritorio.setBackground(new java.awt.Color(102, 153, 255));

        FondoLogo.setBackground(new java.awt.Color(204, 204, 204));
        FondoLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/fondosisitema.jpg"))); // NOI18N
        FondoLogo.setMaximumSize(null);
        FondoLogo.setMinimumSize(null);
        FondoLogo.setPreferredSize(null);
        escritorio.add(FondoLogo);
        FondoLogo.setBounds(460, 160, 310, 260);

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel1.setText("<Nombre Usuario>");
        escritorio.add(jLabel1);
        jLabel1.setBounds(10, 10, 176, 22);

        barraSupHerra.setBackground(new java.awt.Color(255, 255, 255));
        barraSupHerra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraSupHerra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        barraSupHerra.setPreferredSize(new java.awt.Dimension(100, 60));

        BH_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/inicio.png"))); // NOI18N
        BH_usuarios.setText("Inicio");
        BH_usuarios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BH_usuarios.setMinimumSize(new java.awt.Dimension(130, 50));
        BH_usuarios.setPreferredSize(new java.awt.Dimension(130, 50));

        i_CrearUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        i_CrearUsuario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        i_CrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/CrearUser.png"))); // NOI18N
        i_CrearUsuario.setText("Crear Usuario");
        i_CrearUsuario.setPreferredSize(new java.awt.Dimension(230, 40));
        i_CrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_CrearUsuarioActionPerformed(evt);
            }
        });
        BH_usuarios.add(i_CrearUsuario);

        i_cerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        i_cerrarSesion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        i_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/CerrarSesion.png"))); // NOI18N
        i_cerrarSesion.setText("Cerrar Sesion");
        i_cerrarSesion.setPreferredSize(new java.awt.Dimension(230, 40));
        i_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_cerrarSesionActionPerformed(evt);
            }
        });
        BH_usuarios.add(i_cerrarSesion);
        BH_usuarios.add(jSeparator1);

        i_salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        i_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/salir.png"))); // NOI18N
        i_salir.setText("Salir");
        i_salir.setPreferredSize(new java.awt.Dimension(230, 40));
        i_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_salirActionPerformed(evt);
            }
        });
        BH_usuarios.add(i_salir);

        barraSupHerra.add(BH_usuarios);

        BH_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/clientes.png"))); // NOI18N
        BH_clientes.setText("Clientes");
        BH_clientes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BH_clientes.setMinimumSize(new java.awt.Dimension(150, 50));
        BH_clientes.setPreferredSize(new java.awt.Dimension(150, 50));
        BH_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BH_clientesMouseClicked(evt);
            }
        });
        barraSupHerra.add(BH_clientes);

        BH_articulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/articulos.png"))); // NOI18N
        BH_articulos.setText("Articulos");
        BH_articulos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BH_articulos.setPreferredSize(new java.awt.Dimension(150, 50));
        BH_articulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BH_articulosMouseClicked(evt);
            }
        });
        barraSupHerra.add(BH_articulos);

        BH_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/ventas.png"))); // NOI18N
        BH_ventas.setText("Ventas");
        BH_ventas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BH_ventas.setMinimumSize(new java.awt.Dimension(150, 50));
        BH_ventas.setPreferredSize(new java.awt.Dimension(150, 50));
        BH_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BH_ventasMouseClicked(evt);
            }
        });
        barraSupHerra.add(BH_ventas);

        BH_ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/ayuda.png"))); // NOI18N
        BH_ayuda.setText("Ayuda");
        BH_ayuda.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BH_ayuda.setMinimumSize(new java.awt.Dimension(150, 50));
        BH_ayuda.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem3.setText("jMenuItem3");
        BH_ayuda.add(jMenuItem3);

        barraSupHerra.add(BH_ayuda);

        setJMenuBar(barraSupHerra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1219, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void i_CrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_CrearUsuarioActionPerformed
        V_crear_usuario vCrearUser = new V_crear_usuario();
        mostarVentana(vCrearUser);
    }//GEN-LAST:event_i_CrearUsuarioActionPerformed

    private void i_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_cerrarSesionActionPerformed
        dispose();
        new V_login().setVisible(true);
    }//GEN-LAST:event_i_cerrarSesionActionPerformed

    private void i_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_i_salirActionPerformed

    private void BH_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BH_clientesMouseClicked
        V_clientes vClientes = new V_clientes();
        mostarVentana(vClientes);
    }//GEN-LAST:event_BH_clientesMouseClicked

    private void BH_articulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BH_articulosMouseClicked
        V_articulos vArticulos = new V_articulos();
        mostarVentana(vArticulos);
    }//GEN-LAST:event_BH_articulosMouseClicked

    private void BH_ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BH_ventasMouseClicked
        V_ventas vVentas = new V_ventas();
        mostarVentana(vVentas);
    }//GEN-LAST:event_BH_ventasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu BH_articulos;
    private javax.swing.JMenu BH_ayuda;
    private javax.swing.JMenu BH_clientes;
    private javax.swing.JMenu BH_usuarios;
    private javax.swing.JMenu BH_ventas;
    private javax.swing.JLabel FondoLogo;
    private javax.swing.JMenuBar barraSupHerra;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem i_CrearUsuario;
    private javax.swing.JMenuItem i_cerrarSesion;
    private javax.swing.JMenuItem i_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
