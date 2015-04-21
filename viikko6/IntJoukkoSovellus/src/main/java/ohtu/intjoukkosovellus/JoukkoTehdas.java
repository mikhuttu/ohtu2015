package ohtu.intjoukkosovellus;

public class JoukkoTehdas {
    
    public IntJoukko tyhjaJoukko() {
        return new IntJoukko();
    }
    
    public IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        return new IntJoukko().yhdiste(a, b);
    }
    
    public IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        return new IntJoukko().leikkaus(a, b);
    }
    
    public IntJoukko erotus(IntJoukko a, IntJoukko b) {
        return new IntJoukko().erotus(a, b);
    }    
}
