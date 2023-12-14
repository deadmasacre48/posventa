
package Modelo;

public class ClienteM {
    private int idcliente;
    private String nombre;
    private String apellid;
    private String cedula;
    private String telefono;
    private String direccion;
    private int estado;

    public ClienteM() {
        this.idcliente = 0;
        this.nombre = "";
        this.apellid = "";
        this.cedula = "";
        this.telefono = "";
        this.direccion = "";
        this.estado = 0;
        
    }

    public ClienteM(int idcliente, String nombre, String apellid, String cedula, String telefono, String direccion, int estado) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.apellid = apellid;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellid() {
        return apellid;
    }

    public void setApellid(String apellid) {
        this.apellid = apellid;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
}
