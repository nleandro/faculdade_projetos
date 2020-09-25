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
public class Cliente {
    
    private long id;
    private String nome;
    private int cpf;
    private String endereco;
    private int telefone;
    private Date dtNascimento;

    public Cliente() {
    
    }

    public Cliente(long id) {
        this.id = id;
    }

    public Cliente(String nome, int cpf, String endereco, int telefone, Date dtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
    }

    public Cliente(long id, String nome, int cpf, String endereco, int telefone, Date dtNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
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
    
    @Override
    public String toString() {
        String dateStr = "";
        if (dtNascimento != null)
            dateStr = DateUtil.dateToString(dtNascimento);
        else
            dateStr = "null";
        
        return "Id: " + id + " - Nome: " + nome + " - Cpf: " + cpf + 
               " - Endereço: " + endereco + " - Telefone: " + telefone + 
               " - Data de Nascimento: " + dateStr;
    }
}
