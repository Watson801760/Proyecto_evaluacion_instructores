 
    Document   : Actualizar_Preguntas
    Created on : 01-ago-2021, 18:50:52
    Author     : user
--%>

<%@page import="ModeloVO.FuncionarioVO"%>
<%@page import="ModeloVO.ClasificacionVO"%>
<%@page import="ModeloDAO.ClasificacionDAO"%>
<%@page import="ModeloVO.PreguntasVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>


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
                <form method="POST" action="Funcionario"  enctype="multipart/form-data">
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
