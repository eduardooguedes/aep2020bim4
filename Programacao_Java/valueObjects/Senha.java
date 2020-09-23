package valueObjects;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Senha {
    
    private String senha;
    private String senhaCriptografada;

    public Senha(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.senha = senha;
        this.senhaCriptografada = digest(senha);
    }

    public String digest(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte digestMessage[] = algoritmo.digest(password.getBytes("UTF-8"));
        StringBuilder hexPassword = new StringBuilder();
        for (byte aByte : digestMessage) {
            hexPassword.append(String.format("%02X", 0xFF & aByte));
        }
        return hexPassword.toString();
    }

    @Override
    public String toString() {
        return "Senha: " + senhaCriptografada;
    }
}