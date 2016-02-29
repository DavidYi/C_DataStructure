package tokens.infixToPostfixConverter;

import interfaces.bca.util.BCAStack;
import tokens.*;

import java.util.Scanner;

/**
 * Created by David on 2/10/2016.
 */
public class InfixConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BCAStack opstack = new BCAStack();
        String output = "";

        System.out.println("Enter a math expression to be converted");
        String line = input.nextLine();
        Tokenizer tk = new Tokenizer(line);
        Token t = tk.nextToken();
        Token temp;

        while (t != null) {
            if (t instanceof NumberToken)
                output += ((NumberToken) t).value + " ";
            else if (t instanceof LeftParenthesisToken){
                opstack.push(t);
            } else if (t instanceof RightParenthesisToken){
                temp = (Token) opstack.pop();
                while (!(temp instanceof LeftParenthesisToken)) {
                    if (temp instanceof OperatorToken)
                        output += temp + " ";

                    temp = (Token) opstack.pop();
                }
            } else if(t instanceof OperatorToken) {
                int precedence = ((OperatorToken) t).getPrecedence();
                temp = opstack.isEmpty() ? null : (Token) opstack.peek();//if empty then equals null else opstack.peek

                while (temp instanceof OperatorToken && precedence <= ((OperatorToken) temp).getPrecedence()) {
                    output += opstack.pop() + " ";

                    temp = opstack.isEmpty() ? null : (Token) opstack.peek();
                }
                opstack.push(t);
            }

            t = tk.nextToken();
        }

        while (!opstack.isEmpty())
            output += opstack.pop() + " ";

        System.out.println(output);
    }
}
