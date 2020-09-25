package classes;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashSet;

import valueObjects.*;
import classes.Postagem;

public class Professor {

    private Código códigoProfessor;
    private Nome nomeProfessor;
    private Date dataNascimentoProfessor;
    private País paísProfessor;
    private Senha senhaProfessor;
    private Email emailProfessor;
    private Disciplina disciplinaPrincipal;

    HashSet<Disciplina> listaDisciplinaProfessor = new HashSet<Disciplina>();    
    HashSet<Chat> chatProfessor = new HashSet<Chat>();
    HashSet<Postagem> postagensProfessor = new HashSet<Postagem>();

    public Professor(int códigoProfessor, String nomeProfessor, String sobrenomeProfessor, Date dataNascimentoProfessor, País paísProfessor, String emailProfessor, String senhaProfessor) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // gerar código ---> this.códigoProfessor = gerarCódigo();
        this.códigoProfessor = new Código(códigoProfessor, "Professor");
        this.nomeProfessor = new Nome(nomeProfessor, sobrenomeProfessor);
        this.dataNascimentoProfessor = dataNascimentoProfessor;
        this.paísProfessor = paísProfessor;
        this.emailProfessor = new Email(emailProfessor);
        this.senhaProfessor = new Senha(senhaProfessor);
    }

    public Senha getSenha(){
        return this.senhaProfessor;
    }
    public String getDadosProfessor(){
        return "[ " + emailProfessor.getEmail() + " - " + nomeProfessor.getNomeCompleto() + " - " + dataNascimentoProfessor.getDate() + '/' + dataNascimentoProfessor.getMonth() + '/' + dataNascimentoProfessor.getYear() + " - " + paísProfessor.getNomePaís() + " ]";
    }    

    public void setDisciplinaProfessor(Disciplina disciplina){
        listaDisciplinaProfessor.add(disciplina);
    }

    public String getQuantidadeDisciplinas(){
        return "O professor " + nomeProfessor.getNome() + ", leciona atualmente " + listaDisciplinaProfessor.size() + " disciplinas.";
    }

    public void getDisciplinasLecionadas(){
        for(Disciplina disciplina : listaDisciplinaProfessor){
            System.out.println(disciplina.getNomeDisciplina());
        }
    }

    public void criarChat(Professor professor){
        Chat chat = new Chat("Professor-Professor", 4);
        chatProfessor.add(chat);
    }

    public void criarPostagem(){
        Postagem postagem = new Postagem(6, "Tudo pronto", ":D", this.disciplinaPrincipal);
        postagensProfessor.add(postagem);
    }

    public void criarPostagemDisciplinas(){
        //dados inseridos manualmente para simular inserção do usuário
        Postagem postagem = new Postagem(5, "AEP 2020", "Equipe EFI", listaDisciplinaProfessor);
        postagensProfessor.add(postagem);
    }

}
