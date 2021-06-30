<%-- 
    Document   : InicioDeSesion
    Created on : 22-jun-2021, 17:47:55
    Author     : Sofia Paola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Te Evaluo</title>
        <link href="Assets/CSS/Style_InicioDeSecion" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">
            <h1>Inicio de Sesión</h1>
            <form action="" method="POST" style="margin-top:10%;">
                <select name="tipodedocumento" placeholder="Tipo De Documento">
                    <option value="0">Tarjeta De Identidad</option>
                    <option value="1">Cédula De Ciudadanía</option>
                    <option value="2">Cédula De Extranjería</option>
                </select>         
                <input type="text" name="numerodedocumento" placeholder="Numero De Documento" required>
                <input type="password" name="password" placeholder="Contraseña" required>
                <input type="submit" value="Ingresar">
            </form>
        </div>
    </body>
</html>
