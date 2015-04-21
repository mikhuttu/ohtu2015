
package com.mycompany.webkauppa.model.tietokantayhteydet;

import com.mycompany.webkauppa.sovelluslogiikka.Tuote;
import java.util.*;

public class TuoteDAOInMemory implements TuoteDAO {
    private ArrayList<Tuote> tuotteet;
    private long id;
    
    public TuoteDAOInMemory() {
        tuotteet = new ArrayList<>();
        
        tuotteet.add( new Tuote(1, "Fink Bräu", 1) );
        tuotteet.add( new Tuote(2, "Karjala", 2) );
        tuotteet.add( new Tuote(3, "Huvila Pale Ale", 4) );
        tuotteet.add( new Tuote(4, "Nögne IPA", 7) );
        tuotteet.add( new Tuote(5, "Weihenstephaner", 4) );
       
        tuotteet.stream().forEach((tuote) -> {
            tuote.setSaldo(100);
        });
        
        id = 6;
    }
    
    @Override
    public List<Tuote> findAll() {
        return tuotteet;
    }

    @Override
    public void save(Tuote tuote) { 
        if ( tuote.getId()==0 ) {
            tuote.setId(++id);
            System.out.println( "saved " + tuote.getNimi() );
        }
    }
    
}
