package ohtu;

public class TennisGame {
    private final Player p1;
    private final Player p2;

    public TennisGame(String name1, String name2) {
        p1 = new Player(name1);
        p2 = new Player(name2);
    }

    public void wonPoint(String name) {
        if (name.equals(p1.getName())) {
            p1.wonPoint();
            return;
        }
        p2.wonPoint();
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        
        if (tilanneTasan()) {
            score.append(tasaTilanne());
        }
                
        else if (otteluPallo()) {
            score.append("Advantage player");
            lisaaJohtoasemassaOlevanPelaajanNumero(score);
        }
        
        else if (peliPaattynyt()) {
            score.append("Win for player");
            lisaaJohtoasemassaOlevanPelaajanNumero(score);
        }
        
        else {
            score.append(p1.pointsToString()).append("-").append(p2.pointsToString());
        }
        
        return score.toString();
    }
    
    protected boolean tilanneTasan() {
        return p1.getPoints() == p2.getPoints();
    }
    
    protected String tasaTilanne() {
        if (p1.getPoints() >= 4) {
            return Tulokset.Deuce.name();
        }
        
        return p1.pointsToString() + "-All";
    }
    
    protected boolean otteluPallo() {
        return tarkistaJohtajaTaiVoittaja(false);
    }
    
    protected boolean peliPaattynyt() {
        return tarkistaJohtajaTaiVoittaja(true);
    }
    
    protected boolean tarkistaJohtajaTaiVoittaja(boolean tarkistaVoittaja) {
        if (p1.getPoints() >= 4 || p2.getPoints() >= 4) {
            int pisteEro = Math.abs(p1.getPoints() - p2.getPoints());
            
            if (tarkistaVoittaja) {
                return pisteEro >= 2;
            }
            return pisteEro == 1;
        }
        return false;
    }
    
    protected void lisaaJohtoasemassaOlevanPelaajanNumero(StringBuilder score) {
        if (p1.getPoints() > p2.getPoints()) {
            score.append("1");
            return;
        }
        
        score.append("2");
    }
}