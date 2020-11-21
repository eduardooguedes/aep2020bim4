package br.wwteachers.valueObjects;

public class Senha {
    
    private String senha;

    public Senha(String senha) {
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha;
    }
}