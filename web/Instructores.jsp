<%-- 
    Document   : Instructores.jsp
    Created on : 05-sep-2021, 20:56:47
    Author     : Usuario
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.FuncionarioDAO"%>
<%@page import="ModeloVO.FuncionarioVO"%>
<%@page import="ModeloVO.FuncionarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Assets/CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
                    <% 
                    FuncionarioVO funVO = new FuncionarioVO();
                    FuncionarioDAO funDAO= new FuncionarioDAO(funVO);
        
                    ArrayList<FuncionarioVO>ListaFuncionario=funDAO.listar();
                    for (int i = 0; i < ListaFuncionario.size(); i++) {
                        
                            funVO= ListaFuncionario.get(i);
            
                    %>
        <div class="container m-4">
            <div class="row">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h2><%=funVO.getNombre()%></h2>
                        </div>
                        <div class="card-body">
                            <img src="<%=funVO.getUrlFoto()%>" width="200" height="180">   
                        </div>
                        <div class="card-footer">
                            <div>
                                <a class="btn btn-danger">Evaluar</a>
                            </div> 

                        </div>        
                    </div>
                </div>
            </div>
        </div>
                    <%}%>
    </body>
</html>
