/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.exemploproperties.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALUNO
 */
public class ConnectionFactory {
 
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    ConfUtil.getConf(ConfUtil.JDBC_URL), 
                    ConfUtil.getConf(ConfUtil.JDBC_USER), 
                    ConfUtil.getConf(ConfUtil.JDBC_PASSWORD));
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    
    
}
