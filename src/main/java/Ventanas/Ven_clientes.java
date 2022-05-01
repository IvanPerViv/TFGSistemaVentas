package Ventanas;

import Conexiones.Con_clientes;
import Conexiones.Con_localidad_prov_pais;
import Modelos.Articulos;
import Modelos.Clientes;
import Utils.generarCodigos;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Iván Pérez
 */
public class Ven_clientes extends javax.swing.JInternalFrame {

    protected DefaultTableModel datosClientes;
    protected final String DATOVACIO = "";
    protected final Con_localidad_prov_pais objLocal = new Con_localidad_prov_pais();
    protected final Con_clientes objConexionClientes = new Con_clientes();

    public Ven_clientes() {
        initComponents();
        bloquear(false);
        cargaDeDatosClientes(DATOVACIO);
        TFCodigo.setEnabled(false);
        TFCiudad.setEnabled(false);
    }

    protected void bloquear(boolean blockeo) {
        botonCancelar.setEnabled(blockeo);
        botonGuardar.setEnabled(blockeo);
        botonActualizar.setEnabled(blockeo);
        BotonLocalidad.setEnabled(blockeo);

        TFNombre.setEnabled(blockeo);
        TFNombreComercial.setEnabled(blockeo);
        TFNif.setEnabled(blockeo);
        TFCp.setEnabled(blockeo);
        TFDir.setEnabled(blockeo);
        TFTelef.setEnabled(blockeo);
        TFEmail.setEnabled(blockeo);

    }

    protected void limpiarDatos() {
        TFCodigo.setText("");
        TFNombre.setText("");
        TFNombreComercial.setText("");
        TFNif.setText("");
        TFCp.setText("");
        TFDir.setText("");
        TFCiudad.setText("");
        TFEmail.setText("");
        TFTelef.setText("");

    }

    protected void generarCodigoCliente() {
        Con_clientes con = new Con_clientes();
        int codigoCliente = con.codigoClientes();
        if (codigoCliente != 0) {
            generarCodigos objGenCod = new generarCodigos();
            int numero = objGenCod.generarCod(codigoCliente);
            TFCodigo.setText(String.valueOf(numero));
        } else {
            TFCodigo.setText("1");
        }
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

        barraHerramientasClientes = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botonGuardar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        txtSeparacion = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        txtSeparacion1 = new javax.swing.JLabel();
        PANEL_detalle_cliente = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JLabel();
        TFCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JLabel();
        TFNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JLabel();
        TFTelef = new javax.swing.JTextField();
        txtDirrec = new javax.swing.JLabel();
        TFDir = new javax.swing.JTextField();
        txtEmail = new javax.swing.JLabel();
        TFEmail = new javax.swing.JTextField();
        TFCp = new javax.swing.JTextField();
        txtCp = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JLabel();
        TFCiudad = new javax.swing.JTextField();
        TFNombreComercial = new javax.swing.JTextField();
        txtApellidos1 = new javax.swing.JLabel();
        TFNif = new javax.swing.JTextField();
        BotonLocalidad = new javax.swing.JButton();
        PANEL_buscar_cliente = new javax.swing.JPanel();
        TFBuscar = new javax.swing.JTextField();
        buscadorClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Clientes");
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(672, 618));

        barraHerramientasClientes.setFloatable(false);
        barraHerramientasClientes.setRollover(true);
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

        botonCancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/cancelar.png"))); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.setFocusable(false);
        botonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCancelar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonCancelar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonCancelar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        barraHerramientasClientes.add(botonCancelar);
        barraHerramientasClientes.add(jSeparator1);

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
        barraHerramientasClientes.add(txtSeparacion);
        barraHerramientasClientes.add(jSeparator2);

        txtSeparacion1.setText("                                                                ");
        barraHerramientasClientes.add(txtSeparacion1);

        PANEL_detalle_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo.setText("Código:");

        txtNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre.setText("Nombre:");

        txtTelefono.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTelefono.setText("Télefono:");

        txtDirrec.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtDirrec.setText("Dirección:");

        txtEmail.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtEmail.setText("Email:");

        txtCp.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCp.setText("CP:");

        txtNombre1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre1.setText("Nombre Comercial:");

        txtCiudad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCiudad.setText("Localidad:");

        txtApellidos1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtApellidos1.setText("NIF Fiscal:");

        BotonLocalidad.setText("...");
        BotonLocalidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLocalidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_detalle_clienteLayout = new javax.swing.GroupLayout(PANEL_detalle_cliente);
        PANEL_detalle_cliente.setLayout(PANEL_detalle_clienteLayout);
        PANEL_detalle_clienteLayout.setHorizontalGroup(
            PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TFCp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFDir)
                                    .addComponent(txtDirrec, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)))
                            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFTelef)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFEmail)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(TFNombreComercial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFCiudad)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(BotonLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                        .addComponent(TFCodigo))
                                    .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13))
                            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFNif)
                                    .addComponent(txtApellidos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(230, 230, 230)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PANEL_detalle_clienteLayout.setVerticalGroup(
            PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_detalle_clienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addComponent(txtApellidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFNombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDirrec, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonLocalidad))
                        .addGroup(PANEL_detalle_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(TFTelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PANEL_detalle_clienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_detalle_clienteLayout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        PANEL_buscar_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

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
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        buscadorClientes.setViewportView(tablaClientes);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Buscar por palabras: ");

        javax.swing.GroupLayout PANEL_buscar_clienteLayout = new javax.swing.GroupLayout(PANEL_buscar_cliente);
        PANEL_buscar_cliente.setLayout(PANEL_buscar_clienteLayout);
        PANEL_buscar_clienteLayout.setHorizontalGroup(
            PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_buscar_clienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscadorClientes)
                    .addGroup(PANEL_buscar_clienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        PANEL_buscar_clienteLayout.setVerticalGroup(
            PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_buscar_clienteLayout.createSequentialGroup()
                .addGroup(PANEL_buscar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscadorClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PANEL_detalle_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(barraHerramientasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(PANEL_detalle_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(PANEL_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // BOTON CANCELAR //
        bloquear(false);
        botonNuevo.setEnabled(true);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // BOTON NUEVO //
        bloquear(true);
        limpiarDatos();
        botonNuevo.setEnabled(false);
        botonActualizar.setEnabled(false);
        generarCodigoCliente();
        TFNombre.requestFocus(); //Obtener Foco 

    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // BOTON GUARDAR //
        int codigoUser = Integer.parseInt(TFCodigo.getText());
        String nombre = TFNombre.getText();
        String nombreComercial = TFNombreComercial.getText();
        String nif = TFNif.getText();
        int codPostal = Integer.parseInt(TFCp.getText());
        String dirrecion = TFDir.getText();
        int localidad = objLocal.consultarLocalidad(TFCiudad.getText());
        int telef = Integer.parseInt(TFTelef.getText());
        String email = TFEmail.getText();

        boolean comprobacion = objConexionClientes.ingresoClientes(codigoUser, nombre, nombreComercial, nif, codPostal, dirrecion, localidad, telef, email);

        if (comprobacion == true) {
            JOptionPane.showMessageDialog(this, "Datos guardados con exito.", "", JOptionPane.INFORMATION_MESSAGE);
            cargaDeDatosClientes(DATOVACIO);
            limpiarDatos();
            bloquear(false);
            botonNuevo.setEnabled(true);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // BOTON ELIMINAR //

        int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "IMPORTANTE", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (seleccion == 0) {
            int codigoUser = Integer.parseInt(TFCodigo.getText());
            objConexionClientes.eliminarRegistroCliente(codigoUser);
            cargaDeDatosClientes(DATOVACIO);
            JOptionPane.showMessageDialog(this, "Datos eliminados.", "", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_botonEliminarActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        int filaSelecionada = tablaClientes.rowAtPoint(evt.getPoint());
        bloquear(true);
        botonGuardar.setEnabled(false);
        TFCodigo.setText(tablaClientes.getValueAt(filaSelecionada, 0).toString());
        TFNombre.setText(tablaClientes.getValueAt(filaSelecionada, 1).toString()); 
        TFNombreComercial.setText(tablaClientes.getValueAt(filaSelecionada, 2).toString());
        TFNif.setText(tablaClientes.getValueAt(filaSelecionada, 3).toString());
        TFCp.setText(tablaClientes.getValueAt(filaSelecionada, 4).toString());
        TFDir.setText(tablaClientes.getValueAt(filaSelecionada, 5).toString());
        TFCiudad.setText(tablaClientes.getValueAt(filaSelecionada, 6).toString());
        TFTelef.setText(tablaClientes.getValueAt(filaSelecionada, 7).toString());
        TFEmail.setText(tablaClientes.getValueAt(filaSelecionada, 8).toString());

    }//GEN-LAST:event_tablaClientesMouseClicked

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        //BOTON MODIFICAR
        bloquear(true);
        
        int codigoUser = Integer.parseInt(TFCodigo.getText());
        String nombre = TFNombre.getText();
        String nombreComercial = TFNombreComercial.getText();
        String nif = TFNif.getText();
        int codPostal = Integer.parseInt(TFCp.getText());
        String dirrecion = TFDir.getText();
        int localidad = objLocal.consultarLocalidad(TFCiudad.getText());
        int telef = Integer.parseInt(TFTelef.getText());
        String email = TFEmail.getText();
        
       boolean comprobacion = objConexionClientes.actualizarClientes(codigoUser, nombre, nombreComercial, nif, codPostal, dirrecion, localidad, telef, email);

        if (comprobacion != true) {
            JOptionPane.showMessageDialog(this, "Datos actualizados.", "", JOptionPane.INFORMATION_MESSAGE);
            cargaDeDatosClientes(DATOVACIO);
            bloquear(false);
            botonNuevo.setEnabled(true);
            limpiarDatos();
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        cargaDeDatosClientes(TFBuscar.getText());
    }//GEN-LAST:event_TFBuscarKeyReleased

    private void BotonLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLocalidadActionPerformed
        // Boton Localidad
        Ven_clientes_tabla_localidad objLocalidad = new Ven_clientes_tabla_localidad();
        Ven_principal.escritorio.add(objLocalidad).setVisible(true);

    }//GEN-LAST:event_BotonLocalidadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonLocalidad;
    private javax.swing.JPanel PANEL_buscar_cliente;
    private javax.swing.JPanel PANEL_detalle_cliente;
    private javax.swing.JTextField TFBuscar;
    public static javax.swing.JTextField TFCiudad;
    private javax.swing.JTextField TFCodigo;
    private javax.swing.JTextField TFCp;
    private javax.swing.JTextField TFDir;
    private javax.swing.JTextField TFEmail;
    private javax.swing.JTextField TFNif;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFNombreComercial;
    private javax.swing.JTextField TFTelef;
    private javax.swing.JToolBar barraHerramientasClientes;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JScrollPane buscadorClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JLabel txtApellidos1;
    private javax.swing.JLabel txtCiudad;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtCp;
    private javax.swing.JLabel txtDirrec;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombre1;
    private javax.swing.JLabel txtSeparacion;
    private javax.swing.JLabel txtSeparacion1;
    private javax.swing.JLabel txtTelefono;
    // End of variables declaration//GEN-END:variables
}
