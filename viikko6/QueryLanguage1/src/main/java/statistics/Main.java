package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        
        QueryBuilder query = new QueryBuilder();
        Matcher m1 = query.playsIn("PHI")
                            .hasAtLeast(15, "goals")
                            .hasFewerThan(35, "assists").build();
        
        query = new QueryBuilder();
        Matcher m2 = query.playsIn("PHI")
                  .hasAtLeast(3, "goals")
                  .hasFewerThan(25, "assists").build();
        
        stats.matches(m1).stream().forEach((player) -> {
            System.out.println(player);
        });
        System.out.println("\n");
        
        stats.matches(m2).stream().forEach((player) -> {
            System.out.println(player);
        });   
        System.out.println("\n");
        
        query = new QueryBuilder();
        Matcher yhdiste = query.oneOf(m1, m2).build();
        
        stats.matches(yhdiste).stream().forEach((player) -> {
            System.out.println(player);
        });
        
    }
}
