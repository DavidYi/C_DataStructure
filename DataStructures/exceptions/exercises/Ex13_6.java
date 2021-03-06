package exceptions.exercises;

import java.util.Scanner;
/**
 * (NumberFormatException) Listing 9.2 implements the hexToDecimal(String hexString) method,
 * which converts a hex string into a decimal number. Implement the hexToDecimal method to
 * throw a NumberFormatException if the string is not a hex String.
 * Created by David on 1/14/2016.
 */

public class Ex13_6 {
  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter a string
    System.out.print("Enter a hex number: ");
    String hex = input.nextLine();

    System.out.println("The decimal value for hex number "
      + hex + " is " + hexToDecimal(hex.toUpperCase()));
  }

  public static int hexToDecimal(String hex) {

      int decimalValue = 0;
      for (int i = 0; i < hex.length(); i++) {
          char hexChar = hex.charAt(i);
          decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
      }
    
    return decimalValue;
  }

  public static int hexCharToDecimal(char ch) {
      if (ch >= 'A' && ch <= 'F')
          return 10 + ch - 'A';
      else if (ch >= '0' && ch <= '9')// ch is '0', '1', ..., or '9'
          return ch - '0';
      else
          throw new NumberFormatException("The string is not a hex string");
  }
}
