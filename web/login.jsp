<%-- 
    Document   : login
    Created on : 26-sep-2021, 15:25:59
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Tevalúo</title>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>
        <link rel="stylesheet" href="Assets/css/login.css" type="text/css">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
    </head>
    <body class="back-body">

        <!-- partial:index.partial.html -->
        <div class="login-wrap">
            <div class="login-html">
                <h1 class="text-center" ><img src="Assets/images/Tevaluo.png"></h1><br><br>
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">iniciar sesión</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Registrarse</label>
                <div class="login-form">
                    <div class="sign-in-htm">
                        <form method="POST" action="Usuario">
                            <div class="group">
                                <br><br>
                                <label for="user" class="label">Usuario</label>
                                <input id="user" name="textUsuario" type="text" class="input">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Contraseña</label>
                                <input id="pass" name="textContrasena" type="password" class="input" data-type="password">
                            </div>
                            <div class="group">
                                <input id="check" type="checkbox" class="check" checked>
                                <label for="check"><span class="icon"></span> Mantenerme registrado</label>
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Iniciar Sesiòn">
                                <input class="form-control" type="hidden" value="3" name="opcion">
                            </div>
                            <br> <br><br>
                            <div class="foot-lnk">
                                <a href="#forgot">¿olvido la contraseña?</a>
                            </div>
                            <%if (request.getAttribute("mensajeError") == null) {%>
                            <div style="color:aqua;">${mensajeExito}</div>
                            <% } else if (request.getAttribute("mensajeExito") == null) {%>
                            <div style="color:red;">${mensajeError}</div>
                            <%}%>
                        </form>
                    </div>
                    <div class="sign-up-htm">
                        <div class="group">
                            <br><br>
                            <label for="user" class="label">Usuario</label>
                            <input id="user" type="text" class="input">
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Contraseña</label>
                            <input id="pass" type="password" class="input" data-type="password">
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Repetir la Contraseña</label>
                            <input id="pass" type="password" class="input" data-type="password">
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Correo Electronico</label>
                            <input id="pass" type="text" class="input">
                        </div>
                        <div class="group">
                            <input type="submit" class="button" value="Registrarse">
                        </div>
                        <div class="hr"></div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>