package br.wwteachers.chat;

import java.time.LocalDateTime;

import br.wwteachers.professor.Professor;

public class Mensagem {
    
    private Professor professor;
    private String mensagem;
    private LocalDateTime horaMensagem;
    private Foto foto;

    public Mensagem(Professor professor, String mensagem){
        this.professor = professor;
        this.mensagem = mensagem;
        this.horaMensagem = LocalDateTime.now();
    }

    public Mensagem(Professor professor, String mensagem, Foto foto){
        this(professor, mensagem);
        this.foto = foto;
    }
    
    public Professor getProfessor(){
        return this.professor;
    }

    public String getMensagem(){
        return this.mensagem;
    }

    public LocalDateTime getDateTime(){
        return this.horaMensagem;
    }

    public Foto getFoto(){
        return this.foto;
    }
}

