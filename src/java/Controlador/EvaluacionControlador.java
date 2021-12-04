/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.AprendizDAO;
import ModeloDAO.EvaluaDAO;
import ModeloDAO.FichaDAO;
import ModeloDAO.FuncionarioDAO;
import ModeloDAO.PreguntasDAO;
import ModeloVO.AprendizVO;
import ModeloVO.EvaluaVO;
import ModeloVO.FichaVO;
import ModeloVO.FuncionarioVO;
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
@WebServlet(name = "EvaluacionControlador", urlPatterns = {"/Evaluacion"})
public class EvaluacionControlador extends HttpServlet {

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
        String idPregentaFK = request.getParameter("textPreguntaFK");
        String idFuncionarioFK = request.getParameter("textFuncionarioFK");
        String idAprendizFK = request.getParameter("textAprendizFK");
        String repuesta = request.getParameter("respuesta");
        String idFuncionario = request.getParameter("textIdFun");
        
        EvaluaVO evaVO = new EvaluaVO(idPregentaFK,idFuncionarioFK,idAprendizFK,repuesta);
        EvaluaDAO evaDAO = new EvaluaDAO(evaVO);
        PreguntasVO preVO = new PreguntasVO(idPregunta,pregunta,respuestaFavorable,estado,idClasificacionFK,idEvaluacionFK);
        PreguntasDAO preDAO = new PreguntasDAO(preVO);
        AprendizVO aprenVO = new AprendizVO();
        AprendizDAO aprenDAO = new AprendizDAO(aprenVO);
        FuncionarioVO funVO = new FuncionarioVO(idFuncionario);
        FuncionarioDAO funDAO = new FuncionarioDAO(funVO);
        FichaVO ficVO= new FichaVO();
        FichaDAO ficDAO = new FichaDAO(ficVO);

        switch(opcion){
        
            case 1:
                preVO = preDAO.consultarPregunta(idPregunta);
                if (preVO != null ) {
                    request.setAttribute("preguntaConsultada", preVO);
                    request.getRequestDispatcher("Actualizar_Preguntas.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "No se ha registrado la pregunta ");
                    request.getRequestDispatcher("Consultar_Preguntas.jsp").forward(request, response);
                }
                break;    
                
            case 2:
                System.out.println("aprendiz" + valor);
                aprenVO = aprenDAO.consultarAprendiz_Por_Usuario(valor);
                funVO = funDAO.consultarFuncionario(idFuncionario);
                if(aprenVO != null){
                    
                    request.setAttribute("Funcionario Consultado", funVO);
                    request.setAttribute("Aprendiz Consultado", aprenVO);    
                    request.getRequestDispatcher("Evaluacion.jsp").forward(request, response);
                    
                }else{
                   request.getRequestDispatcher("Instructores.jsp").forward(request, response);
                }
            case 3:
                System.out.println("agerga registro" + repuesta);
                System.out.println("agerga registro" + idPregentaFK);
                System.out.println("agerga registro" + idFuncionarioFK);
                System.out.println("agerga registro" + idAprendizFK);
                  if(evaDAO.agregarRegistro()) {
                      System.out.println("hizo el registro");
                    request.setAttribute("mensajeExito", "Se registro la evaluacion corretamente");
                }else{
                    request.setAttribute("mensajeError", "No se registro la evaluacion corretamente");
                }
                request.getRequestDispatcher("Evaluacion.jsp").forward(request, response);
                break;
             case 4:    
                ficVO = ficDAO.consultarAprendiz_Ficha(valor);   
                if(ficVO!= null){

                request.setAttribute("Ficha Consultada", ficVO);
                request.getRequestDispatcher("Instructores.jsp").forward(request, response);

                }else{
                request.setAttribute("mensajeError", "No se encontraron fichas para el usuario ");
                request.getRequestDispatcher("Evaluacion.jsp").forward(request, response);
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

    


