package com.schoolapp.model.command;

import com.schoolapp.bean.Curso;
import com.schoolapp.model.dao.CursoDAO;
import com.schoolapp.util.Utilitario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clayton
 */
public class CadastrarCurso implements InterfaceCommand {

    private CursoDAO cursoDAO;
    
    public CadastrarCurso(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("titulo", "Cadastrar - Curso");
        
        if (request.getMethod().equals("POST")) {
            Curso curso = new Curso();
            curso.setNome(request.getParameter("nome"));
            curso.setDataInicio(Utilitario.dataFormatada(request.getParameter("dataInicio")));
            curso.setDataTermino(Utilitario.dataFormatada(request.getParameter("dataTermino")));
            
            try {
                cursoDAO.salvar(curso);
                request.setAttribute("cursos", cursoDAO.getCursos());
            } catch (SQLException e) {
            //
            }
            
            // redirecionar para index
            
            return "app?cmd=consultarCurso";
        }
        
        return "curso/form.jsp";
    }
    
}
