package Ventanas;

import Conexiones.Con_articulos;
import Modelos.Articulos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Ven_tabla_articulos extends javax.swing.JInternalFrame {

    protected DefaultTableModel mostrarClientes;
    protected final String DATOVACIO = "";
    protected final Con_articulos objConexionClientes = new Con_articulos();
    protected static String codigo;

    public Ven_tabla_articulos() {
        initComponents();
        cargaDeDatosArticulos(DATOVACIO);
    }

    protected void cargaDeDatosArticulos(String buscar) {

        String[] nombreTablas = {"Codigo", "Producto", "Precio", "IVA", "Stock"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        DefaultTableModel art = new DefaultTableModel(null, nombreTablas);
        tablaArt.setModel(art);

        Object[] fila = new Object[5];

        ArrayList<Articulos> artArry = new ArrayList<Articulos>();
        artArry = objConexionClientes.mostrarArticulosYBusqueda(buscar);

        for (int i = 0; i < artArry.size(); i++) {
            fila[0] = artArry.get(i).getCod_articulo();
            fila[1] = artArry.get(i).getNombre_producto();
            fila[2] = artArry.get(i).getPrecio_compra();
            fila[3] = artArry.get(i).getIVA();
            fila[4] = artArry.get(i).getStock();
            art.addRow(fila);
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

        informacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion.setText("ARTICULOS");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por palabras: ");

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

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
                            .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0))))
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
        cargaDeDatosArticulos(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased

    private void tablaArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArtMouseClicked
        int fila = tablaArt.getSelectedRow();
        if (evt.getClickCount() == 1) {
            Ven_pedidos.TFCodProd.setText(tablaArt.getValueAt(fila, 0).toString());
            Ven_pedidos.TFNombreProc.setText(tablaArt.getValueAt(fila, 1).toString());
            Ven_pedidos.TFPrecio.setText(tablaArt.getValueAt(fila, 2).toString());
            Ven_pedidos.TFIva.setText(tablaArt.getValueAt(fila, 3).toString());
            Ven_pedidos.TFStock.setText(tablaArt.getValueAt(fila, 4).toString());

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
