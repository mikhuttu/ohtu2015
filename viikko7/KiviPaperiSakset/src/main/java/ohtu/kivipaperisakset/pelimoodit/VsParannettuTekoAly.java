package ohtu.kivipaperisakset.pelimoodit;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.pelaajat.TekoAlyParannettu;
import ohtu.kivipaperisakset.pelimoodit.siirrot.ParannetunTekoAlynSiirto;

public class VsParannettuTekoAly extends Peli {
    
    public VsParannettuTekoAly(IO io) {
        super(io, new ParannetunTekoAlynSiirto(new TekoAlyParannettu(20)));
    }
}
