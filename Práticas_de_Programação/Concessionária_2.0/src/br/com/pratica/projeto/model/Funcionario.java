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
    private String endereco;
    private int telefone;
    private Date dtNascimento;
    private int salario;

    public Funcionario() {
    
    }

    public Funcionario(long id) {
        this.id = id;
    }

    public Funcionario(String nome, String endereco, int telefone, Date dtNascimento, int salario) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
        this.salario = salario;
    }

    public Funcionario(long id, String nome, String endereco, int telefone, Date dtNascimento, int salario) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
        this.salario = salario;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        String dateStr = "";
        if (dtNascimento != null)
            dateStr = DateUtil.dateToString(dtNascimento);
        else
            dateStr = "null";
        
        return "Id: " + id + " - Nome: " + nome + " - Endereço: " + endereco + 
               " - Telefone: " + telefone + " - Data de Nascimento: " + dateStr +
               " - Salário: " + salario;
    }
}
