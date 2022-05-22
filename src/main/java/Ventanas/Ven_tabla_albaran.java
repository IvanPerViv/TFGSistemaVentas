package Ventanas;

import Conexiones.Con_albaran;
import Conexiones.Con_cliente;
import Conexiones.Con_pedido;
import Modelos.Albaran;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iván Pérez
 */
public class Ven_tabla_albaran extends javax.swing.JInternalFrame {

    private Con_albaran objConAlbaran;
    private Con_pedido objConPedidos;

    public Ven_tabla_albaran(int codigoCliente) {
        initComponents();
        objConAlbaran = new Con_albaran();
        objConPedidos = new Con_pedido();
        cargaDatosAlbaran(codigoCliente);
    }

    private void cargaDatosAlbaran(int buscar) {
        String[] nombreTablas = {"CÓDIGO ALBARÁN", "CLIENTE", "NºPEDIDO", "FECHA"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        DefaultTableModel dtm = new DefaultTableModel(null, nombreTablas);
        tablaAlbaranes.setModel(dtm);

        Object[] columna = new Object[nombreTablas.length];

        ArrayList<Albaran> arAlbaran = new ArrayList<>();
        arAlbaran = objConAlbaran.mostrarPorCodCliente(buscar);

        for (int i = 0; i < arAlbaran.size(); i++) {
            columna[0] = arAlbaran.get(i).getCodAlbaran();
            columna[1] = objConPedidos.mostrarNombreCliente(arAlbaran.get(i).getCodCliente()); //SUBCONSULTA PARA SABER EL NOMBRE DEL CLIENTE
            columna[2] = arAlbaran.get(i).getNumPedido();
            columna[3] = arAlbaran.get(i).getFecha();
            String estado = arAlbaran.get(i).getEstado();
            
            //Comprobacion para que NO se repita la facturaciones de albaranes.
            if (!estado.contains("Facturado")) {
                dtm.addRow(columna);
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buscadorAlbaranes = new javax.swing.JScrollPane();
        tablaAlbaranes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        informacion2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Listado albaranes");

        informacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion.setText("ALBARÁNES");

        tablaAlbaranes.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaAlbaranes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaAlbaranes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        buscadorAlbaranes.setViewportView(tablaAlbaranes);

        jButton1.setText("ENVIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        informacion2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        informacion2.setText("Clic 'Ctrl' para seleccionar varios albaránes.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(buscadorAlbaranes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(informacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(buscadorAlbaranes, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int cantidadFilas = tablaAlbaranes.getSelectedRowCount(); //SABER CUANTAS FILAS ESTAN SELECIONADAS
        int filaSeleccionda = tablaAlbaranes.getSelectedRow(); // Fila SELECCIONADA

        if (cantidadFilas == 1) {
            int codigo = Integer.parseInt(tablaAlbaranes.getValueAt(filaSeleccionda, 0).toString());
            String codCliente = tablaAlbaranes.getValueAt(filaSeleccionda, 1).toString();
            int codPedido = Integer.parseInt(tablaAlbaranes.getValueAt(filaSeleccionda, 2).toString());
            String fecha = tablaAlbaranes.getValueAt(filaSeleccionda, 3).toString();

            Object[] fila = {codigo, codCliente, codPedido, fecha};
            Ven_factura.dtmFactura.addRow(fila);
        } else {
            int[] cantidadDeFilas = tablaAlbaranes.getSelectedRows();

            for (int i = 0; i < cantidadDeFilas.length; i++) {
                int codigo = Integer.parseInt(tablaAlbaranes.getValueAt(i, 0).toString());
                String codCliente = tablaAlbaranes.getValueAt(i, 1).toString();
                int codPedido = Integer.parseInt(tablaAlbaranes.getValueAt(i, 2).toString());
                String fecha = tablaAlbaranes.getValueAt(i, 3).toString();

                Object[] fila = {codigo, codCliente, codPedido, fecha};
                Ven_factura.dtmFactura.addRow(fila);
            }
        }

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane buscadorAlbaranes;
    private javax.swing.JLabel informacion;
    private javax.swing.JLabel informacion2;
    private javax.swing.JButton jButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaAlbaranes;
    // End of variables declaration//GEN-END:variables

}
