package ohtu.kivipaperisakset.pelimoodit.siirrot;

import ohtu.kivipaperisakset.kirjanpito.Valinta;
import ohtu.kivipaperisakset.pelaajat.Pelaaja;

public class TekoAlynSiirto extends SiirtoMenetelma {

    public TekoAlynSiirto(Pelaaja tekoAly) {
        super(tekoAly);
    }
    
    @Override
    public Valinta siirto() {
        Valinta tekoAlynSiirto = pelaaja.annaSiirto();
        System.out.println("Tietokone valitsi: " + charina(tekoAlynSiirto));
        
        return tekoAlynSiirto;
    }
    
    private char charina(Valinta valinta) {
        switch(valinta) {
            case KIVI:
                return 'k';
            case PAPERI:
                return 'p';
            case SAKSET:
                return 's';
            default:
                throw new IllegalStateException();
        }
    }
}