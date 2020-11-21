package wwteachers.src.valueObjects;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataNascimento {

    private String dataFormatada;
    private LocalDate dataPadrao;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DataNascimento(String data) {
        if(validarData(data)){
            String[] newData = data.split("/");
            this.dataPadrao = LocalDate.of(Integer.parseInt(newData[2]), Integer.parseInt(newData[1]), Integer.parseInt(newData[0]));
            this.dataFormatada = dataPadrao.format(formatter);
        }else{
            this.dataPadrao = null;
        }
        
    }

	private boolean validarData(String data) {
        
        
        return true;
    }

    public String getDataFormatada() {
        return dataFormatada;
    }

    public LocalDate getDataPadrao(){
        return dataPadrao;
    }

    public int getDia() {
        return dataPadrao.getDayOfMonth();
    }

    public DayOfWeek getDiaSemana() {
        return dataPadrao.getDayOfWeek();
    }

	public int getMes() {
		return dataPadrao.getMonthValue();
	}

	public int getYear() {
		return dataPadrao.getYear();
	}
}
