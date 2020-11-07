package valueObjects;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// import javax.swing.JOptionPane;

public class InstanteDataHora{

    private String dataHoraFormatada;

	public InstanteDataHora(LocalDateTime dateTimeAtual) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.dataHoraFormatada = dateTimeAtual.format(formatter);
        
        // JOptionPane.showMessageDialog(null, "Data/hora formatada ["+ dateTimeFormatado + "]");
    }  
    
    public String getInstante(){
        return this.dataHoraFormatada;
    }

}
