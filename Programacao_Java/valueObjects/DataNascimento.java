package valueObjects;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataNascimento {
    
    private String dataFormatada;

    public DataNascimento(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataFormatada = date.format(formatter);
    }

    public String getData(){
        return dataFormatada;
    }
}
