package ohtu.kivipaperisakset.pelimoodit;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.pelimoodit.siirrot.ToisenPelaajanSiirto;

public class VsPelaaja extends Peli {
    
    public VsPelaaja(IO io) {
        super(io, new ToisenPelaajanSiirto(io));
    }
}