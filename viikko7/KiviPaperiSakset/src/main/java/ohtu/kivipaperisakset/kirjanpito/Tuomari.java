package ohtu.kivipaperisakset.kirjanpito;

import static ohtu.kivipaperisakset.kirjanpito.Valinta.*;

public class Tuomari {
    private int ekanPisteet;
    private int tokanPisteet;
    private int tasapelit;

    public Tuomari() {
        this.ekanPisteet = 0;
        this.tokanPisteet = 0;
        this.tasapelit = 0;
    }

    public void kirjaaSiirto(Valinta ekanSiirto, Valinta tokanSiirto) {
        if (ekaVoittaa(ekanSiirto, tokanSiirto)) {
            ekanPisteet++;
        }
        else if (ekaVoittaa(tokanSiirto, ekanSiirto)) {
            tokanPisteet++;
        }
        else {
            tasapelit++;
        }
    }

    private boolean ekaVoittaa(Valinta eka, Valinta toka) {
        return eka == KIVI && toka == SAKSET ||
               eka == SAKSET && toka == PAPERI ||
               eka == PAPERI && toka == KIVI;
    }

    @Override
    public String toString() {
        return "Pelitilanne: " + ekanPisteet + " - " + tokanPisteet + "\n"
                + "Tasapelit: " + tasapelit;
    }
}