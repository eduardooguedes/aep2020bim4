package ValueObjects;

import java.util.ArrayList;

public class País {
    
    private String nomePaís;

    private List listaPaís = new ArrayList<>();
    
    listaPaís.add('BRASIL');
    listaPaís.add('INGLATERRA');
    listaPaís.add('JAMAICA');
    listaPaís.add('HAITI');
    listaPaís.add('CHILE');
    listaPaís.add('PARAGUAI');
    listaPaís.add('ESTADOS UNIDOS');
    listaPaís.add('ARGENTINA');
    listaPaís.add('ALEMANHA');
    listaPaís.add('RUSSIA');
    listaPaís.add('JAPÃO');
    listaPaís.add('CHINA');
    listaPaís.add('AUSTRALIA');
    listaPaís.add('ITALIA');
    //listaPaís.add('');

    public País(País nomePaís){
        if(verificaPaísLista(nomePaís)){
            this.nomePaís = nomePaís;
        }
        throw new RuntimeException("País não existe!");
    }

    public boolean verificaPaísLista(País nomePaís){
        for(nomePaís nome in listaPaís){
            if(nomePaís.equals(nome)){
                return true;
            }
            return false;
        }
    }
}
