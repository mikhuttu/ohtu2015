package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.kirjanpito.IO;
import ohtu.kivipaperisakset.pelimoodit.Peli;
import ohtu.kivipaperisakset.pelimoodit.PeliTehdas;

public class Paaohjelma {
    private static final IO io = new IO();
    
    public static void main(String[] args) {
        
        while (true) {
            tulostaAloitusTeksti();
            
            try {
                Peli peli = seuraavaPeli(io.nextLine());
                peli.run();
            }
            catch (IllegalStateException e) {
                break;
            }
        }
    }
    
    private static Peli seuraavaPeli(String vastaus) {
        
        if (validiVastaus(vastaus)) {
            tulostaMilloinPaattyy();
            
            char c = vastaus.charAt(0);
            PeliTehdas tehdas = new PeliTehdas();
            
            switch (c) {
                case 'a':
                    return tehdas.vsPelaaja(io);
                case 'b':
                    return tehdas.vsPerusTekoAly(io);
                case 'c':
                    return tehdas.vsParannettuTekoAly(io);
                case 'd':
                    return tehdas.vsRandomTekoAly(io);
                default:
            }
        }
        
        throw new IllegalStateException();
    }
    
    private static void tulostaAloitusTeksti() {
        io.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\n (d) random tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
    }
    
    private static void tulostaMilloinPaattyy() {
        io.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s"); 
    }
    
    private static boolean validiVastaus(String vastaus) {
        if (vastaus.length() == 1) {
            char c = vastaus.charAt(0);
            return c == 'a' || c == 'b' || c == 'c' || c == 'd';
        }
        
        return false;
    }
}
