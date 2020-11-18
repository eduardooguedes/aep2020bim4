package br.wwteachers.valueObjects;

import static java.lang.Integer.parseInt;

import java.sql.Date;
// import java.time.format.DateTimeFormatter;

public class DataNascimento {

    private Date dataPadrao;
    // private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DataNascimento(String data) {
        if(validarData(data)){
            String[] newData = data.split("/");
            this.dataPadrao = new Date(Integer.parseInt(newData[0]), Integer.parseInt(newData[1]), parseInt(newData[0]));
        }else{
            this.dataPadrao = null;
        }
    }

	public DataNascimento(Date date) {
        this.dataPadrao = date;
	}

	private boolean validarData(String data) {
        
        
        return true;
    }

    public Date getDataPadrao(){
        return dataPadrao;
    }

    public int getDia() {
        return dataPadrao.getDate();
    }

    public int getDiaSemana() {
        return dataPadrao.getDay();
    }

	public int getMes() {
		return dataPadrao.getMonth();
	}

	public int getYear() {
		return dataPadrao.getYear();
	}
}
