package com.schoolapp.model.command;

import com.schoolapp.model.dao.InterfaceUsuarioDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clayton
 */
public class ConsultarUsuario implements InterfaceCommand {

    private InterfaceUsuarioDAO usuarioDAO;

    public ConsultarUsuario(InterfaceUsuarioDAO usuarioDAO) {
        super();
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("titulo", "Consulta - Usuários");

        try {

            request.setAttribute("usuarios", usuarioDAO.getUsuarios());

        } catch (SQLException e) {
            request.setAttribute("mensagem", "<font color=\"#ff0000\">Problemas com acesso a base de dados: </font>" + e.getMessage());
            e.printStackTrace();
        }

        return "consultaUsuario.jsp";
    }
    
}
