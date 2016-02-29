package Casting;

import interfaces.bca.util.BCAArrayList;
import tokens.NumberToken;
import tokens.OperatorToken;
import tokens.Token;

import java.util.Random;

/**
 * Created by David on 2/8/2016.
 */

public class Casting {

    public static void main(String[] args) {
        Random rand = new Random();
        BCAArrayList a1 = new BCAArrayList();

        for (int i = 0; i < 10; i++) {
            int r = rand.nextInt(2);

            if (r == 0)
                a1.add(new NumberToken(rand.nextInt(100)));
            else
                a1.add(new OperatorToken('+'));

        }

        for (int i = 0; i < 10; i++) {
            Token t = (Token) a1.get(i);
            System.out.println("\n" + t);

            if (t instanceof NumberToken) {
                NumberToken nt = (NumberToken) t;
                nt.value *= 2;
                System.out.println(t);
            }
        }

    }
}


