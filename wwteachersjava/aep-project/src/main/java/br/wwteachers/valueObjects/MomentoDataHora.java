package br.wwteachers.valueObjects;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

// import javax.swing.JOptionPane;

public class MomentoDataHora {

    private String dataHoraFormatada;
    private LocalDateTime dataHoraPadrão;
    
	public MomentoDataHora() {
        this.dataHoraPadrão = LocalDateTime.now();
        System.out.println(dataHoraPadrão.toString());
    }
    
    public MomentoDataHora(LocalDateTime dateTimeAtual) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.dataHoraFormatada = dateTimeAtual.format(formatter);
        this.dataHoraPadrão = dateTimeAtual;
    }
    
    public LocalDateTime getMomentoPadrao(){
        return this.dataHoraPadrão;
    }

    public String getMomentoFormatado() {
        return this.dataHoraFormatada;
    }

    public int getHora() {
        return this.dataHoraPadrão.getHour();
    }

    public int getMinuto() {
        return this.dataHoraPadrão.getMinute();
    }

    public int getDia() {
        return this.dataHoraPadrão.getDayOfMonth();
    }

    public int getMêsValor(){
        return this.dataHoraPadrão.getMonthValue();
    }

    public Month getMês() {
        return this.dataHoraPadrão.getMonth();
    }

    public int getAno(){
        return this.dataHoraPadrão.getYear();
    }

}
