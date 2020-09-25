package classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import valueObjects.*;

public class Grupo {
    
    private Código códigoGrupo;
    private String nomeGrupo;
    private String descriçãoGrupo;
    private Professor professorAdmin;

    List<Professor> listaModeradores = new ArrayList<Professor>();
    HashSet<Professor> listaParticipantes = new HashSet<Professor>();
    HashSet<Postagem> postagensGrupo = new HashSet<Postagem>();

    private Chat chatGrupo = new Chat("Grupo", 1);

    public Grupo(int códigoGrupo, String nomeGrupo, String descriçãoGrupo, Professor professor){
        this.códigoGrupo = new Código(códigoGrupo, "Grupo");
        this.nomeGrupo = nomeGrupo;
        this.descriçãoGrupo = descriçãoGrupo;
        this.professorAdmin = professor;
    }

    public void adicionarProfessor(Professor professor){
        listaParticipantes.add(professor);
    }    

    public void escolherModeradores(){
        for(Professor participante : listaParticipantes){
            if(participante.equals("Eduardo")){
                listaModeradores.add(participante);
            }    
        }
    }

    public void criarPostagemGrupo(){
        Postagem postagem = new Postagem(7, "Leões", "Esse grupo só tem fera");
        postagensGrupo.add(postagem);
    }

}
