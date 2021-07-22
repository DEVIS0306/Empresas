<%-- 
    Document   : Estadistica
    Created on : 19/07/2021, 10:00:38 PM
    Author     : jevergara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="org.jfree.chart.*"%>
<%@page import="org.jfree.chart.plot.*"%>
<%@page import="org.jfree.data.general.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <center>
        <br/>
        
        <form action="graficoTorta" class="transparente" target="myFrame">
            <input type="submit" value="Ver grafico estadistico de Torta" style="font-family: Arial; background: aqua; font-size: 20pt"/>
        </form>
        
        <br/>
        
        <form action="graficoBarra" target="myFrame">
            <input type="submit" value="Ver grafico estadistico de Barra" style="font-family: Arial; background: aqua; font-size: 20pt"/>
        </form>
        
    </center>
    </body>
</html>
