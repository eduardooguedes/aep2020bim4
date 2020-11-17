package br.wwteachers.acesso;

import java.sql.SQLException;
// import java.util.Arrays;
// import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import br.wwteachers.conexãoBancoDados.GerenciadorConexão;
import br.wwteachers.professor.*;
import br.wwteachers.valueObjects.*;

public class Cadastro {

    private JPasswordField senha1 = new JPasswordField();
    private JPasswordField senha2 = new JPasswordField();

    public Cadastro() throws SQLException {
        GerenciadorConexão conexão;
        try {
            conexão = new GerenciadorConexão();
            RepositórioProfessores repositorio = new RepositórioProfessores(conexão.getConexão());
            repositorio.cadastrarProfessor(setNovoCadastro());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Professor setNovoCadastro() {
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


        // do{
        //     List<País> listaPaises = Arrays.asList(País.values());
        //     String paísDigitado = JOptionPane.showInputDialog(null, "Informe seu país: ");
        //     for(País pais : listaPaises){
        //         if(pais.getNomePaís() == paísDigitado){
        //             paísCadastro = pais;
        //             break;
        //         }
        //         else{
        //             paísCadastro = null;
        //         }
        //     }

        // }while(paísCadastro == null);

        do {
            String email = JOptionPane.showInputDialog(null, "Email: ");
            emailCadastro = new Email(email);
        } while (emailCadastro.getEmail() == null);

        senha1.setEchoChar('*');
        senha2.setEchoChar('*');
        
        do{
            int value = JOptionPane.showConfirmDialog(null, senha1, "Senha: ", JOptionPane.OK_CANCEL_OPTION);
            if(value == JOptionPane.OK_OPTION){
               JOptionPane.showConfirmDialog(null, senha2, "Confirme sua senha: ", JOptionPane.OK_CANCEL_OPTION);
            }

            if(!senha1.equals(senha2)) {
                JOptionPane.showMessageDialog(null, "Senhas não coincidem");
            }
        }while(!senha1.equals(senha2));
        senhaCadastro = new Senha(senha1.getText());

        paísCadastro = País.BRA;
        Professor professorCadastro = new Professor(nomeCadastro, sobrenomeCadastro, dataCadastro, paísCadastro, emailCadastro, senhaCadastro);
        return professorCadastro;
    }

}
