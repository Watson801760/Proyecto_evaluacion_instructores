<%-- 
    Document   : MenuAdministrador
    Created on : 22-jun-2021, 21:06:51
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Assets/CSS/Style_Menu_Ad.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav>
            <ul>
                <a href="">
                    <li>
                        <div class="barra"></div>
                        <p class="menu">Instructores</p>
                    </li>
                </a>
                <a href="">
                    <li>
                        <div class="barra"></div>
                        <p class="menu">Aprendices</p>
                    </li>
                </a>
                <a href="Consultar_Preguntas.jsp">
                    <li>
                        <div class="barra"></div>
                        <p class="menu">Crear Preguntas</p>
                    </li>
                </a>
            </ul>
        </nav>
    </body>
</html>
