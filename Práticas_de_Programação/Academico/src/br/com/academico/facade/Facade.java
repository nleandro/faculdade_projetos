/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.facade;

import br.com.academico.dao.AlunoDao;
import br.com.academico.dao.CoordenadorDao;
import br.com.academico.dao.CursoDao;
import br.com.academico.dao.DisciplinaDao;
import br.com.academico.dao.EstagioDAO;
import br.com.academico.dao.InstituicaoDao;
import br.com.academico.dao.MatriculaDao;
import br.com.academico.dao.MonitoriaDao;
import br.com.academico.dao.ProfessorDao;
import br.com.academico.dao.ProjetoDeExtensaoDao;
import br.com.academico.dao.SecretariaDao;
import br.com.academico.dao.TurmaDao;
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
import java.util.List;

/**
 *
 * @author Nellson
 */
public class Facade {

    private AlunoDao alunoDao = new AlunoDao();
    private CoordenadorDao coordenadorDao = new CoordenadorDao();
    private CursoDao cursoDao = new CursoDao();
    private DisciplinaDao disciplinaDao = new DisciplinaDao();
    private ProfessorDao professorDao = new ProfessorDao();
    private SecretariaDao secretariaDao = new SecretariaDao();
    private MatriculaDao matriculaDao = new MatriculaDao();
    private ProjetoDeExtensaoDao projetoDeExtensaoDao = new ProjetoDeExtensaoDao();
    private TurmaDao turmaDAO = new TurmaDao();
    private InstituicaoDao instituicaoDAO = new InstituicaoDao();
    private EstagioDAO estagioDao = new EstagioDAO();
    private MonitoriaDao monitoriaDao = new MonitoriaDao();

    // Aluno
    public void salvarAluno(Aluno a) throws Exception {
        alunoDao.inserir(a);
    }

    public void editarAluno(Aluno a) throws Exception {
        alunoDao.editar(a);
    }

    public void excluirAluno(Aluno a) throws Exception {
        alunoDao.excluir(a);
    }

    public List<Aluno> listarAluno() throws Exception {
        return alunoDao.getLista();
    }

    public Aluno getPorIdAluno(int id) throws Exception {
        return alunoDao.getPorId(id);
    }

    // Coordenador
    public void salvarCoordenador(Coordenador c) throws Exception {
        coordenadorDao.inserir(c);
    }

    public void editarCoordenador(Coordenador c) throws Exception {
        coordenadorDao.editar(c);
    }

    public void excluirCoordenador(Coordenador c) throws Exception {
        coordenadorDao.excluir(c);
    }

    public List<Coordenador> listarCoordenador() throws Exception {
        return coordenadorDao.getLista();
    }

    public Coordenador getPorIdCoordenador(String id) throws Exception {
        return coordenadorDao.getPorId(id);
    }

    // Curso
    public void salvarCurso(Curso c) throws Exception {
        cursoDao.inserir(c);
    }

    public void editarCurso(Curso c) throws Exception {
        cursoDao.editar(c);
    }

    public void excluirCurso(Curso c) throws Exception {
        cursoDao.excluir(c);
    }

    public List<Curso> listarCurso() throws Exception {
        return cursoDao.getLista();
    }

    public Curso getPorIdCurso(int id) throws Exception {
        return cursoDao.getPorId(id);
    }

    // Disciplina
    public void salvarDisciplina(Disciplina d) throws Exception {
        disciplinaDao.inserir(d);
    }

    public void editarDisciplina(Disciplina d) throws Exception {
        disciplinaDao.editar(d);
    }

    public void excluirDisciplina(Disciplina d) throws Exception {
        disciplinaDao.excluir(d);
    }

    public List<Disciplina> listarDisciplina() throws Exception {
        return disciplinaDao.getLista();
    }

    public Disciplina getPorIdDisciplina(int id) throws Exception {
        return disciplinaDao.getPorId(id);
    }

    // Professor
    public void salvarProfessor(Professor p) throws Exception {
        professorDao.inserir(p);
    }

    public void editarProfessor(Professor p) throws Exception {
        professorDao.editar(p);
    }

    public void excluirProfessor(Professor p) throws Exception {
        professorDao.excluir(p);
    }

    public List<Professor> listarProfessor() throws Exception {
        return professorDao.getLista();
    }

    public Professor getPorIdProfessor(String id) throws Exception {
        return professorDao.getPorId(id);
    }

    // Secretaria
    public void salvarSecretaria(Secretaria s) throws Exception {
        secretariaDao.inserir(s);
    }

    public void editarSecretaria(Secretaria s) throws Exception {
        secretariaDao.editar(s);
    }

    public void excluirSecretaria(Secretaria s) throws Exception {
        secretariaDao.excluir(s);
    }

    public List<Secretaria> listarSecretaria() throws Exception {
        return secretariaDao.getLista();
    }

    public Secretaria getPorIdSecretaria(String id) throws Exception {
        return secretariaDao.getPorId(id);
    }

    // Matricula
    public void salvarMatricula(Matricula m) throws Exception {
        matriculaDao.inserir(m);
    }

    public void editarMatricula(Matricula m) throws Exception {
        matriculaDao.editar(m);
    }

    public void excluirMatricula(Matricula m) throws Exception {
        matriculaDao.excluir(m);
    }

    public List<Matricula> listarMatricula() throws Exception {
        return matriculaDao.getLista();
    }

    public Matricula getPorIdMatricula(int id) throws Exception {
        return matriculaDao.getPorId(id);
    }

    // Projeto de Extensão
    public void salvarProjetoDeExtensao(ProjetoDeExtensao p) throws Exception {
        projetoDeExtensaoDao.inserir(p);
    }

    public void editarProjetoDeExtensao(ProjetoDeExtensao p) throws Exception {
        projetoDeExtensaoDao.editar(p);
    }

    public void excluirProjetoDeExtensao(ProjetoDeExtensao p) throws Exception {
        projetoDeExtensaoDao.excluir(p);
    }

    public List<ProjetoDeExtensao> listarProjetoDeExtensao() throws Exception {
        return projetoDeExtensaoDao.getLista();
    }

    public ProjetoDeExtensao getPorIdProjetoDeExtensao(int id) throws Exception {
        return projetoDeExtensaoDao.getPorId(id);
    }

    //Turma 
    public void salvarTurma(Turma t) throws Exception {
        turmaDAO.inserir(t);
    }

    public void editarTurma(Turma t) throws Exception {
        turmaDAO.editar(t);
    }

    public void excluirTurma(Turma t) throws Exception {
        turmaDAO.excluir(t);
    }

    public List<Turma> listarTurma() throws Exception {
        return turmaDAO.getLista();
    }

    public Turma getPorIdTurma(int id) throws Exception {
        return turmaDAO.getPorId(id);
    }

    //Instituição
    public void salvarInstituicao(Instituicao i) throws Exception {
        instituicaoDAO.inserir(i);
    }

    public void editarInstituicao(Instituicao i) throws Exception {
        instituicaoDAO.editar(i);
    }

    public void excluirInstituicao(Instituicao i) throws Exception {
        instituicaoDAO.excluir(i);
    }

    public List<Instituicao> listarInstituicao() throws Exception {
        return instituicaoDAO.getLista();
    }

    public Instituicao getPorIdInstituicao(int id) throws Exception {
        return instituicaoDAO.getPorId(id);
    }

    // Estagio
    public void salvarEstagio(Estagio e) throws Exception {
        estagioDao.inserir(e);
    }

    public void editarEstagio(Estagio e) throws Exception {
        estagioDao.editar(e);
    }

    public void excluirEstagio(Estagio e) throws Exception {
        estagioDao.excluir(e);
    }

    public List<Estagio> listarEstagio() throws Exception {
        return estagioDao.getLista();
    }

    public Estagio getPorIdEstagio(int codigo) throws Exception {
        return estagioDao.getPorId(codigo);
    }

    // Monitoria
    public void salvarMonitoria(Monitoria m) throws Exception {
        monitoriaDao.inserir(m);
    }

    public void editarMonitoria(Monitoria m) throws Exception {
        monitoriaDao.editar(m);
    }

    public void excluirMonitoria(Monitoria m) throws Exception {
        monitoriaDao.excluir(m);
    }

    public List<Monitoria> listarMonitoria() throws Exception {
        return monitoriaDao.getLista();
    }

    public Monitoria getPorIdMonitoria(int codigo) throws Exception {
        return monitoriaDao.getPorId(codigo);
    }
}
