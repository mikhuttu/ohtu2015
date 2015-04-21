package Komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Summa extends Komento {

    public Summa(Sovelluslogiikka sovellus, JTextField tulosK, JTextField syoteK) {
        super(sovellus, tulosK, syoteK);
    }
    
    @Override
    public void suorita() {
        this.sovellus.plus(syoteKentanArvo());
        paivitaKentatKomennonSuorituksenJalkeen();
    }
}
