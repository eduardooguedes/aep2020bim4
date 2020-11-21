package br.wwteachers.professor;

import java.sql.Date;
import java.util.HashSet;

import br.wwteachers.chat.Chat;
import br.wwteachers.comunidade.Disciplina;
import br.wwteachers.comunidade.Postagem;
import br.wwteachers.valueObjects.*;

public class Professor {
    private Código código;
    private Nome nome;
    private Nome sobrenome;
    private DataNascimento dataNascimento;
    private País país;
    private Senha senha;
    private Email email;
    private Disciplina disciplina;

    HashSet<Disciplina> listaDisciplinaProfessor = new HashSet<Disciplina>();
    HashSet<Chat> chatProfessor = new HashSet<Chat>();
    HashSet<    Postagem> postagensProfessor = new HashSet<Postagem>();

    public Professor(Nome nomeProfessor, Nome sobrenomeProfessor, DataNascimento data, País paísProfessor,
            Email emailProfessor, Senha senhaProfessor) {
        this.código = setCódigo();
        this.nome = nomeProfessor;
        this.sobrenome = sobrenomeProfessor;
        this.dataNascimento = data;
        this.país = paísProfessor;
        this.email = emailProfessor;
        this.senha = senhaProfessor;
    }

    public Professor(Código código, Nome nomeProfessor, Nome sobrenomeProfessor, DataNascimento data, País paísProfessor,
    Email emailProfessor){
        this.código = código;
        this.nome = nomeProfessor;
        this.sobrenome = sobrenomeProfessor;
        this.dataNascimento = data;
        this.país = paísProfessor;
        this.email = emailProfessor;
        this.senha = null;
        this.disciplina = null;
    }

    public String getCódigo() {
        return código.getCodigo();
    }

    private Código setCódigo() {
        return new Código("Professor");
    }

    public String getNome() {
        return this.nome.getNome();
    }

    public String getSobrenome() {
        return this.sobrenome.getNome();
    }

    public Date getDataPadrao() {
        return dataNascimento.getDataPadrao();
    }

    public String getTrêsDigitosPaís() {
        return país.getTrêsDigitos();
    }

    public String getDoisDigitosPaís() {
        return país.getDoisDigitos();
    }

    public String getNomePaís() {
        return país.getNomePaís();
    }

    public String getEmail() {
        return this.email.getEmail();
    }

    // IMPLEMENTAR SENHA HASH
    public String getSenha() {
        return this.senha.getSenha();
    }

    public String getCódigoDisciplinaPrincipal() {
        return this.disciplina.getCódigo();
    }

    public String getDisciplina() {
        return this.disciplina.getNome();
    }

    // // ========================= DISCIPLINAS =============================\\

    public void setDisciplinaProfessor(Disciplina disciplina) {
        listaDisciplinaProfessor.add(disciplina);
    }

    public String getQuantidadeDisciplinas() {
        return "O professor " + nome.getNome() + ", leciona atualmente " + listaDisciplinaProfessor.size()
                + " disciplinas.";
    }

    public void getDisciplinasLecionadas() {
        for (Disciplina disciplina : listaDisciplinaProfessor) {
            System.out.println(disciplina.getNome());
        }
    }

    // =========================== CHAT =============================\\

    public void criarChat(Professor professor) {
        Chat chat = new Chat("Professor-Professor");
        chatProfessor.add(chat);
    }

    // // ========================= POSTAGENS =============================\\

    public void criarPostagem() {
        Postagem postagem = new Postagem("Tudo pronto", ":D", this.disciplina);
        postagensProfessor.add(postagem);
    }

    public void criarPostagemDisciplinas() {
        // dados inseridos manualmente para simular inserção do usuário
        Postagem postagem = new Postagem("AEP 2020", "Equipe EFI", listaDisciplinaProfessor);
        postagensProfessor.add(postagem);
    }

}
