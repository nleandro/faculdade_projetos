/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map;

import java.util.Observable;

/**
 *
 * @author Nellson
 */
public class Evento extends Observable {

    private HttpRequestProxy hr;
    private String response;

    public Evento() throws Exception {
        this.hr = new HttpRequestProxy();
        this.response = hr.get();
    }

    public void updateSite() throws Exception {
        String newResponse = hr.get();
        if (!response.equals(newResponse)) {
            this.response = newResponse;
            this.setChanged();
            this.notifyObservers();
        }
    }
}
