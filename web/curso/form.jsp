<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../cabecalho.jsp" />
<div class="container">
    <h1><%= request.getAttribute("titulo")%></h1>
    <form action="?cmd=cadastrarCurso" method="POST">
        <div class="form-group">
            <label for="nome">Nome</label>
            <input type="text" name="nome" id="nome" value="" class="form-control">
        </div>
        <div class="form-group">
            <label for="dataInicio">Data Início</label>
            <input type="text" name="dataInicio" id="dataInicio" value="" class="form-control">
        </div>
        <div class="form-group">
            <label for="dataTermino">Data Término</label>
            <input type="text" name="dataTermino" id="dataTermino" value="" class="form-control">
        </div>
        <button type="submit" value="Gravar" class="btn btn-primary">Gravar</button>
        <a href="?cmd=consultarCurso">Cancelar</a>
    </form>
</div>
<jsp:include page="../rodape.jsp" />