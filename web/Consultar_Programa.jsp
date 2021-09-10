<%-- 
    Document   : Consultar_Programa
    Created on : 10/09/2021, 07:18:08 AM
    Author     : Sofia
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.NivelDAO"%>
<%@page import="ModeloVO.NivelVO"%>
<%@page import="ModeloDAO.ProgramaDAO"%>
<%@page import="ModeloVO.ProgramaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Programa</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.1/css/dataTables.bootstrap4.min.css">
    </head>
    <body>
        <div class="container mb-5 mt-3">
            <h1>Programas</h1>

            <table class="table table-striped table-bordered " style="width: 100%" id="example" >
                <thead>
                    <tr>
                        <th colspan="1"class="text-center">ID</th>
                        <th class="text-center" >Programa</th>
                        <th class="text-center" >Nivel</th>
                        <th class="text-center">Actualizar</th>    
                        <th class="text-center">Borrar</th>   
                    </tr>
                </thead>
                <tbody>
                    <%
                        ProgramaVO proVO = new ProgramaVO();
                        ProgramaDAO proDAO = new ProgramaDAO(proVO);
                        NivelVO nilVO = new NivelVO();
                        NivelDAO claDAO = new NivelDAO();
                        ArrayList<ProgramaVO> ListaProgramas = proDAO.listar();
                        ArrayList<String> listaNil = new ArrayList<String>();
                        for (int i = 0; i < ListaProgramas.size(); i++) {

                            proVO = ListaProgramas.get(i);
                            


                    %>

                    <tr>
                        <td class="text-center" ><%=proVO.getIdPrograma()%></td>
                        <td class="text-center" ><%=proVO.getNombrePrograma()%></td>
                        <td class="text-center" ><%=proVO.getIdNivelFK()%></td>
                        <td class="text-center" >
                            <form method="POST" action="Programa">
                                <button class="btn btn-warning">Actualizar</button>
                                <input type="hidden" value="4" name="opcion">
                                <input type="hidden" value="<%=proVO.getIdPrograma()%>" name="textId">
                            </form>

                        </td>
                        <td class="text-center" >
                            <form method="POST" action="Programa">
                                <button class="btn btn-warning">Borrar</button>
                                <input type="hidden" value="2" name="opcion">
                                <input type="hidden" value="<%=proVO.getIdPrograma()%>" name="textId">
                            </form>

                        </td>
                    </tr>
                    <%}%>
                </tbody>
                <tfoot>
                <th class="text-center">ID</th>
                <th class="text-center" >Programa</th>
                <th class="text-center" >Nivel</th>
                <th class="text-center">Actualizar</th>    
                <th class="text-center">Borrar</th> 
                </tfoot>  

            </table>

            <a class="btn btn-success" href="MenuAdministrador.jsp">Volver</a>
            <a class="btn btn-success" href="Crear_Programa.jsp">Registrar</a>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> 
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 

        <script src="https://cdn.datatables.net/1.11.1/js/jquery.dataTables.min.js"></script>  
        <script src="https://cdn.datatables.net/1.11.1/js/dataTables.bootstrap4.min.js"></script> 
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
    </body>
</html>
