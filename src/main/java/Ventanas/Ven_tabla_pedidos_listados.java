package Ventanas;

import Conexiones.Con_pedidos;
import Modelos.Pedidos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ven_tabla_pedidos_listados extends javax.swing.JInternalFrame {

    protected DefaultTableModel mostrarPedidos;
    protected Con_pedidos objConPedidos = new Con_pedidos();
    protected String estado;

    public Ven_tabla_pedidos_listados() {
        initComponents();
        cargaDeDatosPedidos("");

    }

    protected void cargaDeDatosPedidos(String buscar) {
        String[] nombreTablas = {"Código", "Nombre Cliente", "Total", "Estado"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        mostrarPedidos = new DefaultTableModel(null, nombreTablas);
        tablaPedidos.setModel(mostrarPedidos);

        ArrayList<Pedidos> pedidosArr = new ArrayList<Pedidos>();
        pedidosArr = objConPedidos.mostrarPedidos(buscar);

        Object[] fila = new Object[4];
        for (int i = 0; i < pedidosArr.size(); i++) {
            fila[0] = pedidosArr.get(i).getCod_pedido();
            fila[1] = objConPedidos.mostrarCodPedido(pedidosArr.get(i).getCod_cliente());
            fila[2] = pedidosArr.get(i).getPrecio_total();
            fila[3] = pedidosArr.get(i).getEstado();
            System.out.println(fila[1]);
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
        txtEstado1 = new javax.swing.JLabel();
        botonActualizarPedido = new javax.swing.JButton();
        txtTotal1 = new javax.swing.JLabel();
        TFTotalPedido1 = new javax.swing.JTextField();

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
        tablaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPedidosMouseClicked(evt);
            }
        });
        buscadorPedidos.setViewportView(tablaPedidos);

        TFCodPedido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFCodPedido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFCodPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TFCodPedido.setEnabled(false);
        TFCodPedido.setFocusable(false);
        TFCodPedido.setOpaque(false);

        txtCod.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCod.setText("Código Pedido:");

        txtNombreCliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombreCliente.setText("Nombre Cliente:");

        TFNombreCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFNombreCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFNombreCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TFNombreCliente.setEnabled(false);
        TFNombreCliente.setFocusable(false);
        TFNombreCliente.setOpaque(false);

        txtTotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTotal.setText("Total:");

        TFTotalPedido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFTotalPedido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFTotalPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TFTotalPedido.setEnabled(false);
        TFTotalPedido.setFocusable(false);
        TFTotalPedido.setOpaque(false);

        txtEstado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtEstado.setText("Estado Pedido");

        jComboEstadoPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Pagado" }));
        jComboEstadoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEstadoPedidoActionPerformed(evt);
            }
        });

        txtEstado1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtEstado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEstado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/pago.png"))); // NOI18N

        botonActualizarPedido.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        botonActualizarPedido.setText("Pagar");
        botonActualizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarPedidoActionPerformed(evt);
            }
        });

        txtTotal1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTotal1.setText("Subtotal");

        TFTotalPedido1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFTotalPedido1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFTotalPedido1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TFTotalPedido1.setEnabled(false);
        TFTotalPedido1.setFocusable(false);
        TFTotalPedido1.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TFCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFTotalPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TFTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonActualizarPedido))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(3, 3, 3)))
                                .addGap(20, 20, 20)
                                .addComponent(txtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(txtEstado1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(TFNombreCliente)
                            .addComponent(TFCodPedido)
                            .addComponent(TFTotalPedido1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboEstadoPedido)
                                .addComponent(botonActualizarPedido))
                            .addComponent(TFTotalPedido))
                        .addGap(24, 24, 24))))
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
        TFTotalPedido.setText(tablaPedidos.getValueAt(filaSelecionada, 2).toString());
        estado = tablaPedidos.getValueAt(filaSelecionada, 3).toString();

    }//GEN-LAST:event_tablaPedidosMouseClicked

    private void botonActualizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActualizarPedidoActionPerformed

    private void jComboEstadoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEstadoPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEstadoPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFBuscar;
    public static javax.swing.JTextField TFCodPedido;
    public static javax.swing.JTextField TFNombreCliente;
    public static javax.swing.JTextField TFTotalPedido;
    public static javax.swing.JTextField TFTotalPedido1;
    private javax.swing.JButton botonActualizarPedido;
    private javax.swing.JScrollPane buscadorPedidos;
    private javax.swing.JLabel informacion;
    private javax.swing.JComboBox<String> jComboEstadoPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JLabel txtCod;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtEstado1;
    private javax.swing.JLabel txtNombreCliente;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JLabel txtTotal1;
    // End of variables declaration//GEN-END:variables
}
