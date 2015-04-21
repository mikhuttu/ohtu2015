package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.PankkiFasaadi;

public class KomentoTehdas {
    
    public OstoksenLisaysKoriin ostoksenLisaysKoriin(Ostoskori kori, long tuoteId) {
        return new OstoksenLisaysKoriin(kori, tuoteId);
    }
    
    public OstoksenPoistoKorista ostoksenPoistoKorista(Ostoskori kori, long tuoteId) {
        return new OstoksenPoistoKorista(kori, tuoteId);
    }
    
    public OstoksenSuoritus ostoksenSuoritus(PankkiFasaadi pankki, String nimi, String osoite, String luottokorttinumero, Ostoskori kori) {
        return new OstoksenSuoritus(pankki, nimi, osoite, luottokorttinumero, kori);
    }
}
