<%-- 
    Document   : Consultar_Funcionario
    Created on : 28-ago-2021, 22:28:45
    Author     : user
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.FuncionarioDAO"%>
<%@page import="ModeloVO.FuncionarioVO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Assets/CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
        <h1>Aprendices</h1>
     
                <table class="table table-bordered">
                    <tr>
                        <th class="text-center">Nombre</th>
                        <th class="text-center" >Apellido</th>
                        <th class="text-center" >Correo</th>
                        <th class="text-center" >numIdentidad</th>
                        <th></th>    
                    </tr>
                    <% 
                    FuncionarioVO funVO = new FuncionarioVO();
                    FuncionarioDAO funDAO= new FuncionarioDAO(funVO);
        
                    ArrayList<FuncionarioVO>ListaFuncionario=funDAO.listar();
                    for (int i = 0; i < ListaFuncionario.size(); i++) {
                        
                            funVO= ListaFuncionario.get(i);
            
                    %>
                    
                    <tr>
                        <td class="text-center" ><%=funVO.getNombre() %></td>
                        <td class="text-center" ><%=funVO.getApellido() %></td>
                        <td class="text-center" ><%=funVO.getCorreo() %></td>
                        <td class="text-center" ><%=funVO.getNumIdentidad() %></td>
                        <td class="text-center" >
                            <form method="POST" action="Funcionario">
                            <button class="btn btn-warning">Actualizar</button>
                            <input type="hidden" value="4" name="opcion">
                            <input type="hidden" value="<%=funVO.getIdFuncionario() %>" name="textId">
                            </form>
                        </td>
                    </tr>
                    <%}%>
                </table>
         
                <a class="btn btn-success" href="MenuAdministrador.jsp">Volver</a>
                <a class="btn btn-success" href="Crear_Funcionario.jsp">Registrar</a>
        </div>
    </body>
</html>
