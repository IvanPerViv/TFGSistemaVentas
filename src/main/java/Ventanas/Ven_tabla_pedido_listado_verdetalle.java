package Ventanas;

import Conexiones.Con_articulo;
import Conexiones.Con_pedido;
import Conexiones.Con_pedido_linea;
import Modelos.LineaPedido;
import Modelos.Pedido;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iván Pérez
 */
public class Ven_tabla_pedido_listado_verdetalle extends javax.swing.JInternalFrame {

    protected Con_pedido_linea objPedidoLinea;
    protected Con_articulo objArticulo;
    protected Con_pedido objPedido;
    protected DefaultTableModel pedidoLinea;
    protected String estado;
    protected int codPedido;

    public Ven_tabla_pedido_listado_verdetalle(int codigoPedido) {
        initComponents();
        objPedidoLinea = new Con_pedido_linea();
        objArticulo = new Con_articulo();
        objPedido = new Con_pedido();

        this.estado = estado;
        codPedido = codigoPedido;
        cargaDeDatosArticulos(codigoPedido);
        cargaDeDatosPedido();
        calcularPedido();
    }

    protected void cargaDeDatosArticulos(int buscar) {

        String[] nombreTablas = {"CODIGO ARTICULO", "DESCRIPCIÓN PRODUCTO", "CANTIDAD", "PRECIO UNITARIO", "IVA"}; //Cargamos en un array el nombre que tendran nuestras  columnas.
        pedidoLinea = new DefaultTableModel(null, nombreTablas);
        tablaPedidos.setModel(pedidoLinea);

        Object[] fila = new Object[nombreTablas.length];

        ArrayList<LineaPedido> arLineaPedido = new ArrayList<>();
        arLineaPedido = objPedidoLinea.mostrarLineasPedidos(buscar);

        for (int i = 0; i < arLineaPedido.size(); i++) {
            fila[0] = arLineaPedido.get(i).getCodArticulo();
            fila[1] = objArticulo.mostrarNombreArticulo(arLineaPedido.get(i).getCodArticulo()); //SUBCONSULTAA DESCRIPCION PRODUCTO
            fila[2] = arLineaPedido.get(i).getCantidad();
            fila[3] = arLineaPedido.get(i).getPrecioVenta();
            fila[4] = arLineaPedido.get(i).getIva();
            pedidoLinea.addRow(fila);
        }
    }

    protected void cargaDeDatosPedido() {
        ArrayList<Pedido> arPedidos = new ArrayList<Pedido>();
        arPedidos = objPedido.mostrarPedidos("");

        int numPed = 0;
        int numeroCliente = 0;
        String fechaToString="";
        Date fecha;
        for (int i = 0; i < arPedidos.size(); i++) {
            numPed = arPedidos.get(i).getNum_pedido();
            numeroCliente = arPedidos.get(i).getCod_cliente();
            fecha = arPedidos.get(i).getFecha_pedido();

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            fechaToString = dateFormat.format(fecha);
        }

        TFFactura.setText(Integer.toString(numPed));
        TFCodCliente.setText(Integer.toString(numeroCliente));
        TFFecha.setText(fechaToString);
    }

    protected void calcularPedido() {
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
        TFSubtotal.setText(Double.toString(subtotal));
        TFTotal.setText(Double.toString(Math.rint(total)));
    }

    public double calcularIva(double cantidad, double iva) {
        double total;
        return total = (cantidad * iva) / 100;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscadorPedidos = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        TFFactura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TFCodCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TFFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TFSubtotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TFTotal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setClosable(true);
        setTitle("Consulta Pedido");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/VI_icon/iconPedidos.png"))); // NOI18N

        tablaPedidos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPedidos.setOpaque(false);
        buscadorPedidos.setViewportView(tablaPedidos);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Pedido");

        TFFactura.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TFFactura.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFFactura.setBorder(null);
        TFFactura.setEnabled(false);
        TFFactura.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Cod. Cliente");

        TFCodCliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TFCodCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFCodCliente.setBorder(null);
        TFCodCliente.setEnabled(false);
        TFCodCliente.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha");

        TFFecha.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TFFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFFecha.setBorder(null);
        TFFecha.setEnabled(false);
        TFFecha.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Subtotal");

        TFSubtotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TFSubtotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFSubtotal.setBorder(null);
        TFSubtotal.setEnabled(false);
        TFSubtotal.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("TOTAL");

        TFTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TFTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFTotal.setBorder(null);
        TFTotal.setDisabledTextColor(new java.awt.Color(0, 51, 153));
        TFTotal.setEnabled(false);
        TFTotal.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscadorPedidos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(TFFactura))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TFCodCliente))
                                .addGap(286, 286, 286)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFFecha)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TFSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                        .addComponent(jSeparator1)
                                        .addComponent(TFTotal)))))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(buscadorPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TFSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField TFCodCliente;
    public static javax.swing.JTextField TFFactura;
    public static javax.swing.JTextField TFFecha;
    public static javax.swing.JTextField TFSubtotal;
    public static javax.swing.JTextField TFTotal;
    private javax.swing.JScrollPane buscadorPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
