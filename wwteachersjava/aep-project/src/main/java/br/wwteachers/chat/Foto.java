package br.wwteachers.chat;

public class Foto {
    
    private String caminhoArquivo;

    public Foto(String caminhoArquivo){
        this.caminhoArquivo = caminhoArquivo;
    }

    public String getArquivoFoto(){
        return this.caminhoArquivo;
    } 

}
