package com.mycompany.webkauppa.model.tietokantayhteydet;

import com.mycompany.webkauppa.sovelluslogiikka.Tuote;
import java.util.List;

public interface TuoteDAO {
    public List<Tuote> findAll();
    public void save(Tuote tuote);
}
