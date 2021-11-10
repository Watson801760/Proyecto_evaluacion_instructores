<%-- 
    Document   : Instructores.jsp
    Created on : 05-sep-2021, 20:56:47
    Author     : Usuario
--%>

<%@page import="ModeloVO.FichaVO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.FuncionarioDAO"%>
<%@page import="ModeloVO.FuncionarioVO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@include file="Sesiones.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>

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

        <%           FichaVO ficVO = (FichaVO) request.getAttribute("Ficha Consultada");

            FuncionarioVO funVO = new FuncionarioVO();
            if (funVO != null) {

                FuncionarioDAO funDAO = new FuncionarioDAO(funVO);

                ArrayList<FuncionarioVO> ListaFuncionario = funDAO.listarParaAprendiz(ficVO.getIdFicha());
                for (int i = 0; i < ListaFuncionario.size(); i++) {

                    funVO = ListaFuncionario.get(i);

        %>
        <div class="container m-4">
            <div class="row">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h2><%=funVO.getNombre()%> <%=funVO.getApellido()%></h2>
                        </div>
                        <div class="card-body">
                            <img src="<%=funVO.getApellido()%>" width="200" height="180">   
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
        <%}%>
        <!-- Modal Logout -->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelLogout"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabelLogout">Ohh No!</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Estas seguro que quieres cerrar sesiòn?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Cancelar</button>
                        <a href="Sesiones" class="btn btn-primary">Salir</a>
                    </div>
                </div>
            </div>
        </div>            
        <script src="Assets/vendor/jquery/jquery.min.js"></script>
        <script src="Assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="Assets/vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="Assets/js/ruang-admin.min.js"></script>
        <!-- Page level plugins -->
        <script src="Assets/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="Assets/vendor/datatables/dataTables.bootstrap4.min.js"></script>            
    </body>
</html>
