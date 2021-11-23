

<%@page import="Modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body><%
        List<Cliente> lis = (ArrayList) request.getAttribute("Clientes");

        %>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="ClienteServlet"method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" name="txtDni" value="${cliente.getDni()}" class="form-control" required="" maxlength="8">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" name="txtNombres"  value="${cliente.getNom()}"class="form-control"  required="">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" name="txtDireccion"  value="${cliente.getDirec()}"class="form-control" required="" maxlength="9">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text  " name="txtestado"  value="${cliente.getEstado()}"class="form-control" required=""maxlength="1">

                        </div>
                        <br>           
                        <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-primary">
                    </form>
                </div>
            </div>

            <div class="card col-sm-9">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>DIRECCION</th>
                            <th>ESTAD0</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Cliente x : lis) {
                        %>
                        <tr>
                            <td><%=x.getId()%></td>
                            <td><%=x.getDni()%></td>
                            <td><%=x.getNom()%></td>
                            <td><%=x.getDirec() %></td>
                            <td><%=x.getEstado()%></td>
                           
                            <td>
                                <a class="btn btn-warning" href="ClienteServlet?accion=Editar&id=<%=x.getId() %>">Editar</a>
                                <a class="btn btn-danger" href="ClienteServlet?accion=Borrar&id=<%=x.getId()%>">Delete</a>
                            </td>

                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>



            </div>
        </div>


    </body>
</html>
