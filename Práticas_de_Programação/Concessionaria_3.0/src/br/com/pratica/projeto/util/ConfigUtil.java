/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.util;

import java.util.ResourceBundle;

/**
 *
 * @author Nellson
 */
public class ConfigUtil {

    //Arquivo properties
    private static final ResourceBundle bundle = ResourceBundle.getBundle("br/com/pratica/projeto/properties/config");

    //Dados do MySQL
    public static final String JDBC_URL = "jdbc_url";
    public static final String JDBC_USER = "jdbc_user";
    public static final String JDBC_PASSWORD = "jdbc_password";

    public static String getConfig(String key) {
        return bundle.getString(key);
    }

}
