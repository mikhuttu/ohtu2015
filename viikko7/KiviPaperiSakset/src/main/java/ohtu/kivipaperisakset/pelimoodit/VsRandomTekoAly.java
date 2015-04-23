package ohtu.kivipaperisakset.pelimoodit;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.pelaajat.TekoAlyRandom;
import ohtu.kivipaperisakset.pelimoodit.siirrot.TekoAlynSiirto;

public class VsRandomTekoAly extends Peli {
    
    public VsRandomTekoAly(IO io) {
        super(io, new TekoAlynSiirto(new TekoAlyRandom()));
    }
}
