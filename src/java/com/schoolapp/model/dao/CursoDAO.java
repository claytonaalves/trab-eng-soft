package com.schoolapp.model.dao;

import com.schoolapp.bean.Curso;
import com.schoolapp.util.Utilitario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clayton
 */
public class CursoDAO {
    
    private Connection conn;

    public CursoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public List<Curso> getCursos() throws SQLException {
        PreparedStatement ps;
        String sqlSelect = "SELECT * FROM curso";
        ps = conn.prepareStatement(sqlSelect);
        ResultSet rs = ps.executeQuery();

        List<Curso> cursos = new ArrayList<>();
        while (rs.next()) {
            Curso curso = new Curso();
            curso.setNome(rs.getString("nome"));
            curso.setDataInicio(rs.getDate("dataInicio").toLocalDate());
            curso.setDataTermino(rs.getDate("dataTermino").toLocalDate());
            cursos.add(curso);
        }

        rs.close();
        ps.close();
            
        return cursos;
    }

    public Curso getCurso(Integer codigoCurso) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new Curso();
    }
    
    public void salvar(Curso curso) throws SQLException {
        PreparedStatement stmt;

        String sql = 
            "INSERT INTO curso (nome, dataInicio, dataTermino) " + 
            "VALUES (?,?,?)";

        stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, curso.getNome());
        stmt.setDate(2, Date.valueOf(curso.getDataInicio()));
        stmt.setDate(3, Date.valueOf(curso.getDataTermino()));

        stmt.executeUpdate();
        
        conn.commit();
        stmt.close();
    }
}
