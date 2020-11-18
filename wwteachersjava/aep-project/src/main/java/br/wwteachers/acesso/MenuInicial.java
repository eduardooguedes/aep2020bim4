package br.wwteachers.acesso;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.wwteachers.professor.Professor;

public class MenuInicial {
    
    String formatoMenu = "                                             WWTeachers\n                 "
            + "LOGIN\n\n 1 - Acessar\n 2 - Criar conta\n 0 - Sair\n\nEscolha: ";

    public MenuInicial() {
        try {
            mostrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void mostrar() throws SQLException {
        int opcao;
        do{
            String menu = (String) JOptionPane.showInputDialog(null, formatoMenu, "MENU", JOptionPane.QUESTION_MESSAGE);
            opcao = Integer.parseInt(menu);

            switch(opcao){
                case 1:
                    Login login = new Login();
                    login.setLogin();
                    break;

                case 2:
                    Cadastro novoCadastro = new Cadastro();
                    Professor usuário = novoCadastro.getUsuário();
                        
                break;

                case 3:
                break;

                default: break;

                }

        }while(opcao != 0);

        
    }

}
