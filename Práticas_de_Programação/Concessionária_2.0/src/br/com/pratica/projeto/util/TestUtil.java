/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nellson
 */
public class TestUtil {
    
    public static int getLastIdTest(String s) {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM " + s);
            ResultSet rs = st.executeQuery();
            
            if(rs.last()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
}
