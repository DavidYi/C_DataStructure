package tokens;

import java.util.Scanner;

/**
 * Created by David on 2/4/2016.
 */

public class TokenizerDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a string of number and operator tokens!");
		String line = input.nextLine();
		Tokenizer tk = new Tokenizer(line);
		Token t = tk.nextToken();
		
		while (t!=null) {
			System.out.println(t);
			t = tk.nextToken();
		}
	}

}
