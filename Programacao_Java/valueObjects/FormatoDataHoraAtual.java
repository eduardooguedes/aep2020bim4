package valueObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// import javax.swing.JOptionPane;

public class FormatoDataHoraAtual {

    private String dateTimeFormatado;

	public FormatoDataHoraAtual(LocalDateTime dateTimeAtual) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.dateTimeFormatado = dateTimeAtual.format(formatter);
        
        // JOptionPane.showMessageDialog(null, "Data/hora formatada ["+ dateTimeFormatado + "]");
    }
    
}
