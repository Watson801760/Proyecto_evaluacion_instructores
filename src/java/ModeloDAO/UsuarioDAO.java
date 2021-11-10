/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.Crud;
import Util.Conexion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Sofia Paola
 */
public class UsuarioDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String idUsuario = "", nombreUsuario = "", contraseña = "", estado = "", idRolFK = "";

    ;
    
    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        try {
            conexion = this.obtenerConexion();
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

            conexion = this.obtenerConexion();

            sql = "select * from usuario where nombreUsuario=? and contraseña=?";

            puente = conexion.prepareStatement(sql);

            puente.setString(1, nombreUsuario);

            puente.setString(2, contrasena);

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

    public UsuarioVO consultarAprendiz_Ficha(String nombre) {

        UsuarioVO usuVO = null;
        try {
            System.out.println("conexion");
            conexion = this.obtenerConexion();
            System.out.println("obtiene la conexion");
            sql = "SELECT salon.`idFicha(FK)` FROM salon LEFT JOIN usuario ON salon.`idUsuario(FK)` = usuario.idUsuario LEFT JOIN aprendiz ON usuario.idUsuario = aprendiz.`idUsuario(FK)` WHERE usuario.nombreUsuario = ?";
            System.out.println("habre consulta");
            puente = conexion.prepareStatement(sql);
            System.out.println("nombre usuario" + nombre);
            puente.setString(1, nombre);
            System.out.println("se rcogen los datos");
            mensajero = puente.executeQuery();
            System.out.println("se ejecuta la conexion");
            while (mensajero.next()) {

                usuVO = new UsuarioVO(mensajero.getString(1));
            }

        } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return usuVO;
    }

    public ArrayList<UsuarioVO> listarParaAprendiz(String ficha2) {
        ArrayList<UsuarioVO> listarFicha = new ArrayList<>();
        System.out.println("1");
        try {
            System.out.println("2" + obtenerConexion());
            conexion = this.obtenerConexion();
            System.out.println("3");
            sql = "SELECT funcionario.nombre, funcionario.apellido FROM funcionario INNER JOIN usuario ON funcionario.`idUsuario(FK)` = usuario.idUsuario INNER JOIN salon ON usuario.idUsuario = salon.`idUsuario(FK)` WHERE salon.`idFicha(FK)` =?";
            System.out.println("4");
            puente = conexion.prepareStatement(sql);
            System.out.println("5" + ficha2);
            puente.setString(1, ficha2);
            System.out.println("6");
            mensajero = puente.executeQuery();
            System.out.println("7");
            while (mensajero.next()) {

                UsuarioVO usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2));
                listarFicha.add(usuVO);

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
        return listarFicha;
    }

    /*public UsuarioVO Archivo_Excel(String excel) throws FileNotFoundException, IOException {
        FileInputStream archivo = new FileInputStream(excel);
        XSSFWorkbook libro = new XSSFWorkbook(archivo);
        XSSFSheet hoja = libro.getSheetAt(0);
        int numero_Filas = hoja.getLastRowNum();
        for (int i = 0; i <= numero_Filas; i++) {
            Row fila = hoja.getRow(i);
            try {
                sql = "insert into aprendiz (`nombre`,`apellido`,`correo`,`numIdentidad`) values(?,?,?,?)";
                puente = conexion.prepareStatement(sql);
                puente.setString(1, fila.getCell(0).getStringCellValue());
                puente.setString(2, fila.getCell(1).getStringCellValue());
                puente.executeUpdate();
            } catch (Exception e) {
                //Logger.getLogger(Archivo_Excel.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return Archivo_Excel(excel);
    }*/
}
