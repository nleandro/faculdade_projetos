/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.projeto.ui;

import br.com.praticas.projeto.dao.ClienteDAO;
import br.com.praticas.projeto.dao.FuncionarioDAO;
import br.com.praticas.projeto.dao.VeiculoDAO;
import br.com.praticas.projeto.model.Cliente;
import br.com.praticas.projeto.model.Funcionario;
import br.com.praticas.projeto.model.Veiculo;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nellson
 */
public class Menu {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws SQLException, ParseException {
        Scanner input = new Scanner(System.in);
        String op = "";
        String op1 = "";
        
        // Cliente, Funcionario, Veiculo
        String idStr = null;
        long id = 0;
        String nome = "";
        String telefoneStr = "";
        long telefone = 0;
        String date = "";
                
        // Cliente
        Cliente c;
        ClienteDAO daoCliente = new ClienteDAO();
        String endereco = "";
        
        // Funcionario
        Funcionario f;
        FuncionarioDAO daoFuncionario = new FuncionarioDAO();
        
        // Veiculo
        Veiculo v;
        VeiculoDAO daoVeiculo = new VeiculoDAO();
        String placa = "";
        String marca = "";
        String modelo = "";
        
        do {
            System.out.println("----MENU----");
            System.out.println("1 - INSERIR");
            System.out.println("2 - EDITAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - LISTAR");
            System.out.println("0 - SAIR");
            System.out.print("\nOPÇÃO: ");
            
            op = input.nextLine();
            
            if (op.equals("1")) {
                System.out.println("----INSERIR----");
                System.out.println("1 - CLIENTE");
                System.out.println("2 - FUNCIONARIO");
                System.out.println("3 - VEICULO");
                System.out.println("0 - VOLTAR");
                System.out.print("\nOPÇÃO: ");
                
                op1 = input.nextLine();
                
                if (op1.equals("1")) {
                    System.out.println("---INSERIR CLIENTE---");
                    System.out.print("Nome: ");
                    nome = input.nextLine();
                    System.out.print("Endereço: ");
                    endereco = input.nextLine();
                    System.out.print("Telefone: ");
                    telefoneStr = input.nextLine();
                    telefone = Long.parseLong(telefoneStr);
                    System.out.print("Data de Nascimento: ");
                    date = input.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    
                    c = new Cliente();
                    c.setNome(nome);
                    c.setEndereco(endereco);
                    c.setTelefone(telefone);
                    c.setDataNascimento(formatter.parse(date));

                    daoCliente.salvar(c);
                } else if (op1.equals("2")) {
                    System.out.println("---INSERIR FUNCIONARIO---");
                    System.out.print("Nome: ");
                    nome = input.nextLine();
                    System.out.print("Telefone: ");
                    telefoneStr = input.nextLine();
                    telefone = Long.parseLong(telefoneStr);
                    System.out.print("Data de Nascimento: ");
                    date = input.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    
                    f = new Funcionario();
                    f.setNome(nome);
                    f.setTelefone(telefone);
                    f.setDataNascimento(formatter.parse(date));

                    daoFuncionario.salvar(f);
                } else if (op1.equals("3")) {
                    System.out.println("---INSERIR VEICULO---");
                    System.out.print("Placa: ");
                    placa = input.nextLine();
                    System.out.print("Marca: ");
                    marca = input.nextLine();
                    System.out.print("Modelo: ");
                    modelo = input.nextLine();
                    System.out.print("Ano: ");
                    date = input.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
                    
                    v = new Veiculo();
                    v.setPlaca(placa);
                    v.setMarca(marca);
                    v.setModelo(modelo);
                    v.setAno(formatter.parse(date));

                    daoVeiculo.salvar(v);
                } else {
                    System.out.println("VOLTANDO...");
                }
            } else if (op.equals("2")) {
                System.out.println("----EDITAR----");
                System.out.println("1 - CLIENTE");
                System.out.println("2 - FUNCIONARIO");
                System.out.println("3 - VEICULO");
                System.out.println("0 - VOLTAR");
                System.out.print("\nOPÇÃO: ");
                
                op1 = input.nextLine();
                
                if (op1.equals("1")) {
                    System.out.println("---EDITAR CLIENTE---");
                    System.out.print("Id: ");
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);

                    System.out.print("Novo Nome: ");
                    nome = input.nextLine();
                    System.out.print("Novo Endereço: ");
                    endereco = input.nextLine();
                    System.out.print("Novo Telefone: ");
                    telefoneStr = input.nextLine();
                    telefone = Long.parseLong(telefoneStr);
                    System.out.print("Nova Data de Nascimento: ");
                    date = input.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                    c = new Cliente();
                    c.setId(id);
                    c.setNome(nome);
                    c.setEndereco(endereco);
                    c.setTelefone(telefone);
                    c.setDataNascimento(formatter.parse(date));

                    daoCliente.editar(c);

                    System.out.println("REGISTRO EDITADO COM SUCESSO!");
                } else if (op1.equals("2")) {
                    System.out.println("---EDITAR FUNCIONARIO---");
                    System.out.print("Id: ");
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);

                    System.out.print("Novo Nome: ");
                    nome = input.nextLine();
                    System.out.print("Novo Telefone: ");
                    telefoneStr = input.nextLine();
                    telefone = Long.parseLong(telefoneStr);
                    System.out.print("Nova Data de Nascimento: ");
                    date = input.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                    f = new Funcionario();
                    f.setId(id);
                    f.setNome(nome);
                    f.setTelefone(telefone);
                    f.setDataNascimento(formatter.parse(date));

                    daoFuncionario.editar(f);

                    System.out.println("REGISTRO EDITADO COM SUCESSO!");
                } else if (op1.equals("3")) {
                    System.out.println("---EDITAR VEICULO---");
                    System.out.print("Id: ");
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);

                    System.out.print("Nova Placa: ");
                    placa = input.nextLine();
                    System.out.print("Nova Marca: ");
                    marca = input.nextLine();
                    System.out.print("Novo Modelo: ");
                    modelo = input.nextLine();
                    System.out.print("Novo Ano: ");
                    date = input.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");

                    v = new Veiculo();
                    v.setId(id);
                    v.setPlaca(placa);
                    v.setMarca(marca);
                    v.setModelo(modelo);
                    v.setAno(formatter.parse(date));

                    daoVeiculo.editar(v);

                    System.out.println("REGISTRO EDITADO COM SUCESSO!");
                } else {
                    System.out.println("VOLTANDO...");
                }
            } else if (op.equals("3")) {
                System.out.println("----EXCLUIR----");
                System.out.println("1 - CLIENTE");
                System.out.println("2 - FUNCIONARIO");
                System.out.println("3 - VEICULO");
                System.out.println("0 - VOLTAR");
                System.out.print("\nOPÇÃO: ");
                
                op1 = input.nextLine();
                
                if (op1.equals("1")) {
                    System.out.println("---EXCLUIR CLIENTE---");
                    System.out.print("Id: ");
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);

                    c = new Cliente();
                    c.setId(id);
                    
                    daoCliente.excluir(c);

                    System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                } else if (op1.equals("2")) {
                    System.out.println("---EXCLUIR FUNCIONARIO---");
                    System.out.print("Id: ");
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);

                    f = new Funcionario();
                    f.setId(id);
                    
                    daoFuncionario.excluir(f);

                    System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                } else if (op1.equals("3")) {
                    System.out.println("---EXCLUIR VEICULO---");
                    System.out.print("Id: ");
                    idStr = input.nextLine();
                    id = Long.parseLong(idStr);

                    v = new Veiculo();
                    v.setId(id);
                    
                    daoVeiculo.excluir(v);

                    System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                } else {
                    System.out.println("VOLTANDO...");
                }
            } else if (op.equals("4")) {
                System.out.println("----LISTAR----");
                System.out.println("1 - CLIENTE");
                System.out.println("2 - FUNCIONARIO");
                System.out.println("3 - VEICULO");
                System.out.println("0 - VOLTAR");
                System.out.print("\nOPÇÃO: ");
                
                op1 = input.nextLine();
                
                if (op1.equals("1")) {
                    System.out.println("---LISTAR CLIENTE---");
                    List<Cliente> lista = daoCliente.listar();
                    
                    for (Cliente cliente : lista) {
                        System.out.println(cliente);
                    }
                } else if (op1.equals("2")) {
                    System.out.println("---LISTAR FUNCIONARIO---");
                    List<Funcionario> lista = daoFuncionario.listar();
                    
                    for (Funcionario funcionario : lista) {
                        System.out.println(funcionario);
                    }
                } else if (op1.equals("3")) {
                    System.out.println("---LISTAR VEICULO---");
                    List<Veiculo> lista = daoVeiculo.listar();
                    
                    for (Veiculo veiculo : lista) {
                        System.out.println(veiculo);
                    }
                } else {
                    System.out.println("VOLTANDO...");
                }
            } else {
                System.out.println("SAINDO...");
            }
        } while (!op.equals("0"));
    }
    
}