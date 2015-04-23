package ohtu.kivipaperisakset.pelimoodit.siirrot;

import ohtu.kivipaperisakset.kirjanpito.Valinta;
import ohtu.kivipaperisakset.pelaajat.Pelaaja;

public abstract class SiirtoMenetelma {
    protected Pelaaja pelaaja;
    
    public SiirtoMenetelma(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }
    
    public abstract Valinta siirto();
}