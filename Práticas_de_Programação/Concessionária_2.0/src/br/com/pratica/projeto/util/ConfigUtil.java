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

    //MySQL insert
    public static final String MYSQL_INSERT_VEICULO = "mysql_insert_veiculo";
    public static final String MYSQL_INSERT_FUNCIONARIO = "mysql_insert_funcionario";
    public static final String MYSQL_INSERT_CLIENTE = "mysql_insert_cliente";
    public static final String MYSQL_INSERT_VENDAVEICULO = "mysql_insert_vendaveiculo";
    public static final String MYSQL_INSERT_COMPRAVEICULO = "mysql_insert_compraveiculo";
    public static final String MYSQL_INSERT_MANUTENCAO = "mysql_insert_manutencao";

    //MySQL update
    public static final String MYSQL_UPDATE_VEICULO = "mysql_update_veiculo";
    public static final String MYSQL_UPDATE_FUNCIONARIO = "mysql_update_funcionario";
    public static final String MYSQL_UPDATE_CLIENTE = "mysql_update_cliente";
    public static final String MYSQL_UPDATE_VENDAVEICULO = "mysql_update_vendaveiculo";
    public static final String MYSQL_UPDATE_COMPRAVEICULO = "mysql_update_compraveiculo";
    public static final String MYSQL_UPDATE_MANUTENCAO = "mysql_update_manutencao";

    //MySQL delete
    public static final String MYSQL_DELETE_VEICULO = "mysql_delete_veiculo";
    public static final String MYSQL_DELETE_FUNCIONARIO = "mysql_delete_funcionario";
    public static final String MYSQL_DELETE_CLIENTE = "mysql_delete_cliente";
    public static final String MYSQL_DELETE_VENDAVEICULO = "mysql_delete_vendaveiculo";
    public static final String MYSQL_DELETE_COMPRAVEICULO = "mysql_delete_compraveiculo";
    public static final String MYSQL_DELETE_MANUTENCAO = "mysql_delete_manutencao";

    //MySQL select
    public static final String MYSQL_SELECT_VEICULO = "mysql_select_veiculo";
    public static final String MYSQL_SELECT_FUNCIONARIO = "mysql_select_funcionario";
    public static final String MYSQL_SELECT_CLIENTE = "mysql_select_cliente";
    public static final String MYSQL_SELECT_VENDAVEICULO = "mysql_select_vendaveiculo";
    public static final String MYSQL_SELECT_COMPRAVEICULO = "mysql_select_compraveiculo";
    public static final String MYSQL_SELECT_MANUTENCAO = "mysql_select_manutencao";

    public static String getConfig(String key) {
        return bundle.getString(key);
    }

}
