package br.wwteachers.professor;

import br.wwteachers.valueObjects.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RepositórioProfessores {
    private Connection conexão;
    private PreparedStatement insert;

    public RepositórioProfessores(Connection conexão) {
        this.conexão = conexão;
        this.insert = null;
    }

    public void cadastrarProfessor(Professor novoProfessor) {
        try {
            if (insert == null) {
                insert = conexão.prepareStatement(
                        "insert into professores (codigoProfessor, nome, sobrenome, dataNascimento, pais, email, senhaHash) values (?, ?, ?, ?, ?, ?, ?)");
            }
            insert.setString(1, novoProfessor.getCódigo());
            insert.setString(2, novoProfessor.getNome());
            insert.setString(3, novoProfessor.getSobrenome());
            insert.setDate(4, novoProfessor.getDataPadrao());
            insert.setString(5, novoProfessor.getTrêsDigitosPaís());
            insert.setString(6, novoProfessor.getEmail());
            insert.setString(7, novoProfessor.getSenha());
            insert.executeUpdate();

            conexão.commit();
            System.out.println("OK");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Professor buscarUsuário(String emailLogin, String senhaLogin){
        Professor professorLogin = null;
        try{
            PreparedStatement validaSenha = conexão.prepareStatement("select funcao_login (?, ?) as funcao");
            validaSenha.setString(1, emailLogin);
            validaSenha.setString(2, senhaLogin);
            ResultSet validou = validaSenha.executeQuery();
            Boolean senhaValidada = false;
            
            if(validou.next()){
                senhaValidada = validou.getBoolean("funcao");

                if(senhaValidada){
                    PreparedStatement select = conexão.prepareStatement("select codigoProfessor, nome, sobrenome, dataNascimento, pais, email from professores where email = ?");
                    select.setString(1, emailLogin);
                    ResultSet resultado = select.executeQuery();
                    
                    if(resultado.next()){
                        Email email = new Email(resultado.getString("email"));
                        Código código = new Código("Professor", resultado.getString("codigoProfessor"));
                        Nome nome = new Nome(resultado.getString("nome"));
                        Nome sobrenome = new Nome(resultado.getString("sobrenome"));
                        DataNascimento dataNascimento = new DataNascimento(resultado.getDate("dataNascimento"));
                        País país = País(resultado.getString("pais"));
                        
                        professorLogin = new Professor(código, nome, sobrenome, dataNascimento, país, email);
                        select.close();
                    }
                }else{
                    System.out.println("Usuário ou senha incorreta");
                }
            }
            else
            {
                System.out.println("Usuário ou senha incorreto");
            }
        
        } catch(Exception e){
            throw new RuntimeException(e);
        }
        
        return professorLogin;
   }

    private País País(String value) {
        for (País pais : País.values()) {
            if (pais.getTrêsDigitos().equals(value))
                return pais;
        }
        return null;
    }

    public void close() throws Exception {
        if (insert != null && !insert.isClosed()) {
            insert.close();
        }
    }

}
