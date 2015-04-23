package ohtu.kivipaperisakset.pelimoodit;

import ohtu.kivipaperisakset.kirjanpito.IO;

public class PeliTehdas {
    
    public VsPelaaja vsPelaaja(IO io) {
        return new VsPelaaja(io);
    }
    
    public VsPerusTekoAly vsPerusTekoAly(IO io) {
        return new VsPerusTekoAly(io);
    }
    
    public VsParannettuTekoAly vsParannettuTekoAly(IO io) {
        return new VsParannettuTekoAly(io);
    }
    
    public VsRandomTekoAly vsRandomTekoAly(IO io) {
        return new VsRandomTekoAly(io);
    }
}
