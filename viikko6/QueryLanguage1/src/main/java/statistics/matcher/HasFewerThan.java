package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {
    private CheckFieldValue checker;
    
    public HasFewerThan(int value, String category) {
        checker = new CheckFieldValue(value, category);
    }

    @Override
    public boolean matches(Player p) {
        return checker.fieldValue(p) < checker.getValue();
    }    
}