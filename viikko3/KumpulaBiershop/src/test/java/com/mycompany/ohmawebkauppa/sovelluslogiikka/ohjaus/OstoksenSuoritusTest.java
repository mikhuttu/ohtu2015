
package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

import com.mycompany.webkauppa.ohjaus.KomentoTehdas;
import com.mycompany.webkauppa.ohjaus.OstoksenSuoritus;
import com.mycompany.webkauppa.sovelluslogiikka.*;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoksenSuoritusTest {
    PankkiFasaadi pankki = new PankkiFasaadi();
    PankkiFasaadi hylkaavaPankki = teeHylkaavaPankki();
    ToimitusjarjestelmaFasaadi toimitusJarjestelma = new ToimitusjarjestelmaFasaadi();
    
    Varasto varasto = new Varasto();
    
    long tuoteId1;
    long tuoteId2;
    Tuote tuote1;
    Tuote tuote2;
    Ostoskori kori;
    String nimi;
    String osoite;
    String luottokortti;

    KomentoTehdas tehdas;
    OstoksenSuoritus suoritus;
    
    @Before
    public void setUp() {
        nimi = "Arto Vihavainen";
        osoite = "Herttoniemenranta 10 Helsinki";
        luottokortti = "12345";
        
        tuoteId1 = 1;
        tuote1 = varasto.etsiTuote(tuoteId1);
        tuoteId2 = 2;
        tuote2 = varasto.etsiTuote(tuoteId2);
        
        kori = new Ostoskori();
        kori.lisaaTuote(tuote1);        
        kori.lisaaTuote(tuote2);
        
        tehdas = new KomentoTehdas();
    }
    
    @Test
    public void josMaksuOnnistuuKoriTyhjenee() {
        tehdas.ostoksenSuoritus(pankki, nimi, osoite, luottokortti, kori).suorita(toimitusJarjestelma);

        assertEquals(0, kori.ostokset().size());
        assertEquals(0, kori.hinta()); 
        assertEquals(0, kori.tuotteitaKorissa());         
    }
    
    @Test
    public void josMaksuOnnistuuPankinRajapintaaKaytetty() {
        tehdas.ostoksenSuoritus(pankki, nimi, osoite, luottokortti, kori).suorita(toimitusJarjestelma);
    }   

    @Test
    public void josMaksuOnnistuuToiRajmituksenapintaaKaytetty() {
        tehdas.ostoksenSuoritus(pankki, nimi, osoite, luottokortti, kori).suorita(toimitusJarjestelma);
    }             

    // - tyhjä kori, nimi tai osoite -> ei kutsuta pankkia, ei toimitusta
     
    @Test
    public void josPankkiEiHyvaksyMaksuaPalautetaanFalseToimitustaEiTehda() {      
        suoritus = tehdas.ostoksenSuoritus(pankki, nimi, osoite, luottokortti, kori);
        suoritus.setPankki(hylkaavaPankki);
        
        assertFalse( suoritus.suorita(toimitusJarjestelma) );
        
        // assertSomething
    } 
    
    // epäonnistuessa kori säilyy ennallaan
    
    private PankkiFasaadi teeHylkaavaPankki() {
        return new PankkiFasaadi() {

            @Override
            public boolean maksa(String nimi, String luottokortti, int hinta) {
                return false;
            }
                        
        };
    }
}
