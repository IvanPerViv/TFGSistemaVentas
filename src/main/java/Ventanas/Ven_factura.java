package Ventanas;

import Conexiones.Con_albaran;
import Conexiones.Con_factura;
import Conexiones.Con_factura_linea;
import Conexiones.Con_pedido_linea;
import Conexiones.Conexion;
import Modelos.LineaPedido;
import Utils.Comprobaciones;
import Utils.GenerarCodigo;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Iván Pérez
 */
public class Ven_factura extends javax.swing.JInternalFrame {

    private GenerarCodigo objGenCod;
    private Con_factura objConFactura;
    private Conexion con;
    private Con_pedido_linea objConPedidoLinea;
    private Con_factura_linea objConFacturaLinea;
    private Comprobaciones objComprobaciones;
    private Con_albaran objConAlbaran;

    public static DefaultTableModel dtmFactura;

    public Ven_factura() {
        initComponents();
        objGenCod = new GenerarCodigo();
        objConFactura = new Con_factura();
        con = new Conexion();
        objConPedidoLinea = new Con_pedido_linea();
        objConFacturaLinea = new Con_factura_linea();
        objComprobaciones = new Comprobaciones();
        objConAlbaran = new Con_albaran();

        cargaDatosTabla();

        bloquearCampos(false);
        bloquearBotones(false);
        AreaObs.setEnabled(false);
    }

    private void cargaDatosTabla() {
        String[] nombreTablas = {"CÓDIGO ALBARÁN", "NOMBRE CLIENTE", "CÓDIGO PEDIDO", "FECHA"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        dtmFactura = new DefaultTableModel(null, nombreTablas);
        tablaAlbaranes.setModel(dtmFactura);
    }

    private void bloquearCampos(boolean bloquear) {
        TFNumFactura.setEnabled(bloquear);

        //Cliente
        TFCodClie.setEnabled(bloquear);
        TFNombreC.setEnabled(bloquear);
        TFDir.setEnabled(bloquear);
        TFTel.setEnabled(bloquear);
    }

    private void bloquearBotones(boolean bloquear) {
        botonLimpiar.setEnabled(bloquear);

        fecha.setEnabled(bloquear);
        BotonBuscarCliente.setEnabled(bloquear);
        botonAgregarProc.setEnabled(bloquear);
        botonEliminarProc.setEnabled(bloquear);
    }

    private void limpiar() {
        bloquearBotones(true);
        TFNumFactura.setText("");
        TFCodClie.setText("");
        TFNombreC.setText("");
        TFDir.setText("");
        TFTel.setText("");

        AreaObs.setText("");

        TFSubtotal.setText("");
        TFTotal.setText("");
    }

    private void limpiarTabla() {
        DefaultTableModel dtmAlbaran = (DefaultTableModel) tablaAlbaranes.getModel();
        int filas = tablaAlbaranes.getRowCount();
        int contador = 0;
        while (filas > contador) {
            dtmAlbaran.removeRow(0);
            contador++;
        }
    }

    private void generarNumeroFactura() {
        int codFactura = objConFactura.codigoFactura();
        int numero = objGenCod.generarCod(codFactura);

        TFNumFactura.setText(codFactura != 0 ? String.valueOf(numero) : "1");
    }

    private void calcularPedido() {
        int codPedido = 0;
        double precio = 0.0, cantidad = 0.0, totalArticulo = 0.0, subtotal = 0.0, sumaIva = 0.0, totalIva = 0.0, precioTotal = 0.0, precioConIva = 0.0;
        ArrayList<LineaPedido> arLineaPedidos = new ArrayList<>();

        for (int i = 0; i < tablaAlbaranes.getRowCount(); i++) {
            codPedido = Integer.parseInt(tablaAlbaranes.getValueAt(i, 2).toString());

            arLineaPedidos = objConPedidoLinea.mostrarLineasPedidos(codPedido);
            for (int j = 0; j < arLineaPedidos.size(); j++) {
                cantidad = arLineaPedidos.get(j).getCantidad();
                precio = arLineaPedidos.get(j).getPrecioVenta();
                sumaIva = arLineaPedidos.get(j).getIva();

                totalArticulo = cantidad * precio;                     // SIN IVA
                precioConIva = calcularIva(totalArticulo, sumaIva);    // CON IVA

                subtotal = subtotal + totalArticulo;
                totalIva += precioConIva;
            }
            precioTotal = subtotal + totalIva;
        }

        TFSubtotal.setText(Double.toString(Math.ceil(subtotal))); // Redondear hacia arriba
        TFTotal.setText(Double.toString(Math.rint(precioTotal)));
    }

    private double calcularIva(double cantidad, double iva) {
        double total;
        return total = (cantidad * iva) / 100;
    }

    private boolean comprobacionCamposCliente() {
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

        return comprobacion;
    }

    private boolean comprobacionCamposGlobales() {
        boolean comprobacion = true;
        if (objComprobaciones.ValidarCamposNumeros(TFSubtotal) && objComprobaciones.ValidarCamposNumeros(TFTotal)) {
            botonCalculo.setBorder(new LineBorder(Color.red));
            comprobacion = false;
        }
        try {
            if (fecha.getDate() == null) {
                comprobacion = false;
                JOptionPane.showMessageDialog(this, "Rellene el campo 'Fecha'.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NullPointerException ex) {
            System.err.println(ex.toString());
        }

        comprobacionCamposCliente();
        return comprobacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacion2 = new javax.swing.JLabel();
        TFNumFactura = new javax.swing.JTextField();
        informacion4 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        PANEL_carrito = new javax.swing.JPanel();
        listadoVentas = new javax.swing.JScrollPane();
        tablaAlbaranes = new javax.swing.JTable();
        botonAgregarProc = new javax.swing.JButton();
        botonEliminarProc = new javax.swing.JButton();
        panel_observaciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaObs = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        TFSubtotal = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        TFTotal = new javax.swing.JTextField();
        botonRealizarFactura = new javax.swing.JButton();
        botonCalculo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Facturas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/iconFactura.png"))); // NOI18N

        informacion2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion2.setText("Nº de Factura");

        TFNumFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TFNumFactura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFNumFactura.setBorder(null);

        informacion4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion4.setText("Fecha:");

        fecha.setDateFormatString("dd/MM/yyyy");
        fecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

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
                .addGap(10, 10, 10)
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodClie, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFNombreC)
                            .addComponent(txtNombreS, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                    .addComponent(TFDir)
                    .addComponent(txtDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFTel, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonBuscarCliente)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        PANEL_clienteLayout.setVerticalGroup(
            PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonBuscarCliente)))
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
                        .addComponent(TFDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane2.setBorder(null);

        PANEL_carrito.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Albaránes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tablaAlbaranes.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaAlbaranes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaAlbaranes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listadoVentas.setViewportView(tablaAlbaranes);

        botonAgregarProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/mas.png"))); // NOI18N
        botonAgregarProc.setToolTipText("Agregar Albaránes");
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
                .addComponent(jScrollPane1)
                .addGap(15, 15, 15))
        );
        panel_observacionesLayout.setVerticalGroup(
            panel_observacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_observacionesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout PANEL_carritoLayout = new javax.swing.GroupLayout(PANEL_carrito);
        PANEL_carrito.setLayout(PANEL_carritoLayout);
        PANEL_carritoLayout.setHorizontalGroup(
            PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_carritoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_observaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listadoVentas))
                .addGap(15, 15, 15)
                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAgregarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        PANEL_carritoLayout.setVerticalGroup(
            PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_carritoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PANEL_carritoLayout.createSequentialGroup()
                        .addComponent(botonAgregarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminarProc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(panel_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(PANEL_carrito);

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Subtotal:");

        TFSubtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TFSubtotal.setText("0.0");
        TFSubtotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TFSubtotal.setEnabled(false);

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Total:");

        TFTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TFTotal.setForeground(new java.awt.Color(255, 51, 51));
        TFTotal.setText("0.0");
        TFTotal.setDisabledTextColor(new java.awt.Color(0, 51, 153));
        TFTotal.setEnabled(false);

        botonRealizarFactura.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonRealizarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_pedidos/icons8-boleto-30.png"))); // NOI18N
        botonRealizarFactura.setText("Realizar factura");
        botonRealizarFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRealizarFactura.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonRealizarFactura.setMaximumSize(new java.awt.Dimension(140, 40));
        botonRealizarFactura.setMinimumSize(new java.awt.Dimension(140, 40));
        botonRealizarFactura.setPreferredSize(new java.awt.Dimension(140, 40));
        botonRealizarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRealizarFacturaActionPerformed(evt);
            }
        });

        botonCalculo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonCalculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_botonesGenerales/realizarVenta.png"))); // NOI18N
        botonCalculo.setText("Calcular");
        botonCalculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCalculo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonCalculo.setMaximumSize(new java.awt.Dimension(140, 40));
        botonCalculo.setMinimumSize(new java.awt.Dimension(140, 40));
        botonCalculo.setPreferredSize(new java.awt.Dimension(140, 40));
        botonCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(barraHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(informacion2))
                                    .addComponent(TFNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(309, 309, 309)
                                .addComponent(informacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PANEL_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFTotal)
                                    .addComponent(TFSubtotal)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(botonCalculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonRealizarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(barraHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(informacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(TFNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addComponent(PANEL_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(botonCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(botonRealizarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // BOTON NUEVO //
        bloquearBotones(true);
        generarNumeroFactura();
        AreaObs.setEnabled(true);
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // BOTON LIMPIAR //
        limpiar();
        limpiarTabla();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void BotonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarClienteActionPerformed
        // BOTON BUSCAR CLIENTE
        String nombreDeClase = "Ven_factura";

        Ven_tabla_cliente objTabClie = new Ven_tabla_cliente(nombreDeClase);
        Ven_principal.escritorio.add(objTabClie).setVisible(true);
    }//GEN-LAST:event_BotonBuscarClienteActionPerformed

    private void botonAgregarProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarProcActionPerformed
        // BOTON AGREGAR ALBARAN
        if (comprobacionCamposCliente()) {
            int codigoCliente = Integer.parseInt(TFCodClie.getText());
            Ven_tabla_albaran objTablaAlbaranes = new Ven_tabla_albaran(codigoCliente);
            Ven_principal.escritorio.add(objTablaAlbaranes).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Introduce los datos del cliente.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_botonAgregarProcActionPerformed

    private void botonEliminarProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProcActionPerformed
        // BOTON ELIMINAR ALBARAN
        DefaultTableModel modelo = (DefaultTableModel) tablaAlbaranes.getModel();
        int filaSelecionada = tablaAlbaranes.getSelectedRow();
        if (filaSelecionada >= 0) {
            modelo.removeRow(filaSelecionada);
        } else {
            JOptionPane.showMessageDialog(this, "No has selecionado ninguna fila.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarProcActionPerformed

    private void botonRealizarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRealizarFacturaActionPerformed
        // BOTON REALIZAR FACTURA
        if (comprobacionCamposGlobales()) {
            int filaSeleccion = tablaAlbaranes.getRowCount();
            double subTotal = Double.parseDouble(TFSubtotal.getText());
            double total = Double.parseDouble(TFTotal.getText());
            boolean comprobacionFactura2 = false;

            if (filaSeleccion == 0) {
                JOptionPane.showMessageDialog(this, "No existe ningun dato.\nRellene los datos correspondientes.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int codFactura = Integer.parseInt(TFNumFactura.getText());
                int codCliente = Integer.parseInt(TFCodClie.getText());

                Date date = fecha.getDate();
                long fechaConversion = date.getTime();
                java.sql.Date fechaDate = new java.sql.Date(fechaConversion);

                String area = AreaObs.getText();

                // INSERCION FACTURA
                boolean comprobacionFactura = objConFactura.ingresoFacturas(codFactura, codCliente, fechaDate, area);

                // INSERCION LINEAS-FACTURAS - numerofactura, codigoAlbaran, subtotal, total.
                for (int i = 0; i < filaSeleccion; i++) {
                    int codigoAlbaran = Integer.parseInt(tablaAlbaranes.getValueAt(i, 0).toString());
                    comprobacionFactura2 = objConFacturaLinea.ingresoLineaFactura(codFactura, codigoAlbaran, subTotal, total);

                    //Actualizacion del ESTADO del ALBARAN
                    objConAlbaran.actualizarEstadoAlbaran(codigoAlbaran, "Facturado");
                }
                if (comprobacionFactura == true && comprobacionFactura2 == true) {
                    JOptionPane.showMessageDialog(this, "Su pedido ha sido reservado con exito.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);

                    int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea generar un informe?", "Aviso del Sistema.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (seleccion == 0) {
                        try {
                            Connection conn = con.conexion(); // ESTABLECEMOS CONEXION CON NUESTRA BASE DE DATOS.
                            String ubicacion = "src/main/java/Reportes/Facturas.jrxml";
                            Map<String, Object> params = new HashMap<>();
                            params.put("numCliente", codCliente);
                            JasperReport jasperReport = JasperCompileManager.compileReport(ubicacion);
                            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

                            int comprobacion = JOptionPane.showConfirmDialog(this, "¿Desea exportar el archivo a PDF?", "Aviso del Sistema.", JOptionPane.YES_NO_OPTION);
                            if (comprobacion == 0) {
                                //EXPORTAR A PDF.
                                String nombreArchivoPDF = JOptionPane.showInputDialog("Introduzca el nombre para el PDF: ");
                                JasperExportManager.exportReportToPdfFile(jasperPrint, "reportes_PDF/" + nombreArchivoPDF + ".pdf");
                                JasperViewer.viewReport(jasperPrint, false);
                            } else {
                                JasperViewer.viewReport(jasperPrint, false);
                            }
                            con.desconexion();
                        } catch (JRException | NumberFormatException ex) {
                            Logger.getLogger(Ven_albaran.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                limpiar();
                limpiarTabla();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Rellene los campos.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonRealizarFacturaActionPerformed

    private void botonCalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalculoActionPerformed
        calcularPedido();
        botonCalculo.setBorder(new LineBorder(Color.GRAY));
    }//GEN-LAST:event_botonCalculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaObs;
    private javax.swing.JButton BotonBuscarCliente;
    private javax.swing.JPanel PANEL_carrito;
    private javax.swing.JPanel PANEL_cliente;
    public static javax.swing.JTextField TFCodClie;
    public static javax.swing.JTextField TFDir;
    public static javax.swing.JTextField TFNombreC;
    private javax.swing.JTextField TFNumFactura;
    private javax.swing.JTextField TFSubtotal;
    public static javax.swing.JTextField TFTel;
    private javax.swing.JTextField TFTotal;
    private javax.swing.JToolBar barraHerramientas;
    private javax.swing.JButton botonAgregarProc;
    private javax.swing.JButton botonCalculo;
    private javax.swing.JButton botonEliminarProc;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonRealizarFactura;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel informacion2;
    private javax.swing.JLabel informacion4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JScrollPane listadoVentas;
    private javax.swing.JPanel panel_observaciones;
    private javax.swing.JTable tablaAlbaranes;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtCodigo1;
    private javax.swing.JLabel txtDir;
    private javax.swing.JLabel txtNombreS;
    // End of variables declaration//GEN-END:variables
}
