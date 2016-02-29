package tokens;

/**
 * Created by David on 2/4/2016.
 */

public class NumberToken extends Token {
	public double value = -1;
	
	public NumberToken (double value) {
		this.value = value;
	}
	public String toString () {
		return "" + value;
	}
}
 