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
public class PreguntasVO {
    private String idPregunta,pregunta,respuestaFavorable,estado,idClasificacionFK,idEvaluacionFK;
    public PreguntasVO() {
    }
    public PreguntasVO(String idPregunta, String pregunta, String respuestaFavorable, String estado, String idClasificacionFK, String idEvaluacionFK) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.respuestaFavorable = respuestaFavorable;
        this.estado = estado;
        this.idClasificacionFK = idClasificacionFK;
        this.idEvaluacionFK = idEvaluacionFK;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuestaFavorable() {
        return respuestaFavorable;
    }

    public void setRespuestaFavorable(String respuestaFavorable) {
        this.respuestaFavorable = respuestaFavorable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdClasificacionFK() {
        return idClasificacionFK;
    }

    public void setIdClasificacionFK(String idClasificacionFK) {
        this.idClasificacionFK = idClasificacionFK;
    }

    public String getIdEvaluacionFK() {
        return idEvaluacionFK;
    }

    public void setIdEvaluacionFK(String idEvaluacionFK) {
        this.idEvaluacionFK = idEvaluacionFK;
    }

    
    }

    