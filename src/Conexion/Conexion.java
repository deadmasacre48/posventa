
package Conexion;

import java.sql.*;

public class Conexion {
    
    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsistemsale","root","admin");
            return cn;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    
}
