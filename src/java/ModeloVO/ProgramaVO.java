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
public class ProgramaVO {
    private String idPrograma,nombrePrograma,versionPrograma,estado,idNivelFK;
    public ProgramaVO() {
    }

    public ProgramaVO(String idPrograma, String nombrePrograma, String versionPrograma, String estado, String idNivelFK) {
        this.idPrograma = idPrograma;
        this.nombrePrograma = nombrePrograma;
        this.versionPrograma = versionPrograma;
        this.estado = estado;
        this.idNivelFK = idNivelFK;
    }

    public String getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(String idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String getVersionPrograma() {
        return versionPrograma;
    }

    public void setVersionPrograma(String versionPrograma) {
        this.versionPrograma = versionPrograma;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdNivelFK() {
        return idNivelFK;
    }

    public void setIdNivelFK(String idNivelFK) {
        this.idNivelFK = idNivelFK;
    }
    
}
