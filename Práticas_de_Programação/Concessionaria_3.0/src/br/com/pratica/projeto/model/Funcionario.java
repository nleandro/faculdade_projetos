/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

import br.com.pratica.projeto.util.DateUtil;
import java.util.Date;

/**
 *
 * @author Nellson
 */
public class Funcionario {
    
    private long id;
    private String nome;
    private double salario;
    private Date dtNascimento;
    private Endereco endereco;

    public Funcionario() {
        this.endereco = new Endereco();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        String dateStr = "";
        if (dtNascimento != null)
            dateStr = DateUtil.dateToString(dtNascimento);
        else
            dateStr = "null";
        
        return "Id: " + id + " - Nome: " + nome + " - Salário: " + salario + 
               " - Data de Nascimento: " + dateStr + " - Endereço: " + endereco;
    }
}
