package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

<<<<<<< HEAD
import com.mycompany.webkauppa.ohjaus.OstoksenLisaysKoriin;
=======
import com.mycompany.webkauppa.ohjaus.KomentoTehdas;
>>>>>>> mluukkai-lokaali
import com.mycompany.webkauppa.sovelluslogiikka.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class OstoksenLisaysKoriinTest {
<<<<<<< HEAD
    Varasto varasto = Varasto.getInstance();
=======
    Varasto varasto = new Varasto();
>>>>>>> mluukkai-lokaali
    Ostoskori kori;    
    long tuoteid = 1;
    Tuote tuote;
    
<<<<<<< HEAD
    OstoksenLisaysKoriin ostoksenLisays;
=======
    KomentoTehdas tehdas;
>>>>>>> mluukkai-lokaali
    
    @Before
    public void setUp() {
        tuote = varasto.etsiTuote(tuoteid);     
        if ( tuote.getSaldo()==0 ) {
            tuote.setSaldo(1);
        } 
<<<<<<< HEAD
        kori = new Ostoskori();            
=======
        kori = new Ostoskori();
        tehdas = new KomentoTehdas();
>>>>>>> mluukkai-lokaali
    }
    
    @Test
    public void koriSisaltaaLisatynTuotteen() {
<<<<<<< HEAD
        ostoksenLisays = new OstoksenLisaysKoriin(kori, tuoteid);
        ostoksenLisays.suorita();
=======
        tehdas.ostoksenLisaysKoriin(kori, tuoteid).suorita(varasto);
>>>>>>> mluukkai-lokaali
    
        assertEquals(1, kori.tuotteitaKorissa());
        assertEquals(tuote.getHinta(), kori.hinta());
        assertEquals(tuote.getNimi(), kori.ostokset().get(0).tuotteenNimi());
    }
    
    @Test
    public void tuotteenMaaraVahentyy(){
        int varastossaAluksi = varasto.etsiTuote(tuoteid).getSaldo();
<<<<<<< HEAD
        
        ostoksenLisays = new OstoksenLisaysKoriin(kori, tuoteid);
        ostoksenLisays.suorita();
=======
        tehdas.ostoksenLisaysKoriin(kori, tuoteid).suorita(varasto);
>>>>>>> mluukkai-lokaali
    
        assertEquals(varastossaAluksi-1, varasto.etsiTuote(tuoteid).getSaldo());
    }
    
    @Test
    public void josTuotteenVarastosaldoNollaEiTuotettaLaitetaOstoskoriin() {
        varasto.etsiTuote(tuoteid).setSaldo(0);
<<<<<<< HEAD
        
        ostoksenLisays = new OstoksenLisaysKoriin(kori, tuoteid);
        ostoksenLisays.suorita();
=======
        tehdas.ostoksenLisaysKoriin(kori, tuoteid).suorita(varasto);
>>>>>>> mluukkai-lokaali
    
        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size() );
    }
}
