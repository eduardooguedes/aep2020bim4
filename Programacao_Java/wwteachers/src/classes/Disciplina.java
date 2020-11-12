package wwteachers.src.classes;

import wwteachers.src.valueObjects.Código;

public class Disciplina{
    
    private Código código;
    private String nome;
    private String descrição;
    
    private Chat chat;

    public Disciplina(String nomeDisciplina, String descriçãoDisciplina){
        this.código = setCódigo();
        this.nome = nomeDisciplina;
        setDescricao(descriçãoDisciplina);
        setNovoChat();
    }

    public String getCódigo(){
        return this.código.getCodigo();
    }
    
    private Código setCódigo() {
        return new Código("Disciplina");
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
