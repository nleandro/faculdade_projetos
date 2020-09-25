/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web2.model;

import br.com.web2.util.DateUtil;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author EDUARDA
 */
@Entity
public class Aluno {

    @Id
    @GeneratedValue
    private int matricula;
    private String nome;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String curso;
    private String periodo;
    @OneToOne(cascade = CascadeType.ALL)
    private RegistroGeral rg;

    public Aluno() {
        this.rg = new RegistroGeral();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public RegistroGeral getRg() {
        return rg;
    }

    public void setRg(RegistroGeral rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        String dataString = "";
        if (dataNascimento != null) {
            dataString = DateUtil.dateToString(dataNascimento);
        }

        return "Matrícula: " + matricula + " - Nome: " + nome + " - " + rg + " - E-mail: " + email
                + " - Data de Nascimento: " + dataString + " - Período: " + periodo + " - Curso: " + curso;
    }

}
