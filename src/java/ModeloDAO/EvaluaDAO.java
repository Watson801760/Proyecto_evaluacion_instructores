/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.EvaluaVO;
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
public class EvaluaDAO extends Conexion{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
    
        public EvaluaVO consultarAprendiz(String id){
    EvaluaVO evaVO= null;
        try {
            System.out.println("1");
            conexion= this.obtenerConexion();
             System.out.println("2");
            sql="SELECT `idAprendiz(FK)`, idAprendiz FROM evalua AS eva INNER JOIN aprendiz AS apren ON eva.`idAprendiz(FK)`=apren.idAprendiz WHERE idAprendiz=? ";
             System.out.println("3");
            puente= conexion.prepareStatement(sql);
             System.out.println("4"+id);
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
    
}
