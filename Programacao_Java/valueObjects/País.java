package valueObjects;

import java.util.ArrayList;
import java.util.List;

public class País {
    
    private String nomePaís;

    public País(String nomePais) {
        this.nomePaís = nomePais;
    }

    List<String> listaPais = new ArrayList<>();

    public void adicionarLista(String pais){
        listaPais.add(pais);
    }

    public String getPais(){
        return this.nomePaís;
    }
    
    // listaPais.add('Brasil');
    // listaPaís.add('INGLATERRA');
    // listaPaís.add('JAMAICA');
    // listaPaís.add('HAITI');
    // listaPaís.add('CHILE');
    // listaPaís.add('PARAGUAI');
    // listaPaís.add('ESTADOS UNIDOS');
    // listaPaís.add('ARGENTINA');
    // listaPaís.add('ALEMANHA');
    // listaPaís.add('RUSSIA');
    // listaPaís.add('JAPÃO');
    // listaPaís.add('CHINA');
    // listaPaís.add('AUSTRALIA');
    // listaPaís.add('ITALIA');
    //listaPaís.add('');

    // public País(String nomePaís){
    //     if(verificaPaísLista(nomePaís)){
    //         this.nomePaís = nomePaís;
    //     }
    //     throw new RuntimeException("País não existe!");
    // }

    public boolean verificaPaísLista(String nomePaís){
        for(String nome : listaPais){
            if(nomePaís.equals(nome)){
                return true;
            }
        }
        return false;
    }
}
