package com.schoolapp.model.command;

import com.schoolapp.bean.Curso;
import com.schoolapp.model.dao.CursoDAO;
import com.schoolapp.util.Utilitario;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clayton
 */
public class EditarCurso implements InterfaceCommand {
    
    private CursoDAO cursoDAO;
    
    public EditarCurso(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String codigo;
        codigo = request.getParameter("codigo");
        String titulo = "";

        if (codigo == null) {
            titulo = titulo + "Cadastro - Curso";
            request.setAttribute("titulo", titulo);
            return "formCadastroCurso.jsp";
        }
        try {

            titulo = titulo + "Atualização - Curso";
            request.setAttribute("titulo", titulo);

            request.setAttribute("curso", cursoDAO.getCurso(Integer.valueOf(codigo)));
            
            Curso curso = new Curso();
            curso = cursoDAO.getCurso(Integer.valueOf(codigo));
            request.setAttribute("cursoNome", curso.getNome());
//            request.setAttribute("autorDataNascimento", Utilitario.dataFormatada(curso.getDataNascimento()));
//            request.setAttribute("autorEstado", curso.getEndereco().getEstado());
//            request.setAttribute("autorStatus", curso.getStatus());

        } catch (NumberFormatException e) {
            request.setAttribute("mensagem", "Valor do código inválido" + codigo);
//        } catch (SQLException e) {
//            request.setAttribute("mensagem", "<font color=\"#ff0000\">Problemas com acesso a base de dados: </font>" + e.getMessage());
//            e.printStackTrace();
        }


        return "atualizaCurso.jsp";
    }

}
