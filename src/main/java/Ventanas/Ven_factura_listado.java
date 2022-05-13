
package Ventanas;

/**
 *
 * @author Iván Pérez
 */
public class Ven_factura_listado extends javax.swing.JInternalFrame {

    public Ven_factura_listado() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mostrarNumPedido = new javax.swing.JRadioButton();
        buscarPorPalabras = new javax.swing.JRadioButton();
        TFBuscar2 = new javax.swing.JTextField();
        TFnumPedido = new javax.swing.JTextField();
        BuscarNumPedido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buscadorPedidos = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        botonVerDetalles = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Listado FACTURAS");

        informacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion.setText("LISTADO DE FACTURAS");

        mostrarNumPedido.setText("Mostrar  por Nº Factura:");

        buscarPorPalabras.setSelected(true);
        buscarPorPalabras.setText("Buscar por 'Cliente':");

        TFBuscar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscar2KeyReleased(evt);
            }
        });

        BuscarNumPedido.setText("BUSCAR");
        BuscarNumPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarNumPedidoActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_albaran/icons8-test-aprobado-80.png"))); // NOI18N

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaFacturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscadorPedidos.setViewportView(tablaFacturas);

        botonVerDetalles.setText("VER DETALLES");
        botonVerDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mostrarNumPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buscarPorPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TFnumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(BuscarNumPedido))
                                    .addComponent(TFBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonVerDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFnumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mostrarNumPedido)
                            .addComponent(BuscarNumPedido))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscarPorPalabras)
                            .addComponent(TFBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVerDetalles))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFBuscar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscar2KeyReleased
       
    }//GEN-LAST:event_TFBuscar2KeyReleased

    private void BuscarNumPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNumPedidoActionPerformed
       
    }//GEN-LAST:event_BuscarNumPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarNumPedido;
    private javax.swing.JTextField TFBuscar2;
    private javax.swing.JTextField TFnumPedido;
    private javax.swing.JButton botonVerDetalles;
    private javax.swing.JScrollPane buscadorPedidos;
    private javax.swing.JRadioButton buscarPorPalabras;
    private javax.swing.JLabel informacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton mostrarNumPedido;
    private javax.swing.JTable tablaFacturas;
    // End of variables declaration//GEN-END:variables
}
