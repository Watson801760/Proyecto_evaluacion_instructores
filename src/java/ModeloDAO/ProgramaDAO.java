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
import java.util.ArrayList;
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
            sql = "INSERT INTO programa (nombrePrograma,`idNivel(FK)`) VALUES (?,?)";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombrePrograma);
            puente.setString(2, idNivelFK);
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
            sql = "UPDATE programa SET nombrePrograma=?,versionPrograma=? WHERE idPrograma=?";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombrePrograma);
            puente.setString(2, versionPrograma);
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

    public ArrayList<ProgramaVO> listar() {
        ArrayList<ProgramaVO> ListaProgramas = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from programa ";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                ProgramaVO proVO = new ProgramaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5));
                ListaProgramas.add(proVO);

            }

        } catch (Exception e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return ListaProgramas;
    }

    public ProgramaVO consultarPrograma(String id) {

        ProgramaVO proVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from programa where idPrograma= ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                proVO = new ProgramaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5));
            }

        } catch (Exception e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return proVO;
    }

    public ProgramaVO Programa(String programa) {

        ProgramaVO proVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from programa where programa=? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, programa);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                proVO = new ProgramaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5));
            }

        } catch (Exception e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return proVO;
    }
}
