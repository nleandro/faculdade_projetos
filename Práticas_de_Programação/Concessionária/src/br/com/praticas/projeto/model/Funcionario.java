/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.projeto.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nellson
 */
public class Funcionario {
    private long id;
    private String nome;
    private long telefone;
    private Date dataNascimento;

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

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = "";
        if(dataNascimento != null)
            dataString = formatter.format(dataNascimento);
        else
            dataString = "null";
        return "ID: " + id + " - Nome: " + nome + " - Telefone: " + telefone +
                " - Data de Nascimento: " + dataString;
    }
}
