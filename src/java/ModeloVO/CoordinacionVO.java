/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author user
 */
public class CoordinacionVO {
    private String idCoordinacion, nombreCoordinacion;
    public CoordinacionVO() {
    }
    public CoordinacionVO(String idCoordinacion, String nombreCoordinacion) {
        this.idCoordinacion = idCoordinacion;
        this.nombreCoordinacion = nombreCoordinacion;
    }
    public String getIdCoordinacion() {
        return idCoordinacion;
    }

    public void setIdCoordinacion(String idCoordinacion) {
        this.idCoordinacion = idCoordinacion;
    }

    public String getNombreCoordinacion() {
        return nombreCoordinacion;
    }

    public void setNombreCoordinacion(String nombreCoordinacion) {
        this.nombreCoordinacion = nombreCoordinacion;
    }
    

    

    
}
