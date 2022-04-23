package Ventanas;

import Conexiones.Con_clientes;
import Conexiones.Con_articulos;
import Modelos.Articulos;
import Modelos.Clientes;
import static Ventanas.Ven_principal.escritorio;
import java.util.ArrayList;
import javax.swing.JInternalFrame;

/**
 * @author Iván Pérez
 */
public class Ven_pedidos extends javax.swing.JInternalFrame {

    protected final Con_clientes objConexionClientes = new Con_clientes();
    protected final Con_articulos objConexionArticulos = new Con_articulos();

    public Ven_pedidos() {
        initComponents();
        bloquearCampos(false);
        bloquearBotones(false);
    }

    protected void bloquearCampos(boolean bloquear) {
        TFnumPedido.setEnabled(bloquear);
        TFDate.setEnabled(bloquear);

        //Cliente
        TFCodClie.setEnabled(bloquear);
        TFNombreC.setEnabled(bloquear);
        TFDir.setEnabled(bloquear);
        TFTel.setEnabled(bloquear);

        //Articulos
        TFCodProd.setEnabled(bloquear);
        TFNombreProc.setEnabled(bloquear);
        TFPrecio.setEnabled(bloquear);
        TFIva.setEnabled(bloquear);
        TFStock.setEnabled(bloquear);
        TFCantidad.setEnabled(bloquear);

    }

    protected void bloquearBotones(boolean bloquear) {
        botonLimpiar.setEnabled(bloquear);

        BotonBuscarCliente.setEnabled(bloquear);
        botonBuscarProducto.setEnabled(bloquear);
        botonAgregarProc.setEnabled(bloquear);
        botonEliminarProc.setEnabled(bloquear);
    }

    protected void generarNumeroPedido() {

    }

    protected void cargarCamposClientes(String datos) {
        ArrayList<Clientes> arraylistClie;
        arraylistClie = objConexionClientes.mostrarClientesYBusqueda(datos);

        for (Clientes cliente : arraylistClie) {
            TFCodClie.setText(Integer.toString(cliente.getCod_cliente()));
            TFNombreC.setText(cliente.getNombre_comercial());
            TFDir.setText(cliente.getDirrecion() + " , " + cliente.getCiudad() + " "+ cliente.getCodigo_postal());
            TFTel.setText(cliente.getTelefono());
        }
    }
    
     protected void cargarCamposArticulos(String datos) {
        ArrayList<Articulos> arraylistArtciulos;
        arraylistArtciulos = objConexionArticulos.mostrarArticulosYBusqueda(datos);

        for (Articulos articulos : arraylistArtciulos) {
            TFCodProd.setText(Integer.toString(articulos.getCod_articulo()));
            TFNombreProc.setText(articulos.getNombre_producto());
            TFIva.setText(Integer.toString(articulos.getIVA()));
            TFStock.setText(Integer.toString(articulos.getStock()));
        }
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraHerramientas = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        barraHerramientas1 = new javax.swing.JToolBar();
        botonCalcular = new javax.swing.JButton();
        botonRealizarPedido = new javax.swing.JButton();
        PANEL_cliente = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JLabel();
        TFCodClie = new javax.swing.JTextField();
        txtNombreS = new javax.swing.JLabel();
        TFNombreC = new javax.swing.JTextField();
        txtDir = new javax.swing.JLabel();
        TFDir = new javax.swing.JTextField();
        txtCodigo1 = new javax.swing.JLabel();
        TFTel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BotonBuscarCliente = new javax.swing.JButton();
        PANEL_carrito = new javax.swing.JPanel();
        listadoVentas = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        botonAgregarProc = new javax.swing.JButton();
        botonEliminarProc = new javax.swing.JButton();
        txtCod = new javax.swing.JLabel();
        TFCodProd = new javax.swing.JTextField();
        TFPrecio = new javax.swing.JTextField();
        TFStock = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JLabel();
        txtCantidad2 = new javax.swing.JLabel();
        TFIva = new javax.swing.JTextField();
        TFCantidad = new javax.swing.JTextField();
        txtCantidad1 = new javax.swing.JLabel();
        TFNombreProc = new javax.swing.JTextField();
        txtNombre = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        botonBuscarProducto = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        TFTotal = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        TFSubtotal = new javax.swing.JTextField();
        informacion2 = new javax.swing.JLabel();
        TFnumPedido = new javax.swing.JTextField();
        informacion4 = new javax.swing.JLabel();
        TFDate = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pedidos");

        barraHerramientas.setFloatable(false);
        barraHerramientas.setRollover(true);
        barraHerramientas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        barraHerramientas.add(botonNuevo);

        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/deshacer.png"))); // NOI18N
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setFocusable(false);
        botonLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonLimpiar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonLimpiar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonLimpiar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
        barraHerramientas.add(botonLimpiar);
        barraHerramientas.add(jSeparator2);

        barraHerramientas1.setFloatable(false);
        barraHerramientas1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        barraHerramientas1.setRollover(true);
        barraHerramientas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonCalcular.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/calcularVenta.png"))); // NOI18N
        botonCalcular.setText("Calcular Pedido");
        botonCalcular.setFocusable(false);
        botonCalcular.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonCalcular.setMaximumSize(new java.awt.Dimension(160, 40));
        botonCalcular.setMinimumSize(new java.awt.Dimension(160, 40));
        botonCalcular.setPreferredSize(new java.awt.Dimension(160, 40));
        barraHerramientas1.add(botonCalcular);

        botonRealizarPedido.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonRealizarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/realizarVenta.png"))); // NOI18N
        botonRealizarPedido.setText("Realizar Pedido");
        botonRealizarPedido.setFocusable(false);
        botonRealizarPedido.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonRealizarPedido.setMaximumSize(new java.awt.Dimension(160, 40));
        botonRealizarPedido.setMinimumSize(new java.awt.Dimension(160, 40));
        botonRealizarPedido.setPreferredSize(new java.awt.Dimension(160, 40));
        barraHerramientas1.add(botonRealizarPedido);

        PANEL_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo.setText("Código:");

        txtNombreS.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombreS.setText("Nombre Comerical:");

        txtDir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtDir.setText("Dirrección:");

        txtCodigo1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo1.setText("Télefono:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/buscarClie.png"))); // NOI18N

        BotonBuscarCliente.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BotonBuscarCliente.setText("Buscar");
        BotonBuscarCliente.setToolTipText("Buscar Cliente");
        BotonBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_clienteLayout = new javax.swing.GroupLayout(PANEL_cliente);
        PANEL_cliente.setLayout(PANEL_clienteLayout);
        PANEL_clienteLayout.setHorizontalGroup(
            PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodClie, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFNombreC)
                            .addComponent(txtNombreS, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                    .addComponent(TFDir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TFTel))
                .addGap(15, 15, 15)
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(BotonBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        PANEL_clienteLayout.setVerticalGroup(
            PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(TFCodClie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                                .addComponent(txtNombreS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(TFNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(BotonBuscarCliente)))
                .addContainerGap())
        );

        PANEL_carrito.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        listadoVentas.setViewportView(tablaVentas);

        botonAgregarProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/mas.png"))); // NOI18N
        botonAgregarProc.setToolTipText("Agregar Producto");
        botonAgregarProc.setBorderPainted(false);
        botonAgregarProc.setContentAreaFilled(false);
        botonAgregarProc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAgregarProc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/mas2.png"))); // NOI18N
        botonAgregarProc.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/mas2.png"))); // NOI18N
        botonAgregarProc.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/mas2.png"))); // NOI18N

        botonEliminarProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/menos.png"))); // NOI18N
        botonEliminarProc.setToolTipText("Eliminar");
        botonEliminarProc.setBorderPainted(false);
        botonEliminarProc.setContentAreaFilled(false);
        botonEliminarProc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarProc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/menos2.png"))); // NOI18N
        botonEliminarProc.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/menos2.png"))); // NOI18N
        botonEliminarProc.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/menos2.png"))); // NOI18N

        txtCod.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCod.setText("Código:");

        txtCantidad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCantidad.setText("Stock:");

        txtCantidad2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCantidad2.setText("IVA:");

        txtCantidad1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCantidad1.setText("Cantidad:");

        txtNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre.setText("Descripción del Producto:");

        txtPrecio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtPrecio.setText("Precio");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/busProc.png"))); // NOI18N

        botonBuscarProducto.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botonBuscarProducto.setText("Buscar");
        botonBuscarProducto.setToolTipText("Buscar Productos");
        botonBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_carritoLayout = new javax.swing.GroupLayout(PANEL_carrito);
        PANEL_carrito.setLayout(PANEL_carritoLayout);
        PANEL_carritoLayout.setHorizontalGroup(
            PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_carritoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_carritoLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(PANEL_carritoLayout.createSequentialGroup()
                        .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listadoVentas)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_carritoLayout.createSequentialGroup()
                                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PANEL_carritoLayout.createSequentialGroup()
                                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFNombreProc)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_carritoLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TFIva, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(240, 240, 240)
                                        .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TFStock)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TFPrecio)
                                        .addComponent(txtCantidad1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                    .addComponent(TFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_carritoLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonAgregarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonEliminarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_carritoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(botonBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15))))
        );
        PANEL_carritoLayout.setVerticalGroup(
            PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_carritoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_carritoLayout.createSequentialGroup()
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFNombreProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_carritoLayout.createSequentialGroup()
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_carritoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(botonBuscarProducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_carritoLayout.createSequentialGroup()
                        .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PANEL_carritoLayout.createSequentialGroup()
                        .addComponent(txtCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PANEL_carritoLayout.createSequentialGroup()
                        .addComponent(botonAgregarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setText("Total:");

        TFTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TFTotal.setForeground(new java.awt.Color(255, 51, 51));
        TFTotal.setText("0.0");
        TFTotal.setDisabledTextColor(new java.awt.Color(0, 51, 153));
        TFTotal.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setText("Subtotal:");

        TFSubtotal.setText("0.0");
        TFSubtotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TFSubtotal.setEnabled(false);

        informacion2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion2.setText("Nº de pedido:");

        informacion4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion4.setText("Fecha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(barraHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PANEL_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PANEL_carrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TFnumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TFDate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraHerramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(barraHerramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(TFnumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(informacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(TFDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addComponent(PANEL_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(PANEL_carrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // BOTON NUEVO //
        bloquearBotones(true);
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // BOTON LIMPIAR //

    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void BotonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarClienteActionPerformed
        // BOTON BUSCAR CLIENTE
        Ven_tabla_cliente objTabClie = new Ven_tabla_cliente();
        Ven_principal.escritorio.add(objTabClie).setVisible(true);

        String codigo = objTabClie.codigo;
        cargarCamposClientes(codigo);
    }//GEN-LAST:event_BotonBuscarClienteActionPerformed

    private void botonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProductoActionPerformed
        Ven_tabla_articulos objTablaArticulos = new Ven_tabla_articulos();
        Ven_principal.escritorio.add(objTablaArticulos).setVisible(true);

        String codigo = objTablaArticulos.codigo;
        cargarCamposArticulos(codigo);
        TFCantidad.setEnabled(true);
    }//GEN-LAST:event_botonBuscarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscarCliente;
    private javax.swing.JPanel PANEL_carrito;
    private javax.swing.JPanel PANEL_cliente;
    private javax.swing.JTextField TFCantidad;
    private javax.swing.JTextField TFCodClie;
    private javax.swing.JTextField TFCodProd;
    private javax.swing.JTextField TFDate;
    public static javax.swing.JTextField TFDir;
    private javax.swing.JTextField TFIva;
    private javax.swing.JTextField TFNombreC;
    private javax.swing.JTextField TFNombreProc;
    private javax.swing.JTextField TFPrecio;
    private javax.swing.JTextField TFStock;
    private javax.swing.JTextField TFSubtotal;
    private javax.swing.JTextField TFTel;
    private javax.swing.JTextField TFTotal;
    private javax.swing.JTextField TFnumPedido;
    private javax.swing.JToolBar barraHerramientas;
    private javax.swing.JToolBar barraHerramientas1;
    private javax.swing.JButton botonAgregarProc;
    private javax.swing.JButton botonBuscarProducto;
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonEliminarProc;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonRealizarPedido;
    private javax.swing.JLabel informacion2;
    private javax.swing.JLabel informacion4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JScrollPane listadoVentas;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JLabel txtCantidad;
    private javax.swing.JLabel txtCantidad1;
    private javax.swing.JLabel txtCantidad2;
    private javax.swing.JLabel txtCod;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtCodigo1;
    private javax.swing.JLabel txtDir;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombreS;
    private javax.swing.JLabel txtPrecio;
    // End of variables declaration//GEN-END:variables
}