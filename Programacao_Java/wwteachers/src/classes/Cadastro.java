package wwteachers.src.classes;

import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;

import javax.swing.JOptionPane;

import wwteachers.src.ConexaoPostgres.GerenciadorConexão;
import wwteachers.src.ConexaoPostgres.RepositórioProfessores;
import wwteachers.src.valueObjects.*;

public class Cadastro {

	public Cadastro() throws SQLException {
        GerenciadorConexão conexão;
        try{
            int conection = 0;
            do{
                conexão = new GerenciadorConexão();
                RepositórioProfessores repositorio = new RepositórioProfessores(conexão.getConexão());            
                repositorio.cadastrarProfessor(setNovoCadastro());            
                conection++;
            }while(conection < 10);
        }catch(SQLTransientConnectionException e){
            e.printStackTrace();
        }

         
    }

    private Professor setNovoCadastro(){
        Nome nomeCadastro;
        Nome sobrenomeCadastro;
        DataNascimento dataCadastro;
        País paísCadastro;
        Senha senhaCadastro;
        Email emailCadastro;
        
        do{
            String nome = JOptionPane.showInputDialog(null, "Informe seu nome: ");
            String sobrenome = JOptionPane.showInputDialog(null, "Sobrenome: ");
            nomeCadastro = new Nome(nome);
            sobrenomeCadastro = new Nome(sobrenome);

            if(nomeCadastro.getNome() == null || sobrenomeCadastro.getNome() == null){
                JOptionPane.showMessageDialog(null, "Nome ou sobrenome inválido [apenas letras]");
            }
        }while(nomeCadastro.getNome() == null || sobrenomeCadastro.getNome() == null);

        do{
            String data = JOptionPane.showInputDialog(null, "Data nascimento (dd/mm/yyyy): ");
            dataCadastro = new DataNascimento(data);
        }while(dataCadastro.getDataPadrao() == null);

        // do{
        //     String pais = 
        //     // País pais = JOptionPane.showInputDialog(null, "PAISSSS: ");
        // }while()

        do{
            String email = JOptionPane.showInputDialog(null, "Email: ");
            emailCadastro = new Email(email);
        }while(emailCadastro.getEmail() == null);

        String senha1; String senha2;
        // do{
        //     senha1 = JOptionPane.showInputDialog(null, "Senha: ");
        //     senha2 = JOptionPane.showInputDialog(null, "Confirme sua senha: ");

        //     if(senha1.equals(senha2)){
        //         senhaCadastro = new Senha(senha1);
        //     }else{
        //         JOptionPane.showMessageDialog(null, "Senhas não coincidem");
        //     }
        // }while(!senha1.equals(senha2));

        País paíscadastro = País.BRA;
        senhaCadastro = new Senha("senha");
        Professor professorCadastro = new Professor(nomeCadastro, sobrenomeCadastro, dataCadastro, paíscadastro, emailCadastro, senhaCadastro);
        return professorCadastro;
        
    }

}
