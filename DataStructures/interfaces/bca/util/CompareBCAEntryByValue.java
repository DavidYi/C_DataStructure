package interfaces.bca.util;

import java.util.Comparator;

/**
 * Created by David on 2/24/2016.
 */
public class CompareBCAEntryByValue implements Comparator<BCAEntry>{

    @Override
    public int compare(BCAEntry o1, BCAEntry o2){
        return ((Comparable)o1.value).compareTo(o2.value);
    }
}
