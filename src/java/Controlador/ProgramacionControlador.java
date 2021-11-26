/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ProgramacionDAO;
import ModeloVO.ProgramaVO;
import ModeloVO.ProgramacionVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author user
 */
@WebServlet(name = "ProgramacionControlador", urlPatterns = {"/Programacion"})
public class ProgramacionControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int opcion= Integer.parseInt(request.getParameter("opcion"));
        String idProgramacion = request.getParameter("textId");
        String fechaInicio = request.getParameter("textFechaInicio");
        String fechaFin = request.getParameter("textFechaFin");
        String codigoAcceso = request.getParameter("textCodigo");
        String semestre =request.getParameter("textSemestre");
        String idEvaluacionFK =request.getParameter("textFoto");
        String idUsuarioFK =request.getParameter("textUsuFK");
        String idCoordinacionFK =request.getParameter("textCoFK");
        String valor = request.getParameter("sql");
        String id = request.getParameter("id");
        Calendar fechaIniConv = Calendar.getInstance();
        Calendar fechaFinConv = Calendar.getInstance();
        
      
        
        
        if(fechaInicio != null && !"".equals(fechaInicio)){
            String fechaIniSplit[] = fechaInicio.split("-");
            fechaIniConv.set(Integer.parseInt(fechaIniSplit[0]), Integer.parseInt(fechaIniSplit[1]), Integer.parseInt(fechaIniSplit[2]));
        }
        if(fechaFin != null && !"".equals(fechaFin)){
            String fechaFinSplit[] = fechaFin.split("-");
            fechaIniConv.set(Integer.parseInt(fechaFinSplit[0]), Integer.parseInt(fechaFinSplit[1]), Integer.parseInt(fechaFinSplit[2]));
        }
      
        
     
        ProgramacionVO proVO = new ProgramacionVO(idProgramacion, codigoAcceso, semestre, idEvaluacionFK, fechaIniConv.getTime(), fechaFinConv.getTime());
        ProgramacionDAO proDAO = new ProgramacionDAO(proVO);
     
        
               switch(opcion){
          case 1:
            
               if(proDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "La programacion se registro correctamente");
                }else{
                    request.setAttribute("mensajeError", "La programacion no se pudo registrar correctamente");
                }
                request.getRequestDispatcher("Crear_Programacion.jsp").forward(request, response);
                break;
                
                
            case 2:  
                
                if (proDAO.eliminarRegistro(idProgramacion)) {
                    
                } else {
                    request.setAttribute("mensajeError", "El funcionario no se pudo eliminar");

                }
                request.getRequestDispatcher("Consultar_Programacion.jsp").forward(request, response);
                break;
                
            case 3:  
                
                boolean aaa = proDAO.actualizarRegistro(valor, id);
                if (aaa == true) {
                    request.setAttribute("mensajeExito", "El Funcionario se actualizo ");
                }else{
                    request.setAttribute("mensajeError", "El Funcionario no se pudo actualizar");
                }
                request.getRequestDispatcher("Actualizar_Programacion.jsp").forward(request, response);
                break; 
                
            case 4:
     
                proVO= proDAO.consultarProgramacion(idProgramacion);
                if (proVO != null ) {
                    request.setAttribute("Funcionario Consultado", proVO);
                    request.getRequestDispatcher("Actualizar_Programacion.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "No se ha registrado el Funcinario ");
                    request.getRequestDispatcher("Consultar_Programacion.jsp").forward(request, response);
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
