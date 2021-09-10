<%-- 
    Document   : Actualizar_Aprendiz
    Created on : 28-ago-2021, 20:51:35
    Author     : user
--%>

<%@page import="ModeloVO.AprendizVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tevalúo</title>
        <link href="Assets/CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container" >
            <h1>Actualizar Aprendiz</h1>

            <%
                AprendizVO aprenVO = (AprendizVO) request.getAttribute("Aprendiz Consultado");
                if (aprenVO != null) {


            %>  


            <form method="POST" action="Aprendiz">
                Nombre<br>
                <input class="form-control" type="text" name="sql" value="<%= aprenVO.getNombre()%>"><br>
                Apellido<br>
                <input class="form-control" type="text" name="textApellido" value="<%= aprenVO.getApellido()%>"><br> 
                Correo<br>
                <input class="form-control" type="text" name="textCorreo" value="<%= aprenVO.getCorreo()%>"><br>  
                NumeroIdentidad<br>
                <input class="form-control" type="text" name="textIdentidad" value="<%= aprenVO.getNumIdentidad()%>"><br>  
                <button class="btn btn-warning" >Actualizar</button>
                <input type="hidden" value="3" name="opcion">
                <input  type="hidden" name="id" value="<%= aprenVO.getIdAprendiz()%>"><br>
            </form>
                



            <% }%>       

            <%if (request.getAttribute("mensajeError") == null) {%>
            <div style="color:aqua;">${mensajeExito}</div>
            <% } else if (request.getAttribute("mensajeExito") == null) {%>
            <div style="color:red;">${mensajeError}</div>
            <%}%>



            <a class="btn btn-success" href="Consultar_Aprendiz.jsp">Volver</a>
        </div>
    </body>
</html>
