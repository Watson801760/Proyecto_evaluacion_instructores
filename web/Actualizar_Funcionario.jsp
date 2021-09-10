<%-- 
    Document   : Actualizar_Funcionario
    Created on : 28-ago-2021, 22:40:59
    Author     : user
--%>

<%@page import="ModeloVO.CoordinacionVO"%>
<%@page import="ModeloDAO.CoordinacionDAO"%>
<%@page import="ModeloDAO.CoordinacionDAO"%>
<%@page import="ModeloVO.FuncionarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Assets/CSS/bootstrap.css" rel="stylesheet" type="text/css"/>

        <title>Tevalúo</title>
        <link href="Assets/CSS/Style_Funcionario.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <nav>
            <ul>
                <a href="#openModal">Lanzar el modal</a>

                <div id="openModal" class="modalDialog">
                    <div>
                        <a href="#close" title="Close" class="close">X</a>
                        <h2>Mi modal</h2>
                        <p>Este es un ejemplo de modal, creado gracias al poder de CSS3.</p>
                        <p>Puedes hacer un montón de cosas aquí, como alertas o incluso crear un formulario de registro aquí mismo.</p>
                    </div>
                </div>
                <form method="POST" action="Funcionario">

                    <%
                        FuncionarioVO funVO = (FuncionarioVO) request.getAttribute("");
                        if (funVO != null) {
                    %>  

                    <h1>Actualizar Funcionario</h1>

                    Nombre<br>
                    <input type="text" placeholder="textNombre" class="form-control" value="<%= funVO.getNombre()%>"><br>
                    Apellido<br>
                    <input class="form-control" type="text" name="textApellido" value="<%= funVO.getApellido()%>"><br> 
                    Correo<br>
                    <input class="form-control" type="text" name="textCorreo" value="<%= funVO.getCorreo()%>"><br>  
                    NumeroIdentidad<br>
                    <input class="form-control" type="text" name="textIdentidad" value="<%= funVO.getNumIdentidad()%>"><br>  
                    <button class="btn btn-warning">Actualizar</button>


            <form method="POST" action="Funcionario">
                Nombre<br>
                <input class="form-control" type="text" name="sql" value="<%= funVO.getNombre()%>"><br>
                
                Apellido<br>
                <input class="form-control" type="text" name="textApellido" value="<%= funVO.getApellido()%>"><br> 
                Correo<br>
                <input class="form-control" type="text" name="textCorreo" value="<%= funVO.getCorreo()%>"><br>  
                NumeroIdentidad<br>
                <input class="form-control" type="text" name="textIdentidad" value="<%= funVO.getNumIdentidad()%>"><br> 
                Coordinacion
                <select class="form-select"  name="textCoFK">
                            <option><%=funVO.getIdCoordinacionFK() %></option>
                            <%
                                CoordinacionDAO cooDAO = new CoordinacionDAO();
                                for (CoordinacionVO cooVO: cooDAO.listar() ) {
                            %>
                            <option value="<%=cooVO.getIdCoordinacion() %>"> <%=cooVO.getNombreCoordinacion() %></option>
                            <%
                                }
                            %>
               </select><br>
                <button class="btn btn-warning" >Actualizar</button>
=======
                    <input type="hidden" value="3" name="opcion">
                    <input type="hidden" name="id" value="<%= funVO.getIdFuncionario()%>"><br>
>>>>>>> origin/master

                </form>
                </div>                
                </div>

            </ul>
        </nav>

        <% }%>       

        <%if (request.getAttribute("mensajeError") == null) {%>
        <div style="color:aqua;">${mensajeExito}</div>
        <% } else if (request.getAttribute("mensajeExito") == null) {%>
        <div style="color:red;">${mensajeError}</div>
        <%}%>
        <a class="btn btn-success" href="Consultar_Funcionario.jsp">Volver</a>
    </body>
</html>
