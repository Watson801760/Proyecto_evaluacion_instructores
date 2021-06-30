/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */

    public class Conexion {
    private String driver,user,password,nombreBd,urlBd;
    private Connection conexion;
    
    public Conexion() {
        driver="com.mysql.jdbc.Driver";
        user="root";
        password="";
        nombreBd="evaluacion_instructores";
        urlBd="jdbc:mysql://localhost:3306/"+nombreBd;
        
        try {
            Class.forName(driver).newInstance();
            conexion= DriverManager.getConnection(urlBd,user,password);
            System.out.println("Conexion");
        } catch (Exception e) {
            System.out.println("error"+ e.toString());
        }
}
    
    public Connection obtenerConexion() {
        return conexion;
    
    }
    public Connection cerrarConexion() throws SQLException{
        
        conexion.close();
        conexion=null;
        return conexion;
   }
    
    public static void main (String[] args){
        new Conexion();
    
    }
            
}

