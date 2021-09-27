/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Sofia Paola
 */
public class UsuarioVO {
    private String idUsuario, nombreUsuario, contraseña, estado, idRolFK;
    public UsuarioVO() {
    }
    public UsuarioVO(String idUsuario, String idRolFK) {
        this.idUsuario = idUsuario;
        this.idRolFK = idRolFK;
    }
    
    public UsuarioVO(String idUsuario, String nombreUsuario, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }
    

    public UsuarioVO(String idUsuario, String nombreUsuario, String contraseña, String estado, String idRolFK) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.estado = estado;
        this.idRolFK = idRolFK;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdRolFK() {
        return idRolFK;
    }

    public void setIdRolFK(String idRolFK) {
        this.idRolFK = idRolFK;
    }                  
}