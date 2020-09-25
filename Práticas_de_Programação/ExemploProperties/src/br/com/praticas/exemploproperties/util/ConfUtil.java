/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.exemploproperties.util;

import java.util.ResourceBundle;

/**
 *
 * @author ALUNO
 */
public class ConfUtil {
 
    private static final ResourceBundle bundle = ResourceBundle.getBundle("conf");
    
    public static final String JDBC_URL = "jdbc_url";
    public static final String JDBC_USER = "jdbc_user";
    public static final String JDBC_PASSWORD = "jdbc_password";
    
    public static String getConf(String key){
        return bundle.getString(key);
    }
    
    
}
