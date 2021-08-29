/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author user
 */
public interface Crud {
    public abstract boolean agregarRegistro();
    public abstract boolean actualizarRegistro( String valor, String id);
    public abstract boolean eliminarRegistro(String id);
}
