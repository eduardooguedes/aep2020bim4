import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import java.text.ParseException;

import classes.*;
import valueObjects.Nome;

public class App {

    public static void main(String[] args)
    throws ParseException, UnsupportedEncodingException, NoSuchAlgorithmException {

        Nome novo = new Nome("Eduardo");
        System.out.println(novo.getNome());
        Nome novo1 = new Nome("Iago");
        System.out.println(novo1.getNome());


        JOptionPane.showMessageDialog(null, " Bem vindo ao WWTeachers\n\n A internet dos professores.", "                           WWTeachers", JOptionPane.INFORMATION_MESSAGE);
        Menu menu = new Menu();
        menu.mostrar();
        
        // LocalDateTime dataHora = LocalDateTime.now();
        // DataHoraMomento data = new DataHoraMomento(dataHora);
        // JOptionPane.showMessageDialog(null, data.getDataHora());

        // Disciplina matemática = new Disciplina("Matemática", "Matemática Básica");
        // Disciplina português = new Disciplina("Português", "Português BR");

    }

}