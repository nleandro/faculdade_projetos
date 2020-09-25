/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.ui;

import br.com.pratica.projeto.facade.ClienteFacade;
import br.com.pratica.projeto.facade.CompraVeiculoFacade;
import br.com.pratica.projeto.facade.FuncionarioFacade;
import br.com.pratica.projeto.facade.ManutencaoFacade;
import br.com.pratica.projeto.facade.VeiculoFacade;
import br.com.pratica.projeto.facade.VendaVeiculoFacade;
import br.com.pratica.projeto.model.Cliente;
import br.com.pratica.projeto.model.CompraVeiculo;
import br.com.pratica.projeto.model.Funcionario;
import br.com.pratica.projeto.model.Manutencao;
import br.com.pratica.projeto.model.Veiculo;
import br.com.pratica.projeto.model.VendaVeiculo;
import br.com.pratica.projeto.util.DateUtil;
import br.com.pratica.projeto.util.MensagemUtil;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nellson
 */
public class Menu {
    
    public static void main(String[] args) {
        
        //Menu
        Scanner input = new Scanner(System.in);
        String op1 = "";
        String op2 = "";
        
        //Variáveis gerais
        String idStr = "";
        long id = 0;
        String dateStr = "";
        Date date = null;
        String dateStr1 = "";
        Date date1 = null;
        String placa = "";
        String modelo = "";
        String fabricante = "";
        String nome = "";
        String endereco = "";
        String telefoneStr = "";
        int telefone = 0;
        String salarioStr = "";
        int salario = 0;
        String cpfStr = "";
        int cpf = 0;
        String precoStr = "";
        int preco = 0;
        String comprador = "";
        String formaPagamento = "";
        
        //Veículo
        Veiculo veiculo = null;
        VeiculoFacade veiculoFacade = new VeiculoFacade();
        
        //Funcionário
        Funcionario funcionario = null;
        FuncionarioFacade funcionarioFacade = new FuncionarioFacade();
        
        //Cliente
        Cliente cliente = null;
        ClienteFacade clienteFacade = new ClienteFacade();
        
        //Venda de Veículo
        VendaVeiculo vendaVeiculo = null;
        VendaVeiculoFacade vendaVeiculoFacade = new VendaVeiculoFacade();
        
        //Compra de Veículo
        CompraVeiculo compraVeiculo = null;
        CompraVeiculoFacade compraVeiculoFacade = new CompraVeiculoFacade();
        
        //Manutenção de Veículo
        Manutencao manutencao = null;
        ManutencaoFacade manutencaoFacade = new ManutencaoFacade();
        
        do {
            //Menu principal
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_PRINCIPAL));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO1));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO2));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO3));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO4));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO5));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO6));
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_PRINCIPAL_OPCAO7));
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
                    placa = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_MODELO));
                    modelo = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_FABRICANTE));
                    fabricante = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_ANO));
                    dateStr = input.nextLine();
                    date = DateUtil.stringToDate(dateStr);
                    
                    veiculo = new Veiculo(placa, modelo, fabricante, date);
                    veiculoFacade.inserirVeiculo(veiculo);
                }
                else if(op2.equals("2")) { //Editar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_EDITAR));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_PLACA));
                    placa = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_MODELO));
                    modelo = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_FABRICANTE));
                    fabricante = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ANO));
                    dateStr = input.nextLine();
                    date = DateUtil.stringToDate(dateStr);
                    
                    veiculo = new Veiculo(id, placa, modelo, fabricante, date);
                    veiculoFacade.editarVeiculo(veiculo);
                }
                else if(op2.equals("3")) { //Remover
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_REMOVER));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    
                    veiculo = new Veiculo(id);
                    veiculoFacade.removerVeiculo(veiculo);
                }
                else if(op2.equals("4")) { //Listar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_LISTAR));
                    List<Veiculo> lista = veiculoFacade.listaVeiculo();
                    
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
                    nome = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_ENDERECO));
                    endereco = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_TELEFONE));
                    telefoneStr = input.nextLine();
                    telefone = Integer.parseInt(telefoneStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_DTNASCIMENTO));
                    dateStr = input.nextLine();
                    date = DateUtil.stringToDate(dateStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_SALARIO));
                    salarioStr = input.nextLine();
                    salario = Integer.parseInt(salarioStr);
                    
                    funcionario = new Funcionario(nome, endereco, telefone, date, salario);
                    funcionarioFacade.inserirFuncionario(funcionario);
                }
                else if(op2.equals("2")) { //Editar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_EDITAR));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_NOME));
                    nome = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ENDERECO));
                    endereco = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_TELEFONE));
                    telefoneStr = input.nextLine();
                    telefone = Integer.parseInt(telefoneStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_DTNASCIMENTO));
                    dateStr = input.nextLine();
                    date = DateUtil.stringToDate(dateStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_SALARIO));
                    salarioStr = input.nextLine();
                    salario = Integer.parseInt(salarioStr);
                    
                    funcionario = new Funcionario(id, nome, endereco, telefone, date, salario);
                    funcionarioFacade.editarFuncionario(funcionario);
                }
                else if(op2.equals("3")) { //Remover
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_REMOVER));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    
                    funcionario = new Funcionario(id);
                    funcionarioFacade.removerFuncionario(funcionario);
                }
                else if(op2.equals("4")) { //Listar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_LISTAR));
                    List<Funcionario> lista = funcionarioFacade.listaFuncionario();
                    
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
                    nome = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_CPF));
                    cpfStr = input.nextLine();
                    cpf = Integer.parseInt(cpfStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_ENDERECO));
                    endereco = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_TELEFONE));
                    telefoneStr = input.nextLine();
                    telefone = Integer.parseInt(telefoneStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_DTNASCIMENTO));
                    dateStr = input.nextLine();
                    date = DateUtil.stringToDate(dateStr);
                    
                    cliente = new Cliente(nome, cpf, endereco, telefone, date);
                    clienteFacade.inserirCliente(cliente);
                }
                else if(op2.equals("2")) { //Editar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_EDITAR));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_NOME));
                    nome = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_CPF));
                    cpfStr = input.nextLine();
                    cpf = Integer.parseInt(cpfStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ENDERECO));
                    endereco = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_TELEFONE));
                    telefoneStr = input.nextLine();
                    telefone = Integer.parseInt(telefoneStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_DTNASCIMENTO));
                    dateStr = input.nextLine();
                    date = DateUtil.stringToDate(dateStr);
                    
                    cliente = new Cliente(id, nome, cpf, endereco, telefone, date);
                    clienteFacade.editarCliente(cliente);
                }
                else if(op2.equals("3")) { //Remover
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_REMOVER));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    
                    cliente = new Cliente(id);
                    clienteFacade.removerCliente(cliente);
                }
                else if(op2.equals("4")) { //Listar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_LISTAR));
                    List<Cliente> lista = clienteFacade.listaCliente();
                    
                    if(lista.isEmpty())
                        System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTA_VAZIA));
                    else {
                        for(Cliente c : lista)
                           System.out.println(c);
                    }
                }
            } else if (op1.equals("4")) { //Menu Venda de Veículo
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_VENDAVEICULO));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_SAIR));
                System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_ESCOLHA));
                
                op2 = input.nextLine();
                
                if(op2.equals("1")) { //Inserir
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_INSERIR));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_MODELO));
                    modelo = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PRECO));
                    precoStr = input.nextLine();
                    preco = Integer.parseInt(precoStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_COMPRADOR));
                    comprador = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_FORMAPAGAMENTO));
                    formaPagamento = input.nextLine();
                                        
                    vendaVeiculo = new VendaVeiculo(modelo, preco, comprador, formaPagamento);
                    vendaVeiculoFacade.inserirVendaVeiculo(vendaVeiculo);
                }
                else if(op2.equals("2")) { //Editar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_EDITAR));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_MODELO));
                    modelo = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PRECO));
                    precoStr = input.nextLine();
                    preco = Integer.parseInt(precoStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_COMPRADOR));
                    comprador = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_FORMAPAGAMENTO));
                    formaPagamento = input.nextLine();
                                        
                    vendaVeiculo = new VendaVeiculo(id, modelo, preco, comprador, formaPagamento);
                    vendaVeiculoFacade.editarVendaVeiculo(vendaVeiculo);
                }
                else if(op2.equals("3")) { //Remover
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_REMOVER));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    
                    vendaVeiculo = new VendaVeiculo(id);
                    vendaVeiculoFacade.removerVendaVeiculo(vendaVeiculo);
                }
                else if(op2.equals("4")) { //Listar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_LISTAR));
                    List<VendaVeiculo> lista = vendaVeiculoFacade.listaVendaVeiculo();
                    
                    if(lista.isEmpty())
                        System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTA_VAZIA));
                    else {
                        for(VendaVeiculo v : lista)
                           System.out.println(v);
                    }
                }
            } else if (op1.equals("5")) { //Menu Compra de Veículo
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_COMPRAVEICULO));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTAR));
                System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_SAIR));
                System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_OPCAO_ESCOLHA));
                
                op2 = input.nextLine();
                
                if(op2.equals("1")) { //Inserir
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_INSERIR));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_FABRICANTE));
                    fabricante = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_MODELO));
                    modelo = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PRECO));
                    precoStr = input.nextLine();
                    preco = Integer.parseInt(precoStr);
                    
                    compraVeiculo = new CompraVeiculo(fabricante, modelo, preco);
                    compraVeiculoFacade.inserirCompraVeiculo(compraVeiculo);
                }
                else if(op2.equals("2")) { //Editar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_EDITAR));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_FABRICANTE));
                    fabricante = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_MODELO));
                    modelo = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PRECO));
                    precoStr = input.nextLine();
                    preco = Integer.parseInt(precoStr);
                    
                    compraVeiculo = new CompraVeiculo(id, fabricante, modelo, preco);
                    compraVeiculoFacade.editarCompraVeiculo(compraVeiculo);
                }
                else if(op2.equals("3")) { //Remover
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_REMOVER));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    
                    compraVeiculo = new CompraVeiculo(id);
                    compraVeiculoFacade.removerCompraVeiculo(compraVeiculo);
                }
                else if(op2.equals("4")) { //Listar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_LISTAR));
                    List<CompraVeiculo> lista = compraVeiculoFacade.listaCompraVeiculo();
                    
                    if(lista.isEmpty())
                        System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTA_VAZIA));
                    else {
                        for(CompraVeiculo c : lista)
                           System.out.println(c);
                    }
                }
            } else if (op1.equals("6")) { //Menu Manutenção
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
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_MODELO));
                    modelo = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_ULTIMAREVISAO));
                    dateStr = input.nextLine();
                    date = DateUtil.stringToDate(dateStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PROXIMAREVISAO));
                    dateStr1 = input.nextLine();
                    date1 = DateUtil.stringToDate(dateStr1);
                                        
                    manutencao = new Manutencao(modelo, date, date1);
                    manutencaoFacade.inserirManutencao(manutencao);
                }
                else if(op2.equals("2")) { //Editar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_EDITAR));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_EDITAR_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_MODELO));
                    modelo = input.nextLine();
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_ULTIMAREVISAO));
                    dateStr = input.nextLine();
                    date = DateUtil.stringToDate(dateStr);
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_INSERIR_PROXIMAREVISAO));
                    dateStr1 = input.nextLine();
                    date1 = DateUtil.stringToDate(dateStr1);
                                        
                    manutencao = new Manutencao(id, modelo, date, date1);
                    manutencaoFacade.editarManutencao(manutencao);
                }
                else if(op2.equals("3")) { //Remover
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_REMOVER));
                    System.out.print(MensagemUtil.getMensagem(MensagemUtil.MENU_REMOVER_ID));
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);
                    
                    manutencao = new Manutencao(id);
                    manutencaoFacade.removerManutencao(manutencao);
                }
                else if(op2.equals("4")) { //Listar
                    System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_TITULO_LISTAR));
                    List<Manutencao> lista = manutencaoFacade.listaManutencao();
                    
                    if(lista.isEmpty())
                        System.out.println(MensagemUtil.getMensagem(MensagemUtil.MENU_LISTA_VAZIA));
                    else {
                        for(Manutencao m : lista)
                           System.out.println(m);
                    }
                }
            } else if(op1.equals("7")) { //Menu idioma
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
