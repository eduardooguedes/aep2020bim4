package br.wwteachers;

import br.wwteachers.acesso.MenuInicial;
import java.sql.SQLException;
import br.wwteachers.bancoDeDados.DataBase;
import br.wwteachers.bancoDeDados.GerenciadorDeConexão;

public class Application_wwt {
    public static void main(String[] args)  {

        // GerenciadorDeConexão conexão;
        // try{
        //     conexão = new GerenciadorDeConexão();
        //     System.out.println("Criando tabelas...");
        //     DataBase.createTables(conexão.getConexão());
        // }catch(SQLException e){
        //     e.printStackTrace();
        // }
        
        MenuInicial menu = new MenuInicial();
   
    }
}
