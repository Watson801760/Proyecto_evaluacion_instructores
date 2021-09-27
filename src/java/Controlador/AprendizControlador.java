/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.AprendizDAO;
import ModeloVO.AprendizVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "AprendizControlador", urlPatterns = {"/Aprendiz"})
public class AprendizControlador extends HttpServlet {

    private AprendizVO aprenVO;

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
        int opcion= Integer.parseInt(request.getParameter("opcion"));
        String idAprendiz = request.getParameter("textId");
        String nombre = request.getParameter("textNombre");
        String apellido = request.getParameter("textApellido");
        String correo = request.getParameter("textCorreo");
        String numIdentidad =request.getParameter("textIdentidad");
        String urlFoto =request.getParameter("textFoto");
        String idUsuarioFK =request.getParameter("textUsuFK");
        String valor = request.getParameter("sql");
        String id = request.getParameter("id");
        
       AprendizVO aprenVO = new AprendizVO(idAprendiz, nombre, apellido, correo, numIdentidad, urlFoto, idUsuarioFK);
       AprendizDAO aprenDAO = new AprendizDAO(aprenVO);
       
        switch(opcion){
          case 1:
              if ( aprenDAO.Aprendiz(numIdentidad) != null) {
                    request.setAttribute("mensajeError", "El Aprendiz ya existe");
                } else if(aprenDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El aprendiz se registro correctamente");
                }else{
                    request.setAttribute("mensajeError", "El aprendiz no se pudo registrar correctamente");
                }
                request.getRequestDispatcher("Crear_Aprendiz.jsp").forward(request, response);
                break;
                
                
            case 2:  
                
                if (aprenDAO.eliminarRegistro(idAprendiz)) {
                  
                    
                } else {
                    request.setAttribute("mensajeError", "La pregunta no se pudo eliminar");

                }
                request.getRequestDispatcher("Consultar_Preguntas.jsp").forward(request, response);
                break;
                
            case 3:  
                
                boolean aaa = aprenDAO.actualizarRegistro(valor, id);
                if (aaa == true) {
                    request.setAttribute("mensajeExito", "El aprendiz se actualizo ");
                }else{
                    request.setAttribute("mensajeError", "El aprendiz no se pudo actualizar");
                }
                request.getRequestDispatcher("Actualizar_Preguntas.jsp").forward(request, response);
                break; 
                
            case 4:
     
                aprenVO = aprenDAO.consultarAprendiz(idAprendiz);
                if (aprenVO != null ) {
                    request.setAttribute("Aprendiz Consultado", aprenVO);
                    request.getRequestDispatcher("Actualizar_Aprendiz.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "No se ha registrado la pregunta ");
                    request.getRequestDispatcher("Consultar_Aprendiz.jsp").forward(request, response);
                }
                break;    
            case 5:
                
                if (aprenDAO.listarFicha(valor) != null ) {
                    request.setAttribute("mensajeExito", "Ficha Consultada");
                }else{
                    request.setAttribute("mensajeError", "No se ha encontrado la ficha ");
                    request.getRequestDispatcher("Consultar_Aprendiz.jsp").forward(request, response);
                }
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
