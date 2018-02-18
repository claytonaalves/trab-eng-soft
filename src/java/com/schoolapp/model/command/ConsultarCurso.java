package com.schoolapp.model.command;

import com.schoolapp.model.dao.CursoDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clayton
 */
public class ConsultarCurso implements InterfaceCommand {
    
    private CursoDAO cursoDAO;
    
    public ConsultarCurso(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("titulo", "Consulta - Cursos");
        try {
            request.setAttribute("cursos", cursoDAO.getCursos());
        } catch (SQLException e) {
            request.setAttribute("mensagem", "<font color=\"#ff0000\">Problemas com acesso a base de dados: </font>" + e.getMessage());
            e.printStackTrace();
        }
        return "curso/index.jsp";
    }

}
