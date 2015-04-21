package ohtu.kivipaperisakset.kirjanpito;

import java.util.Scanner;

public class IO {
    private final Scanner scanner;
    
    public IO() {
        this.scanner = new Scanner(System.in);
    }
    
    public String next() {
        return scanner.nextLine();
    }
}
