/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
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
                System.out.println("1"+nombreUsuario);
                String usuId = "";
                System.out.println("2"+contrasena);
                if (usuDAO.iniciarSesion(nombreUsuario, contrasena)){
                    System.out.println("3");
                    RolDAO rol = new RolDAO();
                    System.out.println("4");
                    HttpSession miSesion = request.getSession(true);    
                    System.out.println("5");
                    usuVO = new UsuarioVO(idUsuario, nombreUsuario, contrasena);
                    System.out.println("6");
                    miSesion.setAttribute("datosUsuario", usuVO);
                    System.out.println("7 "+nombreUsuario);
                    ArrayList<UsuarioVO> listaRol = rol.rol(nombreUsuario);
                    System.out.println("8");
                    for (int i = 0; i < listaRol.size(); i++) {
                        usuVO = listaRol.get(i);
                    System.out.println("9");    
                        usuId = usuVO.getIdUsuario();
                    }
                    System.out.println("10");                                       
                    miSesion.setAttribute("rol", listaRol);  
                    System.out.println("11");
                    if (usuVO.getIdRolFK().equals("Administrador")) {
                      System.out.println("12");  
                        request.getRequestDispatcher("MenuAdministrador.jsp").forward(request, response);
                     System.out.println("13");   
                    } else if (usuVO.getIdRolFK().equals("Aprendiz")) {
                      System.out.println("14");  
                        request.getRequestDispatcher("Instructores.jsp").forward(request, response);
                     System.out.println("15");   
                    } else if (usuVO.getIdRolFK().equals("Instructor")) {
                     System.out.println("16");   
                        request.getRequestDispatcher("MenuAdministrador.jsp").forward(request, response);
                    }                                        
                }else{
                    request.setAttribute("mensajeError", "Datos de inicio de sesion incorrectos");
                    request.getRequestDispatcher("InicioDeSesion.jsp").forward(request, response);
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
