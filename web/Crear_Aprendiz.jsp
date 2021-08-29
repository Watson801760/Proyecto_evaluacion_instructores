<%-- 
    Document   : Crear_Aprendiz
    Created on : 28-ago-2021, 20:35:11
    Author     : user
--%>

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
        <h1>Registrar Aprendiz</h1>
        <form method="POST" action="Aprendiz">
            Nombre
            <input class="form-control" type="text" name="textNombre"><br>
            Apellido
            <input class="form-control" type="text" name="textApellido"><br>
            Correo
            <input class="form-control" type="text" name="textCorreo"><br>
            Numero de Idetidad
            <input class="form-control" type="text" name="textIdentidad"><br>
            
            <button class="btn btn-warning" >Registrar</button>
            <input class="form-control" type="hidden" value="1" name="opcion">
            
            <a class="btn btn-success" href="Consultar_Aprendiz.jsp">Volver</a>

        </form>
        <%if (request.getAttribute("mensajeError") == null) {%>
        <div style="color:aqua;">${mensajeExito}</div>
        <% } else if (request.getAttribute("mensajeExito") == null) {%>
        <div style="color:red;">${mensajeError}</div>
        <%}%>
        </div>
    </body>
</html>
