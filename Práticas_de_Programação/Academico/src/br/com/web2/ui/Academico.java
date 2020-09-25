/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web2.ui;

import br.com.web2.facade.Facade;
import br.com.web2.model.Aluno;
import br.com.web2.model.Coordenador;
import br.com.web2.model.Curso;
import br.com.web2.model.Disciplina;
import br.com.web2.model.Professor;
import br.com.web2.model.Secretaria;
import br.com.web2.util.DateUtil;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nellson
 */
public class Academico {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        String op = "";
        String op2 = "";

        Facade facade = new Facade();

        Aluno a;
        Curso c;
        Disciplina d;
        Coordenador co;
        Secretaria s;
        Professor p;

        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1 - ALUNO");
            System.out.println("2 - CURSO");
            System.out.println("3 - DISCIPLINA");
            System.out.println("4 - PROFESSOR");
            System.out.println("5 - COORDENADOR");
            System.out.println("6 - SECRETÁRIA");
            System.out.println("0 - SAIR");
            op = input.nextLine();

            switch (op) {
                case "1":
                    System.out.println("1 - CADASTRAR ALUNO");
                    System.out.println("2 - EDITAR ALUNO");
                    System.out.println("3 - REMOVER ALUNO");
                    System.out.println("4 - LISTAR ALUNOS");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL ");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();
                    
                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR ALUNO ---");
                            
                            a = new Aluno();
                            
                            // ler dados do usuário
                            System.out.println("NOME:");
                            a.setNome(input.nextLine());
                            System.out.println("E-MAIL:");
                            a.setEmail(input.nextLine());
                            System.out.println("DATA DE NASCIMENTO:");
                            a.setDataNascimento(DateUtil.stringToDate(input.nextLine()));
                            System.out.println("CURSO:");
                            a.setCurso(input.nextLine());
                            System.out.println("PERÍODO:");
                            a.setPeriodo(input.nextLine());
                            System.out.println("RG:");
                            a.getRg().setRg(input.nextLine());
                            System.out.println("DATA DE EXPEDIÇÃO:");
                            a.getRg().setDataExpedicao(DateUtil.stringToDate(input.nextLine()));
                            System.out.println("ÓRGÃO EMISSOR:");
                            a.getRg().setOrgaoEmissor(input.nextLine());
                            
                            facade.SalvarAluno(a);
                            
                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR ALUNO ---");
                            
                            System.out.println("MATRÍCULA:");
                            a = facade.getPorIdAluno(Integer.parseInt(input.nextLine()));
                            
                            if (a != null) {
                                System.out.println("NOVO NOME:");
                                a.setNome(input.nextLine());
                                System.out.println("NOVO E-MAIL:");
                                a.setEmail(input.nextLine());
                                System.out.println("DATA DE NASCIMENTO:");
                                a.setDataNascimento(DateUtil.stringToDate(input.nextLine()));
                                System.out.println("CURSO:");
                                a.setCurso(input.nextLine());
                                System.out.println("PERÍODO:");
                                a.setPeriodo(input.nextLine());
                                System.out.println("NOVO RG:");
                                a.getRg().setRg(input.nextLine());
                                System.out.println("NOVO DATA DE EXPEDIÇÃO:");
                                a.getRg().setDataExpedicao(DateUtil.stringToDate(input.nextLine()));
                                System.out.println("NOVO ÓRGÃO EMISSOR:");
                                a.getRg().setOrgaoEmissor(input.nextLine());

                                facade.EditarAluno(a);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR ALUNO ---");
                            
                            a = new Aluno();
                            
                            System.out.println("MATRÍCULA:");
                            a.setMatricula(Integer.parseInt(input.nextLine()));
                            
                            facade.ExcluirAluno(a);
                            
                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR ALUNO ---");
                            
                            List<Aluno> lista = facade.ListarAluno();
                            
                            for (Aluno aluno : lista) {
                                System.out.println(aluno);
                            }
                            break;
                    }
                    break;
                case "2":
                    System.out.println("1 - CADASTRAR CURSO");
                    System.out.println("2 - EDITAR CURSO");
                    System.out.println("3 - REMOVER CURSO");
                    System.out.println("4 - LISTAR CURSO");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL ");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();
                    
                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR CURSO ---");
                            
                            c = new Curso();
                            
                            // ler dados do usuário
                            System.out.println("NOME:");
                            c.setNome(input.nextLine());
                            System.out.println("NOME DO COORDENADOR:");
                            c.setNomeCoordenador(input.nextLine());
                            
                            facade.SalvarCurso(c);
                            
                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR CURSO ---");
                            
                            System.out.println("CÓDIGO:");
                            c = facade.getPorIdCurso(Integer.parseInt(input.nextLine()));
                            
                            if (c != null) {
                                System.out.println("NOVO NOME:");
                                c.setNome(input.nextLine());
                                System.out.println("NOVO NOME DO COORDENADOR:");
                                c.setNomeCoordenador(input.nextLine());

                                facade.EditarCurso(c);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR CURSO ---");
                            
                            c = new Curso();
                            
                            System.out.println("CÓDIGO:");
                            c.setCodigo(Integer.parseInt(input.nextLine()));
                            
                            facade.ExcluirCurso(c);
                            
                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR CURSO ---");
                            
                            List<Curso> lista = facade.ListarCurso();
                            
                            for (Curso curso1 : lista) {
                                System.out.println(curso1);
                            }
                            break;
                    }
                    break;
                case "3":
                    System.out.println("1 - CADASTRAR DISCIPLINA");
                    System.out.println("2 - EDITAR DISCIPLINA");
                    System.out.println("3 - REMOVER DISCIPLINA");
                    System.out.println("4 - LISTAR DISCIPLINA");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL ");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();
                    
                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR DISCIPLINA ---");
                            
                            d = new Disciplina();
                            
                            // ler dados do usuário
                            System.out.println("NOME:");
                            d.setNome(input.nextLine());
                            System.out.println("MINISTRADOR:");
                            d.setMinistrador(input.nextLine());
                            System.out.println("CARGA HORÁRIA:");
                            d.setCargaHoraria(input.nextLine());
                            System.out.println("SEMESTRE:");
                            d.getEmenta().setSemestre(input.nextLine());
                            System.out.println("CONTEÚDOS:");
                            d.getEmenta().setConteudos(input.nextLine());
                            System.out.println("QUANTIDADE DE AVALIAÇÕES:");
                            d.getEmenta().setQtdAvaliacoes(Integer.parseInt(input.nextLine()));
                            
                            facade.SalvarDisciplina(d);
                            
                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR DISCIPLINA ---");
                            
                            System.out.println("CÓDIGO:");
                            d = facade.getPorIdDisciplina(Integer.parseInt(input.nextLine()));
                            
                            if (d != null) {
                                System.out.println("NOVO NOME:");
                                d.setNome(input.nextLine());
                                System.out.println("NOVO MINISTRADOR:");
                                d.setMinistrador(input.nextLine());
                                System.out.println("NOVA CARGA HORÁRIA:");
                                d.setCargaHoraria(input.nextLine());
                                System.out.println("NOVO SEMESTRE:");
                                d.getEmenta().setSemestre(input.nextLine());
                                System.out.println("NOVO CONTEÚDOS:");
                                d.getEmenta().setConteudos(input.nextLine());
                                System.out.println("NOVA QUANTIDADE DE AVALIAÇÕES:");
                                d.getEmenta().setQtdAvaliacoes(Integer.parseInt(input.nextLine()));

                                facade.EditarDisciplina(d);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR DISCIPLINA ---");
                            
                            d = new Disciplina();
                            
                            System.out.println("CÓDIGO:");
                            d.setCodigo(Integer.parseInt(input.nextLine()));
                            
                            facade.ExcluirDisciplina(d);
                            
                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR DISCIPLINAS ---");
                            
                            List<Disciplina> lista = facade.ListarDisciplina();
                            
                            for (Disciplina disciplina : lista) {
                                System.out.println(disciplina);
                            }
                            break;
                    }
                    break;
                case "4":
                    System.out.println("1 - CADASTRAR PROFESSOR");
                    System.out.println("2 - EDITAR PROFESSOR");
                    System.out.println("3 - REMOVER PROFESSOR");
                    System.out.println("4 - LISTAR PROFESSORES");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();
                    
                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR PROFESSOR ---");
                            
                            p = new Professor();
                            
                            // ler dados do usuário
                            System.out.println("CPF:");
                            p.setCpf(input.nextLine());
                            System.out.println("NOME:");
                            p.setNome(input.nextLine());
                            System.out.println("SALÁRIO:");
                            p.setSalario(input.nextLine());
                            System.out.println("TITULAÇÃO:");
                            p.setTitulacao(input.nextLine());
                            System.out.println("ENDERECO");
                            System.out.println("RUA:");
                            p.getEndereco().setRua(input.nextLine());
                            System.out.println("NÚMERO:");
                            p.getEndereco().setNumero(input.nextLine());
                            System.out.println("BAIRRO:");
                            p.getEndereco().setBairro(input.nextLine());
                            System.out.println("CIDADE:");
                            p.getEndereco().setCidade(input.nextLine());
                            System.out.println("ESTADO (UF):");
                            p.getEndereco().setUf(input.nextLine());
                            
                            facade.SalvarProfessor(p);
                            
                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR PROFESSOR ---");
                            
                            System.out.println("CPF:");
                            p = facade.getPorIdProfessor(input.nextLine());
                            
                            if (p != null) {
                                System.out.println("NOVO NOME:");
                                p.setNome(input.nextLine());
                                System.out.println("NOVO SALÁRIO:");
                                p.setSalario(input.nextLine());
                                System.out.println("NOVA TITULAÇÃO:");
                                p.setTitulacao(input.nextLine());
                                System.out.println("NOVO ENDERECO");
                                System.out.println("NOVA RUA:");
                                p.getEndereco().setRua(input.nextLine());
                                System.out.println("NOVO NÚMERO:");
                                p.getEndereco().setNumero(input.nextLine());
                                System.out.println("NOVO BAIRRO:");
                                p.getEndereco().setBairro(input.nextLine());
                                System.out.println("NOVA CIDADE:");
                                p.getEndereco().setCidade(input.nextLine());
                                System.out.println("NOVO ESTADO (UF):");
                                p.getEndereco().setUf(input.nextLine());

                                facade.EditarProfessor(p);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR PROFESSOR ---");
                            
                            p = new Professor();
                            
                            System.out.println("CPF:");
                            p.setCpf(input.nextLine());
                            
                            facade.ExcluirProfessor(p);
                            
                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR PROFESSORES ---");
                            
                            List<Professor> lista = facade.ListarProfessor();
                            
                            for (Professor professor1 : lista) {
                                System.out.println(professor1);
                            }
                            break;
                    }
                    break;
                case "5":
                    System.out.println("1 - CADASTRAR COORDENADOR");
                    System.out.println("2 - EDITAR COORDENADOR");
                    System.out.println("3 - REMOVER COORDENADOR");
                    System.out.println("4 - LISTAR COORDENADOR");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();
                    
                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR PROFESSOR ---");
                            
                            co = new Coordenador();
                            
                            // ler dados do usuário
                            System.out.println("CPF:");
                            co.setCpf(input.nextLine());
                            System.out.println("NOME:");
                            co.setNome(input.nextLine());
                            System.out.println("SALÁRIO:");
                            co.setSalario(input.nextLine());
                            System.out.println("FORMACAO:");
                            co.setFormacao(input.nextLine());
                            System.out.println("ATUACAO:");
                            co.setAtuacao(input.nextLine());
                            
                            facade.SalvarCoordenador(co);
                            
                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR PROFESSOR ---");
                            
                            System.out.println("CPF:");
                            co = facade.getPorIdCoordenador(input.nextLine());
                            
                            if (co != null) {
                                System.out.println("NOVO NOME:");
                                co.setNome(input.nextLine());
                                System.out.println("NOVO SALÁRIO:");
                                co.setSalario(input.nextLine());
                                System.out.println("NOVA FORMACAO:");
                                co.setFormacao(input.nextLine());
                                System.out.println("NOVA ATUACAO:");
                                co.setAtuacao(input.nextLine());

                                facade.EditarCoordenador(co);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR COORRDENADOR ---");
                            
                            co = new Coordenador();
                            
                            System.out.println("CPF:");
                            co.setCpf(input.nextLine());
                            
                            facade.ExcluirCoordenador(co);
                            
                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR COORDENADORES ---");
                            
                            List<Coordenador> lista = facade.ListarCoordenador();
                            
                            for (Coordenador coordenador1 : lista) {
                                System.out.println(coordenador1);
                            }
                            break;
                    }
                    break;
                case "6":
                    System.out.println("1 - CADASTRAR SECRETÁRIA");
                    System.out.println("2 - EDITAR SECRETÁRIA");
                    System.out.println("3 - REMOVER SECRETÁRIA");
                    System.out.println("4 - LISTAR SECRETÁRIA");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();
                    
                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR SECRETARIA ---");
                            
                            s = new Secretaria();
                            
                            // ler dados do usuário
                            System.out.println("CPF:");
                            s.setCpf(input.nextLine());
                            System.out.println("NOME:");
                            s.setNome(input.nextLine());
                            System.out.println("SALÁRIO:");
                            s.setSalario(input.nextLine());
                            System.out.println("QUALIFICACAO:");
                            s.setQualificacao(input.nextLine());
                            System.out.println("IDIOMA:");
                            s.setIdioma(input.nextLine());
                            
                            facade.SalvarSecretaria(s);
                            
                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR SECRETARIA ---");
                            
                            System.out.println("CPF:");
                            s = facade.getPorIdSecretaria(input.nextLine());
                            
                            if (s != null) {
                                System.out.println("NOVO NOME:");
                                s.setNome(input.nextLine());
                                System.out.println("NOVO SALÁRIO:");
                                s.setSalario(input.nextLine());
                                System.out.println("NOVA QUALIFICACAO:");
                                s.setQualificacao(input.nextLine());
                                System.out.println("NOVO IDIOMA:");
                                s.setIdioma(input.nextLine());

                                facade.EditarSecretaria(s);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR SECRETARIA ---");
                            
                            s = new Secretaria();
                            
                            System.out.println("CPF:");
                            s.setCpf(input.nextLine());
                            
                            facade.ExcluirSecretaria(s);
                            
                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR SECRETARIA ---");
                            
                            List<Secretaria> lista = facade.ListarSecretaria();
                            
                            for (Secretaria secretaria1 : lista) {
                                System.out.println(secretaria1);
                            }
                            break;
                    }
                    break;
            }
        } while (!op.equals("0"));
    }

}
