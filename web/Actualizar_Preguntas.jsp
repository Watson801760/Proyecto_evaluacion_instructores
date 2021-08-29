<%-- 
    Document   : Actualizar_Preguntas
    Created on : 01-ago-2021, 18:50:52
    Author     : user
--%>

<%@page import="ModeloVO.ClasificacionVO"%>
<%@page import="ModeloDAO.ClasificacionDAO"%>
<%@page import="ModeloVO.PreguntasVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Preguntas</title>
        <link href="Assets/CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container" >
          <h1>Actualizar Preguntas</h1>
        
        <% 
         PreguntasVO preVO = (PreguntasVO)request.getAttribute("preguntaConsultada");
         if (preVO != null) {
                 
             
        %>  
  

      <form method="POST" action="Preguntas">
          Pregunta<br>
          <input class="form-control" type="text" name="sql" value="<%= preVO.getPregunta()%>"><br>
          <input class="form-control" type="hidden" name="id" value="<%= preVO.getIdPregunta() %>"><br>
          <select class="form-select" type="text" name="textClasificacion" >
               <option  value="<%= preVO.getIdClasificacionFK()%>"></option>
                            <%
                                ClasificacionDAO claDAO = new ClasificacionDAO();
                                for (ClasificacionVO claVO: claDAO.listar() ) {
                            %>
                            <option value="<%=claVO.getIdClasificacion()%>"> <%=claVO.getNombreClasificacion() %></option>
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

     
    
        <a class="btn btn-success" href="Consultar_Preguntas.jsp">Volver</a>
    </div>
      
    </body>
</html>
