package Ventanas;

import Conexiones.Con_albaran;
import Conexiones.Con_cliente;
import Conexiones.Con_pedido;
import Modelos.Albaran;
import Modelos.Cliente;
import Modelos.Pedido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ven_albaran_listado extends javax.swing.JInternalFrame {

    private DefaultTableModel dtmAlbaran;
    private Con_albaran objAlbaran;
    private Con_pedido objConPedidos;

    public Ven_albaran_listado() {
        initComponents();
        objAlbaran = new Con_albaran();
        objConPedidos = new Con_pedido();

        cargaDeDatosAlbaran("");
    }

    private void cargaDeDatosAlbaran(String buscar) {
        String[] nombreTablas = {"CÓDIGO ALBARÁN", "CÓDIGO PEDIDO", "NOMBRE CLIENTE", "FECHA", "ESTADO"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        dtmAlbaran = new DefaultTableModel(null, nombreTablas);
        tablaPedidos.setModel(dtmAlbaran);

        ArrayList<Albaran> arAlbaran = new ArrayList<>();
        arAlbaran = objAlbaran.mostrarAlbaran(buscar);

        Object[] columna = new Object[nombreTablas.length];
        for (int i = 0; i < arAlbaran.size(); i++) {
            columna[0] = arAlbaran.get(i).getCodAlbaran();
            columna[1] = arAlbaran.get(i).getNumPedido();
            columna[2] = objConPedidos.mostrarNombreCliente(arAlbaran.get(i).getCodCliente()); //SUBCONSULTA
            columna[3] = arAlbaran.get(i).getFecha();
            columna[4] = arAlbaran.get(i).getEstado();
            dtmAlbaran.addRow(columna);
        }
    }

    private void cargaDeDatosNumPedidos(int buscar) {
        String[] nombreTablas = {"CÓDIGO ALBARÁN", "CÓDIGO PEDIDO", "NOMBRE CLIENTE", "FECHA", "ESTADO"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        dtmAlbaran = new DefaultTableModel(null, nombreTablas);
        tablaPedidos.setModel(dtmAlbaran);

        ArrayList<Pedido> arPedidos = new ArrayList<>();
        arPedidos = objConPedidos.busquedaNumPedido(buscar);

        Object[] columna = new Object[3];
        for (int i = 0; i < arPedidos.size(); i++) {
            columna[0] = arPedidos.get(i).getNum_pedido();
            columna[1] = objConPedidos.mostrarNombreCliente(arPedidos.get(i).getCod_cliente());
            columna[2] = arPedidos.get(i).getFecha_pedido();
            dtmAlbaran.addRow(columna);
        }
    }

    private void cargaDeDatosCliente(int buscar) {
        ArrayList<Cliente> arCliente = new ArrayList<>();
        arCliente = objAlbaran.mostrarPorCodCliente(buscar);

        Object[] columna = new Object[1];
        for (int i = 0; i < arCliente.size(); i++) {
            columna[0] = arCliente.get(i).getNombreComercial();
            dtmAlbaran.addRow(columna);
        }
    }

    private void limpiezaTabla() {
        DefaultTableModel dtmListadoPedidos = (DefaultTableModel) tablaPedidos.getModel();
        int numeroDeFila = tablaPedidos.getRowCount();
        int contador = 0;
        while (numeroDeFila > contador) {
            dtmListadoPedidos.removeRow(0);
            contador++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonGroup = new javax.swing.ButtonGroup();
        informacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buscadorPedidos = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        botonVerDetalles = new javax.swing.JButton();
        mostrarNumPedido = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        mostrarFecha = new javax.swing.JRadioButton();
        BuscarNumPedido1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Listado ALBARÁNES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/iconAlbaranes.png"))); // NOI18N

        informacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion.setText("LISTADO DE ALBARÁNES");

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
        buscadorPedidos.setViewportView(tablaPedidos);

        botonVerDetalles.setText("VER DETALLES");
        botonVerDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerDetallesActionPerformed(evt);
            }
        });

        botonGroup.add(mostrarNumPedido);
        mostrarNumPedido.setText("Mostrar 'Todo'");
        mostrarNumPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarNumPedidoActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_albaran/icons8-test-aprobado-80.png"))); // NOI18N

        fecha.setDateFormatString("dd/MM/yyyy");
        fecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        botonGroup.add(mostrarFecha);
        mostrarFecha.setSelected(true);
        mostrarFecha.setText("Mostrar por Fecha");

        BuscarNumPedido1.setText("BUSCAR");
        BuscarNumPedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarNumPedido1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mostrarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mostrarNumPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(15, 15, 15)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BuscarNumPedido1))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonVerDetalles)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mostrarFecha, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BuscarNumPedido1)))
                        .addGap(15, 15, 15)
                        .addComponent(mostrarNumPedido)
                        .addGap(15, 15, 15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVerDetalles))
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
            if (!estado.equals("Enviado") && !estado.equals("Facturado")) {
                Ven_albaran objAlbaraan = new Ven_albaran(codAlbaran);
                Ven_principal.escritorio.add(objAlbaraan).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Su Albarán ha sido '"+estado+"'.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_botonVerDetallesActionPerformed

    private void BuscarNumPedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNumPedido1ActionPerformed
        Date date = fecha.getDate();
        long fechaConversion = date.getTime();
        java.sql.Date fechaDate = new java.sql.Date(fechaConversion);  
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formatofecha.format(date);

        cargaDeDatosAlbaran(fechaString);
        
    }//GEN-LAST:event_BuscarNumPedido1ActionPerformed

    private void mostrarNumPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarNumPedidoActionPerformed
        if (mostrarNumPedido.isSelected()) {
            limpiezaTabla();
            cargaDeDatosAlbaran("");
        }
    }//GEN-LAST:event_mostrarNumPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarNumPedido1;
    private javax.swing.ButtonGroup botonGroup;
    private javax.swing.JButton botonVerDetalles;
    private javax.swing.JScrollPane buscadorPedidos;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel informacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton mostrarFecha;
    private javax.swing.JRadioButton mostrarNumPedido;
    private javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
