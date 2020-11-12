package wwteachers.src.classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import wwteachers.src.valueObjects.Código;

public class Grupo {
    
    private Código código;
    private String nome;
    private String descrição;
    private Professor professorAdmin;

    List<Professor> listaModeradores = new ArrayList<Professor>();
    HashSet<Professor> listaParticipantes = new HashSet<Professor>();
    HashSet<Postagem> postagensGrupo = new HashSet<Postagem>();

    private Chat chat;

    public Grupo(String nomeGrupo, String descriçãoGrupo, Professor professorAdmin){
        this.código = setcódigo();
        this.nome = nomeGrupo;
        this.descrição = descriçãoGrupo;
        this.professorAdmin = professorAdmin;
        setNovoChat();
    }
    
    private Código setcódigo() {
        return new Código("Grupo");
    }
    
    public String getcódigo(){
        return this.código.getCodigo();
    }
    
    public String getNome(){
        return nome;
    }

    public void setNovoNome(String novoNome){
        this.nome = novoNome;
    }
    
    public String getDescrição(){
        return this.descrição;
    }

    public void setNovaDescrição(String novaDescrição){
        this.descrição = novaDescrição;
    }
    
    public Professor getAdministrador(){
        return this.professorAdmin;
    }
    
    public void setNovoAdministrador(Professor novoAdministrador){
        this.professorAdmin = novoAdministrador;
    }
    
    public void adicionarProfessor(Professor professor) {
        listaParticipantes.add(professor);
    }    
    
    public void escolherModeradores(Professor novoModerador){
        for(Professor participante : listaParticipantes){
            if(participante.equals(novoModerador)){
                listaModeradores.add(participante);
            }    
        }
    }
    
    public Chat getChat(){
        return this.chat;
    }
    
    private void setNovoChat() {
        this.chat = new Chat("Grupo");
    }  

    // public void criarPostagemGrupo(){
        //     Postagem postagem = new Postagem(7, "Leões", "Esse grupo só tem fera");//EXEMPLO
        //     postagensGrupo.add(postagem);
    // }
}
