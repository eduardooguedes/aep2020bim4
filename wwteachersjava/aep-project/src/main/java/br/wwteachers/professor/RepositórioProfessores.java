package br.wwteachers.professor;

import br.wwteachers.comunidade.Disciplina;
import br.wwteachers.valueObjects.*;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RepositórioProfessores {
    private Connection conexão;
    private PreparedStatement insert;

    public RepositórioProfessores(Connection conexão) {
        this.conexão = conexão;
        criarTabela();
    }

    private void criarTabela() {
        try {
            Statement createTable = conexão.createStatement(); 
            createTable.executeUpdate("create table if not exists professores (" +
             "codigoProfessor char(36) not null primary key, " +
             "nome varchar(25) not null, " +
             "sobrenome varchar(50) not null, " +
             "dataNascimento date not null," +
             "pais char(3) not null," +
             "disciplinaCod char(36) not null," +
             "email varchar(60) not null unique," +
             "senhaHash char(40) not null," +
             "sal char(20) not null unique," +   
             "constrain foreign key (disciplinaCod) references disciplina(codigoDisciplina) )");        
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarProfessor(Professor novoProfessor){
        try{
            if(insert == null){
                insert = conexão.prepareStatement("insert into professores (codigoProfessor, nome, sobrenome, dataNascimento, pais, disciplinaCod, email, senhaHash, sal) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            }
            insert.setString(1, novoProfessor.getCódigo());
            insert.setString(2, novoProfessor.getNome());
            insert.setString(3, novoProfessor.getSobrenome());
            insert.setString(4, novoProfessor.getDataNascimento());
            insert.setString(5, novoProfessor.getTrêsDigitosPaís());
            insert.setString(6, novoProfessor.getCódigoDisciplinaPrincipal());
            insert.setString(7, novoProfessor.getEmail());
            insert.setString(8, novoProfessor.getSenha().getSenhaHash());
            insert.setString(9, novoProfessor.getSenha().getSal());

            insert.executeUpdate();
            conexão.commit();
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Professor buscarUsuário(String emailLogin, String senhaLogin){
        try{
            Statement select = conexão.createStatement();
            ResultSet resultado = select.executeQuery("select codigoProfessor, nome, sobrenome, dataNascimento, pais, disciplinaCod, email, senhaHash, sal from professores where email = '" +  emailLogin + "'");
            if(resultado.next()){
                Email email = new Email(resultado.getString("email"));
                String senha = resultado.getString("senhaHash");
                String sal = resultado.getString("sal");

                if(email.getEmail().equals(emailLogin)  && Senha.verificaSenha(senhaLogin, sal) == senha){
                    Código código = new Código("Professor", resultado.getString("codigoProfessor"));
                    Nome nome = new Nome(resultado.getString("nome"));
                    Nome sobrenome = new Nome(resultado.getString("sobrenome"));
                    DataNascimento dataNascimento = new DataNascimento(resultado.getString("dataNascimento"));
                    País país = País(resultado.getString("pais"));
                    Disciplina disciplinaCod = new Disciplina(resultado.getString("disciplinaCod"));

                    Professor professorLogin = new Professor(código, nome, sobrenome, dataNascimento, país, email, null, disciplinaCod); //= new Professor();
                    return professorLogin; 
                }
            }
            else
            {
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
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
