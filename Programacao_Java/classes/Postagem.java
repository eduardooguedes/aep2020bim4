package classes;

import java.sql.Date;

import valueObjects.*;

public class Postagem {
    
    private Código códigoPostagem;
    private String títuloPostagem;
    private String conteúdoPostagem;
    private Date dataPostagem;  

    public Postagem(int códigoPostagem, String títuloPostagem, String conteúdoPostagem, Date dataAtual){
        this.códigoPostagem = new Código(códigoPostagem, "Postagem");
        this.títuloPostagem = títuloPostagem;
        this.conteúdoPostagem = conteúdoPostagem;
        this.dataPostagem = dataAtual;
    }

    s


}
