package classes;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashSet;

import valueObjects.*;
import classes.Postagem;

public class Professor {

    private Código códigoProfessor;
    private Nome nome;
    private DataNascimento dataNascimento;
    private País país;
    private Senha senha;
    private Email email;
    private Disciplina disciplina;

    HashSet<Disciplina> listaDisciplinaProfessor = new HashSet<Disciplina>();    
    HashSet<Chat> chatProfessor = new HashSet<Chat>();
    HashSet<Postagem> postagensProfessor = new HashSet<Postagem>();

    public Professor(String nomeProfessor, String sobrenomeProfessor, DataNascimento data, País paísProfessor, String emailProfessor, String senhaProfessor) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.códigoProfessor = new Código("Prof");
        this.nome = new Nome(nomeProfessor, sobrenomeProfessor);
        this.dataNascimento = data;
        this.país = paísProfessor;
        this.email = new Email(emailProfessor);
        this.senha = new Senha(senhaProfessor);
    }

    public String getDataNascimento(){
        return dataNascimento.getDataCompleta();
    }

	public Senha getSenha(){
        return this.senha;
    }

    public String getDadosProfessor(){
        return "[ " + email.getEmail() + " - " + nome.getNomeCompleto() + " - " + dataNascimento.getDataCompleta() + " - " + país.getNomePaís() + " ]";
    }    

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

    public void criarChat(Professor professor){
        Chat chat = new Chat("Prof-Prof");
        chatProfessor.add(chat);
    }

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
