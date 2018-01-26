package com.schoolapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.schoolapp.bean.Usuario;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements InterfaceUsuarioDAO {

    private Connection conn;
    
    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
        
    @Override
    public void excluir(Integer codigo) throws SQLException {
        PreparedStatement ps;

        String sql = "DELETE FROM usuario WHERE usuario_id = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.execute();
        ps.close();
    }

    @Override
    public void salvar(Usuario usuario) throws SQLException {
        PreparedStatement ps;

        String sql = "INSERT INTO autor (nomecompleto, datanascimento, cpf, "
                + "sexo, rua, bairro, cidade, estado, sobrenome, cep, status)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?);";

        ps = conn.prepareCall(sql);
        setPreparedStatement(usuario, ps);

        ps.executeUpdate();
//      System.out.println("Debug - " + autor + ps);
        ps.close();
    }
    
    private void setPreparedStatement(Usuario usuario, PreparedStatement ps)
            throws SQLException {

//        ps.setObject(1, usuario.getNomeCompleto());
//        ps.setObject(2, usuario.getDataNascimentoFormatadaBD());
//        ps.setObject(3, usuario.getCpf());
//        ps.setObject(4, usuario.getSexo().name());
//        ps.setString(5, usuario.getEndereco().getRua());
//        ps.setString(6, usuario.getEndereco().getBairro());
//        ps.setString(7, usuario.getEndereco().getCidade());
//        ps.setString(8, usuario.getEndereco().getEstado().name());
//        ps.setString(9, usuario.getSobrenome());
//        ps.setString(10, usuario.getEndereco().getCep());
//        ps.setString(11, usuario.getStatus().name());

    }

    public List<Usuario> todos() {
        String sql = "SELECT * FROM pessoas";
        List<Usuario> lista = new ArrayList<Usuario>();
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Usuario usuario = null;
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                // ...
                lista.add(usuario);
            }
            rs.close();
        }
        catch (SQLException e) {
            
        }
        return lista;
    }

    @Override
    public void atualizar(Usuario usuario) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getUsuario(Integer codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> getUsuarios() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        
        Usuario usuario = new Usuario();
        usuario.setNome("Clayton");
        lista.add(usuario);
        
        usuario = new Usuario();
        usuario.setNome("Vanessa");
        lista.add(usuario);
        
        return lista;
    }
    
}
