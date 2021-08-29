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
public class NivelVO {
    private String idNivel,nombreFormacion;
    public NivelVO() {
    }

    public NivelVO(String idNivel, String nombreFormacion) {
        this.idNivel = idNivel;
        this.nombreFormacion = nombreFormacion;
    }

    public String getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(String idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombreFormacion() {
        return nombreFormacion;
    }

    public void setNombreFormacion(String nombreFormacion) {
        this.nombreFormacion = nombreFormacion;
    }
    
}
