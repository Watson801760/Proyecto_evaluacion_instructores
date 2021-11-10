/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.FichaDAO;
import ModeloDAO.FuncionarioDAO;
import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.FichaVO;
import ModeloVO.FuncionarioVO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sofia Paola
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String idUsuario = request.getParameter("textId");
        String nombreUsuario = request.getParameter("textUsuario");
        String contrasena = request.getParameter("textContrasena");
        String estado = request.getParameter("textEstado");
        String idRolFK = request.getParameter("textRol");
        

        UsuarioVO usuVO = new UsuarioVO(idUsuario, nombreUsuario, contrasena, estado, idRolFK);
        UsuarioVO boVO = new UsuarioVO( nombreUsuario);
        FuncionarioVO funVO = new FuncionarioVO();
        FuncionarioDAO funDAO = new FuncionarioDAO(funVO);
        FichaVO ficVO= new FichaVO();
        FichaDAO ficDAO = new FichaDAO(ficVO);
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
        
        switch (opcion) {
            case 1://agregar regstro
                if (usuDAO.agregarRegistro()) {
                    request.setAttribute("mensajEXito", "El usuario se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario NO se registro correctamente");
                }
                request.getRequestDispatcher("").forward(request, response);
                break;
            case 2:// actualizar registros
                if (usuDAO.actualizarRegistro(nombreUsuario, idUsuario)) {
                    request.setAttribute("mensajEXito", "El usuario se registro correctamente");
                }else {
                    request.setAttribute("mensajeError", "El usuario NO se actualizo correctamente");
                }
                request.getRequestDispatcher("").forward(request, response);
                break;
            case 3://inicio de sesion    
         
                String usuId = "";
             
                if (usuDAO.iniciarSesion(nombreUsuario, contrasena)){
            
                    RolDAO rol = new RolDAO();
              
                    HttpSession miSesion = request.getSession(true);    
                
                    usuVO = new UsuarioVO(idUsuario, nombreUsuario, contrasena);
                 
                    miSesion.setAttribute("datosUsuario", usuVO);
                    
                    ArrayList<UsuarioVO> listaRol = rol.rol(nombreUsuario);
                
                    for (int i = 0; i < listaRol.size(); i++) {
                        usuVO = listaRol.get(i);
                 
                        usuId = usuVO.getIdUsuario();
                    }
                                                  
                    miSesion.setAttribute("rol", listaRol);  
               
                    if (usuVO.getIdRolFK().equals("Administrador")) {
                     
                        request.getRequestDispatcher("MenuAdministrador.jsp").forward(request, response);
                
                    } else if (usuVO.getIdRolFK().equals("Aprendiz")) {
                        
                        ficVO = ficDAO.consultarAprendiz_Ficha(nombreUsuario);   
                        if(ficVO!= null){
                      
                        request.setAttribute("Ficha Consultada", ficVO);

                        request.setAttribute("nomUsuario",nombreUsuario);
                        request.getRequestDispatcher("Instructores.jsp").forward(request, response);
                        
                        }else{
                        request.setAttribute("mensajeError", "No se encontraron fichas para el usuario ");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                        
                        
                    } else if (usuVO.getIdRolFK().equals("Instructor")) {
                        funVO = funDAO.consultarInstructor(nombreUsuario);
                        if(funVO!= null){
                        request.setAttribute("Instructor Consultado", funVO);
                        request.getRequestDispatcher("Actualizar_Instructor.jsp").forward(request, response);
                        System.out.println("se va a instructores");
                        }else{
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        request.getRequestDispatcher("MenuAdministrador.jsp").forward(request, response);
                        }               
                        
                }else{
                    request.setAttribute("mensajeError", "Datos de inicio de sesion incorrectos");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                break;            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

    }
}
