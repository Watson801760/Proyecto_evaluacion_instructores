<%-- Document : InicioDeSesion Created on : 22-jun-2021, 17:47:55 Author : Sofia Paola --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Te Evaluo</title>
        <link href="Assets/CSS/Style_InicioDeSesion.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <form action="Usuario" method="POST">
            <div class="container">
                <div>
                    <div class="logo">
                        <img id="logo" src="https://i.imgur.com/PSXxjNY.png">
                    </div>
                    <h1>Inicio De Sesión</h1>                    
                    <div>
                        <input type="text" id="usuario" name="usuario" placeholder="Usuario" class="form-control">                        
                        <input type="password" id="password" name="password" placeholder="Password" class="form-control">
                        <input type="submit" value="Ingresar" class="btn-block btn-color"></input>
                        <a href="#">¿Olvido su contraseña?</a>                        
                    </div>                                                           
                </div>
            </div>
            <div class="container1">           
            </div> 
        </form>
    </body>
</html>