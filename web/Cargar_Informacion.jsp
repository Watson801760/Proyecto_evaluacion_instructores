<%-- 
    Document   : Cargar_Informacion
    Created on : 11-nov-2021, 21:13:06
    Author     : user
--%>

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
            <h1 class="h3 mb-0 text-gray-800">Cargar Archivos</h1>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="./">Home</a></li>
              <li class="breadcrumb-item">Tables</li>
              <li class="breadcrumb-item active" aria-current="page">DataTables</li>
            </ol>
          </div>
            <div class="col-lg-12">
              <div class="card mb-4">
            <form  class="modal-body" method="POST" action="Salon">
                <h2 class="h3 mb-0 text-gray-800">Relecionar Usuarios a Ficha</h2>
                  <div class="custom-file">
                        
                        <input type="file" name="sql" >
                        <input type="submit" value="cargar"  name="sql">
                        
                        <input class="form-control" type="hidden" value="1" name="opcion">
                      </div>
                  </form> 

          <!-- Row -->
          <div class="row">
            <!-- Datatables -->
            
            <!-- DataTable with Hover -->
           
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
                  <p>Estas seguro que quieres cerrar sesi??n?</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Cancelar</button>
                  <a href="Sesiones" class="btn btn-primary">Salir</a>
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
