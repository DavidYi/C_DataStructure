package wrapperClasses;

/**
 * Created by David on 2/1/2016.
 */
public class Autobox {//
    public static Integer add (Integer n1, Integer n2){
        return n1 + n2;//returns an object
    }

    public static void increment (Integer num){
        num++;
        System.out.println("num: " + num);
        //does not change the
    }

    public static void main(String[] args){
        int a = 15;
        int b = 23;

        int c = add(a, b);//convert primitive to object since a and b are primitives
        //converts the object returned back into an int
        System.out.println("c = " + c);

        increment(c);
        System.out.println(c);
    }
}
