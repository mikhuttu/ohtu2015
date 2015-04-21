package com.mycompany.webkauppa.model.tietokantayhteydet;

import com.mycompany.webkauppa.sovelluslogiikka.Tuote;
import java.util.List;

<<<<<<< HEAD
public abstract class TuoteDAO {

//    public static TuoteDAO forHibernate(){
//        return TuoteDAOHibernate.getInstance();
//    }
    
    public static TuoteDAO inMemory(){
        return TuoteDAOInMemory.getInMemoryDAO();
    }

    public abstract List<Tuote> findAll();

    public abstract void save(Tuote tuote);
    
=======
public interface TuoteDAO {
    public List<Tuote> findAll();
    public void save(Tuote tuote);
>>>>>>> mluukkai-lokaali
}
