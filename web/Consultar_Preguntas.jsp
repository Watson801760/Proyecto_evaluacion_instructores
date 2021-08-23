<%-- 
    Document   : Consultar_Preguntas
    Created on : 01-ago-2021, 15:50:21
    Author     : user
--%>

<%@page import="ModeloDAO.ClasificacionDAO"%>
<%@page import="ModeloVO.ClasificacionVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.PreguntasDAO"%>
<%@page import="ModeloVO.PreguntasVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Assets/CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
        <h1>Preguntas</h1>
     
                <table class="table table-bordered">
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center" >Pregunta</th>
                        <th class="text-center" >Clasificacion</th>
                        <th></th>    
                        <th></th>   
                    </tr>
                    <% 
                    PreguntasVO preVO = new PreguntasVO();
                    PreguntasDAO preDAO= new PreguntasDAO(preVO);
                    ClasificacionVO claVO = new ClasificacionVO();
                    ClasificacionDAO claDAO= new ClasificacionDAO();
                    ArrayList<PreguntasVO>ListaPreguntas=preDAO.listar();
                    ArrayList<String> listaCla = new ArrayList<String>();
                    for (int i = 0; i < ListaPreguntas.size(); i++) {
                        
                            preVO= ListaPreguntas.get(i);
                            //listaCla.add(claDAO.consultarClasificacion(preVO.getIdClasificacionFK()).getNombreClasificacion());
                            
    
                            
            
                    %>
                    
                    <tr>
                        <td class="text-center" ><%=preVO.getIdPregunta() %></td>
                        <td class="text-center" ><%=preVO.getPregunta() %></td>
                        
                        <td class="text-center" ><%=preVO.getIdClasificacionFK() %></td>
                        <td class="text-center" >
                            <form method="POST" action="Preguntas">
                            <button class="btn btn-warning">Actualizar</button>
                            <input type="hidden" value="4" name="opcion">
                            <input type="hidden" value="<%=preVO.getIdPregunta()%>" name="textId">
                            </form>
                            
                        </td>
                        <td class="text-center" >
                            <form method="POST" action="Preguntas">
                            <button class="btn btn-warning">Borrar</button>
                            <input type="hidden" value="2" name="opcion">
                            <input type="hidden" value="<%=preVO.getIdPregunta()%>" name="textId">
                            </form>
                            
                        </td>
                    </tr>
                    <%}%>
                </table>
         
                <a class="btn btn-success" href="MenuAdministrador.jsp">Volver</a>
                <a class="btn btn-success" href="Crear_Preguntas.jsp">Registrar</a>
        </div>
               
    </body>
</html>
