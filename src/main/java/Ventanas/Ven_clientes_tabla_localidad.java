package Ventanas;

import Conexiones.Con_localidad_prov_pais;
import Modelos.Localidad;
import Utils.generarCodigos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iván Pérez
 */
public class Ven_clientes_tabla_localidad extends javax.swing.JInternalFrame {

    protected Con_localidad_prov_pais objLocalidad;
    protected generarCodigos objGenCod;
    protected DefaultTableModel datosLocalidades;

    public Ven_clientes_tabla_localidad() {
        initComponents();
        objLocalidad = new Con_localidad_prov_pais();
        objGenCod = new generarCodigos();
        
        cargarDatosLocalidad("");
    }

    protected void cargarDatosLocalidad(String buscar) {
        String[] nombreTablas = {"Cod", "Nombre ciudad", "Provincia"}; //Cargamos en un array el nombre que tendran nuestras columnas.
        datosLocalidades = new DefaultTableModel(null, nombreTablas);
        tablaLocalidades.setModel(datosLocalidades);

        Object[] fila = new Object[nombreTablas.length];

        ArrayList<Localidad> artLocal = new ArrayList<Localidad>();
        artLocal = objLocalidad.MostrarLocalidad(buscar);

        for (int i = 0; i < artLocal.size(); i++) {
            fila[0] = artLocal.get(i).getCodLocalidad();
            fila[1] = artLocal.get(i).getNombreCiudad();
            fila[2] = objLocalidad.buscarProvinciaPorCodigo(artLocal.get(i).getCodProv());
            datosLocalidades.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_buscar_localidad = new javax.swing.JPanel();
        TFBuscar = new javax.swing.JTextField();
        buscardorLocalidad = new javax.swing.JScrollPane();
        tablaLocalidades = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        informacion2 = new javax.swing.JLabel();
        informacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setTitle("Localidad");
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(495, 448));

        panel_buscar_localidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

        tablaLocalidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaLocalidades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaLocalidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLocalidadesMouseClicked(evt);
            }
        });
        buscardorLocalidad.setViewportView(tablaLocalidades);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por palabras: ");

        informacion2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        informacion2.setText("Clic para seleccionar cliente");

        javax.swing.GroupLayout panel_buscar_localidadLayout = new javax.swing.GroupLayout(panel_buscar_localidad);
        panel_buscar_localidad.setLayout(panel_buscar_localidadLayout);
        panel_buscar_localidadLayout.setHorizontalGroup(
            panel_buscar_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_buscar_localidadLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_buscar_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_buscar_localidadLayout.createSequentialGroup()
                        .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_buscar_localidadLayout.createSequentialGroup()
                        .addGroup(panel_buscar_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscardorLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(panel_buscar_localidadLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
        );
        panel_buscar_localidadLayout.setVerticalGroup(
            panel_buscar_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_buscar_localidadLayout.createSequentialGroup()
                .addGroup(panel_buscar_localidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscardorLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        informacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion.setText("Listado de Localidades.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_buscar_localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(informacion, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addComponent(jSeparator1)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(panel_buscar_localidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaLocalidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLocalidadesMouseClicked
        int filaSelecionada = tablaLocalidades.getSelectedRow();
        if (evt.getClickCount() == 1) {
            Ven_clientes.TFCiudad.setText(tablaLocalidades.getValueAt(filaSelecionada, 1).toString());
        }
        dispose();
    }//GEN-LAST:event_tablaLocalidadesMouseClicked

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        cargarDatosLocalidad(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JScrollPane buscardorLocalidad;
    private javax.swing.JLabel informacion;
    private javax.swing.JLabel informacion2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panel_buscar_localidad;
    private javax.swing.JTable tablaLocalidades;
    // End of variables declaration//GEN-END:variables
}
