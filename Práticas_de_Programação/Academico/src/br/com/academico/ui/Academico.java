/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.ui;

import br.com.academico.facade.Facade;
import br.com.academico.model.Aluno;
import br.com.academico.model.Coordenador;
import br.com.academico.model.Curso;
import br.com.academico.model.Disciplina;
import br.com.academico.model.Estagio;
import br.com.academico.model.Instituicao;
import br.com.academico.model.Matricula;
import br.com.academico.model.Monitoria;
import br.com.academico.model.Professor;
import br.com.academico.model.ProjetoDeExtensao;
import br.com.academico.model.Secretaria;
import br.com.academico.model.Turma;
import br.com.academico.util.DateUtil;
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
        String op;
        String op2;

        Facade facade = new Facade();

        Aluno a;
        Curso c;
        Disciplina d;
        Coordenador co;
        Secretaria s;
        Professor p;
        Matricula m;
        ProjetoDeExtensao pe;
        Instituicao i;
        Turma t;
        Estagio e;
        Monitoria mo;

        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1 - ALUNO");
            System.out.println("2 - CURSO");
            System.out.println("3 - DISCIPLINA");
            System.out.println("4 - PROFESSOR");
            System.out.println("5 - COORDENADOR");
            System.out.println("6 - SECRETÁRIA");
            System.out.println("7 - MATRÍCULA");
            System.out.println("8 - PROJETO DE EXTENSÃO");
            System.out.println("9 - INSTITUIÇÃO");
            System.out.println("10 - TURMA");
            System.out.println("11 - ESTÁGIO");
            System.out.println("12 - MONITORIA");
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
                            System.out.println("REGISTRO GERAL:");
                            System.out.println("RG:");
                            a.getRg().setRg(input.nextLine());
                            System.out.println("DATA DE EXPEDIÇÃO:");
                            a.getRg().setDataExpedicao(DateUtil.stringToDate(input.nextLine()));
                            System.out.println("ÓRGÃO EMISSOR:");
                            a.getRg().setOrgaoEmissor(input.nextLine());

                            facade.salvarAluno(a);

                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR ALUNO ---");

                            System.out.println("ID:");
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
                                System.out.println("REGISTRO GERAL:");
                                System.out.println("NOVO RG:");
                                a.getRg().setRg(input.nextLine());
                                System.out.println("NOVO DATA DE EXPEDIÇÃO:");
                                a.getRg().setDataExpedicao(DateUtil.stringToDate(input.nextLine()));
                                System.out.println("NOVO ÓRGÃO EMISSOR:");
                                a.getRg().setOrgaoEmissor(input.nextLine());

                                facade.editarAluno(a);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR ALUNO ---");

                            a = new Aluno();

                            System.out.println("MATRÍCULA:");
                            a.setId(Integer.parseInt(input.nextLine()));

                            facade.excluirAluno(a);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR ALUNO ---");

                            List<Aluno> lista = facade.listarAluno();

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

                            facade.salvarCurso(c);

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

                                facade.editarCurso(c);

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

                            facade.excluirCurso(c);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR CURSO ---");

                            List<Curso> lista = facade.listarCurso();

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
                            System.out.println("EMENTA:");
                            System.out.println("SEMESTRE:");
                            d.getEmenta().setSemestre(input.nextLine());
                            System.out.println("CONTEÚDOS:");
                            d.getEmenta().setConteudos(input.nextLine());
                            System.out.println("QUANTIDADE DE AVALIAÇÕES:");
                            d.getEmenta().setQtdAvaliacoes(Integer.parseInt(input.nextLine()));

                            facade.salvarDisciplina(d);

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
                                System.out.println("EMENTA:");
                                System.out.println("NOVO SEMESTRE:");
                                d.getEmenta().setSemestre(input.nextLine());
                                System.out.println("NOVO CONTEÚDOS:");
                                d.getEmenta().setConteudos(input.nextLine());
                                System.out.println("NOVA QUANTIDADE DE AVALIAÇÕES:");
                                d.getEmenta().setQtdAvaliacoes(Integer.parseInt(input.nextLine()));

                                facade.editarDisciplina(d);

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

                            facade.excluirDisciplina(d);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR DISCIPLINAS ---");

                            List<Disciplina> lista = facade.listarDisciplina();

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

                            facade.salvarProfessor(p);

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

                                facade.editarProfessor(p);

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

                            facade.excluirProfessor(p);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR PROFESSORES ---");

                            List<Professor> lista = facade.listarProfessor();

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
                            System.out.println("--- CADASTRAR COORRDENADOR ---");

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

                            facade.salvarCoordenador(co);

                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR COORRDENADOR ---");

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

                                facade.editarCoordenador(co);

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

                            facade.excluirCoordenador(co);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR COORDENADORES ---");

                            List<Coordenador> lista = facade.listarCoordenador();

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

                            facade.salvarSecretaria(s);

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

                                facade.editarSecretaria(s);

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

                            facade.excluirSecretaria(s);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR SECRETARIA ---");

                            List<Secretaria> lista = facade.listarSecretaria();

                            for (Secretaria secretaria1 : lista) {
                                System.out.println(secretaria1);
                            }
                            break;
                    }
                    break;
                case "7":
                    System.out.println("1 - CADASTRAR MATRÍCULA");
                    System.out.println("2 - EDITAR MATRÍCULA");
                    System.out.println("3 - REMOVER MATRÍCULA");
                    System.out.println("4 - LISTAR MATRÍCULA");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();

                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR MATRÍCULA ---");

                            m = new Matricula();

                            // ler dados do usuário
                            System.out.println("MATRÍCULA:");
                            m.setMatricula(Integer.parseInt(input.nextLine()));
                            System.out.println("ALUNO:");
                            m.setAluno(input.nextLine());
                            System.out.println("CURSO:");
                            m.setCurso(input.nextLine());

                            facade.salvarMatricula(m);

                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR MATRÍCULA ---");

                            System.out.println("ID:");
                            m = facade.getPorIdMatricula(Integer.parseInt(input.nextLine()));

                            if (m != null) {
                                System.out.println("NOVA MATRÍCULA:");
                                m.setMatricula(Integer.parseInt(input.nextLine()));
                                System.out.println("NOVO ALUNO:");
                                m.setAluno(input.nextLine());
                                System.out.println("NOVO CURSO:");
                                m.setCurso(input.nextLine());

                                facade.editarMatricula(m);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR MATRÍCULA ---");

                            m = new Matricula();

                            System.out.println("ID:");
                            m.setId(Integer.parseInt(input.nextLine()));

                            facade.excluirMatricula(m);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR MATRÍCULA ---");

                            List<Matricula> lista = facade.listarMatricula();

                            for (Matricula matricula : lista) {
                                System.out.println(matricula);
                            }
                            break;
                    }
                    break;
                case "8":
                    System.out.println("1 - CADASTRAR PROJETO DE EXTENSÃO");
                    System.out.println("2 - EDITAR PROJETO DE EXTENSÃO");
                    System.out.println("3 - REMOVER PROJETO DE EXTENSÃO");
                    System.out.println("4 - LISTAR PROJETO DE EXTENSÃO");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();

                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR PROJETO DE EXTENSÃO ---");

                            pe = new ProjetoDeExtensao();

                            // ler dados do usuário
                            System.out.println("ALUNO:");
                            pe.setAluno(input.nextLine());
                            System.out.println("ORIENTADOR:");
                            pe.setOrientador(input.nextLine());
                            System.out.println("CURSO:");
                            pe.setCurso(input.nextLine());

                            facade.salvarProjetoDeExtensao(pe);

                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR PROJETO DE EXTENSÃO ---");

                            System.out.println("ID:");
                            pe = facade.getPorIdProjetoDeExtensao(Integer.parseInt(input.nextLine()));

                            if (pe != null) {
                                System.out.println("NOVO ALUNO:");
                                pe.setAluno(input.nextLine());
                                System.out.println("NOVO ORIENTADOR:");
                                pe.setOrientador(input.nextLine());
                                System.out.println("NOVO CURSO:");
                                pe.setCurso(input.nextLine());

                                facade.editarProjetoDeExtensao(pe);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR PROJETO DE EXTENSÃO ---");

                            pe = new ProjetoDeExtensao();

                            System.out.println("ID:");
                            pe.setId(Integer.parseInt(input.nextLine()));

                            facade.excluirProjetoDeExtensao(pe);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR PROJETO DE EXTENSÃO ---");

                            List<ProjetoDeExtensao> lista = facade.listarProjetoDeExtensao();

                            for (ProjetoDeExtensao projetoDeExtensao : lista) {
                                System.out.println(projetoDeExtensao);
                            }
                            break;
                    }
                    break;
                case "9":
                    System.out.println("1 - CADASTRAR INSTITUIÇÃO");
                    System.out.println("2 - EDITAR INSTITUIÇÃO");
                    System.out.println("3 - REMOVER INSTITUIÇÃO");
                    System.out.println("4 - LISTAR INSTITUIÇÃO");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();

                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR INSTITUIÇÃO ---");

                            i = new Instituicao();

                            // ler dados do usuário
                            System.out.println("NOME:");
                            i.setNome(input.nextLine());
                            System.out.println("LOCAL:");
                            i.setLocal(input.nextLine());

                            facade.salvarInstituicao(i);

                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR INSTITUIÇÃO ---");

                            System.out.println("ID:");
                            i = facade.getPorIdInstituicao(Integer.parseInt(input.nextLine()));

                            if (i != null) {
                                System.out.println("NOVO NOME:");
                                i.setNome(input.nextLine());
                                System.out.println("NOVO LOCAL:");
                                i.setLocal(input.nextLine());

                                facade.editarInstituicao(i);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR INSTITUIÇÃO---");

                            i = new Instituicao();

                            System.out.println("ID:");
                            i.setId(Integer.parseInt(input.nextLine()));

                            facade.excluirInstituicao(i);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR INSTITUIÇÃO ---");

                            List<Instituicao> lista = facade.listarInstituicao();

                            for (Instituicao instituicao1 : lista) {
                                System.out.println(instituicao1);
                            }
                            break;
                    }
                    break;
                case "10":
                    System.out.println("1 - CADASTRAR TURMA");
                    System.out.println("2 - EDITAR TURMA");
                    System.out.println("3 - REMOVER TURMA");
                    System.out.println("4 - LISTAR TURMA");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();

                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR TURMA ---");

                            t = new Turma();

                            // ler dados do usuário
                            System.out.println("DISCIPLINA:");
                            t.setDisciplina(input.nextLine());
                            System.out.println("PERÍODO:");
                            t.setPeriodo(input.nextLine());
                            System.out.println("CURSO:");
                            t.setCurso(input.nextLine());

                            facade.salvarTurma(t);

                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR TURMA ---");

                            System.out.println("ID:");
                            t = facade.getPorIdTurma(Integer.parseInt(input.nextLine()));

                            if (t != null) {
                                System.out.println("NOVA DISCIPLINA:");
                                t.setDisciplina(input.nextLine());
                                System.out.println("NOVO PERÍODO:");
                                t.setPeriodo(input.nextLine());
                                System.out.println("NOVO CURSO:");
                                t.setCurso(input.nextLine());

                                facade.editarTurma(t);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR TURMA---");

                            t = new Turma();

                            System.out.println("ID:");
                            t.setId(Integer.parseInt(input.nextLine()));

                            facade.excluirTurma(t);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR TURMA ---");

                            List<Turma> lista = facade.listarTurma();

                            for (Turma turma1 : lista) {
                                System.out.println(turma1);
                            }
                            break;
                    }
                    break;
                case "11":
                    System.out.println("1 - CADASTRAR ESTÁGIO");
                    System.out.println("2 - EDITAR ESTÁGIO");
                    System.out.println("3 - REMOVER ESTÁGIO");
                    System.out.println("4 - LISTAR ESTÁGIO");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();

                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR ESTÁGIO ---");

                            e = new Estagio();

                            // ler dados do usuário
                            System.out.println("ALUNO:");
                            e.setAluno(input.nextLine());
                            System.out.println("ORIENTADOR:");
                            e.setOrientador(input.nextLine());
                            System.out.println("CURSO:");
                            e.setCurso(input.nextLine());

                            facade.salvarEstagio(e);

                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR ESTÁGIO ---");

                            System.out.println("ID:");
                            e = facade.getPorIdEstagio(Integer.parseInt(input.nextLine()));

                            if (e != null) {
                                System.out.println("NOVA ALUNO:");
                                e.setAluno(input.nextLine());
                                System.out.println("NOVO ORIENTADOR:");
                                e.setOrientador(input.nextLine());
                                System.out.println("NOVO CURSO:");
                                e.setCurso(input.nextLine());

                                facade.editarEstagio(e);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR ESTÁGIO---");

                            e = new Estagio();

                            System.out.println("ID:");
                            e.setCodigo(Integer.parseInt(input.nextLine()));

                            facade.excluirEstagio(e);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR ESTÁGIO ---");

                            List<Estagio> lista = facade.listarEstagio();

                            for (Estagio estagio : lista) {
                                System.out.println(estagio);
                            }
                            break;
                    }
                    break;
                case "12":
                    System.out.println("1 - CADASTRAR MONITORIA");
                    System.out.println("2 - EDITAR MONITORIA");
                    System.out.println("3 - REMOVER MONITORIA");
                    System.out.println("4 - LISTAR MONITORIA");
                    System.out.println("5 - VOLTAR MENU PRINCIPAL");
                    System.out.println("QUAL SUA OPCAO?");
                    op2 = input.nextLine();

                    switch (op2) {
                        case "1":
                            System.out.println("--- CADASTRAR MONITORIA ---");

                            mo = new Monitoria();

                            // ler dados do usuário
                            System.out.println("ALUNO:");
                            mo.setAluno(input.nextLine());
                            System.out.println("DISCIPLINA:");
                            mo.setDisciplina(input.nextLine());
                            System.out.println("CURSO:");
                            mo.setCurso(input.nextLine());

                            facade.salvarMonitoria(mo);

                            System.out.println("REGISTRO SALVO COM SUCESSO!");
                            break;
                        case "2":
                            System.out.println("--- EDITAR MONITORIA ---");

                            System.out.println("ID:");
                            mo = facade.getPorIdMonitoria(Integer.parseInt(input.nextLine()));

                            if (mo != null) {
                                System.out.println("NOVO ALUNO:");
                                mo.setAluno(input.nextLine());
                                System.out.println("NOVA DISCIPLINA:");
                                mo.setDisciplina(input.nextLine());
                                System.out.println("NOVO CURSO:");
                                mo.setCurso(input.nextLine());

                                facade.editarMonitoria(mo);

                                System.out.println("REGISTRO EDITADO COM SUCESSO!");
                            } else {
                                System.out.println("REGISTRO NÃO ENCONTRADO!");
                            }
                            break;
                        case "3":
                            System.out.println("--- EXCLUIR MONITORIA---");

                            mo = new Monitoria();

                            System.out.println("ID:");
                            mo.setCodigo(Integer.parseInt(input.nextLine()));

                            facade.excluirMonitoria(mo);

                            System.out.println("REGISTRO REMOVIDO COM SUCESSO!");
                            break;
                        case "4":
                            System.out.println("--- LISTAR MONITORIA ---");

                            List<Monitoria> lista = facade.listarMonitoria();

                            for (Monitoria monitoria : lista) {
                                System.out.println(monitoria);
                            }
                            break;
                    }
                    break;
            }
        } while (!op.equals("0"));
    }
}
