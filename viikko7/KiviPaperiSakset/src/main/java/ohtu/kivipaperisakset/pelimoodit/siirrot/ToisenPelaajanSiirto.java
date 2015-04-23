package ohtu.kivipaperisakset.pelimoodit.siirrot;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.kirjanpito.Valinta;
import ohtu.kivipaperisakset.pelaajat.Ihminen;

public class ToisenPelaajanSiirto extends SiirtoMenetelma {
    private final IO io;
    
    public ToisenPelaajanSiirto(IO io) {
        super(new Ihminen(io));
        this.io = io;
    }
    
    @Override
    public Valinta siirto() {
        io.print("Toisen pelaajan siirto: ");
        return pelaaja.annaSiirto();
    }
}