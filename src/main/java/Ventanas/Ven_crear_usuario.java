package Ventanas;

import Conexiones.Con_usuario;
import Modelos.Usuarios;
import Utils.GenerarCodigo;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Iván Pérez
 */
public class Ven_crear_usuario extends JInternalFrame {

    private Con_usuario objConUsuarios;
    private GenerarCodigo objGenCod;
    private DefaultTableModel dtmUsuario;

    public Ven_crear_usuario() {
        initComponents();
        objConUsuarios = new Con_usuario();
        objGenCod = new GenerarCodigo();

        bloquearBotones(false);
        TFCodigo.setEnabled(false);
        cargaDatosUsuarios("");
    }

    private void bloquearBotones(boolean bloquear) {
        botonGuardar.setEnabled(bloquear);
        botonActualizar.setEnabled(bloquear);

        TFUsuario.setEnabled(bloquear);
        TFNombre.setEnabled(bloquear);
        TFApellidos.setEditable(bloquear);
        TFContraseña.setEnabled(bloquear);
        jComboRol.setEnabled(bloquear);
    }

    private void limpiarDatos() {
        TFUsuario.setText("");
        TFNombre.setText("");
        TFApellidos.setText("");
        TFContraseña.setText("");

    }

    private void generarCodigoUsuario() {
        int codUsuario = objConUsuarios.codigoUsuarios();
        int numero = objGenCod.generarCod(codUsuario);

        TFCodigo.setText(codUsuario != 0 ? String.valueOf(numero) : "1");
    }

    private void cargaDatosUsuarios(String buscar) {
        String[] nombreTablas = {"Codigo", "Usuario", "Nombre", "Apellidos", "Contraseña", "Rol"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        dtmUsuario = new DefaultTableModel(null, nombreTablas);
        tablaArticulos.setModel(dtmUsuario);

        Object[] columna = new Object[nombreTablas.length];

        ArrayList<Usuarios> arUsuarios = new ArrayList<>();
        arUsuarios = objConUsuarios.mostrarUsuarios(buscar);

        for (int i = 0; i < arUsuarios.size(); i++) {
            columna[0] = arUsuarios.get(i).getCod_usuario();
            columna[1] = arUsuarios.get(i).getUsuario();
            columna[2] = arUsuarios.get(i).getNombre();
            columna[3] = arUsuarios.get(i).getApellidos();
            columna[4] = arUsuarios.get(i).getContraseña();
            columna[5] = objConUsuarios.mostrarNombreRol(arUsuarios.get(i).getRol());// SUBCONSULTA
            dtmUsuario.addRow(columna);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraHerramientasClientes = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        botonGuardar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        PANEL_detalle_trabajador = new javax.swing.JPanel();
        TFCodigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        TFNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TFApellidos = new javax.swing.JTextField();
        TFContraseña = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboRol = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        TFUsuario = new javax.swing.JTextField();
        PANEL_buscar_trabajador = new javax.swing.JPanel();
        buscadorArticulos = new javax.swing.JScrollPane();
        tablaArticulos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        TFBuscar = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Trabajadores");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/iconCliente.png"))); // NOI18N
        setMaximumSize(null);
        setMinimumSize(null);

        barraHerramientasClientes.setRollover(true);
        barraHerramientasClientes.setBorderPainted(false);
        barraHerramientasClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonNuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/nuevo.png"))); // NOI18N
        botonNuevo.setText("Nuevo");
        botonNuevo.setFocusable(false);
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevo.setMaximumSize(new java.awt.Dimension(60, 60));
        botonNuevo.setMinimumSize(new java.awt.Dimension(60, 60));
        botonNuevo.setPreferredSize(new java.awt.Dimension(60, 60));
        botonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });
        barraHerramientasClientes.add(botonNuevo);

        botonEliminar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/eliminar.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setFocusable(false);
        botonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonEliminar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonEliminar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        barraHerramientasClientes.add(botonEliminar);
        barraHerramientasClientes.add(jSeparator2);

        botonGuardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/guardar.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setFocusable(false);
        botonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonGuardar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonGuardar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        barraHerramientasClientes.add(botonGuardar);

        botonActualizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/actualizar.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setFocusable(false);
        botonActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonActualizar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonActualizar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonActualizar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        barraHerramientasClientes.add(botonActualizar);
        barraHerramientasClientes.add(jSeparator3);

        PANEL_detalle_trabajador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TRABAJADORES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        PANEL_detalle_trabajador.setMaximumSize(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/crear.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código:");
        jLabel1.setMaximumSize(new java.awt.Dimension(40, 15));
        jLabel1.setMinimumSize(new java.awt.Dimension(40, 15));
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 15));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jLabel2.setMaximumSize(new java.awt.Dimension(40, 15));
        jLabel2.setMinimumSize(new java.awt.Dimension(40, 15));
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 15));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contraseña:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de usuario:");

        jComboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trabajador", "Administrador" }));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Usuario");
        jLabel8.setMaximumSize(new java.awt.Dimension(40, 15));
        jLabel8.setMinimumSize(new java.awt.Dimension(40, 15));
        jLabel8.setPreferredSize(new java.awt.Dimension(40, 15));

        javax.swing.GroupLayout PANEL_detalle_trabajadorLayout = new javax.swing.GroupLayout(PANEL_detalle_trabajador);
        PANEL_detalle_trabajador.setLayout(PANEL_detalle_trabajadorLayout);
        PANEL_detalle_trabajadorLayout.setHorizontalGroup(
            PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_detalle_trabajadorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addGroup(PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_detalle_trabajadorLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PANEL_detalle_trabajadorLayout.createSequentialGroup()
                                .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
                            .addGroup(PANEL_detalle_trabajadorLayout.createSequentialGroup()
                                .addComponent(jSeparator1)
                                .addGap(10, 10, 10))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_detalle_trabajadorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(TFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_detalle_trabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_detalle_trabajadorLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_detalle_trabajadorLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(TFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_detalle_trabajadorLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(TFContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_detalle_trabajadorLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jComboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        PANEL_detalle_trabajadorLayout.setVerticalGroup(
            PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_detalle_trabajadorLayout.createSequentialGroup()
                .addGroup(PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(PANEL_detalle_trabajadorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(PANEL_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        PANEL_buscar_trabajador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        PANEL_buscar_trabajador.setMaximumSize(null);

        tablaArticulos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaArticulos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaArticulos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaArticulosMouseClicked(evt);
            }
        });
        buscadorArticulos.setViewportView(tablaArticulos);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Buscar por palabras: ");

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout PANEL_buscar_trabajadorLayout = new javax.swing.GroupLayout(PANEL_buscar_trabajador);
        PANEL_buscar_trabajador.setLayout(PANEL_buscar_trabajadorLayout);
        PANEL_buscar_trabajadorLayout.setHorizontalGroup(
            PANEL_buscar_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_buscar_trabajadorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_buscar_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscadorArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(PANEL_buscar_trabajadorLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TFBuscar)))
                .addGap(15, 15, 15))
        );
        PANEL_buscar_trabajadorLayout.setVerticalGroup(
            PANEL_buscar_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_buscar_trabajadorLayout.createSequentialGroup()
                .addGroup(PANEL_buscar_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(buscadorArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PANEL_detalle_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(PANEL_buscar_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(PANEL_detalle_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PANEL_buscar_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        bloquearBotones(true);
        limpiarDatos();
        generarCodigoUsuario();
        TFUsuario.requestFocus();
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        //Boton eliminar registro familia
        int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "IMPORTANTE", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (seleccion == 0) {
            int codigoUser = Integer.parseInt(TFCodigo.getText());
            objConUsuarios.eliminarUsuario(codigoUser);
            cargaDatosUsuarios("");
            JOptionPane.showMessageDialog(this, "Datos eliminados.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        //Boton guardar registro familia
        int codUser = Integer.parseInt(TFCodigo.getText());
        String usuario = TFUsuario.getText(),
                nombre = TFNombre.getText(),
                apellidos = TFApellidos.getText(),
                pass = TFContraseña.getText(),
                combo = jComboRol.getSelectedItem().toString();
        int rol = objConUsuarios.mostrarNombreRol(combo);

        boolean comprobacion = objConUsuarios.ingresoUsuarios(codUser, usuario, nombre, apellidos, pass, rol);
        if (comprobacion == true) {
            JOptionPane.showMessageDialog(this, "Datos guardados con exito.", "Información", JOptionPane.INFORMATION_MESSAGE);
            cargaDatosUsuarios("");
            bloquearBotones(false);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // Boton actualizar
        int codUser = Integer.parseInt(TFCodigo.getText());
        String usuario = TFUsuario.getText(),
                nombre = TFNombre.getText(),
                apellidos = TFApellidos.getText(),
                pass = TFContraseña.getText(),
                combo = jComboRol.getSelectedItem().toString();
        int rol = objConUsuarios.mostrarNombreRol(jComboRol.getSelectedItem().toString()); //SUBCONSULTA

        boolean comprobacion = objConUsuarios.actualizarUsuarios(codUser, usuario, nombre, apellidos, pass, rol);
        if (comprobacion != true) {
            JOptionPane.showMessageDialog(this, "Datos guardados con exito.", "Información", JOptionPane.INFORMATION_MESSAGE);
            cargaDatosUsuarios("");
            bloquearBotones(false);
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void tablaArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArticulosMouseClicked
        int filaSelecionada = tablaArticulos.rowAtPoint(evt.getPoint());
        bloquearBotones(true);
        botonGuardar.setEnabled(false);

        TFCodigo.setText(tablaArticulos.getValueAt(filaSelecionada, 0).toString());
        TFUsuario.setText(tablaArticulos.getValueAt(filaSelecionada, 1).toString());
        TFNombre.setText(tablaArticulos.getValueAt(filaSelecionada, 2).toString());
        TFApellidos.setText(tablaArticulos.getValueAt(filaSelecionada, 3).toString());
        TFContraseña.setText(tablaArticulos.getValueAt(filaSelecionada, 4).toString());
    }//GEN-LAST:event_tablaArticulosMouseClicked

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        cargaDatosUsuarios(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANEL_buscar_trabajador;
    private javax.swing.JPanel PANEL_detalle_trabajador;
    private javax.swing.JTextField TFApellidos;
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JTextField TFCodigo;
    private javax.swing.JTextField TFContraseña;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFUsuario;
    private javax.swing.JToolBar barraHerramientasClientes;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JScrollPane buscadorArticulos;
    private javax.swing.JComboBox<String> jComboRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTable tablaArticulos;
    // End of variables declaration//GEN-END:variables
}
