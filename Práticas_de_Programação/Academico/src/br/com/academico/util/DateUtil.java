/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nellson
 */
public class DateUtil {

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

    public static Date stringToDate(String dataString) {
        try {
            return formatter.parse(dataString);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String dateToString(Date date) {
        return formatter.format(date);

    }

}
