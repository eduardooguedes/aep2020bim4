package classes;

import java.util.ArrayList;
import java.util.List;

public class Disciplina{
    
    private String nomeDisciplina;
    private AreaDisciplina areaDisciplina;
    private String descriçãoDisciplina;
    
    public Disciplina(String nomeDisciplina, AreaDisciplina areaDisciplina, String descriçãoDisciplina){
        setNomeDisciplina(nomeDisciplina);
        this.areaDisciplina = areaDisciplina;
        setDescricaoDisciplina(descriçãoDisciplina);
    }

    private void setDescricaoDisciplina(String descriçãoDisciplina) {
        this.descriçãoDisciplina = descriçãoDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }




}
