package classes;

import java.util.ArrayList;
import java.util.List;

import valueObjects.Código;

public class Disciplina{
    
    private Código códigoDisciplina;
    private String nome;
    private String descrição;
    
    private Chat chatDisciplina = new Chat("Disc");

    public Disciplina(int códigoDisciplina, String nomeDisciplina, String descriçãoDisciplina){
        this.códigoDisciplina = new Código("Disc");
        this.nome = nomeDisciplina;
        setDescricao(descriçãoDisciplina);
    }

    private void setDescricao(String descriçãoDisciplina) {
        if(descriçãoDisciplina.length() < 10){
            throw new RuntimeException("Descrição muito pequena.");
        }

        this.descrição = descriçãoDisciplina;
    }

    public String getNome(){
        return this.nome;
    }

    public String getDescrição(){
        return this.descrição;
    }

}
