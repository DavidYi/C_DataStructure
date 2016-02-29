package interfaces.bca.util;

/**
 * Created by David on 2/25/2016.
 */
public class BCAMapByHashedArrayList implements BCAMap{
    protected BCAArrayList buckets[] = null;

    public BCAMapByHashedArrayList (){
        buckets = new BCAArrayList[500];

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new BCAArrayList();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public Object getOrDefault(String key, Object defaultValue) {
        return null;
    }

    @Override
    public Object put(String key, Object value) {
        if (key == null || value == null)
            throw new NullPointerException();

        int bucket = Math.abs(key.hashCode()) % buckets.length;

        return null;
    }

    @Override
    public Object remove(String key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public BCAEntry[] toArray() {
        return new BCAEntry[0];
    }

    @Override
    public String[] keys() {
        return new String[0];
    }

    @Override
    public Object[] values() {
        return new Object[0];
    }
}
