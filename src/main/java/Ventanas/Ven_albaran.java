package Ventanas;

import Conexiones.Con_albaran;
import Conexiones.Con_albaran_linea;
import Conexiones.Con_articulo;
import Conexiones.Con_cliente;
import Conexiones.Con_localidad_prov_pais;
import Conexiones.Con_pedido;
import Conexiones.Conexion;
import Modelos.Albaran;
import Modelos.Cliente;
import Modelos.LineaAlbaran;
import Utils.generacionDeCodigo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Iván Pérez
 */
public final class Ven_albaran extends javax.swing.JInternalFrame {

    protected DefaultTableModel dftAlbaran;

    protected Con_articulo objConArticulos;
    protected Con_cliente objConClientes;
    protected Con_albaran objConAlbaran;
    protected Con_localidad_prov_pais objConLocal;
    protected Con_albaran_linea objConLineaAlbaran;
    protected Con_pedido objConPedidos;
    protected Conexion objCon;

    protected int numAlbaran;
    protected double precioUnitario, iva;

    public Ven_albaran(int codAlbaran) {
        initComponents();
        objConArticulos = new Con_articulo();
        objConAlbaran = new Con_albaran();
        objConClientes = new Con_cliente();
        objConLocal = new Con_localidad_prov_pais();
        objConLineaAlbaran = new Con_albaran_linea();
        objConPedidos = new Con_pedido();

        cargaDeDatosArticulos(codAlbaran);
        this.numAlbaran = codAlbaran;
        bloquearCampos(false);
        cargaDatosAlbaran();
    }

    protected void bloquearCampos(boolean bloquear) {
        TFnumPedido.setEnabled(bloquear);
        TFDate.setEnabled(bloquear);

        //Cliente
        TFCodClie.setEnabled(bloquear);
        TFNombreC.setEnabled(bloquear);
        TFDir.setEnabled(bloquear);
        TFTel.setEnabled(bloquear);

    }

    protected void cargaDatosAlbaran() {
        ArrayList<Albaran> arAlbaran = new ArrayList<>();
        arAlbaran = objConAlbaran.mostrarAlbaran(String.valueOf(numAlbaran));

        int codAlbaran = 0, codCliente = 0;
        Date fecha = null;
        for (int i = 0; i < arAlbaran.size(); i++) {
            codAlbaran = arAlbaran.get(i).getCodAlbaran();
            codCliente = arAlbaran.get(i).getCodCliente();
            fecha = arAlbaran.get(i).getFecha();
        }

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaToString = dateFormat.format(fecha);

        rellenoDeDatosAlbaran(codAlbaran, codCliente, fechaToString);
        cargaDeDatosClientes(codCliente);
    }

    protected void rellenoDeDatosAlbaran(int codAlbaran, int codCliente, String fecha) {
        TFnumPedido.setText(String.valueOf(numAlbaran));
        TFCodAlbaran.setText(String.valueOf(codAlbaran));
        TFCodClie.setText(String.valueOf(codCliente));

        TFDate.setText(fecha);
    }

    protected void cargaDeDatosClientes(int codigoCliente) {
        ArrayList<Cliente> arClientes = new ArrayList<>();
        arClientes = objConClientes.mostrarDatosClientes(codigoCliente);

        for (int i = 0; i < arClientes.size(); i++) {
            String nombreComercial = arClientes.get(i).getNombreComercial();
            int CodPostal = arClientes.get(i).getCodPostal();
            String dir = arClientes.get(i).getDirFiscal();
            String localidad = objConLocal.consultarLocalidadNombre(arClientes.get(i).getLocalidad()); //Subconsulta para saber la localidad.
            int telef = arClientes.get(i).getTelf();

            rellenoDeDatosAlbaran(nombreComercial, CodPostal, dir, localidad, telef);
        }

    }

    protected void rellenoDeDatosAlbaran(String nombreComercial, int CodPostal, String dir, String localidad, int telef) {
        TFNombreC.setText(nombreComercial);
        TFDir.setText(dir + " - " + localidad + " , " + String.valueOf(CodPostal));
        TFTel.setText(String.valueOf(telef));
    }

    protected void cargaDeDatosArticulos(int numAlbaran) {
        String[] nombreTablas = {"CODIGO ARTICULO", "DESCRIPCIÓN PRODUCTO", "CANTIDAD", "CANTIDAD-ENVIAR"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        dftAlbaran = new DefaultTableModel(null, nombreTablas);
        tablaAlbaran.setModel(dftAlbaran);

        Object[] fila = new Object[nombreTablas.length];

        ArrayList<LineaAlbaran> arLineaPedido = new ArrayList<>();
        arLineaPedido = objConLineaAlbaran.mostrarLineaAlbaran(numAlbaran);

        for (int i = 0; i < arLineaPedido.size(); i++) {
            fila[0] = arLineaPedido.get(i).getCodArticulo();
            fila[1] = objConArticulos.mostrarNombreArticulo(arLineaPedido.get(i).getCodArticulo());
            fila[2] = arLineaPedido.get(i).getCantidad();
            precioUnitario = arLineaPedido.get(i).getPrecioUnitario();
            iva = arLineaPedido.get(i).getIva();

            dftAlbaran.addRow(fila);
        }
    }

    protected int generarCodigoAlbaran() {
        int numero;
        int codigoAlbaran = objConAlbaran.codigoAlbaran();
        if (codigoAlbaran != 0) {
            generacionDeCodigo objGenCod = new generacionDeCodigo();
            numero = objGenCod.generarCod(codigoAlbaran);
        } else {
            numero = 1;
        }
        return numero;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PANEL_cliente = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JLabel();
        TFCodClie = new javax.swing.JTextField();
        txtNombreS = new javax.swing.JLabel();
        TFNombreC = new javax.swing.JTextField();
        txtDir = new javax.swing.JLabel();
        TFDir = new javax.swing.JTextField();
        txtCodigo1 = new javax.swing.JLabel();
        TFTel = new javax.swing.JTextField();
        PANEL_carrito = new javax.swing.JPanel();
        listadoVentas = new javax.swing.JScrollPane();
        tablaAlbaran = new javax.swing.JTable();
        informacion2 = new javax.swing.JLabel();
        TFnumPedido = new javax.swing.JTextField();
        informacion4 = new javax.swing.JLabel();
        TFDate = new javax.swing.JTextField();
        informacion3 = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();
        TFCodAlbaran = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Albaran");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/iconAlbaranes.png"))); // NOI18N

        PANEL_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCodigo.setText("Código");

        TFCodClie.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFCodClie.setBorder(null);
        TFCodClie.setEnabled(false);

        txtNombreS.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreS.setText("Nombre Comerical");

        TFNombreC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFNombreC.setBorder(null);
        TFNombreC.setEnabled(false);

        txtDir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDir.setText("Dirrección");

        TFDir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFDir.setBorder(null);
        TFDir.setEnabled(false);

        txtCodigo1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCodigo1.setText("Télefono de Contacto");

        TFTel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TFTel.setBorder(null);
        TFTel.setEnabled(false);

        javax.swing.GroupLayout PANEL_clienteLayout = new javax.swing.GroupLayout(PANEL_cliente);
        PANEL_cliente.setLayout(PANEL_clienteLayout);
        PANEL_clienteLayout.setHorizontalGroup(
            PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_clienteLayout.createSequentialGroup()
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodClie, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFNombreC)
                            .addComponent(txtNombreS, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(TFDir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TFTel))
                .addGap(15, 15, 15))
        );
        PANEL_clienteLayout.setVerticalGroup(
            PANEL_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_clienteLayout.createSequentialGroup()
                .addGap(5, 5, 5)
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
                        .addGap(15, 15, 15)
                        .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TFDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        PANEL_carrito.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRODUCTOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tablaAlbaran.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaAlbaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaAlbaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listadoVentas.setViewportView(tablaAlbaran);

        javax.swing.GroupLayout PANEL_carritoLayout = new javax.swing.GroupLayout(PANEL_carrito);
        PANEL_carrito.setLayout(PANEL_carritoLayout);
        PANEL_carritoLayout.setHorizontalGroup(
            PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_carritoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(listadoVentas)
                .addGap(15, 15, 15))
        );
        PANEL_carritoLayout.setVerticalGroup(
            PANEL_carritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_carritoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(listadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        informacion2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion2.setText("Nº PEDIDO");

        TFnumPedido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TFnumPedido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFnumPedido.setBorder(null);
        TFnumPedido.setFocusable(false);
        TFnumPedido.setOpaque(false);

        informacion4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        informacion4.setText("FECHA");

        TFDate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TFDate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFDate.setBorder(null);
        TFDate.setFocusable(false);
        TFDate.setOpaque(false);

        informacion3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacion3.setText("Nº ALBARÁN");

        botonEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_albaran/enviar.png"))); // NOI18N
        botonEnviar.setText("ENVIAR");
        botonEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        TFCodAlbaran.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TFCodAlbaran.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFCodAlbaran.setBorder(null);
        TFCodAlbaran.setFocusable(false);
        TFCodAlbaran.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PANEL_carrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PANEL_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(informacion2))
                                    .addComponent(TFnumPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(informacion3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TFCodAlbaran))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFDate)
                                    .addComponent(informacion4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(informacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFnumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFCodAlbaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(informacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(TFDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PANEL_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PANEL_carrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonEnviar)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int calcularCantidadEnviada(int cantidadPedida, int cantidadEnviada) {
        return cantidadPedida - cantidadEnviada;
    }

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        // BOTON ENVIAR
        int numeroAlbaran = Integer.parseInt(TFCodAlbaran.getText());
        int codArticulo = 0, producto = 0, cantidadPedida = 0, cantidadEnviar = 0, cantidadFinal = 0;
        int numAlbaran = generarCodigoAlbaran();

        for (int i = 0; i < tablaAlbaran.getRowCount(); i++) {
            codArticulo = Integer.parseInt(tablaAlbaran.getValueAt(i, 0).toString());
            producto = objConArticulos.mostrarCodigoArticulo(tablaAlbaran.getValueAt(i, 1).toString());
            cantidadPedida = Integer.parseInt(tablaAlbaran.getValueAt(i, 2).toString());
            cantidadEnviar = Integer.parseInt(tablaAlbaran.getValueAt(i, 3).toString());

            cantidadFinal = cantidadPedida - cantidadEnviar;
            if (cantidadPedida >= cantidadEnviar) {

                if (cantidadFinal > 0) {
                    try {
                        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
                        Date date = a.parse(TFDate.getText());
                        long fechaConversion = date.getTime();
                        java.sql.Date fechaDate = new java.sql.Date(fechaConversion);

                        // CREAMOS UN NUEVO ALBARAN
                        objConAlbaran.ingresoAlbaran(numAlbaran, Integer.parseInt(TFCodClie.getText()), Integer.parseInt(TFnumPedido.getText()), fechaDate, "Pendiente");

                        //UPDATE DE LOS ARTICULOS RESTANTES A ENVIAR
                        objConLineaAlbaran.actualizarLineaAlbaran(cantidadFinal, numeroAlbaran, codArticulo);

                        // CREAMOS UN NUEVA LINEA PEDIDO CON LOS ARTICULOS RESTANTES QUE QUEDAN POR ENVIAR
                        objConLineaAlbaran.ingresoLineaAlbaran(numAlbaran, codArticulo, cantidadFinal, precioUnitario, iva);

                    } catch (ParseException ex) {
                        Logger.getLogger(Ven_albaran.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            //ACTUALIZAMOS EL ESTADO DE NUESTRO ALBARAN.
            objConAlbaran.actualizarEstadoAlbaran(numeroAlbaran, "Enviado");

        }
        if (cantidadFinal >= 0) {
            JOptionPane.showMessageDialog(this, "Sus articulos han sido enviados.", "Aviso del Sistema.", JOptionPane.INFORMATION_MESSAGE);
            // LUEGO RESTAMOS LA CANTIDAD ELEGIDA DEL STOCK
            objConArticulos.actualizarStock(cantidadFinal, codArticulo);
            int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea generar un informe e imprimirlo?", "Aviso del Sistema.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (seleccion == 0) {
                try {
                    Connection con = null;
                    // GENERAMOS UN DOCUMENTO JASPER REPORT
                    con = DriverManager.getConnection("jdbc:mysql://localhost/sistema_ventas", "root", "");
                    con.setAutoCommit(false);

                    String ubicacion = "src/main/java/reportes/Albaran.jrxml";
                    JasperReport jasperReport = JasperCompileManager.compileReport(ubicacion);
                    Map<String, Object> params = new HashMap<>();
                    params.put("codAlbaran", numeroAlbaran);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);

                    JasperViewer.viewReport(jasperPrint, false);

//                    JRPdfExporter exporter = new JRPdfExporter();
//                    exporter.setExporterInput(new SimpleExporterInput(print));
//                    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("src/main/java/reportes/Albaran.pdf"));
//                    SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//                    exporter.setConfiguration(configuration);
//                    exporter.exportReport();
                    try {
                        if (con != null) {
                            con.rollback();
                            con.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } catch (JRException | SQLException | NumberFormatException ex) {
                    Logger.getLogger(Ven_albaran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            dispose();
        }


    }//GEN-LAST:event_botonEnviarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANEL_carrito;
    private javax.swing.JPanel PANEL_cliente;
    private javax.swing.JTextField TFCodAlbaran;
    public static javax.swing.JTextField TFCodClie;
    private javax.swing.JTextField TFDate;
    public static javax.swing.JTextField TFDir;
    public static javax.swing.JTextField TFNombreC;
    public static javax.swing.JTextField TFTel;
    private javax.swing.JTextField TFnumPedido;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JLabel informacion2;
    private javax.swing.JLabel informacion3;
    private javax.swing.JLabel informacion4;
    private javax.swing.JScrollPane listadoVentas;
    private javax.swing.JTable tablaAlbaran;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtCodigo1;
    private javax.swing.JLabel txtDir;
    private javax.swing.JLabel txtNombreS;
    // End of variables declaration//GEN-END:variables
}
