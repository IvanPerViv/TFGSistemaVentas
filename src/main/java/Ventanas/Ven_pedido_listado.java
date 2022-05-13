package Ventanas;

import Conexiones.Con_albaran;
import Conexiones.Con_albaran_linea;
import Conexiones.Con_articulo;
import Conexiones.Con_cliente;
import Conexiones.Con_pedido;
import Conexiones.Con_pedido_linea;
import Modelos.LineaPedido;
import Modelos.Pedido;
import Utils.Comprobaciones;
import Utils.generacionDeCodigo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ven_pedido_listado extends javax.swing.JInternalFrame {

    protected DefaultTableModel mostrarPedidos;
    protected Con_pedido objConPedidos;
    protected Con_articulo objConArticulos;
    protected Con_pedido_linea obLineaPedido;
    protected Con_albaran objAlbaran;   
    protected Con_albaran_linea objConAlbaranLinea;

    protected final Comprobaciones objComprobaciones;
    protected String estado;

    public Ven_pedido_listado() {
        initComponents();
        objConPedidos = new Con_pedido();
        objComprobaciones = new Comprobaciones();
        objConArticulos = new Con_articulo();
        obLineaPedido = new Con_pedido_linea();
        objAlbaran = new Con_albaran();
        objConAlbaranLinea = new Con_albaran_linea();
        
        cargaDeDatosPedidos("");
    }

    protected void limpiarDatos() {
        TFCodPedido.setText("");
        TFNombreCliente.setText("");
        TFTotalPedido.setText("");
    }

    protected void cargaDeDatosPedidos(String buscar) {
        String[] nombreTablas = {"CÓDIGO PEDIDO", "NOMBRE CLIENTE", "ESTADO", "FECHA"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        mostrarPedidos = new DefaultTableModel(null, nombreTablas);
        tablaPedidos.setModel(mostrarPedidos);

        ArrayList<Pedido> arPedidos = new ArrayList<Pedido>();
        arPedidos = objConPedidos.mostrarPedidos(buscar);

        Object[] fila = new Object[nombreTablas.length];
        for (int i = 0; i < arPedidos.size(); i++) {
            fila[0] = arPedidos.get(i).getNum_pedido();
            fila[1] = objConPedidos.mostrarNombreCliente(arPedidos.get(i).getCod_cliente());
            fila[2] = arPedidos.get(i).getEstado();
            fila[3] = arPedidos.get(i).getFecha_pedido();
            mostrarPedidos.addRow(fila);
        }
    }

    protected void cargaDeDatosNumPedidos(int buscar) {
        ArrayList<Pedido> arPedidos = new ArrayList<Pedido>();
        arPedidos = objConPedidos.busquedaNumPedido(buscar);

        Object[] fila = new Object[4];
        for (int i = 0; i < arPedidos.size(); i++) {
            fila[0] = arPedidos.get(i).getNum_pedido();
            fila[1] = objConPedidos.mostrarNombreCliente(arPedidos.get(i).getCod_cliente());
            fila[2] = arPedidos.get(i).getEstado();
            fila[3] = arPedidos.get(i).getFecha_pedido();
            mostrarPedidos.addRow(fila);
        }
    }

    public void limpiezaTabla() {
        DefaultTableModel tablaTemporal = (DefaultTableModel) tablaPedidos.getModel();
        int filas = tablaPedidos.getRowCount();
        int contador = 0;
        while (filas > contador) {
            tablaTemporal.removeRow(0);
            contador++;
        }
    }

    protected int generarCodigoAlbaran() {
        int numero;
        int codigoAlbaran = objAlbaran.codigoAlbaran();
        if (codigoAlbaran != 0) {
            generacionDeCodigo objGenCod = new generacionDeCodigo();
            numero = objGenCod.generarCod(codigoAlbaran);
        } else {
            numero = 1;
        }
        return numero;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonGroup = new javax.swing.ButtonGroup();
        informacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        TFBuscar = new javax.swing.JTextField();
        buscadorPedidos = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        TFCodPedido = new javax.swing.JTextField();
        txtCod = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JLabel();
        TFNombreCliente = new javax.swing.JTextField();
        txtTotal = new javax.swing.JLabel();
        TFTotalPedido = new javax.swing.JTextField();
        txtEstado = new javax.swing.JLabel();
        jComboEstadoPedido = new javax.swing.JComboBox<>();
        botonEliminarPedido = new javax.swing.JButton();
        botonVerDetalles = new javax.swing.JButton();
        botonCambiarEstadoPedido = new javax.swing.JButton();
        mostrarNumPedido = new javax.swing.JRadioButton();
        TFnumPedido = new javax.swing.JTextField();
        BuscarNumPedido = new javax.swing.JButton();
        buscarPorPalabras = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Listado PEDIDOS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/iconPedidos.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(746, 512));

        informacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion.setText("LISTADO DE PEDIDOS");

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

        tablaPedidos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPedidosMouseClicked(evt);
            }
        });
        buscadorPedidos.setViewportView(tablaPedidos);

        TFCodPedido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFCodPedido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFCodPedido.setBorder(null);
        TFCodPedido.setEnabled(false);
        TFCodPedido.setFocusable(false);
        TFCodPedido.setOpaque(false);

        txtCod.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCod.setText("Código Pedido:");

        txtNombreCliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombreCliente.setText("Nombre Cliente:");

        TFNombreCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFNombreCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFNombreCliente.setBorder(null);
        TFNombreCliente.setEnabled(false);
        TFNombreCliente.setFocusable(false);
        TFNombreCliente.setOpaque(false);

        txtTotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTotal.setText("Fecha:");

        TFTotalPedido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFTotalPedido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFTotalPedido.setBorder(null);
        TFTotalPedido.setEnabled(false);
        TFTotalPedido.setFocusable(false);
        TFTotalPedido.setOpaque(false);

        txtEstado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtEstado.setText("Estado Pedido");

        jComboEstadoPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Enviado", "Anulado" }));
        jComboEstadoPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonEliminarPedido.setText("ELIMINAR");
        botonEliminarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPedidoActionPerformed(evt);
            }
        });

        botonVerDetalles.setText("VER DETALLES");
        botonVerDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerDetallesActionPerformed(evt);
            }
        });

        botonCambiarEstadoPedido.setText("CAMBIAR");
        botonCambiarEstadoPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCambiarEstadoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarEstadoPedidoActionPerformed(evt);
            }
        });

        botonGroup.add(mostrarNumPedido);
        mostrarNumPedido.setText("Mostrar  por Nº Pedido:");

        BuscarNumPedido.setText("BUSCAR");
        BuscarNumPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarNumPedidoActionPerformed(evt);
            }
        });

        botonGroup.add(buscarPorPalabras);
        buscarPorPalabras.setSelected(true);
        buscarPorPalabras.setText("Buscar por 'Estado':");
        buscarPorPalabras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorPalabrasActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_albaran/icons8-test-aprobado-80.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(mostrarNumPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buscarPorPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(15, 15, 15)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(TFnumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(BuscarNumPedido))
                                        .addComponent(TFBuscar)))
                                .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(botonEliminarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonVerDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addGap(12, 12, 12)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TFCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txtEstado))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jComboEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonCambiarEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFnumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mostrarNumPedido)
                            .addComponent(BuscarNumPedido))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscarPorPalabras)
                            .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonVerDetalles)
                        .addGap(15, 15, 15)
                        .addComponent(botonEliminarPedido))
                    .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(TFNombreCliente)
                            .addComponent(TFCodPedido)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonCambiarEstadoPedido))
                    .addComponent(TFTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        cargaDeDatosPedidos(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased

    private void tablaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPedidosMouseClicked
        int filaSelecionada = tablaPedidos.rowAtPoint(evt.getPoint());
        TFCodPedido.setText(tablaPedidos.getValueAt(filaSelecionada, 0).toString());
        TFNombreCliente.setText(tablaPedidos.getValueAt(filaSelecionada, 1).toString());
        estado = tablaPedidos.getValueAt(filaSelecionada, 2).toString();
        TFTotalPedido.setText(tablaPedidos.getValueAt(filaSelecionada, 3).toString());

    }//GEN-LAST:event_tablaPedidosMouseClicked

    private void botonVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerDetallesActionPerformed
        int filaSelecionada = tablaPedidos.getSelectedRow();

        if (filaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila de la tabla.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        } else {

            int codPedido = Integer.parseInt(tablaPedidos.getValueAt(filaSelecionada, 0).toString());
            estado = tablaPedidos.getValueAt(filaSelecionada, 2).toString();
            Ven_tabla_pedido_listado_verdetalle objTablaPedidosListadoVerDetalles = new Ven_tabla_pedido_listado_verdetalle(codPedido);
            Ven_principal.escritorio.add(objTablaPedidosListadoVerDetalles).setVisible(true);
        }
    }//GEN-LAST:event_botonVerDetallesActionPerformed

    private void botonEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPedidoActionPerformed
        // BOTON BORRAR
        int filaSelecionada = tablaPedidos.getSelectedRow();        
        if (filaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila de la tabla.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String estado = tablaPedidos.getValueAt(filaSelecionada, 2).toString();
            if (estado.contains("Anulado")) {
                int seleccion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar el pedido?", "Aviso del Sistema.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (seleccion == 0) {
                    int codPedido = Integer.parseInt(tablaPedidos.getValueAt(filaSelecionada, 0).toString());
                    objConPedidos.eliminarPedido(codPedido);
                    JOptionPane.showMessageDialog(this, "Pedido eliminado.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
                }
                cargaDeDatosPedidos("");
                limpiarDatos();
            } else {
                JOptionPane.showMessageDialog(this, "Anule el pedido para su eliminación.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_botonEliminarPedidoActionPerformed


    private void botonCambiarEstadoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarEstadoPedidoActionPerformed
        // BOTON CAMBIAR ESTADO

        int fila = tablaPedidos.getSelectedRow();
        int codPedido = Integer.parseInt(tablaPedidos.getValueAt(fila, 0).toString());
        String codCliente = tablaPedidos.getValueAt(fila, 1).toString();
        String fecha = tablaPedidos.getValueAt(fila, 3).toString();
        java.sql.Date fechaConversion = java.sql.Date.valueOf(fecha); // CONVERSION STRING TO SQL.DATE

        int codCLiente = objConPedidos.mostrarCodCliente(codCliente);
        String estado = jComboEstadoPedido.getSelectedItem().toString();
        int codigoAlbaran = generarCodigoAlbaran();

        switch (estado) {

            case "Pendiente":
                //SE ACTUALIZA EL ESTADO.
                objConPedidos.actualizarEstadoPedido(codPedido, estado);
                break;
            case "Enviado":
                //GENERA ALBARAN
                int seleccion = JOptionPane.showConfirmDialog(this, "¿Estas seguro?", "Aviso del Sistema.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (seleccion == 0) {
                    //SE ACTUALIZA EL ESTADO.
                    objConPedidos.actualizarEstadoPedido(codPedido, estado);
                    JOptionPane.showMessageDialog(this, "Se ha generado un nuevo Albaran.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);

                    //SE GENERA UN NUEVO ALBARAN
                    objAlbaran.ingresoAlbaran(codigoAlbaran, codCLiente, codPedido, fechaConversion, "Pendiente");

                    ArrayList<LineaPedido> arLineaPedido = new ArrayList<>();
                    arLineaPedido = obLineaPedido.mostrarLineasPedidos(codPedido); //CARGAMOS LOS DATOS DE LINEA-PEDIDO PARA EL PEDIDO
                    for (int i = 0; i < arLineaPedido.size(); i++) {
                        int codArticulo = arLineaPedido.get(i).getCodArticulo();
                        int cantidad = arLineaPedido.get(i).getCantidad();
                        double precioUnitario = arLineaPedido.get(i).getPrecioVenta();
                        double iva = arLineaPedido.get(i).getIva();
                        
                        //SE GENERA UN NUEVO LINEA-ALBARAN CON LOS DATOS DE LINEA-PEDIDO.
                        objConAlbaranLinea.ingresoLineaAlbaran(codigoAlbaran, codArticulo, cantidad, precioUnitario, iva);
                    }
                }
                break;
            case "Anulado":
                objConPedidos.actualizarEstadoPedido(codPedido, estado);
                break;
        }
        cargaDeDatosPedidos("");

    }//GEN-LAST:event_botonCambiarEstadoPedidoActionPerformed

    private void BuscarNumPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNumPedidoActionPerformed
        // BOTON BUSCAR   
        limpiezaTabla();
        cargaDeDatosNumPedidos(Integer.parseInt(TFnumPedido.getText()));
    }//GEN-LAST:event_BuscarNumPedidoActionPerformed

    private void buscarPorPalabrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorPalabrasActionPerformed
        if (buscarPorPalabras.isSelected() == true) {
            limpiezaTabla();
            cargaDeDatosPedidos(TFBuscar.getText());
        }
    }//GEN-LAST:event_buscarPorPalabrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarNumPedido;
    private javax.swing.JTextField TFBuscar;
    public static javax.swing.JTextField TFCodPedido;
    public static javax.swing.JTextField TFNombreCliente;
    public static javax.swing.JTextField TFTotalPedido;
    private javax.swing.JTextField TFnumPedido;
    private javax.swing.JButton botonCambiarEstadoPedido;
    private javax.swing.JButton botonEliminarPedido;
    private javax.swing.ButtonGroup botonGroup;
    private javax.swing.JButton botonVerDetalles;
    private javax.swing.JScrollPane buscadorPedidos;
    private javax.swing.JRadioButton buscarPorPalabras;
    private javax.swing.JLabel informacion;
    private javax.swing.JComboBox<String> jComboEstadoPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton mostrarNumPedido;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JLabel txtCod;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtNombreCliente;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
