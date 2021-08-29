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
public class AprendizVO {
    private String idAprendiz,nombre,apellido,correo,numIdentidad,urlFoto,idUsuarioFK;
    public AprendizVO() {
    }

    public AprendizVO(String idAprendiz, String nombre, String apellido, String correo, String numIdentidad, String urlFoto, String idUsuarioFK) {
        this.idAprendiz = idAprendiz;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numIdentidad = numIdentidad;
        this.urlFoto = urlFoto;
        this.idUsuarioFK = idUsuarioFK;
    }

    public String getIdAprendiz() {
        return idAprendiz;
    }

    public void setIdAprendiz(String idAprendiz) {
        this.idAprendiz = idAprendiz;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumIdentidad() {
        return numIdentidad;
    }

    public void setNumIdentidad(String numIdentidad) {
        this.numIdentidad = numIdentidad;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getIdUsuarioFK() {
        return idUsuarioFK;
    }

    public void setIdUsuarioFK(String idUsuarioFK) {
        this.idUsuarioFK = idUsuarioFK;
    }
    
}
