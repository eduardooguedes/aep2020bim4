package br.wwteachers.acesso;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import br.wwteachers.bancoDeDados.GerenciadorDeConexão;
import br.wwteachers.professor.Professor;
import br.wwteachers.professor.RepositórioProfessores;


public class Login {

    private Professor usuário;
    private JPasswordField senhaInserida = new JPasswordField();

    public void setLogin() {
        senhaInserida.setEchoChar('*');

        String email = JOptionPane.showInputDialog(null, "Email: ");
        int value = JOptionPane.showConfirmDialog(null, senhaInserida, "Senha: ", JOptionPane.OK_CANCEL_OPTION);
        String senha = senhaInserida.getText(); // deprecated, mudar para getPassword(); (char[])

        if (value == JOptionPane.OK_OPTION) {
            // String novaSenha = ;
            efetuarLogin(email, senha);
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.");
        }

        System.out.println(this.usuário.getSobrenome()); 
    }

    private void efetuarLogin(String email, String senha) {
        GerenciadorDeConexão conexão;
        try {
            conexão = new GerenciadorDeConexão();
            RepositórioProfessores abrirRepositorio = new RepositórioProfessores(conexão.getConexão());
            this.usuário = abrirRepositorio.buscarUsuário(email, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }

}   

