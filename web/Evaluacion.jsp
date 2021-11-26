<%-- 
    Document   : Evaluacion
    Created on : 24-nov-2021, 21:41:28
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
         <%
            PreguntasVO preVO = (PreguntasVO) request.getAttribute("Ficha Consultada");
            
           
                if (preVO != null) {
                    
                    PreguntasDAO funDAO= new PreguntasDAO(preVO);
        
                    ArrayList<FuncionarioVO>ListaFuncionario=funDAO.listarParaAprendiz(ficVO.getIdFicha());
                    for (int i = 0; i < ListaFuncionario.size(); i++) {
                        
                        
                        preVO= ListaFuncionario.get(i);  
            
                    %>
    </body>
</html>
