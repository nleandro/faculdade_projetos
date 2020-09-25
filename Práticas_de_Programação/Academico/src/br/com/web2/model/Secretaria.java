/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author EDUARDA
 */
@Entity
public class Secretaria {

    @Id
    private String cpf;
    private String nome;
    private String salario;
    private String qualificacao;
    private String idioma;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getQualificacao() {
        return qualificacao;
    }

    public void setQualificacao(String qualificacao) {
        this.qualificacao = qualificacao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Cpf: " + cpf + " - Nome: " + nome + " - Salario: " + salario
                + " Qualificacao: " + qualificacao + " - Idioma: " + idioma;
    }

}
