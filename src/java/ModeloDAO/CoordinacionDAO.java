/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.CoordinacionVO;
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
public class CoordinacionDAO extends Conexion {
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
    
    public ArrayList<CoordinacionVO>listar(){
        ArrayList<CoordinacionVO> ListaCoordinacion= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="select * from coordinacion ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                CoordinacionVO cooVO = new CoordinacionVO(mensajero.getString(1), mensajero.getString(2));
                ListaCoordinacion.add(cooVO);
                        
            
            }
            
        } catch (Exception e) {
            Logger.getLogger(CoordinacionDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(CoordinacionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ListaCoordinacion;
    }
}
