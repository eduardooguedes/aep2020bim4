package classes;

import java.sql.Date;
import java.text.DateFormat;
import java.util.HashSet;

import javax.print.attribute.standard.DateTimeAtCreation;
import javax.swing.JOptionPane;

import valueObjects.*;

public class Postagem {
    
    private Código códigoPostagem;
    private String título;
    private String conteúdo;
    private String dataPostagem;  
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

    public void getDataHoraAtual(){
        java.util.Date d = new Date(0);
        this.dataPostagem = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        JOptionPane.showMessageDialog(null, "Hora "+ dataPostagem.toString() +" instanciada com sucesso ");
    }
    
}
