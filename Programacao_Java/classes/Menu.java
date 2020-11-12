package classes;

// import images.*;
// import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Menu {

    String formatoMenu = "                                             WWTeachers\n                 "+
    "LOGIN\n\n 1 - Acessar\n 2 - Criar conta\n 0 - Sair\n\nEscolha: ";
    // ImageIcon iconOds = new ImageIcon("images.iconods4.ico");

    public Menu(){
        
    }

    public void mostrar(){
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
                    // novoCadastro.setCadastro();
                    
                break;

                case 3:
                break;

                default: break;


                }

        }while(opcao != 0);

    }


}
