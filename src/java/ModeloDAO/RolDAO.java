/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class RolDAO extends Conexion {
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private String sql;
    
        public ArrayList<UsuarioVO> rol(String usuario) {
        ArrayList<UsuarioVO> listaRol = new ArrayList<>();
      
        try {
           
            conexion = this.obtenerConexion();
            sql = "SELECT usuario.idUsuario, rol.nombreRol FROM rol INNER JOIN usuario ON rol.idRol = usuario.`idRol(FK)` WHERE usuario.nombreUsuario =?"; 
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            mensajero = puente.executeQuery();
          
            
          
            while (mensajero.next()) {
                
                UsuarioVO usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2));
                listaRol.add(usuVO);
            }
           
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            System.err.println(e.toString());
        }
        return listaRol;
    }


}
