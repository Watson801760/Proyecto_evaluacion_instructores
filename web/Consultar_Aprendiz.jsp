<%-- 
    Document   : Consultar_Aprendiz
    Created on : 28-ago-2021, 20:25:35
    Author     : user
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.AprendizDAO"%>
<%@page import="ModeloVO.AprendizVO"%>
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
                    AprendizVO aprenVO = new AprendizVO();
                    AprendizDAO aprenDAO= new AprendizDAO(aprenVO);
        
                    ArrayList<AprendizVO>ListaAprendiz=aprenDAO.listar();
                    for (int i = 0; i < ListaAprendiz.size(); i++) {
                        
                            aprenVO= ListaAprendiz.get(i);
            
                    %>
                    
                    <tr>
                        <td class="text-center" ><%=aprenVO.getNombre() %></td>
                        <td class="text-center" ><%=aprenVO.getApellido() %></td>
                        <td class="text-center" ><%=aprenVO.getCorreo() %></td>
                        <td class="text-center" ><%=aprenVO.getNumIdentidad() %></td>
                        <td class="text-center" >
                            <form method="POST" action="Aprendiz">
                            <button class="btn btn-warning">Actualizar</button>
                            <input type="hidden" value="4" name="opcion">
                            <input type="hidden" value="<%=aprenVO.getIdAprendiz() %>" name="textId">
                            </form>
                        </td>
                    </tr>
                    <%}%>
                </table>
         
                <a class="btn btn-success" href="MenuAdministrador.jsp">Volver</a>
                <a class="btn btn-success" href="Crear_Aprendiz.jsp">Registrar</a>
        </div>
    </body>
</html>
