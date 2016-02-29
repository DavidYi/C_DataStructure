package exceptions.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (NumberFormatExcetion) Write a program that prompts the user to read two
 * integers and displays their sum. Your program should prompt the user to read the
 * number again if the input is incorrect.
 * Created by David on 1/14/2016.
 */
public class Ex13_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean notCorrect = true;
        int a, b;

        System.out.println("Input two integers");

        while (notCorrect)
        try {
            a = in.nextInt();
            b = in.nextInt();
            System.out.println("The sum of the two numbers is " + (a + b));
            notCorrect = false;
        } catch(InputMismatchException ex){
            in.next();
            System.out.println("Input two numbers again.");
        }
    }
}
