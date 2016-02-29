package interfaces.bca.util;

/**
 * Created by David on 2/17/2016.
 */
public class BCAEntry implements Comparable{
    public String key = null;
    public Object value = null;

    public BCAEntry(String key, Object value){
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo (Object o){
        if (o instanceof String)
            return ((String) o).compareTo(key);
        else
            return ((BCAEntry) o).key.compareTo(key);
    }
}