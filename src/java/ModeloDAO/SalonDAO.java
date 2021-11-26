/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.SalonVO;
import Util.Conexion;
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
public class SalonDAO extends Conexion {
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
    private boolean operacion= false;
    
         public ArrayList<SalonVO>listar(){
        ArrayList<SalonVO> ListaFicha= new ArrayList<>();
    
        try {
            conexion= this.obtenerConexion();
            sql="select * from salon ";
            puente= conexion.prepareStatement(sql);
            mensajero= puente.executeQuery();
            
            while(mensajero.next()){
            
                SalonVO salVO = new SalonVO (mensajero.getString(1), mensajero.getString(2),mensajero.getString(3));
                ListaFicha.add(salVO);
                        
            
            }
            
        } catch (Exception e) {
            Logger.getLogger(SalonDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{    
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(SalonDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ListaFicha;
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
            PreparedStatement insertar = conectar.prepareStatement("insert into salon (`idFicha(FK)`,`idUsuario(FK)`,`estado`) values(?,?,?)");
           
     
         
            insertar.setInt(1, (int) fila.getCell(0).getNumericCellValue());
            
            insertar.setInt(2, (int) fila.getCell(1).getNumericCellValue());
            
            insertar.setInt(3, (int) fila.getCell(2).getNumericCellValue());
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
}
