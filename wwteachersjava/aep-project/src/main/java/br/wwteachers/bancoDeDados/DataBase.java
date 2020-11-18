package br.wwteachers.bancoDeDados;

import java.sql.Statement;
import java.sql.Connection;

public class DataBase {
    
    public static void createTables(Connection novaConexão) {
            Connection conexão = novaConexão;
        try {
            Statement createTableProfessores = conexão.createStatement();
            createTableProfessores.executeUpdate("create table professores (" +
             "codigoProfessor char(36) primary key, " +
             "nome varchar(25) not null, " +
             "sobrenome varchar(50) not null, " +
             "dataNascimento date not null," +
             "pais char(3) not null," +
             "disciplinaCod char(36)," +
             "email varchar(60) not null unique," +
             "senhaHash char(40) not null, " +
             "sal char(20) not null unique )");   
            createTableProfessores.close();

            //  "foreign key (disciplinaCod) references disciplina(codigoDisciplina) )");
             Statement createTableDisciplina = conexão.createStatement();
             createTableDisciplina.executeUpdate("create table disciplina (" +
             "codigoDisciplina char(36) not null primary key, " +
             "nome varchar(40) not null,  " +
             "descricao varchar(60) not null unique)");
            createTableDisciplina.close();

            Statement addFKProfessor = conexão.createStatement();
            addFKProfessor.executeUpdate("alter table professores add constraint FkDisciplina foreign key (disciplinaCod) references disciplina (codigoDisciplina) ");
            addFKProfessor.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
     System.out.println("Tabelas criadas");   
    }

}
