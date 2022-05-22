package Ventanas;

import Conexiones.Con_pedido;
import Conexiones.Con_pedido_linea;
import Utils.Comprobaciones;
import Utils.GenerarCodigo;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 * @author Iván Pérez
 */
public class Ven_pedido extends javax.swing.JInternalFrame {

    private Comprobaciones objComprobaciones;
    private Con_pedido objConPedidos;
    private Con_pedido_linea objPedidoLinea;
    private GenerarCodigo objGenCod;

    public Ven_pedido() {
        initComponents();
        objComprobaciones = new Comprobaciones();
        objConPedidos = new Con_pedido();
        objPedidoLinea = new Con_pedido_linea();
        objGenCod = new GenerarCodigo();

        bloquearCampos(false);
        bloquearBotones(false);
        AreaObs.setEnabled(false);
        cargaDeDatosArticulos();
    }

    private void bloquearCampos(boolean bloquear) {
        TFnumPedido.setEnabled(bloquear);

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

    private void bloquearBotones(boolean bloquear) {
        botonLimpiar.setEnabled(bloquear);

        ffFecha.setEnabled(bloquear);
        BotonBuscarCliente.setEnabled(bloquear);
        botonBuscarProducto.setEnabled(bloquear);
        botonAgregarProc.setEnabled(bloquear);
        botonEliminarProc.setEnabled(bloquear);
    }

    private void limpiar() {
        bloquearBotones(true);
        TFnumPedido.setText("");
        TFCodClie.setText("");
        TFNombreC.setText("");
        TFDir.setText("");
        TFTel.setText("");

        TFCodProd.setText("");
        TFPrecio.setText("");
        TFNombreProc.setText("");
        TFIva.setText("");
        TFStock.setText("");
        TFCantidad.setText("");
        AreaObs.setText("");

        TFSubtotal.setText("");
        TFTotal.setText("");
    }

    private void limpiarArticulos() {
        TFCodProd.setText("");
        TFPrecio.setText("");
        TFNombreProc.setText("");
        TFIva.setText("");
        TFStock.setText("");
        TFCantidad.setText("");
    }

    private void limpiarTabla() {
        DefaultTableModel dtmPedido = (DefaultTableModel) tablaPedidos.getModel();
        int filas = tablaPedidos.getRowCount();
        int contador = 0;
        while (filas > contador) {
            dtmPedido.removeRow(0);
            contador++;
        }
    }

    private void generarNumeroPedido() {
        int codPedido = objConPedidos.codigoPedidos();
        int numero = objGenCod.generarCod(codPedido);

        TFnumPedido.setText(codPedido != 0 ? String.valueOf(numero) : "1");
    }

    private void cargaDeDatosArticulos() {
        String[] nombreTablas = {"Cod.Articulo", "Producto", "Cantidad", "Precio", "IVA"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        DefaultTableModel proc = new DefaultTableModel(null, nombreTablas);
        tablaPedidos.setModel(proc);
    }

    private void calcularPedido() {
        double IVA = 0, total = 0, subtotal = 0, precio, totalArticulo = 0;
        String prec, cant, iva;
        int cantidad;

        for (int i = 0; i < tablaPedidos.getRowCount(); i++) {
            cant = tablaPedidos.getValueAt(i, 2).toString();
            prec = tablaPedidos.getValueAt(i, 3).toString();
            iva = tablaPedidos.getValueAt(i, 4).toString();

            precio = Double.parseDouble(prec);
            cantidad = Integer.parseInt(cant);
            IVA = Double.parseDouble(iva);

            totalArticulo = cantidad * precio;
            subtotal = subtotal + totalArticulo;
            IVA = calcularIva(subtotal, IVA);
            total = subtotal + IVA;
        }
        TFSubtotal.setText(Double.toString(Math.ceil(subtotal)));
        TFTotal.setText(Double.toString(Math.rint(total)));
    }

    private double calcularIva(double cantidad, double iva) {
        double total;
        return total = (cantidad * iva) / 100;
    }

    private void comprobarStock() {
        int stock = Integer.parseInt(TFStock.getText());
        int cantidad = Integer.parseInt(TFCantidad.getText());
        if (cantidad > stock) {
            JOptionPane.showMessageDialog(this, "No cuenta con el stock apropiado.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            TFCantidad.setText("");
        }
    }

    private boolean comprobacionCamposGlobales() {
        boolean comprobacion = true;
        if (objComprobaciones.validacionJTextField(TFCodClie)) {
            comprobacion = false;
        }
        if (objComprobaciones.validacionJTextField(TFNombreC)) {
            comprobacion = false;
        }
        if (objComprobaciones.validacionJTextField(TFDir)) {
            comprobacion = false;
        }
        if (objComprobaciones.validacionJTextField(TFTel)) {
            comprobacion = false;
        }
        try {
            if (ffFecha.getDate() == null) {
                comprobacion = false;
                JOptionPane.showMessageDialog(this, "Rellene el campo 'Fecha'.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NullPointerException ex) {
            System.err.println(ex.toString());
        }

        return comprobacion;
    }

    private boolean comprobacionCamposProductos() {
        boolean comprobacion = true;
        if (objComprobaciones.validacionJTextField(TFCodProd)) {
            comprobacion = false;
        }
        if (objComprobaciones.validacionJTextField(TFNombreProc)) {
            comprobacion = false;
        }
        if (objComprobaciones.validacionJTextField(TFPrecio)) {
            comprobacion = false;
        }
        if (objComprobaciones.validacionJTextField(TFIva)) {
            comprobacion = false;
        }
        if (objComprobaciones.validacionJTextField(TFStock)) {
            comprobacion = false;
        }
        if (objComprobaciones.validacionJTextField(TFCantidad)) {
            comprobacion = false;
        }
        return comprobacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraHerramientas = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
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
        Prodcutos = new javax.swing.JScrollPane();
        PANEL_carrito = new javax.swing.JPanel();
        listadoVentas = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
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
        panel_observaciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaObs = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        TFSubtotal = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        TFTotal = new javax.swing.JTextField();
        botonRealizarPedido = new javax.swing.JButton();
        informacion2 = new javax.swing.JLabel();
        TFnumPedido = new javax.swing.JTextField();
        informacion4 = new javax.swing.JLabel();
        ffFecha = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pedidos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/iconPedidos.png"))); // NOI18N

        barraHerramientas.setRollover(true);
        barraHerramientas.setBorderPainted(false);
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

        PANEL_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo.setText("Código:");

        TFCodClie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtNombreS.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombreS.setText("Nombre Comerical:");

        TFNombreC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtDir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtDir.setText("Dirrección:");

        TFDir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtCodigo1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo1.setText("Télefono:");

        TFTel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/buscarClie.png"))); // NOI18N

        BotonBuscarCliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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
                .addGap(15, 15, 15)
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFDir, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(txtDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFTel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFCodClie, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreS, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonBuscarCliente)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );
        PANEL_clienteLayout.setVerticalGroup(
            PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, 0)
                        .addComponent(BotonBuscarCliente))
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
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                                .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(TFDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                                .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(TFTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(7, 7, 7))
        );

        Prodcutos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tablaPedidos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listadoVentas.setViewportView(tablaPedidos);

        botonAgregarProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/mas.png"))); // NOI18N
        botonAgregarProc.setToolTipText("Agregar Producto");
        botonAgregarProc.setBorderPainted(false);
        botonAgregarProc.setContentAreaFilled(false);
        botonAgregarProc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAgregarProc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/mas2.png"))); // NOI18N
        botonAgregarProc.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/mas2.png"))); // NOI18N
        botonAgregarProc.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/mas2.png"))); // NOI18N
        botonAgregarProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarProcActionPerformed(evt);
            }
        });

        botonEliminarProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/menos.png"))); // NOI18N
        botonEliminarProc.setToolTipText("Eliminar");
        botonEliminarProc.setBorderPainted(false);
        botonEliminarProc.setContentAreaFilled(false);
        botonEliminarProc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarProc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/menos2.png"))); // NOI18N
        botonEliminarProc.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/menos2.png"))); // NOI18N
        botonEliminarProc.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/menos2.png"))); // NOI18N
        botonEliminarProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarProcActionPerformed(evt);
            }
        });

        txtCod.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCod.setText("Código:");

        TFCodProd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        TFPrecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        TFStock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtCantidad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCantidad.setText("Stock:");

        txtCantidad2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCantidad2.setText("IVA:");

        TFIva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        TFCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TFCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFCantidadKeyTyped(evt);
            }
        });

        txtCantidad1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCantidad1.setText("Cantidad:");

        TFNombreProc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNombre.setText("Descripción del Producto:");

        txtPrecio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtPrecio.setText("Precio");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/busProc.png"))); // NOI18N

        botonBuscarProducto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        botonBuscarProducto.setText("Buscar");
        botonBuscarProducto.setToolTipText("Buscar Productos");
        botonBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProductoActionPerformed(evt);
            }
        });

        panel_observaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        AreaObs.setColumns(20);
        AreaObs.setRows(5);
        jScrollPane1.setViewportView(AreaObs);

        javax.swing.GroupLayout panel_observacionesLayout = new javax.swing.GroupLayout(panel_observaciones);
        panel_observaciones.setLayout(panel_observacionesLayout);
        panel_observacionesLayout.setHorizontalGroup(
            panel_observacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_observacionesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        panel_observacionesLayout.setVerticalGroup(
            panel_observacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_observacionesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout PANEL_carritoLayout = new javax.swing.GroupLayout(PANEL_carrito);
        PANEL_carrito.setLayout(PANEL_carritoLayout);
        PANEL_carritoLayout.setHorizontalGroup(
            PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_carritoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1)
                    .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PANEL_carritoLayout.createSequentialGroup()
                            .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_carritoLayout.createSequentialGroup()
                                    .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TFNombreProc)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                                    .addGap(15, 15, 15)
                                    .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(21, 21, 21))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_carritoLayout.createSequentialGroup()
                                    .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFIva, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TFStock))
                                    .addGap(15, 15, 15)
                                    .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCantidad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TFCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                    .addGap(23, 23, 23)))
                            .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(botonBuscarProducto)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TFCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PANEL_carritoLayout.createSequentialGroup()
                            .addComponent(listadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botonAgregarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonEliminarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(panel_observaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        PANEL_carritoLayout.setVerticalGroup(
            PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_carritoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TFCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_carritoLayout.createSequentialGroup()
                        .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFNombreProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PANEL_carritoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscarProducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PANEL_carritoLayout.createSequentialGroup()
                        .addComponent(botonAgregarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEliminarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(listadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(panel_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        Prodcutos.setViewportView(PANEL_carrito);

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Subtotal:");

        TFSubtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TFSubtotal.setText("0.0");
        TFSubtotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TFSubtotal.setEnabled(false);
        TFSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFSubtotalActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Total:");

        TFTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TFTotal.setForeground(new java.awt.Color(255, 51, 51));
        TFTotal.setText("0.0");
        TFTotal.setDisabledTextColor(new java.awt.Color(0, 51, 153));
        TFTotal.setEnabled(false);

        botonRealizarPedido.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonRealizarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/icons8-boleto-30.png"))); // NOI18N
        botonRealizarPedido.setText("Realizar Pedido");
        botonRealizarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRealizarPedido.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonRealizarPedido.setMaximumSize(new java.awt.Dimension(140, 40));
        botonRealizarPedido.setMinimumSize(new java.awt.Dimension(140, 40));
        botonRealizarPedido.setPreferredSize(new java.awt.Dimension(140, 40));
        botonRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRealizarPedidoActionPerformed(evt);
            }
        });

        informacion2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion2.setText("Nº de pedido:");

        TFnumPedido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TFnumPedido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFnumPedido.setBorder(null);

        informacion4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion4.setText("Fecha:");

        ffFecha.setDateFormatString("dd/MM/yyyy");
        ffFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ffFecha.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFnumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(informacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ffFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(barraHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PANEL_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Prodcutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFTotal)
                            .addComponent(TFSubtotal)))
                    .addComponent(botonRealizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(botonRealizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(informacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(ffFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(TFnumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PANEL_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Prodcutos, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // BOTON NUEVO //
        bloquearBotones(true);
        generarNumeroPedido();
        AreaObs.setEnabled(true);
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // BOTON LIMPIAR //
        limpiar();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void BotonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarClienteActionPerformed
        // BOTON BUSCAR CLIENTE
        String nombreDeClase = "Ven_pedido";

        Ven_tabla_cliente objTabClie = new Ven_tabla_cliente(nombreDeClase);
        Ven_principal.escritorio.add(objTabClie).setVisible(true);
        TFCantidad.setEnabled(true);
    }//GEN-LAST:event_BotonBuscarClienteActionPerformed

    private void botonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProductoActionPerformed
        // BOTON BUSCAR ARTICULO
        Ven_tabla_articulo objTablaArticulos = new Ven_tabla_articulo();
        Ven_principal.escritorio.add(objTablaArticulos).setVisible(true);
        TFCantidad.setEnabled(true);
    }//GEN-LAST:event_botonBuscarProductoActionPerformed

    private void botonAgregarProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarProcActionPerformed
        // Agregar Datos       
        int numVerificacionArticulo = objComprobaciones.verificacionCodigoPedido(TFNombreProc.getText(), tablaPedidos);

        if (comprobacionCamposProductos()) {
            if (numVerificacionArticulo == 0) { // VERIFICACION DE QUE EL ARTICULO NO SEA EL MISMO.
                DefaultTableModel modelo = (DefaultTableModel) tablaPedidos.getModel();
                String[] pedidos = {
                    TFCodProd.getText(),
                    TFNombreProc.getText(),
                    TFCantidad.getText(),
                    TFPrecio.getText(),
                    TFIva.getText()};
                modelo.addRow(pedidos);
                calcularPedido();
                limpiarArticulos();
            } else {
                JOptionPane.showMessageDialog(this, "El articulo ha sido ingresado, \neliminelo para poder modificarlo.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Rellene el campo 'Producto'.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_botonAgregarProcActionPerformed

    private void botonEliminarProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProcActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaPedidos.getModel();
        int fila = tablaPedidos.getSelectedRow();

        if (fila >= 0) {
            modelo.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(this, "No has selecionado ninguna fila.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_botonEliminarProcActionPerformed

    private void botonRealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRealizarPedidoActionPerformed
        // Boton realizar pedido //
        int Seleccionada = tablaPedidos.getRowCount();
        if (Seleccionada == 0) {
            JOptionPane.showMessageDialog(this, "No existe ningun dato.\nRellene los datos correspondientes.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (comprobacionCamposGlobales()) {
                int numPedido = Integer.parseInt(TFnumPedido.getText());
                Date date = ffFecha.getDate();
                long fechaConversion = date.getTime();
                java.sql.Date fechaDate = new java.sql.Date(fechaConversion);

                int codigoCliente = Integer.parseInt(TFCodClie.getText());
                String estado = "Pendiente";
                String area = AreaObs.getText();

                boolean comprobacionPedido = objConPedidos.ingresoPedidos(numPedido, codigoCliente, fechaDate, estado, area);
                for (int i = 0; i < tablaPedidos.getRowCount(); i++) {
                    int codArticulo = Integer.parseInt(tablaPedidos.getValueAt(i, 0).toString());
                    String Producto = tablaPedidos.getValueAt(i, 1).toString();
                    int cantidad = Integer.parseInt(tablaPedidos.getValueAt(i, 2).toString());
                    double precioUnitario = Double.parseDouble(tablaPedidos.getValueAt(i, 3).toString());
                    double iva = Double.parseDouble(tablaPedidos.getValueAt(i, 4).toString());
                    objPedidoLinea.ingresoLineasPedidos(numPedido, codArticulo, cantidad, precioUnitario, iva); //TAABLA N:N
                }

                if (comprobacionPedido == true) {
                    JOptionPane.showMessageDialog(this, "Su pedido ha sido reservado con exito.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
                    dispose();

                }
            }
        }


    }//GEN-LAST:event_botonRealizarPedidoActionPerformed

    private void TFCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFCantidadKeyTyped
        objComprobaciones.comprobacionNumeroEntero(evt);
    }//GEN-LAST:event_TFCantidadKeyTyped

    private void TFCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFCantidadKeyReleased
        comprobarStock();
        TFCantidad.setBorder(new LineBorder(Color.gray));
    }//GEN-LAST:event_TFCantidadKeyReleased

    private void TFSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFSubtotalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaObs;
    private javax.swing.JButton BotonBuscarCliente;
    private javax.swing.JPanel PANEL_carrito;
    private javax.swing.JPanel PANEL_cliente;
    private javax.swing.JScrollPane Prodcutos;
    private javax.swing.JTextField TFCantidad;
    public static javax.swing.JTextField TFCodClie;
    public static javax.swing.JTextField TFCodProd;
    public static javax.swing.JTextField TFDir;
    public static javax.swing.JTextField TFIva;
    public static javax.swing.JTextField TFNombreC;
    public static javax.swing.JTextField TFNombreProc;
    public static javax.swing.JTextField TFPrecio;
    public static javax.swing.JTextField TFStock;
    private javax.swing.JTextField TFSubtotal;
    public static javax.swing.JTextField TFTel;
    private javax.swing.JTextField TFTotal;
    private javax.swing.JTextField TFnumPedido;
    private javax.swing.JToolBar barraHerramientas;
    private javax.swing.JButton botonAgregarProc;
    private javax.swing.JButton botonBuscarProducto;
    private javax.swing.JButton botonEliminarProc;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonRealizarPedido;
    private com.toedter.calendar.JDateChooser ffFecha;
    private javax.swing.JLabel informacion2;
    private javax.swing.JLabel informacion4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JScrollPane listadoVentas;
    private javax.swing.JPanel panel_observaciones;
    private javax.swing.JTable tablaPedidos;
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
