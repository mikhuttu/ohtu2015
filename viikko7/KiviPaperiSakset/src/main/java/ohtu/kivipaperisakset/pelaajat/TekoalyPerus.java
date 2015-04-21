package ohtu.kivipaperisakset.pelaajat;

public class TekoalyPerus implements Pelaaja {
    private int siirto;

    public TekoalyPerus() {
        this.siirto = 0;
    }
    
    @Override
    public String annaSiirto() {
        this.siirto++;
        this.siirto = this.siirto % 3;

        if (this.siirto == 0) {
            return "k";
        } else if (this.siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }
}
