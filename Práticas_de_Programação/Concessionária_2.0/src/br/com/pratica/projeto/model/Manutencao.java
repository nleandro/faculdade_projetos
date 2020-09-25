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
public class Manutencao {
    
    private long id;
    private String modelo;
    private Date ultimaRevisao;
    private Date proximaRevisao;

    public Manutencao() {
    
    }

    public Manutencao(long id) {
        this.id = id;
    }

    public Manutencao(String modelo, Date ultimaRevisao, Date proximaRevisao) {
        this.modelo = modelo;
        this.ultimaRevisao = ultimaRevisao;
        this.proximaRevisao = proximaRevisao;
    }

    public Manutencao(long id, String modelo, Date ultimaRevisao, Date proximaRevisao) {
        this.id = id;
        this.modelo = modelo;
        this.ultimaRevisao = ultimaRevisao;
        this.proximaRevisao = proximaRevisao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getUltimaRevisao() {
        return ultimaRevisao;
    }

    public void setUltimaRevisao(Date ultimaRevisao) {
        this.ultimaRevisao = ultimaRevisao;
    }

    public Date getProximaRevisao() {
        return proximaRevisao;
    }

    public void setProximaRevisao(Date proximaRevisao) {
        this.proximaRevisao = proximaRevisao;
    }

    @Override
    public String toString() {
        String dateStr1 = "";
        String dateStr2 = "";
        if(ultimaRevisao != null)
            dateStr1 = DateUtil.dateToString(ultimaRevisao);
        else
            dateStr1 = "null";
        if(proximaRevisao != null)
            dateStr2 = DateUtil.dateToString(proximaRevisao);
        else
            dateStr2 = "null";
        
        return "Id: " + id + " - Modelo: " + modelo + " - Última Revisão: " +
               dateStr1 + " - Próxima Revisão: " + dateStr2;
    }
    
    
}
