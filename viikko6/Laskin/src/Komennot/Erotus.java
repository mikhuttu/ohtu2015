package Komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Erotus extends Komento {

    public Erotus(Sovelluslogiikka sovellus, JTextField tulosK, JTextField syoteK) {
        super(sovellus, tulosK, syoteK);
    }
    
    @Override
    public void suorita() {
        this.sovellus.miinus(syoteKentanArvo());
        paivitaKentatKomennonSuorituksenJalkeen();
    }
}