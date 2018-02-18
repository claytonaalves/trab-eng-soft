package com.schoolapp.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clayton
 */
public class Aluno extends PessoaFisica {
    
    private List<Curso> cursos;
    
    public Aluno() {
        cursos = new ArrayList<>();
    }
    
}
