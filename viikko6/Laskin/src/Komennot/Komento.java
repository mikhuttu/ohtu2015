package Komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public abstract class Komento {
    protected JTextField tulosKentta;
    protected JTextField syoteKentta;
    protected Sovelluslogiikka sovellus;
    private String edeltavaTulos;
    
    public Komento(Sovelluslogiikka sovellus, JTextField tulosK, JTextField syoteK) {
        this.sovellus = sovellus;
        this.tulosKentta = tulosK;
        this.syoteKentta = syoteK;
    }
    
    public void peru() {
        this.tulosKentta.setText(edeltavaTulos);
        this.syoteKentta.setText("");
    }
    
    protected void paivitaKentatKomennonSuorituksenJalkeen() {
        this.edeltavaTulos = this.tulosKentta.getText();
        
        this.tulosKentta.setText(Integer.toString(this.sovellus.tulos()));
        this.syoteKentta.setText("");
    }
    
    protected int syoteKentanArvo() {
        try {
            return Integer.parseInt(this.syoteKentta.getText());
        }
        catch (NumberFormatException e) {
            System.err.println("Täytä syötekenttään jokin kokonaisluku.");
            throw e;
        }
        
    }
    
    public abstract void suorita();
}
