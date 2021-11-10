<%-- 
    Document   : consultar_Ficha
    Created on : 10-sep-2021, 6:17:27
    Author     : Usuario
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.FichaDAO"%>
<%@page import="ModeloVO.FichaVO"%>

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
        <div class="container">
            <h1>Fichas</h1>

            <table class="table table-striped table-bordered " style="width: 100%" id="example">
                <thead>
                    <tr>
                        <th class="text-center">Numero de ficha</th>
                        <th class="text-center" >Fecha de inicio electiva</th>
                        <th class="text-center" >Fecha de Finalizacion electiva</th>
                        <th class="text-center" >Fecha de inicio productiva</th>
                        <th class="text-center" >Fecha de Finalizacion productiva</th>
                        <th class="text-center" >Estado</th>
                        <th></th>    
                    </tr>
                </thead>
                <tbody>
                    <%
                        FichaVO fichVO = new FichaVO();
                        FichaDAO fichDAO = new FichaDAO(fichVO);

                        ArrayList<FichaVO> ListaFicha = fichDAO.listar();
                        for (int i = 0; i < ListaFicha.size(); i++) {

                            fichVO = ListaFicha.get(i);

                    %>

                    <tr>
                        <td class="text-center" ><%=fichVO.getNumeroFicha()%></td>
                        <td class="text-center" ><%=fichVO.getFechaInicioElectiva()%></td>
                        <td class="text-center" ><%=fichVO.getFechaFinElectiva()%></td>
                        <td class="text-center" ><%=fichVO.getFechaInicioProductiva()%></td>
                        <td class="text-center" ><%=fichVO.getFechaFinProductiva()%></td>
                        <td class="text-center" ></td>
                        <td class="text-center" >
                            <form method="POST" action="Ficha">
                                <button class="btn btn-warning">Actualizar</button>
                                <input type="hidden" value="4" name="opcion">
                                <input type="hidden" value="<%=fichVO.getIdFicha()%>" name="textIdfich">
                            </form>
                        </td>
                    </tr>
                    <%}%>
                </tbody>

                <tfoot>

                </tfoot>

                <tr>
                    <th class="text-center">Numero de ficha</th>
                    <th class="text-center" >Fecha de inicio electiva</th>
                    <th class="text-center" >Fecha de Finalizacion electiva</th>
                    <th class="text-center" >Fecha de inicio productiva</th>
                    <th class="text-center" >Fecha de Finalizacion productiva</th>
                    <th class="text-center" >Estado</th>
                    <th></th>    
                </tr>
            </table>

            <a class="btn btn-success" href="MenuAdministrador.jsp">Volver</a>
            <a class="btn btn-success" href="Crear_Ficha.jsp">Registrar</a>
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