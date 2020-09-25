package classes;

import java.util.ArrayList;
import java.util.List;

public class Disciplina{
    
    private int códigoDisciplina;
    private String nomeDisciplina;
    private String descriçãoDisciplina;
    
    private Chat chatDisciplina = new Chat("Disciplina", 2);

    public Disciplina(int códigoDisciplina, String nomeDisciplina, String descriçãoDisciplina){
        this.códigoDisciplina = códigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        setDescricaoDisciplina(descriçãoDisciplina);
    }

    private void setDescricaoDisciplina(String descriçãoDisciplina) {
        if(descriçãoDisciplina.length() < 10){
            throw new RuntimeException("Descrição muito pequena.");
        }

        this.descriçãoDisciplina = descriçãoDisciplina;
    }

    public String getNomeDisciplina(){
        return nomeDisciplina;
    }

    public String getDescriçãoDisciplina(){
        return descriçãoDisciplina;
    }

}
