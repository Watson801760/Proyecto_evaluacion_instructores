/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ProgramaVO;
import Util.Crud;
import Util.Conexion;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofia
 */
public class ProgramaDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String idPrograma = "", nombrePrograma = "", versionPrograma = "", estado = "", idNivelFK = "";

    public ProgramaDAO(ProgramaVO proVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            idPrograma = proVO.getIdPrograma();
            nombrePrograma = proVO.getNombrePrograma();
            versionPrograma = proVO.getVersionPrograma();
            estado = proVO.getEstado();
            idNivelFK = proVO.getIdNivelFK();
        } catch (Exception e) {
            Logger.getLogger(ProgramaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO programa(nombrePrograma, versionPrograma, estado) VALUES (?,?,?)";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombrePrograma);
            puente.setString(2, versionPrograma);
            puente.setString(3, estado);
            puente.executeUpdate();
            this.operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(ProgramaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ProgramaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro(String valor, String id) {
        try {
            sql = "UPDATE programa SET nombrePrograma=?,versionPrograma=?,estado=? WHERE idPrograma=?";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombrePrograma);
            puente.setString(2, versionPrograma);
            puente.setString(3, estado);
            puente.setString(4, id);
            puente.executeUpdate();
            this.operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(ProgramaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ProgramaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro(String id) {
        try {
            sql = "DELETE FROM programa WHERE idPrograma=?";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.executeUpdate();
            this.operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(ProgramaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ProgramaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
}
