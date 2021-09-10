/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.FichaVO;
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
 * @author Usuario
 */
public class FichaDAO extends Conexion implements Crud{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion= false;
    private String sql;
    private String idFicha="",numeroFicha="",fechaInicioElectiva="",fechaFinElectiva="",fechaInicioProductiva="",fechaFinProductiva="",estado="",idProgramaFK="";
    

   
    public FichaDAO (FichaVO fichVO){
     super();
            try {
                conexion=this.obtenerConexion();
                idFicha=fichVO.getIdFicha();
                numeroFicha=fichVO.getNumeroFicha();
                fechaInicioElectiva=fichVO.getFechaInicioElectiva();
                fechaFinElectiva=fichVO.getFechaFinElectiva();
                fechaInicioProductiva=fichVO.getFechaInicioProductiva();
                fechaFinProductiva=fichVO.getFechaFinProductiva();
                estado=fichVO.getEstado();
                idProgramaFK=fichVO.getIdProgramaFK();
                
           } catch (Exception e) {
            Logger.getLogger(FichaDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    
    @Override
    public boolean agregarRegistro() {
        try {
       
            sql="insert into Ficha (`numeroFicha`,`fechaInicioElectiva`,`fechaFinElectiva`,`fechaInicioProductiva`,`fechaFinProductiva`,`estado`) values(?,?,?,?) ";
       
            puente= conexion.prepareStatement(sql);
            puente.setString(1,numeroFicha);
            puente.setString(2,fechaInicioElectiva);
            puente.setString(3,fechaFinElectiva);
            puente.setString(4,fechaInicioProductiva);
            puente.setString(5,fechaFinProductiva);
            puente.setString(6,estado );
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<FichaVO>listar(){
        ArrayList<FichaVO>ListaFicha= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="select * from Ficha ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                FichaVO fichVO = new FichaVO (mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                                   mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),
                                                   mensajero.getString(8));
                ListaFicha.add(fichVO);
                        
            
            }
          
        } catch (Exception e) {
            Logger.getLogger(FichaDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return ListaFicha;
    }
    
    public FichaVO consultarFicha (String id){
    
    FichaVO fichVO= null;
        try {
            conexion = this.obtenerConexion();
            sql="select * from Ficha where idFicha=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1,id);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                fichVO= new FichaVO (mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
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
        return fichVO;
    }
    
}
