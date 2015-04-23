package ohtu.kivipaperisakset.pelimoodit;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.kirjanpito.Tuomari;
import ohtu.kivipaperisakset.kirjanpito.Valinta;
import ohtu.kivipaperisakset.pelaajat.Ihminen;
import ohtu.kivipaperisakset.pelaajat.Pelaaja;
import ohtu.kivipaperisakset.pelimoodit.siirrot.ParannetunTekoAlynSiirto;
import ohtu.kivipaperisakset.pelimoodit.siirrot.SiirtoMenetelma;

public class Peli {
    protected final IO io;
    protected final Tuomari tuomari;
    protected final Pelaaja pelaaja1;
    protected SiirtoMenetelma tokanSiirto;
    
    protected Peli(IO io, SiirtoMenetelma siirtoMenetelma) {
        this.io = io;
        this.tuomari = new Tuomari();
        this.pelaaja1 = new Ihminen(io);
        this.tokanSiirto = siirtoMenetelma;
    }
    
    public void pelaa() {
        try {
            Valinta eka = ensimmaisenPelaajanSiirto();
            Valinta toka = tokanSiirto();

            while (true) {
                kirjaaSiirto(eka, toka);
            
                eka = ensimmaisenPelaajanSiirto();
                toka = tokanSiirto();
            
                if (vastassaParannettuTekoAly()) asetaSiirto(eka);
            }
        }

        catch (IllegalArgumentException e) {
            lopeta();
        }
    }
    
    protected void lopeta() {
        io.println("\nKiitos!\n" + tuomari);
    }
    
    protected Valinta ensimmaisenPelaajanSiirto() {
        io.print("Ensimmäisen pelaajan siirto: ");
        return pelaaja1.annaSiirto();
    }
    
    protected Valinta tokanSiirto() {
        return tokanSiirto.siirto();
    }
    
    protected void kirjaaSiirto(Valinta ekanSiirto, Valinta tokanSiirto) {
        tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
        io.println(tuomari + "\n");
    }
    
    protected void asetaSiirto(Valinta eka) {
        ParannetunTekoAlynSiirto parannettu = (ParannetunTekoAlynSiirto) tokanSiirto;
        parannettu.asetaSiirto(eka);
    }
    
    protected boolean vastassaParannettuTekoAly() {
        return tokanSiirto.getClass() == ParannetunTekoAlynSiirto.class;
    }
}
