package statistics;

import statistics.matcher.*;

public class QueryBuilder {
    private Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new And();
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        return luo(new Or(matchers));
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        return luo(new HasAtLeast(value, category));
    }    
    
    public QueryBuilder hasFewerThan(int value, String category) {
        return luo(new HasFewerThan(value, category));
    }        
    
    public QueryBuilder playsIn(String team) {
        return luo(new PlaysIn(team));
    }
    
    public Matcher build() {
        return this.matcher;
    }
    
    protected QueryBuilder luo(Matcher m) {
        this.matcher = new And(matcher, m);
        return this;
    }
}
