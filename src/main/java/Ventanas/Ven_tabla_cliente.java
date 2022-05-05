package Ventanas;

import Conexiones.Con_clientes;
import Conexiones.Con_localidad_prov_pais;
import Modelos.Clientes;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Ven_tabla_cliente extends javax.swing.JInternalFrame {

    protected DefaultTableModel datosClientes;
    protected final String DATOVACIO = "";
    protected Con_clientes objConexionClientes;
    protected Con_localidad_prov_pais objLocal;

    public Ven_tabla_cliente() {
        initComponents();
        objConexionClientes = new Con_clientes();
        objLocal = new Con_localidad_prov_pais();
        
        cargaDeDatosClientes(DATOVACIO);
    }

    protected void cargaDeDatosClientes(String buscar) {
        String[] nombreTablas = {"Cod", "Nombre", "N. Comercial", "NIF", "C.Postal", "Dirreción", "Localidad", "Telefono", "Email"}; //Cargamos en un array el nombre que tendran nuestras columnas.
        datosClientes = new DefaultTableModel(null, nombreTablas);
        tablaClientes.setModel(datosClientes);

        Object[] fila = new Object[nombreTablas.length];

        ArrayList<Clientes> clieArray = new ArrayList<Clientes>();
        clieArray = objConexionClientes.mostrarClientesYBusqueda(buscar);

        for (int i = 0; i < clieArray.size(); i++) {
            fila[0] = clieArray.get(i).getCodClientes();
            fila[1] = clieArray.get(i).getNombre();
            fila[2] = clieArray.get(i).getNombreComercial();
            fila[3] = clieArray.get(i).getNif();
            fila[4] = clieArray.get(i).getCodPostal();
            fila[5] = clieArray.get(i).getDirFiscal();
            fila[6] = objLocal.consultarLocalidadNombre(clieArray.get(i).getLocalidad()); //Integer.parseInt
            fila[7] = clieArray.get(i).getTelf();
            fila[8] = clieArray.get(i).getEmail();
            datosClientes.addRow(fila);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(328, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
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
            Ven_pedidos.TFCodClie.setText(tablaClientes.getValueAt(fila, 0).toString());
            Ven_pedidos.TFNombreC.setText(tablaClientes.getValueAt(fila, 2).toString());
            Ven_pedidos.TFDir.setText(tablaClientes.getValueAt(fila, 5).toString() + " , " + tablaClientes.getValueAt(fila, 6).toString() + " " + tablaClientes.getValueAt(fila, 4).toString());
            Ven_pedidos.TFTel.setText(tablaClientes.getValueAt(fila, 7).toString());
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
