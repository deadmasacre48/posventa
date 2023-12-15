
package Vista;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Menu extends javax.swing.JFrame {
    
    private static JDesktopPane paneD;
    
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setTitle("Sistema de ventas. POS");
        paneD = new JDesktopPane();
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        paneD.setBounds(0,0,ancho,alto);
        this.add(paneD);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        menuItemUsuarios = new javax.swing.JMenuItem();
        menuItemGestorUsuarios = new javax.swing.JMenuItem();
        menuProducto = new javax.swing.JMenu();
        menuItemProducto = new javax.swing.JMenuItem();
        menuItemGestorProducto = new javax.swing.JMenuItem();
        menuItemActualizarStock = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenu();
        menuItemCliente = new javax.swing.JMenuItem();
        menuItemGestorCliente = new javax.swing.JMenuItem();
        menuCategoria = new javax.swing.JMenu();
        menuItemCategoria = new javax.swing.JMenuItem();
        menuItemGestorCategoria = new javax.swing.JMenuItem();
        menuFactura = new javax.swing.JMenu();
        menuItemVenta = new javax.swing.JMenuItem();
        menuItemGestorVenta = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        menuItemReporteCliente = new javax.swing.JMenuItem();
        menuItemReporteCategoria = new javax.swing.JMenuItem();
        menuItemReporteProducto = new javax.swing.JMenuItem();
        menuItemReporteVenta = new javax.swing.JMenuItem();
        menuHistorial = new javax.swing.JMenu();
        menuItemHistorial = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        menuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuUsuario.setForeground(new java.awt.Color(255, 255, 255));
        menuUsuario.setText("Usuarios");
        menuUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        menuItemUsuarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        menuItemUsuarios.setText("Nuevo Usuarios");
        menuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUsuariosActionPerformed(evt);
            }
        });
        menuUsuario.add(menuItemUsuarios);

        menuItemGestorUsuarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemGestorUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        menuItemGestorUsuarios.setText("Gestionar Usuarios");
        menuItemGestorUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestorUsuariosActionPerformed(evt);
            }
        });
        menuUsuario.add(menuItemGestorUsuarios);

        jMenuBar1.add(menuUsuario);

        menuProducto.setForeground(new java.awt.Color(255, 255, 255));
        menuProducto.setText("Productos");
        menuProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        menuItemProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemProducto.setForeground(new java.awt.Color(255, 255, 255));
        menuItemProducto.setText("Nuevo Producto");
        menuItemProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProductoActionPerformed(evt);
            }
        });
        menuProducto.add(menuItemProducto);

        menuItemGestorProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemGestorProducto.setForeground(new java.awt.Color(255, 255, 255));
        menuItemGestorProducto.setText("Gestionar Productos");
        menuItemGestorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestorProductoActionPerformed(evt);
            }
        });
        menuProducto.add(menuItemGestorProducto);

        menuItemActualizarStock.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemActualizarStock.setForeground(new java.awt.Color(255, 255, 255));
        menuItemActualizarStock.setText("Actualizar Stocks");
        menuItemActualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarStockActionPerformed(evt);
            }
        });
        menuProducto.add(menuItemActualizarStock);

        jMenuBar1.add(menuProducto);

        menuCliente.setForeground(new java.awt.Color(255, 255, 255));
        menuCliente.setText("Cliente");
        menuCliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        menuItemCliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemCliente.setForeground(new java.awt.Color(255, 255, 255));
        menuItemCliente.setText("Nuevo Cliente");
        menuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClienteActionPerformed(evt);
            }
        });
        menuCliente.add(menuItemCliente);

        menuItemGestorCliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemGestorCliente.setForeground(new java.awt.Color(255, 255, 255));
        menuItemGestorCliente.setText("Gestionar Clientes");
        menuItemGestorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestorClienteActionPerformed(evt);
            }
        });
        menuCliente.add(menuItemGestorCliente);

        jMenuBar1.add(menuCliente);

        menuCategoria.setForeground(new java.awt.Color(255, 255, 255));
        menuCategoria.setText("Categoria");
        menuCategoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        menuItemCategoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemCategoria.setForeground(new java.awt.Color(255, 255, 255));
        menuItemCategoria.setText("Nueva Categoria");
        menuItemCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCategoriaActionPerformed(evt);
            }
        });
        menuCategoria.add(menuItemCategoria);

        menuItemGestorCategoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemGestorCategoria.setForeground(new java.awt.Color(255, 255, 255));
        menuItemGestorCategoria.setText("Gestionar Categoria");
        menuItemGestorCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestorCategoriaActionPerformed(evt);
            }
        });
        menuCategoria.add(menuItemGestorCategoria);

        jMenuBar1.add(menuCategoria);

        menuFactura.setForeground(new java.awt.Color(255, 255, 255));
        menuFactura.setText("Facturas");
        menuFactura.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        menuItemVenta.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemVenta.setForeground(new java.awt.Color(255, 255, 255));
        menuItemVenta.setText("Nueva Venta");
        menuItemVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVentaActionPerformed(evt);
            }
        });
        menuFactura.add(menuItemVenta);

        menuItemGestorVenta.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemGestorVenta.setForeground(new java.awt.Color(255, 255, 255));
        menuItemGestorVenta.setText("Gestionar ventas");
        menuItemGestorVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestorVentaActionPerformed(evt);
            }
        });
        menuFactura.add(menuItemGestorVenta);

        jMenuBar1.add(menuFactura);

        menuReportes.setForeground(new java.awt.Color(255, 255, 255));
        menuReportes.setText("Reportes");
        menuReportes.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        menuItemReporteCliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemReporteCliente.setForeground(new java.awt.Color(255, 255, 255));
        menuItemReporteCliente.setText("Reportes Cliente");
        menuReportes.add(menuItemReporteCliente);

        menuItemReporteCategoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemReporteCategoria.setForeground(new java.awt.Color(255, 255, 255));
        menuItemReporteCategoria.setText("Reportes Categoria");
        menuReportes.add(menuItemReporteCategoria);

        menuItemReporteProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemReporteProducto.setForeground(new java.awt.Color(255, 255, 255));
        menuItemReporteProducto.setText("Reportes Productos");
        menuReportes.add(menuItemReporteProducto);

        menuItemReporteVenta.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemReporteVenta.setForeground(new java.awt.Color(255, 255, 255));
        menuItemReporteVenta.setText("Reportes Ventas");
        menuReportes.add(menuItemReporteVenta);

        jMenuBar1.add(menuReportes);

        menuHistorial.setForeground(new java.awt.Color(255, 255, 255));
        menuHistorial.setText("Historial");
        menuHistorial.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        menuItemHistorial.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemHistorial.setForeground(new java.awt.Color(255, 255, 255));
        menuItemHistorial.setText("Ver Historial");
        menuHistorial.add(menuItemHistorial);

        jMenuBar1.add(menuHistorial);

        menuSalir.setForeground(new java.awt.Color(255, 255, 255));
        menuSalir.setText("Cerrar Sesion");
        menuSalir.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N

        menuItemSalir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        menuItemSalir.setForeground(new java.awt.Color(255, 255, 255));
        menuItemSalir.setText("Salir de la sesion");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuSalir.add(menuItemSalir);

        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCategoriaActionPerformed
        Categoria cate = new Categoria();
        paneD.add(cate);
        cate.setVisible(true);
    }//GEN-LAST:event_menuItemCategoriaActionPerformed

    private void menuItemGestorCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestorCategoriaActionPerformed
        GestorCategoria gc = new GestorCategoria();
        paneD.add(gc);
        gc.setVisible(true);
    }//GEN-LAST:event_menuItemGestorCategoriaActionPerformed

    private void menuItemProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProductoActionPerformed
        Producto prod = new Producto();
        paneD.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_menuItemProductoActionPerformed

    private void menuItemGestorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestorProductoActionPerformed
        GestorProducto prod = new GestorProducto();
        paneD.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_menuItemGestorProductoActionPerformed

    private void menuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClienteActionPerformed
        Cliente prod = new Cliente();
        paneD.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_menuItemClienteActionPerformed

    private void menuItemGestorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestorClienteActionPerformed
        GestorCliente prod = new GestorCliente();
        paneD.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_menuItemGestorClienteActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void menuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUsuariosActionPerformed
        Usuario prod = new Usuario();
        paneD.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_menuItemUsuariosActionPerformed

    private void menuItemGestorUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestorUsuariosActionPerformed
        GestorUsuario prod = new GestorUsuario();
        paneD.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_menuItemGestorUsuariosActionPerformed

    private void menuItemActualizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarStockActionPerformed
        ActualizaStock prod = new ActualizaStock();
        paneD.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_menuItemActualizarStockActionPerformed

    private void menuItemVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVentaActionPerformed
        Facturar prod = new Facturar();
        paneD.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_menuItemVentaActionPerformed

    private void menuItemGestorVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestorVentaActionPerformed
        GestorVenta prod = new GestorVenta();
        paneD.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_menuItemGestorVentaActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatDarculaLaf());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCategoria;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuFactura;
    private javax.swing.JMenu menuHistorial;
    private javax.swing.JMenuItem menuItemActualizarStock;
    private javax.swing.JMenuItem menuItemCategoria;
    private javax.swing.JMenuItem menuItemCliente;
    private javax.swing.JMenuItem menuItemGestorCategoria;
    private javax.swing.JMenuItem menuItemGestorCliente;
    private javax.swing.JMenuItem menuItemGestorProducto;
    private javax.swing.JMenuItem menuItemGestorUsuarios;
    private javax.swing.JMenuItem menuItemGestorVenta;
    private javax.swing.JMenuItem menuItemHistorial;
    private javax.swing.JMenuItem menuItemProducto;
    private javax.swing.JMenuItem menuItemReporteCategoria;
    private javax.swing.JMenuItem menuItemReporteCliente;
    private javax.swing.JMenuItem menuItemReporteProducto;
    private javax.swing.JMenuItem menuItemReporteVenta;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenuItem menuItemUsuarios;
    private javax.swing.JMenuItem menuItemVenta;
    private javax.swing.JMenu menuProducto;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
