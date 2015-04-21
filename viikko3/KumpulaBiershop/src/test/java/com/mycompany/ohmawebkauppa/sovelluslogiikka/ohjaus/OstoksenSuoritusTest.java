
package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

<<<<<<< HEAD
=======
import com.mycompany.webkauppa.ohjaus.KomentoTehdas;
>>>>>>> mluukkai-lokaali
import com.mycompany.webkauppa.ohjaus.OstoksenSuoritus;
import com.mycompany.webkauppa.sovelluslogiikka.*;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoksenSuoritusTest {
<<<<<<< HEAD
    PankkiFasaadi pankki = PankkiFasaadi.getInstance();
    PankkiFasaadi hylkaavaPankki = teeHylkaavaPankki();
    ToimitusjarjestelmaFasaadi toimitusJarjestelma = ToimitusjarjestelmaFasaadi.getInstance();
    Varasto varasto = Varasto.getInstance();
=======
    PankkiFasaadi pankki = new PankkiFasaadi();
    PankkiFasaadi hylkaavaPankki = teeHylkaavaPankki();
    ToimitusjarjestelmaFasaadi toimitusJarjestelma = new ToimitusjarjestelmaFasaadi();
    
    Varasto varasto = new Varasto();
>>>>>>> mluukkai-lokaali
    
    long tuoteId1;
    long tuoteId2;
    Tuote tuote1;
    Tuote tuote2;
    Ostoskori kori;
    String nimi;
    String osoite;
    String luottokortti;

<<<<<<< HEAD
    OstoksenSuoritus ostoksenSuoritus;
=======
    KomentoTehdas tehdas;
    OstoksenSuoritus suoritus;
>>>>>>> mluukkai-lokaali
    
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
<<<<<<< HEAD
=======
        
        tehdas = new KomentoTehdas();
>>>>>>> mluukkai-lokaali
    }
    
    @Test
    public void josMaksuOnnistuuKoriTyhjenee() {
<<<<<<< HEAD
        ostoksenSuoritus = new OstoksenSuoritus(nimi, osoite, luottokortti, kori);
        ostoksenSuoritus.suorita();
=======
        tehdas.ostoksenSuoritus(pankki, nimi, osoite, luottokortti, kori).suorita(toimitusJarjestelma);
>>>>>>> mluukkai-lokaali

        assertEquals(0, kori.ostokset().size());
        assertEquals(0, kori.hinta()); 
        assertEquals(0, kori.tuotteitaKorissa());         
    }
    
    @Test
    public void josMaksuOnnistuuPankinRajapintaaKaytetty() {
<<<<<<< HEAD
        ostoksenSuoritus = new OstoksenSuoritus(nimi, osoite, luottokortti, kori);
        ostoksenSuoritus.suorita();       
=======
        tehdas.ostoksenSuoritus(pankki, nimi, osoite, luottokortti, kori).suorita(toimitusJarjestelma);
>>>>>>> mluukkai-lokaali
    }   

    @Test
    public void josMaksuOnnistuuToiRajmituksenapintaaKaytetty() {
<<<<<<< HEAD
        ostoksenSuoritus = new OstoksenSuoritus(nimi, osoite, luottokortti, kori);
        ostoksenSuoritus.suorita();       
=======
        tehdas.ostoksenSuoritus(pankki, nimi, osoite, luottokortti, kori).suorita(toimitusJarjestelma);
>>>>>>> mluukkai-lokaali
    }             

    // - tyhjä kori, nimi tai osoite -> ei kutsuta pankkia, ei toimitusta
     
    @Test
<<<<<<< HEAD
    public void josPankkiEiHyvaksyMaksuaPalautetaanFalseToimitustaEiTehda() {        
        ostoksenSuoritus = new OstoksenSuoritus(nimi, osoite, luottokortti, kori);
        ostoksenSuoritus.setPankki(hylkaavaPankki);
 
        
        assertFalse( ostoksenSuoritus.suorita() );
=======
    public void josPankkiEiHyvaksyMaksuaPalautetaanFalseToimitustaEiTehda() {      
        suoritus = tehdas.ostoksenSuoritus(pankki, nimi, osoite, luottokortti, kori);
        suoritus.setPankki(hylkaavaPankki);
        
        assertFalse( suoritus.suorita(toimitusJarjestelma) );
>>>>>>> mluukkai-lokaali
        
        // assertSomething
    } 
    
    // epäonnistuessa kori säilyy ennallaan
    
    private PankkiFasaadi teeHylkaavaPankki() {
<<<<<<< HEAD
        return new PankkiFasaadi(){
=======
        return new PankkiFasaadi() {
>>>>>>> mluukkai-lokaali

            @Override
            public boolean maksa(String nimi, String luottokortti, int hinta) {
                return false;
            }
                        
        };
    }
}
