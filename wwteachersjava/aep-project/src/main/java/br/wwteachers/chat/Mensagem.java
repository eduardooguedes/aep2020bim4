package br.wwteachers.chat;

import java.time.LocalDateTime;

import br.wwteachers.professor.Professor;
import br.wwteachers.valueObjects.MomentoDataHora;

public class Mensagem {
    
    private Professor professor;
    private String mensagem;
    private MomentoDataHora momentoMensagem;

    public Mensagem(Professor professor, String mensagem){
        this.professor = professor;
        this.mensagem = mensagem;
        this.momentoMensagem = new MomentoDataHora();
    }

    public Professor getProfessor(){
        return this.professor;
    }

    public String getMensagem(){
        return this.mensagem;
    }   

    public LocalDateTime getMomento(){
        return this.momentoMensagem.getMomentoPadrao();
    }
    
}

