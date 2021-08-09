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
    <link href="Assets/CSS/Style_InicioDeSesion.css" rel="stylesheet" type="text/css" />
</head>
<body>    
    <div class="wrapper1">
        <img src="Assets/Img/Sena.png">
        <h1>Inicio de Sesión</h1>
        <form action="" method="POST" style="margin-top:10%;">
            <input type="text" name="usuario" placeholder="Número De Documento" required>
            <input type="password" name="password" placeholder="Contraseña" required>
            <input type="submit" value="Ingresar">
        </form>
    </div>
</body>
</html>
