package exceptions.test;

import java.io.File;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
        try {
            File f = new File("Nothing");
            Scanner s = new Scanner(f);
            System.out.println("Hello world");
            s.close();
        } catch(Exception ex){
            System.out.println("The file was not found!");
        }
	}
}
