package ohtu.kivipaperisakset.pelaajat;

import ohtu.kivipaperisakset.kirjanpito.IO;

public class Ihminen implements Pelaaja {
    private final IO io;
    
    public Ihminen(IO io) {
        this.io = io;
    }
    
    @Override
    public String annaSiirto() {
        return io.next();
    }
}