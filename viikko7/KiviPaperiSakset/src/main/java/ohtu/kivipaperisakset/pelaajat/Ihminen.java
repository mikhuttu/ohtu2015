package ohtu.kivipaperisakset.pelaajat;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.kirjanpito.IOValintaMuuntaja;
import ohtu.kivipaperisakset.kirjanpito.Valinta;

public class Ihminen implements Pelaaja {
    private final IO io;
    
    public Ihminen(IO io) {
        this.io = io;
    }
    
    @Override
    public Valinta annaSiirto() {
        String line = io.nextLine();
        return new IOValintaMuuntaja().muunnaValinnaksi(line);
    }
}