<%-- 
    Document   : Evaluacion
    Created on : 24-nov-2021, 21:41:28
    Author     : user
--%>

<%@page import="ModeloVO.AprendizVO"%>
<%@page import="ModeloVO.FuncionarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.PreguntasDAO"%>
<%@page import="ModeloVO.PreguntasVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="Assets/img/logo/logo.png" rel="icon">

        <link href="Assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="Assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="Assets/css/ruang-admin.min.css" rel="stylesheet">
        <link href="Assets/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    </head>
    <body>
         <%
            FuncionarioVO funVO = (FuncionarioVO) request.getAttribute("Funcionario Consultado");
            AprendizVO aprenVO = (AprendizVO) request.getAttribute("Aprendiz Consultado");
            if (funVO != null && aprenVO != null) {
             
             PreguntasVO preVO = new PreguntasVO();
            
           
                
                    
                    PreguntasDAO preDAO= new PreguntasDAO(preVO);
        
                    ArrayList<PreguntasVO>ListaFuncionario=preDAO.listar();
                    for (int i = 0; i < ListaFuncionario.size(); i++) {
                        
                        
                        preVO= ListaFuncionario.get(i);  
            
                    %>
        <form method="POST" action="Evaluacion">  
        <div class="container-fluid">           
            <p><%=preVO.getPregunta()%></p>
                <div id="drink-holder">
                    <select size="6" class="display:inline-block" >
                    <option value="1">Siempre</option>
                    <option value="2">Casi siempre</option>
                    <option value="3">Nunca</option>
                    </select>
                </div>
        </div>
        <%}%>
        
        <%}%>
        </form>
    <script src="Assets/vendor/jquery/jquery.min.js"></script>
    <script src="Assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="Assets/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="Assets/js/ruang-admin.min.js"></script>
    <!-- Page level plugins -->
    <script src="Assets/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="Assets/vendor/datatables/dataTables.bootstrap4.min.js"></script>      
    </body>
</html>
