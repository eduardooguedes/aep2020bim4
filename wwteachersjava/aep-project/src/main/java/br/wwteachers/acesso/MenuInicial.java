package br.wwteachers.acesso;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MenuInicial {
    
    private String formatoMenu = "                                             WWTeachers\n                 "
            + "LOGIN\n\n 1 - Acessar\n 2 - Criar conta\n 0 - Sair\n\nEscolha: ";

    public MenuInicial() {
        try {
            apresentar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void apresentar() throws SQLException {
        try{

            int opcao;
            do{
                String menu = (String) JOptionPane.showInputDialog(null, formatoMenu, "MENU", JOptionPane.QUESTION_MESSAGE);
                opcao = Integer.parseInt(menu);
                
                switch(opcao){
                    case 1:
                    Login login = new Login();
                    break;
                    
                    case 2:
                    Cadastro novoCadastro = new Cadastro();
                    Login login2 = new Login();
                    break;
                    
                    case 3:
                    break;
                    
                    default: break;
                }
                
            }while(opcao != 0);
        
        } catch (NumberFormatException e){
            System.out.println("Até logo.");
        
        } catch (Exception ex){
            ex.printStackTrace();
        }              
    }

}
