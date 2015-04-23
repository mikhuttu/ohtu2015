package ohtu.kivipaperisakset.kirjanpito;

import static ohtu.kivipaperisakset.kirjanpito.Valinta.valintana;

public class IOValintaMuuntaja {

    public Valinta muunnaValinnaksi(String line) {
        if (line.length() > 1) {
            throw new IllegalArgumentException();
        }
        
        return valintana(line.charAt(0));
    }
}