/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author lucas
 */
@Entity
public class Disciplina {

    @Id
    @GeneratedValue
    private int codigo;
    private String nome;
    private String ministrador;
    private String cargaHoraria;
    @OneToOne(cascade = CascadeType.ALL)
    private Ementa ementa;

    public Disciplina() {
        ementa = new Ementa();
    }

    public Ementa getEmenta() {
        return ementa;
    }

    public void setEmenta(Ementa ementa) {
        this.ementa = ementa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMinistrador() {
        return ministrador;
    }

    public void setMinistrador(String ministrador) {
        this.ministrador = ministrador;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " - Nome: " + nome + " - Ministrador: " + ministrador
                + " - Carga Hóraria: " + cargaHoraria + ementa;

    }
}
