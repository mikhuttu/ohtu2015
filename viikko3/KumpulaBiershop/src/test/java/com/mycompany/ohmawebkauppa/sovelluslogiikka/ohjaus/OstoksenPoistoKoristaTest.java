package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

import com.mycompany.webkauppa.ohjaus.KomentoTehdas;
import com.mycompany.webkauppa.ohjaus.OstoksenPoistoKorista;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.webkauppa.sovelluslogiikka.*;

public class OstoksenPoistoKoristaTest {
    KomentoTehdas tehdas;
    Varasto varasto = new Varasto();
    Ostoskori kori;
    long tuoteid = 1;
    OstoksenPoistoKorista ostoksenPoisto;

    @Before
    public void setUp() {
        tehdas = new KomentoTehdas();
        Tuote tuote = varasto.etsiTuote(tuoteid);
        kori = new Ostoskori();
        kori.lisaaTuote(tuote);
    }

    @Test
    public void poistettuTuoteEiEnaaKorissa() {
        tehdas.ostoksenPoistoKorista(kori, tuoteid).suorita(varasto);
    
        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size());
    }
    
    @Test
    public void tuotteenMaaraKasvaa(){
        int varastossaAluksi = varasto.etsiTuote(tuoteid).getSaldo();
        tehdas.ostoksenPoistoKorista(kori, tuoteid).suorita(varasto);
    
        assertEquals(varastossaAluksi+1, varasto.etsiTuote(tuoteid).getSaldo());
    }
}