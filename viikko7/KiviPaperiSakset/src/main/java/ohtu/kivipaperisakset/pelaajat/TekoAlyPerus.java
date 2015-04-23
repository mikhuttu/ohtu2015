package ohtu.kivipaperisakset.pelaajat;

import ohtu.kivipaperisakset.kirjanpito.Valinta;
import static ohtu.kivipaperisakset.kirjanpito.Valinta.*;

public class TekoAlyPerus implements Pelaaja {
    private Valinta valinta;

    public TekoAlyPerus() {
        this.valinta = KIVI;
    }
    
    @Override
    public Valinta annaSiirto() {
        if (valinta == KIVI) {
            valinta = PAPERI;
        }
        else if (valinta == PAPERI) {
            valinta = SAKSET;
        }
        else {
            valinta = KIVI;
        }
        
        return valinta;
    }
}
