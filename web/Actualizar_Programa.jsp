<%-- 
    Document   : Actualizar_Programa
    Created on : 10/09/2021, 07:20:38 AM
    Author     : Sofia
--%>


<%@page import="ModeloVO.NivelVO"%>
<%@page import="ModeloDAO.NivelDAO"%>
<%@page import="ModeloVO.ProgramaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Programa</title>
        <link href="Assets/CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container" >
          <h1>Actualizar Programa</h1>
            <%
                ProgramaVO proVO = (ProgramaVO) request.getAttribute("programaConsultado");
                if (proVO != null) {


            %> 
            <form method="POST" action="Programa">
                Pregunta<br>
                <input class="form-control" type="hidden" name="id" value="<%= proVO.getIdPrograma()%>"><br>
                <input class="form-control" type="text" name="sql" value="<%= proVO.getNombrePrograma()%>"><br>                
                <select class="form-select" type="text" name="textNivel" >
                    <option  value="<%= proVO.getIdNivelFK()%>"></option>
                    <%
                        NivelDAO nilDAO = new NivelDAO();
                        for (NivelVO nilVO : nilDAO.listar()) {
                    %>
                    <option value="<%=nilVO.getIdNivel()%>"><%=nilVO.getNombreFormacion()%></option>
                    <%
                        }
                    %>
                </select>    
                <button class="btn btn-warning" >Actualizar</button>
                <input type="hidden" value="3" name="opcion">

            </form>
            <% }%>       

            <%if (request.getAttribute("mensajeError") == null) {%>
            <div style="color:aqua;">${mensajeExito}</div>
            <% } else if (request.getAttribute("mensajeExito") == null) {%>
            <div style="color:red;">${mensajeError}</div>
            <%}%>



            <a class="btn btn-success" href="Consultar_Programa.jsp">Volver</a>

        </div>
    </body>
</html>
