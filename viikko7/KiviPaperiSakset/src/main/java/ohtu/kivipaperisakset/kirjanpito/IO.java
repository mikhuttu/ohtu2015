package ohtu.kivipaperisakset.kirjanpito;

import java.util.Scanner;

public class IO {
    private final Scanner scanner;
    
    public IO() {
        this.scanner = new Scanner(System.in);
    }
    
    public String nextLine() {
        return scanner.nextLine();
    }
    
    public void println(String teksti) {
        print(teksti + "\n");
    }
    
    public void print(String teksti) {
        System.out.print(teksti);
    }
}
