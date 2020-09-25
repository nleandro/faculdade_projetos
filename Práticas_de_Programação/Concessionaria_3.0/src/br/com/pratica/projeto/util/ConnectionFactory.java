/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nellson
 */
public class ConnectionFactory {
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(ConfigUtil.getConfig(ConfigUtil.JDBC_URL),
                    ConfigUtil.getConfig(ConfigUtil.JDBC_USER),
                    ConfigUtil.getConfig(ConfigUtil.JDBC_PASSWORD));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
    
}
