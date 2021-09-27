/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.Crud;
import Util.Conexion;
import java.sql.*;
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
    private String idUsuario="", nombreUsuario="", contraseña="", estado="", idRolFK="";;
    
    public UsuarioDAO(UsuarioVO usuVO){
    super();
        try {
            conexion= this.obtenerConexion();
            idUsuario = usuVO.getIdUsuario();
            nombreUsuario = usuVO.getNombreUsuario();
            contraseña = usuVO.getContraseña();
            estado = usuVO.getEstado();
            idRolFK = usuVO.getIdRolFK();
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
            sql = "UPDATE usuario SET contraseña=? WHERE idUsuario=?";
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
    
    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        try {
            System.out.println("conexion");
            conexion = this.obtenerConexion();
            System.out.println("obtiene la conexion");
            sql = "select * from usuario where nombreUsuario=? and contraseña=?";
            System.out.println("habre consulta");
            puente = conexion.prepareStatement(sql);
            System.out.println("nombre usuario"+nombreUsuario);
            puente.setString(1, nombreUsuario);
            System.out.println("contraseña"+contrasena);
            puente.setString(2, contrasena);
            System.out.println("se rcogen los datos");
            mensajero = puente.executeQuery();
            System.out.println("se ejecuta la conexion");
            if (mensajero.next()) {
                operacion = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    


}
