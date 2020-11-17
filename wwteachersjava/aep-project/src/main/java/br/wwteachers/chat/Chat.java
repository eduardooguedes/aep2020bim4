package br.wwteachers.chat;

import java.util.ArrayList;
import java.util.List;

import br.wwteachers.professor.Professor;
import br.wwteachers.valueObjects.Código;

public class Chat {

    private Código código;
    private String tipo;

    private List<Mensagem> mensagensChat = new ArrayList<Mensagem>();

    public Chat(String tipoChat) {
        this.tipo = tipoChat;
        this.código = setCódigo();
    }

    public String getCódigo() {
        return código.getCodigo();
    }

    private Código setCódigo(){
        return new Código("Chat");
    }

    public void adicionarMensagem(Professor professor, String texto) {
        Mensagem mensagem = new Mensagem(professor, texto);
        mensagensChat.add(mensagem);
    }

    public List<Mensagem> getListaMensagens() {
        return mensagensChat;
    }

    public String getTipo() {
        return tipo;
    }

    
}

