package tokens;

/**
 * Created by David on 2/4/2016.
 */
 
public class OperatorToken extends Token {
	public char operator = ' ';
	
	public OperatorToken (char op) {
		this.operator = op;
	}

	public int getPrecedence(){
		if (operator == '*' || operator == '/')
			return 2;
		else if (operator == '+' || operator == '-')
			return 1;
		else
			throw new RuntimeException("Unexpected Operator");
	}

	public String toString () {
		return "" + operator;
	}	
}
 