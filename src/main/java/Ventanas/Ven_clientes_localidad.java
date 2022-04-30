package Ventanas;

/**
 *
 * @author Iván Pérez
 */
public class Ven_clientes_localidad extends javax.swing.JInternalFrame {

    public Ven_clientes_localidad() {
        initComponents();
        bloquearCodigos(false);
    }

    protected void bloquearCodigos(boolean blockeo) {
        TFCodPais.setEnabled(blockeo);
        TFProv.setEnabled(blockeo);
        TFCodigoLocal.setEnabled(blockeo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraHerramientasClientes = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        panel_Pais = new javax.swing.JPanel();
        txtCodigo1 = new javax.swing.JLabel();
        TFCodPais = new javax.swing.JTextField();
        txtNombre3 = new javax.swing.JLabel();
        TFPais = new javax.swing.JTextField();
        botonActualizar1 = new javax.swing.JButton();
        botonGuardar1 = new javax.swing.JButton();
        panel_prov = new javax.swing.JPanel();
        txtCodigo2 = new javax.swing.JLabel();
        TFProv = new javax.swing.JTextField();
        txtNombre6 = new javax.swing.JLabel();
        txtNombre7 = new javax.swing.JLabel();
        TFprov1 = new javax.swing.JTextField();
        comboPais = new javax.swing.JComboBox();
        botonActualizar2 = new javax.swing.JButton();
        botonGuardar2 = new javax.swing.JButton();
        panel_localidad = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JLabel();
        TFCodigoLocal = new javax.swing.JTextField();
        txtNombre = new javax.swing.JLabel();
        TFCiudad = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JLabel();
        comboProv = new javax.swing.JComboBox();
        comboPaisLocal = new javax.swing.JComboBox();
        botonActualizar3 = new javax.swing.JButton();
        botonGuardar3 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Localidad");
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(745, 432));

        barraHerramientasClientes.setFloatable(false);
        barraHerramientasClientes.setRollover(true);
        barraHerramientasClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonNuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/nuevo.png"))); // NOI18N
        botonNuevo.setText("Nuevo");
        botonNuevo.setFocusable(false);
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevo.setMaximumSize(new java.awt.Dimension(60, 60));
        botonNuevo.setMinimumSize(new java.awt.Dimension(60, 60));
        botonNuevo.setPreferredSize(new java.awt.Dimension(60, 60));
        botonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientasClientes.add(botonNuevo);

        botonEliminar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/eliminar.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setFocusable(false);
        botonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonEliminar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonEliminar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientasClientes.add(botonEliminar);
        barraHerramientasClientes.add(jSeparator1);

        panel_Pais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo1.setText("Código:");

        txtNombre3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre3.setText("Pais");

        botonActualizar1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonActualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/actualizar.png"))); // NOI18N
        botonActualizar1.setText("Actualizar");
        botonActualizar1.setFocusable(false);
        botonActualizar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonActualizar1.setMaximumSize(new java.awt.Dimension(60, 60));
        botonActualizar1.setMinimumSize(new java.awt.Dimension(60, 60));
        botonActualizar1.setPreferredSize(new java.awt.Dimension(60, 60));
        botonActualizar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        botonGuardar1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/guardar.png"))); // NOI18N
        botonGuardar1.setText("Guardar");
        botonGuardar1.setFocusable(false);
        botonGuardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar1.setMaximumSize(new java.awt.Dimension(60, 60));
        botonGuardar1.setMinimumSize(new java.awt.Dimension(60, 60));
        botonGuardar1.setPreferredSize(new java.awt.Dimension(60, 60));
        botonGuardar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panel_PaisLayout = new javax.swing.GroupLayout(panel_Pais);
        panel_Pais.setLayout(panel_PaisLayout);
        panel_PaisLayout.setHorizontalGroup(
            panel_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PaisLayout.createSequentialGroup()
                .addGroup(panel_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_PaisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(botonGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_PaisLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panel_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFPais, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodPais, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );
        panel_PaisLayout.setVerticalGroup(
            panel_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PaisLayout.createSequentialGroup()
                .addGroup(panel_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_PaisLayout.createSequentialGroup()
                        .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFCodPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TFPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_PaisLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        panel_prov.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Provincia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo2.setText("Código:");

        txtNombre6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre6.setText("Pais");

        txtNombre7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre7.setText("Provincia");

        comboPais.setPreferredSize(new java.awt.Dimension(32, 22));

        botonActualizar2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonActualizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/actualizar.png"))); // NOI18N
        botonActualizar2.setText("Actualizar");
        botonActualizar2.setFocusable(false);
        botonActualizar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonActualizar2.setMaximumSize(new java.awt.Dimension(60, 60));
        botonActualizar2.setMinimumSize(new java.awt.Dimension(60, 60));
        botonActualizar2.setPreferredSize(new java.awt.Dimension(60, 60));
        botonActualizar2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        botonGuardar2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonGuardar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/guardar.png"))); // NOI18N
        botonGuardar2.setText("Guardar");
        botonGuardar2.setFocusable(false);
        botonGuardar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar2.setMaximumSize(new java.awt.Dimension(60, 60));
        botonGuardar2.setMinimumSize(new java.awt.Dimension(60, 60));
        botonGuardar2.setPreferredSize(new java.awt.Dimension(60, 60));
        botonGuardar2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panel_provLayout = new javax.swing.GroupLayout(panel_prov);
        panel_prov.setLayout(panel_provLayout);
        panel_provLayout.setHorizontalGroup(
            panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_provLayout.createSequentialGroup()
                .addGroup(panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_provLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboPais, 0, 185, Short.MAX_VALUE)
                            .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFProv, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_provLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_provLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_provLayout.createSequentialGroup()
                                .addComponent(botonActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(botonGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TFprov1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );
        panel_provLayout.setVerticalGroup(
            panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_provLayout.createSequentialGroup()
                .addGroup(panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_provLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(botonGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_provLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(TFprov1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        panel_localidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Localidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo.setText("Código:");

        txtNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre.setText("Ciudad:");

        txtNombre1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre1.setText("Provincia:");

        txtNombre2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre2.setText("Pais:");

        comboProv.setPreferredSize(new java.awt.Dimension(32, 22));

        comboPaisLocal.setPreferredSize(new java.awt.Dimension(32, 22));

        botonActualizar3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonActualizar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/actualizar.png"))); // NOI18N
        botonActualizar3.setText("Actualizar");
        botonActualizar3.setFocusable(false);
        botonActualizar3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonActualizar3.setMaximumSize(new java.awt.Dimension(60, 60));
        botonActualizar3.setMinimumSize(new java.awt.Dimension(60, 60));
        botonActualizar3.setPreferredSize(new java.awt.Dimension(60, 60));
        botonActualizar3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        botonGuardar3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonGuardar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/guardar.png"))); // NOI18N
        botonGuardar3.setText("Guardar");
        botonGuardar3.setFocusable(false);
        botonGuardar3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar3.setMaximumSize(new java.awt.Dimension(60, 60));
        botonGuardar3.setMinimumSize(new java.awt.Dimension(60, 60));
        botonGuardar3.setPreferredSize(new java.awt.Dimension(60, 60));
        botonGuardar3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panel_localidadLayout = new javax.swing.GroupLayout(panel_localidad);
        panel_localidad.setLayout(panel_localidadLayout);
        panel_localidadLayout.setHorizontalGroup(
            panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_localidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_localidadLayout.createSequentialGroup()
                        .addGroup(panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TFCodigoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_localidadLayout.createSequentialGroup()
                                .addComponent(botonActualizar3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(botonGuardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TFCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addGap(15, 15, 15))
                    .addGroup(panel_localidadLayout.createSequentialGroup()
                        .addGroup(panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboProv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboPaisLocal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panel_localidadLayout.setVerticalGroup(
            panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_localidadLayout.createSequentialGroup()
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFCodigoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(TFCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(comboProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(comboPaisLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonGuardar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(panel_prov, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_localidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_localidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_prov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Pais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFCiudad;
    private javax.swing.JTextField TFCodPais;
    private javax.swing.JTextField TFCodigoLocal;
    private javax.swing.JTextField TFPais;
    private javax.swing.JTextField TFProv;
    private javax.swing.JTextField TFprov1;
    private javax.swing.JToolBar barraHerramientasClientes;
    private javax.swing.JButton botonActualizar1;
    private javax.swing.JButton botonActualizar2;
    private javax.swing.JButton botonActualizar3;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar1;
    private javax.swing.JButton botonGuardar2;
    private javax.swing.JButton botonGuardar3;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JComboBox comboPais;
    private javax.swing.JComboBox comboPaisLocal;
    private javax.swing.JComboBox comboProv;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPanel panel_Pais;
    private javax.swing.JPanel panel_localidad;
    private javax.swing.JPanel panel_prov;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtCodigo1;
    private javax.swing.JLabel txtCodigo2;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombre1;
    private javax.swing.JLabel txtNombre2;
    private javax.swing.JLabel txtNombre3;
    private javax.swing.JLabel txtNombre6;
    private javax.swing.JLabel txtNombre7;
    // End of variables declaration//GEN-END:variables
}
