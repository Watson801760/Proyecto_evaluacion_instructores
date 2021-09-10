<%-- 
    Document   : Consultar_Funcionario
    Created on : 28-ago-2021, 22:28:45
    Author     : user
--%>

<%@page import="ModeloDAO.EvaluaDAO"%>
<%@page import="ModeloVO.EvaluaVO"%>
<%@page import="java.util.ArrayList"%>
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
        <h1>Instructor</h1>
     
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
                    ArrayList<FuncionarioVO>ListaFuncionario=funDAO.listar();
                    for (int i = 0; i < ListaFuncionario.size(); i++) {
                        
                        
                            funVO= ListaFuncionario.get(i);
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
                        
                    </tfoot>
                    
                    <tr>
                        <th class="text-center">Nombre</th>
                        <th class="text-center" >Apellido</th>
                        <th class="text-center" >Correo</th>
                        <th class="text-center" >numIdentidad</th>
                        <th class="text-center" >Evaluaciòn</th>
                        <th></th>    
                    </tr>
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
