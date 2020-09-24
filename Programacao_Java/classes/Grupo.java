package classes;

import valueObjects.*;

public class Grupo {
    
    private Código códigoGrupo;
    private String nomeGrupo;
    private String descriçãoGrupo;

    private Chat chatGrupo = new Chat("Grupo", 0);

    public Grupo(int códigoGrupo, String nomeGrupo, String descriçãoGrupo){
        this.códigoGrupo = new Código(códigoGrupo, "Grupo");
        this.nomeGrupo = nomeGrupo;
        this.descriçãoGrupo = descriçãoGrupo;
    }


}
