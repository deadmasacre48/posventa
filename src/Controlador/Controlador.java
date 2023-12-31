
package Controlador;

import Conexion.Conexion;
import Modelo.*;
import Vista.*;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Controlador {
    
    public boolean loginUser(UsuarioM user){
        boolean r = false;
        Connection cn = Conexion.conectar();
        String sql = "select usuario, clave from tbusuarios where usuario ='"+user.getUsuario()+"' and clave = '"+user.getClave()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                r = true;
            }
            cn.close();
        }catch(Exception e){
            System.out.println("Error al iniciar seccion : " + e);
        }
        return r;
    }
    
    
    
    
    //Metodos dedicados unicamente a categoria
    public boolean GuardarCategoria(CategoriaM cate){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("insert into tbcategoria value (?,?,?)");
            consul.setInt(1, 0);
            consul.setString(2, cate.getDescripcion());
            consul.setInt(3,cate.getEstado());
            if(consul.executeUpdate() >0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Guardar Categoria : "+e);
        }
        return r;
    }
    public boolean ExisteCategoria(String cate){
        boolean r = false;
        String sql = "select direccion from tbcategoria where direccion = '"+cate+"'";
        Statement st = null;
        Connection cn = Conexion.conectar();
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Consultar Categoria : "+e);
        }
        return r;
    }
    public void CargarCategoria(GestorCategoria gc){
        Connection cn = Conexion.conectar();
        DefaultTableModel model = (DefaultTableModel) gc.tablaCategorias.getModel();
        String sql = "select idcategoria, direccion, estado from tbcategoria";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] o = new Object[3];
                for(int i=0; i<3; i++){
                    o[i] = rs.getObject(i+1);
                    
                }
                model.addRow(o);
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar la tabla Categria : "+e);
        }
    }
    public void enviardcs(GestorCategoria gc, int id){
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement ps = cn.prepareStatement("select * from tbcategoria where idcategoria = '"+id+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                gc.txtdescripcion.setText(rs.getString("direccion"));
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Actualizar la tabla Categria : "+e);
        }
    }
    public boolean ActualizarTablaCategoria(CategoriaM cate, int id){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("update tbcategoria set direccion = ? where idcategoria='"+id+"'");
            consul.setString(1, cate.getDescripcion());
            if(consul.executeUpdate() >0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Actualizar Categoria : "+e);
        }
        return r;
    }
    public boolean EliminarCategoria(int id){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("delete from tbcategoria where idcategoria='"+id+"'");
            consul.executeUpdate();
            if(consul.executeUpdate() > 0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Eliminar Categoria : "+e);
        }
        return r;
    }
    
    
    
    
    
    //Metodos dedicados a producto
    public boolean GuardarProducto(ProductoM cate){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("insert into tbproducto value (?,?,?,?,?,?,?,?)");
            consul.setInt(1, 0);
            consul.setString(2, cate.getNombre());
            consul.setInt(3, cate.getCantidad());
            consul.setDouble(4, cate.getPrecio());
            consul.setString(5, cate.getDescripcion());
            consul.setInt(6, cate.getProcentajeIva());
            consul.setInt(7, cate.getIdCategoria());
            consul.setInt(8,cate.getEstado());
            if(consul.executeUpdate() >0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Guardar Producto : "+e);
        }
        return r;
    }
    public boolean ExisteProducto(String cate){
        boolean r = false;
        String sql = "select nombre from tbproducto where nombre = '"+cate+"'";
        Connection cn = Conexion.conectar();
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Ver existencia de Producto : "+e);
        }
        return r;
    }
    public void CargarComboCategoria(JComboBox comboboxcategoria){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbcategoria";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboboxcategoria.removeAllItems();
            comboboxcategoria.addItem("Seleccione:");
            while(rs.next()){
                comboboxcategoria.addItem(rs.getString("direccion"));
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar categorias en combobox : "+e);
        }
    }
    public void CargarComboProducto(JComboBox comboboxcategoria){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbproducto";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboboxcategoria.removeAllItems();
            comboboxcategoria.addItem("Seleccione:");
            while(rs.next()){
                comboboxcategoria.addItem(rs.getString("nombre"));
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar producto en combobox : "+e);
        }
    }
    public void CargarComboProducto(JComboBox comboboxcategoria, Facturar p){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbproducto";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboboxcategoria.removeAllItems();
            comboboxcategoria.addItem("Seleccione:");
            while(rs.next()){
                if(obtenerCantidadProducto(p, rs.getString("nombre"))>0){
                    comboboxcategoria.addItem(rs.getString("nombre"));
                }
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar producto en combobox : "+e);
        }
    }
    public int CargarStockProducto(JComboBox comboboxcategoria, int idproducto, JTextField cantidad){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbproducto where nombre = '"+String.valueOf(comboboxcategoria.getSelectedItem())+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                idproducto = rs.getInt("idproducto");
                cantidad.setText(String.valueOf( rs.getInt("cantidad")));
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar producto en combobox : "+e);
        }
        return idproducto;
    }
    public boolean ActualizarStockProducto(int idproducto, String cantidad){
        boolean r = false;
        Connection cn = Conexion.conectar();
        String sql = "update tbproducto set cantidad = '"+cantidad+"' where idproducto = '"+idproducto+"'";
        try{
            Statement st = cn.createStatement();
            if(st.executeUpdate(sql)>0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Actualizar cantidad de producto : "+e);
        }
        return r;
    }
    public int ObtenerIdCategoria(JComboBox comboboxcategoria, int id){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbcategoria where direccion = '"+comboboxcategoria.getSelectedItem()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt("idcategoria");
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al obtener id de categoria : "+e);
        }
        return id;
    }
    public void CargarTablaProducto(GestorProducto gc){
        Connection cn = Conexion.conectar();
        DefaultTableModel model = (DefaultTableModel) gc.tableproductos.getModel();
        String sql = "select p.idproducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, c.direccion, p.estado from tbproducto as p,tbcategoria as c where p.idcategoria = c.idcategoria;";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] o = new Object[8];
                for(int i=0; i<8; i++){
                    
                    o[i] = rs.getObject(i+1);
                }
                model.addRow(o);
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar la tabla Producto : "+e);
        }
    }
    public double CalcularPrecio(double precio, int iva, GestorProducto gc){
        int iv = iva;
        switch(iv){
            case 0: gc.IVA = 0.0;
            break;
            case 12: gc.IVA = precio * 0.12;
            break;
            case 14: gc.IVA = precio * 0.14;
            default : 
            break;
        }
        gc.IVA = (double)Math.round(gc.IVA*100)/100;
        return gc.IVA;
    }
    public void enviardps(GestorProducto gc, int id){
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement ps = cn.prepareStatement("select * from tbproducto where idproducto = '"+id+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                gc.txtnombre.setText(rs.getString("nombre"));
                gc.txtcantidad.setText(String.valueOf(rs.getInt("cantidad")));
                gc.txtprecio.setText(String.valueOf(rs.getDouble("precio")));
                gc.txtdescripcion.setText(rs.getString("descripcion"));
                int i = (int) rs.getDouble("porcentajeIva");
                gc.comboboxiva.setSelectedItem(i);
                int idc = rs.getInt("idcategoria");
                gc.comboboxcategoria.setSelectedItem(ObetenerNombreCategoria(idc));
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Actualizar la tabla Producto : "+e);
        }
    }
    public String ObetenerNombreCategoria(int id){
        Connection cn = Conexion.conectar();
        String sql = "select direccion from tbcategoria where idcategoria='"+id+"'";
        String cate = "";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                cate = rs.getString("direccion");
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar categorias en Nombre : "+e);
        }
        return cate;
    }
    public boolean EliminarProducto(int id){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("delete from tbproducto where idproducto='"+id+"'");
            consul.executeUpdate();
            if(consul.executeUpdate() > 0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Eliminar Producto : "+e);
        }
        return r;
    }
    public boolean ActualizarTablaProducto(ProductoM cate, int id){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("update tbproducto set nombre=?, cantidad=?, precio=?,descripcion=?,porcentajeIva=?,idcategoria=? where idproducto='"+id+"'");
            consul.setString(1, cate.getNombre());
            consul.setInt(2, cate.getCantidad());
            consul.setDouble(3, cate.getPrecio());
            consul.setString(4, cate.getDescripcion());
            consul.setInt(5, cate.getProcentajeIva());
            consul.setInt(6, cate.getIdCategoria());
            if(consul.executeUpdate() >0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Actualizar Productos : "+e);
        }
        return r;
    }
    
    
    
    
    
    //Metoos dedicados a el apartado de CLIENTE
    public boolean ExisteCliente(String cedu){
        boolean r = false;
        String sql = "select cedula from tbcliente where cedula = '"+cedu+"'";
        Statement st = null;
        Connection cn = Conexion.conectar();
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Ver existencia de Cliente : "+e);
        }
        return r;
    }
    public boolean GuardarCliente(Cliente c, int stado){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("insert into tbcliente(nombre,apellido,cedula,telefono,direccion,estado) value('"+c.txtnombre.getText()+"','"+c.txtapellido.getText()+"','"+c.txtcedula.getText()+"','"+c.txttelefono.getText()+"','"+c.txtdireccion.getText()+"', '"+stado+"')");
            if(consul.executeUpdate() >0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Guardar Cliente : "+e);
        }
        return r;
    }
    public void CargarTablaCliente(GestorCliente gc){
        Connection cn = Conexion.conectar();
        DefaultTableModel model = (DefaultTableModel) gc.tablecliente.getModel();
        String sql = "select * from tbcliente";
        Statement st = null;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] o = new Object[7];
                for(int i=0; i<7; i++){
                    o[i] = rs.getObject(i+1);
                }
                model.addRow(o);
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar la tabla Cliente : "+e);
        }
    }
    public void enviardatoscliente(GestorCliente gc, int id){
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement ps = cn.prepareStatement("select * from tbcliente where idcliente = '"+id+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                gc.txtnombre.setText(rs.getString("nombre"));
                gc.txtapellido.setText(rs.getString("apellido"));
                gc.txtcedula.setText(rs.getString("cedula"));
                gc.txttelefono.setText(rs.getString("telefono"));
                gc.txtdireccion.setText(rs.getString("direccion"));
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Actualizar la tabla Producto : "+e);
        }
    }
    public boolean EliminarCliente(int id){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("delete from tbcliente where idcliente='"+id+"'");
            consul.executeUpdate();
            if(consul.executeUpdate() > 0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Eliminar cliente : "+e);
        }
        return r;
    }
    public boolean ActualizarTablaCliente(GestorCliente cate, int id, int state){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("update tbcliente set nombre='"+cate.txtnombre.getText()+"',apellido='"+cate.txtapellido.getText()+"',"
                    + "cedula='"+cate.txtcedula.getText()+"',telefono='"+cate.txttelefono.getText()+"',direccion='"+cate.txtdireccion.getText()+"',estado='"+state+"' where idcliente='"+id+"'");
            if(consul.executeUpdate() >0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Actualizar Cliente : "+e);
        }
        return r;
    }
    
    
    
    
    
    //Metodos dedicados a el apartado USUARIOS
    public boolean GuardarUsuario(Usuario c, int stado){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("insert into tbusuarios(nombre,apellido,usuario,clave,telefono,estado) value('"+c.txtnombre.getText()+"','"+c.txtapellido.getText()+"','"+c.txtusuario.getText()+"','"+String.valueOf(c.txtclave.getPassword())+"','"+c.txttelefono.getText()+"', '"+stado+"')");
            if(consul.executeUpdate() >0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Guardar usuarios : "+e);
        }
        return r;
    }
    public boolean ExisteUsuario(String cedu){
        boolean r = false;
        String sql = "select usuario from tbusuarios where usuario = '"+cedu+"'";
        Connection cn = Conexion.conectar();
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Ver existencia de usuarios : "+e);
        }
        return r;
    }
    public void CargarTablaUsuarios(GestorUsuario gc){
        Connection cn = Conexion.conectar();
        DefaultTableModel model = (DefaultTableModel) gc.tableUsuarios.getModel();
        String sql = "select * from tbusuarios";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] o = new Object[7];
                for(int i=0; i<7; i++){
                    o[i] = rs.getObject(i+1);
                }
                model.addRow(o);
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar la tabla Usuarios : "+e);
        }
    }
    public void enviardatosUsuarios(GestorUsuario gc, int id){
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement ps = cn.prepareStatement("select * from tbusuarios where idusuarios = '"+id+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                gc.txtnombre.setText(rs.getString("nombre"));
                gc.txtapellido.setText(rs.getString("apellido"));
                gc.txtusuario.setText(rs.getString("usuario"));
                gc.txtclave.setText(rs.getString("clave"));
                gc.txttelefono.setText(rs.getString("telefono"));
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Actualizar la tabla Usuarios : "+e);
        }
    }
    public boolean EliminarUsuario(int id){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("delete from tbusuarios where idusuarios='"+id+"'");
            consul.executeUpdate();
            if(consul.executeUpdate() > 0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Eliminar usuario : "+e);
        }
        return r;
    }
    public boolean ActualizarTablaUsuarios(GestorUsuario cate, int id, int state){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("update tbusuarios set nombre='"+cate.txtnombre.getText()+"',apellido='"+cate.txtapellido.getText()+"',"
                    + "usuario='"+cate.txtusuario.getText()+"',clave='"+String.valueOf(cate.txtclave.getText())+"',telefono='"+cate.txttelefono.getText()+"',estado='"+state+"' where idusuarios='"+id+"'");
            if(consul.executeUpdate() >0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Actualizar Usuarios : "+e);
        }
        return r;
    }
    
    
    
    
    
    //Metodos dedicados al apartado de FACTURACION
    public void CargarComboCliente(JComboBox comboboxcategoria){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbcliente";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboboxcategoria.removeAllItems();
            comboboxcategoria.addItem("Seleccione:");
            while(rs.next()){
                comboboxcategoria.addItem(rs.getString("nombre")+" "+rs.getString("apellido"));
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar clientes en comboBox : "+e);
        }
    }
    public void BuscarClienteCedula(JComboBox comboboxcategoria, String cedula){
        Connection cn = Conexion.conectar();
        String sql = "select nombre, apellido from tbcliente where cedula = '"+cedula+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Toolkit.getDefaultToolkit().beep();
                comboboxcategoria.setSelectedItem(rs.getString("nombre")+" "+rs.getString("apellido"));
            }else{
                comboboxcategoria.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "El cliente no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar clientes en comboBox : "+e);
        }
    }
    public void CargarTablaFactura(Facturar gc){
        Connection cn = Conexion.conectar();
        DefaultTableModel model = (DefaultTableModel) gc.tablefactura.getModel();
        String sql = "select iddetalleventa,idproducto,cantidad,precioUnidad,subTotal,descuento,iva,totalPagar,estado from tbdetalleventa";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] o = new Object[9];
                for(int i=0; i<9; i++){
                    if(i == 1){
                        o[i] = ObtenerNombreProducto((int) rs.getObject(i+1));
                    }else{
                        o[i] = rs.getObject(i+1);
                    }
                }
                model.addRow(o);
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar la tabla Factura : "+e);
        }
    }
    public void InsertarProducto(Facturar p){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbproducto where nombre = '"+p.comboboxproducto.getSelectedItem()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                p.idproducto = rs.getInt("idproducto");
                p.nombre = rs.getString("nombre");
                p.cantidad = rs.getInt("cantidad");
                p.precio = rs.getDouble("precio");
                p.iva = rs.getDouble("porcentajeIva");
                CalcularIva(p, p.precio, p.iva);
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Insertar productos a factura: "+e);
        }
    }
    public void CalcularIva(Facturar p, double precio, double iva){
        int piva = (int) iva;
        switch(piva){
            case 0: p.calculoiva = 0.0;
                break;
            case 12: p.calculoiva = (p.precio * p.cantidad) * 0.12;
                break;
            case 14: p.calculoiva = (p.precio * p.cantidad) * 0.14;
                break;
            default: System.out.println("Error en iva");
                break;
        }
    }
    public boolean insertarProductoDB(Facturar p, int stado){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("insert into tbdetalleventa(idcabezeraventa,idproducto,cantidad,precioUnidad,subTotal,descuento,iva,totalPagar,estado) "
                    + "value('"+p.axiddetalle+"','"+p.idproducto+"','"+p.cantidadAPedir+"','"+p.precio+"','"+p.subtotal+"','"+1+"','"+p.calculoiva+"','"+p.totalpagar+"','"+stado+"')");
            if(consul.executeUpdate() >0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al insertar producto de db: "+e);
        }
        return r;
    }
    public String ObtenerNombreProducto(int id){
        String nombre ="";
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement ps = cn.prepareStatement("select nombre from tbproducto where idproducto = '"+id+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nombre = rs.getString("nombre");
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Obtener nombre de producto: "+e);
        }
        return nombre;
    }
    public void CalcularTotalFactura(Facturar p){
        p.subtotalgeneral = 0;
        p.ivageneral = 0;
        p.descuentogeneral = 0;
        p.totalpagargeneral = 0;
        DefaultTableModel model = (DefaultTableModel) p.tablefactura.getModel();
        for(int i=0; i<model.getRowCount(); i++){
            p.subtotalgeneral += (double) model.getValueAt(i, 4);
            p.ivageneral += (double) model.getValueAt(i, 6);
            p.descuentogeneral += (double) model.getValueAt(i, 5);
            p.totalpagargeneral += (double) model.getValueAt(i, 7);
        }
        p.txtsubtotal.setText(p.subtotalgeneral+"");
        p.txtDescuento.setText(p.descuentogeneral+"");
        p.txtIVA.setText(p.ivageneral+"");
        p.txttotal.setText(p.totalpagargeneral+"");
    }
    public int obtenerCantidadProducto(Facturar p, String nombre){
        int c =0;
        DefaultTableModel model = (DefaultTableModel) p.tablefactura.getModel();
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement ps = cn.prepareStatement("select cantidad from tbproducto where nombre = '"+nombre+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = rs.getInt("cantidad");
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Obtener cantidad de productos: "+e);
        }
        return c;
    }
    public boolean DiscontarCantidadProducto(Facturar p){
        boolean r = false;
        DefaultTableModel model = (DefaultTableModel) p.tablefactura.getModel();
        for(int i=0; i<model.getRowCount(); i++){
            Connection cn = Conexion.conectar();
            try{
                if(obtenerCantidadProducto(p, (String) model.getValueAt(i, 1))>0){
                    PreparedStatement consul = cn.prepareStatement("update tbproducto set cantidad='"+(obtenerCantidadProducto(p, (String) model.getValueAt(i, 1))-(int)model.getValueAt(i, 2))+"' where nombre='"+model.getValueAt(i, 1)+"'");
                    if(consul.executeUpdate() >0){
                        r = true;
                    }
                }else{
                    JOptionPane.showMessageDialog(p, "No tienes suficientes productos para " + model.getValueAt(i, 1),
                            "ERROR",JOptionPane.ERROR_MESSAGE);
                }
                cn.close();
            }catch(SQLException e){
                System.out.println("Error al Disminuir la cantidad de productos : "+e);
            }
        }
        return r;
    }
    public boolean EliminarTodoFactura(Facturar p){
        boolean r = false;
        DefaultTableModel model = (DefaultTableModel) p.tablefactura.getModel();
        for (int i = p.tablefactura.getRowCount(); i > 0; i--) {
            EliminarUnoFactura((int) model.getValueAt(i-1, 0));
        }
        return r;
    }
    public boolean EliminarUnoFactura(int id){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("delete from tbdetalleventa where iddetalleventa='"+id+"'");
            consul.executeUpdate();
            if(consul.executeUpdate() > 0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Eliminar una factura : "+e);
        }
        return r;
    }
    public void CalcularEfectivo(Facturar p){
        double total = Double.parseDouble(p.txttotal.getText());
        double efe = Double.parseDouble(p.txtefectivo.getText());
        double sobr = efe-total;
        
        p.txtcambio.setText(sobr+"");
    }
    public int obtenerIdCliente(String nombre){
        Connection cn = Conexion.conectar();
        String sql = "select idcliente from tbcliente where nombre='"+nombre+"'";
        int cate = 0;
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                cate = rs.getInt("idcliente");
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Obtener id de cliente: "+e);
        }
        return cate;
    }
    public boolean GuardarFactura(Facturar p,String cliente, Date dia, int state){
        boolean r = false;
        Connection cn = Conexion.conectar();
        try{
            PreparedStatement consul = cn.prepareStatement("insert into tbcabezeraventa(idcliente,valorPagar,fechaVenta,estado) "
                    + "value('"+obtenerIdCliente(cliente)+"','"+p.txttotal.getText()+"','"+dia+"','"+state+"')");
            if(consul.executeUpdate() >0){
                r = true;
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al GuardarFactura: "+e);
        }
        return r;
    }
    
    
    
    
    
    //Metodos dedicados al apartado de ADMINISTRAR VENTAS
    public void cargarTablaVentas(GestorVenta gv){
        Connection cn = Conexion.conectar();
        DefaultTableModel model = (DefaultTableModel) gv.tabledetalles.getModel();
        String sql = "select idcliente,valorPagar,fechaVenta,estado from tbcabezeraventa";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] o = new Object[4];
                for(int i=0; i<4; i++){
                    if(i==0){
                        o[i] = obtenerNombreCliente(rs.getInt(i+1));
                    }else{
                        o[i] = rs.getObject(i+1);
                    }
                }
                model.addRow(o);
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar la tabla Venta y Detalles: "+e);
        }
    }
    public String obtenerNombreCliente(int id){
        Connection cn = Conexion.conectar();
        String nombre = "";
        String sql = "select * from tbcliente where idcliente='"+id+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                nombre = rs.getString("nombre")+" "+rs.getString("apellido");
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Obtener el nombre del cliente : "+e);
        }
        return nombre;
    }
    
    
    
    
    
    //Metodos dedicados al apartado de HISTORIAL
    public void MostrarVentasSeleccionadas(Historial gc, String fechai, String fechaf){
        Connection cn = Conexion.conectar();
        String sql = "select fechaVenta, count(fechaVenta) as Ventas from tbcabezeraventa where fechaVenta between '"+fechai+"' and '"+fechaf+"'";
        DefaultTableModel model = (DefaultTableModel) gc.tablehistorial.getModel();
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] o = new Object[2];
                for(int i=0; i<2; i++){
                    o[i] = rs.getObject(i+1);
                }
                model.addRow(o);
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar la tabla Factura : "+e);
        }
    }
    
    
}
