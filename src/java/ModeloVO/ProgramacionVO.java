/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author user
 */
public class ProgramacionVO {
  private String idProgramacion,codigoAcceso,semestre,idEvaluacionFK;
    private Date fechaInicio,fechaFin;
    public ProgramacionVO() {
    }
    
    public ProgramacionVO(String idProgramacion, String codigoAcceso, String semestre, String idEvaluacionFK, Date fechaInicio, Date fechaFin) {
        this.idProgramacion = idProgramacion;
        this.codigoAcceso = codigoAcceso;
        this.semestre = semestre;
        this.idEvaluacionFK = idEvaluacionFK;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(String idProgramacion) {
        this.idProgramacion = idProgramacion;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
