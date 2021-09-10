<%-- 
    Document   : Crear_Programa
    Created on : 10/09/2021, 07:19:53 AM
    Author     : Sofia
--%>

<%@page import="ModeloVO.NivelVO"%>
<%@page import="ModeloDAO.NivelDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Programa</title>
        <link href="Assets/CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container" >
            <h1>Registrar Programa</h1>
            <form method="POST" action="Programa">
                Programa
                <input class="form-control" type="text" name="textPrograma"><br>
                Nivel
                <select class="form-select" name="textNivel">
                    <option>Seleccione...</option>
                    <%
                        NivelDAO nilDAO = new NivelDAO();
                        for (NivelVO nilVO : nilDAO.listar()) {
                    %>
                    <option value="<%=nilVO.getIdNivel()%>"> <%=nilVO.getNombreFormacion()%></option>
                    <%
                        }
                    %>
                </select><br>
                <button class="btn btn-warning" >Registrar</button>
                <input class="form-control" type="hidden" value="1" name="opcion">
                <a class="btn btn-success" href="Consultar_Programa.jsp">Volver</a>

            </form>
            <%if (request.getAttribute("mensajeError") == null) {%>
            <div style="color:aqua;">${mensajeExito}</div>
            <% } else if (request.getAttribute("mensajeExito") == null) {%>
            <div style="color:red;">${mensajeError}</div>
            <%}%>
        </div>
    </body>
</html>
