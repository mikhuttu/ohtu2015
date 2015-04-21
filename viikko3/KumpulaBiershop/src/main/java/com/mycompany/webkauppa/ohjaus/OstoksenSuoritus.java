package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.*;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.*;

public class OstoksenSuoritus {
<<<<<<< HEAD

    private PankkiFasaadi pankki;
    private ToimitusjarjestelmaFasaadi toimitusjarjestelma;
=======
    private PankkiFasaadi pankki;
>>>>>>> mluukkai-lokaali
    private String asiakkaanNimi;
    private String postitusosoite;
    private String luottokortti;
    private Ostoskori ostoskori;
<<<<<<< HEAD
    private Varasto varasto;

    public OstoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori kori) {
        this.varasto = Varasto.getInstance();
        this.pankki = PankkiFasaadi.getInstance();
        this.toimitusjarjestelma = ToimitusjarjestelmaFasaadi.getInstance();
=======

    protected OstoksenSuoritus(PankkiFasaadi pankki, String nimi, String osoite, String luottokorttinumero, Ostoskori kori) {
        this.pankki = pankki;
>>>>>>> mluukkai-lokaali
        this.asiakkaanNimi = nimi;
        this.postitusosoite = osoite;
        this.luottokortti = luottokorttinumero;
        this.ostoskori = kori;
    }

<<<<<<< HEAD
    public boolean suorita() {
=======
    public boolean suorita(ToimitusjarjestelmaFasaadi toimitusjarjestelma) {
>>>>>>> mluukkai-lokaali
        if ( asiakkaanNimi.length()==0 || postitusosoite.length()==0 || ostoskori.tuotteitaKorissa()==0 )
            return false;
        
        if (!pankki.maksa(asiakkaanNimi, luottokortti, ostoskori.hinta())) {
            return false;
        }

        toimitusjarjestelma.kirjaatoimitus(asiakkaanNimi, postitusosoite, ostoskori.ostokset());
        ostoskori.tyhjenna();
        
        return true;
    }

    public void setPankki(PankkiFasaadi pankki) {
        this.pankki = pankki;
    }        
}
