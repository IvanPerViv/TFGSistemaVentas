package Ventanas;

import Utils.Comprobaciones;
import javax.swing.*;

/**
 * @author Iván Pérez
 */
public class Ven_principal extends javax.swing.JFrame {

    protected Comprobaciones objComprobaciones = new Comprobaciones();

    public Ven_principal(String rolUsuario, String nomUser) {
        initComponents();
        comprobacionUsuario(rolUsuario);
        nombreUsuario.setText(nomUser);
        rol_usuario.setText(rolUsuario);
        setLocationRelativeTo(null);
        //setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
    }

    public void comprobacionUsuario(String usuario) {
        if (!usuario.equals("Administrador")) {
            i_CrearUser.disable();
            i_CrearUser.setVisible(false);
        }
    }

    public void mostarVentana(JInternalFrame frame) {
        if (objComprobaciones.comprobacionVentanaAbierta(frame) != true) {
            escritorio.add(frame);
            frame.show();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rol_usuario = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        barraSupHerra = new javax.swing.JMenuBar();
        BH_usuarios = new javax.swing.JMenu();
        i_CrearUser = new javax.swing.JMenuItem();
        i_cerrarSesion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        i_salir = new javax.swing.JMenuItem();
        BH_clientes = new javax.swing.JMenu();
        BH_ciudades = new javax.swing.JMenu();
        i_pais = new javax.swing.JMenuItem();
        i_provincia = new javax.swing.JMenuItem();
        i_ciudad = new javax.swing.JMenuItem();
        BH_articulos = new javax.swing.JMenu();
        BH_consultas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        BH_ventas = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        BH_ayuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        escritorio.setBackground(new java.awt.Color(40, 43, 53));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/fondito.png"))); // NOI18N
        escritorio.add(jLabel3);
        jLabel3.setBounds(410, 260, 370, 130);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Privilegios:");

        rol_usuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rol_usuario.setText("<rol_usuario>");

        nombreUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nombreUsuario.setText("<Nombre_usuario>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(rol_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(504, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rol_usuario)
                        .addComponent(jLabel2)
                        .addComponent(nombreUsuario)))
                .addGap(10, 10, 10))
        );

        barraSupHerra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraSupHerra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        barraSupHerra.setPreferredSize(new java.awt.Dimension(100, 60));

        BH_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/inicio.png"))); // NOI18N
        BH_usuarios.setText("Inicio");
        BH_usuarios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BH_usuarios.setMinimumSize(new java.awt.Dimension(130, 50));
        BH_usuarios.setPreferredSize(new java.awt.Dimension(130, 50));

        i_CrearUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        i_CrearUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        i_CrearUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/CrearUser.png"))); // NOI18N
        i_CrearUser.setText("Crear Usuario");
        i_CrearUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        i_CrearUser.setPreferredSize(new java.awt.Dimension(250, 50));
        i_CrearUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_CrearUserActionPerformed(evt);
            }
        });
        BH_usuarios.add(i_CrearUser);

        i_cerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        i_cerrarSesion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        i_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/CerrarSesion.png"))); // NOI18N
        i_cerrarSesion.setText("Cerrar Sesion");
        i_cerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        i_cerrarSesion.setPreferredSize(new java.awt.Dimension(250, 50));
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
        i_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        i_salir.setPreferredSize(new java.awt.Dimension(250, 50));
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

        BH_ciudades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/Ciudades.png"))); // NOI18N
        BH_ciudades.setText("Ciudades");
        BH_ciudades.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BH_ciudades.setPreferredSize(new java.awt.Dimension(150, 50));

        i_pais.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        i_pais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/Pais.png"))); // NOI18N
        i_pais.setText("Pais");
        i_pais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        i_pais.setPreferredSize(new java.awt.Dimension(250, 50));
        i_pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_paisActionPerformed(evt);
            }
        });
        BH_ciudades.add(i_pais);

        i_provincia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        i_provincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/prov.png"))); // NOI18N
        i_provincia.setText("Provincia");
        i_provincia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        i_provincia.setPreferredSize(new java.awt.Dimension(250, 50));
        i_provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_provinciaActionPerformed(evt);
            }
        });
        BH_ciudades.add(i_provincia);

        i_ciudad.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        i_ciudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/ciudad.png"))); // NOI18N
        i_ciudad.setText("Ciudad");
        i_ciudad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        i_ciudad.setPreferredSize(new java.awt.Dimension(250, 50));
        i_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_ciudadActionPerformed(evt);
            }
        });
        BH_ciudades.add(i_ciudad);

        barraSupHerra.add(BH_ciudades);

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

        BH_consultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/Pedidos.png"))); // NOI18N
        BH_consultas.setText("Pedidos");
        BH_consultas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BH_consultas.setMinimumSize(new java.awt.Dimension(150, 50));
        BH_consultas.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/Crear.png"))); // NOI18N
        jMenuItem1.setText("Crear");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.setPreferredSize(new java.awt.Dimension(250, 50));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        BH_consultas.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/Listar.png"))); // NOI18N
        jMenuItem2.setText("Listado");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.setPreferredSize(new java.awt.Dimension(250, 50));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        BH_consultas.add(jMenuItem2);

        barraSupHerra.add(BH_consultas);

        BH_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/ventas.png"))); // NOI18N
        BH_ventas.setText("Ventas");
        BH_ventas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BH_ventas.setMinimumSize(new java.awt.Dimension(150, 50));
        BH_ventas.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/Albaran.png"))); // NOI18N
        jMenuItem4.setText("Albaranes");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem4.setPreferredSize(new java.awt.Dimension(250, 50));
        BH_ventas.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_principal/Factura2.png"))); // NOI18N
        jMenuItem5.setText("Facturas");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.setPreferredSize(new java.awt.Dimension(250, 50));
        BH_ventas.add(jMenuItem5);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void i_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_cerrarSesionActionPerformed
        dispose();
        new Ven_login().setVisible(true);
    }//GEN-LAST:event_i_cerrarSesionActionPerformed

    private void i_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_i_salirActionPerformed

    private void BH_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BH_clientesMouseClicked
        Ven_clientes vClientes = new Ven_clientes();
        mostarVentana(vClientes);
    }//GEN-LAST:event_BH_clientesMouseClicked

    private void BH_articulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BH_articulosMouseClicked
        Ven_articulos vArticulos = new Ven_articulos();
        mostarVentana(vArticulos);
    }//GEN-LAST:event_BH_articulosMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Ven_pedidos vPedidos = new Ven_pedidos();
        mostarVentana(vPedidos);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Ven_tabla_pedidos_listados vListadoPedidos = new Ven_tabla_pedidos_listados();
        mostarVentana(vListadoPedidos);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void i_provinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_provinciaActionPerformed
        Ven_clientes_prov vProv = new Ven_clientes_prov();
        mostarVentana(vProv);
    }//GEN-LAST:event_i_provinciaActionPerformed

    private void i_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_ciudadActionPerformed
        Ven_clientes_localidad vCiudad = new Ven_clientes_localidad();
        mostarVentana(vCiudad);
    }//GEN-LAST:event_i_ciudadActionPerformed

    private void i_paisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_paisActionPerformed
        Ven_clientes_pais vPais = new Ven_clientes_pais();
        mostarVentana(vPais);
    }//GEN-LAST:event_i_paisActionPerformed

    private void i_CrearUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_CrearUserActionPerformed
        Ven_crear_usuario vCrearUser = new Ven_crear_usuario();
        mostarVentana(vCrearUser);
    }//GEN-LAST:event_i_CrearUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu BH_articulos;
    private javax.swing.JMenu BH_ayuda;
    private javax.swing.JMenu BH_ciudades;
    private javax.swing.JMenu BH_clientes;
    private javax.swing.JMenu BH_consultas;
    private javax.swing.JMenu BH_usuarios;
    private javax.swing.JMenu BH_ventas;
    private javax.swing.JMenuBar barraSupHerra;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem i_CrearUser;
    private javax.swing.JMenuItem i_cerrarSesion;
    private javax.swing.JMenuItem i_ciudad;
    private javax.swing.JMenuItem i_pais;
    private javax.swing.JMenuItem i_provincia;
    private javax.swing.JMenuItem i_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JLabel rol_usuario;
    // End of variables declaration//GEN-END:variables
}
