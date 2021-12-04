/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.FuncionarioVO;
import Util.Conexion;
import Util.Crud;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author user
 */
public class FuncionarioDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String idFuncionario = "", nombre = "", apellido = "", correo = "", numIdentidad = "", urlFoto = "", idUsuarioFK = "", idCoordinacionFK = "";

    public FuncionarioDAO(FuncionarioVO funVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            idFuncionario = funVO.getIdFuncionario();
            nombre = funVO.getNombre();
            apellido = funVO.getApellido();
            correo = funVO.getCorreo();
            numIdentidad = funVO.getNumIdentidad();
            urlFoto = funVO.getUrlFoto();
            idUsuarioFK = funVO.getIdUsuarioFK();
            idCoordinacionFK = funVO.getIdCoordinacionFK();

        } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {

            sql = "insert into funcionario (`nombre`,`apellido`,`correo`,`numIdentidad`,`idCoordinacion(FK)`) values(?,?,?,?,?) ";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            puente.setString(2, apellido);
            puente.setString(3, correo);
            puente.setString(4, numIdentidad);
            puente.setString(5, idCoordinacionFK);
            puente.executeUpdate();
            this.operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return operacion;
    }

    @Override
    public boolean actualizarRegistro(String valor, String id) {
        try {
            sql = "update funcionario set nombre=?, apellido=?, correo=?, numIdentidad=? ,`idCoordinacion(FK)`=? where idFuncionario=? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, valor);
            puente.setString(2, apellido);
            puente.setString(3, correo);
            puente.setString(4, numIdentidad);
            puente.setString(5, idCoordinacionFK);
            puente.setString(6, id);

            puente.executeUpdate();
            this.operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<FuncionarioVO> listar() {
        ArrayList<FuncionarioVO> ListaFuncionario = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from Funcionario ";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                FuncionarioVO funVO = new FuncionarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7),
                        mensajero.getString(8));
                ListaFuncionario.add(funVO);

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
        return ListaFuncionario;
    }

    public FuncionarioVO consultarFuncionario(String id) {

        FuncionarioVO funVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from funcionario where idFuncionario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                funVO = new FuncionarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7),
                        mensajero.getString(8));
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
        return funVO;
    }

    public FuncionarioVO Funcionario(String funcionarioV) {

        FuncionarioVO funVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from funcionario where numIdentidad=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, funcionarioV);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                funVO = new FuncionarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7),
                        mensajero.getString(8));
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
        return funVO;
    }

    public ArrayList<FuncionarioVO> listarFicha(String ficha) {
        ArrayList<FuncionarioVO> ListaFuncionario = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT funcionario.idFuncionario, funcionario.nombre, funcionario.apellido, funcionario.correo, funcionario.numIdentidad FROM funcionario INNER JOIN usuario ON funcionario.`idUsuario(FK)` = usuario.idUsuario INNER JOIN salon ON usuario.idUsuario = salon.`idUsuario(FK)` WHERE salon.`idFicha(FK)` =?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ficha);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                FuncionarioVO funVO = new FuncionarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
                ListaFuncionario.add(funVO);

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
        return ListaFuncionario;
    }
    
    public boolean actualizarFuncionario(String valor, String id) {
       try {
            sql="update funcionario set nombre=?, apellido=?, correo=?, numIdentidad=? ,`idCoordinacion(FK)`=? where idFuncionario=? ";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, valor);    
            puente.setString(2,apellido );
            puente.setString(3,correo );
            puente.setString(4,numIdentidad );
            puente.setString(5,idCoordinacionFK);
            puente.setString(6,id);
            
            puente.executeUpdate();
            this.operacion= true;
            
            
        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }
    
    public FuncionarioVO consultarInstructor(String nombre) {

        FuncionarioVO funVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT funcionario.idFuncionario, funcionario.nombre, funcionario.apellido, funcionario.correo, funcionario.numIdentidad, funcionario.urlFoto, funcionario.`idUsuario(FK)`, funcionario.`idCoordinacion(FK)` FROM funcionario INNER JOIN usuario ON funcionario.`idUsuario(FK)` = usuario.idUsuario WHERE usuario.nombreUsuario = ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                funVO = new FuncionarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7),
                        mensajero.getString(8));
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
        return funVO;
    }
  public boolean Subir_Archivo (String archivo12) throws FileNotFoundException, IOException{
      System.out.println("0" + archivo12);
      FileInputStream archivo = new FileInputStream(archivo12);
        System.out.println("1"+archivo);
        XSSFWorkbook libro = new XSSFWorkbook(archivo);
        System.out.println("2");
        XSSFSheet hoja =  libro.getSheetAt(0);
        System.out.println("3");
        int numero_Filas = hoja.getLastRowNum();
        System.out.println("4");
        for(int i = 0;  i<= numero_Filas ; i++){
            try {
            Row fila = hoja.getRow(i);
            Conexion conexion = new Conexion();
            Connection conectar = conexion.obtenerConexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into funcionario (`nombre`,`apellido`,`correo`,`numIdentidad`,`idUsuario(FK)`,`idCoordinacion(FK)`) values(?,?,?,?,?,?)");
           
            insertar.setString(1,fila.getCell(0).getStringCellValue());
          
            insertar.setString(2,fila.getCell(1).getStringCellValue());
         
            insertar.setString(3,fila.getCell(2).getStringCellValue());
         
            insertar.setInt(4, (int) fila.getCell(3).getNumericCellValue());
            
            insertar.setInt(5, (int) fila.getCell(4).getNumericCellValue());
            
            insertar.setInt(6, (int) fila.getCell(5).getNumericCellValue());
            insertar.executeUpdate();
            this.operacion=true;
            } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        }
        System.out.println("5");
     
       
            
            
         
        /*finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
        return operacion;
    }
    public ArrayList<FuncionarioVO>listarParaAprendiz(String ficha2){
        ArrayList<FuncionarioVO> listarFicha= new ArrayList<>();
          
        try {
            
            conexion= this.obtenerConexion();
           
            sql="SELECT \n" +
                "funcionario.idFuncionario, \n" +
                "funcionario.nombre, \n" +
                "funcionario.apellido, \n" +
                "funcionario.correo, \n" +
                "funcionario.numIdentidad, \n" +
                "funcionario.urlFoto ,\n" +
                "funcionario.`idUsuario(FK)` ,\n" +
                "funcionario.`idCoordinacion(FK)` \n" +
                "FROM funcionario \n" +
                "INNER JOIN usuario ON funcionario.`idUsuario(FK)` = usuario.idUsuario \n" +
                "INNER JOIN salon ON usuario.idUsuario = salon.`idUsuario(FK)` WHERE salon.`idFicha(FK)` = ?";
            
            puente= conexion.prepareStatement(sql);
           
             puente.setString(1, ficha2);
             
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                FuncionarioVO funVO = new FuncionarioVO(
                    mensajero.getString(1), 
                    mensajero.getString(2), 
                    mensajero.getString(3),
                    mensajero.getString(4),
                    mensajero.getString(5),
                    mensajero.getString(6),
                    mensajero.getString(7),
                    mensajero.getString(8)
                );
                listarFicha.add(funVO);
                        
            
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
    public FuncionarioVO consultarFuncionario_Evalua(String id) {

        FuncionarioVO funVO = null;
        try {
            System.out.println("EvaluaFuncionario"+conexion);
            conexion = this.obtenerConexion();
            System.out.println("EvaluaFuncionario la" + sql);
            sql = "SELECT evalua.`idFuncionario(FK)` FROM `evalua` INNER JOIN `funcionario` ON evalua.`idFuncionario(FK)` = funcionario.idFuncionario WHERE `idFuncionario` = ?";
            System.out.println("EvaluaFuncionario pasa la consulta");
            puente = conexion.prepareStatement(sql);
            System.out.println("EvaluaFuncionario"+ id);
            puente.setString(1, id);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                funVO = new FuncionarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7),
                        mensajero.getString(8));
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
        return funVO;
    }
}
