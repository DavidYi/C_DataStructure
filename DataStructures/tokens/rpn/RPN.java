package tokens.rpn;

import interfaces.bca.util.BCAStack;
import tokens.NumberToken;
import tokens.OperatorToken;
import tokens.Token;
import tokens.Tokenizer;

import java.util.Scanner;

/**
 * Created by David on 2/5/2016.
 */
public class RPN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a math expression");
        String line = input.nextLine();
        Tokenizer tk = new Tokenizer(line);
        Token t = tk.nextToken();

        BCAStack stack = new BCAStack();
        NumberToken a, b;
        String result = null;

        while (t != null) {
            if (t instanceof NumberToken)
                stack.push(t);

            else if (t instanceof OperatorToken) {
                if (stack.size() < 2)
                    result = "Stack Empty Exception";
                else{
                    b = (NumberToken) stack.pop();
                    a = (NumberToken) stack.pop();

                    if (((OperatorToken) t).operator == '+')
                        stack.push(new NumberToken(a.value + b.value));
                    else if (((OperatorToken) t).operator == '-')
                        stack.push(new NumberToken(a.value - b.value));
                    else if (((OperatorToken) t).operator == '*')
                        stack.push(new NumberToken(a.value * b.value));
                    else if (((OperatorToken) t).operator == '/')
                        stack.push(new NumberToken(a.value / b.value));
                }

            }
            if (result == null) {
                try {
                    t = tk.nextToken();
                } catch (RuntimeException ex) {
                    result = ex.getMessage();
                }
            }
            if (result != null)
                break;
        }

        if (result == null) {
            result = Double.toString(((NumberToken) stack.pop()).value);
            if (!stack.isEmpty())
                result = "Error: Not enough operators";
        }
        System.out.println("Case: " + line + "\nResult: " + result);

    }

}
