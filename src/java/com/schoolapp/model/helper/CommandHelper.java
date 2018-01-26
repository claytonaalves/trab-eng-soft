package com.schoolapp.model.helper;

import com.schoolapp.model.command.ConsultarUsuario;
import com.schoolapp.model.command.InterfaceCommand;
import com.schoolapp.model.dao.UsuarioDAO;
import java.sql.Connection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

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
//        this.request = request;

        mapaComandos = new HashMap<>();

        mapaComandos.put("consultarUsuario", new ConsultarUsuario(new UsuarioDAO(connection)));

//        mapaComandos.put("cadastrarCliente", new CadastrarCliente(new ClienteDAO(pool), new NivelDeAcessoDAO(pool)));
//        mapaComandos.put("consultarCliente", new ConsultarCliente(new ClienteDAO(pool)));
//        mapaComandos.put("atualizarCliente", new AtualizarCliente(new ClienteDAO(pool), new NivelDeAcessoDAO(pool)));
//        mapaComandos.put("editarCliente", new EditarCliente(new ClienteDAO(pool), new NivelDeAcessoDAO(pool)));
//        mapaComandos.put("excluirCliente", new ExcluirCliente(new ClienteDAO(pool)));

        //comando para a Editora
//        mapaComandos.put("cadastrarEditora", new CadastrarEditora(new EditoraDAO(pool)));
//        mapaComandos.put("consultarEditora", new ConsultarEditora(new EditoraDAO(pool)));
//        mapaComandos.put("atualizarEditora", new AtualizarEditora(new EditoraDAO(pool)));
//        mapaComandos.put("editarEditora", new EditarEditora(new EditoraDAO(pool)));
//        mapaComandos.put("excluirEditora", new ExcluirEditora(new EditoraDAO(pool)));
    }

    public InterfaceCommand getCommand() {

        String cmd = request.getParameter("cmd");
        if (cmd == null) {
        return mapaComandos.get("iniciarSiscultbook");
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
