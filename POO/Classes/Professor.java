package ValueObjects;
package Functions;

import java.sql.Date;

import ValueObjects.Código;

public class Professor{

    private Código codigoProfessor;
    private Nome nomeProfessor;
    private Nome sobrenomeProfessor;
    private Date dataNascimentoProfessor;
    private País paísProfessor;
    private Senha senhaProfessor;
    private Email emailProfessor;

    public Professor(Código codigoProfessor, Nome nomeProfessor, Nome sobrenomeProfessor, Date dataNascimentoProfessor, País paísProfessor, Email emailProfessor, Senha senhaProfessor) {
        // gerar código ---> this.codigoProfessor = gerarCódigo();
        this.codigoProfessor = new Código(codigoProfessor);
        this.nomeProfessor = new Nome(nome);
        this.sobrenomeProfessor = new Nome(sobrenomeProfessor);
        this.dataNascimentoProfessor = new Date(dataNascimentoProfessor);
        this.paísProfessor = new País(paísProfessor);
        this.emailProfessor = new Email(emailProfessor);
        this.senhaProfessor = new Senha(senhaProfessor);
    }

    public String getDadosProfessor(){
        return "[ " + emailProfessor + " - " + nomeProfessor " - " + dataNascimentoProfessor + " - " + paísProfessor + " ]";
    }    


}
