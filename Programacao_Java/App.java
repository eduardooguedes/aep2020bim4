import java.io.DataInput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import valueObjects.*;
import classes.*;

public class App {

    public static void main(String[] args) throws ParseException {
        System.out.println("Hello World!");

        String str = "25/07/1996";
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatador.parse(str);
        // (1996, 07, 25);

        Professor iago = new Professor(1, "Iago", "da Costa", data, País.BRA, "iago.cland@gmail.com", "iago#fela@aepchegando");
        
        System.out.println(iago.getDadosProfessor());

        
    }

}