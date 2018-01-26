package com.schoolapp.model.dao;

import java.sql.SQLException;
import com.schoolapp.bean.Usuario;
import java.util.List;

/**
 *
 * @author clayton
 */
public interface InterfaceUsuarioDAO {
    
    public void excluir(Integer codigo) throws SQLException;

    public void salvar(Usuario usuario) throws SQLException;

    public void atualizar(Usuario usuario) throws SQLException;

    public Usuario getUsuario(Integer codigo) throws SQLException;

    public List<Usuario> getUsuarios() throws SQLException;
    
}
