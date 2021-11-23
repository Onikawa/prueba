

<%@page import="Modelo.Producto"%>
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
        List<Producto> lis = (ArrayList) request.getAttribute("Producto");

        %>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="ProductoServlet"method="POST">
                        
                        <div class="form-group">
                            <label>Nombre Producto</label>
                            <input type="text" name="txtNombres"  value="${producto.getNombre()}"class="form-control"  required="">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" name="txtpre"  value="${producto.getPrecio()}"class="form-control" required="" maxlength="9">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Cantidad</label>
                            <input type="text" name="txtStock" value="${producto.getStk()}" class="form-control" required="" maxlength="8">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text  " name="txtestado"  value="${producto.getEstado()}"class="form-control" required=""maxlength="1">

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
                            
                            <th>NOMBRE PRODUCTO</th>
                            <th>PRECIO</th>
                            <th>STOCK</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Producto x : lis) {
                        %>
                        <tr>
                            <td><%=x.getId()%></td>
                            <td><%=x.getNombre()%></td>
                            <td><%=x.getPrecio()%></td>
                            <td><%=x.getStk()%></td>
                            <td><%=x.getEstado()%></td>
                           
                            <td>
                                <a class="btn btn-warning" href="ProductoServlet?accion=Editar&id=<%=x.getId() %>">Editar</a>
                                <a class="btn btn-danger" href="ProductoServlet?accion=Borrar&id=<%=x.getId()%>">Delete</a>
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
