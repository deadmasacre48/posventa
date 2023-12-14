
package Modelo;

import Controlador.Controlador;
import Vista.Login;
import Vista.Menu;
import javax.swing.JOptionPane;

public class UsuarioM {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private String telefono;
    private int estado;

    public UsuarioM() {
        this.idUsuario = 0;
        this.nombre = "";
        this.apellido = "";
        this.usuario = "";
        this.clave = "";
        this.telefono = "";
        this.estado = 0;
    }
    
    public void login(Login l, Menu m){
        if(!l.txtuser.getText().equals("") && !l.txtclave.getText().equals("")){
            Controlador c = new Controlador();
            UsuarioM u = new UsuarioM();
            u.setUsuario(l.txtuser.getText().trim());
            u.setClave(l.txtclave.getText().trim());
            if(c.loginUser(u)){
                m.setVisible(true);
                l.dispose();
            }else{
                JOptionPane.showMessageDialog(l, "Usuario o Clave incorrecto.",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(l, "Campos Obligatorios vacios.",
                    "ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
}
