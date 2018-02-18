package com.schoolapp.bean;

import java.time.LocalDate;

/**
 *
 * @author clayton
 */
public class Curso {

    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }
    
}
