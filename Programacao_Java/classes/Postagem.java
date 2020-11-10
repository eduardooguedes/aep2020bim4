package classes;

import java.sql.Date;
import java.text.DateFormat;
import java.util.HashSet;

import javax.print.attribute.standard.DateTimeAtCreation;
import javax.swing.JOptionPane;

import valueObjects.*;

public class Postagem {

    private Código código;
    private String título;
    private String conteúdo;
    private MomentoDataHora momento;
    private Disciplina disciplinaPrincipal;

    HashSet<Disciplina> listaDisciplinas = new HashSet<Disciplina>();

    public Postagem(String títuloPostagem, String conteúdoPostagem, HashSet<Disciplina> listaDisciplinaProfessor) {
        this.código = setCódigo();
        this.título = títuloPostagem;
        this.conteúdo = conteúdoPostagem;
        this.momento = setMomento();
        this.disciplinaPrincipal = null;
        for (Disciplina disciplina : listaDisciplinaProfessor) {
            adicionarDisciplina(disciplina);
        }
    }

    public Postagem(String títuloPostagem, String conteúdoPostagem, Disciplina disciplina) {
        this.disciplinaPrincipal = disciplina;
        this.código = setCódigo();
        this.título = títuloPostagem;
        this.conteúdo = conteúdoPostagem;
        this.momento = setMomento();
    }

    public Postagem(String títuloPostagem, String conteúdoPostagem) {
        this.disciplinaPrincipal = null;
        this.código = setCódigo();
        this.título = títuloPostagem;
        this.conteúdo = conteúdoPostagem;
        this.momento = setMomento();
    }

    private Código setCódigo() {
        return new Código("Postagem");
    }

    public String getCódigo(){
        return this.código.getCodigo();
    }


    private void adicionarDisciplina(Disciplina disciplina) {
        this.listaDisciplinas.add(disciplina);
    }

    private MomentoDataHora setMomento(){
        return new MomentoDataHora();
    }

    public String getDataHoraAtual() {
        return momento.getMomento();
        // java.util.Date d = new Date(0);
        // this.momento = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        // JOptionPane.showMessageDialog(null, "Hora " + momento.toString() + " instanciada com sucesso ");
    }

}
