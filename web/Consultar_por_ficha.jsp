<%-- 
    Document   : Consultar_por_ficha
    Created on : 07-oct-2021, 19:12:21
    Author     : user
--%>

<%@page import="ModeloVO.SalonVO"%>
<%@page import="ModeloDAO.SalonDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.EvaluaDAO"%>
<%@page import="ModeloVO.EvaluaVO"%>
<%@page import="ModeloDAO.FuncionarioDAO"%>
<%@page import="ModeloVO.FuncionarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.1/css/dataTables.bootstrap4.min.css">
    </head>
    <body>
        <div class="container">
        <h1>Funcionarios</h1>
          <form method="POST" action="Funcionario">
            <button class="btn btn-warning">Consultar</button>
            <input type="text" name="sql">
            <input type="hidden" value="5" name="opcion">
        </form><br>
                <table class="table table-striped table-bordered " style="width: 100%" id="example">
                     <thead>
                        <tr>
                        <th class="text-center">Nombre</th>
                        <th class="text-center" >Apellido</th>
                        <th class="text-center" >Correo</th>
                        <th class="text-center" >numIdentidad</th>
                        <th class="text-center" >Evaluaciòn</th>
                        <th></th>    
                    </tr>
                    </thead>
                    <tbody>
                        <% 
                    FuncionarioVO funVO = new FuncionarioVO();
                    FuncionarioDAO funDAO= new FuncionarioDAO(funVO);
                    EvaluaVO evaVO = new EvaluaVO();
                    EvaluaDAO evaDAO = new EvaluaDAO();
                    ArrayList<FuncionarioVO>listarFicha=funDAO.listarFicha("sql");
                    for (int i = 0; i < listarFicha.size(); i++) {
                        
                        
                            funVO= listarFicha.get(i);
                        if(evaDAO.consultarAprendiz(funVO.getIdFuncionario())!=null){
                           
                        }else{
                            request.setAttribute("mensajeError", "No ha sido evaluado");
                        }      
            
                    %>
                    
                    <tr>
                        <td class="text-center" ><%=funVO.getNombre() %></td>
                        <td class="text-center" ><%=funVO.getApellido() %></td>
                        <td class="text-center" ><%=funVO.getCorreo() %></td>
                        <td class="text-center" ><%=funVO.getNumIdentidad() %></td>
                        <td class="text-center" ><%if (request.getAttribute("mensajeError") == null) {%>
                                                <div style="color:aqua;">${mensajeExito}</div>
                                                <% } else if (request.getAttribute("mensajeExito") == null) {%>
                                                <div style="color:red;">${mensajeError}</div>
                                                <%}%></td>
                        <td class="text-center" >
                            <form method="POST" action="Funcionario">
                            <button class="btn btn-warning">Actualizar</button>
                            <input type="hidden" value="4" name="opcion">
                            <input type="hidden" value="<%=funVO.getIdFuncionario() %>" name="textId">
                            </form>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                   
                    <tfoot>
                         <tr>
                        <th class="text-center">Nombre</th>
                        <th class="text-center" >Apellido</th>
                        <th class="text-center" >Correo</th>
                        <th class="text-center" >numIdentidad</th>
                        <th class="text-center" >Evaluaciòn</th>
                        <th></th>    
                    </tr>
                    </tfoot>
                    
                   
                </table>
         
                <a class="btn btn-success" href="MenuAdministrador.jsp">Volver</a>
                <a class="btn btn-success" href="Crear_Funcionario.jsp">Registrar</a>
        </div>
        
         <script src="https://code.jquery.com/jquery-3.5.1.js"></script> 
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> 
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 
       
       <script src="https://cdn.datatables.net/1.11.1/js/jquery.dataTables.min.js"></script>  
       <script src="https://cdn.datatables.net/1.11.1/js/dataTables.bootstrap4.min.js"></script> 
       <script>
          $(document).ready(function() {
                $('#example').DataTable();
          } );
       </script>           
    </body>
</html>
