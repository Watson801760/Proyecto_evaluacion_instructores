<%-- 
    Document   : Crear_ficha
    Created on : 10-sep-2021, 2:17:30
    Author     : Usuario
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
        <h1>Registrar Ficha</h1>
        <form method="POST" action="Ficha">
            Numero de Ficha
            <input class="form-control" type="text" name="textnumfi"><br>
            Fecha de inicio electiva
            <input class="form-control" type="text" name="textFechaini"><br>
            Fecha de Finalizacion electiva
            <input class="form-control" type="text" name="textFechafn"><br>
            Fecha de inicio productiva
            <input class="form-control" type="text" name="textFechainip"><br>
            Fecha de Finalizacion productiva
            <input class="form-control" type="text" name="textFechafnp"><br>
            Estado
            <input class="form-control" type="text" name="estado"><br>
            
            <button class="btn btn-warning" >Registrar</button>
            <input class="form-control" type="hidden" value="1" name="opcion">
            
            <a class="btn btn-success" href="Consultar_Ficha.jsp">Volver</a>

        </form>
        <%if (request.getAttribute("mensajeError") == null) {%>
        <div style="color:aqua;">${mensajeExito}</div>
        <% } else if (request.getAttribute("mensajeExito") == null) {%>
        <div style="color:red;">${mensajeError}</div>
        <%}%>
        </div>
    </body>
</html>
