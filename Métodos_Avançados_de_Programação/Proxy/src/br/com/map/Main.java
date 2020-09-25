/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Nellson
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        long tempo = (1000 * 60); // 1 minuto de espera
        Timer timer = new Timer();
        TimerTask timerTask;
        Evento e = new Evento();

        // Adicionar os interessados
        e.addObserver(new Interessado("Nellson", false));
        e.addObserver(new Interessado("Rivaldo", true, "email@si.fiponline.edu.br"));

        //System.out.println("Iniciando o monitoramento do site http://www.fiponline.edu.br/?u=1");
        
        // Iniciar o request por minuto
        timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    e.updateSite();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, tempo, tempo);
    }
}
