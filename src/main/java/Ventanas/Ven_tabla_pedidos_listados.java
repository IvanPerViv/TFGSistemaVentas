package Ventanas;

import Conexiones.Con_pedidos;
import Modelos.Pedidos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Ven_tabla_pedidos_listados extends javax.swing.JInternalFrame {

    protected DefaultTableModel mostrarPedidos;
    Con_pedidos a = new Con_pedidos();

    public Ven_tabla_pedidos_listados() {
        initComponents();
        cargaDeDatosArticulos("");
       
    }

    protected void cargaDeDatosArticulos(String buscar) {
        String[] nombreTablas = {"Código", "Nombre Cliente", "Total", "Estado"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        mostrarPedidos = new DefaultTableModel(null, nombreTablas);
        tablaPedidos.setModel(mostrarPedidos);

        ArrayList<Pedidos> clieArray = new ArrayList<Pedidos>();
        clieArray = a.mostrarPedidos(buscar);
        Object[] fila = new Object[3];
        for (int i = 0; i < clieArray.size(); i++) {
            fila[0] = clieArray.get(i).getCod_pedido();
            fila[1] = clieArray.get(i).getCod_cliente();
            fila[2] = clieArray.get(i).getPrecio_total();

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
        TFCodProd = new javax.swing.JTextField();
        txtCod = new javax.swing.JLabel();
        txtCod2 = new javax.swing.JLabel();
        TFCodProd2 = new javax.swing.JTextField();
        txtCod3 = new javax.swing.JLabel();
        TFCodProd3 = new javax.swing.JTextField();
        txtCod4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

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

        TFCodProd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtCod.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCod.setText("Código Pedido:");

        txtCod2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCod2.setText("Nombre Cliente:");

        TFCodProd2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtCod3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCod3.setText("Total:");

        TFCodProd3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtCod4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCod4.setText("Estado Pedido");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Realizar pago" }));

        jButton1.setText("ACTUALIZAR");

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
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addComponent(informacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(314, 314, 314))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFCodProd)
                                    .addComponent(txtCod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFCodProd2)
                                    .addComponent(txtCod2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFCodProd3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCod3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(109, 109, 109)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCod4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, 114, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCod2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCod3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFCodProd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodProd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCod4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased

    }//GEN-LAST:event_TFBuscarKeyReleased

    private void tablaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPedidosMouseClicked

    }//GEN-LAST:event_tablaPedidosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFBuscar;
    public static javax.swing.JTextField TFCodProd;
    public static javax.swing.JTextField TFCodProd2;
    public static javax.swing.JTextField TFCodProd3;
    private javax.swing.JScrollPane buscadorPedidos;
    private javax.swing.JLabel informacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JLabel txtCod;
    private javax.swing.JLabel txtCod2;
    private javax.swing.JLabel txtCod3;
    private javax.swing.JLabel txtCod4;
    // End of variables declaration//GEN-END:variables
}
