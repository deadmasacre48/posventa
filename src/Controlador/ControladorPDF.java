
package Controlador;

import Conexion.Conexion;
import Vista.Facturar;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorPDF {
    
    private String nombreCliente;
    private String CedulaCliente;
    private String TelefonoCliente;
    private String DireccionCliente;
    private String fechaActual = "";
    private String nombreArchivoPDF = "";
    private Controlador c = new Controlador();
    
    public void ObtenerDatosCliente(int idCliente){
        String sql = "select * from tbcliente where idcliente='"+idCliente+"'";
        Connection cn = Conexion.conectar();
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                nombreCliente = rs.getString("nombre")+"_"+rs.getString("apellido");
                CedulaCliente = rs.getString("cedula");
                TelefonoCliente = rs.getString("telefono");
                DireccionCliente = rs.getString("direccion");
            }
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al Obtener Datos de cliente: "+e);
        }
    }
    public void generarFacturaPDF(Facturar p){
        try{
            Date dia = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(dia);
            String fechaNueva = "";
            for(int i=0; i<fechaActual.length(); i++){
                if(fechaActual.charAt(i)=='/'){
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }
            nombreArchivoPDF = "Venta_" + nombreCliente+"_"+fechaNueva+".pdf";
            FileOutputStream archivo;
            File file = new File("src/pdf/"+nombreArchivoPDF);
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            Paragraph fecha = new Paragraph();
            fecha.add(Chunk.NEWLINE);
            fecha.add("Factura: 001" + "\nFecha: "+fechaActual+"\n\n");
            PdfPTable enca = new PdfPTable(4);
            enca.setWidthPercentage(100);
            enca.getDefaultCell().setBorder(0);
            float[] column = new float[]{20f,30f,70f,40f};
            enca.setWidths(column);
            enca.setHorizontalAlignment(Element.ALIGN_LEFT);
            String ru="0987654321098",nombre="Masacre Corps.",telefono="8297580412",direccion="Tamarindo City",razon="Lo que queremos, Lo hacemos";
            enca.addCell("");
            enca.addCell("RUC: "+ru+" NOMBRE: "+nombre+" TELEFONO: "+telefono+" DIRECCION: "+direccion+" RAZON: "+razon);
            enca.addCell(fecha);
            doc.add(enca);
            
            Paragraph clinte = new Paragraph();
            clinte.add(Chunk.NEWLINE);
            clinte.add("Datos de Cliente: " + "\n\n");
            doc.add(clinte);
            
            PdfPTable tbcli = new PdfPTable(4);
            tbcli.setWidthPercentage(100);
            tbcli.getDefaultCell().setBorder(0);
            float[] cc=new float[]{25f,45f,30f,40f};
            tbcli.setWidths(cc);
            tbcli.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Cedula/RNC: "));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: "));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: "));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Direccion: "));
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);
            tbcli.addCell(cliente1);
            tbcli.addCell(cliente2);
            tbcli.addCell(cliente3);
            tbcli.addCell(cliente4);
            tbcli.addCell(CedulaCliente);
            tbcli.addCell(nombreCliente);
            tbcli.addCell(TelefonoCliente);
            tbcli.addCell(DireccionCliente);
            doc.add(tbcli);
            
            Paragraph es = new Paragraph();
            es.add(Chunk.NEWLINE);
            es.add("");
            es.setAlignment(Element.ALIGN_LEFT);
            doc.add(es);
            
            PdfPTable tbpro = new PdfPTable(4);
            tbpro.setWidthPercentage(100);
            tbpro.getDefaultCell().setBorder(0);
            float[] cp=new float[]{15f,50f,15f,20f};
            tbpro.setWidths(cp);
            tbpro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: "));
            PdfPCell producto2 = new PdfPCell(new Phrase("Descripcion: "));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: "));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: "));
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tbpro.addCell(producto1);
            tbpro.addCell(producto2);
            tbpro.addCell(producto3);
            tbpro.addCell(producto4);
            for(int i=0; i<p.tablefactura.getRowCount(); i++){
                String producto = (String) p.tablefactura.getValueAt(i, 1);
                String cantidad = String.valueOf( p.tablefactura.getValueAt(i, 2));
                String precio = String.valueOf( p.tablefactura.getValueAt(i, 3));
                String total = String.valueOf( p.tablefactura.getValueAt(i, 7));
                tbpro.addCell(producto);
                tbpro.addCell(cantidad);
                tbpro.addCell(precio);
                tbpro.addCell(total);
            }
            doc.add(tbpro);
            
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + p.txttotal.getText());
            info.setAlignment(Element.ALIGN_LEFT);
            doc.add(info);
            
            doc.close();
            Desktop.getDesktop().open(file);
        }catch(DocumentException | FileNotFoundException ex){
            System.out.println("Error al Obtener Datos de cliente: "+ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    //Metodos dedicados al apartado de REPORTES
    public void ReporteCliente(){
        String usuario = "Deadpool Masacre";
        Document doc = new Document();
        try{
            File ruta = new File("Reportes/ReporteCliente.pdf");
            PdfWriter.getInstance(doc, new FileOutputStream(ruta));
            Paragraph parafo = new Paragraph();
            parafo.setAlignment(Paragraph.ALIGN_CENTER);
            parafo.add("Reporte Creado por: "+usuario+"\n\n");
            parafo.add("Reporte de Cliente: \n\n");
            doc.open();
            doc.add(parafo);
            
            PdfPTable tb = new PdfPTable(5);
            tb.addCell("Codigo");
            tb.addCell("Nombre");
            tb.addCell("Cedula");
            tb.addCell("Telefono");
            tb.addCell("Direccion");
            
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("select idcliente, nombre, apellido, cedula, telefono, direccion from tbcliente");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                do{
                    tb.addCell(rs.getString(1));
                    tb.addCell(rs.getString(2)+" "+rs.getString(3));
                    tb.addCell(rs.getString(4));
                    tb.addCell(rs.getString(5));
                    tb.addCell(rs.getString(6));
                }while(rs.next());
                doc.add(tb);
            }
            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte de cliente creado correctamente","Creado",JOptionPane.PLAIN_MESSAGE);
            Desktop.getDesktop().open(ruta);
        }catch(SQLException | DocumentException | FileNotFoundException e){
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(ControladorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ReporteCategoria(){
        String usuario = "Deadpool Masacre";
        Document doc = new Document();
        try{
            File ruta = new File("Reportes/ReporteCategoria.pdf");
            PdfWriter.getInstance(doc, new FileOutputStream(ruta));
            Paragraph parafo = new Paragraph();
            parafo.setAlignment(Paragraph.ALIGN_CENTER);
            parafo.add("Reporte Creado por: "+usuario+"\n\n");
            parafo.add("Reporte de Categorias: \n\n");
            doc.open();
            doc.add(parafo);
            
            PdfPTable tb = new PdfPTable(2);
            tb.addCell("Codigo");
            tb.addCell("Nombre");
            
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("select idcategoria, direccion from tbcategoria");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                do{
                    tb.addCell(rs.getString(1));
                    tb.addCell(rs.getString(2));
                }while(rs.next());
                doc.add(tb);
            }
            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte de categoria creado correctamente","Creado",JOptionPane.PLAIN_MESSAGE);
            Desktop.getDesktop().open(ruta);
        }catch(SQLException | DocumentException | FileNotFoundException e){
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(ControladorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ReporteProducto(){
        String usuario = "Deadpool Masacre";
        Document doc = new Document();
        try{
            File ruta = new File("Reportes/ReporteProducto.pdf");
            PdfWriter.getInstance(doc, new FileOutputStream(ruta));
            Paragraph parafo = new Paragraph();
            parafo.setAlignment(Paragraph.ALIGN_CENTER);
            parafo.add("Reporte Creado por: "+usuario+"\n\n");
            parafo.add("Reporte de Productos: \n\n");
            doc.open();
            doc.add(parafo);
            
            PdfPTable tb = new PdfPTable(7);
            tb.addCell("Codigo");
            tb.addCell("Nombre");
            tb.addCell("Cantidad");
            tb.addCell("Precio");
            tb.addCell("Descripcion");
            tb.addCell("IVA");
            tb.addCell("Categoria");
            
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("select idproducto,nombre,cantidad,precio,descripcion,porcentajeIva,idcategoria from tbproducto");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                do{
                    tb.addCell(rs.getString(1));
                    tb.addCell(rs.getString(2));
                    tb.addCell(rs.getString(3));
                    tb.addCell(rs.getString(4));
                    tb.addCell(rs.getString(5));
                    tb.addCell(rs.getString(6));
                    tb.addCell(c.ObetenerNombreCategoria(rs.getInt(7)));
                }while(rs.next());
                doc.add(tb);
            }
            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte de Producto creado correctamente","Creado",JOptionPane.PLAIN_MESSAGE);
            Desktop.getDesktop().open(ruta);
        }catch(SQLException | DocumentException | FileNotFoundException e){
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(ControladorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ReporteVenta(){
        String usuario = "Deadpool Masacre";
        Document doc = new Document();
        try{
            File ruta = new File("Reportes/ReporteVenta.pdf");
            PdfWriter.getInstance(doc, new FileOutputStream(ruta));
            Paragraph parafo = new Paragraph();
            parafo.setAlignment(Paragraph.ALIGN_CENTER);
            parafo.add("Reporte Creado por: "+usuario+"\n\n");
            parafo.add("Reporte de Ventas: \n\n");
            doc.open();
            doc.add(parafo);
            
            PdfPTable tb = new PdfPTable(4);
            tb.addCell("Codigo");
            tb.addCell("Cliente");
            tb.addCell("Valor Pagado");
            tb.addCell("Fecha Venta");
            
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("select idcabezeraventa,idcliente,valorPagar,fechaVenta from tbcabezeraventa");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                do{
                    tb.addCell(rs.getString(1));
                    tb.addCell(c.obtenerNombreCliente(rs.getInt(2)));
                    tb.addCell(rs.getString(3));
                    tb.addCell(rs.getString(4));
                }while(rs.next());
                doc.add(tb);
            }
            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte de Venta creado correctamente","Creado",JOptionPane.PLAIN_MESSAGE);
            Desktop.getDesktop().open(ruta);
        }catch(SQLException | DocumentException | FileNotFoundException e){
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(ControladorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
