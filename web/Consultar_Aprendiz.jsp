<%-- 
    Document   : Consultar_Aprendiz
    Created on : 28-ago-2021, 20:25:35
    Author     : user
--%>

<%@page import="ModeloDAO.AprendizDAO"%>
<%@page import="ModeloVO.AprendizVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.EvaluaDAO"%>
<%@page import="ModeloVO.EvaluaVO"%>
<%@page import="ModeloDAO.FuncionarioDAO"%>
<%@page import="ModeloVO.FuncionarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="Assets/img/logo/logo.png" rel="icon">
  <title>RuangAdmin - DataTables</title>
  <link href="Assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="Assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="Assets/css/ruang-admin.min.css" rel="stylesheet">
  <link href="Assets/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>

<body id="page-top">
  <div id="wrapper">
    <!-- Sidebar -->
    <ul class="navbar-nav sidebar sidebar-light accordion" id="accordionSidebar">
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon">
          <img src="Assets/img/Tevaluo.png">
        </div>
      </a>
      <hr class="sidebar-divider my-0">
      <li class="nav-item">
        <a class="nav-link" href="MenuAdministrador.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Tablero</span></a>
      </li>
      <hr class="sidebar-divider">
     
       <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTable" aria-expanded="true"
          aria-controls="collapseTable">
          <i class="fas fa-fw fa-table"></i>
          <span>Tablas</span>
        </a>
        <div id="collapseTable" class="collapse" aria-labelledby="headingTable" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Tablas</h6>
            <a class="collapse-item" href="Consultar_Aprendiz.jsp">Aprendices</a>
            <a class="collapse-item" href="Consultar_Funcionario.jsp">Funcionarios</a>
            <a class="collapse-item" href="Consultar_Preguntas.jsp">Crear Preguntas</a>
          </div>
        </div>
      </li>
     
      <hr class="sidebar-divider">
      <li class="nav-item">
        <a class="nav-link" href="Cargar_Informacion.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Cargar Archivo</span></a>
      </li>
   
    </ul>
    <!-- Sidebar -->
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <!-- TopBar -->
        
        <!-- Topbar -->
        <!-- Container Fluid-->
        <div class="container-fluid" id="container-wrapper">
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Aprendices</h1>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="./">Home</a></li>
              <li class="breadcrumb-item">Tables</li>
              <li class="breadcrumb-item active" aria-current="page">DataTables</li>
            </ol>
          </div>

          <!-- Row -->
          <div class="row">
            <!-- Datatables -->
            
            <!-- DataTable with Hover -->
            <div class="col-lg-12">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Aprendices</h6>
                </div>
                  <form  class="modal-body" method="POST" action="Aprendiz">
                  <div class="custom-file">
                        
                        <input type="file" name="sql" >
                        <input type="submit" value="cargar"  name="sql">
                        
                        <input class="form-control" type="hidden" value="6" name="opcion">
                      </div>
                  </form>   
                <div class="table-responsive p-3">
                  <table class="table align-items-center table-flush table-hover" id="dataTable">
                    <thead class="thead-light">
                      <tr>
                        <th class="text-center">Nombre</th>
                        <th class="text-center" >Apellido</th>
                        <th class="text-center" >Correo</th>
                        <th class="text-center" >Tipo</th>
                        <th class="text-center" >numIdentidad</th>
                        <th class="text-center" >Evaluaciòn</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th class="text-center">Nombre</th>
                        <th class="text-center" >Tipo</th>
                        <th class="text-center" >Apellido</th>
                        <th class="text-center" >Correo</th>
                        <th class="text-center" >numIdentidad</th>
                        <th class="text-center" >Evaluaciòn</th>
                      </tr>
                    </tfoot>
                    <tbody>
                         <% 
                    AprendizVO aprenVO = new AprendizVO();
                    AprendizDAO aprenDAO= new AprendizDAO(aprenVO);
                    EvaluaVO evaVO = new EvaluaVO();
                    EvaluaDAO evaDAO = new EvaluaDAO();
                    ArrayList<AprendizVO>ListaAprendiz=aprenDAO.listar();
                    for (int i = 0; i < ListaAprendiz.size(); i++) {
                        
                        
                    aprenVO= ListaAprendiz.get(i);
                      if(evaDAO.consultarAprendiz(aprenVO.getIdAprendiz())!=null){
                            request.setAttribute("mensajeExito", "Ha realizado la evaluación");
                        }else{
                            request.setAttribute("mensajeError", "No ha realizado la evaluación");
                        }      
                            
            
                    %>
                    
                    <tr>
                        <td class="text-center" ><%=aprenVO.getNombre() %></td>
                        <td class="text-center" ><%=aprenVO.getApellido() %></td>
                        <td class="text-center" ><%=aprenVO.getCorreo() %></td>
                        <td class="text-center" ><%=aprenVO.getNumIdentidad() %></td>
                        <td class="text-center" ><%if (request.getAttribute("mensajeError") == null) {%>
                                                <div style="color:aqua;">${mensajeExito}</div>
                                                <% } else if (request.getAttribute("mensajeExito") == null) {%>
                                                <div style="color:red;">${mensajeError}</div>
                                                <%}%>
                                                 </td>
                        <td class="text-center" >
                            <form method="POST" action="Aprendiz">
                            <button class="btn btn-warning">Actualizar</button>
                            <input type="hidden" value="4" name="opcion">
                            <input type="hidden" value="<%=aprenVO.getIdAprendiz() %>" name="textId">
                            </form>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                  </table>
                    <a  class="btn btn-success" class="dropdown-item" href="javascript:void(0);" data-toggle="modal" data-target="#registrarAprendiz">Registrar</a>
                </div>
              </div>
            </div>
          </div>
          <!--Row-->

          <!-- Documentation Link -->
          <div class="row">
            <div class="col-lg-12">
              
            </div>
          </div>

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
                  <button Ftype="button" class="btn btn-outline-primary" data-dismiss="modal">Cancelar</button>
                  <a href="Sesiones" class="btn btn-primary">Salir</a>
                </div>
              </div>
            </div>
          </div>
            <!-- Modal Registrar_Aprendiz -->
          <div class="modal fade" id="registrarAprendiz" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelLogout"
            aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Registrar Aprendiz</h6>
                </div>
                <div class="card-body">
                       <form  class="modal-body" method="POST" action="Aprendiz">
                        <div class="form-group">   
                        <label for="nombre" >Nombre</label>
                        <input class="form-control" type="text" name="textNombre"><br>
                        </div>
                        <div class="form-group">    
                        <label for="apellido">Apellido</label>
                        <input class="form-control" type="text" name="textApellido"><br>
                        </div>
                        <div class="form-group">   
                        <label for="correo">Correo</label>
                        <input class="form-control" type="text" name="textCorreo"><br>
                        </div>
                        <div class="form-group">
                        <label for="exampleFormControlSelect1">Tipo de Documento</label>
                        <select name="textTipDocumento" class="form-control" id="exampleFormControlSelect1">
                          <option value="Tarjeta_de_Identidad">Tarjeta de Identidad</option>
                          <option value="Cedula_de_Ciudadania">Cedula de Ciudadania</option>
                          
                        </select>
                        </div>   
                        <div class="form-group">
                        <label for="numIdentidad">Numero de Idetidad</label>
                        <input class="form-control" type="text" name="textIdentidad"><br>
                        </div>
                        <button class="btn btn-warning" >Registrar</button>
                        <input class="form-control" type="hidden" value="1" name="opcion">

                        <a class="btn btn-success" href="Consultar_Aprendiz.jsp">Volver</a>

                        </form>
                </div>
              </div>
              </div>
            </div>
          </div>

        </div>
        <!---Container Fluid-->
      </div>

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
         
        </div>
      </footer>
      <!-- Footer -->
    </div>
  </div>

  <!-- Scroll to top -->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <script src="Assets/vendor/jquery/jquery.min.js"></script>
  <script src="Assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="Assets/vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="Assets/js/ruang-admin.min.js"></script>
  <!-- Page level plugins -->
  <script src="Assets/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="Assets/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script>
    $(document).ready(function () {
      $('#dataTable').DataTable(); // ID From dataTable 
      $('#dataTableHover').DataTable(); // ID From dataTable with Hover
    });
  </script>

</body>

</html>