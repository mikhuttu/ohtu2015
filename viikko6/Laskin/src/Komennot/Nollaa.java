package Komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Nollaa extends Komento {
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tulosK, JTextField syoteK) {
        super(sovellus, tulosK, syoteK);
    }
    
    @Override
    public void suorita() {
        this.sovellus.nollaa();
        paivitaKentatKomennonSuorituksenJalkeen();
    }
}
