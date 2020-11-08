package classes;

import java.util.ArrayList;
import java.util.List;

import valueObjects.*;

public class Chat {
    
    private Código códigoChat;
    private String tipo;

    private List<Mensagem> mensagensChat = new ArrayList<Mensagem>();

    public Chat(String tipoChat){
        this.tipo = tipoChat;
        this.códigoChat = new Código("Chat");
    }

    public void adicionarMensagem(Professor professor, String texto){
        Mensagem mensagem = new Mensagem(professor, texto);
        mensagensChat.add(mensagem);
    }

}
