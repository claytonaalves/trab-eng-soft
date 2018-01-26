<%-- 
    Document   : consultaUsuario
    Created on : 25/01/2018, 22:08:23
    Author     : clayton
--%>

<%@page import="com.schoolapp.bean.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuários</h1>
        
        <%
                    String classe = "linha1";
                    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                    for (Usuario usuario : usuarios) {

        %>
        
        <%= usuario.getNome() %>
        
        <% } %>

    </body>
</html>
