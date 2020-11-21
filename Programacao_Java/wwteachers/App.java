package wwteachers;

import java.sql.SQLException;
import javax.swing.JOptionPane;

import wwteachers.src.classes.Menu;

public class App {

    public static void main(String[] args) throws SQLException {

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