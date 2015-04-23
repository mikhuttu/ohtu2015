package ohtu.kivipaperisakset.kirjanpito;

public enum Valinta {
    KIVI, PAPERI, SAKSET;
    
    public static Valinta valintana(char c) {
        switch(c) {
            case 'k':
                return Valinta.KIVI;
            case 'p':
                return Valinta.PAPERI;
            case 's':
                return Valinta.SAKSET;
            default:
                throw new IllegalArgumentException();
        }
    }
}