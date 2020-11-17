package br.wwteachers.valueObjects;

public class Senha {
    
    private String senhaHash;
    private String sal;

    public Senha(String senha) {
        this.senhaHash = hash(senha);
    }

    //GERAR HASH
    private String hash(String senha) {
        return senha;
    }

    public String getSenhaHash(){
        return this.senhaHash;
    }

    public String getSal() {
        return sal;
    }

    //UTILIZAR SAL GERADO
    public static String verificaSenha(String senhaLogin, String sal){
        return senhaLogin;
    }
}