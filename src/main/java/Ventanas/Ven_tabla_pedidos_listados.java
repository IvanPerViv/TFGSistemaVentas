package Ventanas;

import Conexiones.Con_pedido;
import Modelos.Pedidos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ven_tabla_pedidos_listados extends javax.swing.JInternalFrame {

    protected DefaultTableModel mostrarPedidos;
    protected Con_pedido objConPedidos = new Con_pedido();
    protected String estado;

    public Ven_tabla_pedidos_listados() {
        initComponents();
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

        ArrayList<Pedidos> arPedidos = new ArrayList<Pedidos>();
        arPedidos = objConPedidos.mostrarPedidos(buscar);

        Object[] fila = new Object[nombreTablas.length];
        for (int i = 0; i < arPedidos.size(); i++) {
            fila[0] = arPedidos.get(i).getNum_pedido();
            fila[1] = objConPedidos.mostrarCodPedido(arPedidos.get(i).getCod_cliente());
            fila[2] = arPedidos.get(i).getEstado();
            fila[3] = arPedidos.get(i).getFecha_pedido();
            mostrarPedidos.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Listado");

        informacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion.setText("LISTADO DE PEDIDOS.");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por palabras: ");

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

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

        jComboEstadoPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Pagado" }));

        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("VER DETALLES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CAMBIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(23, 23, 23)
                                .addComponent(jComboEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txtEstado))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFBuscar))
                            .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addGap(5, 5, 5)
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addComponent(TFTotalPedido)))
                .addGap(17, 17, 17))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int filaSelecionada = tablaPedidos.getSelectedRow();
        if (filaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila de la tabla.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        } else {

            int codPedido = Integer.parseInt(tablaPedidos.getValueAt(filaSelecionada, 0).toString());

            Ven_tabla_pedidos_listados_verdetalles objTablaPedidosListadoVerDetalles = new Ven_tabla_pedidos_listados_verdetalles(codPedido);
            Ven_principal.escritorio.add(objTablaPedidosListadoVerDetalles).setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // BOTON BORRAR
        int filaSelecionada = tablaPedidos.getSelectedRow();
        if (filaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila de la tabla.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int seleccion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar el pedido?", "Aviso del Sistema.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (seleccion == 0) {
                int codPedido = Integer.parseInt(tablaPedidos.getValueAt(filaSelecionada, 0).toString());
                objConPedidos.eliminarPedido(codPedido);

                JOptionPane.showMessageDialog(this, "Pedido eliminado.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            }
            cargaDeDatosPedidos("");
            limpiarDatos();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFBuscar;
    public static javax.swing.JTextField TFCodPedido;
    public static javax.swing.JTextField TFNombreCliente;
    public static javax.swing.JTextField TFTotalPedido;
    private javax.swing.JScrollPane buscadorPedidos;
    private javax.swing.JLabel informacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboEstadoPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JLabel txtCod;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtNombreCliente;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
