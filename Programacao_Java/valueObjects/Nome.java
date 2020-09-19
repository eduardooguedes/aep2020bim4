package valueObjects;

public class Nome {
    
    private String nomeProfessor;

    public Nome(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
    
    public String getNome(){
        return nomeProfessor;
    }
}
