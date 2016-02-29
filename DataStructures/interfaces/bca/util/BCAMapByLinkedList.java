package interfaces.bca.util;

/**
 * Created by David on 2/18/2016.
 */
public class BCAMapByLinkedList implements BCAMap{
    private BCALinkedList list = new BCALinkedList();

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
        if (value == null)
            throw new NullPointerException();

        Node n = list.head;

        while (n != null){
            if (((BCAEntry) n.data).value.equals(value))
                return true;
            n = n.next;
        }
        return false;
    }

    public Object get(String key){
        return getOrDefault(key, null);
    }

    public Object getOrDefault(String key, Object defaultValue){
        if (key == null)
            throw new NullPointerException();

        Node n = list.head;

        while (n != null){
            if (((BCAEntry) n.data).key.equals(key))
                return ((BCAEntry) n.data).value;
            n = n.next;
        }

        return defaultValue;
    }

    public Object put(String key, Object value){
        if (key == null)
            throw new NullPointerException();
        if (value == null)
            throw new NullPointerException();

        Node n = list.head;

        while (n != null){
            if (((BCAEntry) n.data).key.equals(key)) {
                Object returned = ((BCAEntry) n.data).value;
                ((BCAEntry) n.data).value = value;
                return returned;
            }
            n = n.next;
        }

        //if there is no such BCAEntry
        BCAEntry e = new BCAEntry(key, value);
        list.add(list.size(), e);
        return null;
    }

    public Object remove(String key){
        if (key == null)
            throw new NullPointerException();

        Node n = list.head;

        while (n.next != null){
            if (((BCAEntry) n.next.data).key.equals(key)) {
                Object returned = ((BCAEntry) n.next.data).value;
                n.next = n.next.next;
                list.listSize--;
                return returned;
            }
                n = n.next;
        }

        return null;
    }

    public void clear(){
        list.clear();
    }

    public BCAEntry[] toArray(){
        BCAEntry[] a = new BCAEntry[list.size()];

        Node n = list.head;
        int i = 0;

        while (n != null){
            a[i] = (BCAEntry) n.data;

            n = n.next;
            i++;
        }

        return a;
    }

    public String[] keys(){
        String[] key = new String[list.size()];

        Node n = list.head;
        int i = 0;

        while (n != null){
            key[i] = ((BCAEntry) n.data).key;

            n = n.next;
            i++;
        }

        return key;
    }

    public Object[] values(){
        Object[] value = new Object[list.size()];

        Node n = list.head;
        int i = 0;

        while (n != null){
            value[i] = ((BCAEntry) n.data).value;

            n = n.next;
            i++;
        }

        return value;
    }
}
