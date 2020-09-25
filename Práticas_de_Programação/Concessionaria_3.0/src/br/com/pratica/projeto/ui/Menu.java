/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.ui;

import br.com.pratica.projeto.facade.ConcessionariaFacade;
import br.com.pratica.projeto.model.Veiculo;
import br.com.pratica.projeto.model.Funcionario;
import br.com.pratica.projeto.model.Cliente;
import br.com.pratica.projeto.model.Manutencao;
import br.com.pratica.projeto.util.DateUtil;
import br.com.pratica.projeto.util.MensagemUtil;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nellson
 */
public class Menu {
    
    public static void main(String[] args) throws SQLException {
        
        // Menu
        Scanner input = new Scanner(System.in);
        String op1 = "";
        String op2 = "";
        
        // Facade
        ConcessionariaFacade facade = new ConcessionariaFacade();
        
        // Model
        Veiculo veiculo = null;
        Funcionario funcionario = null;
        Cliente cliente = null;
        Manutencao manutencao = null;
                
        do {
            //Menu principal
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_PRINCIPAL));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO1));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO2));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO3));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO4));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO5));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_SAIR));
            System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_ESCOLHA));
            
            op1 = input.nextLine();
            
            if(op1.equals("1")){ //Menu veiculo
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_VEICULO));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_SAIR));
                System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_ESCOLHA));
                
                op2 = input.nextLine();
                
                if(op2.equals("1")) { //Inserir
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_INSERIR));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PLACA));
                    String placa = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_MODELO));
                    String modelo = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_CHASSI));
                    String chassi = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_FABRICANTE));
                    String nomeFabricante = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_CNPJ));
                    String cnpjStr = input.nextLine();
                    int cnpj = Integer.parseInt(cnpjStr);
                    
                    veiculo = new Veiculo();
                    
                    veiculo.setPlaca(placa);
                    veiculo.setModelo(modelo);
                    veiculo.setChassi(chassi);
                    veiculo.getFabricante().setNome(nomeFabricante);
                    veiculo.getFabricante().setCnpj(cnpj);
                    
                    facade.inserirVeiculo(veiculo);
                }
                else if(op2.equals("2")) { //Editar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_EDITAR));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ID));
                    String idStr = input.nextLine();
                    long id = Long.parseLong(idStr);

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_PLACA));
                    String placa = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_MODELO));
                    String modelo = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_CHASSI));
                    String chassi = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_FABRICANTE));
                    String nomeFabricante = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_CNPJ));
                    String cnpjStr = input.nextLine();
                    int cnpj = Integer.parseInt(cnpjStr);

                    veiculo = facade.buscarVeiculo(id);

                    veiculo.setPlaca(placa);
                    veiculo.setModelo(modelo);
                    veiculo.setChassi(chassi);
                    veiculo.getFabricante().setNome(nomeFabricante);
                    veiculo.getFabricante().setCnpj(cnpj);

                    facade.editarVeiculo(veiculo);
                }
                else if(op2.equals("3")) { //Remover
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_REMOVER));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER_ID));
                    String idStr = input.nextLine();
                    long id = Long.parseLong(idStr);
                    
                    veiculo = facade.buscarVeiculo(id);
                    
                    facade.removerVeiculo(veiculo);                    
                }
                else if(op2.equals("4")) { //Listar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_LISTAR));
                    List<Veiculo> lista = facade.listarVeiculo();
                    
                    if(lista.isEmpty())
                        System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTA_VAZIA));
                    else {
                        for(Veiculo v : lista)
                           System.out.println(v);
                    }
                }
            } else if (op1.equals("2")) { //Menu Funcionário
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_FUNCIONARIO));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_SAIR));
                System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_ESCOLHA));
                
                op2 = input.nextLine();
                
                if(op2.equals("1")) { //Inserir
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_INSERIR));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_NOME));
                    String nome = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_DTNASCIMENTO));
                    String dateStr = input.nextLine();
                    Date date = DateUtil.stringToDate(dateStr);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_SALARIO));
                    String salarioStr = input.nextLine();
                    double salario = Double.parseDouble(salarioStr);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_RUA));
                    String rua = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_BAIRRO));
                    String bairro = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_NUMERO));
                    String numeroStr = input.nextLine();
                    int numero = Integer.parseInt(numeroStr);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_CIDADE));
                    String cidade = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_ESTADO));
                    String estado = input.nextLine();
                    
                    funcionario = new Funcionario();
                    
                    funcionario.setNome(nome);
                    funcionario.setDtNascimento(date);
                    funcionario.setSalario(salario);
                    funcionario.getEndereco().setRua(rua);
                    funcionario.getEndereco().setBairro(bairro);
                    funcionario.getEndereco().setNumero(numero);
                    funcionario.getEndereco().setCidade(cidade);
                    funcionario.getEndereco().setEstado(estado);
                    
                    facade.inserirFuncionario(funcionario);
                }
                else if(op2.equals("2")) { //Editar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_EDITAR));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ID));
                    String idStr = input.nextLine();
                    long id = Long.parseLong(idStr);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_NOME));
                    String nome = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_DTNASCIMENTO));
                    String dateStr = input.nextLine();
                    Date date = DateUtil.stringToDate(dateStr);

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_SALARIO));
                    String salarioStr = input.nextLine();
                    double salario = Double.parseDouble(salarioStr);

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_RUA));
                    String rua = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_BAIRRO));
                    String bairro = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_NUMERO));
                    String numeroStr = input.nextLine();
                    int numero = Integer.parseInt(numeroStr);

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_CIDADE));
                    String cidade = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ESTADO));
                    String estado = input.nextLine();

                    funcionario = facade.buscarFuncionario(id);

                    funcionario.setNome(nome);
                    funcionario.setDtNascimento(date);
                    funcionario.setSalario(salario);
                    funcionario.getEndereco().setRua(rua);
                    funcionario.getEndereco().setBairro(bairro);
                    funcionario.getEndereco().setNumero(numero);
                    funcionario.getEndereco().setCidade(cidade);
                    funcionario.getEndereco().setEstado(estado);

                    facade.editarFuncionario(funcionario);
                }
                else if(op2.equals("3")) { //Remover
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_REMOVER));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER_ID));
                    String idStr = input.nextLine();
                    long id = Long.parseLong(idStr);
                    
                    funcionario = facade.buscarFuncionario(id);
                    
                    facade.removerFuncionario(funcionario);
                }
                else if(op2.equals("4")) { //Listar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_LISTAR));
                    List<Funcionario> lista = facade.listarFuncionario();
                    
                    if(lista.isEmpty())
                        System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTA_VAZIA));
                    else {
                        for(Funcionario f : lista)
                           System.out.println(f);
                    }
                }
            } else if (op1.equals("3")) { //Menu Cliente
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_CLIENTE));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_SAIR));
                System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_ESCOLHA));
                
                op2 = input.nextLine();
                
                if(op2.equals("1")) { //Inserir
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_INSERIR));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_NOME));
                    String nome = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_CPF));
                    String cpfStr = input.nextLine();
                    int cpf = Integer.parseInt(cpfStr);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_DTNASCIMENTO));
                    String dateStr = input.nextLine();
                    Date date = DateUtil.stringToDate(dateStr);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_RUA));
                    String rua = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_BAIRRO));
                    String bairro = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_NUMERO));
                    String numeroStr = input.nextLine();
                    int numero = Integer.parseInt(numeroStr);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_CIDADE));
                    String cidade = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_ESTADO));
                    String estado = input.nextLine();
                    
                    cliente = new Cliente();
                    
                    cliente.setNome(nome);
                    cliente.setCpf(cpf);
                    cliente.setDtNascimento(date);
                    cliente.getEndereco().setRua(rua);
                    cliente.getEndereco().setBairro(bairro);
                    cliente.getEndereco().setNumero(numero);
                    cliente.getEndereco().setCidade(cidade);
                    cliente.getEndereco().setEstado(estado);
                    
                    facade.inserirCliente(cliente);
                }
                else if(op2.equals("2")) { //Editar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_EDITAR));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ID));
                    String idStr = input.nextLine();
                    long id = Long.parseLong(idStr);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_NOME));
                    String nome = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_CPF));
                    String cpfStr = input.nextLine();
                    int cpf = Integer.parseInt(cpfStr);

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_DTNASCIMENTO));
                    String dateStr = input.nextLine();
                    Date date = DateUtil.stringToDate(dateStr);

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_RUA));
                    String rua = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_BAIRRO));
                    String bairro = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_NUMERO));
                    String numeroStr = input.nextLine();
                    int numero = Integer.parseInt(numeroStr);

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_CIDADE));
                    String cidade = input.nextLine();

                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ESTADO));
                    String estado = input.nextLine();

                    cliente = facade.buscarCliente(id);

                    cliente.setNome(nome);
                    cliente.setCpf(cpf);
                    cliente.setDtNascimento(date);
                    cliente.getEndereco().setRua(rua);
                    cliente.getEndereco().setBairro(bairro);
                    cliente.getEndereco().setNumero(numero);
                    cliente.getEndereco().setCidade(cidade);
                    cliente.getEndereco().setEstado(estado);

                    facade.editarCliente(cliente);                    
                }
                else if(op2.equals("3")) { //Remover
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_REMOVER));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER_ID));
                    String idStr = input.nextLine();
                    long id = Long.parseLong(idStr);
                    
                    cliente = facade.buscarCliente(id);
                    
                    facade.removerCliente(cliente);
                }
                else if(op2.equals("4")) { //Listar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_LISTAR));
                    List<Cliente> lista = facade.listarCliente();
                    
                    if(lista.isEmpty())
                        System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTA_VAZIA));
                    else {
                        for(Cliente c : lista)
                           System.out.println(c);
                    }
                }
            } else if(op1.equals("4")) { // Menu Manutenção
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_MANUTENCAO));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_SAIR));
                System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_ESCOLHA));
                
                op2 = input.nextLine();
                
                if(op2.equals("1")) { //Inserir
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_INSERIR));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PLACA));
                    String placa = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_ULTIMAREVISAO));
                    String dateStr1 = input.nextLine();
                    Date date1 = DateUtil.stringToDate(dateStr1);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PROXIMAREVISAO));
                    String dateStr2 = input.nextLine();
                    Date date2 = DateUtil.stringToDate(dateStr2);
                                        
                    manutencao = new Manutencao();
                    
                    manutencao.setPlaca(placa);
                    manutencao.setUltimaRevisao(date1);
                    manutencao.setProximaRevisao(date2);
                    
                    facade.inserirManutencao(manutencao);
                }
                else if(op2.equals("2")) { //Editar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_EDITAR));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ID));
                    String idStr = input.nextLine();
                    long id = Long.parseLong(idStr);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PLACA));
                    String placa = input.nextLine();
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_ULTIMAREVISAO));
                    String dateStr1 = input.nextLine();
                    Date date1 = DateUtil.stringToDate(dateStr1);
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PROXIMAREVISAO));
                    String dateStr2 = input.nextLine();
                    Date date2 = DateUtil.stringToDate(dateStr2);
                                        
                    manutencao = facade.buscarManutencao(id);
                    
                    manutencao.setPlaca(placa);
                    manutencao.setUltimaRevisao(date1);
                    manutencao.setProximaRevisao(date2);
                    
                    facade.editarManutencao(manutencao);
                }
                else if(op2.equals("3")) { //Remover
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_REMOVER));
                    
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER_ID));
                    String idStr = input.nextLine();
                    long id = Long.parseLong(idStr);
                    
                    manutencao = facade.buscarManutencao(id);
                    
                    facade.removerManutencao(manutencao);
                }
                else if(op2.equals("4")) { //Listar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_LISTAR));
                    List<Manutencao> lista = facade.listarManutencao();
                    
                    if(lista.isEmpty())
                        System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTA_VAZIA));
                    else {
                        for(Manutencao m : lista)
                           System.out.println(m);
                    }
                }
            } else if(op1.equals("5")) { //Menu idioma
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_IDIOMA));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_IDIOMA_BR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_IDIOMA_EN));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_IDIOMA_FR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_SAIR));
                System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_ESCOLHA));
                
                op2 = input.nextLine();
                
                if(op2.equals("1")) {
                    MensagemUtil.setLocale(MensagemUtil.LOCALE_PT_BR);
                } else if(op2.equals("2")) {
                    MensagemUtil.setLocale(MensagemUtil.LOCALE_EN_US);
                } else if(op2.equals("3")) {
                    MensagemUtil.setLocale(MensagemUtil.LOCALE_FR_FR);
                }
            }
        } while (!op1.equals("0"));
    }
    
}
