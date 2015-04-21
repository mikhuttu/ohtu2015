package ohtu.kivipaperisakset.pelimoodit;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.kirjanpito.Tuomari;
import ohtu.kivipaperisakset.pelaajat.Ihminen;
import ohtu.kivipaperisakset.pelaajat.Pelaaja;

public abstract class PerusToiminnallisuus {
    protected final Tuomari tuomari;
    protected final Pelaaja pelaaja1;
    protected Pelaaja pelaaja2;
    
    public PerusToiminnallisuus(IO io) {
        this.tuomari = new Tuomari();
        this.pelaaja1 = new Ihminen(io);
    }
    
    protected boolean mahdollinenSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    public abstract void pelaa();
}
