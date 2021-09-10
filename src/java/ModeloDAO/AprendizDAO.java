/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.AprendizVO;
import Util.Conexion;
import Util.Crud;
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
public class AprendizDAO extends Conexion implements Crud{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion= false;
    private String sql;
    private String idAprendiz="",nombre="",apellido="",correo="",numIdentidad="",urlFoto="",idUsuarioFK="" ;
    
    public AprendizDAO (AprendizVO aprenVO){
      super();
        try {
            conexion= this.obtenerConexion();
            idAprendiz=aprenVO.getIdAprendiz();
            nombre=aprenVO.getNombre();
            apellido=aprenVO.getApellido();
            correo=aprenVO.getCorreo();
            numIdentidad=aprenVO.getNumIdentidad();
            urlFoto=aprenVO.getUrlFoto();
            idUsuarioFK=aprenVO.getIdUsuarioFK();
            
           } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    @Override
    public boolean agregarRegistro() {
       
        try {
       
            sql="insert into aprendiz (`nombre`,`apellido`,`correo`,`numIdentidad`) values(?,?,?,?) ";
       
            puente= conexion.prepareStatement(sql);
            puente.setString(1,nombre);
            puente.setString(2,apellido);
            puente.setString(3,correo);
            puente.setString(4,numIdentidad);
            puente.executeUpdate();
            this.operacion=true;
            
         
        } catch (SQLException e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return operacion;
    }
    

    @Override
    public boolean actualizarRegistro(String valor, String id) {
        
         try {
            sql="update aprendiz set nombre=?, apellido=?, correo=?, numIdentidad=? where idAprendiz=? ";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, valor);
            puente.setString(2,apellido );
            puente.setString(3,correo );
            puente.setString(4,numIdentidad );
            puente.setString(5, id);
            
            puente.executeUpdate();
            this.operacion= true;
            
            
        } catch (SQLException e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
    public ArrayList<AprendizVO>listar(){
        ArrayList<AprendizVO> ListaAprendiz= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="select * from aprendiz ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                AprendizVO aprenVO = new AprendizVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                                   mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7));
                ListaAprendiz.add(aprenVO);
                        
            
            }
          
        } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return ListaAprendiz;
    }
    
    public AprendizVO consultarAprendiz(String id){
    
    AprendizVO aprenVO= null;
        try {
            conexion = this.obtenerConexion();
            sql="select * from aprendiz where idAprendiz= ?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, id);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                aprenVO= new AprendizVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                        mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7));
            }
            
        } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return aprenVO;
    }
    
    public AprendizVO Aprendiz (String funcionarioV){
    
    AprendizVO AprenVO= null;
        try {
            conexion = this.obtenerConexion();
            sql="select * from funcionario where numIdentidad=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1,funcionarioV);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                AprenVO= new AprendizVO (mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                        mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7));
            }
            
        } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return AprenVO;
    }
}
