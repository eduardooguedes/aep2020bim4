package valueObjects;

public class Nome {
    
    private String nomeProfessor;
    private String sobrenomeProfessor;

    public Nome(String nomeProfessor, String sobrenomeProfessor) {
        this.nomeProfessor = nomeProfessor;
        this.sobrenomeProfessor = sobrenomeProfessor;
    }
    
    public String getNome(){
        return nomeProfessor;
    }

    public String getSobrenome(){
        return sobrenomeProfessor;
    }

    public String getNomeCompleto(){
        return nomeProfessor + ' ' + sobrenomeProfessor;
    }
}
