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
public class FichaVO {
    private String idFicha,numeroFicha,fechaInicioElectiva,fechaFinElectiva,fechaInicioProductiva,fechaFinProductiva,estado,idProgramaFK;
    public FichaVO() {
    }

    public FichaVO(String idFicha, String numeroFicha, String fechaInicioElectiva, String fechaFinElectiva, String fechaInicioProductiva, String fechaFinProductiva, String estado, String idProgramaFK) {
        this.idFicha = idFicha;
        this.numeroFicha = numeroFicha;
        this.fechaInicioElectiva = fechaInicioElectiva;
        this.fechaFinElectiva = fechaFinElectiva;
        this.fechaInicioProductiva = fechaInicioProductiva;
        this.fechaFinProductiva = fechaFinProductiva;
        this.estado = estado;
        this.idProgramaFK = idProgramaFK;
    }

    public String getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(String idFicha) {
        this.idFicha = idFicha;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public String getFechaInicioElectiva() {
        return fechaInicioElectiva;
    }

    public void setFechaInicioElectiva(String fechaInicioElectiva) {
        this.fechaInicioElectiva = fechaInicioElectiva;
    }

    public String getFechaFinElectiva() {
        return fechaFinElectiva;
    }

    public void setFechaFinElectiva(String fechaFinElectiva) {
        this.fechaFinElectiva = fechaFinElectiva;
    }

    public String getFechaInicioProductiva() {
        return fechaInicioProductiva;
    }

    public void setFechaInicioProductiva(String fechaInicioProductiva) {
        this.fechaInicioProductiva = fechaInicioProductiva;
    }

    public String getFechaFinProductiva() {
        return fechaFinProductiva;
    }

    public void setFechaFinProductiva(String fechaFinProductiva) {
        this.fechaFinProductiva = fechaFinProductiva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdProgramaFK() {
        return idProgramaFK;
    }

    public void setIdProgramaFK(String idProgramaFK) {
        this.idProgramaFK = idProgramaFK;
    }
    
}
