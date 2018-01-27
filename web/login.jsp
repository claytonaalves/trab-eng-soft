<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scholl App</title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container" style="margin: 0 auto; width:20%; margin-top: 100px">
        <h1>Acesso</h1>
        <form action="login" method="POST">
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" name="login" id="login" class="form-control">
            </div>
            <div class="form-group">
                <label for="senha">Senha</label>
                <input type="text" name="senha" id="senha" class="form-control">
            </div>
            <button type="submit" value="Acessar" class="btn btn-primary">Acessar</button>
        </form>
        </div>
    </body>
</html>
