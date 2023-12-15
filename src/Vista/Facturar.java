
package Vista;

import Controlador.Controlador;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class Facturar extends javax.swing.JInternalFrame {
    private Controlador c = new Controlador();
    private SpinnerNumberModel nummodel;
    
    public int idproducto = 0;
    public String nombre = "";
    public int cantidad = 0;
    public double precio = 0.0;
    public double iva = 0.0;
    public int cantidadAPedir = 0;
    public double subtotal = 0.0;
    public double descuento = 0.0;
    public double calculoiva = 0.0;
    public double totalpagar = 0.0;
    public int axiddetalle = 1;
    
    
    public Facturar() {
        initComponents();
        nummodel = (SpinnerNumberModel)spinnercantidad.getModel();
        c.CargarComboCliente(comboboxcliente);
        c.CargarComboProducto(comboboxproducto);
        c.CargarTablaFactura(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboboxcliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboboxproducto = new javax.swing.JComboBox<>();
        txtcliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnagregarproducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablefactura = new javax.swing.JTable();
        spinnercantidad = new javax.swing.JSpinner();
        btnbuscarproducto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbpago = new javax.swing.JLabel();
        lbsobrante = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtIVA = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txtefectivo = new javax.swing.JTextField();
        txtcambio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btncancela = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        btntargeta = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Nueva Facturacion");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hacer nueva factura a cliente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cliente");

        comboboxcliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboboxcliente.setForeground(new java.awt.Color(255, 255, 255));
        comboboxcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Null)" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Productos");

        comboboxproducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboboxproducto.setForeground(new java.awt.Color(255, 255, 255));
        comboboxproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Null)" }));
        comboboxproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxproductoActionPerformed(evt);
            }
        });

        txtcliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");

        btnagregarproducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnagregarproducto.setForeground(new java.awt.Color(255, 255, 255));
        btnagregarproducto.setText("Agregar");
        btnagregarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarproductoActionPerformed(evt);
            }
        });

        tablefactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cantidad", "P. Unitario", "SubTotal", "Descuento", "IVA", "Total Pagar", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablefactura);

        spinnercantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        spinnercantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnercantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spinnercantidadKeyTyped(evt);
            }
        });

        btnbuscarproducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnbuscarproducto.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscarproducto.setText("Buscar");
        btnbuscarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarproductoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sub total:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descuento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("IVA:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total:");

        lbpago.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbpago.setForeground(new java.awt.Color(255, 255, 255));
        lbpago.setText("Efectivo");

        lbsobrante.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbsobrante.setForeground(new java.awt.Color(255, 255, 255));
        lbsobrante.setText("Cambio");

        txtsubtotal.setEditable(false);
        txtsubtotal.setForeground(new java.awt.Color(255, 255, 255));
        txtsubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDescuento.setEditable(false);
        txtDescuento.setForeground(new java.awt.Color(255, 255, 255));
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtIVA.setEditable(false);
        txtIVA.setForeground(new java.awt.Color(255, 255, 255));
        txtIVA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txttotal.setEditable(false);
        txttotal.setForeground(new java.awt.Color(255, 255, 255));
        txttotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtefectivo.setForeground(new java.awt.Color(255, 255, 255));
        txtefectivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtefectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtefectivoKeyTyped(evt);
            }
        });

        txtcambio.setEditable(false);
        txtcambio.setForeground(new java.awt.Color(255, 255, 255));
        txtcambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsubtotal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbsobrante, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtcambio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescuento))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtIVA))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txttotal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbpago, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtefectivo)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbpago)
                    .addComponent(txtefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbsobrante)
                    .addComponent(txtcambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sumatorio de factura");

        btncancela.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncancela.setForeground(new java.awt.Color(255, 255, 255));
        btncancela.setText("Cancelar");

        btneliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setText("Eliminar");

        btnregistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrar.setText("Registrar");

        btntargeta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntargeta.setForeground(new java.awt.Color(255, 255, 255));
        btntargeta.setText("Efectivo");
        btntargeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntargetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(comboboxproducto, javax.swing.GroupLayout.Alignment.LEADING, 0, 199, Short.MAX_VALUE)
                                        .addComponent(comboboxcliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnercantidad))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnbuscarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnagregarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnregistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntargeta, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncancela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboboxcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscarproducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboboxproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spinnercantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnagregarproducto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(32, 32, 32)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncancela)
                            .addComponent(btnregistrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btneliminar)
                            .addComponent(btntargeta))
                        .addGap(6, 6, 6)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtefectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtefectivoKeyTyped
        if(btntargeta.getText().equals("Targeta")){
            char e = evt.getKeyChar();
            if(Character.isDigit(e)){

            }else{
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }else{
            
        }
    }//GEN-LAST:event_txtefectivoKeyTyped

    private void btntargetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntargetaActionPerformed
        if(btntargeta.getText().equals("Targeta")){
            lbpago.setText("Targeta");
            lbsobrante.setText("Codigo");
            txtcambio.setEditable(true);
            btntargeta.setText("Efectivo");
        }else if(btntargeta.getText().equals("Efectivo")){
            lbpago.setText("Efectivo");
            lbsobrante.setText("Cambio");
            txtcambio.setEditable(false);
            btntargeta.setText("Targeta");
        }
    }//GEN-LAST:event_btntargetaActionPerformed

    private void btnbuscarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarproductoActionPerformed
        if(!txtcliente.getText().equals("")){
            c.BuscarClienteCedula(comboboxcliente, txtcliente.getText().trim());
        }else{
            JOptionPane.showMessageDialog(null, "Introduce una cedula valida.", 
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnbuscarproductoActionPerformed

    private void btnagregarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarproductoActionPerformed
        if(!comboboxproducto.getSelectedItem().equals("Seleccione:")){
            DefaultTableModel model = (DefaultTableModel) tablefactura.getModel();
            for(int i=tablefactura.getRowCount(); i>0; i--){
                model.removeRow(i-1);
            }
            cantidadAPedir = (int) spinnercantidad.getValue();
            subtotal = precio * cantidadAPedir;
            totalpagar = subtotal + calculoiva + descuento;
            subtotal = Math.round(subtotal * 100)/100;
            calculoiva = Math.round(calculoiva * 100)/100;
            descuento = Math.round(descuento * 100)/100;
            totalpagar = Math.round(totalpagar * 100)/100;
            c.insertarProductoDB(this, 1);
            c.CargarTablaFactura(this);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un producto", 
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnagregarproductoActionPerformed

    private void spinnercantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spinnercantidadKeyTyped
        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            
        }else{
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_spinnercantidadKeyTyped

    private void comboboxproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxproductoActionPerformed
        c.InsertarProducto(this);
        nummodel.setMaximum(cantidad);
        nummodel.setValue(1);
    }//GEN-LAST:event_comboboxproductoActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnagregarproducto;
    public javax.swing.JButton btnbuscarproducto;
    public javax.swing.JButton btncancela;
    public javax.swing.JButton btneliminar;
    public javax.swing.JButton btnregistrar;
    public javax.swing.JButton btntargeta;
    public javax.swing.JComboBox<String> comboboxcliente;
    public javax.swing.JComboBox<String> comboboxproducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbpago;
    public javax.swing.JLabel lbsobrante;
    public javax.swing.JSpinner spinnercantidad;
    public javax.swing.JTable tablefactura;
    public javax.swing.JTextField txtDescuento;
    public javax.swing.JTextField txtIVA;
    public javax.swing.JTextField txtcambio;
    public javax.swing.JTextField txtcliente;
    public javax.swing.JTextField txtefectivo;
    public javax.swing.JTextField txtsubtotal;
    public javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
