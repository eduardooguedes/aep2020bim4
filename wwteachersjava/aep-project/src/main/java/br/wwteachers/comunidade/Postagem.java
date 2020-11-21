package br.wwteachers.comunidade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import br.wwteachers.valueObjects.Código;
import br.wwteachers.valueObjects.MomentoDataHora;


public class Postagem {

    private Código código;
    private String título;
    private String conteúdo;
    private MomentoDataHora momentoDataHora;
    private Disciplina disciplinaPrincipal;

    HashSet<Disciplina> listaDisciplinas = new HashSet<Disciplina>();

    public Postagem(String títuloPostagem, String conteúdoPostagem) {
        this.código = setCódigo();
        this.momentoDataHora = setMomento();
        this.título = títuloPostagem;
        this.conteúdo = conteúdoPostagem;
        this.disciplinaPrincipal = null;
    }
    
    
    public Postagem(String títuloPostagem, String conteúdoPostagem, Disciplina disciplina) {
        this(títuloPostagem, conteúdoPostagem);
        this.disciplinaPrincipal = disciplina;
    }
    
    public Postagem(String títuloPostagem, String conteúdoPostagem, HashSet<Disciplina> listaDisciplinaProfessor) {
        this(títuloPostagem, conteúdoPostagem);
        int x=0;
        for (Disciplina disciplina : listaDisciplinaProfessor) {
            adicionarDisciplina(disciplina);
            if(x == 0){ this.disciplinaPrincipal = disciplina; x = 1;}
        }
    }

    private Código setCódigo() {
        return new Código("Postagem");
    }

    public String getCódigo() {
        return this.código.getCodigo();
    }

    public String getTítulo(){
        return this.título;
    }

    public String getConteúdo(){
        return this.conteúdo;
    }

    public Disciplina getDisciplinaPrincipal(){
        return this.disciplinaPrincipal;
    }

    private void adicionarDisciplina(Disciplina disciplina) {
        this.listaDisciplinas.add(disciplina);
    }

    private MomentoDataHora setMomento() {
        return new MomentoDataHora();
    }

    public LocalDateTime getDataHoraAtual() {
        return momentoDataHora.getMomentoPadrao();
    }

}
