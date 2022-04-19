package Ventanas;

/**
 * @author Iván Pérez
 */
public class V_ventas extends javax.swing.JInternalFrame {

    /**
     * Creates new form V_ventas
     */
    public V_ventas() {
        initComponents();
    }
    
    public void bloquearBotones(boolean bloquear) {
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        PANEL_factura = new javax.swing.JPanel();
        txtCodigo1 = new javax.swing.JLabel();
        TFCodigo1 = new javax.swing.JTextField();
        txtCodigo2 = new javax.swing.JLabel();
        TFCodigo2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        barraHerramientas = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        botonLimpiar2 = new javax.swing.JButton();
        botonLimpiar3 = new javax.swing.JButton();
        PANEL_cliente = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JLabel();
        TFCodigo = new javax.swing.JTextField();
        botonBuscarCliente = new javax.swing.JButton();
        txtNombreS = new javax.swing.JLabel();
        TFNombreS = new javax.swing.JTextField();
        txtDir = new javax.swing.JLabel();
        TFDir = new javax.swing.JTextField();
        PANEL_producto = new javax.swing.JPanel();
        txtCod = new javax.swing.JLabel();
        TFCodProd = new javax.swing.JTextField();
        txtNombre = new javax.swing.JLabel();
        TFNombreProd = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JLabel();
        TFPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JLabel();
        TFStock = new javax.swing.JTextField();
        txtCantidad1 = new javax.swing.JLabel();
        TFCantidad = new javax.swing.JTextField();
        botonNuevo4 = new javax.swing.JButton();
        PANEL_carrito = new javax.swing.JPanel();
        listadoVentas = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        panel_cuentas = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        TFSubtotal = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        TFTotal = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ventas");

        titulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        titulo.setText("FACTURA Nº <cod_factura>");

        PANEL_factura.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCodigo1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo1.setText("NÚMERO DE FACTURA");

        txtCodigo2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo2.setText("FECHA");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_ventas/factura.png"))); // NOI18N

        javax.swing.GroupLayout PANEL_facturaLayout = new javax.swing.GroupLayout(PANEL_factura);
        PANEL_factura.setLayout(PANEL_facturaLayout);
        PANEL_facturaLayout.setHorizontalGroup(
            PANEL_facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_facturaLayout.createSequentialGroup()
                .addGroup(PANEL_facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_facturaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(PANEL_facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TFCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCodigo1))
                            .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PANEL_facturaLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18))
        );
        PANEL_facturaLayout.setVerticalGroup(
            PANEL_facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_facturaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        barraHerramientas.setFloatable(false);
        barraHerramientas.setOrientation(javax.swing.SwingConstants.VERTICAL);
        barraHerramientas.setRollover(true);
        barraHerramientas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/nuevo.png"))); // NOI18N
        botonNuevo.setText("Nueva venta");
        botonNuevo.setFocusable(false);
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonNuevo.setMaximumSize(new java.awt.Dimension(160, 40));
        botonNuevo.setMinimumSize(new java.awt.Dimension(160, 40));
        botonNuevo.setPreferredSize(new java.awt.Dimension(160, 40));
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });
        barraHerramientas.add(botonNuevo);

        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/deshacer.png"))); // NOI18N
        botonLimpiar.setText("Limpiar texto");
        botonLimpiar.setFocusable(false);
        botonLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonLimpiar.setMaximumSize(new java.awt.Dimension(160, 40));
        botonLimpiar.setMinimumSize(new java.awt.Dimension(160, 40));
        botonLimpiar.setPreferredSize(new java.awt.Dimension(160, 40));
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
        barraHerramientas.add(botonLimpiar);
        barraHerramientas.add(jSeparator2);

        botonLimpiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/calcularVenta.png"))); // NOI18N
        botonLimpiar2.setText("Calcular Venta");
        botonLimpiar2.setFocusable(false);
        botonLimpiar2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonLimpiar2.setMaximumSize(new java.awt.Dimension(160, 40));
        botonLimpiar2.setMinimumSize(new java.awt.Dimension(160, 40));
        botonLimpiar2.setPreferredSize(new java.awt.Dimension(160, 40));
        botonLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiar2ActionPerformed(evt);
            }
        });
        barraHerramientas.add(botonLimpiar2);

        botonLimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/realizarVenta.png"))); // NOI18N
        botonLimpiar3.setText("Realizar Venta");
        botonLimpiar3.setFocusable(false);
        botonLimpiar3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonLimpiar3.setMaximumSize(new java.awt.Dimension(160, 40));
        botonLimpiar3.setMinimumSize(new java.awt.Dimension(160, 40));
        botonLimpiar3.setPreferredSize(new java.awt.Dimension(160, 40));
        botonLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiar3ActionPerformed(evt);
            }
        });
        barraHerramientas.add(botonLimpiar3);

        PANEL_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo.setText("Código:");

        botonBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/buscar.png"))); // NOI18N
        botonBuscarCliente.setText("Cliente");
        botonBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscarCliente.setFocusable(false);
        botonBuscarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonBuscarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClienteActionPerformed(evt);
            }
        });

        txtNombreS.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombreS.setText("Señor(a):");

        txtDir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtDir.setText("Dirrección:");

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
                            .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFNombreS)
                            .addComponent(txtNombreS, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                    .addComponent(TFDir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(botonBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        PANEL_clienteLayout.setVerticalGroup(
            PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addComponent(txtNombreS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFNombreS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                .addComponent(botonBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PANEL_producto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCod.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCod.setText("Código:");

        txtNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre.setText("Nombre del Producto:");

        txtPrecio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtPrecio.setText("Precio de Compra:");

        txtCantidad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCantidad.setText("Stock:");

        txtCantidad1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCantidad1.setText("Cantidad:");

        botonNuevo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/buscar.png"))); // NOI18N
        botonNuevo4.setText("Articulo");
        botonNuevo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonNuevo4.setFocusable(false);
        botonNuevo4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevo4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonNuevo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevo4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_productoLayout = new javax.swing.GroupLayout(PANEL_producto);
        PANEL_producto.setLayout(PANEL_productoLayout);
        PANEL_productoLayout.setHorizontalGroup(
            PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_productoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PANEL_productoLayout.createSequentialGroup()
                        .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFNombreProd)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                        .addGap(110, 110, 110))
                    .addGroup(PANEL_productoLayout.createSequentialGroup()
                        .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_productoLayout.createSequentialGroup()
                                .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(TFStock, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantidad1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(TFCantidad)))
                            .addGroup(PANEL_productoLayout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addComponent(botonNuevo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))))
        );
        PANEL_productoLayout.setVerticalGroup(
            PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_productoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PANEL_productoLayout.createSequentialGroup()
                        .addComponent(botonNuevo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(PANEL_productoLayout.createSequentialGroup()
                        .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PANEL_productoLayout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(PANEL_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TFStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15))))
        );

        PANEL_carrito.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrito", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listadoVentas.setViewportView(tablaVentas);

        javax.swing.GroupLayout PANEL_carritoLayout = new javax.swing.GroupLayout(PANEL_carrito);
        PANEL_carrito.setLayout(PANEL_carritoLayout);
        PANEL_carritoLayout.setHorizontalGroup(
            PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_carritoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(listadoVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        PANEL_carritoLayout.setVerticalGroup(
            PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_carritoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(listadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setText("Subtotal:");

        TFSubtotal.setText("0.0");
        TFSubtotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TFSubtotal.setEnabled(false);

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setText("Total:");

        TFTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TFTotal.setForeground(new java.awt.Color(255, 51, 51));
        TFTotal.setText("0.0");
        TFTotal.setDisabledTextColor(new java.awt.Color(0, 51, 153));
        TFTotal.setEnabled(false);

        javax.swing.GroupLayout panel_cuentasLayout = new javax.swing.GroupLayout(panel_cuentas);
        panel_cuentas.setLayout(panel_cuentasLayout);
        panel_cuentasLayout.setHorizontalGroup(
            panel_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cuentasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_cuentasLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TFSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_cuentasLayout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TFTotal)))
                .addGap(23, 23, 23))
        );
        panel_cuentasLayout.setVerticalGroup(
            panel_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cuentasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panel_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PANEL_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PANEL_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PANEL_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PANEL_carrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(15, 15, 15)
                        .addComponent(PANEL_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PANEL_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PANEL_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(PANEL_carrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // BOTON NUEVO //
        bloquearBotones(true);
        botonNuevo.setEnabled(false);
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
 
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBuscarClienteActionPerformed

    private void botonNuevo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevo4ActionPerformed

    private void botonLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonLimpiar2ActionPerformed

    private void botonLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonLimpiar3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANEL_carrito;
    private javax.swing.JPanel PANEL_cliente;
    private javax.swing.JPanel PANEL_factura;
    private javax.swing.JPanel PANEL_producto;
    private javax.swing.JTextField TFCantidad;
    private javax.swing.JTextField TFCodProd;
    private javax.swing.JTextField TFCodigo;
    private javax.swing.JTextField TFCodigo1;
    private javax.swing.JTextField TFCodigo2;
    private javax.swing.JTextField TFDir;
    private javax.swing.JTextField TFNombreProd;
    private javax.swing.JTextField TFNombreS;
    private javax.swing.JTextField TFPrecio;
    private javax.swing.JTextField TFStock;
    private javax.swing.JTextField TFSubtotal;
    private javax.swing.JTextField TFTotal;
    private javax.swing.JToolBar barraHerramientas;
    private javax.swing.JButton botonBuscarCliente;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonLimpiar2;
    private javax.swing.JButton botonLimpiar3;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonNuevo4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JScrollPane listadoVentas;
    private javax.swing.JPanel panel_cuentas;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtCantidad;
    private javax.swing.JLabel txtCantidad1;
    private javax.swing.JLabel txtCod;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtCodigo1;
    private javax.swing.JLabel txtCodigo2;
    private javax.swing.JLabel txtDir;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombreS;
    private javax.swing.JLabel txtPrecio;
    // End of variables declaration//GEN-END:variables
}
