<%-- 
    Document   : Actualizar_Ficha
    Created on : 10-sep-2021, 7:10:39
    Author     : Usuario
--%>

<%@page import="ModeloVO.FichaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" >
            <h1>Actualizar Ficha</h1>

            <%
                FichaVO fichVO = (FichaVO) request.getAttribute("Ficha Consultada");
                if (fichVO != null) {


            %>  


            <form method="POST" action="Ficha">
                Numero de ficha<br>
                <input class="form-control" type="text" name="sql" value="<%= fichVO.getNumeroFicha()%>"><br>
                
                Fecha de inicio electiva<br>
                <input class="form-control" type="text" name="textApellido" value="<%= fichVO.getFechaInicioElectiva()%>"><br> 
                Fecha de Finalizacion electiva<br>
                <input class="form-control" type="text" name="textCorreo" value="<%= fichVO.getFechaFinElectiva()%>"><br>  
                Fecha de inicio productiva<br>
                <input class="form-control" type="text" name="textIdentidad" value="<%= fichVO.getFechaInicioProductiva()%>"><br>  
                Fecha de finalizacion productiva<br>
                <input class="form-control" type="text" name="textIdentidad" value="<%= fichVO.getFechaFinElectiva()%>"><br>
                Estado<br>
                <input class="form-control" type="text" name="textIdentidad" value="<%= fichVO.getEstado()%>"><br>
                
                <button class="btn btn-warning" >Actualizar</button>

                <input type="hidden" value="3" name="opcion">
                <input type="hidden" name="id" value="<%= fichVO.getIdFicha() %>"><br>
            </form>



            <% }%>       

            <%if (request.getAttribute("mensajeError") == null) {%>
            <div style="color:aqua;">${mensajeExito}</div>
            <% } else if (request.getAttribute("mensajeExito") == null) {%>
            <div style="color:red;">${mensajeError}</div>
            <%}%>



            <a class="btn btn-success" href="Consultar_Ficha.jsp">Volver</a>
        </div>
    </body>
</html>
