package valueObjects;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataNascimento {

    private String dataFormatada;
    private LocalDate dataPadrao;

    public DataNascimento(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataPadrao = date;
        this.dataFormatada = date.format(formatter);
    }

    public String getDataCompleta() {
        return dataFormatada;
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
