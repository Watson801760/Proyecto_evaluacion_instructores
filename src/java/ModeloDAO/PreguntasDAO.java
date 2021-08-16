/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.PreguntasVO;
import Util.Conexion;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 
 * @author user
 */
public class PreguntasDAO extends Conexion implements Crud{
    
  private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion= false;
    private String sql;
    private String idPregunta="",pregunta="",respuestaFavorable="",estado="",idClasificacion="",idEvaluacion="";
    public PreguntasDAO(PreguntasVO preVO){
    super();
        try {
            conexion= this.obtenerConexion();
            idPregunta = preVO.getIdPregunta();
            pregunta = preVO.getPregunta();
            respuestaFavorable = preVO.getRespuestaFavorable();
            estado = preVO.getEstado();
            idClasificacion=preVO.getIdClasificacionFK();
        } catch (Exception e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }

    @Override
    public boolean agregarRegistro() {
         try {
             System.out.println("se prepa la conexion");
            sql="insert into pregunta (`pregunta`,`idClasificacion(FK)`) values(?,?) ";
             System.out.println("se entra el registro");
            puente= conexion.prepareStatement(sql);
            System.out.println("1:"+ pregunta);
            puente.setString(1, pregunta);
            System.out.println("2:"+ idClasificacion);
            puente.setString(2, idClasificacion);
             System.out.println("se elige el segundo valor");
            puente.executeUpdate();
            this.operacion=true;
            
            this.cerrarConexion();
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
            sql="update pregunta set pregunta=? where idPregunta=? ";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, valor);
            puente.setString(2, id);
            puente.executeUpdate();
            this.operacion= true;
            
            this.cerrarConexion();
        } catch (SQLException e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro(String id) {
        try {
        String sql="DELETE FROM pregunta WHERE idPregunta=?";
         puente= conexion.prepareStatement(sql);
         puente.setString(1, id);
         puente.executeUpdate();
         this.operacion= true;
     
        
        }catch (SQLException e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }
    
    
  public ArrayList<PreguntasVO>listar(){
        ArrayList<PreguntasVO> ListaPreguntas= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="select * from pregunta ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                PreguntasVO preVO = new PreguntasVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                                   mensajero.getString(4),mensajero.getString(5),mensajero.getString(6));
                ListaPreguntas.add(preVO);
                        
            
            }
            
        } catch (Exception e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ListaPreguntas;
    }
  
  
  public PreguntasVO consultarPregunta(String id){
    
    PreguntasVO preVO= null;
        try {
            conexion = this.obtenerConexion();
            sql="select * from pregunta where idPregunta= ?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, id);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                preVO = new PreguntasVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                        mensajero.getString(4),mensajero.getString(5),mensajero.getString(6));
            }
        } catch (Exception e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return preVO;
    }
}