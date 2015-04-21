package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

<<<<<<< HEAD
=======
import com.mycompany.webkauppa.ohjaus.KomentoTehdas;
>>>>>>> mluukkai-lokaali
import com.mycompany.webkauppa.ohjaus.OstoksenPoistoKorista;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.webkauppa.sovelluslogiikka.*;

public class OstoksenPoistoKoristaTest {
<<<<<<< HEAD

    Varasto varasto = Varasto.getInstance();
=======
    KomentoTehdas tehdas;
    Varasto varasto = new Varasto();
>>>>>>> mluukkai-lokaali
    Ostoskori kori;
    long tuoteid = 1;
    OstoksenPoistoKorista ostoksenPoisto;

    @Before
    public void setUp() {
<<<<<<< HEAD
=======
        tehdas = new KomentoTehdas();
>>>>>>> mluukkai-lokaali
        Tuote tuote = varasto.etsiTuote(tuoteid);
        kori = new Ostoskori();
        kori.lisaaTuote(tuote);
    }

    @Test
    public void poistettuTuoteEiEnaaKorissa() {
<<<<<<< HEAD
        ostoksenPoisto = new OstoksenPoistoKorista(kori, tuoteid);
        ostoksenPoisto.suorita();
=======
        tehdas.ostoksenPoistoKorista(kori, tuoteid).suorita(varasto);
>>>>>>> mluukkai-lokaali
    
        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size());
    }
    
    @Test
    public void tuotteenMaaraKasvaa(){
        int varastossaAluksi = varasto.etsiTuote(tuoteid).getSaldo();
<<<<<<< HEAD
        
        ostoksenPoisto = new OstoksenPoistoKorista(kori, tuoteid);
        ostoksenPoisto.suorita();
    
        assertEquals(varastossaAluksi+1, varasto.etsiTuote(tuoteid).getSaldo());
    }

}
=======
        tehdas.ostoksenPoistoKorista(kori, tuoteid).suorita(varasto);
    
        assertEquals(varastossaAluksi+1, varasto.etsiTuote(tuoteid).getSaldo());
    }
}
>>>>>>> mluukkai-lokaali
