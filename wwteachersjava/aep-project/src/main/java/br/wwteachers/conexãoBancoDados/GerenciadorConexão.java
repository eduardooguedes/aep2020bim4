package br.wwteachers.conexãoBancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Exception;
import java.lang.AutoCloseable;

public class GerenciadorConexão implements AutoCloseable {
    private Connection conexão = null;
    
    public GerenciadorConexão() throws ClassNotFoundException, SQLException {
        
        Class.forName("org.postgresql.Driver");

        conexão = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/wwteachers", "postgres", "postgres");
            conexão.setAutoCommit(false);
    }

    public Connection getConexão() {
        return conexão;
    }

    public void close() throws Exception {
        conexão.close();
    }

}
