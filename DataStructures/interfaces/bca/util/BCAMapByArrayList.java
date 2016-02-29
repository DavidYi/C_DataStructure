package interfaces.bca.util;

/**
 * Created by David on 2/17/2016.
 */
public class BCAMapByArrayList implements BCAMap{
    protected BCAArrayList list = new BCAArrayList();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public boolean containsKey(String key){
        return (getOrDefault(key, null) != null);
    }

    public boolean containsValue(Object value){
        if (value == null) {
            throw new NullPointerException();
        }

        for(int i = 0; i < list.size(); i++){
            if (value.equals(((BCAEntry) list.get(i)).value)) {
                return true;
            }
        }
        return false;
    }

    public Object get(String key){
        return getOrDefault(key, null);
    }

    public Object getOrDefault(String key, Object defaultValue){
        if (key == null)
            throw new NullPointerException();

        for(int i = 0; i < list.size(); i++)
            if (key.equals(((BCAEntry) list.get(i)).key))
                return ((BCAEntry) list.get(i)).value;

        return defaultValue;
    }

    public Object put(String key, Object value){
        if (key == null)
            throw new NullPointerException();
        if (value == null)
            throw new NullPointerException();

        for (int i = 0; i < list.size(); i++){
            BCAEntry e = (BCAEntry) list.get(i);
            if (e.key.equals(key)){
                Object o = e.value;
                e.value = value;
                return o;
            }
        }

        //If the key was not already in the list, add it now
        list.add(new BCAEntry(key,value));
        return null;
    }

    public Object remove(String key){
        if (key == null)
            throw new NullPointerException();

        for(int i = 0; i < list.size(); i++)
            if (key.equals(((BCAEntry) list.get(i)).key))
                return ((BCAEntry) list.remove(i)).value;

        return null;
    }

    public void clear(){
        list.clear();
    }

    public BCAEntry[] toArray(){
        BCAEntry[] a = new BCAEntry[list.size()];

        for (int i = 0; i < list.size(); i++)
            a[i] = (BCAEntry) list.get(i);

        return a;
    }

    public String[] keys(){
        String[] key = new String[list.size()];

        for (int i = 0; i < list.size(); i++)
            key[i] = ((BCAEntry) list.get(i)).key;

        return key;
    }

    public Object[] values(){
        Object[] value = new Object[list.size()];

        for (int i = 0; i < list.size(); i++)
            value[i] = ((BCAEntry) list.get(i)).value;

        return value;
    }
}
