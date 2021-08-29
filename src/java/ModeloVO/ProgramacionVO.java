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
public class ProgramacionVO {
    private String idProgramacion,fechaInicio,fechaFin,codigoAcceso,semestre,idEvaluacionFK;
    public ProgramacionVO() {
    }

    public ProgramacionVO(String idProgramacion, String fechaInicio, String fechaFin, String codigoAcceso, String semestre, String idEvaluacionFK) {
        this.idProgramacion = idProgramacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.codigoAcceso = codigoAcceso;
        this.semestre = semestre;
        this.idEvaluacionFK = idEvaluacionFK;
    }

    public String getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(String idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodigoAcceso() {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getIdEvaluacionFK() {
        return idEvaluacionFK;
    }

    public void setIdEvaluacionFK(String idEvaluacionFK) {
        this.idEvaluacionFK = idEvaluacionFK;
    }
    
}
