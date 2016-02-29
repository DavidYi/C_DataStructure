package exceptions.exercises;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

/**
 * (ArrayIndexOutofBoundsException) Write a program that meets the following requirements:
 * * create an array with 100 randomly chosen integers
 * * Prompt the user to enter the index of the array, then display the corresponding
 *   element value I fhte specified index is out of bound, display message Out of Bounds.
 * Created by David on 1/14/2016.
 */
public class Ex13_3 {
    public static void main(String[] args){
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt();
        }

        System.out.print("Enter an index of the array.");
        int index = in.nextInt();

        try{
            System.out.println(array[index]);
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Out of Bounds.");
        }


    }
}
