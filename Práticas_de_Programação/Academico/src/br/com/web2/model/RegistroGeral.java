/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web2.model;

import br.com.web2.util.DateUtil;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nellson
 */
@Entity
public class RegistroGeral {

    @Id
    @GeneratedValue
    private int id;
    private String rg;
    @Temporal(TemporalType.DATE)
    private Date dataExpedicao;
    private String orgaoEmissor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(Date dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    @Override
    public String toString() {
        String dataString = "";
        if (dataExpedicao != null) {
            dataString = DateUtil.dateToString(dataExpedicao);
        }

        return "RG: " + rg + " - Data de Expedicao: " + dataString + " - Órgão Emissor: " + orgaoEmissor;
    }
}
