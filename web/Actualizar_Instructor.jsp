<%-- 
    Document   : Actualizar_Instructor
    Created on : 28/10/2021, 10:28:57 PM
    Author     : Sofia
--%>

<%@include file="Sesiones.jsp" %>
<%@page import="ModeloVO.FuncionarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" >
            <h1>Actualizar Instructor</h1>

            <%
                FuncionarioVO funVO = (FuncionarioVO) request.getAttribute("Instructor Consultado");
                if (funVO != null) {


            %>  


            <form method="POST" action="Funcionario">
                Nombre<br>
                <input class="form-control" type="text" name="sql" value="<%= funVO.getNombre()%>"><br>
                Apellido<br>
                <input class="form-control" type="text" name="textApellido" value="<%= funVO.getApellido()%>"><br> 
                Correo<br>
                <input class="form-control" type="text" name="textCorreo" value="<%= funVO.getCorreo()%>"><br>  
                NumeroIdentidad<br>
                <input class="form-control" type="text" name="textIdentidad" value="<%= funVO.getNumIdentidad()%>"><br>  
                <button class="btn btn-warning" >Actualizar</button>
                <input type="hidden" value="6" name="opcion">
                <input  type="hidden" name="id" value="<%= funVO.getIdFuncionario() %>"><br>
            </form>
                



            <% }%>       

            <%if (request.getAttribute("mensajeError") == null) {%>
            <div style="color:aqua;">${mensajeExito}</div>
            <% } else if (request.getAttribute("mensajeExito") == null) {%>
            <div style="color:red;">${mensajeError}</div>
            <%}%>
            
        </div>
    </body>
</html>
