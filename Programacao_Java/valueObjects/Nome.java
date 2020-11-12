package valueObjects;

public class Nome {
    
    private String value;

    public Nome(String value) {
            if(validarNome(value)){
                this.value = value;
            }
            else{
                throw new RuntimeException();
            }
    }
    
    public String getNome(){
        return value;
    }

    private boolean validarNome(String nome){
        if(nome.length() < 2 || !(nome.matches("^[A-Za-z]*$"))){
            return false;
        }
        return true;
    }

}
