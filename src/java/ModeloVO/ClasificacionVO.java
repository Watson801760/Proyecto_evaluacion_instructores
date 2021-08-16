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
public class ClasificacionVO {
    private String idClasificacion,NombreClasificacion;

    public ClasificacionVO() {
    }

    public ClasificacionVO(String idClasificacion, String NombreClasificacion) {
        this.idClasificacion = idClasificacion;
        this.NombreClasificacion = NombreClasificacion;
    }

    public String getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(String idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getNombreClasificacion() {
        return NombreClasificacion;
    }

    public void setNombreClasificacion(String NombreClasificacion) {
        this.NombreClasificacion = NombreClasificacion;
    }
    
}
