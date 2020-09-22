package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import valueObjects.*;

public class Professor {

    private Código códigoProfessor;
    private Nome nomeProfessor;
    private Date dataNascimentoProfessor;
    private País paísProfessor;
    private Senha senhaProfessor;
    private Email emailProfessor;

    List<Disciplina> listaDisciplinaProfessor = new ArrayList<Disciplina>();

    public Professor(int códigoProfessor, String nomeProfessor, String sobrenomeProfessor, Date dataNascimentoProfessor, País paísProfessor, String emailProfessor, String senhaProfessor) {
        // gerar código ---> this.códigoProfessor = gerarCódigo();
        this.códigoProfessor = new Código(códigoProfessor);
        this.nomeProfessor = new Nome(nomeProfessor, sobrenomeProfessor);
        this.dataNascimentoProfessor = dataNascimentoProfessor;
        this.paísProfessor = paísProfessor;
        this.emailProfessor = new Email(emailProfessor);
        this.senhaProfessor = new Senha(senhaProfessor);
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
}
