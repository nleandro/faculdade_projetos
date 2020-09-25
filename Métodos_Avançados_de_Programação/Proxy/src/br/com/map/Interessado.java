/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Nellson
 */
public class Interessado implements Observer {

    private GoogleMail mail = new GoogleMail();
    private String nome;
    private boolean notificacaoPorEmail;
    private String email;

    public Interessado(String nome, boolean notificacaoPorEmail) {
        this.nome = nome;
        this.notificacaoPorEmail = notificacaoPorEmail;
    }

    public Interessado(String nome, boolean notificacaoPorEmail, String email) {
        this.nome = nome;
        this.notificacaoPorEmail = notificacaoPorEmail;
        this.email = email;
    }

    @Override
    public void update(Observable o, Object arg) {
        String msg = "Olá " + this.nome + ", houve alteração no site.";
        if (!notificacaoPorEmail) {
            System.out.println(msg);
        } else {
            mail.sendEmail(email, "Atualização", msg);
        }
    }
}
