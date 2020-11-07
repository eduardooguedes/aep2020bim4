import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.swing.JOptionPane;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import valueObjects.*;
import classes.*;

public class App {

    public static void main(String[] args)
    throws ParseException, UnsupportedEncodingException, NoSuchAlgorithmException {
        
        LocalDateTime dataHora = LocalDateTime.now();
        FormatoDataHoraAtual data = new FormatoDataHoraAtual(dataHora);
        

        Disciplina matemática = new Disciplina(1, "Matemática", "Matemática Básica");
        Disciplina português = new Disciplina(2, "Português", "Português BR");

        Professor iago = new Professor("Iago", "da Costa", data, País.BRA, "iago.cland@gmail.com",
                "eduardo#fela@aepchegando");

        iago.setDisciplinaProfessor(matemática);
        iago.setDisciplinaProfessor(matemática);
        iago.setDisciplinaProfessor(português);

        System.out.println(iago.getDadosProfessor());
        iago.getDisciplinasLecionadas();
        System.out.println(iago.getQuantidadeDisciplinas());

        System.out.println(iago.getSenha());

    }

}