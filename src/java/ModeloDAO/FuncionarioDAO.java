/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.FuncionarioVO;
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
public class FuncionarioDAO extends Conexion implements Crud {
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion= false;
    private String sql;
    private String idFuncionario="",nombre="",apellido="",correo="",numIdentidad="",urlFoto="",idUsuarioFK="",idCoordinacionFK="" ;
    
    public FuncionarioDAO (FuncionarioVO funVO){
      super();
        try {
            conexion= this.obtenerConexion();
            idFuncionario=funVO.getIdFuncionario();
            nombre=funVO.getNombre();
            apellido=funVO.getApellido();
            correo=funVO.getCorreo();
            numIdentidad=funVO.getNumIdentidad();
            urlFoto=funVO.getUrlFoto();
            idUsuarioFK=funVO.getIdUsuarioFK();
            idCoordinacionFK=funVO.getIdCoordinacionFK();
            
           } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
    }

    @Override
    public boolean agregarRegistro() {
         try {
       
            sql="insert into funcionario (`nombre`,`apellido`,`correo`,`numIdentidad`) values(?,?,?,?) ";
       
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
            sql="update funcionario set nombre=?, apellido=?, correo=?, numIdentidad=? where idFuncionario=? ";
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
    
    public ArrayList<FuncionarioVO>listar(){
        ArrayList<FuncionarioVO>ListaFuncionario= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="select * from Funcionario ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                FuncionarioVO funVO = new FuncionarioVO (mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                                   mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),
                                                   mensajero.getString(8));
                ListaFuncionario.add(funVO);
                        
            
            }
          
        } catch (Exception e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return ListaFuncionario;
    }
    
    public FuncionarioVO consultarFuncionario (String id){
    
    FuncionarioVO funVO= null;
        try {
            conexion = this.obtenerConexion();
            sql="select * from funcionario where idFuncionario=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1,id);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                funVO= new FuncionarioVO (mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                        mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),
                                        mensajero.getString(8));
            }
            
        } catch (Exception e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return funVO;
    }
}
