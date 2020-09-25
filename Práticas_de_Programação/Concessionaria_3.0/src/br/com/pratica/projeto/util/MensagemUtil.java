/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Nellson
 */
public class MensagemUtil {
    
    //Arquivo properties
    private static ResourceBundle bundle = ResourceBundle.getBundle("br/com/pratica/projeto/properties/mensagem_pt_BR");

    //Linguagens
    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
    public static final Locale LOCALE_EN_US = new Locale("en", "US");
    public static final Locale LOCALE_FR_FR = new Locale("es", "ES");
    
    //Opções geral
    public static final String MENU_OPCAO_SAIR = "menu_opcao_sair";
    public static final String MENU_OPCAO_ESCOLHA = "menu_opcao_escolha";
    public static final String MENU_LISTA_VAZIA = "menu_lista_vazia";
    
    //Menu títulos
    public static final String MENU_TITULO_PRINCIPAL = "menu_titulo_principal";
    public static final String MENU_TITULO_VEICULO = "menu_titulo_veiculo";
    public static final String MENU_TITULO_FUNCIONARIO = "menu_titulo_funcionario";
    public static final String MENU_TITULO_CLIENTE = "menu_titulo_cliente";
    public static final String MENU_TITULO_MANUTENCAO = "menu_titulo_manutencao";
    public static final String MENU_TITULO_IDIOMA = "menu_titulo_idioma";
    public static final String MENU_TITULO_INSERIR = "menu_titulo_inserir";
    public static final String MENU_TITULO_EDITAR = "menu_titulo_editar";
    public static final String MENU_TITULO_REMOVER = "menu_titulo_remover";
    public static final String MENU_TITULO_LISTAR = "menu_titulo_listar";

    //Menu principal
    public static final String MENU_PRINCIPAL_OPCAO1 = "menu_principal_opcao1";
    public static final String MENU_PRINCIPAL_OPCAO2 = "menu_principal_opcao2";
    public static final String MENU_PRINCIPAL_OPCAO3 = "menu_principal_opcao3";
    public static final String MENU_PRINCIPAL_OPCAO4 = "menu_principal_opcao4";
    public static final String MENU_PRINCIPAL_OPCAO5 = "menu_principal_opcao5";
    
    //Menu idioma
    public static final String MENU_IDIOMA_BR = "menu_idioma_br";
    public static final String MENU_IDIOMA_EN = "menu_idioma_en";
    public static final String MENU_IDIOMA_FR = "menu_idioma_fr";
    
    //Menu banco de dados
    public static final String MENU_INSERIR = "menu_inserir";
    public static final String MENU_EDITAR = "menu_editar";
    public static final String MENU_REMOVER = "menu_remover";
    public static final String MENU_LISTAR = "menu_listar";
    
    //Variáveis inserir
    public static final String MENU_INSERIR_PLACA = "menu_inserir_placa";
    public static final String MENU_INSERIR_MODELO = "menu_inserir_modelo";
    public static final String MENU_INSERIR_FABRICANTE = "menu_inserir_fabricante";
    public static final String MENU_INSERIR_CNPJ = "menu_inserir_cnpj";
    public static final String MENU_INSERIR_CHASSI = "menu_inserir_chassi";
    public static final String MENU_INSERIR_NOME = "menu_inserir_nome";
    public static final String MENU_INSERIR_ENDERECO = "menu_inserir_endereco";
    public static final String MENU_INSERIR_DTNASCIMENTO = "menu_inserir_dtnascimento";
    public static final String MENU_INSERIR_SALARIO = "menu_inserir_salario";
    public static final String MENU_INSERIR_CPF = "menu_inserir_cpf";
    public static final String MENU_INSERIR_RUA = "menu_inserir_rua";
    public static final String MENU_INSERIR_BAIRRO = "menu_inserir_bairro";
    public static final String MENU_INSERIR_NUMERO = "menu_inserir_numero";
    public static final String MENU_INSERIR_CIDADE = "menu_inserir_cidade";
    public static final String MENU_INSERIR_ESTADO = "menu_inserir_estado";
    public static final String MENU_INSERIR_ULTIMAREVISAO = "menu_inserir_ultimarevisao";
    public static final String MENU_INSERIR_PROXIMAREVISAO = "menu_inserir_proximarevisao";
    
    
    //Variáveis editar
    public static final String MENU_EDITAR_ID = "menu_editar_id";
    public static final String MENU_EDITAR_PLACA = "menu_editar_placa";
    public static final String MENU_EDITAR_MODELO = "menu_editar_modelo";
    public static final String MENU_EDITAR_FABRICANTE = "menu_editar_fabricante";
    public static final String MENU_EDITAR_NOME = "menu_editar_nome";
    public static final String MENU_EDITAR_ENDERECO = "menu_editar_endereco";
    public static final String MENU_EDITAR_DTNASCIMENTO = "menu_editar_dtnascimento";
    public static final String MENU_EDITAR_SALARIO = "menu_editar_salario";
    public static final String MENU_EDITAR_CPF = "menu_editar_cpf";
    public static final String MENU_EDITAR_CHASSI = "menu_editar_chassi";
    public static final String MENU_EDITAR_CNPJ = "menu_editar_cnpj";
    public static final String MENU_EDITAR_RUA = "menu_editar_rua";
    public static final String MENU_EDITAR_BAIRRO = "menu_editar_bairro";
    public static final String MENU_EDITAR_NUMERO = "menu_editar_numero";
    public static final String MENU_EDITAR_CIDADE = "menu_editar_cidade";
    public static final String MENU_EDITAR_ESTADO = "menu_editar_estado";
    public static final String MENU_EDITAR_ULTIMAREVISAO = "menu_editar_ultimarevisao";
    public static final String MENU_EDITAR_PROXIMAREVISAO = "menu_editar_proximarevisao";
    
    //Variáveis remover
    public static final String MENU_REMOVER_ID = "menu_remover_id";
    
    public static String getMensagem(String key) {
        return bundle.getString(key);
    }
    
    public static void setLocale(Locale l){
        bundle = ResourceBundle.getBundle("br/com/pratica/projeto/properties/mensagem", l);
    }
}
