package br.wwteachers.professor;

import br.wwteachers.comunidade.Disciplina;
import br.wwteachers.valueObjects.*;

import java.sql.Statement;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RepositórioProfessores {
    private Connection conexão;
    private PreparedStatement insert = null;

    public RepositórioProfessores(Connection conexão) {
        this.conexão = conexão;
    }

    public void cadastrarProfessor(Professor novoProfessor){
        try{
            if(insert == null){
                insert = conexão.prepareStatement("insert into professores (codigoProfessor, nome, sobrenome, dataNascimento, pais, email, senhaHash, sal) values (?, ?, ?, ?, ?, ?, ?, ?)");
                System.out.println("OK");
            }
            insert.setString(1, novoProfessor.getCódigo());
            insert.setString(2, novoProfessor.getNome());
            insert.setString(3, novoProfessor.getSobrenome());
            insert.setDate(4, novoProfessor.getDataPadrao());
            insert.setString(5, novoProfessor.getTrêsDigitosPaís());
            insert.setString(6, novoProfessor.getEmail());
            insert.setString(7, novoProfessor.getSenha().getSenhaHash());
            insert.setString(8, novoProfessor.getSenha().getSal());
            insert.executeUpdate();

            conexão.commit();
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Professor buscarUsuário(String emailLogin, String senhaLogin){
        Professor professorLogin = null;
        try{
            Statement select = conexão.createStatement();
            ResultSet resultado = select.executeQuery("select codigoProfessor, nome, sobrenome, dataNascimento, pais, email, senhaHash, sal from professores where email = '" +  emailLogin + "'");

            if(resultado.next()){
                Email email = new Email(resultado.getString("email"));
                String senha = resultado.getString("senhaHash");
                String sal = resultado.getString("sal");

                if(email.getEmail().equals(emailLogin)  && Senha.verificaSenha(senhaLogin, sal) == senha){
                    Código código = new Código("Professor", resultado.getString("codigoProfessor"));
                    Nome nome = new Nome(resultado.getString("nome"));
                    Nome sobrenome = new Nome(resultado.getString("sobrenome"));
                    DataNascimento dataNascimento = new DataNascimento(resultado.getDate("dataNascimento"));
                    País país = País(resultado.getString("pais"));
                    Disciplina disciplinaCod = new Disciplina("Codigo teste");
                    Senha senha2 = new Senha(senhaLogin);

                    professorLogin = new Professor(código, nome, sobrenome, dataNascimento, país, email, senha2, disciplinaCod); //= new Professor();
                    select.close();
                }
            }
            else
            {
                System.out.println("Usuario não encontrado");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return professorLogin;
   }

    private País País(String string) {
        for(País pais : País.values()){
            if(pais.getTrêsDigitos().equals(string))
                return pais;
        }
        return null;
    }

    public void close() throws Exception {
        if(insert != null && !insert.isClosed()){
            insert.close();
        }
    }

}
