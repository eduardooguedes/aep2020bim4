package br.wwteachers.valueObjects;

public class Email {

    private String value;

    public Email(String email){
        if(validarEmail(email)){
            this.value = email;
        }
        else{
            this.value = null;
        }
    }

    private boolean validarEmail(String email) {
        return true;
    }

    public String getEmail() {
        return value;
    }
    
}
