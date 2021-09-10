/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.NivelVO;
import Util.Conexion;
import Util.Crud;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofia
 */
public class NivelDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String idNivel = "", nombreFormacion = "";

    public NivelDAO(NivelVO nilVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            idNivel = nilVO.getIdNivel();
            nombreFormacion = nilVO.getNombreFormacion();
        } catch (Exception e) {
            Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO nivel(idNivel, nombreFormacion) VALUES (?,?)";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, idNivel);
            puente.setString(2, nombreFormacion);
            puente.executeUpdate();
            this.operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro(String valor, String id) {
        try {
            sql = "UPDATE nivel SET nombreFormacion=? WHERE idNivel=?";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombreFormacion);
            puente.setString(2, idNivel);
            puente.executeUpdate();
            this.operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro(String id) {
        try {
            sql = "DELETE FROM nivel WHERE idNivel=?";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.executeUpdate();
            this.operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
            }            
        }
        return operacion;
    }
}
