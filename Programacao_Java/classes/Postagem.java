package classes;

import java.sql.Date;
import java.util.HashSet;

import valueObjects.*;

public class Postagem {
    
    private Código códigoPostagem;
    private String título;
    private String conteúdo;
    private Date dataPostagem;  
    private Disciplina disciplinaPrincipal;

    HashSet<Disciplina> listaDisciplinas = new HashSet<Disciplina>();

    public Postagem(String títuloPostagem, String conteúdoPostagem, HashSet<Disciplina> listaDisciplinaProfessor){
        this.códigoPostagem = new Código("Postagem");
        this.título = títuloPostagem;
        this.conteúdo = conteúdoPostagem;
        //this.dataPostagem = dataAtual;
        this.disciplinaPrincipal = null;
        for(Disciplina disciplina : listaDisciplinaProfessor){
            adicionarDisciplina(disciplina);
        }
    }

    public Postagem(String títuloPostagem, String conteúdoPostagem, Disciplina disciplina){
        this.disciplinaPrincipal = disciplina;
        this.códigoPostagem = new Código("Postagem");
        this.título = títuloPostagem;
        this.conteúdo = conteúdoPostagem;
        //this.dataPostagem = dataAtual;
    }

    public Postagem(String títuloPostagem, String conteúdoPostagem){
        this.disciplinaPrincipal = null;
        this.códigoPostagem = new Código("Postagem");
        this.título = títuloPostagem;
        this.conteúdo = conteúdoPostagem;
        //this.dataPostagem = dataAtual;
    }

    private void adicionarDisciplina(Disciplina disciplina){
        this.listaDisciplinas.add(disciplina);
    }

}
