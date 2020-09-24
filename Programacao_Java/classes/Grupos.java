package classes;

import valueObjects.*;

public class Grupos {
    
    private Código códigoGrupo;
    private Nome nomeGrupo;
    private String descriçãoGrupo;

    public Grupo(int códigoGrupo, String nomeGrupo, String descriçãoGrupo){
        this.códigoGrupo = new Código(códigoGrupo, "Grupo");
        this.nomeGrupo = new Nome(nomeGrupo);
        this.descriçãoGrupo = descriçãoGrupo;
    }
}
