package Ventanas;

/**
 * @author Iván Pérez
 */
public class V_clientes extends javax.swing.JInternalFrame {

    public V_clientes() {
        initComponents();
        bloquearBotones(false);
    }

    public void bloquearBotones(boolean bloquear) {
        botonCancelar.setEnabled(bloquear);
        botonGuardar.setEnabled(bloquear);
        botonActualizar.setEnabled(bloquear);

        txtCodigo.setEnabled(bloquear);
        TFCodigo.setEnabled(bloquear);
        txtNombre.setEnabled(bloquear);
        TFNombre.setEnabled(bloquear);
        txtApellidos.setEnabled(bloquear);
        TFApellidos.setEnabled(bloquear);
        txtTelefono.setEnabled(bloquear);
        TFTelef.setEnabled(bloquear);
        txtTelefono.setEnabled(bloquear);
        txtDirrec.setEnabled(bloquear);
        TFDir.setEnabled(bloquear);
        txtCiudad.setEnabled(bloquear);
        TFCiudad.setEnabled(bloquear);
        txtEmail.setEnabled(bloquear);
        TFEmail.setEnabled(bloquear);
        TFCp.setEnabled(bloquear);
        txtCp.setEnabled(bloquear);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraHerramientasClientes = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botonGuardar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        txtSeparacion = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        txtSeparacion1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        botonImprimir = new javax.swing.JButton();
        PANEL_detalle_cliente = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JLabel();
        TFCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JLabel();
        TFNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JLabel();
        TFApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JLabel();
        TFTelef = new javax.swing.JTextField();
        txtDirrec = new javax.swing.JLabel();
        TFDir = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JLabel();
        TFCiudad = new javax.swing.JTextField();
        txtEmail = new javax.swing.JLabel();
        TFEmail = new javax.swing.JTextField();
        TFCp = new javax.swing.JTextField();
        txtCp = new javax.swing.JLabel();
        PANEL_buscar_cliente = new javax.swing.JPanel();
        TFBuscar = new javax.swing.JTextField();
        botonBuscarClientes = new javax.swing.JButton();
        buscadorClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Clientes");
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(581, 759));

        barraHerramientasClientes.setFloatable(false);
        barraHerramientasClientes.setRollover(true);
        barraHerramientasClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonNuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/nuevo.png"))); // NOI18N
        botonNuevo.setText("Nuevo");
        botonNuevo.setFocusable(false);
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });
        barraHerramientasClientes.add(botonNuevo);

        botonCancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/cancelar.png"))); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.setFocusable(false);
        botonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        barraHerramientasClientes.add(botonCancelar);
        barraHerramientasClientes.add(jSeparator1);

        botonGuardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/guardar.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setFocusable(false);
        botonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientasClientes.add(botonGuardar);

        botonActualizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/actualizar.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setFocusable(false);
        botonActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientasClientes.add(botonActualizar);

        botonEliminar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/eliminar.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setFocusable(false);
        botonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientasClientes.add(botonEliminar);
        barraHerramientasClientes.add(txtSeparacion);
        barraHerramientasClientes.add(jSeparator2);

        txtSeparacion1.setText("                                                                ");
        barraHerramientasClientes.add(txtSeparacion1);
        barraHerramientasClientes.add(jSeparator3);

        botonImprimir.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/imprimir.png"))); // NOI18N
        botonImprimir.setText("Imprimir");
        botonImprimir.setFocusable(false);
        botonImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientasClientes.add(botonImprimir);

        PANEL_detalle_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo.setText("Código:");

        txtNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre.setText("Nombre");

        txtApellidos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtApellidos.setText("Apellidos");

        txtTelefono.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTelefono.setText("Télefono");

        txtDirrec.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtDirrec.setText("Dirección");

        txtCiudad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCiudad.setText("Ciudad");

        txtEmail.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtEmail.setText("Email");

        txtCp.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCp.setText("CP");

        javax.swing.GroupLayout PANEL_detalle_clienteLayout = new javax.swing.GroupLayout(PANEL_detalle_cliente);
        PANEL_detalle_cliente.setLayout(PANEL_detalle_clienteLayout);
        PANEL_detalle_clienteLayout.setHorizontalGroup(
            PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addComponent(TFTelef)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFEmail)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFCp)
                                    .addComponent(txtCp, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                                .addGap(5, 5, 5)
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFDir)
                                    .addComponent(txtDirrec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFNombre)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                .addGap(8, 8, 8)
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        PANEL_detalle_clienteLayout.setVerticalGroup(
            PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_detalle_clienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TFTelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDirrec, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        PANEL_buscar_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        botonBuscarClientes.setText("Mostrar Todos");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        buscadorClientes.setViewportView(tablaClientes);

        javax.swing.GroupLayout PANEL_buscar_clienteLayout = new javax.swing.GroupLayout(PANEL_buscar_cliente);
        PANEL_buscar_cliente.setLayout(PANEL_buscar_clienteLayout);
        PANEL_buscar_clienteLayout.setHorizontalGroup(
            PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_buscar_clienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscadorClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addGroup(PANEL_buscar_clienteLayout.createSequentialGroup()
                        .addComponent(TFBuscar)
                        .addGap(10, 10, 10)
                        .addComponent(botonBuscarClientes)))
                .addGap(15, 15, 15))
        );
        PANEL_buscar_clienteLayout.setVerticalGroup(
            PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_buscar_clienteLayout.createSequentialGroup()
                .addGroup(PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarClientes))
                .addGap(5, 5, 5)
                .addComponent(buscadorClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PANEL_detalle_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(PANEL_detalle_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // BOTON CANCELAR //
        bloquearBotones(false);
        botonNuevo.setEnabled(true);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // BOTON NUEVO //
        bloquearBotones(true);
        botonNuevo.setEnabled(false);
        botonActualizar.setEnabled(false);

    }//GEN-LAST:event_botonNuevoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANEL_buscar_cliente;
    private javax.swing.JPanel PANEL_detalle_cliente;
    private javax.swing.JTextField TFApellidos;
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JTextField TFCiudad;
    private javax.swing.JTextField TFCodigo;
    private javax.swing.JTextField TFCp;
    private javax.swing.JTextField TFDir;
    private javax.swing.JTextField TFEmail;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFTelef;
    private javax.swing.JToolBar barraHerramientasClientes;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscarClientes;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonImprimir;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JScrollPane buscadorClientes;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JLabel txtApellidos;
    private javax.swing.JLabel txtCiudad;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtCp;
    private javax.swing.JLabel txtDirrec;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtSeparacion;
    private javax.swing.JLabel txtSeparacion1;
    private javax.swing.JLabel txtTelefono;
    // End of variables declaration//GEN-END:variables
}
