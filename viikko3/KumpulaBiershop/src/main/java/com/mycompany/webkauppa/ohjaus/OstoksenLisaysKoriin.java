package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Tuote;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;

public class OstoksenLisaysKoriin {
<<<<<<< HEAD

    private Ostoskori ostoskori;
    private long tuoteId;
    private Varasto varasto;

    public OstoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId) {
        this.ostoskori = ostoskori;
        this.tuoteId = tuoteId;
        this.varasto = Varasto.getInstance();
    }

    public void suorita() {
=======
    private Ostoskori ostoskori;
    private long tuoteId;

    protected OstoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId) {
        this.ostoskori = ostoskori;
        this.tuoteId = tuoteId;
    }

    public void suorita(Varasto varasto) {
>>>>>>> mluukkai-lokaali
        boolean saatiinTuote = varasto.otaVarastosta(tuoteId);
        
        if (!saatiinTuote) {
            return;
        }
       
        Tuote tuote = varasto.etsiTuote(tuoteId);                      
<<<<<<< HEAD
        ostoskori.lisaaTuote(tuote);                

=======
        ostoskori.lisaaTuote(tuote);
>>>>>>> mluukkai-lokaali
    }
}
