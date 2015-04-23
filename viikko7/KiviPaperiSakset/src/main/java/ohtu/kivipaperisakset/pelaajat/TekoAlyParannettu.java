package ohtu.kivipaperisakset.pelaajat;

// "Muistava tekoäly"

import ohtu.kivipaperisakset.kirjanpito.Valinta;
import static ohtu.kivipaperisakset.kirjanpito.Valinta.*;

public class TekoAlyParannettu implements Pelaaja {
    private final Valinta[] muisti;
    private int vapaaMuistiIndeksi;

    public TekoAlyParannettu(int muistinKoko) {
        muisti = new Valinta[muistinKoko];
        vapaaMuistiIndeksi = 0;
    }
  
  // jos muisti täyttyy, unohdetaan viimeinen alkio
  
    public void asetaSiirto(Valinta siirto) {
        if (vapaaMuistiIndeksi == muisti.length) {
            for (int i = 1; i < muisti.length; i++) {
                muisti[i - 1] = muisti[i];
            }

            vapaaMuistiIndeksi--;
        }

        muisti[vapaaMuistiIndeksi] = siirto;
        vapaaMuistiIndeksi++;
    }

    @Override
    public Valinta annaSiirto() {
        if (vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
            return KIVI;
        }

        Valinta viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];

        int k = 0;
        int p = 0;
        int s = 0;

        for (int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
            if (viimeisinSiirto == muisti[i]) {
                Valinta seuraava = muisti[i + 1];

                if (seuraava == KIVI) {
                    k++;
                }
                else if (seuraava == PAPERI) {
                    p++;
                }
                else {
                    s++;
                }
            }
        }
    
    
    // Tehdään siirron valinta esimerkiksi seuraavasti;
    // - jos kiviä eniten, annetaan aina paperi
    // - jos papereita eniten, annetaan aina sakset
    // muulloin annetaan aina kivi
    
        if (k > p && k > s) {
            return PAPERI;
        } else if (p > k && p > s) {
            return SAKSET;
        } else {
            return KIVI;
        }
    }
}