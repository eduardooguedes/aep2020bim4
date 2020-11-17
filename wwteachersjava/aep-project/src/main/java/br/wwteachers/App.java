package br.wwteachers;

import java.sql.SQLException;

import br.wwteachers.acesso.MenuInicial;
// import br.wwteachers.professor.Professor;
// import br.wwteachers.valueObjects.*;

public class App {
    public static void main(String[] args) {

        MenuInicial menu = new MenuInicial();
        try {
            menu.mostrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Nome nome = new Nome("Eduardo");
        // Nome sobrenome = new Nome("Guedes");
        // Email email = new Email("eduardo@gmail.com");
        // DataNascimento data = new DataNascimento("06/01/1998");
        // Senha senha = new Senha("Senha");
        
        // Professor eduardo = new Professor(nome, sobrenome, data, País.BRA, email, senha);
        // System.out.println( "Hello World!" );
        // System.out.println(eduardo.getCódigo());
        
        // System.out.println("OK");
        // Código codigo = new Código("teste");
        // System.out.println(codigo.getCodigo());
        
        
    }
}
