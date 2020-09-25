/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nellson
 */
public class DateUtil {
    
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Tranformar java.util.Date para java.sql.Date
     * @param d
     * @return
     */
    public static java.sql.Date parseSql(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }

    /**
     * Tranformar java.sql.Date para java.util.Date
     * @param d
     * @return
     */
    public static java.util.Date parseUtil(java.sql.Date d) {
        return new java.util.Date(d.getTime());
    }

    /**
     * Tranformar String em java.util.Date
     * @param date
     * @return
     */
    public static java.util.Date stringToDate(String date) {
        try {
            return formatter.parse(date);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Tranformar java.util.Date em String
     * @param d
     * @return
     */
    public static String dateToString(java.util.Date d) {
        return formatter.format(d);
    }
}
