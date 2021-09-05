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
public class EvaluaVO {
    private String idPregentaFK,idFuncionarioFK,idAprendizFK,repuesta;

    public EvaluaVO() {
    }

    public EvaluaVO(String idPregentaFK, String idFuncionarioFK, String idAprendizFK, String repuesta) {
        this.idPregentaFK = idPregentaFK;
        this.idFuncionarioFK = idFuncionarioFK;
        this.idAprendizFK = idAprendizFK;
        this.repuesta = repuesta;
    }

    public String getIdPregentaFK() {
        return idPregentaFK;
    }

    public void setIdPregentaFK(String idPregentaFK) {
        this.idPregentaFK = idPregentaFK;
    }

    public String getIdFuncionarioFK() {
        return idFuncionarioFK;
    }

    public void setIdFuncionarioFK(String idFuncionarioFK) {
        this.idFuncionarioFK = idFuncionarioFK;
    }

    public String getIdAprendizFK() {
        return idAprendizFK;
    }

    public void setIdAprendizFK(String idAprendizFK) {
        this.idAprendizFK = idAprendizFK;
    }

    public String getRepuesta() {
        return repuesta;
    }

    public void setRepuesta(String repuesta) {
        this.repuesta = repuesta;
    }
}
