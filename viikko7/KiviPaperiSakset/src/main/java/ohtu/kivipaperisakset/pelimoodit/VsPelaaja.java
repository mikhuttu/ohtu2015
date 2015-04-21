package ohtu.kivipaperisakset.pelimoodit;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.pelaajat.Ihminen;

public class VsPelaaja extends PerusToiminnallisuus {
    
    public VsPelaaja() {
        this(new IO());
    }
    
    private VsPelaaja(IO io) {
        super(io);
        pelaaja2 = new Ihminen(io);
    }
    
    @Override
    public void pelaa() {
        
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = pelaaja1.annaSiirto();
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = pelaaja2.annaSiirto();

        while (mahdollinenSiirto(ekanSiirto) && mahdollinenSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = pelaaja1.annaSiirto();
            
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = pelaaja2.annaSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}