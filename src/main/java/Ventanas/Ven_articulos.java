package Ventanas;

import Modelos.Articulos;
import Conexiones.Con_articulos;
import Conexiones.Conexion;
import Utils.generarCodigos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Iván Pérez
 */
public class Ven_articulos extends javax.swing.JInternalFrame {

    protected final Conexion con = new Conexion();
    protected Con_articulos objArticulo = new Con_articulos();
    protected final String DATOVACIO = "";

    public Ven_articulos() {
        initComponents();
        bloquearBotones(false);
        cargaDeDatosArticulos(DATOVACIO);
        TFCodigo.setEnabled(false);
    }

    public void bloquearBotones(boolean bloquear) {
        botonCancelar.setEnabled(bloquear);
        botonGuardar.setEnabled(bloquear);
        botonActualizar.setEnabled(bloquear);

        TFNombre.setEnabled(bloquear);
        TFPrecio.setEnabled(bloquear);
        TFStock.setEditable(bloquear);
        TFIva.setEnabled(bloquear);
    }

    public void limpiarDatos() {
        TFCodigo.setText("");
        TFNombre.setText("");
        TFPrecio.setText("");
        TFIva.setText("");
        TFIva.setText("");
    }

    protected void generarCodigoArticulo() {
        Con_articulos con = new Con_articulos();
        int codArticulo = con.codigoArticulos();
        if (codArticulo != 0) {
            generarCodigos objGenCod = new generarCodigos();
            int numero = objGenCod.generarCod(codArticulo);
            TFCodigo.setText(String.valueOf(numero));
        } else {
            TFCodigo.setText("1");
        }
    }

    protected void cargaDeDatosArticulos(String buscar) {

        String[] nombreTablas = {"Codigo", "Producto", "Precio", "IVA", "Stock"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        DefaultTableModel art = new DefaultTableModel(null, nombreTablas);
        tablaArticulos.setModel(art);

        Object[] fila = new Object[5];

        ArrayList<Articulos> artArry = new ArrayList<Articulos>();
        artArry = objArticulo.mostrarArticulosYBusqueda(buscar);

        for (int i = 0; i < artArry.size(); i++) {
            fila[0] = artArry.get(i).getCod_articulo();
            fila[1] = artArry.get(i).getNombre_producto();
            fila[2] = artArry.get(i).getPrecio_compra();
            fila[3] = artArry.get(i).getIVA();
            fila[4] = artArry.get(i).getStock();
            art.addRow(fila);
        }
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
        jSeparator3 = new javax.swing.JToolBar.Separator();
        txtSeparacion1 = new javax.swing.JLabel();
        PANEL_detalle_cliente = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JLabel();
        TFCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JLabel();
        TFNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JLabel();
        TFPrecio = new javax.swing.JTextField();
        txtIva = new javax.swing.JLabel();
        TFIva = new javax.swing.JTextField();
        TFStock = new javax.swing.JTextField();
        txtStock = new javax.swing.JLabel();
        PANEL_buscar_cliente = new javax.swing.JPanel();
        buscadorArticulos = new javax.swing.JScrollPane();
        tablaArticulos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        TFBuscar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Articulos");
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(646, 570));

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

        botonCancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/cancelar.png"))); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.setFocusable(false);
        botonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCancelar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonCancelar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonCancelar.setPreferredSize(new java.awt.Dimension(60, 60));
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
        botonGuardar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonGuardar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonGuardar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        barraHerramientasClientes.add(botonGuardar);

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
        barraHerramientasClientes.add(botonActualizar);

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
        barraHerramientasClientes.add(jSeparator3);

        txtSeparacion1.setText("                                                                ");
        barraHerramientasClientes.add(txtSeparacion1);

        PANEL_detalle_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Articulos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo.setText("Código:");

        txtNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre.setText("Descripción del Producto:");

        txtPrecio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtPrecio.setText("Precio de Compra:");

        txtIva.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtIva.setText("IVA:");

        txtStock.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtStock.setText("Stock:");

        javax.swing.GroupLayout PANEL_detalle_clienteLayout = new javax.swing.GroupLayout(PANEL_detalle_cliente);
        PANEL_detalle_cliente.setLayout(PANEL_detalle_clienteLayout);
        PANEL_detalle_clienteLayout.setHorizontalGroup(
            PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(TFPrecio, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(15, 15, 15)
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFIva)
                                    .addComponent(txtIva, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFStock)
                                    .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))))
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addComponent(TFNombre)
                        .addGap(15, 15, 15))))
        );
        PANEL_detalle_clienteLayout.setVerticalGroup(
            PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );

        PANEL_buscar_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaArticulosMouseClicked(evt);
            }
        });
        buscadorArticulos.setViewportView(tablaArticulos);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por palabras: ");

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout PANEL_buscar_clienteLayout = new javax.swing.GroupLayout(PANEL_buscar_cliente);
        PANEL_buscar_cliente.setLayout(PANEL_buscar_clienteLayout);
        PANEL_buscar_clienteLayout.setHorizontalGroup(
            PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_buscar_clienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PANEL_buscar_clienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(TFBuscar))
                    .addComponent(buscadorArticulos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        PANEL_buscar_clienteLayout.setVerticalGroup(
            PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_buscar_clienteLayout.createSequentialGroup()
                .addGroup(PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(buscadorArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PANEL_detalle_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(PANEL_detalle_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // BOTON NUEVO //
        bloquearBotones(true);
        botonNuevo.setEnabled(false);
        botonActualizar.setEnabled(false);
        generarCodigoArticulo();
        TFNombre.requestFocus();

    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // BOTON CANCELAR //
        bloquearBotones(false);
        botonNuevo.setEnabled(true);

    }//GEN-LAST:event_botonCancelarActionPerformed

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        cargaDeDatosArticulos(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // BOTON GUARDAR //
        int cod_art = Integer.parseInt(TFCodigo.getText());
        String nombreProc = TFNombre.getText();
        double precioArticulo = Double.valueOf(TFPrecio.getText());
        int iva = Integer.parseInt(TFIva.getText());
        int stock = Integer.parseInt(TFStock.getText());

        Con_articulos con = new Con_articulos();
        boolean comprobacion = con.ingresoDeArticulos(cod_art, nombreProc, precioArticulo, iva, stock);

        if (comprobacion == true) {
            JOptionPane.showMessageDialog(this, "Datos guardados con exito.", "", JOptionPane.INFORMATION_MESSAGE);
            cargaDeDatosArticulos(DATOVACIO);
            limpiarDatos();
            bloquearBotones(false);
            botonNuevo.setEnabled(true);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // BOTON ACTUALIZAR //
        int codigoUser = Integer.parseInt(TFCodigo.getText());
        String nombreArt = TFNombre.getText(),
                precioArt = TFPrecio.getText(),
                iva = TFIva.getText(),
                stockArt = TFStock.getText();
        boolean comprobacion = objArticulo.actualizarArticulos(codigoUser, nombreArt, precioArt, iva, stockArt);

        if (comprobacion != true) {
            JOptionPane.showMessageDialog(this, "Datos guardados con exito.", "", JOptionPane.INFORMATION_MESSAGE);
            cargaDeDatosArticulos(DATOVACIO);
            limpiarDatos();
            bloquearBotones(false);
        }

    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // BOTON ELIMINAR //
        int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "IMPORTANTE", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (seleccion == 0) {
            int codigoUser = Integer.parseInt(TFCodigo.getText());
            objArticulo.eliminarRegistroArticulo(codigoUser);
            cargaDeDatosArticulos(DATOVACIO);
            JOptionPane.showMessageDialog(this, "Datos eliminados.", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void tablaArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArticulosMouseClicked
        int filaSelecionada = tablaArticulos.rowAtPoint(evt.getPoint());
        bloquearBotones(true);
        botonGuardar.setEnabled(false);

        TFCodigo.setText(tablaArticulos.getValueAt(filaSelecionada, 0).toString());
        TFNombre.setText(tablaArticulos.getValueAt(filaSelecionada, 1).toString());
        TFPrecio.setText(tablaArticulos.getValueAt(filaSelecionada, 2).toString());
        TFIva.setText(tablaArticulos.getValueAt(filaSelecionada, 3).toString());
        TFStock.setText(tablaArticulos.getValueAt(filaSelecionada, 4).toString());

    }//GEN-LAST:event_tablaArticulosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANEL_buscar_cliente;
    private javax.swing.JPanel PANEL_detalle_cliente;
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JTextField TFCodigo;
    private javax.swing.JTextField TFIva;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFPrecio;
    private javax.swing.JTextField TFStock;
    private javax.swing.JToolBar barraHerramientasClientes;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JScrollPane buscadorArticulos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTable tablaArticulos;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtIva;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtPrecio;
    private javax.swing.JLabel txtSeparacion1;
    private javax.swing.JLabel txtStock;
    // End of variables declaration//GEN-END:variables
}
