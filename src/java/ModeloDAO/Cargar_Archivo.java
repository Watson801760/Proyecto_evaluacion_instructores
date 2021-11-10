
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Util.Conexion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

/**
 *
 * @author user
 */
public class Cargar_Archivo {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.sql.SQLException
     */
    public static  void cargarDatos() throws FileNotFoundException, IOException, SQLException{
        FileInputStream archivo = new FileInputStream("C:\\Users\\user\\OneDrive\\Documentos\\Excel\\Aprendices2.xlsx");
        System.out.println("1"+archivo);
        XSSFWorkbook libro = new XSSFWorkbook(archivo);
        DataFormatter formatter = new DataFormatter();
        System.out.println("2");
        XSSFSheet hoja =  libro.getSheetAt(0);
        System.out.println("3");
        int numero_Filas = hoja.getLastRowNum();
        System.out.println("4");
        for(int i = 0;  i<= numero_Filas ; i++){
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
        }
        System.out.println("5");
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, SQLException {
        // TODO code application logic here
        cargarDatos();
    }
    
}
