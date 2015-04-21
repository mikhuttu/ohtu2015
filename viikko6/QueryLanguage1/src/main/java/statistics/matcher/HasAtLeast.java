package statistics.matcher;

import statistics.Player;

public class HasAtLeast implements Matcher {
    private CheckFieldValue checker;
    
    public HasAtLeast(int value, String category) {
        checker = new CheckFieldValue(value, category);
    }

    @Override
    public boolean matches(Player p) {
        return checker.fieldValue(p) >= checker.getValue();
    }    
}