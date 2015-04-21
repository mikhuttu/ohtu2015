
package com.mycompany.webkauppa.model.tietokantayhteydet;

import com.mycompany.webkauppa.sovelluslogiikka.Tuote;
import java.util.*;

<<<<<<< HEAD
public class TuoteDAOInMemory extends TuoteDAO {
    public static TuoteDAO getInMemoryDAO(){
        return new TuoteDAOInMemory();
    }
    
=======
public class TuoteDAOInMemory implements TuoteDAO {
>>>>>>> mluukkai-lokaali
    private ArrayList<Tuote> tuotteet;
    private long id;
    
    public TuoteDAOInMemory() {
<<<<<<< HEAD
        tuotteet = new ArrayList<Tuote>();
=======
        tuotteet = new ArrayList<>();
        
>>>>>>> mluukkai-lokaali
        tuotteet.add( new Tuote(1, "Fink Bräu", 1) );
        tuotteet.add( new Tuote(2, "Karjala", 2) );
        tuotteet.add( new Tuote(3, "Huvila Pale Ale", 4) );
        tuotteet.add( new Tuote(4, "Nögne IPA", 7) );
        tuotteet.add( new Tuote(5, "Weihenstephaner", 4) );
<<<<<<< HEAD
        for (Tuote tuote : tuotteet) {
            tuote.setSaldo(100);
        }
        id = 6;
    }        
=======
       
        tuotteet.stream().forEach((tuote) -> {
            tuote.setSaldo(100);
        });
        
        id = 6;
    }
>>>>>>> mluukkai-lokaali
    
    @Override
    public List<Tuote> findAll() {
        return tuotteet;
    }

    @Override
    public void save(Tuote tuote) { 
        if ( tuote.getId()==0 ) {
            tuote.setId(++id);
<<<<<<< HEAD
            System.out.println( "saved "+tuote.getNimi() );
=======
            System.out.println( "saved " + tuote.getNimi() );
>>>>>>> mluukkai-lokaali
        }
    }
    
}
