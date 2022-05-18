package Ventanas;

import Conexiones.Con_articulo;
import Modelos.Articulo;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Ven_tabla_articulo extends javax.swing.JInternalFrame {

    private DefaultTableModel mostrarClientes;
    private Con_articulo objConexionClientes;

    public Ven_tabla_articulo() {
        initComponents();
        objConexionClientes = new Con_articulo();
        
        cargaDeDatosArticulos("");
    }

    private void cargaDeDatosArticulos(String buscar) {

        String[] nombreTablas = {"CÓDIGO", "PRODUCTO", "FAMILIA", "PRECIO", "IVA", "STOCK"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        DefaultTableModel art = new DefaultTableModel(null, nombreTablas);
        tablaArt.setModel(art);

        Object[] columna = new Object[nombreTablas.length];

        ArrayList<Articulo> arArticulo = new ArrayList<Articulo>();
        arArticulo = objConexionClientes.mostrarArticulosYBusqueda(buscar);

        for (int i = 0; i < arArticulo.size(); i++) {
            columna[0] = arArticulo.get(i).getCod_articulo();
            columna[1] = arArticulo.get(i).getNombre_producto();
            columna[2] = objConexionClientes.mostrarFamiliaArticulos(arArticulo.get(i).getFamilia()); // CONSULTA NOMBRE DE LA FAMILIA
            columna[3] = arArticulo.get(i).getPrecio_compra();
            columna[4] = arArticulo.get(i).getIVA();
            columna[5] = arArticulo.get(i).getStock();
            art.addRow(columna);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        TFBuscar = new javax.swing.JTextField();
        buscadorClientes = new javax.swing.JScrollPane();
        tablaArt = new javax.swing.JTable();
        informacion2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Listado articulos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/iconArticulos.png"))); // NOI18N

        informacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion.setText("ARTICULOS");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por palabras: ");

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

        tablaArt.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaArt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaArt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaArt.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaArt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaArtMouseClicked(evt);
            }
        });
        buscadorClientes.setViewportView(tablaArt);

        informacion2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        informacion2.setText("Clic para seleccionar cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buscadorClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(informacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(TFBuscar)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
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
        cargaDeDatosArticulos(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased

    private void tablaArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArtMouseClicked
        int numFila = tablaArt.getSelectedRow();
        if (evt.getClickCount() == 1) {
            Ven_pedido.TFCodProd.setText(tablaArt.getValueAt(numFila, 0).toString());
            Ven_pedido.TFNombreProc.setText(tablaArt.getValueAt(numFila, 1).toString());
            Ven_pedido.TFPrecio.setText(tablaArt.getValueAt(numFila, 3).toString());
            Ven_pedido.TFIva.setText(tablaArt.getValueAt(numFila, 4).toString());
            Ven_pedido.TFStock.setText(tablaArt.getValueAt(numFila, 5).toString());

            dispose();
        }
    }//GEN-LAST:event_tablaArtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JScrollPane buscadorClientes;
    private javax.swing.JLabel informacion;
    private javax.swing.JLabel informacion2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaArt;
    // End of variables declaration//GEN-END:variables
}
