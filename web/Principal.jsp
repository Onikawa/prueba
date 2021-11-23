<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Empleado"%>
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
        <title>JSP Page</title>
    </head>
    <body >
         
        <%
        Empleado ar = (Empleado) request.getAttribute("usuario");
        %>

        <nav class="navbar navbar-expand-lg navbar-light  bg-primary">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="margin-left: 10px;border: none" class="btn btn-outline-light " href="#">Home</a> 
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="ProductoServlet?accion=Listar" target="myFrame">Producto</a> 
                    </li>
                    <li clàss="nav-item">
                       <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="Controlador?accion=Listar"  target="myFrame">Empeado</a>
                    </li>
                    <li clàss="nav-item">
                        <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="ClienteServlet?accion=Listar" target="myFrame">Cliente</a>
                    </li>
                    <li clàss="nav-item">
                        <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="RegistrarVenta.jsp" target="myFrame">nueva venta</a>
                    </li>
                </ul>
            </div>

            <div class="dropdown">
                <button type="button"  id="dropdownMenu" style="margin-left: 10px;border: none" class="btn btn-outline-light" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

                    <%=ar.getNom()%>
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">
                        <img src="recusos/login/logo.png" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#"><%=ar.getUser()%></a>
                    <a class="dropdown-item" href="#"><%=ar.getUser()%>@gmail.com</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="index.jsp">Salir</a>
                </div>
            </div>
            <br>    
        </nav>
             <div class="m-4" style="height: 800px; ">
    <iframe name="myFrame" style="height:100%; width: 100%"></iframe>
    
</div>             
 
    </body>
</html>