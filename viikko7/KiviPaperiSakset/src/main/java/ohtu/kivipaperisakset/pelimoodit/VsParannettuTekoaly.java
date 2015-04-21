package ohtu.kivipaperisakset.pelimoodit;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.pelaajat.TekoalyParannettu;

public class VsParannettuTekoaly extends PerusToiminnallisuus {
    
    public VsParannettuTekoaly() {
        super(new IO());
        pelaaja2 = new TekoalyParannettu(20);
    }

    @Override
    public void pelaa() {
        TekoalyParannettu tekoaly = new TekoalyParannettu(20);

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
            tekoaly.asetaSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}
