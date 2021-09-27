<%-- Document : InicioDeSesion Created on : 22-jun-2021, 17:47:55 Author : Sofia Paola --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        <title>Tevalúo</title>
        <link href="Assets/CSS/Style_InicioDeSesion.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <form method="POST" action="Usuario">
            <div class="container">
                <img src="Assets/images/Tevaluo.png" alt=""/>                  
                <h1>Inicio De Sesión</h1>                    
                <div>
                    <input type="text" id="usuario" name="textUsuario" placeholder="Usuario" class="form-control" >  
                    
                    <input type="text" id="password" name="textContrasena" placeholder="Contraseña" class="form-control">
                    
                    <button class="btn-block btn-color" >Ingresar</button>
                    <input class="form-control" type="hidden" value="3" name="opcion">
                    
                    <a href="#">¿Olvido su contraseña?</a>
                    
                    <%if (request.getAttribute("mensajeError") == null) {%>
                    <div style="color:aqua;">${mensajeExito}</div>
                    <% } else if (request.getAttribute("mensajeExito") == null) {%>
                    <div style="color:red;">${mensajeError}</div>
                    <%}%>
                </div>                                                           
            </div>          
        </form>
    </body>
</html>