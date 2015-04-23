package ohtu.kivipaperisakset.pelimoodit.siirrot;

import ohtu.kivipaperisakset.kirjanpito.Valinta;
import ohtu.kivipaperisakset.pelaajat.Pelaaja;
import ohtu.kivipaperisakset.pelaajat.TekoAlyParannettu;

public class ParannetunTekoAlynSiirto extends TekoAlynSiirto {

    public ParannetunTekoAlynSiirto(Pelaaja tekoAly) {
        super(tekoAly);
    }
    
    public void asetaSiirto(Valinta pelaajanSiirto) {
        TekoAlyParannettu tekoAly = (TekoAlyParannettu) pelaaja;
        tekoAly.asetaSiirto(pelaajanSiirto);
    }
}