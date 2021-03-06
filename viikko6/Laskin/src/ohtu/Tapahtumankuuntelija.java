package ohtu;

import Komennot.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;
 
public class Tapahtumankuuntelija implements ActionListener {
    private JButton nollaa;
    private JButton undo;    
    private Komento edellinen;
    private Map<JButton, Komento> komennot;
    private Sovelluslogiikka sovellus;
 
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = new Sovelluslogiikka();
        
        this.komennot = new HashMap<>();
        this.komennot.put(plus, new Summa(sovellus, tuloskentta, syotekentta));
        this.komennot.put(miinus, new Erotus(sovellus, tuloskentta, syotekentta));
        this.komennot.put(nollaa, new Nollaa(sovellus, tuloskentta, syotekentta));

        this.nollaa = nollaa;
        this.undo = undo;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Komento komento = komennot.get(ae.getSource());
        
        if (komento != null) {
            komento.suorita();
            edellinen = komento;
        } else { // undo
            edellinen.peru();
            edellinen = null;
        }
        
        nollaa.setEnabled(sovellus.tulos() != 0);
        undo.setEnabled(edellinen != null);
    }
 
}