package ohtu.kivipaperisakset.pelaajat;

import java.util.Random;
import ohtu.kivipaperisakset.kirjanpito.Valinta;
import static ohtu.kivipaperisakset.kirjanpito.Valinta.*;

public class TekoAlyRandom implements Pelaaja {

    @Override
    public Valinta annaSiirto() {
        int arpa = new Random().nextInt(3);
        
        if (arpa == 0) return KIVI;
        if (arpa == 1) return PAPERI;
        if (arpa == 2) return SAKSET;
        
        throw new IllegalStateException("Random functioning in an unexpected way.");
    }
}