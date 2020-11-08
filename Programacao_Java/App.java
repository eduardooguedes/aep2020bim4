import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import valueObjects.*;
import classes.*;

public class App {

    public static void main(String[] args)
    throws ParseException, UnsupportedEncodingException, NoSuchAlgorithmException {
        
        int opcao=0;

        System.out.println("Bem vindo ao WWTeachers. A internet dos professores.");
        System.out.println("================================================================");
        do{
            String menu = JOptionPane.showInputDialog(null, " 1 - Login\n 2 - Cadastrar professor\n 3 - Cadastrar disciplina\n 0 - Sair\n Escolha: ");
            opcao = Integer.parseInt(menu);

            switch(opcao){
                case 1:
                break;

                case 2:
                break;

                case 3:
                break;

                default: break;


                }

        }while(opcao != 0);

        // LocalDateTime dataHora = LocalDateTime.now();
        // DataHoraMomento data = new DataHoraMomento(dataHora);
        // JOptionPane.showMessageDialog(null, data.getDataHora());

        // int year = 1998;
        // int month = 01;
        // int dayOfMonth = 06;
        // LocalDate date = LocalDate.of(year, month, dayOfMonth);
        // DataFormatada dataa = new DataFormatada(date);
        // JOptionPane.showMessageDialog(null, dataa.getData());

        Disciplina matemática = new Disciplina(1, "Matemática", "Matemática Básica");
        Disciplina português = new Disciplina(2, "Português", "Português BR");

        // Professor iago = new Professor("Iago", "da Costa", data, País.BRA, "iago.cland@gmail.com",
        //         "iago123");

        // iago.setDisciplinaProfessor(matemática);
        // iago.setDisciplinaProfessor(matemática);
        // iago.setDisciplinaProfessor(português);

        // System.out.println(iago.getDadosProfessor());
        // iago.getDisciplinasLecionadas();
        // System.out.println(iago.getQuantidadeDisciplinas());

        // System.out.println(iago.getSenha());

    }

}