import java.util.ArrayList;
import java.util.List;

import valueObjects.*;
import classes.*;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //Professor iago = new Professor();
        List<País> listaPais = new ArrayList<>();
        País brasil = new País("Brasil");
        
        listaPais.add(brasil);

        for(País pais : listaPais){
            System.out.println(pais.getPais());
        }

    }

}