package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Tuote;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;

public class OstoksenLisaysKoriin {
    private Ostoskori ostoskori;
    private long tuoteId;

    protected OstoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId) {
        this.ostoskori = ostoskori;
        this.tuoteId = tuoteId;
    }

    public void suorita(Varasto varasto) {
        boolean saatiinTuote = varasto.otaVarastosta(tuoteId);
        
        if (!saatiinTuote) {
            return;
        }
       
        Tuote tuote = varasto.etsiTuote(tuoteId);                      
        ostoskori.lisaaTuote(tuote);
    }
}
