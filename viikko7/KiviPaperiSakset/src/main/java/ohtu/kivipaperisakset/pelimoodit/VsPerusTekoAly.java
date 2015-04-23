package ohtu.kivipaperisakset.pelimoodit;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.pelaajat.TekoAlyPerus;
import ohtu.kivipaperisakset.pelimoodit.siirrot.TekoAlynSiirto;

public class VsPerusTekoAly extends Peli {
    
    public VsPerusTekoAly(IO io) {
       super(io, new TekoAlynSiirto(new TekoAlyPerus()));
    }
}