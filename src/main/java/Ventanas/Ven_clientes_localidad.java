/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Ventanas;

import Conexiones.Con_localidad_prov_pais;
import Modelos.Localidad;
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
 * @author LordUriel
 */
public class Ven_clientes_localidad extends javax.swing.JInternalFrame {

    protected Con_localidad_prov_pais objetoLocalidad;
    protected generarCodigos objGenCod;
    protected Comprobaciones objComprobaciones;
    protected DefaultTableModel datosLocalidad;

    public Ven_clientes_localidad() {
        initComponents();
        objetoLocalidad = new Con_localidad_prov_pais();
        objGenCod = new generarCodigos();
        objComprobaciones = new Comprobaciones();
        
        cargarDatosLocalidad("");
        TFCodigoLocal.setEnabled(false);
        bloquear(false);
    }

    protected void bloquear(boolean blockeo) {
        botonEliminar.setEnabled(blockeo);
        botonActualizar.setEnabled(blockeo);
        botonGuardar.setEnabled(blockeo);

        comboProv.setEnabled(blockeo);
        comboProv.setEnabled(blockeo);
        TFCiudad.setEnabled(blockeo);
    }

    protected void limpiarDatos() {
        TFCiudad.setText("");
    }

    protected void generarCodigoProvincia() {
        int codProv = objetoLocalidad.codigoProv();
        if (codProv != 0) {
            int numero = objGenCod.generarCod(codProv);
            TFCodigoLocal.setText(String.valueOf(numero));
        } else {
            TFCodigoLocal.setText("1");
        }
    }

    protected void cargarDatosLocalidad(String buscar) {
        String[] nombreTablas = {"Cod", "Nombre ciudad", "Provincia"}; //Cargamos en un array el nombre que tendran nuestras columnas.
        datosLocalidad = new DefaultTableModel(null, nombreTablas);
        tablaLocalidad.setModel(datosLocalidad);

        Object[] fila = new Object[nombreTablas.length];

        ArrayList<Localidad> artLocal = new ArrayList<Localidad>();
        artLocal = objetoLocalidad.MostrarLocalidad(buscar);

        for (int i = 0; i < artLocal.size(); i++) {
            fila[0] = artLocal.get(i).getCodLocalidad();
            fila[1] = artLocal.get(i).getNombreCiudad();
            fila[2] = objetoLocalidad.buscarProvinciaPorCodigo(artLocal.get(i).getCodProv());
            datosLocalidad.addRow(fila);
        }
    }

    protected void rellenarBomboBoxProv() {
        ArrayList<Provincia> artPais = new ArrayList<>();
        artPais = objetoLocalidad.consultarProvincia();

        for (int i = 0; i < artPais.size(); i++) {
            comboProv.addItem(artPais.get(i).getNombreProvincia());
            //comboPais.addItem(new Pais(artPais.get(i).getCod(), artPais.get(i).getPais()));
        }
    }

    protected boolean comprobacionCampos() {
        boolean comprobacion = true;
        if (objComprobaciones.comprobacionJTextField(TFCiudad)) {
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
        panel_localidad = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JLabel();
        TFCodigoLocal = new javax.swing.JTextField();
        txtNombre = new javax.swing.JLabel();
        TFCiudad = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JLabel();
        comboProv = new javax.swing.JComboBox();
        botonActualizar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        PANEL_buscar_cliente = new javax.swing.JPanel();
        TFBuscar = new javax.swing.JTextField();
        buscadorClientes = new javax.swing.JScrollPane();
        tablaLocalidad = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Ciudad");

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

        panel_localidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Localidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo.setText("Código:");

        txtNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre.setText("Ciudad:");

        TFCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFCiudadKeyReleased(evt);
            }
        });

        txtNombre1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre1.setText("Provincia:");

        comboProv.setPreferredSize(new java.awt.Dimension(32, 22));

        botonActualizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/actualizar.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
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

        javax.swing.GroupLayout panel_localidadLayout = new javax.swing.GroupLayout(panel_localidad);
        panel_localidad.setLayout(panel_localidadLayout);
        panel_localidadLayout.setHorizontalGroup(
            panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_localidadLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_localidadLayout.createSequentialGroup()
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_localidadLayout.createSequentialGroup()
                        .addGroup(panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TFCiudad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodigoLocal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboProv, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        panel_localidadLayout.setVerticalGroup(
            panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_localidadLayout.createSequentialGroup()
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFCodigoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(comboProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(TFCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        PANEL_buscar_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

        tablaLocalidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaLocalidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaLocalidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLocalidadMouseClicked(evt);
            }
        });
        buscadorClientes.setViewportView(tablaLocalidad);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por palabras: ");

        javax.swing.GroupLayout PANEL_buscar_clienteLayout = new javax.swing.GroupLayout(PANEL_buscar_cliente);
        PANEL_buscar_cliente.setLayout(PANEL_buscar_clienteLayout);
        PANEL_buscar_clienteLayout.setHorizontalGroup(
            PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_buscar_clienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscadorClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(PANEL_buscar_clienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(TFBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_localidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // BOTON NUEVO
        bloquear(true);
        limpiarDatos();
        comboProv.removeAllItems();
        botonActualizar.setEnabled(false);
        generarCodigoProvincia();
        rellenarBomboBoxProv();
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // BOTON ELIMINAR
        int codLocal = Integer.parseInt(TFCodigoLocal.getText());

        int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Aviso del Sistema.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (seleccion == 0) {
            objetoLocalidad.eliminarLocalidad(codLocal);
            cargarDatosLocalidad("");
            JOptionPane.showMessageDialog(this, "Datos eliminados.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        int codLocal = Integer.parseInt(TFCodigoLocal.getText());
        String ciudad = TFCiudad.getText();

        boolean comprobacion = objetoLocalidad.actualizarLocalidad(codLocal, ciudad);

        if (comprobacion != true) {
            JOptionPane.showMessageDialog(this, "Datos actualizados.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);

            bloquear(false);
            botonNuevo.setEnabled(true);
            limpiarDatos();
        }
        cargarDatosLocalidad("");
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // BOTON GUARDAR
        if (comprobacionCampos()) {
            int codLocal = Integer.parseInt(TFCodigoLocal.getText());
            int nombreProvincia = objetoLocalidad.consultarProvincia(comboProv.getSelectedItem().toString());
            String ciudad = TFCiudad.getText();

            boolean comprobacion = objetoLocalidad.ingresoLocalidad(codLocal, ciudad, nombreProvincia);

            if (comprobacion == true) {
                JOptionPane.showMessageDialog(this, "Datos guardados con exito.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
                cargarDatosLocalidad("");
                limpiarDatos();
                bloquear(false);
                botonNuevo.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Introduce el campo necesario.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_botonGuardarActionPerformed

    private void tablaLocalidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLocalidadMouseClicked
        // TABLA 
        bloquear(true);
        botonGuardar.setEnabled(false);
        comboProv.setEnabled(false);
        comboProv.removeAllItems();

        int filaSelecionada = tablaLocalidad.rowAtPoint(evt.getPoint());
        TFCodigoLocal.setText(tablaLocalidad.getValueAt(filaSelecionada, 0).toString());
        TFCiudad.setText(tablaLocalidad.getValueAt(filaSelecionada, 1).toString());
        comboProv.addItem(tablaLocalidad.getValueAt(filaSelecionada, 2).toString());
    }//GEN-LAST:event_tablaLocalidadMouseClicked

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        cargarDatosLocalidad(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased

    private void TFCiudadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFCiudadKeyReleased
        TFCiudad.setBorder(new LineBorder(Color.gray));
    }//GEN-LAST:event_TFCiudadKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANEL_buscar_cliente;
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JTextField TFCiudad;
    private javax.swing.JTextField TFCodigoLocal;
    private javax.swing.JToolBar barraHerramientasClientes;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JScrollPane buscadorClientes;
    private javax.swing.JComboBox comboProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPanel panel_localidad;
    private javax.swing.JTable tablaLocalidad;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombre1;
    // End of variables declaration//GEN-END:variables
}
