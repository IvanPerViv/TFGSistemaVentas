package Ventanas;

import Conexiones.Con_albaran;
import Conexiones.Con_pedido;
import Modelos.Albaran;
import Modelos.Pedidos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ven_albaran_listado extends javax.swing.JInternalFrame {

    protected DefaultTableModel dftAlbaran;
    protected Con_albaran objAlbaran;
    protected Con_pedido objConPedidos;

    public Ven_albaran_listado() {
        initComponents();
        objAlbaran = new Con_albaran();
        objConPedidos = new Con_pedido();

        cargaDeDatosAlbaran("");
    }

    protected void cargaDeDatosAlbaran(String buscar) {
        String[] nombreTablas = {"CÓDIGO ALBARÁN", "CÓDIGO PEDIDO", "NOMBRE CLIENTE", "FECHA", "ESTADO"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        dftAlbaran = new DefaultTableModel(null, nombreTablas);
        tablaPedidos.setModel(dftAlbaran);

        ArrayList<Albaran> arAlbaran = new ArrayList<>();
        arAlbaran = objAlbaran.mostrarAlbaran(buscar);

        Object[] fila = new Object[nombreTablas.length];
        for (int i = 0; i < arAlbaran.size(); i++) {
            fila[0] = arAlbaran.get(i).getCodAlbaran();
            fila[1] = arAlbaran.get(i).getNumPedido();
            fila[2] = objConPedidos.mostrarCodPedido(arAlbaran.get(i).getCodCliente()); //SUBCONSULTA
            fila[3] = arAlbaran.get(i).getFecha();
            fila[4] = arAlbaran.get(i).getEstado();
            dftAlbaran.addRow(fila);
        }
    }

    protected void cargaDeDatosNumPedidos(int buscar) {
        ArrayList<Pedidos> arPedidos = new ArrayList<>();
        arPedidos = objConPedidos.busquedaNumPedido(buscar);

        Object[] fila = new Object[3];
        for (int i = 0; i < arPedidos.size(); i++) {
            fila[0] = arPedidos.get(i).getNum_pedido();
            fila[1] = objConPedidos.mostrarCodPedido(arPedidos.get(i).getCod_cliente());
            fila[2] = arPedidos.get(i).getFecha_pedido();
            dftAlbaran.addRow(fila);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonGroup = new javax.swing.ButtonGroup();
        informacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        TFBuscar = new javax.swing.JTextField();
        buscadorPedidos = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        botonEliminar = new javax.swing.JButton();
        botonVerDetalles = new javax.swing.JButton();
        mostrarNumPedido = new javax.swing.JRadioButton();
        TFnumPedido = new javax.swing.JTextField();
        BuscarNumPedido = new javax.swing.JButton();
        buscarPorPalabras = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Listado ALBARÁNES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/iconAlbaranes.png"))); // NOI18N

        informacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion.setText("LISTADO DE ALBARÁNES");

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
        buscadorPedidos.setViewportView(tablaPedidos);

        botonEliminar.setText("ELIMINAR");
        botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonVerDetalles.setText("VER DETALLES");
        botonVerDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerDetallesActionPerformed(evt);
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
        buscarPorPalabras.setText("Buscar por 'Cliente':");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_albaran/icons8-test-aprobado-80.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonVerDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
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
                            .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonVerDetalles)
                        .addGap(15, 15, 15)
                        .addComponent(botonEliminar))
                    .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerDetallesActionPerformed
        // boton ver detalles ALBARAN
        int filaSelecionada = tablaPedidos.getSelectedRow();
        if (filaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila de la tabla.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int codAlbaran = Integer.parseInt(tablaPedidos.getValueAt(filaSelecionada, 0).toString());
            String estado = tablaPedidos.getValueAt(filaSelecionada, 4).toString();
            if (!estado.equals("Enviado")) {
                Ven_albaran objAlbaraan = new Ven_albaran(codAlbaran);
                Ven_principal.escritorio.add(objAlbaraan).setVisible(true);
                dispose();
            } else{
                JOptionPane.showMessageDialog(this, "Su Albarán ha sido enviado.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_botonVerDetallesActionPerformed

    private void BuscarNumPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNumPedidoActionPerformed
        limpiezaTabla();
        cargaDeDatosNumPedidos(Integer.parseInt(TFnumPedido.getText()));
    }//GEN-LAST:event_BuscarNumPedidoActionPerformed

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        cargaDeDatosAlbaran(TFnumPedido.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarNumPedido;
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JTextField TFnumPedido;
    private javax.swing.JButton botonEliminar;
    private javax.swing.ButtonGroup botonGroup;
    private javax.swing.JButton botonVerDetalles;
    private javax.swing.JScrollPane buscadorPedidos;
    private javax.swing.JRadioButton buscarPorPalabras;
    private javax.swing.JLabel informacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton mostrarNumPedido;
    private javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
