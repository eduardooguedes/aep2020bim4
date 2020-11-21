package br.wwteachers.valueObjects;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Email {

    private String value;
    private Boolean validado;

    public Email(String email){
        if(validarEmail(email)){
            this.value = email;
            this.validado = true;
        }
        else{
            this.value = null;
            this.validado = false;
        }
    }

    public boolean validarEmail(String email) {
        Boolean valido=false;
        try {
            // Create InternetAddress object and validated the supplied
            // address which is this case is an email address.
            InternetAddress endereçoEmail = new InternetAddress(email);
            endereçoEmail.validate();
            valido = true;
        } catch (AddressException e) {
            e.printStackTrace();
        }        
        return valido;
    }

    public String getEmail() {
        return value;
    }

	public Boolean getBoolean() {
		return this.validado;
	}
    
}
