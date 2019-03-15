<%-- 
    Document   : prueba
    Created on : 15/03/2019, 02:25:37 PM
    Author     : alumnog
--%>

<%@page import="entity.LineasTransportistas"%>
<%@page import="entity.Transportes"%>
<%@page import="database.baseDatos"%>
<%@page import="Service.transportesWebService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            baseDatos _baseDatos = new baseDatos();
            Service.transportesWebService _transportes = new transportesWebService(_baseDatos.getConnection());

            Transportes _transporte = new Transportes();

            _transporte.setPlacas("VXHY12345");
            _transporte.setMarca("BMW");
            _transporte.setModelo("i320");
            _transporte.setDescripcion("Prueba para agregar transporte");

            LineasTransportistas _linea = new LineasTransportistas();
            _linea.setId(1);
            _transporte.setLineasTransportistas(_linea);

            if (!_transportes.agregarTransporte(_transporte)) {
                out.print("<h1>Se agrego correctamente</h1>");
            } else {
                out.print("<h1>Ocurrio un error</h1>");
            }

        %>
    </body>
</html>
