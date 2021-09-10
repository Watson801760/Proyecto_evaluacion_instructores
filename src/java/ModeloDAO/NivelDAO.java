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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofia
 */
public class NivelDAO extends Conexion {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;

    public ArrayList<NivelVO> listar() {
        ArrayList<NivelVO> ListaNivel = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from nivel ";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                NivelVO nilVO = new NivelVO(mensajero.getString(1), mensajero.getString(2));
                ListaNivel.add(nilVO);
            }
        } catch (Exception e) {
            Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
        } /*finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return ListaNivel;
    }

    public NivelVO consultarNivel(String id) {
        NivelVO nilVO = null;
        try {
            System.out.println("1");
            conexion = this.obtenerConexion();
            System.out.println("2");
            sql = "select * from nivel where idNivel= ? ";
            System.out.println("3" + sql);
            puente = conexion.prepareStatement(sql);
            System.out.println("4" + id);
            puente.setString(1, id);
            mensajero = puente.executeQuery();
            System.out.println("5");

            while (mensajero.next()) {
                System.out.println("6");

                nilVO = new NivelVO(mensajero.getString(1), mensajero.getString(2));

            }

        } catch (Exception e) {
            Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(NivelDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return nilVO;
    }
}
