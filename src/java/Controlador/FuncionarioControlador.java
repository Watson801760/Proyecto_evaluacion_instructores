/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.FuncionarioDAO;
import ModeloVO.FuncionarioVO;
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
@WebServlet(name = "FuncionarioControlador", urlPatterns = {"/Funcionario"})
public class FuncionarioControlador extends HttpServlet {

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
        String idFuncionario = request.getParameter("textId");
        String nombre = request.getParameter("textNombre");
        String apellido = request.getParameter("textApellido");
        String correo = request.getParameter("textCorreo");
        String numIdentidad =request.getParameter("textIdentidad");
        String urlFoto =request.getParameter("textFoto");
        String idUsuarioFK =request.getParameter("textUsuFK");
        String idCoordinacionFK =request.getParameter("textCoFK");
        String valor = request.getParameter("sql");
        String id = request.getParameter("id");
        String ruta = "C:\\Users\\user\\OneDrive\\Documentos\\Excel\\";
        
        FuncionarioVO funVO = new FuncionarioVO(idFuncionario,nombre,apellido,correo,numIdentidad,urlFoto,idUsuarioFK,idCoordinacionFK);
        FuncionarioDAO funDAO = new FuncionarioDAO(funVO);
        
        
        switch(opcion){
          case 1:
              if ( funDAO.Funcionario(numIdentidad) != null) {
                    request.setAttribute("mensajeError", "El instructor ya existe");
                } else if(funDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El Funcionario se registro correctamente");
                }else{
                    request.setAttribute("mensajeError", "El Funcionario no se pudo registrar correctamente");
                }
                request.getRequestDispatcher("Crear_Funcionario.jsp").forward(request, response);
                break;
                
                
            case 2:  
                
                if (funDAO.eliminarRegistro(idFuncionario)) {
                    
                } else {
                    request.setAttribute("mensajeError", "El funcionario no se pudo eliminar");

                }
                request.getRequestDispatcher("Consultar_Funcionario.jsp").forward(request, response);
                break;
                
            case 3:  
                
                boolean aaa = funDAO.actualizarRegistro(valor, id);
                if (aaa == true) {
                    request.setAttribute("mensajeExito", "El Funcionario se actualizo ");
                }else{
                    request.setAttribute("mensajeError", "El Funcionario no se pudo actualizar");
                }
                request.getRequestDispatcher("Actualizar_Funcionario.jsp").forward(request, response);
                break; 
                
            case 4:
     
                funVO = funDAO.consultarFuncionario(idFuncionario);
                if (funVO != null ) {
                    request.setAttribute("Funcionario Consultado", funVO);
                    request.getRequestDispatcher("Actualizar_Funcionario.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "No se ha registrado el Funcinario ");
                    request.getRequestDispatcher("Consultar_Funcionario.jsp").forward(request, response);
                }
                break;    
        
            case 5:
                
                if (funDAO.listarFicha(valor) != null ) {
                    request.setAttribute("mensajeExito", "Ficha Consultada");
                }else{
                    request.setAttribute("mensajeError", "No se ha encontrado la ficha ");
                    request.getRequestDispatcher("Consultar_Aprendiz.jsp").forward(request, response);
                }
            case 6:
                boolean aa = funDAO.actualizarFuncionario(valor, id);
                if (aa == true) {
                    request.setAttribute("mensajeExito", "El Instructor se actualizo");
                }else{
                    request.setAttribute("mensajeError", "El Instructor no se pudo actualizar");
                }
                request.getRequestDispatcher("Actualizar_Instructor.jsp").forward(request, response);
                break; 
                
            case 7:  
                  
                   boolean fff = funDAO.Subir_Archivo(ruta+valor);
                  
                if ( fff == true) { 
                  
                    request.setAttribute("mensajeExito", "se subioi archivo");
                     
                }else{
                    
                    request.setAttribute("mensajeError", "No se encontro el archivo ");
                    
                   
                   
                }
                request.getRequestDispatcher("Consultar_Funcionario.jsp").forward(request, response);
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
