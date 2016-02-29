package interfaces.bca.util;

import java.util.Arrays;

/**
 * Created by David on 2/24/2016.
 */
public class BCAMapBySortedArrayList extends BCAMapByArrayList{

    @Override
    public Object getOrDefault (String key, Object defaultValue){
        if (key == null)
            throw new NullPointerException();

        int index = Arrays.binarySearch(list.array, 0, list.listSize, key);
        if (index >= 0)
            return ((BCAEntry) list.array[index]).value;

        return defaultValue;
    }

    @Override
    public Object put(String key, Object value){
        if (key == null)
            throw new NullPointerException();
        if (value == null)
            throw new NullPointerException();

        int index = Arrays.binarySearch(list.array, 0, list.listSize, key);
        if (index >= 0){
            Object o = ((BCAEntry) list.array[index]).value;
            ((BCAEntry) list.array[index]).value = value;
            return o;
        }

        //If the key was not already in the list, add it now
        index = (index + 1) * -1;
        list.add(index, new BCAEntry(key, value));
        return null;
    }
}
