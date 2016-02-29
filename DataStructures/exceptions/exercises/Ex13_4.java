package exceptions.exercises;

/**
 * (IllegalArgumentException) Modify the Loan class in Listing 10.2 to throw
 * IllegalArgumentException if the loan amount, interest rate, or number of
 * years is less than or equal to zero.
 * Created by David on 1/14/2016.
 */
public class Ex13_4 {
    public static void main(String[] args){
        Loan loan = new Loan(-1, 5, 3);
        Loan loan1 = new Loan(1, -5, 3);
        Loan loan2 = new Loan(1, 5, -3);
    }
}
