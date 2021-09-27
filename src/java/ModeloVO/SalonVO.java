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
public class SalonVO {
    private String idFichaFK,idUsuarioFK,estado;
    public SalonVO() {
    }

    public SalonVO(String idFichaFK, String idUsuarioFK, String estado) {
        this.idFichaFK = idFichaFK;
        this.idUsuarioFK = idUsuarioFK;
        this.estado = estado;
    }

    public String getIdFichaFK() {
        return idFichaFK;
    }

    public void setIdFichaFK(String idFichaFK) {
        this.idFichaFK = idFichaFK;
    }

    public String getIdUsuarioFK() {
        return idUsuarioFK;
    }

    public void setIdUsuarioFK(String idUsuarioFK) {
        this.idUsuarioFK = idUsuarioFK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
