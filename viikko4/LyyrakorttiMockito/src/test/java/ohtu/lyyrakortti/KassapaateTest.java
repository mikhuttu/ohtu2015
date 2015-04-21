
package ohtu.lyyrakortti;

<<<<<<< HEAD
import static org.junit.Assert.*;
import org.junit.Before;
=======
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
>>>>>>> mluukkai-lokaali
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
<<<<<<< HEAD
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
=======
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verify;
>>>>>>> mluukkai-lokaali
import static org.mockito.Mockito.when;

public class KassapaateTest {
    
    Kassapaate kassa;
    Lyyrakortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = mock(Lyyrakortti.class);
    }
    
    @Test
    public void kortiltaVelotetaanHintaJosRahaaOn() {
        when(kortti.getSaldo()).thenReturn(10);
        kassa.ostaLounas(kortti);
        
        verify(kortti, times(1)).getSaldo();
        verify(kortti).osta(eq(Kassapaate.HINTA));
    }

    @Test
    public void kortiltaEiVelotetaJosRahaEiRiita() {
        when(kortti.getSaldo()).thenReturn(4);
        kassa.ostaLounas(kortti);
        
        verify(kortti, times(1)).getSaldo();
        verify(kortti, times(0)).osta(anyInt());
    }
<<<<<<< HEAD
    
    @Test
    public void kortilleEiLadataJosLadattavaSummaNegTai0() {
        kassa.lataa(kortti, -1);
        verify(kortti, times(0)).lataa(anyInt());
        
        kassa.lataa(kortti, 0);
        verify(kortti, times(0)).lataa(anyInt());        
    }
    
    @Test
    public void kortilleLadataanPosSumma() {
        kassa.lataa(kortti, 2);
        verify(kortti).lataa(eq(2));
    }    
=======
>>>>>>> mluukkai-lokaali
}
