package classes;

import java.sql.Date;

import valueObjects.*;

public class Professor {

    private Código codigoProfessor;
    private Nome nomeProfessor;
    private Nome sobrenomeProfessor;
    private Date dataNascimentoProfessor;
    private País paísProfessor;
    private Senha senhaProfessor;
    private Email emailProfessor;

    public Professor(int codigoProfessor, String nomeProfessor, String sobrenomeProfessor, Date dataNascimentoProfessor, String paísProfessor, String emailProfessor, String senhaProfessor) {
        // gerar código ---> this.codigoProfessor = gerarCódigo();
        this.codigoProfessor = new Código(codigoProfessor);
        this.nomeProfessor = new Nome(nomeProfessor);
        this.sobrenomeProfessor = new Nome(sobrenomeProfessor);
        this.dataNascimentoProfessor = dataNascimentoProfessor;
        this.paísProfessor = new País(paísProfessor);
        this.emailProfessor = new Email(emailProfessor);
        this.senhaProfessor = new Senha(senhaProfessor);
    }

    public String getDadosProfessor(){
        return "[ " + emailProfessor + " - " + nomeProfessor + " - " + dataNascimentoProfessor + " - " + paísProfessor + " ]";
    }    


}
