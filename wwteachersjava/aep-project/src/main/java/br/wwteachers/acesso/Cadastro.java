package br.wwteachers.acesso;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import br.wwteachers.bancoDeDados.GerenciadorDeConexão;
import br.wwteachers.professor.*;
import br.wwteachers.valueObjects.*;

public class Cadastro {

    private Professor usuário;
    private JPasswordField senha1 = new JPasswordField();
    private JPasswordField senha2 = new JPasswordField();

    public Cadastro() throws SQLException {
        GerenciadorDeConexão conexão;
        try {
            conexão = new GerenciadorDeConexão();
            RepositórioProfessores repositorio = new RepositórioProfessores(conexão.getConexão());
            repositorio.cadastrarProfessor(setNovoCadastro());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Professor setNovoCadastro() {
        Nome nomeCadastro;
        Nome sobrenomeCadastro;
        DataNascimento dataCadastro;
        País paísCadastro;
        Senha senhaCadastro;
        Email emailCadastro;

        do {
            String nome = JOptionPane.showInputDialog(null, "Informe seu nome: ");
            String sobrenome = JOptionPane.showInputDialog(null, "Sobrenome: ");
            nomeCadastro = new Nome(nome);
            sobrenomeCadastro = new Nome(sobrenome);

            if (nomeCadastro.getNome() == null || sobrenomeCadastro.getNome() == null) {
                JOptionPane.showMessageDialog(null, "Nome ou sobrenome inválido [apenas letras]");
            }
        } while (nomeCadastro.getNome() == null || sobrenomeCadastro.getNome() == null);

        do {
            String data = JOptionPane.showInputDialog(null, "Data nascimento (dd/mm/yyyy): ");
            dataCadastro = new DataNascimento(data);
        } while (dataCadastro.getDataPadrao() == null);


        do{
            País[] listaPaises = País.values();
            String paísDigitado = JOptionPane.showInputDialog(null, "Informe seu país: ");
            paísCadastro=null;

            for(País pais : listaPaises){                
                if(pais.getNomePaís().equals(paísDigitado)){
                    paísCadastro = pais;
                    break;
                }
                else{
                    paísCadastro = null;
                }
            }
        }while(paísCadastro == null);

        do {
            String email = JOptionPane.showInputDialog(null, "Email: ");
                emailCadastro = new Email(email);
        } while (!emailCadastro.getBoolean());

        senha1.setEchoChar('*');
        senha2.setEchoChar('*');
        int value=2;
        do{
            value = JOptionPane.showConfirmDialog(null, senha1, "Senha: ", JOptionPane.OK_CANCEL_OPTION);
            if(value == JOptionPane.OK_OPTION){
               JOptionPane.showConfirmDialog(null, senha2, "Confirme sua senha: ", JOptionPane.OK_CANCEL_OPTION);
            }

            if(senha1.getText() != senha2.getText()) {
                JOptionPane.showMessageDialog(null, "Senhas não coincidem");
            }

        }while((senha1.getText() != senha2.getText()) || value != JOptionPane.CANCEL_OPTION);

        senhaCadastro = new Senha(senha1.getText()); 

        this.usuário = new Professor(nomeCadastro, sobrenomeCadastro, dataCadastro, paísCadastro, emailCadastro, senhaCadastro);
        return usuário;
    }

}
