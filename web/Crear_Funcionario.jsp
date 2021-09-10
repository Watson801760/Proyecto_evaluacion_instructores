<%-- 
    Document   : Crear_Funcionario
    Created on : 28-ago-2021, 22:37:12
    Author     : user
--%>

<%@page import="ModeloVO.CoordinacionVO"%>
<%@page import="ModeloDAO.CoordinacionDAO"%>
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
        <h1>Registrar Funcionario</h1>
        <form method="POST" action="Funcionario">
            Nombre
            <input class="form-control" type="text" name="textNombre"><br>
            Apellido
            <input class="form-control" type="text" name="textApellido"><br>
            Correo
            <input class="form-control" type="text" name="textCorreo"><br>
            Numero de Idetidad
            <input class="form-control" type="text" name="textIdentidad"><br>
            Coordinacion
             <select class="form-select" name="textCoFK">
                            <option>Seleccione...</option>
                            <%
                                CoordinacionDAO cooDAO = new CoordinacionDAO();
                                for (CoordinacionVO cooVO: cooDAO.listar() ) {
                            %>
                            <option value="<%=cooVO.getIdCoordinacion() %>"> <%=cooVO.getNombreCoordinacion() %></option>
                            <%
                                }
                            %>
            </select><br>
            <button class="btn btn-warning" >Registrar</button>
            <input class="form-control" type="hidden" value="1" name="opcion">
            
            <a class="btn btn-success" href="Consultar_Funcionario.jsp">Volver</a>

        </form>
        <%if (request.getAttribute("mensajeError") == null) {%>
        <div style="color:aqua;">${mensajeExito}</div>
        <% } else if (request.getAttribute("mensajeExito") == null) {%>
        <div style="color:red;">${mensajeError}</div>
        <%}%>
        </div>
    </body>
</html>
