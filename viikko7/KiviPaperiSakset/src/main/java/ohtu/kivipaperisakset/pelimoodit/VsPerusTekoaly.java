package ohtu.kivipaperisakset.pelimoodit;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.pelaajat.TekoalyPerus;

public class VsPerusTekoaly extends PerusToiminnallisuus {

    public VsPerusTekoaly() {
        super(new IO());
        pelaaja2 = new TekoalyPerus();
    }
    
    @Override
    public void pelaa() {
        TekoalyPerus tekoaly = new TekoalyPerus();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = pelaaja1.annaSiirto();
        String tokanSiirto;

        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);


        while (mahdollinenSiirto(ekanSiirto) && mahdollinenSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = pelaaja1.annaSiirto();

            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}