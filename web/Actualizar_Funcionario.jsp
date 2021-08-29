<%-- 
    Document   : Actualizar_Funcionario
    Created on : 28-ago-2021, 22:40:59
    Author     : user
--%>

<%@page import="ModeloVO.FuncionarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" >
            <h1>Actualizar Funcionario</h1>

            <%
                FuncionarioVO funVO = (FuncionarioVO) request.getAttribute("Funcionario Consultado");
                if (funVO != null) {


            %>  


            <form method="POST" action="Funcionario">
                Nombre<br>
                <input class="form-control" type="text" name="sql" value="<%= funVO.getNombre()%>"><br>
                
                Apellido<br>
                <input class="form-control" type="text" name="textApellido" value="<%= funVO.getApellido()%>"><br> 
                Correo<br>
                <input class="form-control" type="text" name="textCorreo" value="<%= funVO.getCorreo()%>"><br>  
                NumeroIdentidad<br>
                <input class="form-control" type="text" name="textIdentidad" value="<%= funVO.getNumIdentidad()%>"><br>  
                <button class="btn btn-warning" >Actualizar</button>

                <input type="hidden" value="3" name="opcion">
                <input type="hidden" name="id" value="<%= funVO.getIdFuncionario() %>"><br>
            </form>



            <% }%>       

            <%if (request.getAttribute("mensajeError") == null) {%>
            <div style="color:aqua;">${mensajeExito}</div>
            <% } else if (request.getAttribute("mensajeExito") == null) {%>
            <div style="color:red;">${mensajeError}</div>
            <%}%>



            <a class="btn btn-success" href="Consultar_Funcionario.jsp">Volver</a>
        </div>
    </body>
</html>
