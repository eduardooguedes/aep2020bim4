package classes;

import javax.swing.JOptionPane;

public class Cadastro {

	public Cadastro() {
        setNovoCadastro();
    }

    private void setNovoCadastro(){
    
        String nome = JOptionPane.showInputDialog(null, "Informe seu nome: ");
        String sobrenome = JOptionPane.showInputDialog(null, "Sobrenome: ");
        
        String data = JOptionPane.showInputDialog(null, "Data nascimento (dd/mm/yyyy): ");
        // País pais = JOptionPane.showInputDialog(null, "PAISSSS: ");

        String email = JOptionPane.showInputDialog(null, "Email: ");
        

        String senha1 = JOptionPane.showInputDialog(null, "Senha: ");
        String senha2 = JOptionPane.showInputDialog(null, "Confirme sua senha: ");
        

        
        // Professor novo = new Professor(nome, professr);
    
    }

}
