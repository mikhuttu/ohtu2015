
package ohtu.verkkokauppa;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class KauppaTest {
    Kauppa kauppa;
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        
        kauppa = new Kauppa(varasto, pankki, viite);
    }
    
    @Test
    public void tilimaksuKutsuuPankinTilisiirtoaOikeillaParametreillaKunLisataanYksiTuoteOstoskoriin() {
        when(viite.uusi()).thenReturn(16);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(1)).thenReturn(10);
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto("pekka", 16, "12345", anyString(), 5);
    }
    
    @Test
    public void tilimaksuKutsuuPankinTilisiirtoaOikeillaParametreillaKunLisataanKaksiEriTuotettaOstoskoriin() {
        when(viite.uusi()).thenReturn(14);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(5)).thenReturn(new Tuote(5, "voi", 12));
        when(varasto.saldo(5)).thenReturn(6);
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(5);
        kauppa.tilimaksu("jonne", "62345");
        
        verify(pankki).tilisiirto("jonne", 14, "62345", anyString(), 17);
    }
    
    @Test
    public void tilimaksuKutsuuPankinTilisiirtoaOikeillaParametreillaKunLisataanKaksiSamaaTuotettaOstoskoriin() {
        when(viite.uusi()).thenReturn(9);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(1)).thenReturn(2);
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("jonne", "62345");
        
        verify(pankki).tilisiirto("jonne", 9, "62345", anyString(), 10);
    }
    
    @Test
    public void tilimaksuKutsuuPankinTilisiirtoaOikeillaParametreillaKunLisataanKaksiTuotettaJoistaToinenLoppu() {
        when(viite.uusi()).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(1)).thenReturn(7);
        when(varasto.haeTuote(5)).thenReturn(new Tuote(5, "voi", 12));
        when(varasto.saldo(5)).thenReturn(0);
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(5);
        kauppa.tilimaksu("jonne", "62345");
        
        verify(pankki).tilisiirto("jonne", 3, "62345", anyString(), 5);
    }
    
    @Test
    public void aloitaAsiointiTyhjentaaOstoskorin() {
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(1)).thenReturn(7);
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("jonne", "62345");
        kauppa.aloitaAsiointi();
        kauppa.tilimaksu("jonne", "62345");
        
        verify(pankki).tilisiirto("jonne", anyInt(), "62345", anyString(), 0);
    }
    
    @Test
    public void uusiViitenumeroGeneroidaanJokaiselleMaksutapahtumalle() {
        kauppa.aloitaAsiointi();
        kauppa.tilimaksu("jonne", "62345");
        verify(viite, times(1)).uusi();

        kauppa.aloitaAsiointi();
        kauppa.tilimaksu("jonne", "62345");
        verify(viite, times(2)).uusi();
    }
    
    @Test
    public void poistaKoristaLisaaTuotteenVarastoon() {
        Tuote m = new Tuote(1, "maito", 5);
        
        when(varasto.haeTuote(1)).thenReturn(m);
        kauppa.poistaKorista(1);
        
        verify(varasto, times(1)).palautaVarastoon(m);
    }
    
}
