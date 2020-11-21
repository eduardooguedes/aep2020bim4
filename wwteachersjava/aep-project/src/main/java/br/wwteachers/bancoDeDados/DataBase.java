package br.wwteachers.bancoDeDados;

import java.sql.Statement;
import java.sql.Connection;

public class DataBase {
    
    private Connection conexão;
    private Statement updateDataBase;

    public DataBase(Connection novaConexão){
        conexão = novaConexão;
        updateDataBase = null;
    }

    public void createTables() {    
        try{
            
            updateDataBase = conexão.createStatement();
            updateDataBase.executeUpdate("create table if not exists professores (" 
                    + "codigoProfessor char(36) primary key, "
                    + "nome varchar(25) not null, " 
                    + "sobrenome varchar(50) not null, "
                    + "dataNascimento date not null, " 
                    + "pais char(3) not null, " 
                    + "disciplinaCodigo char(36), "
                    + "email varchar(60) not null unique, " 
                    + "senhaHash character(128) not null)");
        
            updateDataBase.executeUpdate("create table if not exists disciplina ("
                + "codigoDisciplina char(36) primary key, "
                + "nome varchar(40) not null,  "
                + "descricao varchar(60) not null unique)");

            updateDataBase.executeUpdate(
                "alter table professores add constraint Fk_disciplina foreign key (disciplinaCodigo) references disciplina (codigoDisciplina) ");

            updateDataBase.executeUpdate("create table if not exists postagem ("
                    + " codigoPostagem char(36) primary key," 
                    + " titulo varchar(25) not null,"
                    + " conteúdo varchar(250) not null," 
                    + " momento date not null,"
                    + " disciplinaPrincipal char(36),"
                    + " constraint fk_disciplinaPrincipal foreign key (disciplinaPrincipal) references disciplina (codigoDisciplina))");

            updateDataBase.executeUpdate("create table if not exists disciplinas_postagem("
                    + " codigoPostagem char(36) not null," 
                    + " codigoDisciplina char(36) not null,"
                    + " constraint pk_disciplinas_postagem primary key (codigoPostagem, codigoDisciplina),"
                    + " constraint fk_postagem foreign key (codigoPostagem) references postagem(codigoPostagem)," 
                    + " constraint fk_disciplina foreign key (codigoDisciplina) references disciplina(codigoDisciplina))");

            updateDataBase.executeUpdate("create table if not exists grupo ("
            + " codigoGrupo char(36) not null primary key,"
            + " nome varchar(30) not null,"
            + " descricao varchar(50) not null," 
            + " professorAdmin char(36) not null)");

            updateDataBase.executeUpdate("create table if not exists postagem_grupo("
            + " codigoPostagem char(36) not null,"
            + " codigoGrupo char (36) not null,"
            + " constraint pk_postagem_grupo primary key (codigoPostagem, codigoGrupo),"
            + " constraint fk_postagem_grupo foreign key (codigoPostagem) references postagem(codigoPostagem),"
            + " constraint fk_grupo_postagem foreign key (codigoGrupo) references grupo(codigoGrupo))");

            updateDataBase.executeUpdate("create table if not exists moderadores_grupo("
            + " codigoProfessor char(36) not null,"
            + " codigoGrupo char(36) not null,"
            + " constraint pk_moderadores_grupo primary key (codigoProfessor, codigoGrupo),"
            + " constraint fk_moderadores_grupo foreign key (codigoProfessor) references professores(codigoProfessor),"
            + " constraint fk_grupo_moderadores foreign key (codigoGrupo) references grupo(codigoGrupo))");

            updateDataBase.executeUpdate("create table if not exists participantes_grupo("
            + " codigoProfessor char(36) not null,"
            + " codigoGrupo char (36) not null,"
            + " constraint pk_participantes_grupo primary key (codigoProfessor, codigoGrupo),"
            + " constraint fk_participantes_grupo foreign key (codigoProfessor) references professores(codigoProfessor)," 
            + " constraint fk_grupo_participantes foreign key (codigoGrupo) references grupo(codigoGrupo))");

            updateDataBase.executeUpdate("create or replace function funcao_login (emailLogin IN varchar(60), senhaInformada IN character(128)) returns boolean AS $$"
            + "declare emailRetorno varchar(60); "
            + "begin select email into emailRetorno FROM professores WHERE email = emailLogin AND senhaHash = crypt(senhaInformada, senhaHash); "
            + "if(emailRetorno IS NOT NULL) THEN return true; else return false; end if;  "
            + "end; "
            + "$$ LANGUAGE plpgsql;");
            
            System.out.println("Tabelas criadas");
        
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
    }

}
