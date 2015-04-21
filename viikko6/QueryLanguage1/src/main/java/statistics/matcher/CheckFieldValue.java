package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class CheckFieldValue {
    private final int value;
    private final String fieldName;

    protected CheckFieldValue(int value, String category) {
        this.value = value;
        fieldName = "get" + Character.toUpperCase(category.charAt(0)) + category.substring(1, category.length());
    }
    
    protected int getValue() {
        return this.value;
    }

    protected int fieldValue(Player p) {
        try {            
            Method method = Player.class.getMethod(fieldName);
            return (Integer) method.invoke(p);
            
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field " + fieldName.substring(3, fieldName.length()).toLowerCase());
        }       
        
    }    
    
}
