/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.Crud;
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
 * @author Sofia Paola
 */
public class UsuarioDAO extends Conexion implements Crud{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion= false;
    private String sql;
    private String idUsuario="", nombreUsuario="", contraseña="", estado="";
    
    public UsuarioDAO(UsuarioVO usuVO){
    super();
        try {
            conexion= this.obtenerConexion();
            idUsuario = usuVO.getIdUsuario();
            nombreUsuario = usuVO.getNombreUsuario();
            contraseña = usuVO.getContraseña();
            estado = usuVO.getEstado();
        } catch (Exception e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
    
    @Override
    public boolean agregarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarRegistro(String sql, String id) {
        try {
            sql = "update user set usuario contraseña=? where idUsuario=?";
            puente = conexion.prepareStatement(sql);            
            puente.setString(1, contraseña);
            puente.setString(2, idUsuario);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean iniciarSesion(String usuario, String contraseña) {
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where usuario=? and contraseña=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, contraseña);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    /*public ArrayList<UsuarioVO> rol(String usuario) {
        ArrayList<UsuarioVO> listaRol = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT usuario.idUsuario, rol.nombreRol\n"
                    + "FROM rol INNER JOIN\n"
                    + "usuario ON rol.idRol = usuario.idRol INNER JOIN\n"
                    + "usuario ON usuario.idUsuario = usuario.idUsuario\n"
                    + "WHERE usuario.idUsuario = ?"; 
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
    */   
}
