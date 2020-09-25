/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map;

/**
 *
 * @author Nellson
 */
public class HttpRequestProxy implements IHttpRequest{

    private HttpRequest hp;
    
    public HttpRequestProxy() {
        this.hp = new HttpRequest();
    }
    
    @Override
    public String get() throws Exception {
        System.out.println("Iniciando a verificação do site FIP");
        String html = this.hp.get();
        System.out.println("Verificação encerrada");
        return html;
    }
    
}
