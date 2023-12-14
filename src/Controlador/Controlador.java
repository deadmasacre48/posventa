
package Controlador;

import Conexion.Conexion;
import Modelo.*;
import Vista.*;
import java.sql.*;
import javax.swing.JComboBox;
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
        }catch(Exception e){
            System.out.println("Error al iniciar seccion : " + e);
        }
        return r;
    }
    
    
    
    
    
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
        }catch(SQLException e){
            System.out.println("Error al Consultar Categoria : "+e);
        }
        return r;
    }
    
    public void CargarCategoria(GestorCategoria gc){
        Connection cn = Conexion.conectar();
        DefaultTableModel model = (DefaultTableModel) gc.tablaCategorias.getModel();
        String sql = "select idcategoria, direccion, estado from tbcategoria";
        Statement st = null;
        try{
            st = cn.createStatement();
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
        Statement st = null;
        Connection cn = Conexion.conectar();
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                r = true;
            }
        }catch(SQLException e){
            System.out.println("Error al Ver existencia de Producto : "+e);
        }
        return r;
    }
    
    public void CargarComboCategoria(JComboBox comboboxcategoria){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbcategoria";
        Statement st = null;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboboxcategoria.removeAllItems();
            comboboxcategoria.addItem("Seleccione:");
            while(rs.next()){
                comboboxcategoria.addItem(rs.getString("direccion"));
            }
        }catch(SQLException e){
            System.out.println("Error al Cargar categorias en combobox : "+e);
        }
    }
    
    public void CargarComboProducto(JComboBox comboboxcategoria){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbproducto";
        Statement st = null;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboboxcategoria.removeAllItems();
            comboboxcategoria.addItem("Seleccione:");
            while(rs.next()){
                comboboxcategoria.addItem(rs.getString("nombre"));
            }
        }catch(SQLException e){
            System.out.println("Error al Cargar producto en combobox : "+e);
        }
    }
    
    public int CargarStockProducto(JComboBox comboboxcategoria, int idproducto, JTextField cantidad){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbproducto where nombre = '"+String.valueOf(comboboxcategoria.getSelectedItem())+"'";
        Statement st = null;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                idproducto = rs.getInt("idproducto");
                cantidad.setText(String.valueOf( rs.getInt("cantidad")));
            }
        }catch(SQLException e){
            System.out.println("Error al Cargar producto en combobox : "+e);
        }
        return idproducto;
    }
    
    public boolean ActualizarStockProducto(int idproducto, String cantidad){
        boolean r = false;
        Connection cn = Conexion.conectar();
        String sql = "update tbproducto set cantidad = '"+cantidad+"' where idproducto = '"+idproducto+"'";
        Statement st = null;
        try{
            st = cn.createStatement();
            if(st.executeUpdate(sql)>0){
                r = true;
            }
        }catch(SQLException e){
            System.out.println("Error al Actualizar cantidad de producto : "+e);
        }
        return r;
    }
    
    public int ObtenerIdCategoria(JComboBox comboboxcategoria, int id){
        Connection cn = Conexion.conectar();
        String sql = "select * from tbcategoria where direccion = '"+comboboxcategoria.getSelectedItem()+"'";
        Statement st = null;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt("idcategoria");
            }
        }catch(SQLException e){
            System.out.println("Error al obtener id de categoria : "+e);
        }
        return id;
    }
    
    public void CargarTablaProducto(GestorProducto gc){
        Connection cn = Conexion.conectar();
        DefaultTableModel model = (DefaultTableModel) gc.tableproductos.getModel();
        String sql = "select p.idproducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, c.direccion, p.estado from tbproducto as p,tbcategoria as c where p.idcategoria = c.idcategoria;";
        Statement st = null;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] o = new Object[8];
                for(int i=0; i<8; i++){
                    if(i ==5){
                        //CalcularPrecio(Double.parseDouble(gc.txtprecio.getText()), Integer.parseInt(gc.comboboxiva.getSelectedItem().toString()),gc);
                    }
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
        Statement st = null;
        String cate = "";
        try{
            st = cn.createStatement();
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
        Statement st = null;
        Connection cn = Conexion.conectar();
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                r = true;
            }
        }catch(SQLException e){
            System.out.println("Error al Ver existencia de usuarios : "+e);
        }
        return r;
    }
    
    public void CargarTablaUsuarios(GestorUsuario gc){
        Connection cn = Conexion.conectar();
        DefaultTableModel model = (DefaultTableModel) gc.tableUsuarios.getModel();
        String sql = "select * from tbusuarios";
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
    
}
