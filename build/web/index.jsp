<%-- 
    Document   : index
    Created on : 19/07/2021, 09:19:41 PM
    Author     : jevergara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body style="background:url('imagenes/inicio.png')no-repeat; background-size: cover;">
      
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
           

            <div class="collapse navbar-collapse" href="Controlador?menu=hola" target="myFrame">
                
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none"class="btn btn-outline-light" href="Controlador?menu=inicio" target="myFrame">Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none"class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                          <a style="margin-left: 10px; border: none"class="btn btn-outline-light" href="Controlador?menu=Estadistica" target="myFrame">Estadistica</a>
                    </li>

                </ul>

            </div>
        </nav>
        <div class="p-3" style="height: 555px">
            <iframe name="myFrame" style="height: 99%; width: 97%; border: none"></iframe>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    </body>
</html>
