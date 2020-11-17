package br.wwteachers.comunidade;

import br.wwteachers.chat.Chat;
import br.wwteachers.valueObjects.Código;

public class Disciplina {
    
    private Código código;
    private String nome;
    private String descrição;
    
    private Chat chat;

    public Disciplina(String código){
        this.código = new Código("Disciplina", código);
    }

    public Disciplina(String nomeDisciplina, String descriçãoDisciplina){
        this.código = new Código("Disciplina");
        this.nome = nomeDisciplina;
        setDescricao(descriçãoDisciplina);
        setNovoChat();
    }


	public String getCódigo(){
        return this.código.getCodigo();
    }

    public String getNome(){
        return this.nome;
    }
    
    private void setDescricao(String descriçãoDisciplina) {
        if(descriçãoDisciplina.length() < 10){
            throw new RuntimeException("Descrição muito pequena.");
        }

        this.descrição = descriçãoDisciplina;
    }
    
    public String getDescrição(){
        return this.descrição;
    }

    public Chat getChat(){
        return this.chat;
    }

    private void setNovoChat() {
        this.chat = new Chat("Disciplina");
    } 
}
