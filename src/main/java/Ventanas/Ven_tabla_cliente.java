package Ventanas;

import Conexiones.Con_cliente;
import Conexiones.Con_localidad_prov_pais;
import Modelos.Cliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Ven_tabla_cliente extends javax.swing.JInternalFrame {

    private DefaultTableModel dtmArticulos;
    private Con_cliente objConexionClientes;
    private Con_localidad_prov_pais objLocal;
    private String nombreClase;

    public Ven_tabla_cliente(String nombreClase) {
        initComponents();
        objConexionClientes = new Con_cliente();
        objLocal = new Con_localidad_prov_pais();
        this.nombreClase = nombreClase;

        cargaDeDatosClientes("");
    }

    private void cargaDeDatosClientes(String buscar) {
        String[] nombreTablas = {"Cod", "Nombre", "N. Comercial", "NIF", "C.Postal", "Dirreción", "Localidad", "Telefono", "Email"}; //Cargamos en un array el nombre que tendran nuestras columnas.
        dtmArticulos = new DefaultTableModel(null, nombreTablas);
        tablaClientes.setModel(dtmArticulos);

        Object[] fila = new Object[nombreTablas.length];

        ArrayList<Cliente> arCliente = new ArrayList<Cliente>();
        arCliente = objConexionClientes.mostrarClientesYBusqueda(buscar);

        for (int i = 0; i < arCliente.size(); i++) {
            fila[0] = arCliente.get(i).getCodClientes();
            fila[1] = arCliente.get(i).getNombre();
            fila[2] = arCliente.get(i).getNombreComercial();
            fila[3] = arCliente.get(i).getNif();
            fila[4] = arCliente.get(i).getCodPostal();
            fila[5] = arCliente.get(i).getDirFiscal();
            fila[6] = objLocal.consultarLocalidadNombre(arCliente.get(i).getLocalidad()); //Integer.parseInt
            fila[7] = arCliente.get(i).getTelf();
            fila[8] = arCliente.get(i).getEmail();
            dtmArticulos.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buscadorClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        TFBuscar = new javax.swing.JTextField();
        informacion = new javax.swing.JLabel();
        informacion2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setTitle("Listado Clientes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/iconCliente.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por palabras: ");

        tablaClientes.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        buscadorClientes.setViewportView(tablaClientes);

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

        informacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion.setText("CLIENTES");

        informacion2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        informacion2.setText("Clic para seleccionar cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(TFBuscar)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buscadorClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(informacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(328, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscadorClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        cargaDeDatosClientes(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        int fila = tablaClientes.getSelectedRow();
        if (evt.getClickCount() == 1) {
            switch (nombreClase) {
                case "Ven_pedido":
                    Ven_pedido.TFCodClie.setText(tablaClientes.getValueAt(fila, 0).toString());
                    Ven_pedido.TFNombreC.setText(tablaClientes.getValueAt(fila, 2).toString());
                    Ven_pedido.TFDir.setText(tablaClientes.getValueAt(fila, 5).toString() + " , " + tablaClientes.getValueAt(fila, 6).toString() + " " + tablaClientes.getValueAt(fila, 4).toString());
                    Ven_pedido.TFTel.setText(tablaClientes.getValueAt(fila, 7).toString());
                    break;
                case "Ven_factura":
                    Ven_factura.TFCodClie.setText(tablaClientes.getValueAt(fila, 0).toString());
                    Ven_factura.TFNombreC.setText(tablaClientes.getValueAt(fila, 2).toString());
                    Ven_factura.TFDir.setText(tablaClientes.getValueAt(fila, 5).toString() + " , " + tablaClientes.getValueAt(fila, 6).toString() + " " + tablaClientes.getValueAt(fila, 4).toString());
                    Ven_factura.TFTel.setText(tablaClientes.getValueAt(fila, 7).toString());
                    break;
            }
        }
        dispose();
    }//GEN-LAST:event_tablaClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JScrollPane buscadorClientes;
    private javax.swing.JLabel informacion;
    private javax.swing.JLabel informacion2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
