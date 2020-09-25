/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web2.facade;

import br.com.web2.dao.AlunoDAO;
import br.com.web2.dao.CoordenadorDAO;
import br.com.web2.dao.CursoDao;
import br.com.web2.dao.DisciplinaDao;
import br.com.web2.dao.ProfessorDao;
import br.com.web2.dao.SecretariaDao;
import br.com.web2.model.Aluno;
import br.com.web2.model.Coordenador;
import br.com.web2.model.Curso;
import br.com.web2.model.Disciplina;
import br.com.web2.model.Professor;
import br.com.web2.model.Secretaria;
import java.util.List;

/**
 *
 * @author ALL
 */
public class Facade {

    private AlunoDAO alunoDAO = new AlunoDAO();
    private CoordenadorDAO coordenadorDao = new CoordenadorDAO();
    private CursoDao cursoDAO = new CursoDao();
    private DisciplinaDao disciplinaDAO = new DisciplinaDao();
    private ProfessorDao professorDAO = new ProfessorDao();
    private SecretariaDao secretariaDAO = new SecretariaDao();

    // Aluno
    public void SalvarAluno(Aluno a) throws Exception {
        alunoDAO.inserir(a);
    }

    public void EditarAluno(Aluno a) throws Exception {
        alunoDAO.editar(a);
    }

    public void ExcluirAluno(Aluno a) throws Exception {
        alunoDAO.excluir(a);
    }

    public List<Aluno> ListarAluno() throws Exception {
        return alunoDAO.getLista();
    }
    
    public Aluno getPorIdAluno(int id) throws Exception {
        return alunoDAO.getPorId(id);
    }

    // Coordenador
    public void SalvarCoordenador(Coordenador c) throws Exception {
        coordenadorDao.inserir(c);
    }

    public void EditarCoordenador(Coordenador c) throws Exception {
        coordenadorDao.editar(c);
    }

    public void ExcluirCoordenador(Coordenador c) throws Exception {
        coordenadorDao.excluir(c);
    }

    public List<Coordenador> ListarCoordenador() throws Exception {
        return coordenadorDao.getLista();
    }
    
    public Coordenador getPorIdCoordenador(String id) throws Exception {
        return coordenadorDao.getPorId(id);
    }

    // Curso
    public void SalvarCurso(Curso c) throws Exception {
        cursoDAO.inserir(c);
    }

    public void EditarCurso(Curso c) throws Exception {
        cursoDAO.editar(c);
    }

    public void ExcluirCurso(Curso c) throws Exception {
        cursoDAO.excluir(c);
    }

    public List<Curso> ListarCurso() throws Exception {
        return cursoDAO.getLista();
    }
    
    public Curso getPorIdCurso(int id) throws Exception {
        return cursoDAO.getPorId(id);
    }

    // Disciplina
    public void SalvarDisciplina(Disciplina d) throws Exception {
        disciplinaDAO.inserir(d);
    }

    public void EditarDisciplina(Disciplina d) throws Exception {
        disciplinaDAO.editar(d);
    }

    public void ExcluirDisciplina(Disciplina d) throws Exception {
        disciplinaDAO.excluir(d);
    }

    public List<Disciplina> ListarDisciplina() throws Exception {
        return disciplinaDAO.getLista();
    }
    
    public Disciplina getPorIdDisciplina(int id) throws Exception {
        return disciplinaDAO.getPorId(id);
    }

    // Professor
    public void SalvarProfessor(Professor p) throws Exception {
        professorDAO.inserir(p);
    }

    public void EditarProfessor(Professor p) throws Exception {
        professorDAO.editar(p);
    }

    public void ExcluirProfessor(Professor p) throws Exception {
        professorDAO.excluir(p);
    }

    public List<Professor> ListarProfessor() throws Exception {
        return professorDAO.getLista();
    }
    
    public Professor getPorIdProfessor(String id) throws Exception {
        return professorDAO.getPorId(id);
    }

    // Secretaria
    public void SalvarSecretaria(Secretaria s) throws Exception {
        secretariaDAO.inserir(s);
    }

    public void EditarSecretaria(Secretaria s) throws Exception {
        secretariaDAO.editar(s);
    }

    public void ExcluirSecretaria(Secretaria s) throws Exception {
        secretariaDAO.excluir(s);
    }

    public List<Secretaria> ListarSecretaria() throws Exception {
        return secretariaDAO.getLista();
    }
    
    public Secretaria getPorIdSecretaria(String id) throws Exception {
        return secretariaDAO.getPorId(id);
    }

}
