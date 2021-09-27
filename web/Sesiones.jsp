<%-- 
    Document   : Sesiones
    Created on : 18-sep-2021, 17:18:34
    Author     : user
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
    response.setDateHeader("Expires",0);
%>
<%
 HttpSession buscarSesion = (HttpSession)request.getSession();
  String usuario="";
  if (buscarSesion.getAttribute("datosUsuario")== null) {
      request.getRequestDispatcher("InicioDeSesion.jsp").forward(request, response);
          
      }else{
      
      UsuarioVO usuVO = (UsuarioVO)buscarSesion.getAttribute("datosUsuario");
      usuario = usuVO.getNombreUsuario();
  }
%>
  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesiones</title>
    </head>
    <body>
        <h1>Bienvenido:<%=usuario %></h1>
        <form method="POST" action="Sesiones">
            <input type="submit" value="cerrar Sesion">
        </form>
    </body>
</html>
