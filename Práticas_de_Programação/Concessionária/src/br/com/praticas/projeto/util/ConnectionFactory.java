/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.projeto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nellson
 */
public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/projeto";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return null;
        }
    }
}
