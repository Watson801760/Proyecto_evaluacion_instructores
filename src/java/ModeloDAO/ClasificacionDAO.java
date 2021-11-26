/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ClasificacionVO;
import ModeloVO.UsuarioVO;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ClasificacionDAO extends Conexion {
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
    
    public ArrayList<ClasificacionVO>listar(){
        ArrayList<ClasificacionVO> ListaClasificacion= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="select * from clasificacion ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                ClasificacionVO claVO = new ClasificacionVO(mensajero.getString(1), mensajero.getString(2));
                ListaClasificacion.add(claVO);
                        
            
            }
            
        } catch (Exception e) {
            Logger.getLogger(ClasificacionDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(ClasificacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ListaClasificacion;
    }
    
    
   public ClasificacionVO consultarClasificacion(String id){
    ClasificacionVO claVO= null;
        try {
       
            conexion= this.obtenerConexion();
           
            sql="select * from clasificacion where idClasificacion= ? ";
       
            puente= conexion.prepareStatement(sql);
           
            puente.setString(1, id);
            mensajero= puente.executeQuery();
       
           
            while(mensajero.next()){
              
            
            claVO = new ClasificacionVO(mensajero.getString(1), mensajero.getString(2));
                        
            
            }
            
        } catch (Exception e) {
            Logger.getLogger(ClasificacionDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(ClasificacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return claVO;
    }
   
   
}
