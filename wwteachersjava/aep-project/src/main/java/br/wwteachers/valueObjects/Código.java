package br.wwteachers.valueObjects;

import java.util.UUID;

public class Código {
    
    private String códigoCadastro;
    private String tipoCódigo;

	public Código(String tipoCódigo) {
        códigoCadastro = UUID.randomUUID().toString();
        this.tipoCódigo = tipoCódigo;
	}
    

	public Código(String tipoCódigo, String código) {
        this.tipoCódigo = tipoCódigo;
        this.códigoCadastro = código;
    }


	public String getCodigo(){
        return códigoCadastro;
    }

    public String getTipoCódigo(){
        return this.tipoCódigo;
    }
}
