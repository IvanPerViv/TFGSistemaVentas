package Ventanas;

import Conexiones.Con_localidad_prov_pais;
import Modelos.Pais;
import Modelos.Provincia;
import Utils.Comprobaciones;
import Utils.generarCodigos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iván Pérez
 */
public class Ven_clientes_prov extends javax.swing.JInternalFrame {

    protected Con_localidad_prov_pais objetoProv = new Con_localidad_prov_pais();
    protected generarCodigos objGenCod = new generarCodigos();
    protected final Comprobaciones objComprobaciones = new Comprobaciones();
    protected DefaultTableModel datosPais;

    public Ven_clientes_prov() {
        initComponents();
        cargarDatosProvincia("");
        TFProv.setEnabled(false);
        bloquear(false);
    }

    protected void bloquear(boolean blockeo) {
        botonEliminar.setEnabled(blockeo);
        botonActualizar.setEnabled(blockeo);
        botonGuardar.setEnabled(blockeo);

        TFprov.setEnabled(blockeo);
        comboPais.setEnabled(blockeo);
    }

    protected void limpiarDatos() {
        TFprov.setText("");
    }

    protected void generarCodigoProvincia() {
        int codProv = objetoProv.codigoProv();
        if (codProv != 0) {
            int numero = objGenCod.generarCod(codProv);
            TFProv.setText(String.valueOf(numero));
        } else {
            TFProv.setText("1");
        }
    }

    protected void cargarDatosProvincia(String buscar) {
        String[] nombreTablas = {"Cod", "Provincia", "Pais"}; //Cargamos en un array el nombre que tendran nuestras columnas.
        datosPais = new DefaultTableModel(null, nombreTablas);
        tablaProv.setModel(datosPais);

        Object[] fila = new Object[nombreTablas.length];

        ArrayList<Provincia> arProv = new ArrayList<Provincia>();
        arProv = objetoProv.MostrarProv(buscar);

        for (int i = 0; i < arProv.size(); i++) {
            fila[0] = arProv.get(i).getCodProv();
            fila[1] = arProv.get(i).getNombreProvincia();
            fila[2] = objetoProv.buscarPaisPorCodigo(arProv.get(i).getCodPais());
            datosPais.addRow(fila);
        }
    }

    protected void rellenarBomboBox() {
        ArrayList<Pais> artPais = new ArrayList<>();
        artPais = objetoProv.consultarPais();

        for (int i = 0; i < artPais.size(); i++) {
            comboPais.addItem(artPais.get(i).getPais());
            //comboPais.addItem(new Pais(artPais.get(i).getCod(), artPais.get(i).getPais()));
        }
    }

    protected boolean comprobacionCampos() {
        boolean comprobacion = true;
        if (objComprobaciones.comprobacionJTextField(TFprov)) {
            comprobacion = false;
        }
        return comprobacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraHerramientasClientes = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        panel_prov = new javax.swing.JPanel();
        txtCodigo2 = new javax.swing.JLabel();
        TFProv = new javax.swing.JTextField();
        txtNombre6 = new javax.swing.JLabel();
        txtNombre7 = new javax.swing.JLabel();
        TFprov = new javax.swing.JTextField();
        comboPais = new javax.swing.JComboBox();
        botonActualizar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        PANEL_buscar_cliente = new javax.swing.JPanel();
        TFBuscar = new javax.swing.JTextField();
        buscadorClientes = new javax.swing.JScrollPane();
        tablaProv = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Provincias");

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
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });
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
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        barraHerramientasClientes.add(botonEliminar);
        barraHerramientasClientes.add(jSeparator1);

        panel_prov.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Provincia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo2.setText("Código:");

        txtNombre6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre6.setText("Pais");

        txtNombre7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre7.setText("Provincia");

        TFprov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFprovKeyReleased(evt);
            }
        });

        comboPais.setPreferredSize(new java.awt.Dimension(32, 22));

        botonActualizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/actualizar.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonActualizar.setFocusable(false);
        botonActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonActualizar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonActualizar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonActualizar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/guardar.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar.setFocusable(false);
        botonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonGuardar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonGuardar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_provLayout = new javax.swing.GroupLayout(panel_prov);
        panel_prov.setLayout(panel_provLayout);
        panel_provLayout.setHorizontalGroup(
            panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_provLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFProv, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TFprov, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_provLayout.createSequentialGroup()
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        panel_provLayout.setVerticalGroup(
            panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_provLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panel_provLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_provLayout.createSequentialGroup()
                        .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(TFprov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        PANEL_buscar_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

        tablaProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaProv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProvMouseClicked(evt);
            }
        });
        buscadorClientes.setViewportView(tablaProv);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por palabras: ");

        javax.swing.GroupLayout PANEL_buscar_clienteLayout = new javax.swing.GroupLayout(PANEL_buscar_cliente);
        PANEL_buscar_cliente.setLayout(PANEL_buscar_clienteLayout);
        PANEL_buscar_clienteLayout.setHorizontalGroup(
            PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_buscar_clienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscadorClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(PANEL_buscar_clienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        PANEL_buscar_clienteLayout.setVerticalGroup(
            PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_buscar_clienteLayout.createSequentialGroup()
                .addGroup(PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscadorClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_prov, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_prov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // BOTON NUEVO
        bloquear(true);
        limpiarDatos();
        comboPais.removeAllItems();
        botonActualizar.setEnabled(false);
        generarCodigoProvincia();
        rellenarBomboBox();


    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TBOTON ELIMINAR
        int codProv = Integer.parseInt(TFProv.getText());

        int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Aviso del Sistema.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (seleccion == 0) {
            objetoProv.eliminarProv(codProv);
            cargarDatosProvincia("");
            JOptionPane.showMessageDialog(this, "Datos eliminados.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // BOTON ACTUALIZAR
        int codProv = Integer.parseInt(TFProv.getText());
        String nombreProv = TFprov.getText();

        boolean comprobacion = objetoProv.actualizarProv(codProv, nombreProv);

        if (comprobacion != true) {
            JOptionPane.showMessageDialog(this, "Datos actualizados.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            cargarDatosProvincia("");
            bloquear(false);
            botonNuevo.setEnabled(true);
            limpiarDatos();
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // BOTON GUARDAR
        if (comprobacionCampos()) {
            int codProv = Integer.parseInt(TFProv.getText());
            int nombrePais = objetoProv.buscarNombrePorCodigo(comboPais.getSelectedItem().toString());

            String nombreProv = TFprov.getText();

            boolean comprobacion = objetoProv.ingresoProv(codProv, nombreProv, nombrePais);

            if (comprobacion == true) {
                JOptionPane.showMessageDialog(this, "Datos guardados con exito.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
                cargarDatosProvincia("");
                limpiarDatos();
                bloquear(false);
                botonNuevo.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Introduce el campo necesario.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_botonGuardarActionPerformed

    private void tablaProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProvMouseClicked
        // TABLA 
        bloquear(true);
        botonGuardar.setEnabled(false);
        comboPais.setEnabled(false);
        comboPais.removeAllItems();

        int filaSelecionada = tablaProv.rowAtPoint(evt.getPoint());
        TFProv.setText(tablaProv.getValueAt(filaSelecionada, 0).toString());
        TFprov.setText(tablaProv.getValueAt(filaSelecionada, 1).toString());
        comboPais.addItem(tablaProv.getValueAt(filaSelecionada, 2).toString());

    }//GEN-LAST:event_tablaProvMouseClicked

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        // BUSCADOR
        cargarDatosProvincia(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased

    private void TFprovKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFprovKeyReleased
        TFprov.setBorder(new LineBorder(Color.gray));
    }//GEN-LAST:event_TFprovKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANEL_buscar_cliente;
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JTextField TFProv;
    private javax.swing.JTextField TFprov;
    private javax.swing.JToolBar barraHerramientasClientes;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JScrollPane buscadorClientes;
    private javax.swing.JComboBox comboPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPanel panel_prov;
    private javax.swing.JTable tablaProv;
    private javax.swing.JLabel txtCodigo2;
    private javax.swing.JLabel txtNombre6;
    private javax.swing.JLabel txtNombre7;
    // End of variables declaration//GEN-END:variables
}
