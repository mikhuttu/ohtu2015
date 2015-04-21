package ohtu;

public class Player {
    private String name;
    private int points;
    
    public Player(String name) {
        this.name = name;
        this.points = 0;
    } 
    
    public String getName() {
        return this.name;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public void wonPoint() {
        this.points++;
    }
    
    public String pointsToString() {
        switch (points) {
            case 0:
                return Tulokset.Love.name();
            case 1:
                return Tulokset.Fifteen.name();
            case 2:
                return Tulokset.Thirty.name();
            case 3:
                return Tulokset.Forty.name();
            default:
                throw new IllegalStateException("How did we get here?");
        }
    }
}
