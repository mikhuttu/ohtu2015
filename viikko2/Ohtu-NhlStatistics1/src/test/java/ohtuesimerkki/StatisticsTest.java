package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    Statistics stats;
    Reader readerStub = new Reader() {

        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchReturnsTheSearchedPlayer() {
        Player player = stats.search("Kurri");
        assertEquals("Kurri                EDM 37 + 53 = 90", player.toString());
    }
    
    @Test
    public void searchReturnsNullIfPlayerDoesntExist() {
        assertNull(stats.search("Matti"));
    }
    
    @Test
    public void teamReturnsPlayersOfTheTeam() {
        List<Player> team = stats.team("EDM");
        assertTrue(3 == team.size());
    }
    
    @Test
    public void topScorersWorks() {
        List<Player> scorers = stats.topScorers(2);
        assertTrue(2 == scorers.size());
        
        assertEquals("Lemieux", scorers.get(0).getName());
        assertEquals("Yzerman", scorers.get(1).getName());
    }
}
