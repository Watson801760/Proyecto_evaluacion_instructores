<%-- 
    Document   : Crear_Preguntas
    Created on : 01-ago-2021, 13:16:16
    Author     : user
--%>

<%@page import="ModeloVO.ClasificacionVO"%>
<%@page import="ModeloDAO.ClasificacionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Assets/CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container" >
        <h1>Registrar Preguntas</h1>
        <form method="POST" action="Preguntas">
            Preguntas
            <input class="form-control" type="text" name="textPreguntas"><br>
            Clasificacion
            <select class="form-select" name="textClasificacion">
                            <option>Seleccione...</option>
                            <%
                                ClasificacionDAO claDAO = new ClasificacionDAO();
                                for (ClasificacionVO claVO: claDAO.listar() ) {
                            %>
                            <option value="<%=claVO.getIdClasificacion()%>"> <%=claVO.getNombreClasificacion() %></option>
                            <%
                                }
                            %>
            </select><br>
            <button class="btn btn-warning" >Registrar</button>
            <input class="form-control" type="hidden" value="1" name="opcion">
            <a class="btn btn-success" href="Consultar_Preguntas.jsp">Volver</a>

        </form>

        <%if (request.getAttribute("mensajeError") == null) {%>
        <div style="color:aqua;">${mensajeExito}</div>
        <% } else if (request.getAttribute("mensajeExito") == null) {%>
        <div style="color:red;">${mensajeError}</div>
        <%}%>
       </div>
    </body>
</html>
