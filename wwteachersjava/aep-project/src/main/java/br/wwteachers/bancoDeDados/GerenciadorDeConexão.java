package br.wwteachers.bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorDeConexão implements AutoCloseable {
    private Connection conexão = null;

    public GerenciadorDeConexão() throws SQLException {
        conexão = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/wwteachers", "postgres", "postgres");
            conexão.setAutoCommit(false);
    }

    public Connection getConexão() {
        return conexão;
    }

    public void close() throws Exception {
        System.out.println("GerenciadorDeConexão fechando! :)");
        if (conexão != null) {
            conexão.close();
        }
    }

}
