import interfaces.bca.util.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by David on 2/22/2016.
 */
public class WordCount {

    public static String cleanWord (String w){
        char[] array = w.toCharArray();
        StringBuffer buf = new StringBuffer(array.length);

        for (int i = 0; i < array.length; i++){
            if (Character.isAlphabetic(array[i]))
                buf.append(array[i]);
        }

        return buf.toString();
    }

    public static BCAArrayList parseFile() throws FileNotFoundException{
        BCAArrayList list = new BCAArrayList();
        Scanner in = new Scanner(new FileReader("TaleOfTwoCities.txt"));

        long start = System.currentTimeMillis();

        while (in.hasNext()){
            String w = in.next();
            w = cleanWord (w.toLowerCase());
            if (w.length() > 0)
                list.add(w);
        }
        in.close();
        return list;
    }

    public static void wordCount (BCAMap map, BCAArrayList list) throws FileNotFoundException{
        System.out.println("\n" + map.getClass() + ":");
        Scanner in = new Scanner(new FileReader("TaleOfTwoCities.txt"));

        long start = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++){
            String w = (String) list.get(i);
            int count = (Integer)map.getOrDefault(w, 0);
            map.put(w, count + 1);
        }

        long end = System.currentTimeMillis();

        System.out.printf("Total Seconds: %.3f\n", (end - start)/ 1000.0);
        BCAEntry[] array = map.toArray();
        Arrays.sort(array, new CompareBCAEntryByValue());

        for (int i = 1; i <= 3; i++){
            BCAEntry e = array[array.length - i];
            System.out.println(e.key + ": " + e.value);
        }
    }

    public static void main(String[] args) throws Exception{
        BCAArrayList list = parseFile();
        wordCount(new BCAMapByArrayList(), list);
        wordCount(new BCAMapBySortedArrayList(), list);
    }
}
