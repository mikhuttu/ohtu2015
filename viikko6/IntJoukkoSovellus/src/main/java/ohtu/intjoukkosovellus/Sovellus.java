package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static final Scanner lukija = new Scanner(System.in);
    private static final JoukkoTehdas tehdas = new JoukkoTehdas();
    private static IntJoukko A, B, C;

    private static IntJoukko mikaJoukko() {
        String luettu = lukija.nextLine();
        
        while (true) {
            switch (luettu) {
                case "A":
                case "a":
                    return A;
                case "B":
                case "b":
                    return B;
                case "C":
                case "c":
                    return C;
                default:
                    System.out.println("Virheellinen joukko! " + luettu);
                    System.out.print("Yritä uudelleen!");
                    luettu = lukija.nextLine();
                    break;
            }
        }
    }

    private static void lisaa() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("\nMikä luku lisätään? ");
        joukko.lisaa(lukija.nextInt());

    }

    private static void suoritaOperaatio(String nimi) {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        
        IntJoukko tulos;
        
        switch (nimi) {
            case "yhdiste":
                tulos = tehdas.yhdiste(aJoukko, mikaJoukko());
                break;
            case "leikkaus":
                tulos = tehdas.leikkaus(aJoukko, mikaJoukko());
                break;
            default:
                tulos = tehdas.erotus(aJoukko, mikaJoukko());
                break;
        }
     
        System.out.println("A " + nimi + " B = " + tulos.toString());
    }
    
    private static void yhdiste() {
        suoritaOperaatio("yhdiste");
    }

    private static void leikkaus() {
        suoritaOperaatio("leikkaus");
    }

    private static void erotus() {
        suoritaOperaatio("erotus");
    }

    private static void poista() {
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        joukko.poista(lukija.nextInt());
    }

    private static void kuuluu() {
        System.out.print("Mihin joukkoon? ");
        
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        
        int luku = lukija.nextInt();
        if (joukko.kuuluu(luku)) {
            System.out.println(luku + " kuuluu joukkoon ");
        } 
        else {
            System.out.println(luku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = tehdas.tyhjaJoukko();
        B = tehdas.tyhjaJoukko();
        C = tehdas.tyhjaJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        while (true) {
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
