/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.exemploproperties.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ALUNO
 */
public class MensagensUtil {

    private static ResourceBundle bundle
            = ResourceBundle.getBundle("mensagens");

    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
    public static final Locale LOCALE_EN_US = new Locale("en", "US");

    public static final String MSG_BOAS_VINDAS = "msg_boas_vindas";
    public static final String MENU_PRINCIPAL_TITULO = "menu_principal_titulo";
    public static final String MENU_PRINCIPAL_CADASTRAR = "menu_principal_cadastrar";
    public static final String MENU_PRINCIPAL_BUSCAR = "menu_principal_buscar";
    public static final String MENU_PRINCIPAL_IDIOMA = "menu_principal_idioma";

    public static void setLocale(Locale l){
        bundle
            = ResourceBundle.getBundle("mensagens", l);
    }
    
    public static String getMensagem(String key) {
        return bundle.getString(key);
    }
}
