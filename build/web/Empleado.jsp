<%-- 
   Document   : Empleado
   Created on : 19/07/2021, 09:20:30 PM
   Author     : jevergara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/2c36e9b7b1.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" type="text/css" href="./css/css.css"
              <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    
    <body class="transparente">
        <div class="row no-padding">
            <div class="col-lg-3 col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="titulo-form">REGISTRO DE EMPLEADO</div>
                        <form action="Controlador?menu=Empleado" method="POST">
                            <div class="form-group">
                                <label>CC</label>
                                <input type="text" value="${Empleado.getCc()}" name="txtCc" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Nombres</label>
                                <input type="text"value="${Empleado.getNom()}"  name="txtNombres" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Apellidos</label>
                                <input type="text" value="${Empleado.getApell()}" name="txtApellidos" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Edad</label>
                                <input type="text" value="${Empleado.getEdad()}" name="txtEdad" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Fecha de nacimiento</label>
                                <input type="date" value="${Empleado.getFecha()}" name="txtFecha" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Telefono</label>
                                <input type="text" value="${Empleado.getTel()}" name="txtTel" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Jefe</label>
                                <input type="text"value="${Empleado.getJefes()}" name="txtJefes" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Cargo</label>
                                <select name="txtCargo"value="${Empleado.getCargoid()}" class="form-control">
                                    <option value="">Selecionar</option>
                                    <option value="1">Presidente</option>
                                    <option value="2">Gerente</option>
                                    <option value="3">SubGerente</option>
                                    <option value="4">lideres</option>
                                    <option value="5">Operarios</option>
                                </select>
                            </div>
                            <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-lg-9 col-sm-6 container-list card">
                <!--<form class="form-inline contaier-buscar" method="GET" action="Controlador?menu=Empleado&accion=Buscar&id=">
                    <input class="form-control mr-sm-2" type="search" name="txtBuscar" placeholder="Search" aria-label="Search">
                    <input type="hidden" name="menu" value="Empleado" />
                    <input type="hidden" name="accion" value="Buscar" />
                    <input type="hidden" name="id" value="${em.getId()}" />
                    <input class="btn btn-primary" value="Buscar" type="submit"/>
                </form>-->
                <table id="tablax">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>CC</th>
                            <th>NOMBRES</th>
                            <th>APELLIDO</th>
                            <th>EDAD</th>
                            <th>FECHAN DE NACIMIENTO</th>
                            <th>TELEFONO</th>
                            <th>JEFES</th>
                            <th>CARGO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${empleado}">
                            <tr>
                                <th class="text">${em.getId()}</th>
                                <th  class="text">${em.getCc()}</th>
                                <th class="text">${em.getNom()}</th>
                                <th class="text">${em.getApell()}</th>
                                <th class="text">${em.getEdad()}</th>
                                <th class="text">${em.getFecha()}</th>
                                <th class="text">${em.getTel()}</th>
                                <th class="text">${em.getJefes()}</th>
                                <th class="text">${em.getCargoid()}</th>
                                <td class="btn">
                                    <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}"><i class="fas fa-user-edit"></i></a>
                                    <a class="btn btn-danger"href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}"><i class="fas fa-trash-alt"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                 
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous">
        </script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js">
        </script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js">
        </script>
        <script>
            $(document).ready(function () {
                $('#tablax').DataTable({
                    language: {
                        processing: "Tratamiento en curso...",
                        search: "Buscar&nbsp;:",
                        lengthMenu: "Agrupar de _MENU_ items",
                        info: "Mostrando del item _START_ al _END_ de un total de _TOTAL_ items",
                        infoEmpty: "No existen datos.",
                        infoFiltered: "(filtrado de _MAX_ elementos en total)",
                        infoPostFix: "",
                        loadingRecords: "Cargando...",
                        zeroRecords: "No se encontraron datos con tu busqueda",
                        emptyTable: "No hay datos disponibles en la tabla.",
                        paginate: {
                            first: "Primero",
                            previous: "Anterior",
                            next: "Siguiente",
                            last: "Ultimo"
                        },
                        aria: {
                            sortAscending: ": active para ordenar la columna en orden ascendente",
                            sortDescending: ": active para ordenar la columna en orden descendente"
                        }
                    },
                    scrollY: 400,
                    lengthMenu: [[3, 5, -1], [3, 5, "All"]],
                });
            });
        </script>
    </body>
</html>
