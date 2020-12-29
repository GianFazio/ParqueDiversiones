<%-- 
    Document   : logout
    Created on : 18 dic. 2020, 00:48:54
    Author     : Gian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    HttpSession misesion = request.getSession();
misesion.invalidate();
response.sendRedirect("login.jsp");
%>
</html>
