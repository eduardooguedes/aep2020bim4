package classes;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
        import java.time.LocalDate;
import java.util.HashSet;

import valueObjects.*;

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
    HashSet<Postagem> postagensProfessor = new HashSet<Postagem>();

    public Professor(Nome nomeProfessor, Nome sobrenomeProfessor, DataNascimento data, País paísProfessor, 
                    Email emailProfessor, Senha senhaProfessor) {
        this.código = setCódigo();
        this.nome = nomeProfessor;
        this.dataNascimento = data;
        this.país = paísProfessor;
        this.email = emailProfessor;
        this.senha = senhaProfessor;
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

    // EDITAR SET PARA PASSAR STRING E FORMATAR
    public String getDataNascimento() {
        return dataNascimento.getDataFormatada();
    }

    public LocalDate getDataPadrao() {
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
    public Senha getSenha() {
        return this.senha;
    }

    public String getCódigoDisciplinaPrincipal() {
		return this.disciplina.getCódigo();
    }
    
    public String getDisciplina(){
        return this.disciplina.getNome();
    }

    public String getDadosProfessor(){
        return "[ " + email.getEmail() + " - " + nome.getNome() + " " + sobrenome.getNome() + " - " + dataNascimento.getDataFormatada() + " - " + país.getNomePaís() + " ]";
    }


    //========================= DISCIPLINAS =============================\\

    public void setDisciplinaProfessor(Disciplina disciplina){
        listaDisciplinaProfessor.add(disciplina);
    }

    public String getQuantidadeDisciplinas(){
        return "O professor " + nome.getNome() + ", leciona atualmente " + listaDisciplinaProfessor.size() + " disciplinas.";
    }

    public void getDisciplinasLecionadas(){
        for(Disciplina disciplina : listaDisciplinaProfessor){
            System.out.println(disciplina.getNome());
        }
    }


    //========================= CHAT =============================\\

    public void criarChat(Professor professor){
        Chat chat = new Chat("Prof-Prof");
        chatProfessor.add(chat);
    }

    //========================= POSTAGENS =============================\\

    public void criarPostagem(){
        Postagem postagem = new Postagem("Tudo pronto", ":D", this.disciplina);
        postagensProfessor.add(postagem);
    }

    public void criarPostagemDisciplinas(){
        //dados inseridos manualmente para simular inserção do usuário
        Postagem postagem = new Postagem("AEP 2020", "Equipe EFI", listaDisciplinaProfessor);
        postagensProfessor.add(postagem);
    }


}
