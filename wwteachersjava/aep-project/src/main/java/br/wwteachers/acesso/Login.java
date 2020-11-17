package br.wwteachers.acesso;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import br.wwteachers.conexãoBancoDados.GerenciadorConexão;
import br.wwteachers.professor.Professor;
import br.wwteachers.professor.RepositórioProfessores;


public class Login {

    // private Professor usuário;
    // private Box box = Box.createHorizontalBox();
    // private JTextField emailInserido = new JTextField();
    private JPasswordField senhaInserida = new JPasswordField();

    public void setLogin() {
        senhaInserida.setEchoChar('*');
        // box.add(emailInserido); box.add(senhaInserida);
        // int value = JOptionPane.showConfirmDialog(null, box, "LOGIN",
        // JOptionPane.OK_CANCEL_OPTION);

        String email = JOptionPane.showInputDialog(null, "Email: ");
        int value = JOptionPane.showConfirmDialog(null, senhaInserida, "Senha: ", JOptionPane.OK_CANCEL_OPTION);
        String senha = senhaInserida.getText(); // deprecated, mudar para getPassword(); (char[])

        if (value == JOptionPane.OK_OPTION) {
            // String novaSenha = ;
            efetuarLogin(email, senha);
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.");
        }

    }

    private void efetuarLogin(String email, String senha) {
        GerenciadorConexão conexão;
        try {
            conexão = new GerenciadorConexão();
            RepositórioProfessores abrirRepositorio = new RepositórioProfessores(conexão.getConexão());
            Professor usuário = abrirRepositorio.buscarUsuário(email, senha);
            
            if(usuário == null) {
                System.out.println("Usuario não encontrado.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }    


        JOptionPane.showMessageDialog(null, "     Login efetuado\n email: " + email + " \nsenha: " + senha);
    }

}   

