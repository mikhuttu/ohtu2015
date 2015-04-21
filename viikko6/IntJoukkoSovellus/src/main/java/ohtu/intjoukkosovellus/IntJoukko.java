
package ohtu.intjoukkosovellus;

public class IntJoukko {

    private final String YHDISTE = "yhdiste",
                         LEIKKAUS = "leikkaus",
                         EROTUS = "erotus";
    private static final int KAPASITEETTI = 5,
                            OLETUSKASVATUS = 5;
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int lukuja;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
     
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Annettu parametri negatiivinen. Tarkista parametrit.");
        }

        luvut = new int[kapasiteetti];
        lukuja = 0;
        this.kasvatuskoko = kasvatuskoko;
    }
    
    protected int[] getLuvut() {
        int[] palautettavat = new int[lukuja];
        System.arraycopy(luvut, 0, palautettavat, 0, lukuja);
        
        return palautettavat;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
            
        luvut[lukuja] = luku;
        lukuja++;
        
        if (lukuja == luvut.length) {
            kasvataTaulukkoa();
        }
        
        return true;
    }

    protected int luvunIndeksiTaulukossa(int luku) {
        for (int i = 0; i < lukuja; i++) {
            if (luku == luvut[i]) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean kuuluu(int luku) {
        return luvunIndeksiTaulukossa(luku) >= 0;
    }

    public boolean poista(int luku) {
        int i = luvunIndeksiTaulukossa(luku);
        
        if (i >= 0) {
            siirraTaulukonSeuraavatLuvutEteenpainYhdenPaikanVerran(i);
            lukuja--;
            return true;
        }
        return false;
    }

    public int mahtavuus() {
        return lukuja;
    }
   
    public IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        return operaatio(YHDISTE, a, b);
    }

    public IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        return operaatio(LEIKKAUS, a, b);
    }
    
    public IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        return operaatio(EROTUS, a, b);
    }
    
    protected IntJoukko maaritaYhdiste(int[] a, int[] b) {
        IntJoukko yhdiste = new IntJoukko();
        
        for (int luku : a) yhdiste.lisaa(luku);
        for (int luku : b) yhdiste.lisaa(luku);
        
        return yhdiste;
    }    
    
    protected IntJoukko maaritaLeikkaus(int[] a, int[] b) {
        IntJoukko leikkaus = new IntJoukko();
        
        for (int luku : a) {
            for (int luku2 : b) {
                if (luku == luku2) leikkaus.lisaa(luku);
            }
        }
        
        return leikkaus;
    }
    
    protected IntJoukko maaritaErotus(int[] a, int[] b) {
        IntJoukko erotus = new IntJoukko();
        
        for (int luku : a) erotus.lisaa(luku);
        for (int luku : b) erotus.poista(luku);
        
        return erotus;
    }
    
    protected IntJoukko operaatio(String nimi, IntJoukko a, IntJoukko b) {
        IntJoukko tulos;
        
        int[] aTaulu = a.getLuvut();
        int[] bTaulu = b.getLuvut();
        
        switch(nimi) {
            case YHDISTE:
                tulos = maaritaYhdiste(aTaulu, bTaulu);
                break;
            case LEIKKAUS:
                tulos = maaritaLeikkaus(aTaulu, bTaulu);
                break;
            default:
                tulos = maaritaErotus(aTaulu, bTaulu);
                break;
        }
        
        return tulos;
    }
    
    protected void kasvataTaulukkoa() {
        int[] ptr = luvut;
        luvut = new int[luvut.length + kasvatuskoko];
        System.arraycopy(ptr, 0, luvut, 0, ptr.length);
    }
    
    protected void siirraTaulukonSeuraavatLuvutEteenpainYhdenPaikanVerran(int i) {
        for (int j = i; j < lukuja - 1; j++) {
            luvut[j] = luvut[j + 1];
        }
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        
        for (int i = 0; i < lukuja; i++) {
            builder.append(luvut[i]);
            
            if (i < lukuja - 1) {
                builder.append(", ");
            }
        }
        
        builder.append("}");
        return builder.toString();
    }
}