/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ProgramacionVO;
import Util.Conexion;
import Util.Crud;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ProgramacionDAO extends Conexion implements Crud  {
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion= false;
    private String sql;
    private String idProgramacion="",codigoAcceso="",semestre="",idEvaluacionFK="";
    private Date fechaInicio,fechaFin;
    
    String inActiveDate = null;
    
   public ProgramacionDAO (ProgramacionVO proVO){
      super();
        try {
            conexion= this.obtenerConexion();
            idProgramacion=proVO.getIdProgramacion();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            fechaInicio = (Date) proVO.getFechaInicio();
            fechaFin= (Date) proVO.getFechaFin();
            inActiveDate = format1.format(proVO.getFechaInicio());
            //fechaInicio= proVO.getFechaInicio();
            //fechaFin= proVO.getFechaFin();
            codigoAcceso=proVO.getCodigoAcceso();
            semestre=proVO.getSemestre();
            idEvaluacionFK=proVO.getIdEvaluacionFK();
           } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    @Override
    public boolean agregarRegistro() {
        try {
            
            System.out.println("fechaInicio: "+fechaInicio);
            System.out.println("fechaFin: "+fechaFin);
            System.out.println("codigoAcceso: "+codigoAcceso);
            System.out.println("semestre: "+semestre);
            
            sql="insert into programacion (`fechaInicio`,`fechaFin`,`codigoAcceso`,`semestre`) values(?,?,?,?) ";
       
            puente= conexion.prepareStatement(sql);
            puente.setDate(1, fechaInicio);
            puente.setDate(2, fechaFin);
            
            puente.setString(3,codigoAcceso);
            puente.setString(4,semestre);
            puente.executeUpdate();
            this.operacion=true;
            
         
        } catch (SQLException e) {
            Logger.getLogger(ProgramacionDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return operacion;}

    @Override
    public boolean actualizarRegistro(String valor, String id) {
       try {
            sql="update programacion set fechaInicio=?, fechaFin=?, codigoAcceso=?, semestre=? where idProgramacion=? ";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, valor);
            puente.setDate(2, fechaFin);
            puente.setString(3,codigoAcceso);
            puente.setString(4,semestre);
            puente.setString(5, id);
            
            puente.executeUpdate();
            this.operacion= true;
            
            
        } catch (SQLException e) {
            Logger.getLogger(ProgramacionDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }


    @Override
    public boolean eliminarRegistro(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<ProgramacionVO>listar(){
        ArrayList<ProgramacionVO>ListaProgramacion= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="select * from programacion ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                ProgramacionVO proVO = new ProgramacionVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                                   mensajero.getString(4),mensajero.getDate(5),mensajero.getDate(6));
                ListaProgramacion.add(proVO);
                        
            
            }
          
        } catch (Exception e) {
            Logger.getLogger(ProgramacionDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return ListaProgramacion;
    }
    
     public ProgramacionVO consultarProgramacion (String id){
    
    ProgramacionVO  proVO= null;
        try {
            conexion = this.obtenerConexion();
            sql="select * from programacion where idProgramacion=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1,id);
            mensajero= puente.executeQuery();
            while(mensajero.next()){
            
                proVO= new ProgramacionVO (mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                        mensajero.getString(4),mensajero.getDate(5),mensajero.getDate(6));
            }
            
        } catch (Exception e) {
            Logger.getLogger(ProgramacionDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return proVO;
    }
}
