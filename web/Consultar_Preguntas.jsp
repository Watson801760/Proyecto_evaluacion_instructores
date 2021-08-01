<%-- 
    Document   : Consultar_Preguntas
    Created on : 01-ago-2021, 15:50:21
    Author     : user
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.PreguntasDAO"%>
<%@page import="ModeloVO.PreguntasVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Hello</h1>
     <form>
                <table border="2">
                    <tr>
                        <th>Pregunta</th>
                        
                    </tr>
                    <% 
                    PreguntasVO preVO = new PreguntasVO();
                    PreguntasDAO preDAO= new PreguntasDAO(preVO);
                    ArrayList<PreguntasVO>ListaPreguntas=preDAO.listar();
                    for (int i = 0; i < ListaPreguntas.size(); i++) {
                        
                            preVO= ListaPreguntas.get(i);
            
                    %>
                    
                    <tr>
                        
                        <td><%=preVO.getPregunta() %></td>
                        
                        
                    </tr>
                    <%}%>
                </table>
            </form>
    </center>
        
    </body>
</html>
