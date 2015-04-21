package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.pelimoodit.VsPerusTekoaly;
import ohtu.kivipaperisakset.pelimoodit.VsPelaaja;
import ohtu.kivipaperisakset.pelimoodit.VsParannettuTekoaly;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                VsPelaaja kaksinpeli = new VsPelaaja();
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                VsPerusTekoaly yksinpeli = new VsPerusTekoaly();
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                VsParannettuTekoaly pahaYksinpeli = new VsParannettuTekoaly();
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }

    }
}
