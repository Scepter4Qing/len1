package sc;

public class Num extends AST {
	Token token;
	String value;
	
	public Num(Token t) {
		token = t;
		value = token.value;
	}
	
	public int visit() {
		//System.out.println(Integer.parseInt(value));
		return Integer.parseInt(value); 
	}
}
