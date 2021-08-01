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
    private String idPregunta="",pregunta="",respuestaFavorable="",estado="";
    
    public PreguntasDAO(PreguntasVO preVO){
    super();
        try {
            conexion= this.obtenerConexion();
            idPregunta = preVO.getIdPregunta();
            pregunta = preVO.getPregunta();
            respuestaFavorable = preVO.getRespuestaFavorable();
            estado = preVO.getEstado();
        } catch (Exception e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }

    @Override
    public boolean agregarRegistro() {
         try {
            sql="insert into pregunta (pregunta) values(?) ";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, pregunta);
            puente.executeUpdate();
            this.operacion=true;
            
            this.cerrarConexion();
        } catch (SQLException e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql="update pregunta set pregunta=? where idPregunta=? ";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, pregunta);
            
            puente.executeUpdate();
            this.operacion= true;
            
            this.cerrarConexion();
        } catch (SQLException e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
  public ArrayList<PreguntasVO>listar(){
        ArrayList<PreguntasVO> ListaPreguntas= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="select * from pregunta ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                PreguntasVO preVO = new PreguntasVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
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
}