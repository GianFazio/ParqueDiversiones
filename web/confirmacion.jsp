<%-- 
    Document   : confirmacion
    Created on : 14 dic. 2020, 18:20:16
    Author     : Gian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos ingresados:</h1>
        
        <p>Nombre: <%=session.getAttribute("nombre")%></p>
        <p>Edad: <%=session.getAttribute("edad")%></p>
    </body>
</html>
