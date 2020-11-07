package valueObjects;

import java.util.UUID;

public class Código {
    
    private String códigoCadastro;
    private String tipoCódigo;

	public Código(String tipoCódigo) {
        códigoCadastro = UUID.randomUUID().toString();
        this.tipoCódigo = tipoCódigo;
	}
    

}
