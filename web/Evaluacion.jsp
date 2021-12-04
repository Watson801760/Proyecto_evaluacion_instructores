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
             
             if (buscarSesion.getAttribute("datosUsuario") == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);

            } else {

                UsuarioVO usuVO =(UsuarioVO) buscarSesion.getAttribute("datosUsuario");
                usuario = usuVO.getNombreUsuario();
            }
            FuncionarioVO funVO = (FuncionarioVO) request.getAttribute("Funcionario Consultado");
            AprendizVO aprenVO = (AprendizVO) request.getAttribute("Aprendiz Consultado");
            if (funVO != null && aprenVO != null) {
             
             PreguntasVO preVO = new PreguntasVO();
            
           
                
                    
                    PreguntasDAO preDAO= new PreguntasDAO(preVO);
        
                    ArrayList<PreguntasVO>ListaFuncionario=preDAO.listar();
                    for (int i = 0; i < ListaFuncionario.size(); i++) {
                        
                        
                        preVO= ListaFuncionario.get(i);  
            
                    %>
        <div class="container-fluid"> 
         <form method="POST" action="Evaluacion">  
                  
            <p><%=preVO.getPregunta()%></p>
                <div id="drink-holder">
                    <select id="Respuesta1" size="6" class="" name="respuesta" >
                    <option value="3">Siempre</option>
                    <option value="2">Casi siempre</option>
                    <option value="1">Nunca</option>
                    </select>
                </div>
                <div>
                    <button class="btn btn-warning">Enviar</button>
                    <input type="hidden" value="3" name="opcion">
                    <input type="hidden" value="<%=funVO.getIdFuncionario()%>" name="textFuncionarioFK">
                    <input type="hidden" value="<%=aprenVO.getIdAprendiz()%>" name="textAprendizFK">
                    <input type="hidden" value="<%=preVO.getIdPregunta()%>" name="textPreguntaFK">
                    
                </div><br><br>
                

        <%}%>
        
        <%}%>
        </form>
        <form method="POST" action="Evaluacion"> 
        <button class="btn btn-warning">Volver</button>
        <input type="hidden" value="<%=usuario%>" name="sql">
        <input type="hidden" value="4" name="opcion">
        </form>
      </div>  
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
