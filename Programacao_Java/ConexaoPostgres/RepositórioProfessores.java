package ConexaoPostgres;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import classes.Professor;

public class RepositórioProfessores{
    private Connection conexão;
    private PreparedStatement insert;

    public RepositórioProfessores(Connection conexão) {
        this.conexão = conexão;
        criarTabela();
    }

    private void criarTabela() {
        try (Statement createTable = conexão.createStatement()){
             createTable.executeUpdate("create table if not exists professores (" +
             "codigo char(36) not null primary key, " +
             "nome varchar(25) not null, " +
             "sobrenome varchar(50) not null, " +
             "pais char(3) not null," +
             "disciplinaCod char(36) not null," +
             "email varchar(60) not null unique," +
             "senhaHash char(40) not null," +
             "sal char(20) not null unique" +   
             ")");        
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void cadastrarProfessor(Professor novoProfessor){
        try{
            if(insert == null){
                insert = conexão.prepareStatement("insert into professores (codigo, nome, sobrenome, pais, disciplinaCod, email, senhaHash, sal) values (?, ?, ?, ?, ?, ?, ?, ?)");
            }
            insert.setString(1, novoProfessor.getCódigo());
            insert.setString(2, novoProfessor.getNome());
            insert.setString(3, novoProfessor.getSobrenome());
            insert.setString(4, novoProfessor.getTrêsDigitosPaís());
            insert.setString(5, novoProfessor.getCódigoDisciplinaPrincipal());
            insert.setString(6, novoProfessor.getEmail());
            insert.setString(7, novoProfessor.getSenha().getSenhaHash());
            insert.setString(8, novoProfessor.getSenha().getSal());

            insert.executeUpdate();
            conexão.commit();
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void encontrarUsuário(String emailLogin, String senhaLogin){
        try (Statement select = conexão.createStatement();
            ResultSet resultado = select.executeQuery("select email, senhaHash, sal from professores where email = '" +  emailLogin + "'");) {
            
            if(resultado.next()){
                String email = resultado.getString("email");
                String senha = resultado.getString("senhaHash");
                String sal = resultado.getString("sal");

                //FINISH
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws Exception{
        if(insert != null && !insert.isClosed()){
            insert.close();
        }
    }

}