package ConexaoPostgres;

import java.sql.Connection;
import java.sql.Statement;

public class RepositórioProfessores {

    private Connection conexão;
    
    public RepositórioProfessores(Connection conexão) {
        this.conexão = conexão;
        criarTabela();
    }

    private void criarTabela() {
        try (Statement createTable = conexão.createStatement()){
             createTable.executeUpdate("create table if not exists professores (" +
             "id char(36) not null primary key, " +
             "nome varchar(25) not null, " +
             "sobrenome varchar(50) not null, " +
             "pais char(3) not null," +
             "disciplinaId char(36) not null," +
             "email varchar(60) not null unique," +
             //"senha char(20) not null," +   
             ")");        
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}