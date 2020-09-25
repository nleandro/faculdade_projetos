/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Nellson
 */
public class HttpRequest {
    public String get() throws Exception {
        
        URL url = new URL("http://www.fiponline.edu.br/?u=1");
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        
        conexao.setRequestMethod("GET");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
	}
        in.close();
        
        conexao.disconnect();
        
        return response.toString();
    }
}
