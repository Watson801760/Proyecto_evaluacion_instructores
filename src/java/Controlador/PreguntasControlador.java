/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.PreguntasDAO;
import ModeloVO.PreguntasVO;
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
@WebServlet(name = "PreguntasControlador", urlPatterns = {"/Preguntas"})
public class PreguntasControlador extends HttpServlet {

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
        String idPregunta = request.getParameter("textId");
        String pregunta = request.getParameter("textPreguntas");
        String respuestaFavorable = request.getParameter("textRespuestaFav");
        String estado = request.getParameter("textEstado");
        String idClasificacionFK =request.getParameter("textClasificacion");
        String idEvaluacionFK =request.getParameter("textEvaluacion");
        String valor = request.getParameter("sql");
        String id = request.getParameter("id");
        
        PreguntasVO preVO = new PreguntasVO(idPregunta,pregunta,respuestaFavorable,estado,idClasificacionFK,idEvaluacionFK);
        PreguntasDAO preDAO = new PreguntasDAO(preVO);
        
        switch(opcion){
        
            
            case 1:
                if ( preDAO.Pregunta(pregunta) != null) {
                    request.setAttribute("mensajeError", "La pregunta ya existe");
                } else if(preDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "La pregunta se pudo registrar correctamente");
                }else{
                    request.setAttribute("mensajeError", "La pregunta no se pudo registrar correctamente");
                }
                request.getRequestDispatcher("Crear_Preguntas.jsp").forward(request, response);
                break;
                
                
            case 2:  
                
                if (preDAO.eliminarRegistro(idPregunta)) {
                  
                    
                } else {
                    request.setAttribute("mensajeError", "La pregunta no se pudo eliminar");

                }
                request.getRequestDispatcher("Consultar_Preguntas.jsp").forward(request, response);
                break;
                
            case 3:  
                
                boolean aaa = preDAO.actualizarRegistro(valor, id);
                if (aaa == true) {
                    request.setAttribute("mensajeExito", "La pregunta se rescribio ");
                }else{
                    request.setAttribute("mensajeError", "La pregunta no se pudo sobrescribir");
                }
                request.getRequestDispatcher("Actualizar_Preguntas.jsp").forward(request, response);
                break; 
                
            case 4:
     
                preVO = preDAO.consultarPregunta(idPregunta);
                if (preVO != null ) {
                    request.setAttribute("preguntaConsultada", preVO);
                    request.getRequestDispatcher("Actualizar_Preguntas.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "No se ha registrado la pregunta ");
                    request.getRequestDispatcher("Consultar_Preguntas.jsp").forward(request, response);
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
