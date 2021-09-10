/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ProgramaDAO;
import ModeloVO.ProgramaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sofia
 */
@WebServlet(name = "ProgramaControlador", urlPatterns = {"/Programa"})
public class ProgramaControlador extends HttpServlet {

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
        String idPrograma = request.getParameter("textId");
        String nombrePrograma = request.getParameter("textNombre");
        String VersionPrograma = request.getParameter("textVersion");
        String estado = request.getParameter("textEstado");
        String idNivelFK = request.getParameter("textNivel");
        String valor = request.getParameter("sql");
        String id = request.getParameter("id");

        ProgramaVO proVO = new ProgramaVO(idPrograma, nombrePrograma, VersionPrograma, estado, idNivelFK);
        ProgramaDAO proDAO = new ProgramaDAO(proVO);

        switch (opcion) {

            case 1:
                if (proDAO.Programa(nombrePrograma) != null) {
                    request.setAttribute("mensajeError", "El programa ya existe");
                } else if (proDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El programa se pudo registrar correctamente");
                } else {
                    request.setAttribute("mensajeError", "El programa no se pudo registrar correctamente");
                }
                request.getRequestDispatcher("Crear_Programa.jsp").forward(request, response);
                break;

            case 2:

                if (proDAO.eliminarRegistro(idPrograma)) {

                } else {
                    request.setAttribute("mensajeError", "El programa no se pudo eliminar");

                }
                request.getRequestDispatcher("Consultar_Programa.jsp").forward(request, response);
                break;

            case 3:

                boolean aaa = proDAO.actualizarRegistro(valor, id);
                if (aaa == true) {
                    request.setAttribute("mensajeExito", "El programa se rescribio ");
                } else {
                    request.setAttribute("mensajeError", "El programa no se pudo sobrescribir");
                }
                request.getRequestDispatcher("Actualizar_Programa.jsp").forward(request, response);
                break;

            case 4:

                proVO = proDAO.consultarPrograma(idPrograma);
                if (proVO != null) {
                    request.setAttribute("preguntaConsultada", proVO);
                    request.getRequestDispatcher("Actualizar_Programa.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "No se ha registrado el programa ");
                    request.getRequestDispatcher("Consultar_Programa.jsp").forward(request, response);
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
