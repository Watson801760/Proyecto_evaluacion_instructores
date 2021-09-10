10<%-- 
    Document   : Crear_Programacion
    Created on : 09-sep-2021, 22:33:22
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Programacion</title>
        <link href="Assets/CSS/bootstrap.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container" >
        <h1>Crear Programacion</h1>
        <form method="POST" action="Programacion">
            Fecha Inicio
            <input class="form-control" type="Date" name="textFechaInicio"><br>
            Fecha Fin
            <input class="form-control" type="Date" name="textFechaFin"><br>
            Codigo
            <input class="form-control" type="text" name="textCodigo"><br>
            Semestre
            <input class="form-control" type="text" name="textSemestre"><br>
            
            <button class="btn btn-warning" >Registrar</button>
            <input class="form-control" type="hidden" value="1" name="opcion">
            
            <a class="btn btn-success" href="Consultar_Programacion.jsp">Volver</a>

        </form>
        <%if (request.getAttribute("mensajeError") == null) {%>
        <div style="color:aqua;">${mensajeExito}</div>
        <% } else if (request.getAttribute("mensajeExito") == null) {%>
        <div style="color:red;">${mensajeError}</div>
        <%}%>
        </div>
    </body>
</html>
