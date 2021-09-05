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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.1/css/dataTables.bootstrap4.min.css">
    </head>
    <body>
        <div class="container mb-5 mt-3">
        <h1>Preguntas</h1>
     
        <table class="table table-striped table-bordered " style="width: 100%" id="example" >
            <thead>
                <tr>
                    <th colspan="1"class="text-center">ID</th>
                    <th class="text-center" >Pregunta</th>
                    <th class="text-center" >Clasificacion</th>
                    <th></th>    
                    <th></th>   
                    </tr>
            </thead>
            <tbody>
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
            </tbody>
            <tfoot>
                <th class="text-center">ID</th>
                        <th class="text-center" >Pregunta</th>
                        <th class="text-center" >Clasificacion</th>
                        <th></th>    
                        <th></th> 
            </tfoot>  
                    
                </table>
         
                <a class="btn btn-success" href="MenuAdministrador.jsp">Volver</a>
                <a class="btn btn-success" href="Crear_Preguntas.jsp">Registrar</a>
        </div>
       <script src="https://code.jquery.com/jquery-3.5.1.js"></script> 
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> 
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 
       
       <script src="https://cdn.datatables.net/1.11.1/js/jquery.dataTables.min.js"></script>  
       <script src="https://cdn.datatables.net/1.11.1/js/dataTables.bootstrap4.min.js"></script> 
       <script>
          $(document).ready(function() {
                $('#example').DataTable();
          } );
       </script>
    </body>
</html>
