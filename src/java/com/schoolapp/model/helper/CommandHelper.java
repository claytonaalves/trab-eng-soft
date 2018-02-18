package com.schoolapp.model.helper;

import com.schoolapp.model.command.CadastrarCurso;
import java.util.HashMap;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;

import com.schoolapp.model.command.ConsultarCurso;
import com.schoolapp.model.command.ConsultarUsuario;
import com.schoolapp.model.command.EditarCurso;
import com.schoolapp.model.command.InterfaceCommand;
import com.schoolapp.model.command.ListarMenuPrincipal;
import com.schoolapp.model.dao.CursoDAO;
import com.schoolapp.model.dao.UsuarioDAO;

/**
 *
 * @author clayton
 */
public class CommandHelper {
    private final HashMap<String, InterfaceCommand> mapaComandos;
    private HttpServletRequest request;
    private final Connection connection;

    public CommandHelper(Connection connection) {
        this.connection = connection;

        mapaComandos = new HashMap<>();

        mapaComandos.put("listarMenuPrincipal", new ListarMenuPrincipal());
        mapaComandos.put("consultarUsuario", new ConsultarUsuario(new UsuarioDAO(connection)));
                
        mapaComandos.put("cadastrarCurso", new CadastrarCurso(new CursoDAO(connection)));
        mapaComandos.put("consultarCurso", new ConsultarCurso(new CursoDAO(connection)));
//        mapaComandos.put("atualizarCurso", new AtualizarCurso(new CursoDAO(connection)));
//        mapaComandos.put("editarCurso", new EditarCurso(new CursoDAO(connection)));
//        mapaComandos.put("excluirCurso", new ExcluirCurso(new CursoDAO(connection)));

    }

    public InterfaceCommand getCommand() {

        String cmd = request.getParameter("cmd");
        if (cmd == null) {
            return mapaComandos.get("iniciarApp");
        }
        return mapaComandos.get(cmd);
        /*
        String cmd = request.getParameter("cmd");
        if (cmd == null || request.getSession().getAttribute("usuario") == null) {
            return mapaComandos.get("acessarUsuario");
        }
        return mapaComandos.get(cmd);*/
        /*
        String cmd = request.getParameter("cmd");
        return mapaComandos.get(cmd);
         */
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
}
