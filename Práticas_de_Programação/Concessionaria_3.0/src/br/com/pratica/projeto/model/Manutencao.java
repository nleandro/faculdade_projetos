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
    private String placa;
    private Date ultimaRevisao;
    private Date proximaRevisao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
        
        return "Id: " + id + " - Placa: " + placa + " - Última Revisão: " +
               dateStr1 + " - Próxima Revisão: " + dateStr2;
    }
    
    
}
