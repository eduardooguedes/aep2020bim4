package classes;

import java.sql.Date;
import java.util.HashSet;

import valueObjects.*;

public class Postagem {
    
    private Código códigoPostagem;
    private String títuloPostagem;
    private String conteúdoPostagem;
    private Date dataPostagem;  
    private Disciplina disciplinaPrincipal;

    HashSet<Disciplina> listaDisciplinas = new HashSet<Disciplina>();

    public Postagem(int códigoPostagem, String títuloPostagem, String conteúdoPostagem, HashSet<Disciplina> listaDisciplinaProfessor){
        this.códigoPostagem = new Código(códigoPostagem, "Postagem");
        this.títuloPostagem = títuloPostagem;
        this.conteúdoPostagem = conteúdoPostagem;
        //this.dataPostagem = dataAtual;
        this.disciplinaPrincipal = null;
        for(Disciplina disciplina : listaDisciplinaProfessor){
            adicionarDisciplina(disciplina);
        }
    }

    public Postagem(int códigoPostagem, String títuloPostagem, String conteúdoPostagem, Disciplina disciplina){
        this.disciplinaPrincipal = disciplina;
        this.códigoPostagem = new Código(códigoPostagem, "Postagem");
        this.títuloPostagem = títuloPostagem;
        this.conteúdoPostagem = conteúdoPostagem;
        //this.dataPostagem = dataAtual;
    }

    public Postagem(int códigoPostagem, String títuloPostagem, String conteúdoPostagem){
        this.disciplinaPrincipal = null;
        this.códigoPostagem = new Código(códigoPostagem, "Postagem");
        this.títuloPostagem = títuloPostagem;
        this.conteúdoPostagem = conteúdoPostagem;
        //this.dataPostagem = dataAtual;
    }

    private void adicionarDisciplina(Disciplina disciplina){
        this.listaDisciplinas.add(disciplina);
    }

}
