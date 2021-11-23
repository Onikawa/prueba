<%-- 
    Document   : RegistarVenta
    Created on : 08/11/2021, 03:18:05 PM
    Author     : onikawa
--%>

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
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="ClienteServlet" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <br>
                            <div class="form-group d-flex" >
                                <div class="col-sm-4 d-flex">
                                    <input type="text" name="codigocliente" value="${cliente.getDni()}" class="form-control" placeholder="DNI " required="" maxlength="8">
                                </div>
                                <div class="col-sm-2">
                                    <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" placeholder="Nombre Cliente"   value="${cliente.getNom()}" class="form-control">
                                </div>

                            </div>

                        </div>
                    </form>
                    <form action="ProductoServlet" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>DatoS Producto</label>    
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex">
                                    <input type="text" name="codigoproducto"  class="form-control" placeholder="Codigo">
                                </div>
                                <div class="col-sm-2">
                                    <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" placeholder="Datos Producto" class="form-control">
                                </div>

                            </div>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label>DatoS Producto</label>    
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex">
                                    <input type="text" name="precio" class="form-control" placeholder="s/.0.00">

                                </div>
                                <div class="col-sm-2">
                                    <input type="number" name="cant" placeholder="" class="form-control">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="stock" placeholder="Stock" class="form-control">
                                </div>

                            </div>
                            <br>
                            <div class="form-group">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info ">
                            </div>
                        </div>

                    </form>


                </div>

            </div>
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body"> 

                        <div class="d-flex col-sm-4 ml-auto ">
                            <label>Nro. Serie: </label>
                            <input type="text" name="Nroserie" class="form-control">
                        </div>
                        <table class="table table-hover">

                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>

                    </div>

                    <div class="card-footer">
                        <div>
                            <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                            <input type="submit" name="accion" value="cancelar" class="btn btn-danger">
                        </div>
                    </div>

                </div>
            </div>

        </div>

    </body>
</html>
