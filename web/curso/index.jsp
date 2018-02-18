<%@page import="java.util.List"%>
<%@page import="com.schoolapp.bean.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schooll App</title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
        <h1>Cursos</h1>
        
        <div class="row">
            <div class="col-md-12">
                <a href="?cmd=cadastrarCurso" class="btn btn-primary float-right">Adicionar</a>
            </div>
        </div>
                
        <%
            List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
        %>
        <table class="table">
            <tr>
                <th>Nome</th>
                <th>Data início</th>
                <th>Data término</th>
            </tr>
        <%
            for (Curso curso : cursos) {
        %>
            <tr>
                <td><%= curso.getNome() %></td>
                <td></td>
                <td></td>
            </tr>
        <% } %>
        </table>
        </div>
    </body>
</html>
