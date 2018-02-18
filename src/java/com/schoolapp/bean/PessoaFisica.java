package com.schoolapp.bean;

import java.sql.Date;

/**
 *
 * @author clayton
 */
public class PessoaFisica extends Pessoa {

    private Date dataNascimento;
    private String CPF;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}
