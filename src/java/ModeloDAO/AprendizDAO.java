/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.AprendizVO;
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
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author user
 */
public class AprendizDAO extends Conexion implements Crud{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion= false;
    private String sql;
    private String idAprendiz="",nombre="",apellido="",correo="",tipoDocumento="",numIdentidad="",urlFoto="",idUsuarioFK="" ;
    
    public AprendizDAO (AprendizVO aprenVO){
      super();
        try {
            conexion= this.obtenerConexion();
            idAprendiz=aprenVO.getIdAprendiz();
            nombre=aprenVO.getNombre();
            apellido=aprenVO.getApellido();
            correo=aprenVO.getCorreo();
            tipoDocumento=aprenVO.getTipoDocumento();
            numIdentidad=aprenVO.getNumIdentidad();
            urlFoto=aprenVO.getUrlFoto();
            idUsuarioFK=aprenVO.getIdUsuarioFK();
            
           } catch (Exception e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    @Override
    public boolean agregarRegistro() {
       
        try {
       
            sql="insert into aprendiz (`nombre`,`apellido`,`correo`,`numIdentidad`) values(?,?,?,?) ";
       
            puente= conexion.prepareStatement(sql);
            puente.setString(1,nombre);
            puente.setString(2,apellido);
            puente.setString(3,correo);
            puente.setString(4,numIdentidad);
            puente.executeUpdate();
            this.operacion=true;
            
         
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
            sql="update aprendiz set nombre=?, apellido=?, correo=?, numIdentidad=? where idAprendiz=? ";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, valor);
            puente.setString(2,apellido );
            puente.setString(3,correo );
            puente.setString(4,numIdentidad );
            puente.setString(5, id);
            
            puente.executeUpdate();
            this.operacion= true;
            
            
        } catch (SQLException e) {
            Logger.getLogger(AprendizDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
    public ArrayList<AprendizVO>listar(){
        ArrayList<AprendizVO> ListaAprendiz= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="select * from aprendiz ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                AprendizVO aprenVO = new AprendizVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                                   mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),mensajero.getString(8));
                ListaAprendiz.add(aprenVO);
                        
            
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
        return ListaAprendiz;
    }
    
    public AprendizVO consultarAprendiz(String id){
    
    AprendizVO aprenVO= null;
        try {
            conexion = this.obtenerConexion();
            sql="select * from aprendiz where idAprendiz= ?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, id);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                aprenVO= new AprendizVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                        mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),mensajero.getString(8));
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
        return aprenVO;
    }
    
    public AprendizVO Aprendiz (String funcionarioV){
    
    AprendizVO AprenVO= null;
        try {
            conexion = this.obtenerConexion();
            sql="select * from funcionario where numIdentidad=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1,funcionarioV);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                AprenVO= new AprendizVO (mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                        mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),mensajero.getString(8));
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
        return AprenVO;
    }
    
     public ArrayList<AprendizVO>listarFicha(String ficha){
        ArrayList<AprendizVO> ListaAprendiz= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="SELECT aprendiz.idAprendiz, aprendiz.nombre, aprendiz.apellido, aprendiz.correo, aprendiz.numIdentidad FROM aprendiz INNER JOIN usuario "
     + "ON aprendiz.`idUsuario(FK)` = usuario.idUsuario INNER JOIN salon ON usuario.idUsuario = salon.`idUsuario(FK)` WHERE salon.`idFicha(FK)` = ? ";
            puente= conexion.prepareStatement(sql);
             puente.setString(1, ficha);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                AprendizVO aprenVO = new AprendizVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                                                   mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),mensajero.getString(8));
                ListaAprendiz.add(aprenVO);
                        
            
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
        return ListaAprendiz;
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
            PreparedStatement insertar = conectar.prepareStatement("insert into aprendiz (`nombre`,`apellido`,`correo`,`numIdentidad`,`tipoDocumento`,`idUsuario(FK)`) values(?,?,?,?,?,?)");
            System.out.println("5"+ 1);
            insertar.setString(1,fila.getCell(0).getStringCellValue());
            System.out.println("6"+ 2);
            insertar.setString(2,fila.getCell(1).getStringCellValue());
            System.out.println("7"+ 3);
            insertar.setString(3,fila.getCell(2).getStringCellValue());
            System.out.println("NEAAAAA: "+(int) fila.getCell(3).getNumericCellValue());
            insertar.setInt(4, (int) fila.getCell(3).getNumericCellValue());
            System.out.println("9"+ 5);
            insertar.setString(5,fila.getCell(4).getStringCellValue());
            System.out.println("10"+ (int) fila.getCell(5).getNumericCellValue());
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
  
  public AprendizVO consultarAprendiz_Por_Usuario(String nombre) {

        AprendizVO aprenVO = null;
        try {
            
            conexion = this.obtenerConexion();
           
            sql = "SELECT aprendiz.idAprendiz, aprendiz.nombre, aprendiz.apellido, aprendiz.correo, aprendiz.tipoDocumento, aprendiz.numIdentidad, aprendiz.urlFoto, aprendiz.`idUsuario(FK)` FROM aprendiz INNER JOIN usuario ON aprendiz.`idUsuario(FK)` = usuario.idUsuario WHERE usuario.nombreUsuario = ?";
        
            puente = conexion.prepareStatement(sql);
            
            puente.setString(1, nombre);
            
            mensajero = puente.executeQuery();
           
            while (mensajero.next()) {

                aprenVO = new AprendizVO(idAprendiz, nombre, apellido, correo, idAprendiz, numIdentidad, urlFoto, idUsuarioFK);
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
        return aprenVO;
    }
       
}

