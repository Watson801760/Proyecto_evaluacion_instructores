/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.FichaDAO;
import ModeloVO.FichaVO;
import com.sun.javafx.application.ParametersImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "FichaControlador", urlPatterns = {"/Ficha"})
public class FichaControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void processRequest(HttpServletRequest request,HttpServletResponse response)
           throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       int opcion=Integer.parseInt(request.getParameter ("opcion"));
       String IdFicha = request.getParameter("textIdfich");
       String numeroFicha = request.getParameter("textnumfi"); 
       String fechaInicioElectiva = request.getParameter("textFechaini"); 
       String fechaFinElectiva= request.getParameter("textFechafn"); 
       String fechaInicioProductiva = request.getParameter("textFechainip"); 
       String fechaFinProductiva= request.getParameter("textFechafnp");
       String estado= request.getParameter("estado"); 
       String  idProgramaFK= request.getParameter("textProgFk"); 
       
       FichaVO fichVO = new FichaVO(IdFicha, numeroFicha, fechaInicioElectiva, fechaFinElectiva, fechaInicioProductiva, fechaFinProductiva, estado, idProgramaFK);
       FichaDAO fichDAO = new FichaDAO(fichVO);
       
       
        switch(opcion){
          case 1:
                if(fichDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "La Ficha se registro correctamente");
                }else{
                    request.setAttribute("mensajeError", "La Ficha no se pudo registrar correctamente");
                }
                request.getRequestDispatcher("Crear_Ficha.jsp").forward(request, response);
                break;
                
                
            case 2:  
                
                if (fichDAO.eliminarRegistro(IdFicha)) {
                    
                } else {
                    request.setAttribute("mensajeError", "La Ficha no se pudo eliminar");

                }
                request.getRequestDispatcher("Consultar_Ficha.jsp").forward(request, response);
                break;
                
          /* case 3:  
                
                boolean aaa = fichDAO.actualizarRegistro();
                if (aaa == true) {
                    request.setAttribute("mensajeExito", "La Ficha se actualizo ");
                }else{
                    request.setAttribute("mensajeError", "La Ficha no se pudo actualizar");
                }
                request.getRequestDispatcher("Actualizar_Ficha.jsp").forward(request, response);
                break; */
                
            case 4:
     
                fichVO = fichDAO.consultarFicha(IdFicha);
                if (fichVO != null ) {
                    request.setAttribute("Ficha Consultada", fichVO);
                    request.getRequestDispatcher("Actualizar_Funcionario.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "No se ha registrado la Ficha ");
                    request.getRequestDispatcher("Consultar_Ficha.jsp").forward(request, response);
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
