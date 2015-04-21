<<<<<<< HEAD

=======
>>>>>>> mluukkai-lokaali
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Tuote;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;

public class OstoksenPoistoKorista {
    private Ostoskori ostoskori;
    private long tuoteId;
<<<<<<< HEAD
    private Varasto varasto;
    
    public OstoksenPoistoKorista(Ostoskori ostoskori, long tuoteId) {
        this.ostoskori = ostoskori;
        this.tuoteId = tuoteId;
        this.varasto = Varasto.getInstance();
    }    
    
    public void suorita() {
        varasto.palautaVarastoon( tuoteId );         
        Tuote poistettava = varasto.etsiTuote( tuoteId );              
        ostoskori.poista(poistettava);  
=======
    
    protected OstoksenPoistoKorista(Ostoskori ostoskori, long tuoteId) {
        this.ostoskori = ostoskori;
        this.tuoteId = tuoteId;
    }
    
    public void suorita(Varasto varasto) {
        varasto.palautaVarastoon( tuoteId );         
        Tuote poistettava = varasto.etsiTuote( tuoteId );              
        ostoskori.poista(poistettava);
>>>>>>> mluukkai-lokaali
    }          
}
