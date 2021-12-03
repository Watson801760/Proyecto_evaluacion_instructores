/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.EvaluaVO;
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
public class EvaluaDAO extends Conexion implements Crud{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
     private boolean operacion= false;
    private String sql;
    private String idPregentaFK="",idFuncionarioFK="",idAprendizFK="",repuesta="";
    
    
    public EvaluaDAO (EvaluaVO evaVO){
      super();
        try {
            conexion= this.obtenerConexion();
            idPregentaFK=evaVO.getIdPregentaFK();
            idFuncionarioFK=evaVO.getIdFuncionarioFK();
            idAprendizFK=evaVO.getIdAprendizFK();
            repuesta=evaVO.getRepuesta();
            
           } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
 

    @Override
    public boolean agregarRegistro() {
      try {
            System.out.println("1");
            sql="insert into evalua (`idPregenta(FK)`,`idFuncionario(FK)`,`idAprendiz(FK)`,`respuesta`) values(?,?,?,?) ";
            System.out.println("2");
            puente= conexion.prepareStatement(sql);
            System.out.println("3" +idPregentaFK);
            puente.setString(1,idPregentaFK);
            System.out.println("4" +idFuncionarioFK);
            puente.setString(2,idFuncionarioFK);
            System.out.println("5" +idAprendizFK);
            puente.setString(3,idAprendizFK);
            System.out.println("6" + repuesta);
            puente.setString(4,repuesta);
            System.out.println("7");
            puente.executeUpdate();
            System.out.println("8");
            this.operacion=true;
            
         
        }catch (SQLException e) {
            Logger.getLogger(EvaluaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
       return operacion;
    }

    @Override
    public boolean actualizarRegistro(String valor, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
           public EvaluaVO consultarAprendiz(String id){
    EvaluaVO evaVO= null;
        try {
            
            conexion= this.obtenerConexion();
             
            sql="SELECT  idAprendiz FROM evalua  WHERE idAprendiz=? ";
             
            puente= conexion.prepareStatement(sql);
             
            puente.setString(1, id);
            mensajero= puente.executeQuery();
            while(mensajero.next()){
            evaVO = new EvaluaVO(mensajero.getString(1), mensajero.getString(2),mensajero.getString(3), mensajero.getString(4));
            }
        } catch (Exception e) {
            Logger.getLogger(EvaluaDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(EvaluaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return evaVO;
    }
        
    public EvaluaVO consultarFuncionario(String id){
    EvaluaVO evaVO= null;
        try {
            conexion= this.obtenerConexion();
            sql="SELECT `idFuncionario(FK)`, idFuncionario FROM evalua AS eva INNER JOIN funcionario AS fun ON eva.`idFuncionario(FK)`=fun.idFuncionario WHERE idFuncionario=? ";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, id);
            mensajero= puente.executeQuery();
            while(mensajero.next()){
            evaVO = new EvaluaVO(mensajero.getString(1), mensajero.getString(2),mensajero.getString(3), mensajero.getString(4));
            }
        } catch (Exception e) {
            Logger.getLogger(EvaluaDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(EvaluaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return evaVO;
    }
    
    public EvaluaVO consultarIdAprendiz(){
    EvaluaVO evaVO= null;
        try {
            conexion= this.obtenerConexion();
            sql="SELECT `idAprendiz(FK)` FROM evalua ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            while(mensajero.next()){
            evaVO = new EvaluaVO(mensajero.getString(1), mensajero.getString(2),mensajero.getString(3), mensajero.getString(4));
            }
        } catch (Exception e) {
            Logger.getLogger(EvaluaDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(EvaluaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return evaVO;
    }
}
