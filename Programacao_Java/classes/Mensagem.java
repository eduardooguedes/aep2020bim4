package classes;

//import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalDateTime;

public class Mensagem {
    
    private Professor professor;
    private String mensagem;
    //private LocalDateTime horaMensagem;

    public Mensagem(Professor professor, String mensagem){
        this.professor = professor;
        this.mensagem = mensagem;
        //this.horaMensagem = new LocalDateTime.now();
    }
  
}
