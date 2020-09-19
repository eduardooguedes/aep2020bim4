import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import valueObjects.*;
import classes.*;

public class App {

    public static void main(String[] args) throws ParseException {
        
        String str = "25/07/1996";
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatador.parse(str);
        // (1996, 07, 25);

        Disciplina matemática = new Disciplina(1, "Matemática", "Materia de fazer continhas");
        Disciplina português = new Disciplina(2, "Português", "Materia de escrever certin");

        Professor iago = new Professor(1, "Iago", "da Costa", data, País.BRA, "iago.cland@gmail.com", "iago#fela@aepchegando");

        iago.setDisciplinaProfessor(matemática);
        iago.setDisciplinaProfessor(português);

        System.out.println(iago.getDadosProfessor());
        iago.getDisciplinasLecionadas();
        System.out.println(iago.getQuantidadeDisciplinas());
   
    }

}