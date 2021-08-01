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
    private String idPregunta,pregunta,respuestaFavorable,estado;

    public PreguntasVO() {
    }

    public PreguntasVO(String idPregunta, String pregunta, String respuestaFavorable, String estado) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.respuestaFavorable = respuestaFavorable;
        this.estado = estado;
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

    
}
