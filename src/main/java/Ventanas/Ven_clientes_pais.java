package Ventanas;

import Conexiones.Con_localidad_prov_pais;
import Modelos.Pais;
import Utils.Comprobaciones;
import Utils.generarCodigos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Ven_clientes_pais extends javax.swing.JInternalFrame {

    protected Con_localidad_prov_pais objPais;
    protected generarCodigos objGenCod;
    protected final Comprobaciones objComprobaciones;
    protected DefaultTableModel datosPais;

    public Ven_clientes_pais() {
        initComponents();
        objPais = new Con_localidad_prov_pais();
        objGenCod = new generarCodigos();
        objComprobaciones = new Comprobaciones();
        
        cargarDatosPais("");
        TFCodPais.setEnabled(false);
        bloquear(false);
    }

    protected void bloquear(boolean blockeo) {
        botonEliminar.setEnabled(blockeo);
        botonActualizar.setEnabled(blockeo);
        botonGuardar1.setEnabled(blockeo);

        TFPais.setEnabled(blockeo);
    }

    protected void limpiarDatos() {
        TFPais.setText("");
    }

    protected void generarCodigoPais() {
        int codPais = objPais.codigoPais();
        if (codPais != 0) {
            int numero = objGenCod.generarCod(codPais);
            TFCodPais.setText(String.valueOf(numero));
        } else {
            TFCodPais.setText("1");
        }
    }

    protected void cargarDatosPais(String buscar) {
        String[] nombreTablas = {"Cod", "Pais"}; //Cargamos en un array el nombre que tendran nuestras columnas.
        datosPais = new DefaultTableModel(null, nombreTablas);
        tablaPais.setModel(datosPais);

        Object[] fila = new Object[nombreTablas.length];

        ArrayList<Pais> clieArray = new ArrayList<Pais>();
        clieArray = objPais.MostrarPais(buscar);

        for (int i = 0; i < clieArray.size(); i++) {
            fila[0] = clieArray.get(i).getCod();
            fila[1] = clieArray.get(i).getPais();

            datosPais.addRow(fila);
        }
    }

    protected boolean comprobacionCampos() {
        boolean comprobacion = true;
        if (objComprobaciones.comprobacionJTextField(TFPais)) {
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
        panel_Pais = new javax.swing.JPanel();
        txtCodigo1 = new javax.swing.JLabel();
        TFCodPais = new javax.swing.JTextField();
        txtNombre3 = new javax.swing.JLabel();
        TFPais = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();
        botonGuardar1 = new javax.swing.JButton();
        PANEL_buscar_cliente = new javax.swing.JPanel();
        TFBuscar = new javax.swing.JTextField();
        buscadorClientes = new javax.swing.JScrollPane();
        tablaPais = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pais");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/CiudadesIcons.png"))); // NOI18N

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

        panel_Pais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo1.setText("Código:");

        txtNombre3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre3.setText("Pais");

        TFPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFPaisKeyReleased(evt);
            }
        });

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

        botonGuardar1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/guardar.png"))); // NOI18N
        botonGuardar1.setText("Guardar");
        botonGuardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar1.setFocusable(false);
        botonGuardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar1.setMaximumSize(new java.awt.Dimension(60, 60));
        botonGuardar1.setMinimumSize(new java.awt.Dimension(60, 60));
        botonGuardar1.setPreferredSize(new java.awt.Dimension(60, 60));
        botonGuardar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_PaisLayout = new javax.swing.GroupLayout(panel_Pais);
        panel_Pais.setLayout(panel_PaisLayout);
        panel_PaisLayout.setHorizontalGroup(
            panel_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PaisLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFPais)
                    .addGroup(panel_PaisLayout.createSequentialGroup()
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFCodPais, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        panel_PaisLayout.setVerticalGroup(
            panel_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PaisLayout.createSequentialGroup()
                .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFCodPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(panel_PaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        PANEL_buscar_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

        tablaPais.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaPais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaPais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPaisMouseClicked(evt);
            }
        });
        buscadorClientes.setViewportView(tablaPais);

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
                        .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PANEL_buscar_clienteLayout.setVerticalGroup(
            PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_buscar_clienteLayout.createSequentialGroup()
                .addGroup(PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscadorClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Pais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        bloquear(true);
        limpiarDatos();
        botonActualizar.setEnabled(false);
        generarCodigoPais();
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // Boton eliminar 
        int codPais = Integer.parseInt(TFCodPais.getText());

        int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Aviso del Sistema.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (seleccion == 0) {
            objPais.eliminarPais(codPais);
            cargarDatosPais("");
            JOptionPane.showMessageDialog(this, "Datos eliminados.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // BOTON ACTUALIZAR
        int codPais = Integer.parseInt(TFCodPais.getText());
        String pais = TFPais.getText();

        boolean comprobacion = objPais.actualizarPais(codPais, pais);

        if (comprobacion != true) {
            JOptionPane.showMessageDialog(this, "Datos actualizados.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            cargarDatosPais("");
            bloquear(false);
            botonNuevo.setEnabled(true);
            limpiarDatos();
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardar1ActionPerformed
        // BOTON GUARDAR
        if (comprobacionCampos()) {
            int codPais = Integer.parseInt(TFCodPais.getText());
            String pais = TFPais.getText();
            boolean comprobacion = objPais.ingresoPais(codPais, pais);

            if (comprobacion == true) {
                JOptionPane.showMessageDialog(this, "Datos guardados con exito.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
                cargarDatosPais("");
                limpiarDatos();
                bloquear(false);
                botonNuevo.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Introduce el campo necesario.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_botonGuardar1ActionPerformed

    private void tablaPaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPaisMouseClicked
        bloquear(true);
        botonGuardar1.setEnabled(false);
        int filaSelecionada = tablaPais.rowAtPoint(evt.getPoint());
        TFCodPais.setText(tablaPais.getValueAt(filaSelecionada, 0).toString());
        TFPais.setText(tablaPais.getValueAt(filaSelecionada, 1).toString());
    }//GEN-LAST:event_tablaPaisMouseClicked

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        cargarDatosPais(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased

    private void TFPaisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFPaisKeyReleased
        TFPais.setBorder(new LineBorder(Color.gray));
    }//GEN-LAST:event_TFPaisKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANEL_buscar_cliente;
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JTextField TFCodPais;
    private javax.swing.JTextField TFPais;
    private javax.swing.JToolBar barraHerramientasClientes;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar1;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JScrollPane buscadorClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPanel panel_Pais;
    private javax.swing.JTable tablaPais;
    private javax.swing.JLabel txtCodigo1;
    private javax.swing.JLabel txtNombre3;
    // End of variables declaration//GEN-END:variables
}
