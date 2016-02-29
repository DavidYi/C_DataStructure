package tokens;

/**
 * Created by David on 2/4/2016.
 */

public class Tokenizer {
	private char[] tokenStr;
	int pos = 0;
	
	public Tokenizer (String str) {
		tokenStr = str.toCharArray();
	}
	
	private void skipSpaces() {
		while ((pos < tokenStr.length) && Character.isSpaceChar(tokenStr[pos]))
			pos++;
	}
	
	private NumberToken readNumberToken() {
		int val = 0;		
		while ((pos < tokenStr.length) && Character.isDigit(tokenStr[pos])) {
			val = val * 10 + tokenStr[pos] - '0';
			pos++;
		}
		return new NumberToken (val);
	}

	private OperatorToken readOperatorToken() {
		Character op = tokenStr[pos];
		pos++;
		
		if ((op != '+') && (op != '-') && (op != '/') && (op != '*'))
            throw new RuntimeException ("Found " + op + " expecting an operator at position " + pos + ".");

		return new OperatorToken (op);
	}

	
	public Token nextToken() {
		skipSpaces();
		if (pos >= tokenStr.length)
			return null;
		else if (tokenStr[pos] == '('){
			pos++;
			return new LeftParenthesisToken();
		} else if (tokenStr[pos] == ')'){
			pos++;
			return new RightParenthesisToken();
		} else if (Character.isDigit(tokenStr[pos]))
            return readNumberToken();
		else
            return readOperatorToken();

	}
}
